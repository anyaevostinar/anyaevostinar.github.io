---
layout: page
title: Working with Classes Preparation
permalink: /classes/111-w26/oop2-prep
---
<script type="module" src="https://pyscript.net/releases/2025.11.2/core.js"></script>

## Overview
Once you know how to define your own class, there are lots of ways that you can use and interact with it. Today we'll focus on how you can use your own classes as parameters and return values.

## Basic Learning Objectives
Before class, you should be able to:
* Pass an object of your own class to a function
* Return an object of your own class
* Define the `__str__` method
* Explain the difference between *class variables* and *instance variables*

## Advanced Learning Objectives
After class, you should be able to:
* Define several classes that work together to solve a problem

## Resources
You should read the following:
* [Runestone 13.6 Objects as Arguments and Parameters](https://runestone.academy/ns/books/published/foppff/classes_objects-as-arguments-and-parameters.html?mode=browsing)
* [Runestone 13.7](https://runestone.academy/ns/books/published/foppff/classes_converting-an-object-to-a-string.html?mode=browsing)
* [Runestone 13.8 Instances as Reeturn Values](https://runestone.academy/ns/books/published/foppff/classes_instances-as-return-values.html?mode=browsing)
* [Runestone 13.9 Class Variables and Instance Variables](https://runestone.academy/ns/books/published/foppff/classes_class-variables-and-instance-variables.html?mode=browsing)

## Checks
Submit answers to the following on Moodle:
1. (13.7 Check) Create a class called Cereal that accepts three inputs: 2 strings and 1 integer, and assigns them to 3 instance variables in the constructor: `name`, `brand`, and `fiber`. When an instance of `Cereal` is printed, the user should see the following: `“[name] cereal is produced by [brand] and has [fiber integer] grams of fiber in every serving!”` To the variable name `c1`, assign an instance of `Cereal` whose name is "Corn Flakes", brand is "Kellogg's", and fiber is 2. To the variable name `c2`, assign an instance of `Cereal` whose name is "Honey Nut Cheerios", brand is "General Mills", and fiber is 3. Print both.
    <script type="py-editor">
    #Your class here
    </script> 
2. (13.13.3) Define a class called `BankAccount` that accepts the name you want associated with your bank account in a string, and an integer that represents the amount of money in the account. The constructor should initialize two instance variables from those inputs: `name` and `amt`. Add a string method so that when you print an instance of `BankAccount`, you see `"Your account, [name goes here], has [start_amt goes here] dollars."` Create an instance of this class with "Bob" as the name and 100 as the amount. Save this to the variable `t1`.
    <script type="py-editor">
    #Your class here
    </script>  
