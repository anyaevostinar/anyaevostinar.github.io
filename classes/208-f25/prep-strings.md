---
layout: page
title: Strings and Arrays Preparation
permalink: /classes/208-f25/strings-prep
---

## Overview
You've probably used strings and lists a whole bunch in your programming career, but have you ever thought about how they actually are stored in memory? It turns out that they are complicated and a great chance to think about memory more deeply!

## Basic Learning Objectives
Before class, you should  be able to:
* Create variables and arrays in a C program
* Identify the various functions that the string library provides
* Compare the characters in two strings for equality

## Advanced Learning Objectives
After class, you should be able to:
* Explain how arrays are passed to functions
* Explain how strings and character arrays relate
* Define null-terminated
* Explain the difference between `strcpy` and `strncpy`


## Resources
You should read the following in DIS: 
* [1.5 Arrays and Strings](https://diveintosystems.org/book/C1-C_intro/arrays_strings.html)
* [2.6 Strings and the String Library](https://diveintosystems.org/book/C2-C_depth/strings.html) (don't worry about dynamic allocation yet)


## Checks
Submit answers to the following to Moodle:
* What will this print and why?

    ```c
    char buffer[5] = "cats";
    buffer[2] = '\0';
    printf("\%s", buffer);
    ```
* Fill in the ?? in this memory diagram for the previous code after it has run:

    ```
    | ??  | ??  | ??  | ??  | ??  | 
    ```

* If you'd like more practice, [check out these problems](https://diveintosystems.org/exercises/section-2_6.html), but you don't need to submit any of those answers.