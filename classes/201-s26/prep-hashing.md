---
layout: page
title: Hashing and Sets Preparation
permalink: /classes/201-f25/hashing-prep
---

## Overview
You've probably used the `Map` built-in data structure, and possibly a dictionary in Python, but how do these actually work? Today we'll be focusing on that magic that is hashing that leads to such amazing performance for hashmaps and dictionaries; we'll also think again about how implementation can influence performance of ADTs by thinking about sets.

## Basic Learning Objectives
Before class, you should be able to:
* Explain the high-level idea of hashing
* Give an example hash function for integers and strings
* Explain why collision resolution is necessary
* Describe the set ADT

## Advanced Learning Objectives
After class, you should be able to:
* Implement your own simple hash table
* Explain how implementation impacts the performance of a map or set

## Reading
You should read the following:

* [Runestone 5.5](https://runestone.academy/ns/books/published/pswadsup/sort-search_hashing.html?mode=browsing)
* [Sets ADT](https://brilliant.org/wiki/sets-adt/)

## Checks
Submit answers to the following.  Drawing out hash tables will be cumbersome so feel free to draw out your answers on a piece of paper or your choice of drawing app, take pictures or screenshots, and upload them to Moodle.


Suppose your keys are letter grades that have a `hashCode()` function where “A”=1, “A-” = 2, “B+” = 3, “B”=4, “B-”=5, “C+”=6...”F”=12 and then you use mod (remainder) of the hash table size to generate a hash index. Your hash table begins at size 5. 

1. Draw out the hash table after adding the following key-value pairs (key-> value): (“A” -> 4.0), (“A-” -> 3.667), (“B+” -> 3.333),(“B” -> 3.0), (“B-” -> 2.667). 
2. Suppose that collisions are resolved using chaining. Draw out the hash table after adding the following key-value pair: (C+ → 2.333). 
3. Suppose that collisions are resolved using chaining and you have a spot in the hash table with a linked list containing 3 items. If you resize the hash table, should you compute the new spot for the first item in the linked list and then copy the linked list to that spot in the new hash table? Explain why or why not.
