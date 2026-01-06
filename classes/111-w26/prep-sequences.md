---
layout: page
title: Sequences Preparation
permalink: /classes/111-w26/sequences-prep
---
<script type="module" src="https://pyscript.net/releases/2025.11.2/core.js"></script>

## Overview
*Lists* and *strings* are two kinds of sequences that have some similar functionality in Python.
Today's focus will be on using these two types of sequences.

## Basic Learning Objectives
Before class, you should be able to:
* Create a *list* in Python
* Create a *string* in Python
* Identify the syntax for indexing into, slicing, and concatenating sequences 

## Advanced Learning Objectives
After class, you should be able to:
* Use the functionality of strings and lists to solve problems

## Readings
You should complete the following readings/videos and embedded checks in Runestone:
* [8.1 Introduction: Sequences](https://runestone.academy/ns/books/published/foppff/sequences_introduction-sequences.html?mode=browsing)
* [8.2 Strings and Lists](https://runestone.academy/ns/books/published/foppff/sequences_strings-and-lists.html?mode=browsing)
* [8.3 Index Operator](https://runestone.academy/ns/books/published/foppff/sequences_index-operator-working-with-the-characters-of-a-string.html?mode=browsing)
* [8.5 Length](https://runestone.academy/ns/books/published/foppff/sequences_length.html?mode=browsing)
* [8.6 The Slice Operator](https://runestone.academy/ns/books/published/foppff/sequences_the-slice-operator.html?mode=browsing)
* [8.7 Concatenation and Repetition](https://runestone.academy/ns/books/published/foppff/sequences_concatenation-and-repetition.html?mode=browsing)
* Feel free to read the other sections if you'd like to know about more operations

## Checks
Submit answers to the following on Moodle:
* What will the output be for the following code? (Checkpoint 8.10.1)
    ```python
    let = "z"
    let_two = "p"
    c = let_two + let
    m = c*5
    print(m)
    ```
* Write a program that extracts the last three items in the list `sports` and assigns it to the variable `last`. Make sure to write your code so that it works no matter how many items are in the list. (Checkpoint 8.10.2)
<script type="py-editor">
  sports = ['cricket', 'football', 'volleyball', 'baseball', 'softball',
     'track and field', 'curling', 'ping pong', 'hockey']
  last = #Your code here
  print(last) #should print ['curling', 'ping pong', 'hockey']
</script>