---
layout: page
title: Expression Tree Lab
permalink: /classes/201-f20/expressiontree
---

## Goals
To practice creating and manipulating trees in Java, and to strengthen your understanding of recursion.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Monday Oct 26th, but it isn't due until Wednesday Oct 28th at 5:00pm Central.

Create a new repl and make it private. Upload or copy/paste [this file](/classes/201-f20/ExpressionTree.java).

You're welcome to work on this lab with input from one or more members of your collaborative learning group. You should write all of your own code, but you're welcome to share your screen/use multiplayer mode with members of your collaborative learning group to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

## Exercise 0
Using the Add File button on repl.it, add a Collaborations.txt file and describe any interactions you have with your collaborative learning group on this lab. Also note any outside sources such as websites that you referenced. If you do not collaborate or check any outside websites, you should state that in Collaborations.txt.

## Exercise 1
In this lab, you'll be working with expression trees: trees for representing a mathematical expression. Here's an example:

![Tree with five nodes. Root node is +, left child is *, right child is 2. Child of * are 3 and 5.](/classes/201-f20/ExpressionTree.png)

We'll be representing expressions using postfix notation, which avoids issues of order or operations and parentheses. 
In postfix notation, the operation (+, *, -, /, ÷) comes after the things it operates on (operands). In this case, the postfix notation would be 3 5 * 2 +.

Draw a tree that represents the postfix expression 4 3 + 5 2 * -

When you're done, check against the solution:
<details><summary>Show solution</summary>
<p>
<img src="/classes/201-f20/ExampleExpressionTree.png">
</p>
</details>

## Exercise 2
Open `ExpressionTree.java`.

There is a lot of code in here already, most of it you won't need to worry about.
You'll be implementing the constructor.

a. First read through the nested BinaryTreeNode class (it is very short).

b. Then read through the `isOperator` method, which will  be useful to you in determining if a String is a mathematical operator.

## Exercise 3
Time to start on the constructor.

a. Note that the starter code creates a `List<String> postfixNotationList` for you.

b. You should then check if the `postfixNotationList` is empty. If it is empty, you should just return.

c. If it isn't empty, you should create a new `BinaryTreeNode` to save to root. Note that `root` has already been declared so you should not declare it!

d. Remove the last item from the list and set it to `root`'s item.

e. If the root item is an operator, call the `parseHelper` method with the arguments `root` and `postfixNotationList`.

f. Compile and run `ExpressionTree.java` to see if you code does something. It won't print out the entire tree at this point, but it should print out just the root operation for each of the test trees.

## Exercise 4
Now you'll implement a recursive `parseHelper` so that the rest of the tree is created.

a. First `parseHelper` should check if the list `toProcess` is empty, and if it is, do nothing.

b. If the list is not empty, then there is at least one more node to create, so you should create a new `BinaryTreeNode`, remove the last element from the list and set it to the new node's item.

c. If the item is an operator, you can assume the next item in the list should be a child for the new node, so  you should make a recursive call to `parseHelper` passing in your new node and the list. This will get all the children of the new node sorted out.

d. Once any children of new node have been created, you need to attach your new node to your input node. Since postfix order gives you the right children first, you should first check if `input` has a right child. If it doesn't, then the new node should be the right child. If there is already a right child, your new node should be the left child.

e. We are assuming our expression trees always have two children for each operator, so if you set the new node to be the right child, you need to make a recursive call with the same arguments to set up the left child. (You could create both the right and left in the same method, but that would lead to some repeated code.)

f. Finally, make sure your code works for the provided tests and write a JavaDocs comment for the `parseHelper` method.

## Submitting
This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the document to indicate things you tried but what went wrong/where you got stuck. Feedback on labs and activities is less detailed than on homework.

Submit your zip file to Moodle as always.

## Extensions
If you have extra time, you can try evaluating an expression tree. Evaluating the tree means calculating the value of the expression it represents. For example, for the tree at the top of the lab, the value is 17.