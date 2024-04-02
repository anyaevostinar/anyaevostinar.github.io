---
layout: page
title: Linked List Lab
permalink: /classes/201-s24/linked-list-lab
published: true
---

## Goals
To better learn about how linked lists work by implementing your own simple linked list.

## Setup
[Mount the COURSES drive](getting-started) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK/username called `LinkedListLab`
* Create a file `LinkedList.java` 
 

## Exercise 1

a. Create a generic `LinkedList` class (note that we are not implementing the `List` interface because we aren't going to have time for all the methods it requires):
```java
public class LinkedList<T> {}
```

b. In the same folder, place [`Node.java`](Node.java)

c. Create a private instance variable to store the `LinkedLists`'s head node (this will look very similar to [LinkedStructure](LinkedStructure.java), but a different variable name):
```java
public class LinkedList<T> {
    private Node<T> head;

}
```

d. Make sure your code compiles, it won't do anything yet, but this is a good time to catch any errors in your setup.

## Exercise 2
Now we'll finally make a method to add items.

a. Create a method `public void add(T element)`. This method will just add to the head of the list.

b. Within your `add` method, create a new `Node` to hold the `element`. 

c. What should the new `Node`'s `next` point to? Set it correctly (ask if you aren't sure!).

d. Update your list's `head` variable.

e. In `main` of your `LinkedList.java`, try making a new `LinkedList` of `String` and adding a few strings. Then print out the `data` of the head to make sure that it is correctly set.

## Exercise 3
It would be nice to have a `toString()` method to easily print your list. Consult [Exercise 4](queues-lab#exercise-4) to make a similar method for your `LinkedList`:

```
"hi > friend > "
```

Don't worry about the trailing `>`, you can fix it later.

Verify your `add` and `toString` methods work by adding a few items to your `LinkedList` in `main()` and running it.

## Exercise 4
Finally, it would be useful to have another add method that inserted an item in the middle of the list.

a. Create a method `public void add(int index, T element)`. 

b. You'll want to be sure that a user doesn't try to add something far past the end of your existing `LinkedList` since that wouldn't make sense. To do that check ahead of time, add an instance variable `size` to your `LinkedList` class and update your other `add` method to increment it.

c. Check if `index` is larger than `size` and if it is, print a helpful message to the user.

d. We'll often want helper methods that do a small job and make a larger method's code simpler. Implement a method `getNodeAt(int index)` so that you can use it here. Then complete your `add(int index, T element)` method.

e. As always, test out your code by trying it. Make sure to try adding at index 0 and at the end of your list, as well as the middle somewhere.

## Exercise 5
Linked lists are particularly good at efficiently combining. Try making a `combine` method that takes another linked list and adds it to the current one. What design decisions can make this process more efficient?

## Extensions
If you want have more time, here are something things to try:
* Write a remove method
* Fix the trailing `>` at the end of your printing of LinkedList
* Check the JavaDocs for other required methods of the List interface and properly implement them so you can `implements List`
* Determine the asymptotic order of each of the methods