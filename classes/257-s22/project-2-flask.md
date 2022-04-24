---
layout: page
title: Project Version 2 - Flask
permalink: /classes/257-s22/project-2-flask
---

## Overview

The goal of this iteration of your project is to create a basic Flask app to allow a user to interact with your data via a web browser.
Your Flask app should also include an expanded automated test suite that tests your Flask functions and has been updated for any refactoring that you did.

The learning objectives for this iteration of your project are to be able to 1) create a basic Flask app using variable routes, 2) further expand your automated test suite, and 3) continue to create code that follows the principles of good function design.

## Collaboration

You should work with your team on this portion of the project.
You are able to get help from outside sources, as specified in the syllabus, but everything that your team submits should be your own.

## Due Date

This iteration of the project is due Monday April 25th at 10pm on GitHub.

## Your Task

Your team should write a program that:
* Uses the [Flask](https://flask.palletsprojects.com/en/2.1.x/) framework to build a browser app
* Supports at least two independent features via [Flask routes](https://pythonbasics.org/flask-tutorial-routes/); each of these features should enable the user to get information from your dataset(s) via the web browser
* Has at least one route that uses at least one route parameter meaningfully
* Has a useful message when the user enters an incorrect URL
* Has an automated test suite with reasonable coverage for both the core functions and the Flask-specific functions
* Follows the function design principles and has generally good style
* Has documentation through [docstrings](https://peps.python.org/pep-0257/) and in-line comments where appropriate
* Follows the [recommended Python style](https://peps.python.org/pep-0008/)

You should largely be able to build from and reuse/refactor your existing code. I recommend that you keep your core functionality in a separate file(s) from your Flask-specific functionality so that it is easier to adjust your core functions later. You might need to adjust some of your functions to return strings if they had been returning lists (and adjust your tests in the process).

## Turning it in

Your team should submit this iteration of the project on your team repo with the tag `flask` by typing the following:

```
git tag -a flask -m "basic Flask app"
git push origin flask
```

## Evaluation

The criteria for "Meets Expectations" and "Exceeds Expectations" are below.
When evaluating your project, the grader will pull down your team's repo and run both your production code and test suite, as well as look through your code for style.

### Meets Expectations Criteria
* Functionality:
  * Uses the Flask framework correctly
  * There is a useful 404 page
  * There are two independent features controlled by separate routes that allows the user to get information from the chosen dataset
  * One of the routes uses a route parameter that has some influence on what is displayed
  * There is an automated test suite that covers all the typical cases and some of the edge cases
* Design:
  * The functions/methods are mostly written at a single layer of abstraction
  * Function names, return values, and parameters generally follow the principles of good design
  * Function/method [docstrings](https://peps.python.org/pep-0257/) generally provide the required information
  * There isn't an excessive amount of repeated code
  * Style mostly follows the [style guide](https://peps.python.org/pep-0008/)

### Exceeds Expectations Criteria
* All the Meets Expectations criteria are met
* Functionality:
  * The test suite covers nearly all edge cases
  * The test suite includes sufficient integration tests
  * The 404 page is thorough and clear
  * The features are interesting and enable the user to gain a large amount of information from the dataset
  * The route parameter(s) are highly effective in enabling the user to gain specific information from the dataset
* Design:
  * The Flask-specific functionality is separate from the core functionality in separate files
  * The functions/methods are all written at a single layer of abstraction
  * Function names, return values, and parameters all follow the principles of good design
  * Function/method [docstrings](https://peps.python.org/pep-0257/) all provide the required information
  * There is barely any duplicated code




