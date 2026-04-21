---
layout: page
title: Hashing and Sets Preparation
permalink: /classes/201-s26/hashing-prep
---

## Overview
You've probably used the `Map` built-in data structure, and possibly a dictionary in Python, but how do these actually work? Today we'll be focusing on the magic that is hashing that leads to such amazing performance for hashmaps, dictionaries, and sets.

## Basic Learning Objectives
Before class, you should be able to:
* Describe the Set and Map ADTs
* Explain the high-level idea of hashing
* Give an example hash function for integers and strings
* Explain why collision resolution is necessary

## Advanced Learning Objectives
After class, you should be able to:
* Implement your own simple hash table
* Explain how implementation impacts the performance of a map or set
* Describe when a hash table should be used to solve a problem

## Reading
You should read the following:

* [6.2 The Map and Set ADTs](https://runestone.academy/ns/books/published/kotlinds/map_ADT.html?mode=browsing)
* [6.3 Implementing a Map and Set with a List](https://runestone.academy/ns/books/published/kotlinds/listmap.html?mode=browsing)
* [6.4 Hashing](https://runestone.academy/ns/books/published/kotlinds/sort-search_hashing.html?mode=browsing)

## Checks
Submit answers to the following to Moodle. You'll want to reference this abbreviated [ASCII chart](/classes/201-s26/ascii) for these exercises.

### Check 1
Suppose I have three hash functions for strings:
1. `hashCode1` uses the ASCII value of the first character of a given string for the hash code.
2. `hashCode2` uses the sum of the ASCII values of all the characters in the string for the hash code.
3. `hashCode3` uses the sum of the ASCII values of the characters in the string, but weights them by the position of the character in the string (so the first value is multiplied by 1, the second value is multiplied by 2, etc.)

Fill in the table for the hash codes for each string (definitely use a calculator!):

| |hashCode1| hashCode2 | hashCode3|
|-----|-----|-----|----|
| `ant` |    |  | |
| `tan` | | | |
| `mop` | | | |
| `tin` | | | |

### Check 2
Imagine you have a hash table of size 5 and are using an open addressing collision resolution process with linear probing. Draw out the hash table after adding each of the strings above with each of the hashcodes (so draw three tables total). 

### Check 3
What is the source of collisions for each hashcode in Exercise 2? Could they be avoided?
