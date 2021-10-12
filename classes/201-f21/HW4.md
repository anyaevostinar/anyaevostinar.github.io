---
layout: page
title: HW 4 Country Sorter List
permalink: /classes/201-f21/hw4
---

## Logistics
30 points, due Friday, Oct 15th by 10PM. Like all assignments, there is a 48-hour, no questions asked extensions policy. If you have a tech issue, a health issue, or some other issue that impedes making the deadline, use this policy.  You or your partner need to notify me that you're using the policy via email, CC'ing the partner. Extensions beyond the 48-hour policy will only be considered in extenuating circumstances, and circumstances that arise between the original deadline and the extension are generally not extenuating - the deadline is still Friday, not 48 hours later.

## Goals
To gain a better understanding of linked lists by implementing one that inserts values into sorted positions and maintains forward and backward pointers.

## Assignment Type and Collaborative Learning Expectations
This is a homework assignment that you'll be handing in on Moodle.

You must work on this homework with your assigned partner (if you have one) via pair programming. That means that you cannot write **any** code without your partner and you must both be fully engaged and discussing the code at all times while working. See the [collaboration policy](collaboration) for details.

## Setup and Requirements
Mount COURSES, download the [HW4 starter code](HW4Starter.zip) and move it to your StuWork/username folder. You should follow the same process of compressing your files and uploading them to Moodle to submit your homework. 

Create a file `Collaborations.txt` and put in any help that you get on this assignment including sources that you reference and help from lab assistants or the prefect. Make sure to refer to the [Collaboration page](collaboration) on what collaborations are allowed for homework assignments.

The code that you write for this assignment will build on top of the `Country` class that you worked with previously.
I've provided my own version of it and the boilerplate code for reading in from a file and creating a `Country`.

## Specification
For this assignment, you'll make a new class, `CountrySorterList` that consists of a linked list that adds items in sorted order according to a previously set indicator and is able to provide the user with the minimum and maximum countries for the given indicator. 

### Comparator
If you were thinking after the Country Stats Displayer assignment that there has got to be a better way of sorting, you are right! 
In Java, there is an interface called the `Comparator` that focuses on allowing two objects of the same type to be compared easily.
This is slightly different than the `Comparable` interface discussed and used in the book because it doesn't assume that the class has an inherent order, and instead orders the objects of the class based on the user specified `indicator`.
First you will create a comparator that will then be stored in your linked list later.

Create a new class `CountryComparator` that implements the `Comparator` interface for Country:
```
public class CountryComparator implements Comparator<Country> {
```

This class will consist of just two methods: 1) a constructor, and 2) the `compare` method that is required for a `Comparator`.

#### Constructor
Your comparator needs to store the indicator that it compares by.
Create that instance variable and a constructor that takes in a value for indicator and sets the instance variable.

#### compare method
Next create a method `compare` that takes two `Country` objects as parameters. 
The `Comparator`'s `compare` method works similarly to the `Comparable` interface in that for two objects `a` and `b`, it returns:

*  -1 if `a` comes before `b`, 
* 0 if `a` and `b` could be in either order, and 
* 1 if `b` comes before `a`.

Your `compare` method should work the same based on the indicator chosen by the constructor. 

You should test your `CountryComparator` by making a new one in the `main(String[] args)` method of `CountryComparator.java` with some test `Country` objects.

### CountrySorterList
Now that you have an object for comparing two countries, let's make a sorted linked list for your countries.
Note that you are **not allowed to use any built-in List classes or methods!** The point of this homework is to understand linked lists by implementing your own.

#### Using CountryComparator
Your `CountrySorterList` should use an object of type `CountryComparator` to determine the order of the countries in the list.

#### add(Country newEntry)

You should create an `add` method that takes a `Country` object and puts it into the correct spot in the sorted list based on the comparator. 
The reading gives you a good start on this method and you can and should copy over the relevant code and credit it in your `Collaborations.txt` document.
You will need to adapt the code to work with your `CountryComparator` though.

#### Double linking

You should adapt the starter code and reading code to have a doubly-linked list, which is a list where the `Node`s have a link to the node before them, often called `previous` and you maintain a `lastNode` pointer as well as a `firstNode` pointer.

#### Max and min

You should enable the user to get the following information:
* The top X countries for any of the indicators, where X can be any number that the user specifies (i.e. the top 10 countries for Population Growth)
* The bottom X countries for any of the indicators

You should retrieve this information efficiently, meaning that you should not have to loop all the way to the end of the list to get either the maximum or minimum countries. 
Instead, you should use the double linked nature of the list effectively.

#### User interaction

As usual, it is up to you how you get information from the user and return information to them and you should consider how to do those tasks in a way that makes it easiest for the user.

## README

As always, you should include a detailed README for this homework. 
It should include a brief overview of your project, a short example of how to run your program and see its interesting behavior, and a more detailed section that has **demonstration input for each of the rubric items**. Remember, you want to make it as easy as possible for the grader to see that your homework does everything its supposed to!

### Prompt
In addition to demonstrating each rubric item, include a separate discussion about why you are using the `CountryComparator` class instead of having `Country` implement the interface `Comparable` as discussed in Java Interlude 5 of the textbook.


## Rubric
This is how you will be graded on this homework:

| Item | Points |
|-------|--------|
| User can get list of top X countries for each indicator | 6 |
| User can get list of bottom X countries for each indicator | 6 |
| Information from end of list retrieved efficiently | 6 |
| `CountryComparator` implemented and used correctly | 3 |
| README clear and complete | 6 |
| Java-docs style documentation | 3 |

## Submission
Remember to update your `Collaborations.txt` file with any sources that you consulted.

Then make a .zip of your files and upload it to Moodle. If you are working with a partner, only one of you should submit on Moodle, the grader will handle giving you both the same score.