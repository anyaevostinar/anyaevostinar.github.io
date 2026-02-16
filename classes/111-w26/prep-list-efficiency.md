---
layout: page
title: List and Dictionary Efficiency Preparation
permalink: /classes/111-w26/list-efficiency-prep
---

## Overview
When storing data, the two main structures that you've seen so far are lists and dictionaries.
We've mentioned previously how lists are slow for finding items and dictionaries are fast. 
While we won't get into exactly how dictionaries are so fast, we will look today at what algorithm analysis can tell us about common list operations.

## Basic Learning Objectives
Before class, you should be able to:
* Compare lists and dictionaries efficiency for their common operations
* Identify which tasks lists or dictionaries are more efficient at

## Advanced Learning Objectives
After class, you should be able to:
* Explain why lists in Python have the time efficiency that they do for indexing and `contains`
* Evaluate when you should use a list versus a dictionary to solve a problem based on the time efficiency

## Resources
Read the following:
* [PythonDS3 2.5. Performance of Python Data Structures](https://runestone.academy/ns/books/published/pythonds3/AlgorithmAnalysis/PerformanceofPythonDataStructures.html?mode=browsing)
* [PythonDS3 2.6 Lists](https://runestone.academy/ns/books/published/pythonds3/AlgorithmAnalysis/Lists.html?mode=browsing)
* [PythonDS3 2.7 Dictionaries](https://runestone.academy/ns/books/published/pythonds3/AlgorithmAnalysis/Dictionaries.html?mode=browsing)

## Checks
Submit answers to the following:
1. Which of the list operations shown below is not O(1) and why?
    * `a_list.pop(0)`
    * `a_list.pop()`
    * `a_list.append()`
    * `a_list[10]`
2. Which of the dictionary operations shown below are O(1)?
    * "x" in a_dict
    * del a_dict["x"]
    * a_dict["x"] == 10
    * a_dict["x"] = a_dict["x"] + 1