---
layout: page
title: Patching Guide
permalink: /classes/257-w26/guide-patching
---

## Overview
This page is a guide on how to use the `@patch` functionality to enable your tests to run on GitHub after you have added a database.

## Setup

Here is my example `DataSource`:
```python
import records
import ProductionCode.psql_config as config

class DataSource:
    def __init__(self):
        self.database_url = f"postgresql://{config.USER}:{config.PASSWORD}@{config.HOST}:5432/{config.DATABASE}"
        self.database = records.Database(self.database_url)

    def get_pokemon_by_name(self, name):
        query = "SELECT * FROM pokemon WHERE name = :name"
        rows = self.database.query(query, name=name)
        
        if rows:
            return rows[0].export('csv')
        return None

    def get_pokemon_by_name_dictionary(self, name):
        #an example if you just want to return the Record object dictionary
        query = "SELECT * FROM pokemon WHERE name = :name"
        rows = self.database.query(query, name=name)
        return rows
```

## Testing `get_pokemon_by_name`
My method doesn't do a whole lot, but if I wanted to test the **Python** code (not the query), here is how.

The `unittest.mock.patch` tool allows you to swap out the real `records.Database` with a `Mock` object. This lets you "fake" the database response and verify that your logic — like calling `.export('csv')` — is working correctly without needing to connect to the real server.

### The Strategy: Mocking the Chain
In my `get_pokemon_by_name` method, there is a chain of calls that I need to simulate:

* `records.Database()` creates the database object.
* `database.query()` returns a list-like object of rows.
* `rows[0]` is a row object.
* `rows[0].export('csv')` returns the final string.

### The Test Implementation
Assuming my code is in a file named `datasource.py` in `ProductionCode`, here is how I write the test:

```python 
import unittest
from unittest.mock import patch, MagicMock
from ProductionCode.datasource import DataSource

class TestDataSource(unittest.TestCase):

    @patch('ProductionCode.datasource.records.Database')
    def test_get_pokemon_by_name_returns_csv(self, mock_db_class):
        # The combo of @patch and the parameter mock_db_class automatically
        # creates a MagicMock of records.Database and saves it to mock_db_class

        # 1. Setup the Mocks
        # mock_db_class is the already mocked 'records.Database' class (really its constructor)
        # mock_db_class.return_value is a new mock object, because mock object constructors make
        #    more mock objects
        # mock_db_instance is the object that will be returned when 'records.Database()' is called
        mock_db_instance = mock_db_class.return_value
        
        # Create a mock for the individual row, MagicMock makes an object with all the normal built-in methods
        # and lets you add additional things to it
        mock_row = MagicMock()

        # When export is called on the mock_row, regardless of parameter, this string is returned
        # this works because all functions/methods are actually objects in Python
        mock_row.export.return_value = "1,Pikachu,Electric"
        
        # Mock the .query() method to return a list containing our mock_row
        mock_db_instance.query.return_value = [mock_row]

        # 2. Initialize a fresh DataSource for this test
        ds = DataSource()

        # Run the code we are testing
        result = ds.get_pokemon_by_name("Pikachu")

        # 3. Assertions
        # Verify the database was queried with the correct parameters
        mock_db_instance.query.assert_called_once_with(
            "SELECT * FROM pokemon WHERE name = :name", 
            name="Pikachu"
        )
        
        # Verify the row's export method was called
        mock_row.export.assert_called_with('csv')
        
        # Verify the final output
        self.assertEqual(result, "1,Pikachu,Electric")

    @patch('ProductionCode.datasource.records.Database')
    def test_get_pokemon_by_name_dictionary(self, mock_db_class):
        # Setup the mock database instance
        mock_db_instance = mock_db_class.return_value
        
        # Mock the query result (A Record is basically a dictionary, so we can just make a dictionary)
        mock_db_instance.query.return_value = {'number': 1, 'name': 'Bulbasaur', 'type_1': 'Fake'}
        
        # Initialize a fresh DataSource for this test
        ds = DataSource()
        
        # Act
        result = ds.get_pokemon_by_name_dictionary("Bulbasaur")
        
        # Assert
        self.assertEqual(result['number'], 1)
        self.assertEqual(result['name'], 'Bulbasaur')
        self.assertEqual(result['type_1'], 'Fake')
        # Verify the query was called with the correct parameter
        mock_db_instance.query.assert_called_once_with(
            "SELECT * FROM pokemon WHERE name = :name", 
            name="Bulbasaur"
        )

    @patch('ProductionCode.datasource.records.Database')
    def test_get_pokemon_by_name_not_found(self, mock_db_class):
        # Setup query to return an empty list
        mock_db_class.return_value.query.return_value = []
        
        ds = DataSource()
        result = ds.get_pokemon_by_name("MissingNo")
        
        self.assertIsNone(result)

            query = "SELECT * FROM pokemon WHERE name = :name"
        rows = self.database.query(query, name=name)

```

