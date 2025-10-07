---
layout: page
title: Hashing Lab
permalink: /classes/201-f25/hashing
published: true
---

## Goals
To work with different hash code generating functions and gain a better understanding of how characteristics of the hash code relate to collisions.

## Setup
Mount the COURSES drive and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HashingLab`
* Download the [starter code](/classes/201-f25/HashTable.kt) and put it into your lab folder
* Open your `HashingLab` folder in VSCode

## Exercise 1
Determine and write on your worksheet the hashcode for each of the potential `hashCode` functions for each of the following words (you may find this [ASCII chart](/classes/201-f25/ASCII%20Conversion%20Chart.pdf) helpful):

* ant
* tan
* mop
* tiger

Then implement each of the functions and check that they are working as you expect.

## Exercise 2
Now you get to implement your own hash table!

Usually you will need a compression function that takes a hash value and makes sure that it fits within a hashtable of a specific size. The function `compressToSize` does this by performing a modulo operation (which determines the remainder of a diversion operation). Things get a bit weird with negative values, so it adjusts for that.


Implement `insertKey` to use one of your `hashCode` functions and the linear probing strategy where if the home position is taken, you just move to the right by one until you find an open position. Make sure to test that things get put into your hash table where you expect before moving on! 

Note: to get the ASCII of a specific character from a string, do `my_str[0].code`


## Exercise 3
One way of improving your collision resolution is to move right by more than 1 when linear probing.

Create a new function `insertKey2(key : String)` that does the same as `insertKey` but skips by 3 instead of 1. (Note that I had you skip 3, not 2. Think about what would happen if you skipped 2 with this particular hash table size and make sure you understand why 3 is preferable.)

## Exercise 4
The issue with linear probing by more than 1 is that you have to make sure your skip amount is relatively prime to the size of your table, otherwise you will end up not checking certain spots in the hashtable at all on certain hash codes. There are a number of other techniques that can help with that, however they still run into the problem of **secondary clustering** where all the keys that hash to the same hashcode will follow the same probing sequence, leading to a lot of collision resolution work. 

You can use a technique called **double hashing** where the probe technique uses the original key so that different keys with the same hash code follow a different probe sequence.

1. Create a new function `insertKey3(key :String)` that calculates the skip size with the following function:
```kotlin
var skipSize = 1 + (key % (hashTable.size - 1))
```

2. Note that this function only works well when the table size is prime, so change the table size to 11 and then try to come up with some values that will cause secondary clustering (using hashcode1 will make that easier!)

Why this function works well with prime table sizes is not something we will discuss in this class and there are many other hashing techniques. You can read about these and more in the [OpenDSA reading on Improved Collision Resolution](https://opendsa-server.cs.vt.edu/OpenDSA/Books/CS3/html/HashCImproved.html) if you are interested.

Submit your completed `HashTable.kt` to Moodle for an engagement credit.

## Extra
If you finish early, try these. 
Hashing is an active area of research, so there is a lot more that you could do if you are interested.

* In this lab you aren't required to implement a retrieval method because it is nearly identical to the insert method. Implement them!
* A number of other collision resolution techniques are discussed in the reading linked above, implement some or all of them.
* Try to test the effectiveness of preventing collisions of each of your collision resolution approaches.
* This lab is set up with a lot of repeated code and a need to switch around functions used. Feel free to refactor to a more elegant way of changing probing sequences, probably setting the technique in the constructor would be best. Or the command line!