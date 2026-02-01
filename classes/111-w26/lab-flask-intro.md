---
layout: page
title: Webpages with Flask
permalink: /classes/111-w26/flask-lab
---

## Goal
Explore different functionalities of Flask with a simple dataset.

## Table of Contents
* [Getting Started](#getting-started)
* [Outputting Data](#outputting-data)
* [Handling User Errors](#handling-user-errors-and-your-own)

## Setup
Create a folder `FlaskLab` in COURSES as you usually do. 

Then download [flask_lab_app.py](flask_lab_app.py) and [Pokemon.csv](Pokemon.csv) and place them in that folder.

## Getting Started
As you know from the reading, Flask is a web framework that lets you build dynamic a dynamic website using Python.
You're going to build a very simple app that grabs data from a file and displays it on dynamically-built (and ugly) web pages.

1. The starter code starts with the Flask boilerplate and loads in the Pokemon data for you.
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

    And if you the click on the link [http://127.0.0.1:5100/](http://127.0.0.1:5100/), a web browser should open and you should see your message. Congrats, you made a website with Flask!


## Outputting Data
The main goal of using Flask is that we are able to display data from your dataset onto your website. Normally we would have this data in a special location called a database, but we'll just stick with loading from a file. 

1. I've provided you with a dataset about Pokemon already in the repository, called `Pokemon.csv`, along with a `load_data` function that handles reading that data into a list of lists

3. Now there are a lot of choices for how to display this data. If you wanted to let the user get a particular cell of your dataset, you could make the decorator for the function include the desired row and column as variables:
    ```python
    @app.route('/<int:row>/<int:column>/')
    ```

    The `<>` indicate that the string inside them should be a variable that is passed to your associated function, and in this case we are also converting `row` and `column` to `int`s immediately.  The function has to take those exact arguments, like so:
    ```python
    def get_cell(row, column):
    ```

    **Use those two snippets to complete the `get_cell` function** so that you can go to the page `your_url/0/1` and see a page with `Name` on it.

4. Now try letting the user get an entire row of the dataset, perhaps by specifying the Pokemon name that they want. Remember that you can use additional `/` in your routes to specify different commands, such as `/name/<pokemon_name>`.

## Handling user errors (and your own)

You may have noticed as you were doing the previous pieces that it would be nice if you could have errors display nicely.
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

## Submission
Submit your Flask app at this point for an extra engagement credit. Then play around and make more functionality for your website!

## HTML
You may already be aware that website use HTML (and CSS) to specify how they should look (and be less ugly). You can do that with Flask via the following:

1. Create a `templates` folder in your lab folder
2. Create a file in that folder `index.html` and put in the following boilerplate:
    ```html
    <html>
        <head>

        </head>
        <body>

        </body>
    </html>
    ```
3. Within the `heading` put in a set of `title` HTML tags and place a placeholder {%raw%}`{{title}}`{%endraw%} between them (this language is called Jinja and it's a lot like Python):
    ```html
    {%raw %}
    <title>{{title}}</title>
    {%endraw%}
    ```
4. If you have as many tabs open as I do regularly, you can't actual see the titles easily, so, within the `body`, put in a heading with the title as well:
    ```html
    {%raw%}
    <h1>Welcome to the {{title}}!</h1>
    {%endraw%}
    ```
5. Now you need to go edit your existing Flask app to use your new template. Open `flask_lab_app.py` and edit your `homepage()` function so that instead of just returning a plain string, it returns the result of calling `render_template` with your title of choice:
    ```python
    @app.route('/')
    def index():
        return render_template('index.html', title="Pokemon rule!")
    ```
6. Run your app and check out your new fancy (kind of) homepage!

## Data with Templates
Even though you don't strictly have to use Jinja, it makes displaying lists much easier.
Let's display the headings of the Pokemon dataset on the homepage.

1. Within `index.html` make an unordered list in the `body`:
    ```html
    <ul>
    </ul>
    ```
2. Within that unordered list, we'll use Jinja to make a list item for each heading in our list `headings`:
    ```html
    {%raw%}{% for heading in headings: %}
    <li>{{ heading }}</li>
    {% endfor %}{%endraw%}
    ```
3. Now we need to actually pass that argument. Within `flask_lab_app.py`, add to the arguments that you are passing to `render_template` in `index`:
    ```python
    def homepage():
        return render_template('index.html', title="Pokemon rule!", headings = data[0])
    ```
4. Restart your app to see your new fancy list!
5. Try adding another list of the first data row of the Pokemon dataset.

## Fun extra
By combining the route variables and Jinja placeholders, you can let the user display what they want on your page.
Try making a new template and route so that you can go to `your_url/greeting/your_name` and find a web page that greets whatever the user puts for `your_name`.