---
layout: page
title: HW 8 Word Cloud
permalink: /classes/201-f20/hw8
---

## Logistics
25 points, due Friday Nov 6th by 10PM Central time. Like all assignments, there is a 48-hour, no questions asked extensions policy. If you have a tech issue, a health issue, or some other issue that impedes making the deadline, use this policy. You need to notify me that you're using the policy. Extensions beyond the 48-hour policy will only be considered in extenuating circumstances, and circumstances that arise between the original deadline and the extension are generally not extenuating - the deadline is still the deadline, not 48 hours later.

## Goals
To implement a particular tree structure and use it to store words and counts. You'll generalize some of the ideas that you've been learning about trees to a slightly different tree structure.

## Assignment Type and Collaborative Learning Expectations
This is a homework assignment that you'll be handing in on Moodle.

You're welcome to either complete this homework with input from one or more members of your collaborative learning group or to complete it on your own. You and the other members of your collaborative learning group should each write your own code, even if you're helping one another, but you may share your screens/use multiplayer mode to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

## Setup and Requirements
Make a new repl, make it private, and then upload the files in [this zip folder](/classes/201-f20/hw8Files.zip). You should follow the same process of downloading your files and uploading them to Moodle to submit your homework. 

In this assignment, you'll be implementing a tree structure to count words that will store the words using somewhat less memory than a binary search tree. The start files include a Java class called WordCloudMaker.java (originally written by Sherri Goings, with a few modifications by Jeff Ondich and Anna Rafferty - thanks for sharing!), as well as a sample book (WutheringHeights.txt) and a stopwords file described below.

Create a file Collaborations.txt and put in any collaboration with your learning group or references to outside websites.

## What is a Word Cloud
You've probably seen word clouds like the one below generated from Hound of the Baskervilles by Sir Arthur Conan Doyle:

![Words of varying sizes](/classes/201-f20/BaskervillesWordCloud.png)

The neat thing about word clouds is that words are displayed in a size proportional to the number of times they are used in the text on which the cloud is based. (Note that very common words, also known as stopwords, are typically not included in the cloud. Otherwise, all English word clouds would be dominated by "the", "and", "a", "in", etc.) In this assignment, you'll implement a particular type of search tree to count words and their counts in text, allowing you to make your own word clouds.

## WordCoutTree
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
* You start at the root (which reprents an empty string or null character), and then find the child that represents 't'.
* You then find the child of 't' that represents 'h'.
* Then you find the child of 'h' that represents 'e'.
* Since you've now found all of "the", you look at count to see how many times "the" appeared, which is 50.
* If you were looking for "then", you'd start exactly the same way as for "the", but continue on to the child that represents 'n'.

There are a couple of things to note about this tree:
* It's not a binary tree -- each node can have any number of children.
* The ordering of the children doesn't really matter.
* Any node that exists in the tree either has a non-zero count or has a descendant with a non-zero count. (In the above example, the root doesn't have a child that represents 'a' because we didn't see any words stating with 'a'.)
* The property above means that if we were to remove the word "chomp", we could remove the nodes below 'c' representing 'h', 'o', 'm', and 'p', but we could not remove the node 'c' because it is still needed for "cat".

You'll want to create a `Node` class instead of your `WordCountTree` class like we usually do with trees. You must directly create your tree stucture, though you may use Java implementations of other data structures such as Lists to support your implementation.

Remember that characters are a primitive type in Java:
```
char myChar = 'a';
char nullChar;
char example = myString.charAt(0); //gets the first character in a string myString
```

Your `WordCountTree` must have the constructor and methods below; it may also have any other methods of your choosing.

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
 * Returns a list of WordCount objects, one per word stored in this 
 * WordCountTree, sorted in decreasing order by count. 
 */
 public List<WordCount> getWordCountsByCount();
  
/** 
 * Returns a count of the total number of nodes in the tree. 
 * A tree with only a root is a tree with one node; it is an acceptable
 * implementation to have a tree that represents no words have either
 * 1 node (the root) or 0 nodes.
 * Implementation must be recursive, not iterative.
 */
 public int getNodeCount(); 

 ```

 You'll note that `WordCountTree` uses a class called `WordCount`, you should also implement this small class:
 ```
/**
 * Gets the word stored by this WordCount
 */
public String getWord();
 
/** 
 * Gets the count stored by this WordCount
 */
 public int getCount()  
```

For the methods above that must be recursive, it's fine for each one to call a helper method where the recursion actually takes place, and it's also fine if your method implementation includes some loops, as long as there is recursion as well. (Frequently, you might loop over the children while changing levels in the tree recursively.)

### Sorting WordCounts
You'll note that the method `getWordCountsbyCount` requires the `WordCount` objects to be sorted from highest count to smallest count. There are many ways that you could achieve this and you are welcome to use one of the previous sorting approaches you've used if you want. However, you may also use Java's built-in sorting capabilities by following these steps:

1) Create a WordCount comparator:

```
class SortWordCount implements Comparator<WordCount> {

  public int compare(WordCount a, WordCount b)
  {
    return b.count - a.count;
  }

}
```

2) Use Java's built-in sort with the comparator:

```
Collections.sort(myWordCountList, new SortWordCount());
```

### Testing WordCountTree
As always you should test your code as you implement each method. For each required method in `WordCountTree` **you must have an example of it working** in the `main()` method of `WordCountTree.java`. At minimum these examples should call the method, those double checking the results would be a good additional thing to do.

## WordCounter.java
In order to actually make a word cloud, we need to process a data file and output something useful. You should create a `WordCounter` class that can count the words in a text file and then output them in some format. WordCounter counts all of the words in the file except "stop words". A list of stop words is included in the download of files for this assignment (StopWords.txt); your WordCounter can assume that this file is present in the same directory where it is being run.

Your `WordCounter` should take in the following command line arguments:
```
java WordCounter textFileName numberOfWordsToInclude
```

And then print out HTML generated by `WordCloudMaker.java`. You should use the `getWordCloudHTML()` method in `WordCloudMaker.java`, so check what it's parameters are. A typical invocation of the cloud generator would be:
```
java WordCounter WutheringHeights.txt 40
```

which would generate the word cloud based on the 40 most common non-stopwords in `WutheringHeights.txt` and output the cloud HTML to the terminal. (If the text contains fewer than 40 non-stopwords, then the cloud will just use all the words, and if some words are tied, any method of tie-breaking is fine.) Note that depending on your machine, processing WutheringHeights might actually take a while, so you should initially test with a smaller file.

Your `WordCounter` should use the `WordCountTree` you built in the previous part to store the words and counts. Before you put words in the tree, you should 'normalize' them by removing punctuation and spaces and making them lower case. You can use the following code to normalize a word (this is using a thing called regex, which we haven't covered this term):
```
word = word.replaceAll("\\s*\\p{Punct}+\\s*$", "").toLowerCase();
```

The HTML output by your program can be put into [an online html previewer](https://htmledit.squarefree.com/) to see the (not as pretty) word cloud.

## Grading
Your code will be graded on the following rubric:

|Item | Points |
|-----|---------|
|incrementCount method implemented correctly | 2 | 
|incrementCount method example provided | 1 |
|contains method implemented correctly|2|
|contains method example provided|1|
|getCount method implemented correctly|2| 
|getCount method example provided|1|
|getWordCountsByCount implemented correctly|2|
|getWordCountsByCount example provided|1|
|getNodeCount method implemented correctly|2|
|getNodeCount example provided|1|
|WordCount methods implemented correctly|2|
|WordCounter implemented correctly | 3 |
|Good style |2|
|Sufficient documentation | 3 |


