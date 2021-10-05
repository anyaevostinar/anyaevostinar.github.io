---
layout: page
title: Recursion Review
permalink: /classes/201-f21/recursion
published: false
---

## Goals
To refresh on thinking recursively and writing recursive code.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Wednesday Oct 13th, but it isn't due until Friday Oct 15th at 5:00pm Central.

You should work on this with your in-class partner, but you both need to submit separately. 
If you finish it outside of class without your partner, note which sections you completed together and which you completed separately in your `Collaborations.txt`.

## Setup
[Mount the COURSES drive](https://wiki.carleton.edu/pages/viewpage.action?spaceKey=carl&title=CS+111+and+201+workflow+in+CS+labs) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK/username folder called `RecursionLab`
* Open that folder through VSCode
* Create your Collaborations.txt document in that folder

You should work on this with your in-class partner, but you both need to submit separately. 
If you finish it outside of class without your partner, note which sections you completed together and which you completed separately in your `Collaborations.txt`.

## Exercise 0
Create a new file called `Recursion.java` in your `RecursionLab` folder.
For this lab, you'll make several `static` recursive functions in this class and call them in the `main` method of your `Recursion` class.
(This will be a good example of when `static` methods are helpful.)

## Exercise 1


a. The website [CodingBat](https://codingbat.com/) has several good practice problems for recursion. Solve the [bunny ears](https://codingbat.com/prob/p107330) problem. You can type your code either in VSCode or the website, but you should test your code on the website and then paste your solution into your VSCode file in `Recursion.java`.

b. CodingBat does some work behind the scenes to let you just put in the function. To run your functions locally, you'll need to make them `static` so that you don't have to create an instance of `Recursion` (since that'd be weird), and then call them in `main`:
```
public static void main(String[] args) {
    System.out.println(Recursion.bunnyEars2(2));
}
```
Make sure that your method outputs `5` when the input is `2`.


## Exercise 2
Write a `static` recursive function that performs exponentiation: it should return a<sup>b</sup> for input parameters `a` and `b`, which are both positive integers. You should not use built-in exponentiation and are limited to only using multiplication.

Remember to test it in `main`.

## Exercise 3
The Fibonacci sequence is the sequence 0, 1, 1, 2, 3, 5, 8, 13,... where the number at index `k` is equal to the sum of the numbers at `k−1` and `k−2`. Write a recursive function for calculating the kth Fibonacci number that does as little repeated work as possible.

You should implement a version that counts up instead of down to reduce the amount of work. You should start with a method signature:
```
public static int fibonacci(int index, int curValue, int prevValue, int targetIndex)
```

where `targetIndex` is `k` and `index` starts at a small number to track where you currently are in the sequence.

Make sure to test your function for a few numbers, for example:
```
System.out.println(Recursion.fibonacci(1, 1, 0, 4));
//Should print 3
```

## Submission
Compress your files as a zip, and upload that zip to Moodle under the appropriate assignment.
Remember that partners need to submit their code separately and you should share the code you wrote in class with your partner.

This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the code to indicate things you tried but what went wrong/where you got stuck.

## Extensions
There are several more recursion activities on CodingBat to try if you'd like more practice with recursion.