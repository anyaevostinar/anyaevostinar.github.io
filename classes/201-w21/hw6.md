---
layout: page
title: HW 6 Experiments with Quicksort
permalink: /classes/201-w21/hw6
---

## Logistics
25 points, due Friday Feb 19th by 10PM Central time. Like all assignments, there is a 48-hour, no questions asked extensions policy. If you have a tech issue, a health issue, or some other issue that impedes making the deadline, use this policy. You need to notify me that you're using the policy. Extensions beyond the 48-hour policy will only be considered in extenuating circumstances, and circumstances that arise between the original deadline and the extension are generally not extenuating - the deadline is still the deadline, not 48 hours later.

## Goals
To study the performance characteristics of quicksort with several different pivot choices and hone your analysis skills.

## Assignment Type and Collaborative Learning Expectations
This is a homework assignment that you'll be handing in on Moodle.

You're welcome to either complete this homework with input from one or more members of your collaborative learning group or to complete it on your own. You and the other members of your collaborative learning group should each write your own code and memo, even if you're helping one another, but you may share your screens to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

## Setup and Requirements
Open the HW 6 project on Repl.it. You should follow the same process of downloading your files and uploading them to Moodle to submit your homework. 

In this assignment, you'll be doing a mixture of coding, designing timing experiments, and analyzing your results. You'll be thinking through what timing data makes sense to collect, and writing your reasoning in a short report. You will need to create a PDF file with your report and upload it in addition to the zip of your code.

Create a file Collaborations.txt and put in any collaboration with your learning group or references to outside websites.

## Provided Code
There are a variety of different ways that the pivot can be selected in quicksort. In this investigation, you'll explore the consequences of the pivot selection method on quicksort's run time.

I've provided you with an implementation of quicksort in `Quicksort.java`. The public quicksort method takes in two arguments: an array of ints to sort and a `PivotSelector` instance. `PivotSelector` is an interface that I've provided that has one method: `choosePivotIndex`, which returns the index of the int that we'll use as the pivot. Your job is to examine how variations in pivot selection impact run time for different arrays. I've included an example of how to collect timing data in `main` of `Quicksort.java`, and you'll change or replace my code to collect the data that you want.

You should first compile everything and run the `Quicksort.java` file to see what it does.

## MedianOf3PivotSelector

Your first task is to implement a new `PivotSelector` named `MedianOf3PivotSelector` in its own `.java` file. It should return the index of the median of the first, middle, and last elements between indices `first` and `last` in the array.

## Experimenting

Now you should change the code in `main` of `Quicksort.java` to test all three pivot selector approaches on a variety of arrays, including those with:

* varying numbers of duplicate items
* varying amounts of sortedness (in both directions)
* varying lengths 

You can use many different array sizes to explore the questions in this assignment. Make sure the arrays you're choosing are big enough to show real differences. If all of your experiments take only 1 or 2 milliseconds, it will be very hard to understand how your variations are related to differences in timing. Instead, use an array that's big enough to take at least hundreds of milliseconds to sort.

## Memo

You should now write a 1-2 (single-spaced) page memo recommending which pivot selection method should be used and presenting evidence to support your position. Your evidence might include plots and/or tables of timing data. The page limit includes any charts and plots; it can be shorter as long as your communicate all of the needed information, it can also be longer if you would like.

Your memo should assume that average run time is the most important consideration, but if run times are similar, it might discuss other reasons to prefer or disprefer a particular method. The memo should at least briefly discuss whether the length of the array to sort influences which selection method to choose and whether characteristics of the numbers in the array or their initial ordering (e.g., many duplicates, degree of sortedness) impact which selection method to choose.

In your report, you should describe the timing experiments you performed and the data you collected. You should make sure to explain how the evidence you collected supports your claims, and explain your choices about what evidence to collect for each question. I encourage you to think carefully about how to connect evidence and explanations. Imagine your report is intended to help someone make decisions related to this investigation - what information do they need to know? Why do you think the timing data looks the way it does based on what you know about how the algorithm works? You should try to design your experiments in a way that will be convincing to the reader. How could you compensate for the fact that timing data is "noisy," with the same code sometimes taking a little longer or shorter to run? You're welcome to chat with me or with your collaborative learning about about your approach.

Your memo will be evaluated based on its clarity and how well you use evidence to support your claims, including whether you collected appropriate evidence for those claims. Your evidence collection will be evaluated based on your descriptions and by looking at the code you write in main to collect the evidence.

You must turn your memo into a PDF for submission.

## Grading
Here is how your assignment will be graded:

| Item | Points |
|-------|--------|
| Median of 3 pivot selector implemented correctly | 5 |
| Analyzed effect of length of array | 3 |
| Analyzed effect of initial ordering | 3 |
| Analyzed effect of duplicated | 3 |
| Analyzed effect of initial sortedness | 3 |
| Explains convinincingly why evidence supports the claim | 3 |
| Memo makes a recommendation of which pivot approach to use | 2 |
| Evidence presented clearly | 2 |
| Memo organized well | 1 |

## Extensions
There are lots of other ways of choosing a pivot, so if you are interested, you are welcome to implement more and test them as well.