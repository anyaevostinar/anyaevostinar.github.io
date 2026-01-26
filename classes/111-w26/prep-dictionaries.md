---
layout: page
title: Dictionaries Preparation
permalink: /classes/111-w26/dictionaries-prep
---

## Overview
*Dictionaries* in programming are an extremely powerful tool when you want to associate two types of information together efficiently.
For example, being able to look up a person's phone number from their name.
Today is focused on the syntax and basic use of them, but you will learn lots more about them in future computer science classes!

## Basic Learning Objectives
Before class, you should be able to:
* Make a new dictionary
* Add *key-value pairs* to a dictionary
* Look up the value associated with a key

## Advanced Learning Objectives
After class, you should be able to:
* Use a dictionary to solve a programming problem
* Use the accumulator pattern with a dictionary

## Resources
You should readthe following (it's a slightly older version of the textbook that we've been using):
* [11.1 Introduction Dictionaries](https://runestone.academy/ns/books/published/fopp/Dictionaries/intro-DictionaryGoals.html?mode=browsing)
* [11.2 Getting Started with Dictionaries](https://runestone.academy/ns/books/published/fopp/Dictionaries/intro-Dictionaries.html?mode=browsing)
* [11.3 Dictionary Operations](https://runestone.academy/ns/books/published/fopp/Dictionaries/Dictionaryoperations.html?mode=browsing)
* [11.4 Dictionary Methods](https://runestone.academy/ns/books/published/fopp/Dictionaries/Dictionarymethods.html?mode=browsing)
* [11.6 Intro to Accumulating with a Dictionary](https://runestone.academy/ns/books/published/fopp/Dictionaries/intro-AccumulatingMultipleResultsInaDictionary.html?mode=browsing)
* [11.7 Accumulating with a Dictionary](https://runestone.academy/ns/books/published/fopp/Dictionaries/AccumulatingResultsFromaDictionary.html?mode=browsing)
* [11.8 Accumulating the Best Key](https://runestone.academy/ns/books/published/fopp/Dictionaries/AccumulatingtheBestKey.html?mode=browsing)
* [11.9 When to Use a Dictionary](https://runestone.academy/ns/books/published/fopp/Dictionaries/WPChoosingDictionaries.html?mode=browsing)

## Checks
Submit answers to the following on Moodle:
1. What will the following code print?
    ```python
    d = {'spring': 'autumn', 'autumn': 'fall', 'fall': 'spring'}
    print d['autumn']
    ```
2. In order to get the last line to print “success”, what should the value `x` (in the last line) be?
    ```python
    d = { 'work': 'success', 'success': 'failure', 'failure': 'money', 'time': 'work', 'industry': 'time'}
    print d[d[x]]
    ```
3. What does the following block of code do?
    ```python
    d =  {'a': 2, 'b': 3, 'c': 1}
    e = {}
    for c in d:
        e[d[c]] = c
    print(e)
    ```