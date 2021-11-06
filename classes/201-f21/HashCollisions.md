---
layout: page
title: Collision Resolution Lab
permalink: /classes/201-f21/collisionresolution
published: false
---

## Goals
To implement different collision resolution and probing strategies to better understand how they can work and gain awareness of the various challenges to hashing and collision resolution and the myriad of ways they are dealt with.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Wednesday Nov 10th, but isn't due until Friday Nov 12th at 5:00pm Central.

You should work on this with your in-class partner, but you both need to submit separately. 
If you finish it outside of class without your partner, note which sections you completed together and which you completed separately in your `Collaborations.txt`.

## Setup
[Mount the COURSES drive](https://wiki.carleton.edu/pages/viewpage.action?spaceKey=carl&title=CS+111+and+201+workflow+in+CS+labs) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `CollisionsLab`
* Create your `Collaborations.txt` document in that folder
* Download the [starter code](HashTable.java) and put it into your lab folder
* Open your `CollisionsLab` folder in VSCode

## Exercise 1
You will implement a simple hash table for this lab.

a. Within `HashTable`, create a constructor that takes an argument for the number of buckets/slots that the hash table should contain and then instantiate the `Integer` array with the appropriate size.

b. Create a simple version of `insertKey(Integer key)` that ignores if another value is already in the hash table and just places the key at the location determined by `compressToSize`.

c. Create a new `HashTable` of size 10 in the `main` function and insert a value into it. Print out the contents of your `HashTable` to verify that it is working as expected (you may want to make a `toString()` method to make this easier).

## Exercise 2
You'll now implement linear probing to deal with collision resolution.

a. Update `insertKey` to use the linear probing strategy discussed in the reading where if the home position is taken, you just move to the right by one until you find an open position.

b. Test your linear probing strategy by inserting 9877, 9050, 2037, 1059, and 7200 and making sure the contents of your hash table match the reading.

## Exercise 3
You can clearly see the issue of primary clustering in Exercise 2. One way of improving your collision resolution is to move right by more than 1 when linear probing.

a. Create a new function `insertKey2(Integer key)` that does the same as `insertKey` but skips by 3 instead of 1 (you can change `i++` to `i+=3`).

b. Note that I had you skip 3, not 2. Think about what would happen if you skipped 2 with this particular hash table size and make sure you understand why 3 is preferable.

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

## Extensions
If you finish early, try these. 
Hashing is an active area of research, so there is a lot more that you could do if you are interested.

* Try using one of the hashing methods from Monday's lab to allow you to store strings in your hash table.
* In this lab you aren't required to implement a retrieval method because it is nearly identical to the insert method. Feel free to implement them if you want.
* A number of other collision resolution techniques are discussed in the reading linked above, implement some or all of them if you have time.
* This lab is set up with a lot of repeated code and a need to switch around functions used. Feel free to refactor to a more elegant way of changing probing sequences, probably setting the technique in the constructor would be best.

## Submission
Compress your files as a zip, and upload that zip to Moodle under the appropriate assignment.
Remember that partners need to submit their code separately and you should share the code you wrote in class with your partner.

This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the code to indicate things you tried but what went wrong/where you got stuck.

