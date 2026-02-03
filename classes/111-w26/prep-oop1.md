---
layout: page
title: Object Oriented Preparation
permalink: /classes/111-w26/oop1-prep
---
<script type="module" src="https://pyscript.net/releases/2025.11.2/core.js"></script>

## Overview
*Object-oriented programming* is a powerful way of organizing programs that you've already used in bits and pieces.
While it's great to use Python's built in classes such as lists and strings, object-oriented programming really shines when you make your own classes.
Today we'll focus on the paradigm of thinking with objects and starting to make your own classes.

## Basic Learning Objectives
Before class, you should be able to:
* Define *classes*, *instances*, and *instance variables*
* Identify the syntax to define your own class
* Create a program with multiple instances of a given class

## Advanced Learning Objectives
After class, you should be able to:
* Define your own class
* Define a constructor
* Explain how instance variables and methods are used by objects

## Resources
You should read the following:
* [Runestone 13.1 Classes and Objects - the Basics](https://runestone.academy/ns/books/published/foppff/classes_introduction-classes-and-objects-the-basics.html?mode=browsing)
* [Runestone 13.2 Objects Revisited](https://runestone.academy/ns/books/published/foppff/classes_objects-revisited.html?mode=browsing)
* [Runestone 13.3 User Defined Classes](https://runestone.academy/ns/books/published/foppff/classes_user-defined-classes.html?mode=browsing)
* [Runestone 13.4 Adding Parameters to the Constructor](https://runestone.academy/ns/books/published/foppff/classes_adding-parameters-to-the-constructor.html?mode=browsing)
* [Runestone 13.5 Adding Other Methods to a Class](https://runestone.academy/ns/books/published/foppff/classes_adding-other-methods-to-a-class.html?mode=browsing)

## Checks
Submit answers to the following to Moodle:

1. (Checkpoint 13.13.1) Define a class called `Bike` that accepts a string and a float as input, and assigns those inputs respectively to two instance variables, `color` and `price`. Assign to the variable `testOne` an instance of Bike whose color is "blue" and whose price is *89.99*. Assign to the variable `testTwo` an instance of `Bike` whose color is "purple" and whose price is 25.0.
    <script type="py-editor">
    #Your class here
    </script>   

2. (Checkpoint 13.13.2) Create a class called `AppleBasket` whose constructor accepts two inputs: a string representing a color, and a number representing a quantity of apples. The constructor should initialize two instance variables: `apple_color` and `apple_quantity`. Write a class method called `increase` that increases the quantity by 1 each time it is invoked. 
     <script type="py-editor">
    #Your class here
    </script>  