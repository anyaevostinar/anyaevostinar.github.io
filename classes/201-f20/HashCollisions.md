---
layout: page
title: Collision Resolution Lab
permalink: /classes/201-f20/collisionresolution
---

## Goals
To implement different collision resolution and probing strategies to better understand how they can work and gain awareness of the various challenges to hashing and collision resolution and the myriad of ways they are dealt with.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Wednesday Nov 11th, but isn't due until Friday Nov 13th at 5:00pm Central.

Please create a new Repl project and make it private.

You're welcome to work on this lab with input from one or more members of your collaborative learning group. You should write all of your own code, but you're welcome to share your screen/use multiplayer mode with members of your collaborative learning group to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

## Exercise 0
Using the Add File button on repl.it, add a Collaborations.txt file and describe any interactions you have with your collaborative learning group on this lab. Also note any outside sources such as websites that you referenced.

## Exercise 1
You will implement a simple hash table for this lab.

a. Create a class `HashTable` in its own file. Give this class an instance variable `Integer[] hashTable`.

b. Create a constructor that takes an argument for the number of buckets/slots that the hash table should contain and then instantiate the `Integer` array with the appropriate size.

c. Here is an adapted version of the `compressToSize` function for your `HashTable` class:
```
  /**
    * Compression function that takes a hash code (positive or negative)  and compresses
    * the hash code into the range [0, sizeOfhashTable).
    */
  private int compressToSize(int hashCode) {
    int numberOfBuckets = hashTable.length;
    int compressedValue = hashCode % numberOfBuckets;
    if(compressedValue >= 0) {
      return compressedValue;
    } else {
      return compressedValue+numberOfBuckets;
    }
  }
```

d. Create a simple version of `insertKey(Integer key)` that ignores if another value is already in the hash table and just places the key at the location determined by `compressToSize`.

e. Create a new `HashTable` of size 10 in the `main` function and insert a value into it. Print out the contents of your `HashTable` to verify that it is working as expected (you may want to make a `toString()` method to make this easier).

## Exercise 2
You'll now implement linear probing to deal with collision resolution.

a. Update `insertKey` to use the linear probing strategy discussed in the reading where if the home position is taken, you just move to the left by one until you find an open position.

b. Test your linear probing strategy by inserting 9877, 9050, 2037, 1059, and 7200 and making sure the contents of your hash table match the reading.

## Exercise 3
You can clearly see the issue of primary clustering in Exercise 2. One way of improving your collision resolution is to move left by more than 1 when linear probing.

a. Create a new function `insertKey2(Integer key)` that does the same as `insertKey` but skips by 3 instead of 1 (you can change `i++` to `i+=3`).

b. Note that I had you skip 3, not 2. Think about what would happen if you skipped 2 with this particular hash table size and make sure you understand why 3 is preferrable.

## Exercise 4
The issue with linear probing by more than 1 is that you have to make sure your skip amount is relatively prime to the size of your table, otherwise you will end up not checking certain spots in the hashtable at all on certain hash codes. There are a number of other techniques that can help with that, however they still run into the problem of **secondary clustering** where all the keys that hash to the same hashcode will follow the same probing sequence, leading to a lot of collision resolution work. 

You can use a technique called **double hashing** where the probe technique uses the original key so that different keys with the same hash code follow a different probe sequence.

a. Create a new function `insertKey3(Integer key)` that calculates the skip size with the following function:
```
skipSize = 1 + (key % (hashTable.length - 1))
```

b. Note that this function only works well when the table size is prime, so change the table size to 11 and then insert the values 55, 66, 11, and 24. You should get the following table:
```
55, 24, 11, null, null, null, null, 66, null, null, null, 
```

Why this function works well with prime table sizes is not something we will discuss in this class and there are many other hashing techniques. You can read about these and more in the [OpenDSA reading on Improved Collision Resolution](https://opendsa-server.cs.vt.edu/OpenDSA/Books/CS3/html/HashCImproved.html) if you are interested.

## Submitting
This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the document to indicate things you tried but what went wrong/where you got stuck. Feedback on labs and activities is less detailed than on homework.

Submit your zip file to Moodle as always.

## Extensions
Hashing is an active area of research, so there is a lot more that you could do if you are interested.

* In this lab you aren't required to implement a retrieval method because it is nearly identical to the insert method. Feel free to implement them if you want.
* A number of other collision resolution techniques are discussing in the reading linked above, implement some or all of them if you have time.
* This lab is set up with a lot of repeated code and a need to switch around functions used. Feel free to refactor to a more elegant way of changing probing sequences, probably setting the technique in the constructor would be best.