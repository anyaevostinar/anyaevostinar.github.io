---
layout: page
title: Starting with Flask
permalink: /classes/257-w26/flask-intro
---

## Goal
Explore different functionalities of Flask with a simple dataset.

## Table of Contents
* [Getting Started](#getting-started)
* [Outputting Data](#outputting-data)
* [Handling User Errors](#handling-user-errors-and-your-own)
* [Testing](#testing)
* [Separating the API](#separating-api)
* [Applying to Your Project](#applying-to-your-project)

## Setup
Make sure that you have [installed Flask in your virtual environment](venv-guide) and activate your virtual environment:
```bash
source ~/.venvs/cs257_venv/bin/activate
```

## Getting Started
As you know from the reading, Flask is a web framework that lets you build dynamic a dynamic website using Python.
You're first going to build a very simple app that grabs data from a file and displays it on dynamically-built (and ugly) web pages.

1. Clone down the Flask Lab classroom repository (linked on Moodle) and `cd` into that directory. This repository starts with the Flask boilerplate and loads in the Pokemon data for you.
4. Note that there is already a `homepage()` function that is called when a user first goes to your website using `@app.route('/')` (feel free to make the string returned more exciting):
    ```python
    @app.route('/')
    def homepage():
        return "hello, this is the homepage"
    ```

6. Open up the Terminal in VSCode and run your python script as you normally would:
    ```bash
    python flask_lab_app.py
    ```

    You should see something like:
    ```bash
    * Serving Flask app 'app' (lazy loading)
    * Environment: production
        WARNING: This is a development server. Do not use it in a production deployment.
        Use a production WSGI server instead.
    * Debug mode: off
    * Running on http://127.0.0.1:5100/ (Press CTRL+C to quit)
    ```

    And if you copy that URL and put it into your web browser of choice, you should see your message. Congrats, you made a website with Flask!


## Outputting Data
The main goal of using Flask is that we are able to display data from your dataset onto your website.
Eventually, we'll put your data into a database, but for now, we'll stick with loading it in from a file so we can focus on how Flask itself works.

1. I've provided you with a dataset about Pokemon already in the repository, called `Pokemon.csv`, along with a `load_data` function that handles reading that data into a list of lists

3. Now there are a lot of choices for how to display this data. We'll start by thinking of your command line arguments as being entered in the URL. If you wanted to let the user get a particular cell of your dataset, you could make the decorator for the function include the desired row and column as variables:
    ```python
    @app.route('/<int:row>/<int:column>/')
    ```

    The `<>` indicate that the string inside them should be a variable that is passed to your associated function, and in this case we are also converting `row` and `column` to `int`s immediately.  The function has to take those exact arguments, like so:
    ```python
    def get_cell(row, column):
    ```

    **Use those two snippets to complete the `get_cell` function** so that you can go to the page `your_url/0/1` and see a page with `Name` on it.

4. Now try letting the user get an entire row of the dataset, perhaps by specifying the Pokemon name that they want. Remember that you can use additional `/` in your endpoints to specify different commands, such as `/name/<pokemon_name>`.

## Handling user errors (and your own)

You may have noticed as you were doing the previous pieces that it would be nice if you could achieve something similar to a usage statement.
Fun fact, you can!

1. Add a function with the decorator `@app.errorhandler(404)` to catch page not found errors. The function will need to take an argument (which is the error):
    ```python

    @app.errorhandler(404)
    def page_not_found(e):
        return "sorry, wrong format, do this instead...."
    ```

    Make sure that the function lets the user know what format they should use for the URL to get the information they want, perhaps with some examples. 

2. You can add a function for internal server errors as well, i.e. when you have a bug in your Python code:
    ```python
    @app.errorhandler(500)
    def python_bug(e):
        return "Eek, a Caterpie!"
    ```

## Testing
You can test the Flask-specific functions the normal way by just calling them directly and checking that they return the correct thing.
You can also test that your Flask app returns the correct thing based on a URL with the following:
```python
from flask_lab_app import *
import unittest

class TestSOMETHING(unittest.TestCase):
    def test_route(self):
        #sets up a special test app
        self.app = app.test_client() 
        #test app returns TestResponse object
        response = self.app.get('/', follow_redirects=True) 
        #TestResponse has webpage in .data
        self.assertEqual(b'hello, this is the homepage', response.data) 
```
      
The `b` stands for byte and its because `response.data` is a 'bytes-like object'.
Once you make more complicated pages, you can use `assertIn` to check for the specific data that you care about without worrying about the HTML tags.

Open the `flask_tests.py` file and **write tests for your existing functions and routes** (Yes, we're breaking TDD since we already have the production code written. It'd be a good idea to purposefully break your production code to make sure your tests fail first.) You can run your tests like so:
```bash
python -m unittest flask_tests.py
```

## Separating API
In the future, you will want your websites to display nice HTML by default, however we don't want your API to disappear either! The best way to separate your API from your (eventual) fancy webpage is with flask's `Blueprint` class.

1. Add `Blueprint` to the import list for `flask` at the top of your `flask_lab_app.py` file.
2. Create an `api` object around the same place you make your `app` object:
    ```python
    api = Blueprint('api', __name__)
    ```

3. The goal of the API blueprint is to preface all your API URLs appropriately so that the API is still accessible but clearly not what a user would normally navigate to. You do that when you link the Blueprint to your app just before running (so do this down in the `if __name__ == '__main__'` conditional):
```python
app.register_blueprint(api, url_prefix='/api')
```

4. To designate that a route should be used as an API endpoint, you just add it to the `api` instead of `app`, like so:
```python
@api.route('/<int:row>/<int:column>/')
```
    Try out changing your `get_cell` to be an API endpoint and then go to `your_url/api/0/1` to check that it's working.

## Applying to your project
You're now all set to turn your command-line interface project into a Flask app.
It's good to separate the underlying logic of your program from the Flask-specific portion so that it will be easier to refactor the logic portion once we add a database.
Therefore, **you should have all the Flask functionality in a separate file that imports the file with core functions**, which hopefully will be easy to do if you kept the command line separate already.
You should now start on your [individual deliverable](project-2-ind) for this week, which is making a Flask app with a homepage and single data route.