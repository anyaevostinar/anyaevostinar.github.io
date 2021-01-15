---
layout: page
title: Linked List Activity
permalink: /classes/201-w21/linked-list
---

## Goals
To better learn about how linked lists work by implementing your own simple linked list.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Wednesday Jan 20th, but it isn't due until Friday Jan 22nd at 5:00pm Central.

You'll do this lab on repl.it. Go to our team, click on Projects, and open Linked List project.

You're welcome to work on this lab with input from one or more members of your collaborative learning group. You should write all of your own code, but you're welcome to share your screen/use multiplayer mode with members of your collaborative learning group to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

## Exercise 0
Using the Add File button on repl.it, add a Collaborations.txt file and describe any interactions you have with your collaborative learning group on this lab. Also note any outside sources such as websites that you referenced. 

## Exercise 1
This activity will use two types of classes that you haven't made before, generic and private classes.

a. Create a generic LinkedList class (note that we are not implementing the List interface because we aren't going to have time for all the methods it requires):
```
public class LinkedList<T> {}
```

b. **Within** your LinkedList class, create a private Node class:
```
public class LinkedList<T> {

    private class Node {}
}
```

This is a nested private class because it will be used by LinkedList and is specific to LinkedList, so no other classes should use it anyway. The benefit of having it nested is that Node objects will be able to access private instance variables of LinkedList!

c. Create a private instance variable to store the LinkedLists's head node:
```
public class LinkedList<T> {
    private Node head;
```

d. We'll also need the Node class to have some instance variables. Remember that a Node needs to hold it's item and a pointer to the next Node in the LinkedList. Because Node is a nested class, it knows about the generic variable type T from LinkedList:
```
private class Node {
    private T item;
    private Node next;
}
```

e. Make sure your code compiles, it won't do anything yet, but this is a good time to catch any errors in your setup.

## Exercise 2
Now let's make some constructors and check everything is working.

a. First create a constructor for Node that takes the item and sets `next` to `null`. `null` is a special keyword that can go in the place that an `Object` normally would but signals that there isn't anything there.

b. Next, we'll use the model of LinkedList where it maintains a special null head node, so create a constructor for LinkedList that doesn't take any parameters, creates a new Node with `null` for the item, and sets that Node to be the `head`.

c. Finally, we want to be able to easily print the contents of our LinkedList and we can make it work with System.out.println() by creating a method `public String toString()`. For now, your list only has a null head node, so just have the method return a String saying "Empty LinkedList!".

d. Create a main() method in LinkedList.java, make a new instance of LinkedList, and print it with System.out.println() to verify that everything works:
```
LinkedList<Integer> myList = new LinkedList<Integer>();
System.out.println(myList);
```

## Exercise 3
Now we'll finally make a method to add items.

a. Create a method `public void add(T element)`. This method will just append the item to the end.

b. In this method, we'll first need to trace to the end of our LinkedList since we aren't currently maintaining a tail pointer. To trace through, you should first create a Node variable `current` that starts as `head`.

c. Next create a while loop that goes until you are at the last item in the list. The trick to this is to check if `current.next` is equal to `null`. If it isn't, then you want to change `current` to equal the next Node.

d. Once you're at the last Node in the LinkedList, you need to create a new Node with the `element` as an argument and set `current.next` to be that new Node.

e. Use a similar approach to change your `toString()` method so that it loops over all the Nodes in LinkedList and builds up a nicely formatted String of their values:
```
"hi > friend > "
```

Don't worry about the trailing `>`, you can fix it later.

f. Verify your `add` and `toString` methods work by adding a few items to your LinkedList in main() and running it.

## Exercise 4
Finally, it would be useful to have another add method that inserted an item in the middle of the list.

a. Create a method `public void add(int index, T element)`. 

b. You'll want to be sure that a user doesn't try to add something far past the end of your existing LinkedList since that wouldn't make sense. To do that check ahead of time, add an instance variable `size` to your LinkedList class and update your other `add` method to increment it.

c. Check if `index` is larger than `size` and if it is, print a helpful message to the user.

d. Using the technique from the reading, insert a new Node into the LinkedList. Remember that the `head` node shouldn't be counted in the index! If you get stuck or confused, check the reading again and try drawing out an example on paper. 

e. As always, test out your code by trying it. Make sure to try adding at index 0 and at the end of your list, as well as the middle somewhere.

## Submitting
This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the document to indicate things you tried but what went wrong/where you got stuck. 

## Extensions
If you want more practice, here are something things to try:
* Write a remove method
* Fix the trailing `>` at the end of your printing of LinkedList
* Check the JavaDocs for other required methods of the List interface and properly implement them so you can `implements List`