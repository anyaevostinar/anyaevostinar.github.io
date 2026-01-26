---
layout: page
title: Webpages Prep
permalink: /classes/111-w26/webpages-prep
---

## Overview
You can do all sorts of things with Python, including run a website! There are several third-party modules that support this, but we'll be exploring one that keeps things a little simpler today: Flask. We're going to focus just on making plain text websites today, but if you are interested in HTML, Flask supports generating fully polished webpages as well.

## Basic Learning Objectives
Before class, you should be able to:
* Explain the basic idea of Flask
* Identify the syntax that Flask uses for routes

## Advanced Learning Objectives
After class, you should be able to:
* Use Flask to create a basic website

## Readings
To achieve the basic learning objectives, you should read the following sections of the Flask Tutorial on [pythonbasics.org](https://pythonbasics.org/) and try out the Hello World app:

1. [What is Flask](https://pythonbasics.org/what-is-flask-python/)
2. [Flask Tutorial - Hello World](https://pythonbasics.org/flask-tutorial-hello-world/#Hello-World) - note that this references having things installed, don't worry about actually running anything, just read through what each line of the basic app does.
3. [Flask Tutorial - Routes](https://pythonbasics.org/flask-tutorial-routes/) (ignore the 'flask route post' section, we won't get into that in this class)


## Checks
(Note that you can't run Flask on your own machine without doing some additional installing, so I recommend just using the lab machines. If you really want to try installing everything, you can look at [this guide from CS 257](/classes/257-w26/venv-guide).)

Submit answers to the following through Moodle:
1. How does Flask connect Python functions to URLs?
2. What is one URL that would trigger the following function to run?
    ```python
    @app.route('/name/<row>/<column>/')
    def get_cell(row, column):
        return data[int(row)][int(column)]
    ```
