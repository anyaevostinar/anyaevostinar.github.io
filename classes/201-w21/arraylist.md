---
layout: page
title: Array List Activity
permalink: /classes/201-w21/arraylist
---

## Goals
To better understand how ArrayList works by implementing a simplified version yourself.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Friday Jan 22nd, but it isn't due until Monday Jan 25th at 5:00pm Central.

You'll do this lab on repl.it. Go to our team page, click on Projects, and open Array List. 

You're welcome to work on this lab with input from one or more members of your collaborative learning group. You should write all of your own code, but you're welcome to share your screen/use multiplayer mode with members of your collaborative learning group to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

This activity has some automated tests that you'll be using to check your work as you go. We'll actually use the `Run` button for once, and when you click it, you should see something like the following:
![Screenshot of command terminal with test output for failing tests](/classes/201-f20/test-suite-example.png)

Test suites are very helpful for checking if your code is working as it should.
You should always run your test suite on code that you know shouldn't pass, to make sure the test suite is working, and then when your code does pass the test suite, you know it's because your code actually works too!

## Exercise 0
Create a `Collaborations.txt` file and add any help you get to it.

Read through the code in StringArrayList.java and use the `Run` button to run your tests and verify that the code does not currently pass your tests.

## Exercise 1
Implement the `get` method. 
Note that your code should only be a few lines long.
Remember that you should use the underlying array, but you need to make sure that the position is within the items that exist in the array and that there may be fewer valid positions than the length of the array.

Make sure that your code passes the test suite:
![Screen shot of command terminal with test output for passing tests](/classes/201-f20/test-suite-passing.png)

## Exercise 2
Implement the `set` method.
Remember to still check for the bounds of the ArrayList.

To run the tests for `set`, go into the Tests.txt file and remove the `//` at the beginning of lines that say `//q2` at the end. Then click Run to see if you code passes the tests for set and fix any problems.

## Exercise 3
Now you'll implement the `add(int index, String newItem)` method assuming that there is already sufficient space in the underlying array to add the item. Remember that you aren't overwriting an existing item, so you'll need to move all the later items down in order to insert a new item.

Remove the `//` at the beginning of lines in Tests.txt that end in `//q3` to test your code.

## Exercise 4
When there isn't enough space to add a new item, an ArrayList should create a new array with twice the amount of space and copy the items from the old array over in addition to adding the new item. Update your `add(int index, String newItem)` method so that it handles this case.

Uncomment the appropriate tests for `q4` and test your code.

## Exercise 5
Finally, implement the special scenario `add(String newItem)` that just adds the item to the end of the existing items by making an appropriate call to `add(int index, String newItem)`. 

Uncomment the last tests and check your work.

## Submitting
This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the document to indicate things you tried but what went wrong/where you got stuck. Feedback on labs and activities is less detailed than on homework.

Submit your zip file to Moodle as always.

## Extensions
If you have extra time, you're welcome to add on to your work in this activity. Some ideas for what you might try:

* Implement a `remove(int)` method that removes the item at the index that's passed in as a parameter.
* Take a look at the tests in TestStringArrayList.java. Try to make sense of what's going on, and try writing some tests of your own, either for remove if you did the previous extension or as extra tests for the methods that you implemented.
* Brainstorm two use cases for a list where you'd prefer an array list implementation over a linked list implementation. Then, brainstorm for the opposite case: when would you prefer a linked list over an array list?