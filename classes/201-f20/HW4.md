---
layout: page
title: HW 4 Country Data Redux
permalink: /classes/201-f20/hw4
---

# Logistics
25 points, due Wednesday, Oct 7th by 10PM Central time. Like all assignments, there is a 48-hour, no questions asked extensions policy. If you have a tech issue, a health issue, or some other issue that impedes making the deadline, use this policy. You need to notify me that you're using the policy. Extensions beyond the 48-hour policy will only be considered in extenuating circumstances, and circumstances that arise between the original deadline and the extension are generally not extenuating - the deadline is still the deadline, not 48 hours later.

# Goals
To gain a better understanding of linked lists by implementing one that inserts values into sorted positions.

# Assignment Type and Collaborative Learning Expectations
This is a homework assignment that you'll be handing in on Moodle.

You're welcome to either complete this homework with input from one or more members of your collaborative learning group or to complete it on your own. You and the other members of your collaborative learning group should each write your own code, even if you're helping one another, but you may share your screens/use multiplayer mode to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

# Setup and Requirements
Go to our Course on Repl.it and open the project HW4. Make sure that the repl is private.

You should first create a Collaborations.txt document and update it with any sources (webpage or people) that you get help from.

The code that you write for this assignment will build on top of the Country.java class that you wrote previously.
You should copy that file over to this project.

## Specification
For this assignment, you'll make a new class, `SortedLinkedList` that consists of a linked list that adds items in sorted order according to a previously set indicator and order. 

## Comparator
If you were thinking after the last assignment that there has got to be a better way of sorting, you are right! 
In Java, there is an interface called the `Comparator` that focuses on allowing two objects of the same type to be compared easily.
First you will create a comparator that will then be stored in your linked list later.

Create a new class `CountryComparator` that implements the `Comparator` interface for Country:
```
public class CountryComparator implements Comparator<Country> {
```

This class will consist of just two methods: 1) a constructor, and 2) the `compare` method that is required for a `Comparator`.

### Constructor
Your comparator needs to store the indicator that it compares by and the direction that it should sort by (greatest to least or least to greatest).
Create those instance variables and a constructor that takess in value for those variables and sets them.

### compare method
Next create a method `compare` that takes two Country instances as parameters. 
The way that comparators in Java work is that for two objects a and b, it returns -1 if a comes before b, 0 if a and b could be in either order, and 1 if b comes before a.
Your compare method should work the same based on the indicator and order chosen by the constructor. 
If two countries have the same value for the indicator, you should return 0.

You should test your CountryComparator by making a new one in the main(String[] args) method of CountryComparator.java with some test Country objects.

## SortedLinkedList
Now that you have an object for comparing two countries, let's make a sorted linked list.
Note that you are **not allowed to use any built-in List classes or methods!** The point of this homework is to understand linked lists by implementing your own.

Create a class `SortedLinkedList` that implements the provided interface `SortedList` just for Country:
```
public class SortedLinkedList implements SortedList<Country> {
```

Adapt your Node code from the Linked List Activity so that you have a private Node class, a head, and a size instance variable. In addition, declare a comparator instance variable:
```
Comparator<Country> myComparator;
```

Copy the method signatures and comments from the `SortedList` interface and turn them into method stubs in `SortedLinkedList` by returning something of the correct type for each method.

### Constructor
Create a constructor that takes a `Comparator<Country>` as a parameter and sets the instance variables appropriately.

### test method
Create a `test` method that first creates three Country objects with dummy data, then puts them into Nodes and then connects those Nodes together from the `head` so that other methods can be tested before you implement `add`.

### size and isEmpty methods
Start by implementing the `size` and `isEmpty` methods since they are short.

Using your `test` method, make sure that these work.

### toString method
Adapt the `toString` method from the Linked List Activity for this class so that it returns the names of the countries in the list.

Using your `test` method, make sure that this works.

### get method
Implement a `get` method that returns the Country at the given position. 
If the user tries to access a position outside of the range, you should throw an IndexOutOfBoundsException:
```
throw new IndexOutOfBoundsException();
```

Using your `test` method, make sure that this works.

### add method
The add method is the heavy-lifter of this class since it needs to add a given item in the correct place in the list.

There are three scenarios that you need to think about when implementing your add method:
1) adding to the middle of the list

2) adding to the beginning of the list

3) adding to the end of the list

I recommend you go in that order and make sure each scenario works before moving on to the next one.
You are allowed to include extra instance variables such as `tail` if you find them useful.
I also highly recommend that you have an example written down on paper and trace through it by hand so that you have a firm idea of what you need to do.
You will probably run into a lot of NullPointerExceptions as you do this; try not to let them fluster you and just remember that that means you are accessing a `null` thing somewhere and go back to your example to figure out where.

Demonstrate in the main() method of SortedLinkedList that each of the three cases for add works.

# Rubric
This is how you will be graded on this homework:

| Item | Points |
|-------|--------|
| Comparator implemented correctly | 3 |
| compare method correct | 2 |
| size and isEmpty correct | 2 |
| toString method correct | 2 |
| get works as specified | 2 |
| Adding to the front of the list works | 3 |
| Adding to the middle works | 3 |
| Adding to the end works | 3 |
| Demonstration examples for add | 2 |
| Style | 3 |

# Submission
Make sure Collaborations.txt is accurate and includes any sources that you used including any conversations. Did you share strategies with anyone else? Talk about any annoying compiler error and get advice? These are fine things to do, and you should note them in the Collaborations.txt file. Give the names of people you talked with. If you used any resources outside of our course materials, that is also something to note in Collaborations.txt. If you didn't talk with anyone, please note that explicitly in Collaborations.txt.

After making Collaborations.txt and finishing the assignment, click on the three vertical dots next to the add file and add folder icons on repl.it, and choose "Download as zip" from the menu. Upload that zip on Moodle.

## Extensions
* Adapt toString so that it includes the name of the country and the indicator of interest.
* Add a remove method.
* Incorporate your SortedLinkedList into your CountryDisplayer and create an interactive user interface (this is intentionally open ended so you can do whatever seems interesting and useful).