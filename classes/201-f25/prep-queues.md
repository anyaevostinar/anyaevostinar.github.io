---
layout: page
title: Queues Preparation
permalink: /classes/201-f25/queues-prep
---

## Overview
While lists are a good general linear structure, you don't always need all of the functionality and complexity of them. Today we are focused on a simpler, but vital, data structure: the queue.

## Basic Learning Objectives
Before class, you should be able to: 
* Explain what a queue is and how items are added and removed
* Define FIFO


## Advanced Learning Objectives
After class, you should be able to:
* Explain the efficiency concerns related to implementing a queue
* Explain how a circular queue works
* Explain how a linked queue works


## Readings
You should read the following:

* [3.10 Queues](https://runestone.academy/ns/books/published/pswadsup/basic-ds_queues.html?mode=browsing)
* [3.11 The Queue ADT](https://runestone.academy/ns/books/published/pswadsup/basic-ds_the-queue-abstract-data-type.html?mode=browsing)
* [3.14 Printing Tasks](https://runestone.academy/ns/books/published/pswadsup/basic-ds_queue-simulation-printing-tasks.html?mode=browsing)



## Checks
Submit answers to the following on Moodle, given this [Kotlin Queue Implementation](https://github.com/dmusican/cs201f24share/blob/main/code-for-readings/src/main/kotlin/Queue.kt):

![Diagram of a queue](/classes/201-f25/queue.png)

* `dequeue()` is called on the Queue above. 
    1. What does the Queue look like now? (i.e. Which elements are in which index?)
    2. Which index is `front` pointing to?
    3. Which index is rear pointing to?
* `enqueue("Nick")` is next called on the Queue.
    1. What does the Queue look like now? (i.e. Which elements are in which index?)
    2. Which index is front pointing to?
    3. Which index is rear pointing to?

## Acknowledgements
The check questions and diagram are from Prof Jean Salac.