---
layout: page
title: Pivot Timing Lab
permalink: /classes/201-f25/quicksort-lab
published: true
---

## Goals
To study the performance characteristics of quicksort with several different pivot choices and hone your analysis skills.

## Setup
[Mount the COURSES drive](scavenger-hunt) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Download the [starter code](/classes/201-f25/QuicksortLabStarter.zip), move it into your STUWORK/username folder, and unzip it
* Open that folder through VSCode

Note: this lab is all in Java since there is a lot and some of it relies on Java libraries for timing. You won't be writing any Java, don't worry!


## Exercise 1
There are a variety of different ways that the pivot can be selected in quicksort. In this investigation, you'll explore the consequences of the pivot selection method on quicksort's run time.

I've provided you with an implementation of quicksort in `Quicksort.java`. The public quicksort method takes in two arguments: an array of `int`s to sort and a `PivotSelector` instance. `PivotSelector` is an interface that I've provided that has one method: `choosePivotIndex`, which returns the **index** (not value!) of the `int` that we'll use as the pivot. Your job is to examine how variations in pivot selection impact run time for different arrays. All the code for running the analysis is included, you will just be changing the values of variables on lines 156-168.

You should first compile everything and run with:
```bash
javac *.java
java Quicksort
```

Which should give you approximately the output (your numbers will vary slightly, why is that?):

```bash
First index: 0.05
Random index: 0.12
Median of First 3 index: 0.06
Middle index: 0.02
```

## Exercise 2
You'll be changing only specific values of the code, so let's look at those. I have marked with comments where each of these things are, so go find them:

a. How large of arrays are you initially testing with?

b. How many runs of the experiment are initially occurring? Note that the first round isn't being counted because it often takes longer due to setup, so I'm running numRuns + 1.

c. Which pivot selection approaches are being tested?

d. How much of the array is being shuffled to start?

## Exercise 3
Now let's get a sense of how fast each of the approaches are with the current settings as the size of the array gets larger.  Record the averages for each at array size 1k, 10k, and 100k (on your worksheet). If you run the program again with the same size, how much variation do you get?

Plot the resulting values on the [Desmos calculator](https://www.desmos.com/calculator) (click the + and choose "table" to enter in your timing data points). Do some intermediate sizes to get a more complete curve if you'd like. (You can try going higher than 100k, but it might take a while to run.) If anything takes longer than a minute to run, you should stop it with `Ctrl-C`.

## Exercise 4
Now let's see what happens when the arrays are partially sorted. Adjust the argument to `shuffleEnd` to be `arraySize/2` and try running your program again. If you get an error or it takes a really long time, try shortening the array back down to 1k or 10k. Based on those times, remove the pivot selector that you think might be causing the error and try with larger arrays again. (Mark "Error" in your table for any pivot selectors that can't handle a given array size.)

*To remove a pivot selector, just delete it from the `selectors` list and the `names` list.*

## Exercise 5
What happens if the array is completely sorted? Change the argument to `shuffleEnd` to just be 0 and see what happens. How small of arrays do you need to sort to be able to run all the selectors?

## Extra
Even though the lab is in Java, you can take a shot at making some of these small changes.
Once you complete the above, adapt the starter code to test for the impact of the following:
* duplicate values
* reverse sorted arrays

Try also to come up with an initial ordering of the arrays that would particularly bad for Median of First 3.

Another variation of Median of 3 is to actually sort the three values that you are comparing. Make a new pivot selector with that improvement and see how it compares.