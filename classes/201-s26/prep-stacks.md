---
layout: page
title: Stacks Preparation
permalink: /classes/201-s26/stacks-prep
---

## Overview
We'll start our exploration of ADTs with one of the simplest: the stack. The ability to simply place an item on a *stack* and remove items last-in, first-out can be used to elegantly solve many problems. Today, we'll focus on how we can use the humble stack ADT.

## Basic Learning Objectives
Before class, you should be able to: 
* Explain what a stack is and how items are added and removed
* Define LIFO
* Explain the time complexity tradeoffs with a stack implementation

## Advanced Learning Objectives
After class, you should be able to:
* Implement your own version of a stack
* Use a stack to solve a problem


## Readings
Read the following in the online textbook Runestone:

* [3.2 What are Linear Structures?](https://runestone.academy/ns/books/published/kotlinds/basic-ds_what-are-linear-structures.html?mode=browsing)
* [3.3 Stacks](https://runestone.academy/ns/books/published/kotlinds/basic-ds_stacks.html?mode=browsing)
* [3.4 The Stack ADT](https://runestone.academy/ns/books/published/kotlinds/basic-ds_the-stack-abstract-data-type.html?mode=browsing)
* [3.5 Implementing a Stack in Kotlin](http://runestone.academy/ns/books/published/kotlinds/basic-ds_implementing-a-stack.html?mode=browsing)
* [3.21 Implementing an Unordered List: Arrays](https://runestone.academy/ns/books/published/kotlinds/basic-ds_implementing-an-unordered-list-arrays.html?mode=browsing) - we'll be exploring using arrays in class to implement a stack, so read this section focusing on how arrays work and we'll be revisiting unordered lists on Friday

## Checks
Submit answers to the follows on Moodle:

```
 | “Teddy” |
 |  “Sam”  |
 | “Janine”|
 -----------
```

1. Given the stack above, what will the stack look like after calling `pop()` and then `push(“Allison”)` on that stack.

2. Complete `reverseString` from section 3.5, self-check 3 and upload it.