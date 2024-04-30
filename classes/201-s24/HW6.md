---
layout: page
title: HW 6 Word Counter
permalink: /classes/201-s24/hw6
---

## Logistics
This is a paired assignment, so you should complete it with your assigned partner, if you have one, via paired programming. The whole time that you are working, you should both be present and actively working on the problem at hand. (Two brains, one keyboard.) Switch off the typing duties so that you each type for roughly half of the time.

You are able to get help from many sources as detailed in the [collaboration policy](collaboration).

This assignment is due on Wednesday May 8th at 10pm. As with all assignments, you will have the opportunity to [revise](revision-process) this assignment individually based on the feedback that you get.

## Goals
To implement a particular tree structure and use it to store words and counts. You'll generalize some of the ideas that you've been learning about trees to a slightly different tree structure. Also to practice recursion on trees.

## Assessment
To demonstrate proficiency, your program needs to:

* Pass all tests on Gradescope
* Follow the specifications for the command-line
* Implemented `incrementCount`, `contains`, `getCount`, `getNodeCount` and `WordCounter` correctly
* Be object-oriented
* Have a README with an overview and example
* Be somewhat [well-styled](style-reference)

To **demonstrate mastery**, your program needs to:
* Demonstrate proficiency
* Have JavaDocs documentation for all public methods
* Use helper methods correctly and effectively
* Use the tree structure effectively and efficiently
* Be extremely [well-styled](style-reference) and clear by choosing descriptive variable names and including only useful comments 
* Have a thorough, well-styled README 
* Have clear and thorough documentation

## Setup and Requirements
Mount COURSES, download the [HW 6 Starter Code](/classes/201-w24/HW6-Starter.zip) and move it to your StuWork/username folder.

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

You should look at the [String Java Documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html) for more helpful `String` methods.

Your `WordCountTree` must have the constructor and methods below implemented and with properly styled JavaDocs method comments; it may also have any other methods of your choosing (i.e. helper methods are a really good idea).

```java

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

For the methods above that must be recursive, it's fine (and recommended) for each one to call a helper method where the recursion actually takes place, and it's also fine if your method implementation includes some loops, as long as there is recursion as well. (Frequently, you might loop over the children while changing levels in the tree recursively.)

## WordCounter.java
In order to actually make a word cloud, we need to process a data file and output something useful. 
I've provided you a `WordCounter` class that will use `WordCountTree` to count the words in a text file. WordCounter counts all of the words in the file except "stop words". A list of stop words is included in the download of files for this assignment (`StopWords.txt`); your WordCounter can assume that this file is present in the same directory where it is being run.

You need to write the `main` of WordCounter to allow for the user to (via command line arguments):
* specify the file to be counted (you can assume that you'll always use the same `StopWords.txt`)
* specify the number of words that should be in the word cloud (if the user specifies more than how many words are possible, you should output all the words)

**You will need to slightly adapt `printWordCloudHTML` to print the associated HTML of the word cloud with the correct number of words** (you can see what you're word clouds look like at [here](https://www.w3schools.com/html/tryit.asp?filename=tryhtml_intro), though it isn't as pretty as the normal ones).

Here is an example interaction:
```bash
% java WordCounter WutheringHeights.txt 10
<!DOCTYPE html>
<head>
<title>Word Counts</title>
</head>
<body>
<h1>Word Counts</h1>
<div style="
 width: 800px;
 background-color: rgb(250,250,250);
 border: 5px grey solid;
text-align: center">
<span style="color:#880000;font-size:96px;">&nbspheathcliff&nbsp</span>
<span style="color:#006633;font-size:89px;">&nbspno&nbsp</span>
<span style="color:#0033FF;font-size:69px;">&nbsplinton&nbsp</span>
<span style="color:#6600CC;font-size:65px;">&nbspcatherine&nbsp</span>
<span style="color:#CC0000;font-size:55px;">&nbspmr&nbsp</span>
<span style="color:#009966;font-size:55px;">&nbspout&nbsp</span>
<span style="color:#0099FF;font-size:47px;">&nbspup&nbsp</span>
<span style="color:#CC99FF;font-size:27px;">&nbspnow&nbsp</span>
<span style="color:#FF99CC;font-size:14px;">&nbspshall&nbsp</span>
<span style="color:#66FFCC;font-size:14px;">&nbspmust&nbsp</span>

</div>
</body>
</html>


```

I've provided you with the text of the book Wuthering Heights, which you can use to ultimately test your word cloud maker, though I recommend you initially start with a smaller file.
The starter code in WordCounter handles normalizing the words to lowercase and remove punctuation.

## README
As always, you should include a detailed README for this homework. 
It should include a brief overview of your project and a short example of how to run your program and see its interesting behavior.

There is no additional prompt for this homework.

## Submission
Remember to update your Collaborations.txt file with any sources that you consulted.

Then upload all of your files to the Gradescope link on Moodle, at which point the autograder will run and let you know if your code works correctly. You are able to submit your code as many times as you wish before the deadline to fix any issues. If you have questions about what the autograder is telling you is wrong, please ask!

## FAQ
I'm getting index out of bounds errors on Gradescope but not on my computer, what gives?
* Make sure that you are using `.equals` to compare a string to the empty string, that tends to be a difference in different versions of Java, leading to your base case not triggering when run on Gradescope

I'm getting Gradescope errors talking about "reference to assertEquals is ambiguous", how do I fix it?
* Your methods aren't returning the exact type that Gradescope is expecting and Java is trying to figure out a conversion, but there are multiple options. You should first check the assignment to see if a return type is specified and match that exactly (i.e. `int` versus `Integer` often causes a problem). Generally it's that you should have `int` instead of `Integer` for this assignment.

I'm failing the "Test WutheringHeights.txt with 10 words (0/0)" and getting "Test Failed: list index out of range", what is wrong?
* Revisit the part of the homework talking about needing to slightly adapt `printWordCloudHTML`, you are missing some required functionality.
