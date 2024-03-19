---
layout: page
title: Java Scavenger Hunt
permalink: /classes/201-s24/java_scavenger
published: true
---

# Goals
To get started understanding the differences between Java and Python and create a reference sheet for yourself to use throughout the term as you write your own Java programs.

## Logistics
This is a lab assignment and so you will not be submitting it. However, the concepts and practice will help you on both the homework and quizzes so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

## Java Basics
Learning your second programming language is different from learning your first.
You already know about many of the nearly-universal language constructs: variables, loops, conditionals, functions, operators, (often) classes, etc. Learning the second language involves a lot of learning new syntax for old ideas, rather than learning both the ideas and the syntax at the same time.

As a result, learning your second language typically goes more quickly than learning the first. 
That doesn't mean the second one is easy to learn — “easy” starts to happen around the fourth or fifth language — but there are definitely opportunities to learn more efficiently the second time around.
This lab will guide you through making a reference sheet of the important things in Java.

## Exercise 0

b. Download the [Comparing Python and Java](/classes/201-w24/Comparing-Python-and-Java.zip) project, double-click it to unzip it into a folder.

c. (If you haven't already) [Mount the COURSES drive](https://stolafcarleton.teamdynamix.com/TDClient/3356/Portal/KB/ArticleDet?ID=152558) and move the `Comparing Python and Java` folder into your STUWORK/username folder so that you don't lose it. **If you don't do this, everything you write will disappear when you log out!!!!**

c. Open VSCode.

d. Click and drag the `Comparing Python and Java` folder in Visual Studio Code. 

## Exercise 1
The files in "Comparing Python and Java" contain programs in both Python and Java that do the same things and these will be a valuable resource in figuring out how to do things in Java. 
To get you used to looking through these files, I'm going to ask you to find examples of doing various common programming tasks and write them down on your reference sheet.
If you are stuck, I recommend looking through the Python examples until you find what you are looking for, and then looking at the corresponding Java example.

a. First things first, it's good to know how to write pseudocode as comments. Find how to do both **multi-line and single line comments in Java and write down examples in your reference sheet**. (Hint, look in `CommandLine.java` for examples of both.)

b. Java requires a fair amount of 'boiler plate' code to do even a basic Hello World. Find an example of that **boiler plate code and put it in your reference sheet**. (Hint, `Hello.java` is a good place to look.)

c. Finally, find an example of **making a variable** and add it to your reference sheet. (Hint, `Loops.java` is a good place to look.)

## Exercise 2
Next, let's figure out how to do some interesting things in Java.

a. Find an example of a **for-loop and while-loop** and put it in your reference sheet.

b. Find an example of a **conditional** and put it in your reference sheet.

c. Find an example of **printing** and put it in your reference sheet.

d. Find an example of **reading from a file** and put it in your reference sheet. (Hint, `LineReader.java` is a good place to look.)

## Exercise 3
We'll talk about **lists** more in depth in the coming weeks, but you probably will want to use one sooner rather than later.

Find examples of:

a. **Making** a list

b. **Adding to** a list

c. **Getting an item from** a list

d. **Looping over the items** in a list

## Exercise 4
Here are some other interesting things you might want to do.
If any of these are things you aren't familiar with at all, please ask your partner, me, or the prefect.

Find examples of:

a. Getting a **command line argument** from the user.

b. Making a **constructor for a class**

c. Instantiating an **instance of a class**

d. Calling **methods of a class**

e. **Importing** a Java library

f. Getting a **random number** (note there are three steps required)

If there is anything else that you see in these files that you'd like to keep track of how to do, feel free to add it to your reference sheet; it's for you after all!

## Exercise 5
Finally, you probably want to actually **run a Java program** at some point here right?

To run a Java program, you have to first *compile* it:
```
javac Hello.java
```

And then run it (notice no `.java`!):
```
java Hello
```

Put those two commands in your reference sheet as well.

## Extra
If you finish all of that early, try changing the `Die` class so that it rolls the dice one-by-one and waits for the user to tell it to roll the next one (or two?), using the following code hints:

```java
import java.util.Scanner;

Scanner input = new Scanner(System.in);
String newString = input.next();
Integer newInt = input.nextInt();
```
