---
layout: page
title: Starting with Flask
permalink: /classes/257-s22/flask-intro
---

## Goal
Get started with Flask by making the simplest app.

## Setup
If you are doing this on your personal machine and have Flask installed, great.

If you don't have Flask installed yet, go back to the reading for today and do that.

If you have trouble installing Flask on your personal machine, you can use a lab machine.

If you are using a lab machine, you're good, Flask is already installed.

## Getting Started
As you know from the reading, Flask is a web framework that lets you build dynamic a dynamic website using Python.
You're first going to build a very simple app that grabs data from a file and displays it on dynamically-built (and ugly) web pages.

1. Open your individual deliverables repository for this lab and make a new folder `FlaskLab`
2. Download [this](dataset.csv) very exciting dataset (it's not exciting, sorry) and place it in that folder
3. Make a new file `flask_lab_app.py`
4. In that file, put the boilerplate for Flask apps:
    ```python
    from flask import Flask

    app = Flask(__name__)

    if __name__ == '__main__':
        app.run()
    ```
5. As you know from your reading, Flask allows you to mark which function should be called when a user goes to a specific URL, so start by making a `homepage()` function that is called when a user first goes to your website using `@app.route('/')` (feel free to make the string returned more exciting):
    ```python
    @app.route('/')
    def homepage():
        return "hello, this is the homepage"
    ```
6. Open up the Terminal in VSCode and run your python script as you normally would:
    ```bash
    python3 flask_lab_app.py
    ```

    You should see something like:
    ```bash
    * Serving Flask app 'app' (lazy loading)
    * Environment: production
      WARNING: This is a development server. Do not use it in a production deployment.
     Use a production WSGI server instead.
    * Debug mode: off
    * Running on http://127.0.0.1:5000/ (Press CTRL+C to quit)
    ```

    And if you copy and paste that web address (the thing that starts with `http`) and put it into your web browser of choice, you should see your message. Congrats, you made a website with a Flask!


## Outputting Data
The main goal of using Flask is that we are able to display data from your dataset onto your website.
Eventually, we'll put your data into a database, but for now, we'll stick with loading it in from a file so we can focus on how Flask itself works.

1. Download [this](dataset.csv) very exciting dataset (it's not exciting, sorry) and put it into the folder with your flask app python file
2. We're going to keep things simple by just making a global variable `data` and saving the dataset into that:
    ```python
    data = []

    def load_data():
        #slightly weird syntax for reading from a file, but apparently the proper Pythonic way:
        with open('dataset.csv', newline='') as f:
            reader = csv.reader(f)
            for row in reader:
                data.append(row)
    ```
3. Now there are a lot of choices for how to display this data, though a common mistake is to not have the function return a string. We'll start by thinking of your command line arguments as being entered in the URL. If you wanted to let the user get a particular cell of your dataset, you could make the decorator for the function include the desired row and column as variables:
    ```python
    @app.route('/<row>/<column>', strict_slashes=False)
    ```

    The `<>` indicate that the string inside them should be a variable that is passed to your associated function, which also means that the function has to take those arguments, like so:
    ```python
    def get_cell(row, column):
    ```

    Use those two snippets to complete the `get_cell` function so that you can go to the page `your_url/0/1` and see a page with `data_1_1` on it.

    You can also try letting the user get an entire row of the dataset, but remember that you'll need to turn the list into a string to do so.

## Applying to your project
You're now all set to turn your command-line interface project into a Flask app by adding the appropriate decorators. You might need to adjust some of your functions to return strings if they had been returning lists (and adjust your tests in the process), so coordinate with your team and start on the next stage of the project.