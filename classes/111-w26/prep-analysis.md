---
layout: page
title: Algorithm Analysis Preparation
permalink: /classes/111-w26/analysis-prep
---

## Overview
So far in class we've talked generally about some things being *slow* like looking for an item in a list, but we haven't been very precise about what that means.
We want a way to be able to compare between different approaches to solving a problem to see which might be better.
Better can mean a lot of things, but today we're going to focus on how to compare two algorithms based on how *fast* they will solve the same problem using "Big-O" analysis.

## Basic Learning Objectives
Before class, you should be able to:
* Explain what *benchmark analysis* is
* Explain what *Big-O notation* is and why is is needed over benchmark analysis
* Define *best case* and *worse case* at a high-level

## Advanced Learning Objectives
After class, you should be able to:
* Determine which of the common order of magnitude functions a simple program falls into

## Resources
You should read the following (new book!):
* [PythonDS3 2.2 What Is Algorithm Analysis?](https://runestone.academy/ns/books/published/pythonds3/AlgorithmAnalysis/WhatIsAlgorithmAnalysis.html?mode=browsing)
* [PythonDS3 2.3 Big O Notation](https://runestone.academy/ns/books/published/pythonds3/AlgorithmAnalysis/BigONotation.html?mode=browsing)
* [PythonDS3 2.4 An Anagram Detection Example](https://runestone.academy/ns/books/published/pythonds3/AlgorithmAnalysis/AnAnagramDetectionExample.html?mode=browsing)

These are from the new book that we are using, *Problem Solving with Algorithms and Data Structures using Python by Brad Miller and David Ranum*.

## Checks
Submit answers to the following on Moodle:
1. Given the following code fragment, what is its Big O running time?
    ```python
    test = 0
    for i in range(n):
        for j in range(n):
            test = test + i * j
    ```
2. Given the following code fragment, what is its Big O running time?
    ```python
    test = 0
    for i in range(n):
        test = test + 1

    for j in range(n):
        test = test - 1
    ``` 
3. Given the following code fragment, what is its Big O running time?
    ```python
    i = n
    while i > 0:
        k = 2 + 2
        i = i // 2
    ```