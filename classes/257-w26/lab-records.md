---
layout: page
title: Records Lab
permalink: /classes/257-w26/records-lab
---

## Goal
Learn how to connect a Flask Python app with a Postgres database using the `records` module.

## Setup

1. If you haven't already, you should accept the assignment through Moodle for the [ID3: individual back-end deliverable](project-3-ind) since you'll be working there today.

You should edit most of these files locally and push them to your individual repository before then connecting to `stearns` (through `fern`) and testing them out.
Remember that if you're on `stearns` and want to push, you'll probably need to use a [GitHub Personal Access Token](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token) to do so.
It'll generally be easier to just create files locally and not need to push from `stearns`.

## psql_config.py
The module we'll be using will allow for connection between your database and your Flask app.
However, for it to make that connection, it needs to know the relevant information about your database, including your database password.
In general, **you should never push passwords to a git repository**, so we're going to first verify that you can't accidentally push this new file with that information to the remote repository.

1. Open the file `.gitignore` that should be in your repository
2. Verify that the line `psql_config.py` is in there (this tells git to not add this file even when you do `git add *`, which you should generally avoid). If you've been having trouble with `__pycache__` files getting into your team repository, you can always add that to your `.gitignore`! (If you do, be sure to add/commit/push)


## datasource.py
I've provided a file named `datasource.py` in your repository.
This file is responsible for connecting your database to your Flask app.

1. In that file, there are two import statements, the first imports the module we'll be using and second is the configuration file that you will make on `stearns`:
    ```python
    import records
    import ProductionCode.psql_config as config
    ```

2. This file is structured in an object-oriented style, so there is a class called `DataSource`:

    ```python
    class DataSource:
        
        def __init__(self):
            pass
    ```

3. The responsibility of this class is to connect to your database and `records` makes that pretty easy with the following code (already provided):
    ```python
        connect = f"postgresql://{config.user}:{config.password}@localhost:5432/{config.database}"
        self.db = records.Database(connect)
    ```

4. Your constructor creates a connection string using your log in information from `psql_config` and sets up the connection to listen locally at port 5432 (the default PostgreSQL port). It then uses `records` to connect to the database and saves the resulting `Database` object as an instance variable `self.db`.

5. You'll need to write a method to execute one of your queries on your database and print the resulting information. To execute a query on the database, you send your exact query to the `query` method:
    ```python
    def get_example(self):
        result = self.db.query("SELECT * FROM test WHERE second_col ='data_2_2' ")
        print(result[0])
    ```
    **Edit this example to send a query to either your ID3 data table or the `pokemon` data table from Monday.** Then add, commit, and push your file.


## On `stearns`
Now you're ready to test out your code with your database. 

1. Connect to stearns (through [`fern`](https://fern.mathcs.carleton.edu/jupyter/)) and clone your individual repository. Make sure that your `.gitignore` file is there so that you don't accidentally push your database information.

2. Create the `psql_config.py` file

3. Add the following three lines with your individual database information:
    ```python
    DATABASE = 'YOUR_DATABASE_NAME'
    USER = 'YOUR_CARLETON_USERNAME'
    PASSWORD = 'YOUR_DATABASE_PASSWORD'
    ```
    That should be your Carleton username for the first two and the password that I provided to you for the last one.

4. Test out your method by calling it in `datasource.py`'s main to see what you get. If you need to make changes, remember to make them locally and the push to test.

## `app.py`

6. **Remember to go back to editing locally at this point.** You likely noticed that the result is of this type `Record` which isn't quite what your Flask app is used to getting. You can export records in lots of formats, but let's test out `csv` since you are used to that already. Update your code to use `export('csv')` like so:
    ```python
    print(result[0].export('csv'))
    ```

7. You ultimately want to be able to return data from your `Datasource` methods to your Flask app, so switch to returning and then open `app.py` and test out calling your method. (Remember to add, commit, and push and the pull down your changes on `stearns` to test.)

4. Try running your `app.py` and see if it is able to connect to your database and print the results to the terminal!

5. If that works, great job, you're almost done with your [individual deliverable](project-3-ind)! (You might need to do some additional style fixes still.)

Once you finish with the individual deliverable, start thinking about the changes to your team project that will be needed to connect your Flask app to your new database. 