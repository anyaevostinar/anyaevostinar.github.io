---
layout: page
title: Graphics Prep 
permalink: /classes/111-w26/graphics-prep
---

## Overview
*Object-oriented programming* is a style of programming that uses *objects* to organize the program. We'll be dipping our metaphorical-toes into OOP in order to do something fun: drawing! Today, we'll be exploring the [`graphics.py`](graphics.py) library, which is a simplified library for drawing graphical user interfaces in Python.

## Basic Learning Objectives
Before the start of class, you should be able to:
* Give examples of *objects* and *classes* in the context of `graphics.py`
* Write a program to generate a basic shape in a `GraphWin`

## Advanced Learning Objectives
During and after class, you should be able to:
* Write a program to generate a more complex image with `graphics.py`
* Use the coordinate system of `graphics.py`
* Make an interactive graphics window

## Readings

You should read the material linked through Moodle (or Zelle 4-4.4) and submit answers to the following on Moodle:
* Draw the reference diagram after the following code:
```python
dotOne = Circle(Point(10, 10), 4)
dotTwo = dotOne
dotTwo.move(1, 1)
```
* What is the problem with the above code and how do you fix it?
* Write a program that does the following. Note that you can test it out by [downloading this file](graphics.py) and putting it in the same folder as your code, but it's fine if you don't have a chance to test it.
    * Imports everything from `graphics`
    * Creates a graphics window
    * Draws a yellow circle somewhere in the window with radius 20