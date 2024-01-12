---
layout: page
title: Linked Queue Lab
permalink: /classes/201-w24/queues-lab
published: true
---

## Goals
To better learn about how queues work by creating a linked queue.


## Setup
[Mount the COURSES drive](getting-started) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK/username folder called `QueueLab`
* Open that folder through VSCode
* Download the [example LinkedStructure](LinkedStructure.java) code

## Exercise 1
For this activity, we'll make a linked chain-based queue, which we'll call a `LinkedQueue`.

a. First, create a LinkedQueue that can hold a generic type:
```
public class LinkedQueue<T> {
```

b. Since this will use a linked chain, copy the nested Node class from the `LinkedStructure` code. (Note: copy the code, don't just work from `LinkedStructure` since you're making a queue!)

## Exercise 2
Let's start with adding things to the queue with the `enqueue` method.

a. Create an `enqueue` method that takes a `T newItem`, creates a Node for that item and adds that item to the tail of the queue. You should make the appropriate instance variables that you need for your queue to be able to access the location of the end of the queue quickly.

## Exercise 3
Whenever you are making a data structure, you'll probably want to be able to print out its contents while testing it.
You can make your own data structures work directly with `System.out.println()` by implementing the `toString()` method.

a. When you are working with linked data structures, you'll frequently need to navigate through the chain. To do this, you should always create a local variable `currentNode` and set it equal to the first node. (It's up to you if you want to print your queue tail to head or head to tail.)

b. Use a `while` loop to loop over each `Node` in your chain. Think about what the stopping condition for the while loop should be and what should happen at each step of the loop to move to the next `Node`.

c. Within your while loop, grab the data of the `currentNode` and add it to a `String` that you can then return.

d. Use `System.out.println` to print out the contents of your queue in `main`.

e. Add multiple items to your test queue and print the contents to see what happens.


## Exercise 4
Finally, we want to also be able to remove items from a queue with `dequeue`.

a. Create a `dequeue` method that returns a `T item` from the head of the queue.

b. If the queue is empty, return null.

c. Verify via printing that you are able to dequeue several items (print both the dequeued item and the queue to verify the item has been removed).

## Exercise 5
Make a `size` variable. How can you change your methods based on this variable? Is it worth having?


## Extensions
If you have extra time, try implementing more of the methods from the reading:
* `peek()`
* `isEmpty()`
* `clear()`
* `size()`

Compare your implementation to the one from [OpenDSA](https://opendsa-server.cs.vt.edu/OpenDSA/Books/CS2/html/QueueLinked.html)

Make a second implementation that has the head and tail reversed. What changes are necessary and how does this impact the elegance and efficiency of your code?