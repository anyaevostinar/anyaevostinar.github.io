---
layout: page
title: Flask Forms
permalink: /classes/257-w26/flask-form
---

## Goal
Be able to add a form to your Flask app and use POST HTTP requests correctly.

## Setup
We'll be continuing to use the [Pokemon dataset](Pokemon.csv) as an example.
Clone down the Flask Forms Lab repository linked on Moodle.
If you need the previous two Flask labs for reference, they are here: [Intro to Flask](flask-intro) and [Flask and HTML](flask-html).

## Table of Contents
If you want specific functionality, here are the sections:

* [Simple Radio Buttons](#simple-row-display)
* [Testing](#test-forms)
* [POST requests](#post-requests)
* [Dynamically generated dropdowns](#dynamically-generated-dropdowns)
* [Autocomplete search bar](#extra) - link to tutorial and hints

## Simple Row Display
We're first going to use radio buttons to let the user choose which two rows of the dataset to view.

1. Make a new route and function in your Flask app that just returns the specified row from the dataset, for example:
    ```python
    @app.route('/displayrow')
    def display_row():
        row = 1
        return str(data[row])
    ```

2. To give the user a choice in which row to display, we need to add a form to the page. You can make a new HTML page, or just put this on `index.html`, whichever you prefer:
    ```html
        <p>Which row would you like to see?</p>
        <form action="displayrow">
            <label for="1">Row 1</label>
            <input type="radio" id="1" name="rowchoice" value="1">
            <label for="2">Row 2</label>
            <input type="radio" id="2" name="rowchoice" value="2">
            <input type="submit" value="Submit">
        </form>
    ```

    We're only letting them choose between row 1 and row 2 currently and using radio buttons to force them to choose only one.

3. If you run your app now, you'll notice that Flask is ignoring what the user selected and still always showing row 1, so we need to update the Flask function so that it actually uses the information the user submitted.
    First, we need to import the `request` functionality in Flask:
    ```python
    from flask import Flask, render_template, request
    ```

    Then we need to update the function to get information from the `request` object:
    ```python
    @app.route('/displayrow')
    def display_row():
        row = int(request.args['rowchoice'])
        return str(data[row])
    ```

    Now if you try your app again, you should see the data that the user requested!

## Test Forms
How to test your new formy page? It's nice and simple for a GET request:

```python
    def setUp(self):
        self.app = app.test_client()

    def test_display_row(self):
        response = self.app.get('/displayrow?rowchoice=1')
        self.assertIn(b"Your choice: 1", response.data)
```

You just include the `?my_var=X` after your normal route address.

## POST Requests
You might have noticed in the URL that the user's selection is shown there. This is fine for non-sensitive data, but might not always be what you want. If you don't want the information included right in the URL, then you need to use a POST method.

1. Add to your HTML another form, this time specifying that the method used should be `post`:
    ```html
        <p>POST version: Which row would you like to see?</p>
        <form action="displayrow" method="post">
            <label for="1">Row 1</label>
            <input type="radio" id="1" name="rowchoice" value="1">
            <label for="2">Row 2</label>
            <input type="radio" id="2" name="rowchoice" value="2">
            <input type="submit" value="Submit">
        </form>
    ```

2. If you try to just run your app, you'll get an error, because Flask functions default to only accepting GET requests. To also accept POST requests, we need to pass in a keyword parameter to the route:
    ```python
    @app.route('/displayrow', methods=['GET', 'POST'])
    ```

    If you try to run it now, you'll get another error, this time because POST requests access the variables a little bit differently. To be able to handle both POST and GET requests, we need to first detect which method is being used and then make the correct call to access the information:

    ```python
    def display_row():
        if request.method == 'POST':
            row = int(request.form['rowchoice'])
        elif request.method == 'GET':
            row = int(request.args['rowchoice'])
        else:
            return 'Not a valid request protocol'

        return str(data[row])
    ```

    Try out your app now and verify that you are able to get the information using either request method. Awesome!

To test your POST request, it's a bit more complicated, [but explained here](https://flask.palletsprojects.com/en/stable/testing/#form-data) (not required for the lab, just in case you want to know).

## Dynamically Generated Dropdowns
You might have realized that it will be really annoying if you have to manually make radio buttons for every possible choice that the user might want to look up in your dataset. 
Fortunately, with a little bit of Jinja, we can automatically generate a dropdown menu.

1. First we'll need a couple of new functions. We need a function to give all the 'titles' of the rows (i.e. the first column):

    ```python
    def get_poke_names():
        row_names = []
        for row in data:
            row_names.append(row[1])

        return row_names
    ```
    (This function obviously isn't very efficient, but I'm not worried about that at the moment.)

    We also need a function to look up the Pokemon by name, which I've provided (`get_pokemon(poke_name)`).

2. With those functions in place, we need to pass the row titles to our homepage template:
    ```python
    @app.route('/')
    def home():
        return render_template('index.html', rows=get_poke_names())
    ```

    And adjust our HTML template to use that information by displaying it in a dropdown menu:

    ```html
    <p>Dropdown version: Which row would you like to see?</p>
    <form action="rowbyname">
        <label for="rows">Choose a row</label>
        <select  id="rows" name="rowchoice">
            {%raw %}
            {% for row in rows: %}
            <option value="{{row}}">{{row}}</option>
            {% endfor %}
            {%endraw%}
        </select>
        <input type="submit" value="Submit">
    </form>
    ```

3. Finally, we need to make the Flask route specified:

    ```python
    @app.route('/rowbyname')
    def display_row_by_name():
        return str(get_pokemon(request.args['rowchoice']))
    ```

## Extra
You're now all set to implement a fancy way to navigate from the homepage to the data page for your [individual front-end deliverable](project-4-ind).

If you want, see if you can get an [autocomplete search box](https://www.geeksforgeeks.org/autocomplete-input-suggestion-using-python-and-flask/) working. 
*Hint: text input always goes through POST, so make sure to have your Flask method set up for POST. You'll also need to add the `form` tags and `submit` button and add a `name` argument to the `input` tag.*
You are welcome to use the `ajax.googleapis.com` scripts in your project, just be sure to cite the tutorial!