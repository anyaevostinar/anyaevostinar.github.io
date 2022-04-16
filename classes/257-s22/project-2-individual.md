---
layout: page
title: Project Version 2 - Individual
permalink: /classes/257-s22/project-2-ind
---

## Overview

This is the individual component of the [Flask iteration](project-2-flask) of your team's project.
For this component, you need to write a basic Flask app with one potential route.
Much of this code won't end up in your team's repository because it will be duplicate. 
Instead, the goal is to get you to practice and start thinking about the Flask app individually.

## Collaboration

You should work individually on this component.
You shouldn't coordinate with your team, since the goal is that you get practice individually, and so it's fine if there is some duplication.
You can get conceptual help from your team and others, however what you submit must be all your own work.

## Due Date

The individual deliverable for this iteration is due **Friday April 22nd** at 10pm on your individual GitHub.

## Your Task

You should write a basic Flask app with at least one route. Your Flask app should import the files from your group's command-line interface app and use those functions to provide some of the data from your dataset on a web page.
The home page of your app should provide instructions for what URL to go to to see the data you choose.
To get 'exceeds expectations' that route should use a route parameter and you should have a couple of tests in another file for your Flask-specific functions.

Specifically, the grader will:
* Pull down your group's files that are tagged 'cl'
* Pull down your submission for this deliverable that should be tagged 'flask'
* Place your Flask app file in the same directory as your group's code
* Run your Flask app file
* Based on the information on your homepage, type in a URL to see the data
* Examine your code for style and requirements

## Turning it in

You should submit the file with your individual Flake app to your individual deliverables repository with the tag `flask` by typing the following:

```
git tag -a flask -m "basic flask app"
git push origin flask
```


## Evaluation

The criteria for "Meets Expectations" and "Exceeds Expectations" are below.

### Meets Expectations Criteria
* Functionality:
  * The Flask app works with the team's core command line code
  * There is a homepage with instructions
  * There is at least one route that uses the team's code to display data from the dataset
* Design:
  * Flask app code is reasonably easy to read and understand
  * The Flask app code has appropriate [docstrings](https://peps.python.org/pep-0257/) 
  * There isn't an excessive amount of repeated code
  * Style mostly follows the [style guide](https://peps.python.org/pep-0008/)

### Exceeds Expectations Criteria
* All the Meets Expectations criteria are met
* Functionality:
  * Route uses a parameter to change what data is displayed
  * There is a reasonable automated test suite for the Flask-specific functions including tests for the routes
* Design:
  * The Flask app code is very clear, potentially using helper functions to ensure that Flask-specific functions are at a single layer of abstraction
  * There is barely any duplicated code
  * The docstrings are particularly clear
