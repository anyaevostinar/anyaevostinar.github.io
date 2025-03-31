---
layout: page
title: Function Design Prep
permalink: /classes/257-s25/function-prep
---

## Overview
Functions are a fundamental unit of a program and an excellent place to focus on good design practices. A program with a lot of short and well-written functions is easy to read, test, and extend. Many of the design practices relevant to functions also apply to larger units of organization, such as classes, so we will focus on functions today, but keep these principles in mind for all levels of your program.

## Basic Learning Objectives
Before class, you should be able to:
* Explain what a TO paragraph is and what role it plays in defining functions
* Explain the idea of the single [layer of abstraction](https://en.wikipedia.org/wiki/Abstraction_layer) principle
* Explain Martin's reasoning for how many parameters a function should have
* Give an example of a side effect in a function

## Advanced Learning Objectives
After class, you should be able to:
* Refactor functions to have a single layer of abstraction
* Write a TO paragraph for a function
* Explain strategies for selecting argument and return values

## Readings
To achieve the basic learning objectives, you can read the following:
* Clean Code Ch. 3 "Functions" up to and including "Have No Side Effects" (Heads up, the illustrations in this book are sometimes pretty odd, be prepared)
* [High-Quality Routines](https://cs.carleton.edu/faculty/jondich/local/high-quality-routines.pdf) from Code Complete, 2nd edition by Steve McConnell. [You have to be connected to the Carleton network for this link.](https://apps.carleton.edu/campus/its/services/accounts/offcampus/) This reading talks about some of the same things and has some different opinions. Note: 'routine' means 'a thing like a function or a method.'

## Checks
Submit answers to the following on Moodle:
1. What is a TO paragraph, and what role does it play in defining functions?
2. List at least 2 reasons why a function should operate at one level of abstraction.
4. Give an example of a side effect in a function

In addition, find an example from code you've written in the past of a function that violates at least one of the principles of effective functions. Annotate your code, pointing out the parts that violate these principles and why they violate these principles. (You can either mark up your code as a PDF, add comments, or whatever makes most sense to you.) Make sure this code is accessible to you during class, either on paper or on your computer. Remember, it's okay to have violated these principles in the past, it's good to write and rewrite your code just like writing an essay!