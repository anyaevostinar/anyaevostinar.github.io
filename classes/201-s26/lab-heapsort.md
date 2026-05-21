---
layout: page
title: Heapsort Lab
permalink: /classes/201-s26/heapsort-lab
published: true
---

## Goals
To better understand heapsort by implementing it and possibly using it to implement replacement selection.

## Setup
Mount the COURSES drive and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Download the [starter code](/classes/201-s26/HeapsortLabStarter.zip), unzip it, and put it into your STUWORK folder
* Open your `HeapsortLabStarter` folder in VSCode

## Exercise 1
I've provided you a `MaxHeap` implementation, but it only has a `deleteMax`. For heapsort, you need to be able to move the max to the end of the array without deleting it.
Implement the `moveMax` function, which has a stub at the end of `MaxHeap`. Try out writing your own test code to make sure that it works!

## Exercise 2
You're ready to implement `heapsort`! Note that it is outside of the `MaxHeap` class, why do you think that is?

I've repeated the test lists to make sure that you are sorting correctly.

## Submission
You can submit your completed `MaxHeap` and `heapsort` to Moodle for an additional engagement credit.


## Extra
Try out implementing replacement selection:
* You'll need to make a new class for MinHeap (or grab the one from the reading or your previous lab)
* Have `replacementSelection` take in lists to simulate the input buffer and output buffer
* Try out generating a few short runs and merging them



    