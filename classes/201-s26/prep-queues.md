---
layout: page
title: Queues Preparation
permalink: /classes/201-s26/queues-prep
---

## Overview
While lists are a good general linear structure, you don't always need all of the functionality and complexity of them. Today we are focused on a simpler, but vital, data structure: the queue.

## Basic Learning Objectives
Before class, you should be able to: 
* Explain what a queue is and how items are added and removed
* Identify the time complexity of a given queue implementation


## Advanced Learning Objectives
After class, you should be able to:
* Explain the efficiency concerns related to implementing a queue
* Explain how a linked queue works
* Use a queue to solve a problem


## Readings
You should read the following:

* [3.10 Queues](https://runestone.academy/ns/books/published/kotlinds/basic-ds_queues.html?mode=browsing)
* [3.11 The Queue ADT](https://runestone.academy/ns/books/published/kotlinds/basic-ds_the-queue-abstract-data-type.html?mode=browsing)
* [3.12 Implementing a Queue](https://runestone.academy/ns/books/published/kotlinds/basic-ds_implementing-a-queue.html?mode=browsing)
* [3.14 Printing Tasks](https://runestone.academy/ns/books/published/kotlinds/basic-ds_queue-simulation-printing-tasks.html?mode=browsing)



## Checks
Submit answers to the following on Moodle

1. (Self Check 3.12.1) Given the following queue operations:
```kotlin
val q = new Queue<>()
q.enqueue("hello")
q.enqueue("dog")
q.enqueue("cat")
q.dequeue()
```
What is the state of the queue from head to tail?

2. Given the implementations of `enqueue` and `dequeue` in section 3.12, explain why the time complexities are O(n) and O(1).
