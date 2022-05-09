---
layout: page
title: Psycopg2 Lab
permalink: /classes/257-s22/psycopg2
---

## Goal
Learn how to connect a Flask Python app with a Postgres database using the `psycopg2` module.

## Setup

You should first complete this lab in your individual repository to complete your submission for the [individual back-end deliverable](project-4-ind). 
You'll then want to coordinate with your team since you'll need to apply what you learn to your team project.

You should create most of these files locally and push them to your individual repository before then connecting to perlman and testing them out.
Remember that if you're on perlman and want to push, you'll probably need to use a [GitHub Personal Access Token](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token) to do so.
It'll generally be easier to just create files locally and not need to push from perlman.

## psqlConfig.py
The module we'll be using will allow for connection between your database and your Flask app.
However, for it to make that connection, it needs to know the relevant information about your database, including your database password.
In general, you should never push passwords to a git repository, so we're going to first ensure that you don't accidentally push this new file with that information to the remote repository.

1. Create a file `.gitignore` (or open the existing one if there is already one in your repo)
2. Add the line `psqlConfig.py` (this tells git to not add this file even when you do `git add *`)
3. You won't make the `psqlConfig.py` yet, since you'll need to just make it directly on perlman. Add your changes to `.gitignore` and commit and push to your individual repository.



## datasource.py
You should create a file named `datasource.py` in your individual deliverables repository.
This file will be responsible for connecting your database to your Flask app.

1. In that file, you should first import the module we'll be using and the configuration file that you will make on perlman:
    ```python
    import psycopg2
    import psqlConfig as config
    ```

2. It's best to structure this file in an object-oriented style, so you should first make a class called `DataSource`:

    ```python
    class DataSource:
        
        def __init__(self):
            pass

        def connect(self):
            pass
    ```

3. A common thing that you will need to do is connect to your database, hence why there is a `connect` method. The `psycopg2` module makes that pretty easy, add the following to the `connect` method:
    ```python
    try:
        connection = psycopg2.connect(database=config.database, user=config.user, password=config.password, host="localhost")
    except Exception as e:
        print("Connection error: ", e)
        exit()
    return connection
    ```

4. Your constructor should probably call the `connect` method and save the resulting connection object as an instance variable; write that code now.

5. Finally, you'll need to write a method to execute one of your queries on your database and print the resulting information. To execute a query on the database, you need to use the `cursor()` method of the connection. Here is an example adapted from the [psycopg2 documentation](https://www.psycopg.org/docs/install.html#quick-install)
    ```python
    def getExample(self):
        try:

            #Open a cursor to perform database operations
            cursor = self.connection.cursor()

            #Execute a query
            cursor.execute("SELECT * FROM my_data")

            #Retrieve query results
            records = cursor.fetchall()

            print(records)
    ```

6. You might want to be able to use arguments in your queries, which you can do with a particular syntax ([more details are in the psycopg2 documentation](https://www.psycopg.org/docs/usage.html#passing-parameters-to-sql-queries)). Here is an example method for your reference (that uses the earthquake data):
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

7. For testing purposes, create a `DataSource` object and call one or more of your methods at the bottom of your `datasource.py` file:
    ```python
    if __name__ == '__main__':
        my_source = DataSource()
        #call your method
    ```
    
8. Add your `datasource.py` file, commit, and push.


## On perlman
Now you're ready to test out your code with your database. 

1. Connect to perlman and pull your individual repository to get the changes that you made. Make sure that your `.gitignore` file is there so that you don't accidentally push your database information.

2. Create the `psqlConfig.py` file

3. Add the following three lines with your individual database information:
    ```python
    database = 'YOUR_DATABASE_NAME'
    user = 'YOUR_CARLETON_USERNAME'
    password = 'YOUR_DATABASE_PASSWORD'
    ```
    That should be your Carleton username for the first two and the password that I provided to you for the last one.

4. Try running your `datasource.py` and see if it is able to connect to your database!

5. If that works, great job, you're done with the [individual deliverable](project-4-ind)! Back on your local setup, add the correct tag and push it.

Once you finish with the individual deliverable, start working on the changes to your team project that will be needed to connect your Flask app to your new database.