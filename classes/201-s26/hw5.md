---
layout: page
title: Homework 5 - Cuckoo Hashing
permalink: /classes/201-f25/hw5
---

**Due: Friday, Oct 24th, at 10:00pm**

* Starter code: [cuckoo_hashing.zip](hw5_starter.zip)  
* Upload solutions via Gradescope as: `CuckooHashMap.kt`

## Goals

This assignment is designed to help you with the following:
* practice with hashing fundamentals
* practice extending basic data structures for more complex functionality

## Collaboration policy

For this assignment, you may work alone or with a partner, but you must type up all of the code yourself.  (It is therefore unexpected for two code submissions to be completely identical.)  You may have at most one partner.

You may also discuss the assignment at a high level with other students.  You can discuss the assignment with Anya, our prefect, or any course staff.

You should list any student or course staff with whom you discussed the assignment (you don't have to include prefect sessions), and the manner of discussion (high level, partner, etc.) in comments at the top of your `CuckooHashMap.kt` file.  You also need to include your name.

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
9. Helper functions are used to reduce code duplication.

## Assessment

The **core** requirements for your submission are:

* complete Parts A, B, and E
    * Basic Hashing
    * Basic Cuckoo Hashing
    * Reflection
* not make use of any built-in hashing-related libraries
* satisfy the code style expectations #0-#4 above
* include a reflection in comments at the bottom of your `CuckooHashMap.kt` file

The **advanced** requirements for your submission are:

* satisfy the core requirements
* complete all of Parts A-E
    * Code Refactoring
    * Complete Cuckoo Hashing
* satisfy all code style expectations listed above (#0-#9)
* include your name and collaboration statement at the top of your `CuckooHashMap.kt` file

## Assignment overview

Hashing in an array, also known as "open addressing", is one of the main approaches to implementing a hashtable.  It's the one that Python uses for its built-in dictionaries.  As we discussed in class, one primary disadvantage of open addressing is the possibility of collisions.  This issue is typically resolved by some form of probing (e.g., linear or quadratic probing).  That works, but it could result in large clusters that cause slow inserts and lookups.

[Cuckoo hashing](https://itu.dk/people/maau/teaching/visualisation/cuckoo-hashing/index.html) is an alternative approach to probing when implementing open addressing.  It guarantees that you can find a value with a maximum of two lookups, no matter what, even if there were collisions when inserting.  The tradeoff is that insertions might be dramatically slower than with probing if collisions occur.  If one has an application where lookup time matters more than insertion time -- which is commonly the case -- then Cuckoo hashing is potentially a reasonable approach.

Cuckoo hashing is named after Cuckoo birds, some of which are known for kicking eggs out of their nests.  The algorithm kicks entries from one table to another.

## Getting started

Find your `cs201` folder for assignments.  Maybe it contains an `assignments` folder inside of it.

Download [this `cuckoo_hashing.zip` file](hw5_starter.zip) to get the starter code.  Put it in the `cs201` folder you just created and unzip it.  Rename the folder `cuckoo_hashing`.  Make sure that you actually unzip / extract the code, don't just open up the .zip file in another window.

Now open your folder in VS Code.  There are multiple ways to do this, so pick one:
* Open VS Code, then select `File` -> `Open Folder` and navigate to the `cuckoo_hashing` folder you just made.
* Open VS Code, then drag and drop the folder (e.g., from Finder in MacOS or File Explorer in Windows) into VS Code to open it.

Either way, if you are asked, click that you trust the authors.  If you have any issues getting started, ask the lab assistants for help -- any of them should be able to help you get started, even if they aren't super familiar with Kotlin.

## Building your code with Maven

Like most of our assignments, this project structure uses Maven, so you can use the following commands (in the VS Code terminal) to execute your code (note that you must be in the top-level folder `cuckoo_hashing` for these commands to work):

* `mvn test` runs the tests that we provided (see below)

* `mvn compile exec:java` compiles and runs your code, as specified in your `main` function

* `mvn compile` compiles your code, but doesn't run it (this is like `kotlinc` by itself)

If you want to see less output from Maven, you can add `-q` (for "quiet") flag:

* `mvn -q test` run tests, with less output

* `mvn -q compile exec:java` runs your `main` function, with less output (but still any print statements you have)

If you run the tests with the starter code, you should have errors, as you haven't written any code yet.

## Cuckoo hashing algorithm

Here are [part 1](https://www.youtube.com/watch?v=GPiJUtdiUlo) and [part 2](https://www.youtube.com/watch?v=wGjOZhK11ms) of a set of videos on Cuckoo hashing.  You are encouraged to watch them to get an idea of how it works.

These are the most important details:

* There are two arrays (acting as individual hash tables) instead of just one.  We'll denote them as table 0 and table 1.

* Each table has its own **separate** hash function that goes with it; we'll call them _h_<sub>_0_</sub> and _h_<sub>_1_</sub>.

* You should implement the Cuckoo hashing algorithm within the `CuckooHashMap<K, V>` class as two functions:

    * `fun set(key: K, value: V)` -- inserts a key-value pair into the hashmap (if the given key is already present in the hashmap, this just replaces the value with the new one)
    * `fun get(key: K): V?` -- looks up the key in the hashmap, returning its value if found or `null` otherwise

### Insertion

Here is an overview of the algorithm for inserting a key-value pair:

1. Try to insert a new entry into the first table as you would in normal hashing.  If this succeeds, then we're done!

2. In the event of a collision, remove the entry that is there (but remember it), then insert the new one.  Now you're stuck holding an entry that was removed.  Try to insert that entry into the second table.  If this succeeds, then we're done!

3. In the event of a collision in the second table, remove the entry that is there (but remember it), then insert the entry you were holding on to.  Now again you are stuck holding an entry.  Try to insert that back into the first table.  If this succeeds, then we're done!

4. In the event of a collision in the first table, remove the entry that is there (but remember it), then insert the entry you were holding on to. Now you are again stuck holding an entry. Try to insert that back into the second table. If this succeeds, then we're done!

5. Keep repeating this process (including switching tables) until you eventually find room to insert something, or until you give up because a certain number of iterations have passed. (This number is configured in `CuckooSetup.kt`.)

6. If you gave up in the repetition in the previous step because too many iterations passed, it likely means a cycle of insertions happened, and that you'll never actually succeed.  So, pick two completely new hash functions _h_<sub>_0_</sub> and _h_<sub>_1_</sub> for the two tables, then rehash everything in them so they land in completely new locations, and start the whole insertion process again back at Step 1.  (If you make it back to Step 5, just keep rehashing and repeating...) Note that there is starter code that helps with this.

_Note: Check out the code in `CuckooSetup.kt`.  You are expected to read through it before trying to start, so you at least know what is there.  You should not make any changes to this file, but you'll want to use what you find._

### Retrieval

The lookup process is fairly straightforward when using Cuckoo hashing, due to the guarantee that we only have to check each table once, and there isn't any probing.  Something is in its place or it's not there.

Here is an overview of the algorithm for looking up the value for a key:

1. Look the key up in the first table exactly as you would in normal hashing.  If you find it, you're done!

2. If you didn't find it in the first table, try looking it up in the second table using the hash function for that table.  If you find it, you're done!

3. If you didn't find the key in either table, then you know it isn't present, so return `null`.

### Generating lots of hash functions

As mentioned in Step 6 for [insertion](#insertion) above, Cuckoo hashing requires that we can keep creating new hash functions as needed.  For this assignment, we're going to leverage a pseudo-random number generator.  Specifically, we'll use the fact that we can give it a seed, and have it generate for us a predictable random number (so it works for insertion and later retrieval).  Here's the code we'll use, which you'll find in `CuckooSetup.kt`:

```kotlin
    var seed = 0

    fun cuckooHashCode(tableNum: Int, key: K): Int {
        val multiplier = Random(2 * seed + tableNum).nextInt()
        val newHashCode = multiplier * key.hashCode()
        return abs(newHashCode)
    }
```

The function `cuckooHashCode` takes in a table number (which should be `0` or `1`) and a key.  It then generates a predictable-yet-random-seeming hash value.  Whenever we want to create a new set of hash functions, we just increment the seed.

## Part A: Basic hashing functionality

To get started, you should implement `set` and `get`, but only working within a single table.  In other words, you can assume you live in a perfect world in which collisions never occur.  You don't need to use the second hash table yet.

Here's a simplified version of the algorithm for each function:

* Inserting a key-value pair:

    1. Try to insert a new entry into the first table as you would in normal hashing.  This will succeed, because the world is perfect and nothing ever collides.

* Looking up the value for a key:

    1. Look the key up in the first table exactly as you would in normal hashing.  If you find it, you're done!

    2. If you didn't find it in the first table, then you know it isn't present, because the world is perfect and this is only place it would have been, so return `null`.

Once you have this basic functionality implemented, you should pass the `oneTableNoRehashingNeeded` test when you run `mvn test`.

Note: It is important that you do not use any built-in hashing-related libraries.  You have to do this yourself with the arrays of `Entry<K, V>?` in `tables`.

## Part B: Basic Cuckoo hashing

As the next step, you'll extend your work from the previous part to incorporate the second table.  This means that collisions can occur, but you can assume that you'll be able to use the second table without any additional complexity.

Here's the updated subset of the algorithm for each function:

* Inserting a key-value pair:

    1. Try to insert a new entry into the first table as you would in normal hashing.  If this succeeds, then we're done!

    2. In the event of a collision, remove the entry that is there (but remember it), then insert the new one.  Now you're stuck holding an entry that was removed.  Try to insert that entry into the second table.  This will succeed, because the world is perfect and nothing ever collides in the second table.

* Looking up the value for a key:

    1. Look the key up in the first table exactly as you would in normal hashing.  If you find it, you're done!

    2. If you didn't find it in the first table, try looking it up in the second table using the hash function for that table.  If you find it, you're done!

    3. If you didn't find the key in either table, then you know it isn't present, so return `null`.

Once you have this additional functionality implemented, you should pass both the `oneTableNoRehashingNeeded` and `noRehashingNeeded` tests in `mvn test`.

Note: Insertion is what makes Cuckoo hashing complex, so by now you have completed implementing `get`!

## Part C: Code refactoring

It is important that you avoid duplicated code.  By now, you likely have similar code, for example, to look up a value in the first table and the second using their respective hash functions.  Look for any such repeated code, and write one or more helper functions to simplify your `get` and `set` implementations.  **You will need to write some helper functions to earn Advanced on this assignment.**

For example, you may add a function that adds or updates the key/value pair in the given table, and returns the entry that was evicted, or `null` if no entry was previously stored in that location.  This could be its signature:
```kotlin
    private fun addOrUpdate(key: K, value: V, tableNum: Int): Entry<K, V>?
```

## Part D: Complete Cuckoo hashing

As a final step, you should complete the entire implementation for insertion using the Cuckoo hashing algorithm (see [above](#insertion)).

## Part E: Reflection

Were there any particular issues or challenges you dealt with in completing this assignment?  How long did you spend on this assignment?

Write a brief discussion (a sentence or two is fine) at the bottom of your `CuckooHashMap.kt` file (in comments, so each line should start with `//` or be in a `/* */` block).

Here are some examples:

```kotlin
// Reflection:
// I got really mixed up making sense of the two tables.
// I had trouble figuring out how to invoke the right hash function for table 0.
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

## Hints and suggestions

* There is a function named `display` that will print out both hash tables.  You should use it regularly by adding code to `Main.kt` and running `mvn compile exec:java` to make sure that `set` and `get` seem to be behaving correctly on simple cases you come up with.  This will make debugging much, much easier.

* You can choose how to implement `set`, but here's one approach you can take:

    1. Create a private helper function named `insert` that does the real work of inserting the key and value into the hash tables.  If `insert` succeeds, it returns `null`; if it fails because it loops too many times trying, it returns the key/value pair that was most recently kicked out while trying to insert.

    2. Then, create a private helper function named `rehash` that also takes a key/value pair to insert.  This function can be called when an insert or a previous rehash has failed.  It just increments the seed, then tries to insert the key/value pair that was passed in.  If it succeeds, then it loops over both tables looking for entries.  Each time it finds an entry, it takes it out (setting the location in the table to `null`) and then tries to reinsert it.  At any time, if `insert` fails and kicks out an entry, the `rehash` function also gives up and returns that entry.  If `rehash` succeeds, it returns `null`.

    3. You can create a very short private helper function named `rehashUntilSuccess` that takes a key/value pair and calls `rehash` in a while loop, doing so over and over until `rehash` succeeds.

    4. Finally, the `set` function can just call `insert` with the new key/value pair, and if it fails, it can call `rehashUntilSuccess`.

&nbsp;