---
layout: page
title: Homework 6 - Word Counter
permalink: /classes/201-f25/hw6
---

**Due: Friday, Oct 31st, at 10:00pm** (Boo!)

* Starter code: [word_counter.zip](word_counter.zip)  
* Upload solutions via Gradescope as: `WordCountTree.kt`

# Goals

This assignment is designed to help you with the following:
* practice with trees
* practice with recursion
* practice extending basic data structures for more complex functionality

# Collaboration policy

For this assignment, you may work alone or with a partner, but you must type up all of the code yourself.  (It is therefore unexpected for two code submissions to be completely identical.)  You may have at most one partner.

You may also discuss the assignment at a high level with other students.  You can discuss the assignment with Anya, our prefect, or any course staff.

You should list any student or course staff with whom you discussed the assignment (you don't have to include prefect sessions), and the manner of discussion (high level, partner, etc.) in comments at the top of your `WordCountTree.kt` file.  You also need to include your name.

_If you work alone, you should say so instead._

# Note on style:

The following style guidelines are expected moving forward:

0. You submit only the requested file(s).
1. Variable names should be clear and easy to understand, should _not_ start with a capital letter, and should only be a single letter when appropriate (e.g., `i` or `j` as indices, `x` and `y` as coordinates).
2. The indentation, spacing, and location of curly braces is consistent.
3. There are no extra print statements in your program.
4. There is no commented-out code that is no longer being used (e.g., debugging print statements).
5. Your program has a comment at the top of each function with at least 5 words describing what the function does.
6. There is good use of comments to explain the "why" of your code and empty lines to break up logical chunks.
7. The code doesn't have "magic numbers" -- these are numbers in the code by themselves, rather than stored in a variable.
8. The code doesn't compute the right answer by doing extra work (e.g., having a computation in a loop when it could have been done only once, after the loop).
9. Helper functions are used to reduce code duplication.

# Assessment

The **core requirements** for your submission are:

* complete Parts A and D
    * incrementCount
    * getCount
* makes use of the provided map in the `Node` class
* satisfy the code style expectations #0-#4 above
* include a reflection in comments at the bottom of your `WordCountTree.kt` file

To **demonstrate mastery**, your submission needs to:

* demonstrate proficiency
* complete all of Parts A-D
* implement all functions recursively, not iteratively
* satisfy all code style expectations listed above (#0-#9)
* include your name and collaboration statement at the top of your `WordCountTree.kt` file

# Assignment overview

Perhaps you've seen word clouds before, like [this word cloud on Wikipedia](https://en.wikipedia.org/wiki/Tag_cloud#/media/File:Foundation-l_word_cloud_without_headers_and_quotes.png).  The neat thing about word clouds is that words are displayed in a size proportional to the number of times they are used in the text on which the word cloud is based.

In this assignment, you'll implement a particular type of search tree to count words in a given text, which is a critical task required to produce a word cloud.  (You won't actually get to the step of building the word cloud, but then, summer is coming ;) .)

# Getting started

Find your `cs201` folder for assignments.  Maybe it contains an `assignments` folder inside of it.

Download [this `word_counter.zip` file](../../resources/assignments/word_counter.zip) to get the starter code.  Put it in the `cs201` folder you just created and unzip it.  This should give you a folder named `word_counter`.  Make sure that you actually unzip / extract the code, don't just open up the .zip file in another window.

Now open your folder in VS Code.  There are multiple ways to do this, so pick one:
* Open VS Code, then select `File` -> `Open Folder` and navigate to the `word_counter` folder you just made.
* Open VS Code, then drag and drop the folder (e.g., from Finder in MacOS or File Explorer in Windows) into VS Code to open it.

Either way, if you are asked, click that you trust the authors.  If you have any issues getting started, ask the lab assistants for help -- any of them should be able to help you get started, even if they aren't super familiar with Kotlin.

# Building your code with Maven

Like most of our assignments, this project structure uses Maven, so you can use the following commands (in the VS Code terminal) to execute your code <span style="color: #10a5f5">(note that you must be in the top-level folder `word_counter` for these commands to work)</span>:

* `mvn test` runs the tests that we provided (see below)

* `mvn compile exec:java` compiles and runs your code, as specified in your `main` function

* `mvn compile` compiles your code, but doesn't run it (this is like `kotlinc` by itself)

If you want to see less output from Maven, you can add `-q` (for "quiet") flag:

* `mvn -q test` run tests, with less output

* `mvn -q compile exec:java` runs your `main` function, with less output (but still any print statements you have)

If you run the tests with the starter code, you should have errors, as you haven't written any code yet.

