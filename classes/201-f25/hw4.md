---
layout: page
title: Homework 4 - Deck of Cards
permalink: /classes/201-f25/hw4
---

**Due: Friday Oct 17th at 10:00pm**

Starter code: [cards-project.zip](cards-project.zip)  
Upload solutions via Gradescope as: `Deck.kt`

## Goals

This assignment is designed to help you with the following:
* practice using doubly linked lists
* practice with null safety in Kotlin

## Collaboration policy

For this assignment, you may work alone or with a partner, but you must type up all of the code yourself.  (It is therefore unexpected for two code submissions to be completely identical.)  You may have at most one partner.

You may also discuss the assignment at a high level with other students.  You can discuss the assignment with Anya, our prefect, or any course staff.

You should list any student or course staff with whom you discussed the assignment (you don't have to include prefect sessions), and the manner of discussion (high level, partner, etc.) in comments at the top of your `Deck.kt` file.  You also need to include your name.

_If you work alone, you should say so instead._

## Note on style:

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
9. The code uses helper functions to reduce duplication and improve readability.

## Assessment

The **core** requirements for your submission are:

* complete Parts A and C
    * A: * `getString(n: Int): String`, `getStringBackwards(n: Int): String`, `countDown(): Int`
    * C: Reflection
* satisfy the code style expectations #0-#4 above
* include a reflection in comments at the bottom of your `Deck.kt` file

The **advanced** requirements for your submission are:

* satisfy core requirements
* complete all of Parts A-C
    * B: `swapJokerA()`, `swapJokerB()`, `tripleCut()`
* satisfy all code style expectations listed above (#0-#9)
* include your name and collaboration statement at the top of your `Deck.kt` file

## Assignment overview

There is a fun encryption technique called the [Solitaire Cipher](https://en.wikipedia.org/wiki/Solitaire_(cipher)).  It's a hard-to-crack encryption approach designed for sending secure messages with very low tech.  The technique is based on using a deck of cards, and performing a variety of operations on that deck.  We're going to represent that deck of cards as a circular linked list, and implement some of the operations of the encryption technique.

We'll be using a specialized card deck that has 28 cards in it, each numbered with an integer from 1 to 28.  We'll refer to the cards numbered 27 and 28 as "jokers", because if we were doing this with a real deck of playing cards we would use [joker cards](https://en.wikipedia.org/wiki/Joker_(playing_card)).

To be clear, we're not going to implement the (super cool!) encryption algorithm itself, although that would be a fantastic extension if you're interested.  We're going to do a subset of it, which is a series of operations on playing cards.

## Getting started

Find your `cs201` folder for assignments.  Maybe it contains an `assignments` folder inside of it.

Download [this `cards-project.zip` file](/classes/201-f25/cards-project.zip) to get the starter code.  Put it in the `cs201` folder you have and unzip it.  This should give you a folder named `cards-project`.  Make sure that you actually unzip / extract the code, don't just open up the .zip file in another window.

Now open your folder in VS Code.  There are multiple ways to do this, so pick one:
* Open VS Code, then select `File` -> `Open Folder` and navigate to the `cards-project` folder you just made.
* Open VS Code, then drag and drop the folder (e.g., from Finder in MacOS or File Explorer in Windows) into VS Code to open it.

Either way, if you are asked, click that you trust the authors.  If you have any issues getting started, ask the lab assistants for help -- any of them should be able to help you get started, even if they aren't super familiar with Kotlin.

## Building your code with Maven

Like Assignments #1 and #3, this project structure uses Maven, so you can use the following commands (in the VS Code terminal) to execute your code (note that you must be in the top-level folder `cards-project` for these commands to work):

* `mvn test` runs the tests that we provided (see below)

* `mvn compile exec:java` compiles and runs your code, as specified in your `main` function

* `mvn compile` compiles your code, but doesn't run it (this is like `kotlinc` by itself)

If you want to see less output from Maven, you can add `-q` (for "quiet") flag:

* `mvn -q test` run tests, with less output

* `mvn -q compile exec:java` runs your `main` function, with less output (but still any print statements you have)

If you run the tests with the starter code, you should have errors, as you haven't written any code yet.

## Representing a deck of cards

In this assignment, you are provided with a class `Deck` that maintains the list of numbers (1-28) in a **circular doubly linked list**.  A doubly linked list is one where each node has two pointers: one points to the next node, and the other points to the previous one.  A circular linked list is one where the very last item in the list points to the first one.

It turns out the deck-rearranging algorithm described above is more straightforward if your deck can be thought of as one big circle of cards that you can flip through in either direction.  The actual ordering of the numbers is provided as a `String`, which contains the numbers in some given order, on a single line, separated by spaces.

The constructor for the deck, **which is provided for you**, looks like this:

```kotlin
Deck(initialCardOrdering: String)
```

Your assignment is to enhance the class by adding several member functions, described in more detail below and listed here:
* `getString(n: Int): String`
* `getStringBackwards(n: Int): String`
* `countDown(): Int`
* `swapJokerA()`
* `swapJokerB()`
* `tripleCut()`

## Part A: Querying the deck of cards

For Part A, you should complete the first three methods listed above.  They are each described in more detail below.

### `getString(n: Int): String`

>This method should return a space-delimited `String` consisting of `n` numbers from your deck.  Note that `n` is an `Int` greater than or equal to 1, but it can be larger than 28.  If it is, your deck should start over from the top and keep adding to the string.
>
>Make sure to get your items efficiently: you shouldn't be doing something super-duper slow like "find the first item in the list, add it to the string, then start at the beginning and find the second item, add it to the string, then start at the beginning and find the third item, etc.".

### `getStringBackwards(n: Int): String`

>This method works ust like `getString`, except that it starts at the last number in the deck and works backwards.  Like `getString`, `n` can be larger than 28, in which case it will wrap around.

### `countDown(): Int`

>This method looks at the top card's value (if the top card is a joker, assume its value is 27, even if it's actually 28).  It leaves that card on top of the deck.
>
>Given the value of the top card, it should count down the deck by that many cards, starting with the top one.  Record the value of the _**next**_ card that is in the deck, but don't remove it from the deck.
>
>If the original ordering of our cards is as follows:
>```
>1 4 7 10 13 16 19 22 25 28 3 6 9 12 15 18 21 24 27 2 5 8 11 14 17 20 23 26
>^ ^
>```
>
>Then we would find a `1`, and return `4`, because that is the **next** card after the 1st card in the deck.
>
>If instead this were our ordering:
>```
>5 8 11 14 17 20 23 26 28 9 12 15 18 21 24 2 27 1 4 7 10 13 16 19 22 25 3 6
>^            ^^
>```
>
>Then it would find a `5` and return `20`.

# Part B: Reordering a deck of cards

For Part B, you will complete the last three methods listed above.  They are each described in more detail below.

### `swapJokerA()`

>This method first finds the `27`, which we'll call "Joker A".  It exchanges it with the card beneath (after) it in the deck, which moves Joker A down the deck by one position.
>
>For example, suppose that the original ordering of our cards is as given below:
>```
>1 4 7 10 13 16 19 22 25 28 3 6 9 12 15 18 21 24 27 2 5 8 11 14 17 20 23 26
>```
>
>Then `swapJokerA()` would swap the node holding `27` with the node following it.  In this case, that means the `27` and `2` should be swapped:
>```
>1 4 7 10 13 16 19 22 25 28 3 6 9 12 15 18 21 24 2 27 5 8 11 14 17 20 23 26
>                                                ^^^^
>```

### `swapJokerB()`

>This method is similar to `swapJokerB()`, with a few key differences.  First, it finds the `28`, which we'll call "Joker B".  It then moves it two cards down by performing two exchanges.
>
>For example, if we started with the deck above after doing `swapJokerA()`, we would then move `28` two places down the list.  It ends up between the `6` and `9`:
>```
>1 4 7 10 13 16 19 22 25 3 6 28 9 12 15 18 21 24 2 27 5 8 11 14 17 20 23 26
>                          ^^^^^^
>```

### `tripleCut()`

>This final method swaps all of the cards above the first joker (whichever is closest to the top of the deck) with the cards below the second joker.
>
>For example, if we started with the above deck after `swapJokerB()`, everything above the first joker (`28` in this case) goes to the bottom ("back") of the deck, and everything below the second joker (`27`) goes to the top ("front"):
>```
>5 8 11 14 17 20 23 26 28 9 12 15 18 21 24 2 27 1 4 7 10 13 16 19 22 25 3 6
>^^^^^^^^^^^^^^^^^^^^^                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^
>```

# Part C: Reflection

Were there any particular issues or challenges you dealt with in completing this assignment?  How long did you spend on this assignment?

Write a brief discussion (a sentence or two is fine) at the bottom of your `Deck.kt` file (in comments, so each line should start with `//` or be in a `/* */` block).

Here are some examples:

```kotlin
// Reflection:
// I had trouble finding the start of the deck.
// I had to look up how to deal with null safety and !! in Kotlin.
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

* If you get errors related to "null" or "null safety", you may be missing `!!`.  For example, if `node` may possibly be `null`, you may need `node!!.null` if *you* know it cannot be but the *compiler* doesn't seem to.

* Try to complete `getString` and `getStringBackwards` early, to see if you're having any issues walking the linked list in either direction.

* Take a look at the `Node` class to see both pointers and the `value` (which we've called `item` in class).

* When you're working on `swapJokerA`, think carefully about what should happen if Joker A was originally at the "top" (beginning?) or "bottom" (end?) of the deck of cards.

&nbsp;