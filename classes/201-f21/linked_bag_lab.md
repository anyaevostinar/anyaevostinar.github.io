---
layout: page
title: Linked Structures Lab
permalink: /classes/201-f21/linked-structures
published: false
---

## Logistics
You should complete this on Monday Sept 27th, 2021, but it isn't due until Wednesday Sept 29nd, 2021 at 5pm. 

You should work on this with your in-class partner, but you both need to submit separately. 
If you finish it outside of class without your partner, note which sections you completed together and which you completed separately in your `Collaborations.txt`.

## Goal
Practice with the ideas of linked data structures and implement a Linked Bag data structure.

## Setup
[Mount the COURSES drive](https://wiki.carleton.edu/pages/viewpage.action?spaceKey=carl&title=CS+111+and+201+workflow+in+CS+labs) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `LinkedBagLab`
* Create your `Collaborations.txt` document in that folder
* Create a file `LinkedBag.java` and copy the [starter code](LinkedBag.java) into that file

## add
The first thing you'll probably want to do with your bag is be able to add items to it.

a. In the stub of the `add` method, create a new `Node` with `newEntry` as its `dataPortion`.

b. Make your new node the first node in your linked chain and change the return value to `true`.

c. Make a `main` method in your `LinkedBag` class so that you can make a test `LinkedBag` and make sure you can call the `add` method. Compile and run your code (it won't seem like it does anything, you're just checking for compile-time errors at this point).

d. This would work for a bag that holds just one item, but it won't work for more than one item. Figure out why and fix it. If you aren't sure, move on to the next exercise to see how to print the items in your bag so you can see the problem.

## toString
Whenever you are making a data structure, you'll probably want to be able to print out its contents while testing it.
You can make your own data structures work directly with `System.out.println()` by implementing the `toString()` method.

a. When you are working with linked data structures, you'll frequently need to navigate through the chain. To do this, you should always create a local variable `currentNode` and set it equal to the first node. 

b. Use a `while` loop to loop over each `Node` in your chain. Think about what the stopping condition for the while loop should be and what should happen at each step of the loop to move to the next `Node`.

c. Within your while loop, grab the data of the `currentNode` and add it to a `String` that you can then return.

d. Use `System.out.println` to print out the contents of your bag in `main`:
```
System.out.println("Contents of bag: " + test);
```

e. If you weren't sure about the problem with `add` previously, try adding multiple items to your test bag and printing it to see what happens and fix it.