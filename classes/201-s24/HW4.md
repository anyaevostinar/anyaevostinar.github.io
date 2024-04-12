---
layout: page
title: HW 4 Country Sorter List
permalink: /classes/201-s24/hw4
---

## Logistics
This is a paired assignment, so you should complete it with your assigned partner, if you have one, via paired programming. You should continue to work with your partner from homework 3. The whole time that you are working, you should both be present and actively working on the problem at hand. (Two brains, one keyboard.) Switch off the typing duties so that you each type for roughly half of the time.

You are able to get help from many sources as detailed in the [collaboration](collaboration) policy.

This assignment is due on Wednesday April 24th at 10pm. As with all assignments, you will have the opportunity to [revise](revision-process) this assignment individually based on the feedback that you get.

## Goals
To gain a better understanding of linked lists by implementing one that inserts values into sorted positions and maintains forward and backward pointers.

## Assessment
To demonstrate proficiency, your program needs to:

* Pass all tests on Gradescope
* Follow the specifications for the command-line
* Implement `CountrySorterList` and `CountryComparator` correctly
* Be object-oriented
* Have a README with an overview, example, and response to the prompt
* Be somewhat [well-styled](style-reference)

To **demonstrate mastery**, your program needs to:
* Demonstrate proficiency
* Use private variables correctly and effectively
* Use the double-linked list effectively and efficiently
* Be extremely [well-styled](style-reference) and clear by choosing descriptive variable names and including useful comments 
* Have JavaDocs documentation for all public methods
* Have a thorough, well-styled README with thoughtful prompt response
* Have clear and thorough documentation

## Setup and Requirements
Mount COURSES, download the [HW4 starter code](/classes/201-w24/HW4Starter.zip) and move it to your StuWork/username folder.

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
```java
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
The reading shows a version with `Comparable` that you can reference (and cite in `Collaborations.txt` document), but you will have to make enough changes that you might be better off writing it from scratch to work with your `CountryComparator`.

#### Double linking

You should adapt the starter code to have a doubly-linked list, which is a list where the `Node`s have a link to the node before them, often called `previous` and you maintain a `lastNode` pointer as well as a `firstNode` pointer.

#### User interaction

The user should be able to specify the filename, number of top and bottom countries, and indicator of interest (in "") that they want displayed via the command line interface, such as:

```java CountrySorterList CountryDataset.csv 5 "Population Total"```

which would then display the countries with the top 5 population totals and the bottom 5 population totals:
```bash
Lowest:
1. Tuvalu 0.01
2. Palau 0.02
3. Gibraltar 0.03
4. British Virgin Islands 0.03
5. Turks and Caicos Islands 0.04
------
Highest:
1. China 1364.8
2. India 1294.75
3. United States 318.37
4. Indonesia 254.95
5. Brazil 202.69
```

You can change the output formatting but need to have at least the names of the countries (the autograder will be checking that all required names are there and the human graders will be evaluating clearness of your output).

You should retrieve the top and bottom information efficiently, meaning that you should not have to loop all the way to the end of the list to get either the maximum or minimum countries. 
Instead, you should use the double linked nature of the list effectively.

## README

As always, you should include a detailed README for this homework. 
It should include a brief overview of your project and a short example of how to run your program and see its interesting behavior.

### Prompt
Include a discussion about why you are using the `CountryComparator` class instead of having `Country` implement the interface `Comparable`.


## Submission
Remember to update your Collaborations.txt file with any sources that you consulted and that you should only submit **one** assignment for your pair and then add your partner to the submission on Gradescope.

Then upload all of your files to the Gradescope link on Moodle, at which point the autograder will run and let you know if your code works correctly. You are able to submit your code as many times as you wish before the deadline to fix any issues. If you have questions about what the autograder is telling you is wrong, please ask!