---
layout: page
title: Queue Lab
permalink: /classes/201-w21/queues
---

## Goals
To better learn about how queues work by creating a linked queue.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Wednesday Jan 27th, but it isn't due until Friday Jan 29th at 5:00pm Central.

Open the [Queue Lab](https://repl.it/team/carlcs201s01w21/Queue-Lab) on Repl.it.

You're welcome to work on this lab with input from one or more members of your collaborative learning group. You should write all of your own code, but you're welcome to share your screen with members of your collaborative learning group to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

## Exercise 0
Using the Add File button on repl.it, add a Collaborations.txt file and describe any interactions you have with your collaborative learning group on this lab. Also note any outside sources such as websites that you referenced. 

## Exercise 1
For this activity, we'll make a linked list-based queue, which we'll call a LinkedQueue.

a. First, create a LinkedQueue that can hold a generic type:
```
public class LinkedQueue<T> {
```

b. Since this will use a linked list, copy the nested Node class from your Linked List Activity code.

## Exercise 2
Let's start with adding things to the queue. In a queue, adding is called `enqueue`.

a. Create an `enqueue` method that takes a `T newItem`, creates a Node for that item and adds that item to the end of the queue. You should make the appropriate instance variables that you need for your queue to be able to access the location of the end of the queue quickly. You may also find a `size` variable helpful.

b. As always, we need to be able to print the items to check that things are working. Adapt your `toString()` method from LinkedList to print the items in the queue from the front of the queue to the end of the queue. You should add whatever instance variables you need to be able to do this.

c. If you previously created a `head` Node that contains a null value, remove it and have `head` point to the first non-null Node. Make sure you understand why you don't need a null head node for a queue whereas it is useful for a linked list.

d. Verify via printing that you are able to enqueue several items. (If you want, make them complaints from the peasants in the reading.)
```
System.out.println(myQueue);
```

## Exericse 3
Finally, we want to also be able to remove items from a queue, which is called `dequeue`.

a. Create a `dequeue` method that returns a `T item` from the front of the queue.

b. If the queue is empty, throw an appropriate exception.

c. Verify via printing that you are able to dequeue several items (print both the dequeued item and the queue to verify the item has been removed).

## Submitting
This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the document to indicate things you tried but what went wrong/where you got stuck. 

Submit your zip file to Moodle as always.

## Extensions
If you have extra time, try combining what you know about creating SortedLinkedLists with LinkedQueues to create the Priority Queue discussed in the reading where a `Node` has a priority in addition to an item and is placed in the queue sorted by priority. 