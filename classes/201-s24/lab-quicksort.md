---
layout: page
title: Pivot Timing Lab
permalink: /classes/201-s24/quicksort-lab
published: true
---

## Goals
To study the performance characteristics of quicksort with several different pivot choices and hone your analysis skills.

## Setup
[Mount the COURSES drive](getting-started) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Download the [starter code](/classes/201-s24/QuicksortLabStarter.zip), move it into your STUWORK/username folder, and unzip it
* Open that folder through VSCode


## Exercise 1
There are a variety of different ways that the pivot can be selected in quicksort. In this investigation, you'll explore the consequences of the pivot selection method on quicksort's run time.

I've provided you with an implementation of quicksort in `Quicksort.java`. The public quicksort method takes in two arguments: an array of `int`s to sort and a `PivotSelector` instance. `PivotSelector` is an interface that I've provided that has one method: `choosePivotIndex`, which returns the **index** (not value!) of the `int` that we'll use as the pivot. Your job is to examine how variations in pivot selection impact run time for different arrays. I've included an example of how to collect timing data in `main` of `Quicksort.java`, and you'll update my code to collect the data that you want.

You should first compile everything and run the `Quicksort.java` file to see what it does.

a. How large of arrays are you initially testing with?

b. How many runs of the experiment are initially occurring? Note that the first round isn't being counted because it often takes longer due to setup.

c. Which pivot selection approaches are being tested?

d. How much of the array is being shuffled to start?

## Exercise 2

Let's first get a sense of how fast each of the approaches are with the current settings as the size of the array gets larger.  Record the averages for each at array size 1k, 10k, and 100k (on your worksheet). If you run the program again with the same size, how much variation do you get?

Plot the resulting values on the [Desmos calculator](https://www.desmos.com/calculator) (click the + and choose "table" to enter in your timing data points). Do some intermediate sizes to get a more complete curve if you'd like. (You can try going higher than 100k, but it might take a while to run.)

## Exercise 3
Now let's see what happens when the arrays are partially sorted. Adjust the argument to `shuffle` to be `arraySize/2` and try running your program again. If you get an error, try shortening the array back down to 1k or 10k. Based on those times, remove the pivot selector that you think might be causing the error and try with larger arrays again. (Mark "Error" in your table for any pivot selectors that can't handle a given array size.)

*To remove a pivot selector, just delete it from the `selectors` list and the `names` list.*

## Exercise 4
What happens if the array is completely sorted? Change the argument to `shuffle` to just be 0 and see what happens. How small of arrays do you need to sort to be able to run all the selectors?

## Extensions
Once you complete the above, adapt the starter code to test for the impact of the following:
* duplicate values
* reverse sorted arrays

Try also to come up with an initial ordering of the arrays that would particularly bad for Median of 3.

Another variation of Median of 3 is to actually sort the three values that you are comparing. Make a new pivot selector with that improvement and see how it compares.