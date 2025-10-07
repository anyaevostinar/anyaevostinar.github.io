---
layout: page
title: Rehashing Preparation
permalink: /classes/201-f25/rehashing-prep
---

## Overview
There are many many ways of dealing with collisions in hash tables. Today, we'll be thinking about what to do when the hash table needs to be completely redone.

## Basic Learning Objectives
Before class, you should be able to:
* Describe at a high-level what rehashing is
* Explain the idea of a load factor

## Advanced Learning Objectives
After class, you should be able to:
* Analyze the pros and cons of each collision resolution technique
* Implement a specific kind of hash table

## Reading
You should read the following:
* [Introduction to Hashing](https://www.geeksforgeeks.org/introduction-to-hashing-2/)
* [Open Addressing](https://www.geeksforgeeks.org/dsa/open-addressing-collision-handling-technique-in-hashing/)

## Checks
Submit answers to the following on Moodle.  Drawing out hash tables will be cumbersome so feel free to draw out your answers on a piece of paper or your choice of drawing app, take pictures or screenshots, & put them on Moodle.

* Suppose you are using linear probing for collision resolution. Suppose your keys are letters that have a `hashCode()` function where “a”=1, “b” = 2, “c” = 3,…”z”=26 and then you use mod (remainder) of the hash table size to generate a hash index. Your hash table begins at size 7. 
    * Draw the hash table after you add the following key-value pairs of letter counts (letter → number of occurrences for that letter): (“a” → 3), (“b” → 2), (“n” → 17), (“g” → 7)
    * Say I want to add (“j” → 10). Which entries do I look through in the hash table? What will the hash table look like after I make this call?
* Consider the double hashing technique to resolve collisions. What value must `hash2(x)` never return for double hashing to be effective?

