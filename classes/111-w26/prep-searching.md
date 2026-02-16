---
layout: page
title: Searching Algorithms Preparation
permalink: /classes/111-w26/searching-prep
---

## Overview
You've frequently used Python's built-in functionality for searching for an item in a list, but how does that actually work? What if the list is already sorted; can you search faster then?
Today's focus will be on two algorithms used for finding an item in unsorted and sorted lists.

## Basic Learning Objectives
Before class, you should be able to:
* Explain the idea of sequential searching
* Explain the high-level idea of binary search

## Advanced Learning Objectives
After class, you should be able to:
* Implement sequential search
* Identify the time complexity of sequential searching in the worst case
* Implement recursive binary search
* Identify when to use sequential vs. binary search

## Resources
You should read the following:
* [PythonDS3 5.2 Searching](https://runestone.academy/ns/books/published/pythonds3/SortSearch/searching.html?mode=browsing)
* [PythonDS3 5.3 The Sequential Search](https://runestone.academy/ns/books/published/pythonds3/SortSearch/TheSequentialSearch.html?mode=browsing)
* [PythonDS3 5.4 The Binary Search](https://runestone.academy/ns/books/published/pythonds3/SortSearch/TheBinarySearch.html?mode=browsing)
* Optional, but since some of you where interested in hashing: [PythonDS3 5.5 Hashing](https://runestone.academy/ns/books/published/pythonds3/SortSearch/Hashing.html?mode=browsing)

## Checks
Submit answers to the following on Moodle:
1. Suppose you are doing a sequential search of the list `[15, 18, 2, 19, 18, 0, 8, 14, 19, 14]`. How many comparisons would you need to do in order to find the key 18?
2. Suppose you are doing a sequential search of the ordered list `[3, 5, 6, 8, 11, 12, 14, 15, 17, 18]`. How many comparisons would you need to do in order to find the key 13?
3. Suppose you have the following sorted list [3, 5, 6, 8, 11, 12, 14, 15, 17, 18] and are using the recursive binary search algorithm. What is the sequence of numbers that `item` will be compared to? Hint, the first number is `12`.