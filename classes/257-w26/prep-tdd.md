---
layout: page
title: Test-Driven Development Prep
permalink: /classes/257-w26/tdd-prep
---

## Overview
Writing tests for your code is a vital part of any well-design software project, however there is a school of thought that writing tests *before* you even start your project is the best approach. This is 'test-driven development' and it takes a bit of practice to get the hang of, which will be the goal for today's class.

## Basic Learning Objectives
Before class, you should be able to:
* Explain the basic philosophy behind test-driven development
* Define the terms 'unit test' and 'integration test'
* Explain the basic workflow 'red-green-refactor' in Python using `unittest`

## Advanced Learning Objectives
After class, you should be able to:
* Argue about the pros and cons of writing unit tests as a mechanism for developing and testing functions
* Use `unittest` to write tests in Python
* Identify edge cases for a basic project

## Readings
To achieve the basic learning objectives, read the following:
* [A simple introduction to Test Driven Development with Python](https://www.freecodecamp.org/news/learning-to-test-with-python-997ace2d8abe/) - we'll be using `unittest` so this is great for both the concepts of TDD and the syntax you'll be using
* [The Practical Test Pyramid](https://martinfowler.com/articles/practical-test-pyramid.html#TheImportanceOftestAutomation) - read through "The Test Pyramid", not the whole thing! Further sections on Unit and Integration tests are great if you are interested
* [Professionalism and Test-Driven Development](https://www.computer.org/csdl/magazine/so/2007/03/s3032/13rRUyYBleZ) by Robert C. Martin
* Optional: Clean Code Ch 9 goes into more detail

There is some interesting controversy about TDD (and I definitely don't always follow it), so if you are curious, here are some more things to read to get deeper into what various industry people are saying:
* [Canon TDD by Kent Beck](https://tidyfirst.substack.com/p/canon-tdd) - the "reviver" or "codifier" of TDD, who is apparently salty at people criticizing it without understanding it
* [Is TDD Dead?](https://martinfowler.com/articles/is-tdd-dead/) - a collection of conversations between several "big names" in the industry going over the disagreements

## Checks
Submit answers to the following through Moodle:
* What are the steps to test-driven development?
* What is the basic structure of a test using `unittest`?
* How do you run your tests using `unittest`?