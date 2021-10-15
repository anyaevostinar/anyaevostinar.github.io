---
layout: page
title: HW 6 Word Counter
permalink: /classes/201-f21/hw6
---

## Logistics
30 points, due Friday Oct 29th by 10PM Central time. Like all assignments, there is a 48-hour, no questions asked extensions policy. If you have a tech issue, a health issue, or some other issue that impedes making the deadline, use this policy.  You or your partner need to notify me that you're using the policy via email, CC'ing the partner. Extensions beyond the 48-hour policy will only be considered in extenuating circumstances, and circumstances that arise between the original deadline and the extension are generally not extenuating - the deadline is still Friday, not 48 hours later.

## Goals
To implement a particular tree structure and use it to store words and counts. You'll generalize some of the ideas that you've been learning about trees to a slightly different tree structure. Also to practice recursion on trees.

## Assignment Type and Collaborative Learning Expectations
This is a homework assignment that you'll be handing in on Moodle.

You must work on this homework with your assigned partner (if you have one) via pair programming. That means that you cannot write **any** code without your partner and you must both be fully engaged and discussing the code at all times while working. See the [collaboration policy](collaboration) for details.

## Setup and Requirements
Mount COURSES, download the [HW 6 Starter Code](HW6-Starter.zip) and move it to your StuWork/username folder. You should follow the same process of compressing your files and uploading them to Moodle to submit your homework. 

Create a file `Collaborations.txt` and put in any help that you get on this assignment including sources that you reference and help from lab assistants or the prefect. Make sure to refer to the [Collaboration page](collaboration) on what collaborations are allowed for homework assignments.

## What is a Word Cloud
You've probably seen word clouds like the one below generated from Hound of the Baskervilles by Sir Arthur Conan Doyle:

![Words of varying sizes](/classes/201-f20/BaskervillesWordCloud.png)

The neat thing about word clouds is that words are displayed in a size proportional to the number of times they are used in the text on which the cloud is based. (Note that very common words, also known as stopwords, are typically not included in the cloud. Otherwise, all English word clouds would be dominated by "the", "and", "a", "in", etc.) In this assignment, you'll implement a particular type of search tree to count words and their counts in text, allowing you to make your own word clouds.

## WordCountTree
First you'll build a `WordCountTree` class to hold your words and their counts. Your `WordCountTree` will be a particular kind of tree. Each node except for the root will represent a character as well as a count. The children of a node will be characters that could come after the current character to represent a word. To find a word, you'll work down the tree until you reach the final character in the word, and then look at the count for that node. For example, imagine that we had a (very short) book that had the following words and counts:

|Word | Count |
|------|------|
|the | 50 |
|that | 20 |
|cat | 120|
|chomp | 3 |
|then | 7|

The `WordCountTree` would then look like this:

![Tree with nodes showing characters and counts](/classes/201-f20/TreeImage.png)

To trace down the tree to find "the", you would follow the steps:
* You start at the root (which represents an empty string or null character), and then find the child that represents 't'.
* You then find the child of 't' that represents 'h'.
* Then you find the child of 'h' that represents 'e'.
* Since you've now found all of "the", you look at count to see how many times "the" appeared, which is 50.
* If you were looking for "then", you'd start exactly the same way as for "the", but continue on to the child that represents 'n'.

There are a couple of things to note about this tree:
* It's not a binary tree -- each node can have any number of children.
* The ordering of the children doesn't really matter.
* Any node that exists in the tree either has a non-zero count or has a descendant with a non-zero count. (In the above example, the root doesn't have a child that represents 'a' because we didn't see any words stating with 'a'.)

You'll find a `Node` class inside of your `WordCountTree` class like we usually do with trees. You must directly create your tree structure, though you may use Java implementations of other data structures such as `List`s to support your implementation.

Remember that characters are a primitive type in Java:
```
char myChar = 'a';
char nullChar;
char example = myString.charAt(0); //gets the first character in a string myString
```

