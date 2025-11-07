---
layout: page
title: Heapsort Lab
permalink: /classes/201-f25/heapsort-lab
published: true
---

## Goals
To better understand heapsort by implementing it and possibly using it to implement replacement selection.

## Setup
Mount the COURSES drive and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HeapsortLab`
* Download the [starter code](/classes/201-f25/Heapsort.kt) and put it into your lab folder
* Open your `HeapsortLab` folder in VSCode

## Exercise 1
The first thing we'll need is to build the heap from a provided list. Implement the `buildHeap` method, keeping the following in mind:
* You want start with nodes near the bottom and move them down
* You should skip all the leaves, since they can't move down
* Think about what the index of the last parent is
* Note that I have provided `heapify` for you

Once you've implemented this one, run your code and make sure that the first thing printed is a correct max heap.

## Exercise 2
Next you'll need to implement `moveMax`. Try out writing your own test code to make sure that it works!

## Exercise 3
You're ready to implement `heapsort`! Note that it is outside of the `MaxHeap` class, why do you think that is?

The second provided test should now be sorted least to greatest.


## Extra
Try out implementing replacement selection:
* You'll need to make a new class for MinHeap
* Have `replacementSelection` take in lists to simulate the input buffer and output buffer
* Try out generating a few short runs and merging them



    