---
layout: page
title: Kotlin Scavenger Hunt
permalink: /classes/201-f25/kotlin-lab
---

In this lab, you will explore the difference between Python and Kotlin.  You will generate a reference sheet for yourself to use throughout the term as you write your own Kotlin programs.

## Submission

As with all labs in this class, you can earn an additional engagement credit by completing the lab and submitting the required evidence on Moodle under today's in class section.

## Kotlin

Learning your second programming language is a different experience from learning your first -- you already know the basics of programming, including the concepts of `if` statements and `for` loops, defining variables and writing functions, and printing output for the user to see.  For your second language, it's much more about specific syntax, rather than also learning the fundamental programming concepts.

You will likely experience that learning Kotlin is faster than learning your first language, but that doesn't make it inherently easy.  You may not find it "easy" to learn a new language until your fourth or fifth time.  Still, this lab is designed to help ease your transition into Kotlin.

## Getting started

We'll be working with a set of files in both Python and Kotlin.  To get started, follow these steps:

1. [Download this .zip file](Comparing-Python-and-Kotlin.zip) and then double-click to unzip it.  You'll now have a folder named `Comparing-Python-and-Kotlin`.

2. [Mount the COURSES drive](https://stolafcarleton.teamdynamix.com/TDClient/3356/Portal/KB/ArticleDet?ID=152558) and copy the `Comparing-Python-and-Kotlin` folder into your `STUWORK/username` folder.  **When you log out of the computer, everything not in this folder gets deleted!**

3. Open VS Code.

4. Open the `Comparing-Python-and-Kotlin` folder in VS Code, either by clicking and dragging the folder icon or by going to `File` -> `Open Folder`.

## Exercise 1

The files in `Comparing-Python-and-Kotlin` contain programs in both Python and Kotlin that do the same things.  Your goal is to look through them to fill in a reference sheet of how to write Kotlin code.  If you get stuck, look through the Python code first, then switch over to the corresponding Kotlin file.

1. First, it's important to write pseudocode as comments.  Find out how to do both **multi-line and single-line comments in Kotlin and write down examples in your reference sheet**.

2. Your first program in any language will typically be a "Hello, world!" program, in part because it teaches you how to write a main function, print statements, and specify strings.  Find an example of the **boiler-plate code** to successfully print "Hello, world!" and put it in your reference sheet.  (Hint: try `Hello.kt`.)

3. Finally, you'll need to make lots of variables.  Find an example of **making a variable** and add it to your reference sheet.  Can you figure out why some are specified with `val` and others with `var`?

## Exercise 2

Now, let's explore some interesting things in Kotlin.

1. Find examples of a **for loop** and a **while loop** and put them in your reference sheet.

2. Find an example of a **conditional** and put it in your reference sheet.

3. Find an example of **printing a variable's value** and put it in your reference sheet.

4. Find an exmaple of **reading from a file** and put it in your reference sheet.

## Exercise 3

We'll talk about lists more in depth in the coming weeks, but you'll probably want to use one sooner rather than later.  Find examples of:

1. **making** a list

2. **adding to** a list

3. **getting an item from** a list

4. **looping over the items** in a list

## Exercise 4

Here are some other interesting things you might want to do.  If any of these things aren't familiar to you, please ask your neighbor, me, or the prefect!  Find examples of:

<!-- 1. Getting a **command-line argument** from the user. -->

1. Making a **constructor for a class**.

2. Instantiating an **instance of a class**.

3. Calling **methods of a class**.

4. **Importing** a Kotlin/Java library.

5. Getting a **random number** (this may require multiple steps...).

If there is anything else that you see in these files that you'd like to keep track of, add it to your reference sheet -- it's for your own benefit!

## Exercise 5

Finally, are you ready to run a Kotlin program?

First you need to compile it.  We'll do this in the terminal:

```bash
kotlinc Hello.kt
```

Then you can run it:

```bash
kotlin HelloKt.class
```

Put these two commands in your reference sheet.

## Submitting

Now take a picture of the first page of your completed reference sheet and upload it to Moodle's "Kotlin Lab Upload" assignment!

## Want more to do?

If you finish that and have time, you can try changing the `Die` class so it rolls the dice one-by-one and waits for the user to tell it to roll the next one (or two?).  _(Hint: See `Conditionals.kt` for an example of getting a number from the user.)_