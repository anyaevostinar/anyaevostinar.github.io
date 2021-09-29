---
layout: page
title: Linked List Activity
permalink: /classes/201-f21/linked-list
published: false
---

## Goals
To better learn about how linked lists work by implementing your own simple linked list.

## Logistics
You should complete this on Wednesday Oct 6th, 2021, but it isn't due until Friday Oct 8th, 2021 at 5pm. 

You should work on this with your in-class partner, but you both need to submit separately. 
If you finish it outside of class without your partner, note which sections you completed together and which you completed separately in your `Collaborations.txt`.

## Setup
[Mount the COURSES drive](https://wiki.carleton.edu/pages/viewpage.action?spaceKey=carl&title=CS+111+and+201+workflow+in+CS+labs) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `LinkedListLab`
* Create your `Collaborations.txt` document in that folder
* Create a file `LinkedList.java` 
 

## Exercise 1
This lab will have a lot of similarities and use code from the `LinkedBag` lab, so feel free to look at that [starter code](LinkedBag.java) as reference, though it won't always be an exact copy.

a. Create a generic `LinkedList` class (note that we are not implementing the List interface because we aren't going to have time for all the methods it requires):
```
public class LinkedList<T> {}
```

b. **Within** your LinkedList class, copy the private Node class from `LinkedBag`

c. Create a private instance variable to store the `LinkedLists`'s head node, what the book calls `firstNode`:
```
public class LinkedList<T> {
    private Node firstNode;
```

d. Make sure your code compiles, it won't do anything yet, but this is a good time to catch any errors in your setup.

## Exercise 2
Now we'll finally make a method to add items.

a. Create a method `public void add(T element)`. This method will just append the item to the end.

b. In this method, we'll first need to trace to the end of our `LinkedList` since we aren't currently maintaining a tail pointer. To trace through, you should first create a Node variable `current` that starts as `firstNode`.

c. Next create a while loop that goes until you are at the last item in the list. The trick to this is to check if `current.next` is equal to `null`. If it isn't, then you want to change `current` to equal the next Node.

d. Once you're at the last Node in the `LinkedList`, you need to create a new Node with the `element` as an argument and set `current.next` to be that new Node.

e. Use a similar approach to the `LinkedBag` to implement a `toString()` method so that it loops over all the Nodes in `LinkedList` and builds up a nicely formatted String of their values:
```
"hi > friend > "
```

Don't worry about the trailing `>`, you can fix it later.

f. Verify your `add` and `toString` methods work by adding a few items to your `LinkedList` in `main()` and running it.

## Exercise 3
Finally, it would be useful to have another add method that inserted an item in the middle of the list.

a. Create a method `public void add(int index, T element)`. 

b. You'll want to be sure that a user doesn't try to add something far past the end of your existing `LinkedList` since that wouldn't make sense. To do that check ahead of time, add an instance variable `size` to your `LinkedList` class and update your other `add` method to increment it.

c. Check if `index` is larger than `size` and if it is, print a helpful message to the user.

d. We'll often want helper methods that do a small job and make a larger method's code simpler. The reading `getNodeAt(int index)` is such a method. Implement that method so that you can use it here. Then complete your `add(int index, T element)` method.

e. As always, test out your code by trying it. Make sure to try adding at index 0 and at the end of your list, as well as the middle somewhere.

## Submission
Compress your files as a zip, and upload that zip to Moodle under the appropriate assignment.
Remember that partners need to submit their code separately and you should share the code you wrote in class with your partner.

This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the code to indicate things you tried but what went wrong/where you got stuck.

## Extensions
If you want more practice, here are something things to try:
* Write a remove method
* Fix the trailing `>` at the end of your printing of LinkedList
* Check the JavaDocs for other required methods of the List interface and properly implement them so you can `implements List`
* Determine the asymptotic order of each of the methods