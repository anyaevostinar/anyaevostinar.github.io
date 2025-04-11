---
layout: page
title: Starting with Flask
permalink: /classes/257-s25/flask-intro
---

## Goal
Get started with Flask by making the simplest app.

## Setup
Make sure that you have [installed Flask in your virtual environment](venv-guide) and activate your virtual environment.

## Getting Started
As you know from the reading, Flask is a web framework that lets you build dynamic a dynamic website using Python.
You're first going to build a very simple app that grabs data from a file and displays it on dynamically-built (and ugly) web pages.

1. Make a new folder `FlaskLab` and open it in VSCode
2. Make a new file `flask_lab_app.py`
3. In that file, put the boilerplate for Flask apps:
```python
from flask import Flask

app = Flask(__name__)

if __name__ == '__main__':
    app.run()
```
4. As you know from your reading, Flask allows you to mark which function should be called when a user goes to a specific URL, so start by making a `homepage()` function that is called when a user first goes to your website using `@app.route('/')` (feel free to make the string returned more exciting):
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

    Use those two snippets to complete the `get_cell` function so that you can go to the page `your_url/0/1` and see a page with `column_2` on it.

    You can also try letting the user get an entire row of the dataset, but remember that you'll need to turn the list into a string to do so.

## Handling user errors (and your own)

You may have noticed as you were doing the previous pieces that it would be nice if you could achieve something similar to a usage statement.
Fun fact, you can!

1. Add a function with the decorator `@app.errorhandler(404)` to catch page not found errors. The function will need to take an argument (which is the error):
```python

@app.errorhandler(404)
def page_not_found(e):
    return "sorry, wrong format, do this instead...."
```

    Make sure that the function lets the user know what format they should use for the URL to get the information they want. 

2. You can add a function for internal server errors as well, i.e. when you have a bug in your Python code:
```python
@app.errorhandler(500)
def python_bug(e):
    return "Eek, a bug!"
```

## Testing
You can test the Flask-specific functions the normal way by just calling them directly and checking that they return the correct thing.
You can also test that your Flask app returns the correct thing based on a URL with the following:

```python
from app import *
import unittest

class TestSOMETHING(unittest.TestCase):
    def test_route(self):
        self.app = app.test_client()
        response = self.app.get('/', follow_redirects=True)
        self.assertEqual(b'hello, this is the homepage', response.data)
```
      
The `b` stands for byte and its because `response.data` is a 'bytes-like object'.
Once you make more complicated pages, you can use `assertIn` to check for the specific data that you care about without worrying about the HTML tags.

Make a test file and test your existing functions and routes. (Yes, we're breaking TDD since we already have the production code written. It'd be a good idea to purposefully break your production code to make sure your tests fail first.)

## Applying to your project
You're now all set to turn your command-line interface project into a Flask app.
It's good to separate the underlying logic of your program from the Flask-specific portion so that it will be easier to refactor the logic portion once we add a database.
Therefore, you should have all the Flask functionality in a separate file that imports the file with core functions.
You should now start on your [individual deliverable](project-2-ind) for this week, which is making a Flask app with a homepage and single data route.