## Key Takeaways
* **Patch where the object is used:** Notice I patched `ProductionCode.datasource.records.Database`. You want to intercept the import inside your module, not the records library itself.
* **Use `.return_value` frequently**: Since `DataSource` calls `records.Database()`, the patch gives us the class. To control the instance created inside `__init__`, we use `mock_db_class.return_value`. The line `mock_db_instance = mock_db_class.return_value` is just giving us a more convenient name for the object returned by calling `records.Database(self.database_url)`
* **`MagicMock` for Rows**: Because the `records` library returns row objects with their own methods (like `.export()`), we create a `MagicMock()` for the row and define its behavior separately.
* **Pretend it's a dictionary**: If you aren't using `export` or any other `Record` object methods, you can just use a Python dictionary for your tests
* You can adapt the above to work for your project without needing to change very much.

## Testing Flask routes
I have the following Flask file, using my `DataSource` from above:

```python
from flask import Flask, request, render_template

from ProductionCode.datasource import DataSource

app = Flask(__name__)
ds = DataSource()

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/pokemon/<name>')
def display(poke_name):
    result = ds.get_pokemon_by_name(poke_name)
    return result


if __name__ == '__main__':
    app.run()
```

### The Test Implementation
In my test file, I will patch the `ds` object specifically inside the `app` module. First, I need to avoid the `DataSource` trying to contact the database:

```python
import unittest
from unittest.mock import patch

# Patch out the database right away so constructor isn't called
db_patcher = patch('ProductionCode.datasource.records.Database')
mock_db_class = db_patcher.start()

# Safely import app without worrying about DataSource contacting database
from app import app
```

Then I can test with the following:
```python
class TestFlaskApp(unittest.TestCase):

    def setUp(self):
        # Creates a test client so we can make requests without running a server
        self.client = app.test_client()
        self.client.testing = True

    @patch('app.ds.get_pokemon_by_name')
    def test_display_route_success(self, mock_get_pokemon):
        # 1. Setup the Mock response
        # We simulate what the Datasource would return (the CSV string)

        mock_get_pokemon.return_value = "25,Pikachu,Electric"

        # 2. Simulate a GET request to the route
        response = self.client.get('/pokemon/Pikachu/')

        # 3. Assertions
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.data.decode('utf-8'), "25,Pikachu,Electric")
        
        # Verify the mock was called with the right argument from the URL
        mock_get_pokemon.assert_called_once_with("Pikachu")

    @patch('app.ds.get_pokemon_by_name')
    def test_display_route_not_found(self, mock_get_pokemon):
        # Setup the mock to return None (simulating a missing database record)
        mock_get_pokemon.return_value = None

        response = self.client.get('/pokemon/MissingNo/')

        self.assertEqual(response.status_code, 200)
        self.assertIn("No pokemon!", response.data.decode('utf-8'))
```

### Key Concepts for Flask Patching
* **Preventing DataSource constructor**: In my current setup, I have a global `DataSource` and `DataSource` creates a connection within its constructor so I need to mock that class before importing `app`. I could avoid that with refactoring to not immediately connect to the database in the constructor or with a "factory" design pattern, which we'll discuss later in the term.
* `app.test_client()`: This acts as a "browser in a box." It lets you trigger routes and inspect the response (status codes, headers, and body) without actually starting a web server on a port.
* **Patching the Instance**: In the previous section, I patched the class (`records.Database`). Here, I patched the method of an already existing instance (`app.ds.get_pokemon_by_name`). This is often easier because you aren't messing with the constructor logic and it is ideal to patch as close to the function that you are testing as possible.
* **Response Decoding**: Flask `response.data` returns bytes. To compare it to a string, you’ll usually need to call `.decode('utf-8')`.

## For More
There is a lot more that you can do with Mock and patch, and the best place to learn more is the Python documentation:
* [patch start and stop](https://docs.python.org/3/library/unittest.mock.html#patch-methods-start-and-stop) - if you want to get rid of repetitive patching of the database
* [Quick Guide](https://docs.python.org/3/library/unittest.mock.html#quick-guide) - for more how how Mock and MagicMock actually work