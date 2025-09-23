---
layout: page
title: Dynamic Memory Preparation
permalink: /classes/208-f25/dynamic-prep
---

## Overview
So far, we've been focusing on "statically allocated memory" and have been just ignoring mentions of "dynamically allocated memory". It's time to think more deeply about where our data is saved and why there are two different places it can go!

## Basic Learning Objectives
Before class, you should  be able to:
* Explain the difference between the "heap" and the "stack"
* Explain what `malloc` and `free` do


## Advanced Learning Objectives
After class, you should be able to:
* Explain why the heap and stack are used differently
* Write C code that uses dynamically allocated memory correctly


## Resources
You should read the following in DIS: 
* [2.4 Dynamic Memory Allocation](https://diveintosystems.org/book/C2-C_depth/dynamic_memory.html)


## Checks
Submit the following to Moodle (one file or two or just text on Moodle is all good):
* Write a program to create two arrays, one on the stack and one on the heap and fill them both with the values `[1, 2, 3, 4, 5]`
* Write a sentence or two on the pros and cons of dynamic memory allocation instead of static memory allocation.