Your `WordCountTree` must have the constructor and methods below implemented and with properly styled JavaDocs method comments; it may also have any other methods of your choosing (i.e. helper methods are a really good idea).

```

/**
 * Constructs an empty WordCountTree.
 */         
public WordCountTree();
 
/**
 * Adds 1 to the existing count for word, or adds word to the WordCountTree
 * with a count of 1 if it was not already present.
 * Implementation must be recursive, not iterative.
 */
public void incrementCount(String word);
 
/**
 * Returns true if word is stored in this WordCountTree with
 * a count greater than 0, and false otherwise.
 * Implementation must be recursive, not iterative.
 */
public boolean contains(String word);
 
/**
 * Returns the count of word, or -1 if word is not in the WordCountTree.
 * Implementation must be recursive, not iterative.
 */
public int getCount(String word);
 
  
/** 
 * Returns a count of the total number of nodes in the tree. 
 * A tree with only a root is a tree with one node; it is an acceptable
 * implementation to have a tree that represents no words have either
 * 1 node (the root) or 0 nodes.
 * Can be recursive or use an instance variable.
 */
 public int getNodeCount(); 

 ```

For the methods above that must be recursive, it's fine for each one to call a helper method where the recursion actually takes place, and it's also fine if your method implementation includes some loops, as long as there is recursion as well. (Frequently, you might loop over the children while changing levels in the tree recursively.)


### Testing WordCountTree
As always you should test your code as you implement each method. For each required method in `WordCountTree` **you must have an example of it working** in the `main()` method of `WordCountTree.java`. At minimum these examples should call the method and print the results, though double checking the results would be a good additional thing to do.

## WordCounter.java
In order to actually make a word cloud, we need to process a data file and output something useful. 
I've provided you a `WordCounter` class that will use `WordCountTree` to count the words in a text file. WordCounter counts all of the words in the file except "stop words". A list of stop words is included in the download of files for this assignment (`StopWords.txt`); your WordCounter can assume that this file is present in the same directory where it is being run.

You need to write the `main` of WordCounter to allow for the user to:
* specify the file to be counted (you can assume that you'll always use the same `StopWords.txt`)
* the number of words that should be in the word cloud (and you should let the user know if that number is too big given the file they chose)

And then you should use `printWordCloudHTML` to print the associated HTML of the word cloud (you can see what you're word clouds look like at [here](https://www.w3schools.com/html/tryit.asp?filename=tryhtml_intro), though it isn't as pretty as the normal ones).
(If the text contains fewer than 40 non-stopwords, then the cloud should just use all the words, and if some words are tied, any method of tie-breaking is fine.)

I've provided you with the text of the book Wuthering Heights, which you can use to ultimately test your word cloud maker, though I recommend you initially start with a smaller file.
The starter code in WordCounter handles normalizing the words to lowercase and remove punctuation.

## README
As always, you should include a detailed README for this homework. 
It should include a brief overview of your project, a short example of how to run your program and see its interesting behavior, and a more detailed section that has **demonstration input or code/line numbers for each of the rubric items**. Remember, you want to make it as easy as possible for the grader to see that your homework does everything its supposed to!

Remember that you should use Word or Google Docs or Markdown to make a nicely formatted README. 
You should not have a README in plain text!

There is no additional prompt for this homework.

## Grading
Your code will be graded on the following rubric:

|Item | Points |
|-----|---------|
|README clear and complete | 6 |
|incrementCount method implemented correctly | 4 | 
|incrementCount method example provided | 1 |
|contains method implemented correctly|4|
|contains method example provided|1|
|getCount method implemented correctly|4| 
|getCount method example provided|1|
|getNodeCount method implemented correctly|4|
|getNodeCount example provided|1|
|WordCounter works as specified | 1 |
|Good style |1|
|JavaDocs style documentation | 2 |