# Counting words using a prefix tree ("trie")

You can implement a word-counting tree as a prefix tree (a.k.a. a trie).  Each node except for the root will represent a character as well as a count.  The children of a node will be characters that could come after the current character to represent a word.

To find a word, you'll work down the tree until you reah the final character in the word, and then look at the count for that node.  For example, imagine that we had a (very short) book that had the following words and counts:

| Word   | Count |
|:-------|------:|
| the    | 50    |
| that   | 20    |
| cat    | 120   |
| chomp  | 3     |
| then   | 7     |

The word-count tree would then look like this:

![Word-Count Tree Example](../images/wct_example.png)

To trace down the tree to find "the" you would take the following steps:

1. Start at the root (which represents an empty string or null character), and then find the child that represents `'t'`.
2. Find the child of `'t'` that represents `'h'`.
3. Find the child of `'h'` that represents `'e'`.
4. You've now found all of the `"the"`, so you look at `count` to see how many times `"the"` appeared, which is 50.
5. If you were looking for `"then"`, you'd start exactly the same way as for `"the"`, but continue onto the node that represents `'n'`.

There are a couple of things to note about this tree:

* It's not a binary tree -- each node can have any number of children.
* The ordering of the children doesn't really matter.
* Any node that exists in the tree either has a non-zero `count` or has a descendant with a non-zero `count`.  (In the above example, the root doesn't have a child that represents `'a'` because we didn't see any words starting with `'a'`.)

# Part A: Basic word-counting functionality

You will implement the above word-counting tree in the `WordCountTree` class in `WordCountTree.kt`.

To get started, take a look at `WordCountTree.kt` and find its private `Node` data class, just like we usually use with trees.  You'll see that each `Node` has a `MutableMap`, which is what you'll use to connect each node to its children.

Your first task is to implement two functions:

* `incrementCount(word: String)` -- Adds 1 to the existing `count` for `word`, or adds `word` with a `count` of 1 if it was not already present.

* `getCount(word: String): Int` -- Returns the `count` of `word` in the prefix tree.

Once you have this basic functionality implemented, you should pass the `testIncrementAndGet` test when you run `mvn test`.

Note: It is important that you do not use any built-in libraries or other functionality that avoids doing it with your own code.  If you are getting around the point of the assignment (i.e., not working with the map in each node, not having a tree represented via connected nodes, etc.) you will not demonstrate Proficiency for this assignment.

# Part B: Use recursion!

You should work to make each of the four functions you'll implement for this assignment (two for Part A and two for Part C) recursive, not iterative.  It is okay for your functions to call a helper method where the recursion actually takes place (like we saw in [`BinarySearchTree.kt`](../../resources/samples/BinarySearchTree.kt)), as long as there is recursion when it goes to the next level of the tree.

Take some time to look through your implementations of `incrementCount` and `getCount` from Part A and make them recursive if they aren't already.

# Part C: Remaining word-counting functionality

Finally, you should implement the remaining functionality.  Here are the last two functions you'll write:

* `contains(word: String): Boolean` -- Returns `true` if `word` is stored in this `WordCountTree` with a `count` greater than 0, and `false` otherwise.

* `getAutocompletionMap(prefix: String): MutableMap<String, Int>` -- Returns a map of all words in the `WordCountTree` that start with the given `prefix`, mapped to their `count`s.

Once you have these two functions working, all tests should pass when you run `mvn test`.

Note that these two functions should also be recursive, as described in [Part B](#part-b-use-recursion).  For `getAutocompletionMap`, you might need to loop over all of the children while changing levels in the tree recursively.

# Part D: Reflection

Were there any particular issues or challenges you dealt with in completing this assignment?  How long did you spend on this assignment?

Write a brief discussion (a sentence or two is fine) at the bottom of your `WordCountTree.kt` file (in comments, so each line should start with `//` or be in a `/* */` block).

Here are some examples:

```kotlin
// Reflection:
// I got really mixed up working with the maps within the nodes.
// I had trouble figuring out how to make my functions recursive.
// I spent 6 hours on this assignment.
```

```kotlin
// Reflection:
// I started late, so I had to rush to make sure I knew how to test my code.
// It may be good to start early next time.
// I spent 5 hours on this assignment.
```

```kotlin
// Reflection:
// It went fine; I found what I needed in my notes.
// I spent 3 hours on this assignment.
```

# Hints and suggestions

* If you are having trouble remembering how to use a `MutableMap` in Kotlin, go back to the [Kotlin Tour](https://kotlinlang.org/docs/kotlin-tour-collections.html#map).

&nbsp;