---
layout: page
title: Linked Lists Preparation
permalink: /classes/201-f25/linkedlist-prep
---

## Overview
You've worked with lists a lot by using built-in functionality, but how do those built-in lists actually work? Today, we'll be focusing on one way to implement the unordered list ADT: linked lists.

## Basic Learning Objectives
Before class, you should be able to: 
* Explain what a list is
* Explain what the unordered list ADT is
* Explain the general idea of a linked list


## Advanced Learning Objectives
After class, you should be able to:
* Implement a basic linked list in Kotlin


## Readings
Read the following (again, there is some Python, but focus on the ideas):

* [3.19 Lists](https://runestone.academy/ns/books/published/pswadsup/basic-ds_lists.html?mode=browsing)
* [3.20 Unordered List ADT](https://runestone.academy/ns/books/published/pswadsup/basic-ds_the-unordered-list-abstract-data-type.html?mode=browsing)
* [3.21 Implementing an Unordered List: Linked Lists](https://runestone.academy/ns/books/published/pswadsup/basic-ds_implementing-an-unordered-list-linked-lists.html?mode=browsing)

## Checks
Submit answers to the following on Moodle. Feel free to draw out your linked lists on paper and upload a picture.

![diagram of linked list](/classes/201-f25/linkedListDiagram.png)

1. Given the singly linked list above, what will the linked list look like if the node `“Great Hall will be on your left”` is inserted at the end of the list?
2. What do you think is the Big-O time complexity of  `insertAtEnd()`? Why? 
3. Given the singly linked list from Q1, what will the linked list look like if the first node `“Turn right on 1st E”` is removed?
4. What do you think is the Big-O time complexity of  `removeFirstNode()`? Why? 
5. Compare the [Singly Linked List Implementation](https://github.com/dmusican/cs201f24share/blob/main/code-for-readings/src/main/kotlin/LinkedStack.kt) and the [List Implementation](https://github.com/dmusican/cs201f24share/blob/main/code-for-readings/src/main/kotlin/Stack.kt) of a Stack. What are some similarities and differences across both the implementations?



## Acknowledgements
The check questions and diagram are from Prof Jean Salac.