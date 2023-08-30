---
layout: page
title: Project Component 1 - Command Line
permalink: /classes/257-f23/project-command-line
---

## Overview

The goal of this component of your project is to create a minimal app to allow a user to interact with your data via the command line.
Your app should also include an automated test suite.

The learning objectives for this subcomponent of your project are to be able to 1) create an automated test suite, 2) create an app with a command line interface, and 3) create code that follows the principles of good function design.

## Collaboration

You should work with your team on this portion of the project.
You are able to get help from outside sources, as specified in the syllabus, but everything that your team submits should be your own.

## Due Date

This subcomponent of your project is due Monday October 2nd at 10pm on GitHub.

## Your Task

Your team should write a program that:
* Supports at least two independent features; each of these features should enable the user to get information from your dataset(s) via the command line interface
* Has a usage statement
* Has an automated test suite with reasonable coverage (probably 10-20 tests)
* Follows the function design principles and has generally good style
* Has documentation through [docstrings](https://peps.python.org/pep-0257/) and in-line comments where appropriate
* Follows the [recommended Python style](https://peps.python.org/pep-0008/)

You may find the [`csv`](https://docs.python.org/3/library/csv.html) module useful for dealing with your dataset (assuming it's a `.csv`).

Your command line interface can either use the `sys.argv` list directly or you can use one of the many modules for parsing command line arguments.
The [`argparse`](https://docs.python.org/3/library/argparse.html) module is probably the easiest to use and is standard for all installations of Python.

You can and should create 'dummy data' that allows you to test your production code more easily and quickly. Make sure to include that dummy data in what you submit.

## Turning it in

Your team should submit this subcomponent of the project on your team repo with the tag `cl` by typing the following:

```
git tag -a cl -m "command line interface"
git push origin cl
```

## Evaluation

The criteria for "Demonstrates Proficiency" and "Demonstrates Mastery" are below.
When evaluating your project, the grader will pull down your team's repo, checkout the `cl` tag, and run both your production code and test suite, as well as look through your code for style.

#### Proficiency
* Functionality:
  * There is a functional usage statement
  * There are two independent features controlled by a command line interface that allows the user to get information from the chosen dataset
  * There is an automated test suite that covers all the typical cases and some of the edge cases
* Design:
  * The correct directory structure is used
  * The functions/methods are mostly written at a single layer of abstraction
  * Function names, return values, and parameters generally follow the principles of good design
  * Function/method [docstrings](https://peps.python.org/pep-0257/) generally provide the required information
  * There isn't an excessive amount of repeated code
  * Style mostly follows the [style guide](https://peps.python.org/pep-0008/)

#### Mastery
* All the Proficiency criteria are met
* Functionality:
  * The test suite covers nearly all edge cases and documents which tests are edge cases clearly
  * The test suite includes sufficient integration tests and documents which tests are integration tests clearly
  * The usage statement is thorough and clear
  * The features are interesting and enable the user to gain a large amount of information from the dataset
* Design:
  * The functions/methods are all written at a single layer of abstraction
  * Function names, return values, and parameters all follow the principles of good design
  * Function/method [docstrings](https://peps.python.org/pep-0257/) all provide the required information
  * There is barely any duplicated code
