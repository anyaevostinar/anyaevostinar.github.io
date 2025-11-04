---
layout: page
title: Homework 8 - Sorting
permalink: /classes/201-f25/hw8
---

**Due Monday Nov 17th at 10pm**

* Starter file: none  
* Upload (hand-written!) solutions via Gradescope

## Goals

This assignment is designed to help you with the following:
* practice with sorting algorithms
* practice thinking about performance of sorting algorithms

## Collaboration policy

For this assignment, you may work alone or with a partner, but you must write up all of your answers yourself.  (It is therefore unexpected for two submissions to be completely identical.)  You may have at most one partner.

You may also discuss the assignment at a high level with other students.  You can discuss the assignment with Anya, our prefect, or any course staff.

You should list any student or course staff with whom you discussed the assignment (you don't have to include prefect sessions), and the manner of discussion (high level, partner, etc.) in the reflection at the end of the assignment.

_If you work alone, you should say so instead._

## Assessment

The **core requirements** for your submission are:

* correctly answer questions 1-3
* include a reflection at the end of your assignment

The **advanced requirements** for your submission are:

* satisfy the core requirements
* give thorough and correct explanations for questions 4-6
* include your collaboration statement in your response to the last question of the assignment 

Note that there won't be an opportunity to revise this assignment through the normal process. Instead, you will be able to answer questions on the self-scheduled final if you need to revise.

## Assignment overview

The questions for this assignment are listed below.  This is assignment does not require you to write any code.

This assignment needs to be written in your own handwriting (not typed). You can complete it on paper or on a tablet, but it must be hand-written (life in the age of LLMs).  You will need to submit a PDF to Gradescope, and make sure to select the regions in your PDF that correspond to each solution -- be sure to keep your answers somewhat separated from each other.

You should always assume that the list should sort from least to greatest.

## Core questions

Complete the following questions for the core requirements.

### #1: Mergesort trace

On paper, sort the sequence of numbers 3, 1, 4, 1, 5, 9, 2, 6 using Mergesort.  Be sure to show your work.

### #2: Quicksort trace

On paper, sort the sequence of numbers 3, 1, 4, 1, 5, 9, 2, 6 using Quicksort.  Assume you always select the pivot as the first element in the subarray, and be sure to show your work.

### #3: Heapsort trace

On paper, sort the sequence of numbers 3, 1, 4, 1, 5, 9, 2, 6 using Heapsort.  Assume you always select the pivot as the first element in the subarray, and be sure to show your work.

Don't forget to build the initial heap using the `buildHeap` procedure we discussed in class!



## Advanced questions

Additionally, complete the following questions for the advanced requirements.

### #4: Quicksort pivot

The choice of pivot for Quicksort can dramatically affect its performance.  Some common choices, relative to a given subarray, are:

* the first element by position
* the middle element by position
* a randomly selected element
* the median element by value
* the median element of the first three elements

Comment on each of the above choices.  What are the pros and cons of each?  Under what situations are they good or bad ideas? You should include at least 2 sentences for each choice, clearly labeled.

### #5: Mergesort temp array

Look at this [sample Mergesort code](https://www.cs.carleton.edu/faculty/tamert/courses/cs201-s25/resources/samples/Mergesort.kt) that was based on one of our readings.

Note that it passes in a temporary list as a parameter to the recursion instead of creating a temporary list inside the `_mergesort` function.

Explain why using a single temporary array, as in the sample code, can be argued to be an improvement over declaring one locally, either in terms of amount of memory needed, speed, or both.

### #6: Fast sort

Suppose that you have an array of `n` elements, containing only two distinct keys, _true_ and _false_.  Give an O(n) algorithm to rearrange the list so that all _false_ elements precede the _true_ elements.  You may only use constant extra space.

# Reflection

Were there any particular issues or challenges you dealt with in completing this assignment?  How long did you spend on this assignment?

Write a brief discussion (a sentence or two is fine) at the end of your assignment writeup.

Here are some examples:

* Reflection:
>>
>>I had forgot to swap the pivot into place in Quicksort, so I had to redo #2 a few times.
>>
>>I had to refer to my notes to remember how to make a heap from an array
>>
>>I spent 6 hours on this assignment.

* Reflection:
>>
>>I started late, so I had to rush my explanations.
>>
>>I really don't understand the difference in #5.  I should probably go to office hours.
>>
>>I spent 5 hours on this assignment.

* Reflection:
>>
>>This went fine; I forgot how the pivot worked in Quicksort but I found it in my notes.
>>
>>I spent 3.5 hours on this assignment.

&nbsp;