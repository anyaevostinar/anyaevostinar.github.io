---
layout: page
title: More Iteration Preparation
permalink: /classes/111-w26/more-iteration-prep
---
<script type="module" src="https://pyscript.net/releases/2025.11.2/core.js"></script>

## Overview
Simple definite (for) loops are great when you know exactly how many times you want to iterate.
But there are situations where you just don't know how long the loop should run, like when you are relying on input from the user to tell you they are done with something. 
Sometimes you also want to be able to work with 2D data, such as matrices or grids and to iterate over them, you need a more complex structure than your basic definite loop.
Today we'll be exploring some variations on iteration that let us do more complex tasks.

## Basic Learning Objectives
Before class, you should be able to:
* Write a basic *indefinite loop* using `while`
* Predict what output a *nested loop* will produce
* Identify what value is at a given index location of a *nested list*


## Advanced Learning Objectives
After class, you should be able to:
* Write an indefinite loop to solve a problem
* Write a nested loop to produce specific output
* Use a nested list to solve a problem

## Resources
You should read/watch the following:
* [The `while` statement](https://runestone.academy/ns/books/published/foppff/more-about-iteration_the-while-statement.html?mode=browsing)
* [The Listener Loop](https://runestone.academy/ns/books/published/foppff/iteration_the-listener-loop.html?mode=browsing)
* [`break` and `continue`](https://runestone.academy/ns/books/published/foppff/iteration_break-and-continue.html?mode=browsing)
* [Nested Data](https://runestone.academy/ns/books/published/foppff/nested-data_introduction-nested-data-and-nested-iteration.html?mode=browsing) - stop when you get to discussion of "dictionaries"
* [Nested Iteration](https://runestone.academy/ns/books/published/foppff/nested-data_nested-iteration.html?mode=browsing)

## Check
Submit answers to the following on Moodle:

* Rewrite the following for loop as a while loop, keeping the output the same:
<script type="py-editor">
  for i in range(5):
    print(i)
</script>

* What will the following output?
```python
for i in range(3):
    for j in ['a', 'b']:
        print(i, j)
```

* Given the following nested list:
    ```python
    my_list = [[1, 'a'],
                [5, 'c'],
                ['z', 10],
                [100, 200, 300]]
    ```
    What is the value at `my_list[1][0]`?