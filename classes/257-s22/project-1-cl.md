---
layout: page
title: Project Version 1 - Command Line
permalink: /classes/257-s22/project-command-line
---

## Overview

The goal of this iteration of your project is to create a minimal prototype to allow a user to interact with your data via the command line.
Your minimal prototype should also include an automated test suite.

The learning objectives for this iteration of your project are to be able to 1) create an automated test suite, 2) create a command line interface, and 3) create code that follows the principles of good function design.

## Collaboration

You should work with your team on this portion of the project.
You are able to get help from outside sources, as specified in the syllabus, but everything that your team submits should be your own.

## Due Date

This iteration of the project is due Monday April 18th at 10pm on GitHub.

## Your Task

Your team should write a program that:
* Supports at least two independent features; each of these features should enable the user to get information from your dataset(s) via the command line interface
* Has a usage statement
* Has an automated test suite with reasonable coverage
* Follows the function design principles and has generally good style
* Has documentation through function docstrings and in-line comments where appropriate

You may find the [`csv`](https://docs.python.org/3/library/csv.html) module useful for dealing with your dataset (assuming it's a `.csv`).

Your command line interface can either use the `sys.argv` list directly or you can use one of the many modules for parsing command line arguments.
The [`argparse`](https://docs.python.org/3/library/argparse.html) module is probably the easiest to use and is standard for all installations of Python.

## Turning it in

Your team should submit this iteration of the project on your team repo with the tag `cl` by typing the following:

```
git tag -a cl -m "command line interface"
git push origin cl
```

## Evaluation

The criteria for "Meets Expectations" and "Exceeds Expectations" are below.

### Meets Expectations Criteria
* Functionality:
* * There is a functional usage statement
* * There are two independent features controlled by a command line interface that allows the user to get information from the chosen dataset
* * There is an automated test suite that covers all the typical cases and some of the edge cases
* Design:
* * The functions/methods are mostly written at a single layer of abstraction
* * Function names, return values, and parameters generally follow the principles of good design
* * Function/method docstrings generally provide the required information
* * There isn't an excessive amount of repeated code
