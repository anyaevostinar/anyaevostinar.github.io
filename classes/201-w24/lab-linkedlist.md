---
layout: page
title: Linked List Lab
permalink: /classes/201-w24/linked-list-lab
published: true
---

## Goals
To better learn about how linked lists work by implementing your own simple linked list.

## Setup
[Mount the COURSES drive](getting-started) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK/username called `LinkedListLab`
* Create a file `LinkedList.java` 
 

## Exercise 1

a. Create a generic `LinkedList` class (note that we are not implementing the List interface because we aren't going to have time for all the methods it requires):
```
public class LinkedList<T> {}
```

b. **Within** your LinkedList class, copy the private Node class from (`LinkedStructure.java`)[LinkedStructure.java]

c. Create a private instance variable to store the `LinkedLists`'s head node:
```
public class LinkedList<T> {
    private Node head;
```

d. Make sure your code compiles, it won't do anything yet, but this is a good time to catch any errors in your setup.

## Exercise 2
Now we'll finally make a method to add items.

a. Create a method `public void add(T element)`. This method will just append the item to the end.

b. In this method, we'll first need to trace to the end of our `LinkedList` since we aren't currently maintaining a tail pointer. To trace through, you should first create a Node variable `current` that starts as `head`.

c. Next create a while loop that goes until you are at the last item in the list. The trick to this is to check if `current.next` is equal to `null`. If it isn't, then you want to change `current` to equal the next Node.

d. Once you're at the last Node in the `LinkedList`, you need to create a new Node with the `element` as an argument and set `current.next` to be that new Node.

e. Implement a `toString()` method that loops over all the Nodes in `LinkedList` and builds up a nicely formatted String of their values:
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

d. We'll often want helper methods that do a small job and make a larger method's code simpler. Implement a method `getNodeAt(int index)` so that you can use it here. Then complete your `add(int index, T element)` method.

e. As always, test out your code by trying it. Make sure to try adding at index 0 and at the end of your list, as well as the middle somewhere.

## Exercise 4
Linked lists are particularly good at efficiently combining. Try making a `combine` method that takes another linked list and adds it to the current one. What design decisions can make this process more efficient?

## Extensions
If you want have more time, here are something things to try:
* Write a remove method
* Fix the trailing `>` at the end of your printing of LinkedList
* Check the JavaDocs for other required methods of the List interface and properly implement them so you can `implements List`
* Determine the asymptotic order of each of the methods