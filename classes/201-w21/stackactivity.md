---
layout: page
title: Stack Lab
permalink: /classes/201-w21/stacks
---

## Goals
To better learn about how stacks work by creating a variation of a stack.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Monday Jan 25th, but it isn't due until Wednesday Jan 27th at 5:00pm Central.

Open the [Stacks Lab](https://repl.it/team/carlcs201s01w21/Stacks-Lab) on our Team Repl.it. You will see there is no starter code.

You're welcome to work on this lab with input from one or more members of your collaborative learning group. You should write all of your own code, but you're welcome to share your screen with members of your collaborative learning group to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

## Exercise 0
Using the Add File button on repl.it, add a Collaborations.txt file and describe any interactions you have with your collaborative learning group on this lab. Also note any outside sources such as websites that you referenced. 

## Exercise 1
For this lab, you'll create an array-based double stack for storing the books that you want to read and the books that you've already read. 
I don't know about you, but my books often end up in a literal stack, such that I can only access the book at the top, and then once I've read it, I put it on my stack of read books that I plan to shelve someday (emphasis on someday!). 
We're going to simulate that 'organization' of books.

a. Create a BookStack class in your repl.it.

b. Declare three ints for number of books to read, number of books read, and the array size, as well as one String array instance variable:
```
String[] bookArray;
```

c. Create a constructor for your BookStack that doesn't take any parameters, starts the arraySize at 3, instantiates your String array to the appropriate size, and initializes number of books to read and number of books read to 0.

d. As we've seen before, it's helpful to make a toString method right away so that you can see if your other methods are working easily. Have your toString method return a string in the following format:
```
Number to read: X, Number read: Y
"Contents1" "Contents2" "Contents3"
```
The "Contents" should have the quotation marks around them, remember that you can achieve that in a string with `\"`.

Check that your class works so far by creating a new BookStack in the main() method of BookStack.java and printing it. You should see:
```
Number to read: 0, Number read: 0
"null" "null" "null"
```

You are printing the entire contents of the array so that you can more easily reason about what is going on with both of your stacks, so you must print out the nulls!

## Exercise 2
Now let's actually be able to put some books onto the to read stack!

a. Create a `push(String)` method that takes the title of the book you just got and pushes it onto the 'top' of your to read stack. Remember that array-based stacks should have the 'bottom' of the stack be the beginning of the array. For now, don't worry about growing  beyond the bounds of the array, just get three books in first. Don't forget to update the number of books to read!

b. Test to make sure that your code works for adding three books. You should print the contents after adding each book to make sure that your stack is growing in the correct direction (which should be towards the end of the array).

## Exercise 3
I personally have way more than three books on my to read stack, so let's allow the stack to grow larger.

a. Update your `push` method so that it checks if the new book will fit on the stack and if it won't fit, create a new array that is double the size of the current array and copy all of the contents of the current array into the new array.

b. Verify that you code now allows you to push more books onto the to read stack.

## Exercise 4
Hopefully eventually you find time to actually read books on your to read stack, so it's time to implement that method.

a. The read stack will exist on the other side of the bookArray so that it's 'bottom' is the end of the array and it grows towards the front of the array. Create a `read` method that moves the top book from the to read stack to the top of the read stack. If you aren't sure how to do this, draw out a small example on paper. Make sure to adjust the number of books to read and the number of books read.

b. You'll need to update your code for growing the array since you will now need to also copy over the contents of the read stack. Remember that the read stack should start at the end of the array, so when they are copied over to a new array, their index values will shift quite a lot. Again, if you are unsure of how to do this, draw it out on paper. It's always easier to think about real numbers for the index values.

c. Test that your new code works correctly by printing your BookStack before and after your call `read`. Also verify that growing your array with the read stack works.

## Submitting
This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the document to indicate things you tried but what went wrong/where you got stuck. 

Submit your zip file to Moodle as always.

## Extensions
* I sometimes find myself reading multiple books at once and doing so in a stack-like way where I get bored of a book and start another, which I finish before then going back to the other book. Could you make a triple stack in the array with a 'currently reading' stack?
* Try implementing the functionality of the BookStack with a linked list instead of an array.
