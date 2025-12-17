---
layout: page
title: Building Blocks Preparation
permalink: /classes/111-w26/build-blocks-prep
---

## Overview
There are several building blocks in Python that you'll need for doing pretty much anything: values, variables, and functions.
Today's class is focused on what you can do with these building blocks and how they differ from what you might expect.

## Basic Learning Objectives

Before class, you should be able to:
* Give examples of at least two *values* of different *types* in Python
* Use a built-in/provided function 
* Define the term *variable* in a programming context
* Make a new variable using an *assignment statement*
* Use an existing variable
* Change an existing variable

## Advanced Learning Objectives

After class, you should be able to:
* Predict what type an expression will result in
* Explain how `int` and `float` values interact
* Use the modulus `%` operator
* Explain what it means to evaluate a variable and identify when evaluation occurs
* Predict what value a variable will have at the end of a program, especially when the program uses and changes multiple variables
* Draw reference diagrams to show what is happening with a variable in a program, especially when the variable is changed
* Use several variables in a program to solve a problem

## Readings
You should complete the following Runestone readings and embedded checks:
* [2.2 Values and Data Types](https://runestone.academy/ns/books/published/foppff/simple-python-data_values-and-data-types.html?mode=browsing)
* [2.4 Function Calls](https://runestone.academy/ns/books/published/foppff/simple-python-data_function-calls.html?mode=browsing)
* [2.6 Variables](https://runestone.academy/ns/books/published/foppff/simple-python-data_variables.html?mode=browsing)
* [2.12 Reassignment](https://runestone.academy/ns/books/published/foppff/simple-python-data_reassignment.html?mode=browsing)
* [2.13 Updating Variables](https://runestone.academy/ns/books/published/foppff/simple-python-data_updating-variables.html?mode=browsing)
* [2.15 Input](https://runestone.academy/ns/books/published/foppff/simple-python-data_input.html?mode=browsing)

## Checks
Submit answers to the following on Moodle. For the diagrams, feel free to draw on paper and upload.

* (Checkpoint 2.12.3) After the following statements, what are the values of x and y?
    ```python
    x = 15
    y = x
    x = 22
    ```

* Draw the "reference" diagram (i.e. memory diagram) of the following code:
    ```python
    a = 3
    b = 7
    a = a + b
    b = 5
    ```

* Write a program that will compute the area of a circle (which is the radius squared, multiplied by pi (3.14)). Have the program work regardless of what value the `radius` variable is set to. Print a nice message back to the user with the answer. Be sure to copy what you write below and save it in Moodle.
<script type="py-editor">
  radius = 5
  #how to compute and print the area?
</script>