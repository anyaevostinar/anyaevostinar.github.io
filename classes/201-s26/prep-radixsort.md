---
layout: page
title: Radix Sort Preparation
permalink: /classes/201-f25/radix-sort-prep
---

## Overview
Bonus day! I've said a few times that O(n log n) is the best we can do for "normal" space complexity sorting. It turns out that we can do better if we are willing to use some extra space in special situations.

First some additional background for the reading:
* Remember that Big-O/Big-Oh is the upper-bound time complexity, i.e. the maximum amount of time it will take to solve a problem
* Ω ("big-Omega" or just "Omega") is the lower-bound time complexity, i.e. the minimum amount of time it will take to solve a problem
* Θ ("big-Theta") means that the upper-bound and lower-bound are in the same class of functions, i.e. if an algorithm is both O(n) and Ω(n), then it is Θ(n). (Much of the time we've actually been talking about the Θ(), but we didn't worry about that detail.)

Remember that today is mostly just for curiosity, so don't stress too much!

## Basic Learning Objectives
Before class, you should be able to:
* Explain the general idea of binsort and radix sort

## Advanced Learning Objectives
After class, you should be able to:
* Explain the tradeoffs with binsort and radix sort
* Start on an implementation of radix sort

## Reading
You should read the following:
* [OpenDSA 13.13 Binsort](https://opendsa-server.cs.vt.edu/OpenDSA/Books/Everything/html/BinSort.html)
* [OpenDSA 13.14 Radix Sort](https://opendsa-server.cs.vt.edu/OpenDSA/Books/Everything/html/RadixSort.html)

Optional, if you are curious why we know we can't really do much better than O(n log n): [Lower Bounds for Sorting](https://opendsa-server.cs.vt.edu/OpenDSA/Books/Everything/html/SortingLowerBound.html)

## Checks
Submit an answer to the following:
* Have you ever used Binsort to sort a bunch of papers? Think you will now?


