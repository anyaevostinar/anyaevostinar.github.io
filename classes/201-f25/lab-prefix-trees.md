---
layout: page
title: Prefix Trees Lab
permalink: /classes/201-f25/prefix-trees-lab
published: true
---

## Goals
To implement an iterative version of a prefix tree.

## Setup
Mount the COURSES drive and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `PrefixTreeLab`
* Download the [starter code](/classes/201-f25/PrefixTreeLab.kt) and put it into your lab folder
* Open your `PrefixTreeLab` folder in VSCode

## Exercise 1
Look at the code in `main` and draw out what the prefix tree should look like for the strings that we will insert.

## Exercise 2
We'll start with `insert`. You should implement it **iteratively**, so you should not call `insert` recursively. Instead, you should use a for loop to iterate over each letter in the key and get the index of the letter in the `childNode` array:

```kotlin
for (letter in key) {
    val index = letter - 'a' //this will get you the index, cool huh??
}
```

You will want to have a structure similar to how you worked with a linked list, such as a `currentNode` that you update with each loop.

Remember to uncomment the `insert` loop in `main` and make sure that your code runs. Note that you can't really see if it worked yet though.

## Exercise 3
Now implement `search` iteratively. You'll want a very similar structure to `insert`.

Test out your code so far and make sure that everything is working as expected!

## Exercise 4
Think about, but don't worry about implementing yet: how would you instead do this implementation recursively? What would you need to change?

Upload your completed lab to Moodle for an extra engagement credit.

## Extra
Time for `delete`! As we discussed, delete has several cases even in just the normal case. I recommend you tackle things in this order:
* If the current node doesn't have a child for the next letter, return false
* Otherwise, figure out how many other children there are (using a loop)
* If there is more than one child, we're going to have to do one of the complicated cases once we get to the last character
* Case 1: just decrement the last character's word count
* Case 2: Break the link to the deleted chain (probably should have saved that node to a variable....)
* Case 3: Break the link to the deleted chain from the root

As you complete each case, consult your drawing and think about which word will test your case. You might need to add more words or make up some pretend words to do your testing.


