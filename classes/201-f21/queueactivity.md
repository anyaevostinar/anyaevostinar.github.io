---
layout: page
title: Queue Lab
permalink: /classes/201-f21/queues
published: true
---

## Goals
To better learn about how queues work by creating a linked queue.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Wednesday Sept 29th, but it isn't due until Friday Oct 1st at 5:00pm Central.


## Setup
[Mount the COURSES drive](https://wiki.carleton.edu/pages/viewpage.action?spaceKey=carl&title=CS+111+and+201+workflow+in+CS+labs) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK/username folder called `QueueLab`
* Open that folder through VSCode
* Create your Collaborations.txt document in that folder

You should work on this with your in-class partner, but you both need to submit separately. 
If you finish it outside of class without your partner, note which sections you completed together and which you completed separately in your `Collaborations.txt`.

## Exercise 1
For this activity, we'll make a linked chain-based queue, which we'll call a `LinkedQueue`.

a. First, create a LinkedQueue that can hold a generic type:
```
public class LinkedQueue<T> {
```

b. Since this will use a linked chain, copy the nested Node class from the [`LinkedBag` starter code](LinkedBag.java).

## Exercise 2
Let's start with adding things to the queue with the `enqueue` method.

a. Create an `enqueue` method that takes a `T newItem`, creates a Node for that item and adds that item to the end of the queue. You should make the appropriate instance variables that you need for your queue to be able to access the location of the end of the queue quickly.

b. As always, we need to be able to print the items to check that things are working. Adapt your `toString()` method from LinkedBag to print the items in the queue from the front of the queue to the end of the queue. You should add whatever instance variables you need to be able to do this.

c. Verify via printing in `main` that you are able to enqueue several items. (If you want, make them complaints from the peasants in the reading.)
```
System.out.println(myQueue);
```

## Exericse 3
Finally, we want to also be able to remove items from a queue with `dequeue`.

a. Create a `dequeue` method that returns a `T item` from the front of the queue.

b. If the queue is empty, return null.

c. Verify via printing that you are able to dequeue several items (print both the dequeued item and the queue to verify the item has been removed).

## Submitting
This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the document to indicate things you tried but what went wrong/where you got stuck. 

Submit your zip file to Moodle as always.

## Extensions
If you have extra time, try implementing more of the methods from the reading:
* `getFront()`
* `isEmpty()`
* `clear()`