---
layout: page
title: Linked Structures Lab
permalink: /classes/201-f21/linked-structures
published: true
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

e. Add multiple items to your test bag and print the contents to see what happens. If you weren't sure about the problem with `add` previously, try to fix any problems now with this additional information. (You can also add additional print statements to trace through what is going on.)

## remove(T anEntry)
Finally, if this were a real bag, you'd want to be able to remove things from it someday. Remove is a trickier method to write, so be sure to think carefully about how it should work.

a. Use a similar while loop approach to loop through the items in your linked chain to find the item that you are looking for.

b. Once you find it, you need to remove it from your chain. Remember that the order of the items in the chain doesn't matter, since everything gets jumbled in a bag. This means that the easiest thing to do is to copy the data from the `firstNode` into the node that matches `anEntry` and then remove `firstNode`.

c. Be sure to return `true` or `false` depending on if you find the item or not.

d. Check that your code works for an item in the middle of the chain, an item at the beginning of the chain, an item at the end of the chain, and an empty bag.

## Submission
Compress your files as a zip, and upload that zip to Moodle under the appropriate assignment.
Remember that partners need to submit their code separately and you should share the code you wrote in class with your partner.

This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the code to indicate things you tried but what went wrong/where you got stuck.

## Extensions
There were several more methods that were suggested for the Bag ADT, feel free to try implementing any of these:

* `getCurrentSize()`
* `isEmpty()`
* `clear()`
* `getFrequencyOf(T anEntry)`
* `contains(T anEntry)`