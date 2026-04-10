---
layout: page
title: Arrays and Linked Lists Preparation
permalink: /classes/201-s26/linkedlist-prep
---

## Overview
You've worked with lists a lot by using built-in functionality and previously learned about arrays. However, there is another way of implementing a list. Today, we'll be focusing on this other way to implement the unordered list ADT: linked lists.

## Basic Learning Objectives
Before class, you should be able to: 
* Explain what the unordered list ADT is
* Explain the general idea of a linked list
* Implement adding to the beginning or end of a linked list
* Explain how to traverse through a linked list


## Advanced Learning Objectives
After class, you should be able to:
* Explain the pros and cons of linked lists and arrays
* Implement advanced functionality in a linked list
* Use an array or linked list to solve a given problem


## Readings
Read the following (again, there is some Python, but focus on the ideas):

* [3.19 Lists](https://runestone.academy/ns/books/published/kotlinds/basic-ds_lists.html?mode=browsing)
* [3.20 Unordered List ADT](https://runestone.academy/ns/books/published/kotlinds/basic-ds_the-unordered-list-abstract-data-type.html?mode=browsing)
* [3.21 Implementing an Unordered List: Linked Lists](https://runestone.academy/ns/books/published/kotlinds/basic-ds_implementing-an-unordered-list-linked-lists.html?mode=browsing)

## Checks
Submit answers to the following on Moodle. Feel free to draw out your linked lists on paper and upload a picture.

Here is Figure 3.22.5 from the reading:

![A linked list diagram with boxes and arrows](https://runestone.academy/ns/books/published/kotlinds/external/BasicDS/Figures/node2.png)

1. Draw a linked list with boxes and arrows (like Figure 3.22.5 above) after the following sequence of operations (you may show intermediate steps, but you only need to show the final state of the list):
```kotlin
val exampleList = LinkedUnorderedList<String>()
exampleList.addFirst("cat")
exampleList.addFirst("dragon")
exampleList.addFirst("pigeon")
exampleList.remove("dragon")
```

2. Complete the `addLast` method of the `LinkedUnorderedList<T>` below. What is the time complexity of your implementation? Can you get it to be O(1)?

<iframe src="https://pl.kotl.in/Hngo13JB6" width="700" height="700"></iframe>
