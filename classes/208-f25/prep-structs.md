---
layout: page
title: Structs Preparation
permalink: /classes/208-f25/structs-prep
---

## Overview
C doesn't have classes, but it does have `struct`s! Today, we'll be focusing on these pseudo-classes, how we can use them, and what they tell us about memory organization.

## Basic Learning Objectives
Before class, you should be able to:
* Define a `struct` in C
* Explain how a `struct` differs from a traditional class
* Explain how a `struct` differs from an array

## Advanced Learning Objectives
After class, you should be able to:
* Explain how `struct`s are represented in memory
* Demonstrate how complex elements (e.g. structs with nested arrays) of an array are stored in memory
* Identify when padding will be necessary for a struct in memory


## Resources
Read the following:
* [DIS 1.6 Struct Syntax](https://diveintosystems.org/book/C1-C_intro/structs.html)
* [DIS 2.7 Structs in Memory](https://diveintosystems.org/book/C2-C_depth/structs.html) - Again, don't worry about `malloc` and dynamic memory just yet (soon!)

## Checks
Submit you answer to the following on Moodle.
1. What is the `struct` definition that will result in the following memory diagram?

    ![A diagram with boxes representing different sizes of memory](/classes/208-f25/struct_array.png)

* If you'd like more practice, check out DIS exercises for [1.6](https://diveintosystems.org/exercises/section-1_6.html) and [2.7](https://diveintosystems.org/exercises/section-2_7.html).
