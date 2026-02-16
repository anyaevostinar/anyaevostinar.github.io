---
layout: page
title: Recursion Preparation
permalink: /classes/111-w26/recursion-prep
---

<script type="module" src="https://pyscript.net/releases/2025.11.2/core.js"></script>

## Overview
Sometimes the most natural way to solve a problem is to first solve smaller versions of the same problem and then build on that solution.
As strange as it might seem, in Python functions are allowed to call themselves to accomplish just this sort of problem-solving approach.
This is called *recursion* and it can be a bit tricky to wrap your head around at first.

## Basic Learning Objectives
Before class, you should be able to:
* Explain the high-level idea of recursion
* Explain how a function can call itself
* Explain what a *base case* is

## Advanced Learning Objectives
After class, you should be able to:
* Write a recursive function to solve a problem

## Reading
You should read/watch the following:
* [PythonDS3 4.2 What Is Recursion?](https://runestone.academy/ns/books/published/pythonds3/Recursion/WhatIsRecursion.html?mode=browsing)
* [PythonDS3 4.3 Calculating the Sum of a List of Numbers](https://runestone.academy/ns/books/published/pythonds3/Recursion/CalculatingtheSumofaListofNumbers.html?mode=browsing)
* [PythonDS3 4.4 The Three Laws of Recursion](https://runestone.academy/ns/books/published/pythonds3/Recursion/TheThreeLawsofRecursion.html?mode=browsing)
* [PythonDS3 4.7 Visualizing Recursion](https://runestone.academy/ns/books/published/pythonds3/Recursion/VisualizingRecursion.html?mode=browsing)

## Checks
Submit answers to the following to Moodle:
1. Suppose you are going to write a recursive function to calculate the factorial of a number. `fact(n)` returns `n * n-1 * n-2 * …` Where the factorial of zero is defined to be 1. What would be the most appropriate base case?
2. Write a recursive function `reverse_list(lst)` that given a list `lst`, returns a new list with the order of elements in `lst` reversed. For example, `reverse_list(['a','b','c'])` should return `['c','b','a']`. Hint: Take the first element, reverse the remaining list and put the first element to the end of the new list and return.
    <script type="py-editor">
    def reverse_list(lst):
        # Your recursive code here
    def main():
        print(reverse_list(['a','b','c']))
        #should print ['c', 'b','a']
    main()
    </script>  