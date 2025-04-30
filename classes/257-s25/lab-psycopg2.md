---
layout: page
title: Psycopg2 Lab
permalink: /classes/257-s25/psycopg2
---

## Goal
Learn how to connect a Flask Python app with a Postgres database using the `psycopg2` module.

## Setup

You should first complete this lab in your individual repository to complete your submission for the [individual back-end deliverable](project-3-ind). 
You'll then want to coordinate with your team since you'll need to apply what you learn to your team project.

You should edit most of these files locally and push them to your individual repository before then connecting to stearns and testing them out.
Remember that if you're on stearns and want to push, you'll probably need to use a [GitHub Personal Access Token](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token) to do so.
It'll generally be easier to just create files locally and not need to push from stearns.

## psql_config.py
The module we'll be using will allow for connection between your database and your Flask app.
However, for it to make that connection, it needs to know the relevant information about your database, including your database password.
In general, you should never push passwords to a git repository, so we're going to first verify that you can't accidentally push this new file with that information to the remote repository.

1. Open the file `.gitignore` that should be in your repository
2. Verify that the line `psql_config.py` is in there (this tells git to not add this file even when you do `git add *`, which you should generally avoid). If you've been having trouble with `__pycache__` files getting into your team repository, you can always add that to your `.gitignore`! (If you do, be sure to add/commit/push)


## datasource.py
I've provided a file named `datasource.py` in your repository.
This file is responsible for connecting your database to your Flask app.

1. In that file, there are two import statements, the first imports the module we'll be using and second is the configuration file that you will make on stearns:
    ```python
    import psycopg2
    import ProductionCode.psql_config as config
    ```

2. This file is structured in an object-oriented style, so there is a class called `DataSource`:

    ```python
    class DataSource:
        
        def __init__(self):
            pass

        def connect(self):
            pass
    ```

3. A common thing that you will need to do is connect to your database, hence why there is a `connect` method. The `psycopg2` module makes that pretty easy with the following in the `connect` method (already provided):
    ```python
    try:
        connection = psycopg2.connect(database=config.DATABASE, user=config.USER, password=config.PASSWORD, host="localhost")
    except Exception as e:
        print("Connection error: ", e)
        exit()
    return connection
    ```

4. Your constructor calls the `connect` method and saves the resulting connection object as an instance variable that you'll use next, called `self.connection`

5. You'll need to write a method to execute one of your queries on your database and print the resulting information. To execute a query on the database, you need to use the `cursor()` method of the connection. Here is an example adapted from the [psycopg2 documentation](https://www.psycopg.org/docs/install.html#quick-install)
    ```python
    def getExample(self):

        #Open a cursor to perform database operations
        cursor = self.connection.cursor()

        #Execute a query
        cursor.execute("SELECT * FROM my_data")

        #Retrieve query results
        records = cursor.fetchall()

        print(records)
    ```

6. You might want to be able to use arguments in your queries, which you can do with a particular syntax ([more details are in the psycopg2 documentation](https://www.psycopg.org/docs/usage.html#passing-parameters-to-sql-queries)). Here is an example method for your reference (that uses some earthquake data):
    ```python
    def getQuakesAboveMagnitude(self, magnitude):
        try:
            #set up a cursor
            cursor = self.connection.cursor()

            #make the query using %s as a placeholder for the variable
            query = "SELECT * FROM earthquakes WHERE mag>%s ORDER BY mag DESC"

            #executing the query and saying that the magnitude variable 
            # should be placed where %s was, the trailing comma is important!
            cursor.execute(query, (magnitude,))
            print(cursor.fetchall())

        except Exception as e:
            print ("Something went wrong when executing the query: ", e)
            return None
    ```

7. For testing purposes, open `app.py`. There is a `DataSource` object already created.Call one or more of your methods at the bottom of your `app.py` file.

8. Add your `datasource.py` and `app.py` file changes, commit, and push.


## On stearns
Now you're ready to test out your code with your database. 

1. Connect to stearns and pull your individual repository to get the changes that you made. Make sure that your `.gitignore` file is there so that you don't accidentally push your database information.

2. Create the `psqlConfig.py` file

3. Add the following three lines with your individual database information:
    ```python
    DATABASE = 'YOUR_DATABASE_NAME'
    USER = 'YOUR_CARLETON_USERNAME'
    PASSWORD = 'YOUR_DATABASE_PASSWORD'
    ```
    That should be your Carleton username for the first two and the password that I provided to you for the last one.

4. Try running your `app.py` and see if it is able to connect to your database!

5. If that works, great job, you're almost done with your [individual deliverable](project-3-ind)! (You might need to do some additional style fixes still.)

Once you finish with the individual deliverable, start thinking about the changes to your team project that will be needed to connect your Flask app to your new database. 