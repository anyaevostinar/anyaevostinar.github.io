---
layout: page
title: Hashing Lab
permalink: /classes/201-w24/hashing
published: true
---

## Goals
To work with different hash code generating functions and gain a better understanding of how characteristics of the hash code relate to collisions.

## Setup
[Mount the COURSES drive](getting-started) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HashingLab`
* Download the [starter code](/classes/201-w24/Hashing-Lab.zip) and put it into your lab folder
* Open your `HashingLab` folder in VSCode

## Exercise 1
a. Determine and write on your worksheet the hashcode for each of the provided `hashCode` functions for each of the following words:

* ant
* tan
* mop
* tiger

## Exercise 2
Usually you will need a compression function that takes a hash value and makes sure that it fits within a hashtable of a specific size. The function `compressToSize(int, int)` does this by performing a modulo operation (which determines the remainder of a diversion operation). Things get a bit weird with negative values, so it adjusts for that.

a. Think about how a hashtable with 1,000 slots versus 10,000 slots would affect the number of words that hash to the same value using the provided compression function. On your worksheet, write your answer for each hashcode function.

b. Use the function `printCollisionInformation` to test 1000 slots (also called buckets) versus 10,000 for `words.txt` and write down your results. Make sure you understand what each number reported means!

c. Run the same experiment with the text file `HoundOfTheBaskervilles.txt` and report on what if any difference there is and why that would be the case. 

## Exercise 3
Finally, repeat your experiments for hashtable sizes of 2039 (a prime number) and 2048 (a non-prime number). Write down your results as well as what difference if any you see between them. 

## Exercise 4
Now you get to implement your own hash table! Look through `HashTable.java` to see a basic hash table that doesn't deal with collisions. Your job is to implement linear probing to deal with collision resolution.

a. Update `insertKey` to use the linear probing strategy where if the home position is taken, you just move to the right by one until you find an open position.

b. Test your linear probing strategy by inserting 9877, 9050, 2037, 1059, and 7200 and making sure the contents of your hash table are:

```bash
9050 7200 null null null null null 9877 2037 1059
```

## Exercise 5
You can clearly see the issue of primary clustering in Exercise 4. One way of improving your collision resolution is to move right by more than 1 when linear probing.

a. Create a new function `insertKey2(Integer key)` that does the same as `insertKey` but skips by 3 instead of 1. (Note that I had you skip 3, not 2. Think about what would happen if you skipped 2 with this particular hash table size and make sure you understand why 3 is preferable.)

## Exercise 6
The issue with linear probing by more than 1 is that you have to make sure your skip amount is relatively prime to the size of your table, otherwise you will end up not checking certain spots in the hashtable at all on certain hash codes. There are a number of other techniques that can help with that, however they still run into the problem of **secondary clustering** where all the keys that hash to the same hashcode will follow the same probing sequence, leading to a lot of collision resolution work. 

You can use a technique called **double hashing** where the probe technique uses the original key so that different keys with the same hash code follow a different probe sequence.

a. Create a new function `insertKey3(Integer key)` that calculates the skip size with the following function:
```java
skipSize = 1 + (key % (hashTable.length - 1))
```

b. Note that this function only works well when the table size is prime, so change the table size to 11 and then insert the values 55, 66, 11, and 24. You should get the following table:

```bash
55, 24, 11, null, null, null, null, 66, null, null, null, 
```

Why this function works well with prime table sizes is not something we will discuss in this class and there are many other hashing techniques. You can read about these and more in the [OpenDSA reading on Improved Collision Resolution](https://opendsa-server.cs.vt.edu/OpenDSA/Books/CS3/html/HashCImproved.html) if you are interested.

## Extra
If you finish early, try these. 
Hashing is an active area of research, so there is a lot more that you could do if you are interested.

* Try using one of the hashing methods from the first part of the lab to allow you to store strings in your hash table.
* In this lab you aren't required to implement a retrieval method because it is nearly identical to the insert method. Implement them!
* A number of other collision resolution techniques are discussed in the reading linked above, implement some or all of them.
* Try to test the effectiveness of preventing collisions of each of your collision resolution approaches.
* This lab is set up with a lot of repeated code and a need to switch around functions used. Feel free to refactor to a more elegant way of changing probing sequences, probably setting the technique in the constructor would be best.