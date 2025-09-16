---
layout: page
title: Pointers Preparation
permalink: /classes/208-f25/pointers-prep
---

## Overview
We've been avoiding talking much about those weird `*` that show up in various places in C, but now it's time to dive in to one of the most powerful but feared features of C: pointers! This is one of the aspects of C that makes it a "lower level" language, since pointers give you much more control and access, but come with additional complexity and responsibility.

## Basic Learning Objectives
Before class, you should be able to:
* Explain the difference between `int` and `int *`
* Explain the general idea of pointers
* Identify some of the benefits of using pointers

## Advanced Learning Objectives
After class, you should be able to:
* Correctly use `*` and `&` operators
* Explain the benefits and reasons to use pointers

## Resources
You should read/watch the following (if you aren't a fan of goofy videos, you can skip the first one):
* [Binky Pointer Video](https://www.youtube.com/watch?v=5VnDaHBi8dM) - silly intro to pointers
* [DIS 2.1 Parts of Program Memory and Scope](https://diveintosystems.org/book/C2-C_depth/scope_memory.html)
* [DIS 2.2 C Pointer Variables](https://diveintosystems.org/book/C2-C_depth/pointers.html)
* [Pointer basics from Standford](http://cslibrary.stanford.edu/106/)



## Checks
Submit answers to the following on Moodle:
1. Given a variable `int count=5`, what is the C code to define a variable `count_ptr` that holds the memory address of `count`?

2. Complete the following code that swaps the values stored at two `int` pointers: 

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=//void%20swap%28%20%3F%3F%20a,%20%3F%3F%20b%29%20%7B%0A%0A//%7D%0A%0Aint%20main%28%29%20%7B%0A%20%20int%20first%20%3D%201%3B%0A%20%20int%20second%20%3D%202%3B%0A%20%20%0A%20%20//swap%28%3F%3F,%20%3F%3F%29%3B%0A%20%20//first%20should%20now%20hold%202%20and%20second%20should%20hold%201%0A%0A%20%20return%200%3B%0A%7D&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=true&origin=opt-frontend.js&py=c_gcc9.3.0&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

There are a lot more exercises on DIS if you'd like more practice:
* [DIS 2.1](http://runestone.cs.swarthmore.edu/DIS_Exercises/section-2_1.html)
* [DIS 2.2](http://runestone.cs.swarthmore.edu/DIS_Exercises/section-2_2.html)