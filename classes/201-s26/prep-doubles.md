---
layout: page
title: Doubles Preparation
permalink: /classes/201-f25/doubles-prep
---

## Overview
There are a lot of variations on the linear data structures that we've thought about so far. Today, we'll focus on two that give us some helpful additional functionality: double-ended queues ("deques" pronounced "decks") and doubly-linked lists.

## Basic Learning Objectives
Before class, you should be able to: 
* Describe what a doubly-linked list is
* Describe what a double-ended queue is


## Advanced Learning Objectives
After class, you should be able to:
* Describe the steps of each doubly-linked list operation
* Describe the steps of each double-ended queue operation
* Explain the time complexity of each operation

## Readings
Read the following:

* [3.15 Deques](https://runestone.academy/ns/books/published/pswadsup/basic-ds_deques.html?mode=browsing)
* [3.16 Deque ADT](https://runestone.academy/ns/books/published/pswadsup/basic-ds_the-deque-abstract-data-type.html?mode=browsing)
* [Doubly Linked List](https://www.guru99.com/doubly-linked-list.html)


## Checks
Submit answers to the following on Moodle. For the following questions, compare the [Double-Ended Queue](https://github.com/dmusican/cs201f24share/blob/main/code-for-readings/src/main/kotlin/Deque.kt), [Singly-Linked List](https://github.com/dmusican/cs201f24share/blob/main/code-for-readings/src/main/kotlin/SinglyLinkedList.kt), [Queue](https://github.com/dmusican/cs201f24share/blob/main/code-for-readings/src/main/kotlin/Queue.kt) implementations in Kotlin.

1. Which double-ended queue operation and Singly-Linked List operation perform the same task as the Queue `enqueue()` operation? 
2. What is the Big-O time complexity of the Queue `enqueue()` operation? Of its analogous Double-Ended Queue and Singly-Linked List operations?
3. Which Double-Ended Queue operation and Singly-Linked List operation perform the same task as the Queue `dequeue()` operation?
4. What is the Big-O time complexity of the Queue `dequeue()` operation? Of its analogous Double-Ended Queue and Singly-Linked List operations?
5. Between the [Queue](https://github.com/dmusican/cs201f24share/blob/main/code-for-readings/src/main/kotlin/Queue.kt) and [Double-Ended Queue](https://github.com/dmusican/cs201f24share/blob/main/code-for-readings/src/main/kotlin/Deque.kt) implementations, which one do you think takes up more space in memory? Why? 
    * Hint: Consider the variables and their respective types used in each implementation. You can see how much space each type takes in the [Kotlin documentation](https://kotlinlang.org/docs/basic-types.html).


## Acknowledgements
The check questions and diagram are from Prof Jean Salac.