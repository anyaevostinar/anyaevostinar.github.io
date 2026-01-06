---
layout: page
title: Functions Preparation
permalink: /classes/111-w26/functions-prep
---
<script type="module" src="https://pyscript.net/releases/2025.11.2/core.js"></script>


## Overview
*Functions* are a fantastic way of bundling a series of statements together conceptually to make your code much clearer.
You've already been using them a lot, but now you'll learn how to make your own and how to think through what they are doing.

## Basic Learning Objectives
Before the start of class, you should be able to:
* Define the terms *function* and *parameter*
* Predict the return value of a function given sample parameter values (aka arguments)
* Define and use a new function to accomplish a simple task

## Advanced Learning Objectives
During and after class, you should be able to:
* Explain the difference between a return value and a side effect
* Explain when the code in a function is executed
* Explain what the *scope* of a function is and how it impacts variables used inside the function
* Define and use a new function with multiple parameters to accomplish a task
* Identify when a function should be created

## Readings

You should read the following (note there are a few places where an old checkpoint doesn't show correctly, don't worry about it):
* [4.1 Introduction to Functions](https://runestone.academy/ns/books/published/foppff/functions_introduction-to-functions.html?mode=browsing)
* [4.2 Function Definition](https://runestone.academy/ns/books/published/foppff/functions_function-definition.html?mode=browsing)
* [4.4 Function Parameters](https://runestone.academy/ns/books/published/foppff/functions_function-parameters.html?mode=browsing)
* [4.5 Returning a value from a function](https://runestone.academy/ns/books/published/foppff/functions_returning-a-value-from-a-function.html?mode=browsing)
* [4.7 Type Annotations](https://runestone.academy/ns/books/published/foppff/functions_type-annotations.html?mode=browsing)

## Checks
Submit answers to the following on Moodle:
* What output will the following code produce (Checkpoint 4.4.6):
    ```python
    CONSTANT_VALUE = -8
    def cyu(n1: int, n2: int) -> int:
        print(n1 + n2 - CONSTANT_VALUE)

    cyu(4, 3)
    ```
* Write a function `cheer_up` that takes a string and returns it with a `:)` at the end.
<script type="py-editor">
  #your code here
  print(cheer_up("CS 111")) #should output "CS 111:)"
</script>