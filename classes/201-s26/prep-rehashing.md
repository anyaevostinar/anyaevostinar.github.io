---
layout: page
title: Rehashing Preparation
permalink: /classes/201-s26/rehashing-prep
---

## Overview
There are many many ways of dealing with collisions in hash tables. Today, we'll be thinking about several possible approaches and comparing their strengths and weaknesses.

## Basic Learning Objectives
Before class, you should be able to:
* Describe at a high-level what double hashing is
* Describe the idea of Cuckoo Hashing

## Advanced Learning Objectives
After class, you should be able to:
* Choose a hash function and collision resolution technique appropriate to a problem
* Implement Cuckoo Hashing

## Reading
You should read the following:
* [Open Addressing](https://www.geeksforgeeks.org/dsa/open-addressing-collision-handling-technique-in-hashing/) - Some repetition from the previous prep, focus on the table comparing chaining and open addressing
* [Visualization of Cuckoo Hashing](https://studwww.itu.dk/~maau/teaching/visualisation/cuckoo-hashing/index.html)

## Checks
Submit answers to the following on Moodle.  Drawing out hash tables will be cumbersome so feel free to draw out your answers on a piece of paper or your choice of drawing app, take pictures or screenshots, & put them on Moodle.

* Suppose you are using double hashing for collision resolution. Suppose your keys are letters that have a `hashCode()` function where “a”=1, “b” = 2, “c” = 3,…”z”=26 and then you use mod (remainder) of the hash table size to generate a hash index. Your hash table begins at size 11. Your second hashing function is `1 + (hashCode() mod 7`.
    * Draw the hash table after you add the following key-value pairs of letter counts (letter → number of occurrences for that letter): (“a” → 3), (“k” → 2), (“l” → 17), (“g” → 7)
    * Say I want to add (“j” → 10). Which entries do I look through in the hash table? What will the hash table look like after I make this call?
* In the Cuckoo Hashing visualization, describe what happens when `e` is added.

