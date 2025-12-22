---
layout: page
title: Building Blocks Preparation
permalink: /classes/111-w26/build-blocks-prep
---
<script type="module" src="https://pyscript.net/releases/2025.11.2/core.js"></script>

## Overview
We'll be exploring a couple more useful building blocks today: definite loops (`for`) and changing the value of a variable.

## Basic Learning Objectives

Before class, you should be able to:
* Change an existing variable
* Iterate a certain number of times using *range*
* Explain what the *accumulator pattern* is

## Advanced Learning Objectives

After class, you should be able to:
* Predict what value a variable will have at the end of a program, especially when the program uses and changes multiple variables
* Draw reference diagrams to show what is happening with a variable in a program, especially when the variable is changed
* Use several variables in a program to solve a problem
* Solve a problem using the accumulator pattern

## Readings
You should complete the following Runestone readings and embedded checks. Note that we are jumping ahead in the book a bit to be able to do some cool stuff sooner, so don't worry about some unfamiliar things showing up in the readings in Chapter 7, we'll get to it all soon!
* [2.12 Reassignment](https://runestone.academy/ns/books/published/foppff/simple-python-data_reassignment.html?mode=browsing)
* [2.13 Updating Variables](https://runestone.academy/ns/books/published/foppff/simple-python-data_updating-variables.html?mode=browsing)
* [7.1 Introduction: Iteration](https://runestone.academy/ns/books/published/foppff/more-about-iteration_introduction-iteration.html?mode=browsing)
* [7.2 Flow of Execution](https://runestone.academy/ns/books/published/foppff/more-about-iteration_flow-of-execution-of-the-for-loop.html?mode=browsing) - the `[]` is just how you make a list
* [7.5 The Accumulator Pattern](https://runestone.academy/ns/books/published/foppff/more-about-iteration_the-accumulator-pattern.html?mode=browsing) - you get a sneak peek of making your own function in this section, focus on the for loop part for now (skip the checks about strings for now)
* [7.7 Naming Variables in For Loops](https://runestone.academy/ns/books/published/foppff/more-about-iteration_naming-variables-in-for-loops.html?mode=browsing)

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

* (Checkpoint 7.5.2) Consider the following code:
    ```python
    nums = "123456789"
    for w in nums:
        accum = 0
        accum = accum + w
    print(accum)
    ```
    What happens if you put the initialization of `accum` inside the for loop as the first instruction in the loop?

* Write code using `range` and `for` to accumulate the sum of numbers from 5 to 43. You can test your code below and then copy your solution to Moodle:
<script type="py-editor">
  #your code here
</script>