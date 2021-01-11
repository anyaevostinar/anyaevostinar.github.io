---
layout: page
title: Maps Activity
permalink: /classes/201-w21/maps-activity
---

## Goals
Get practice using maps and see how a map can be used.

## Logistics
You should complete this activity on Friday Jan 15th, but it is due Monday Jan 18th at 5pm Central, 2020. 

You may get help from your collaborative learning group and anyone else in class, but be sure to submit your own solution and record any help or outside sources in your Collaborations.txt document.

## Setup
You'll complete the activity on Repl.it as always and hand it in on Moodle.
* Open the Maps Activity from the Projects list in our Team
* Create your Collaborations.txt document

## Exercise 1
a. In Main.java import Map and HashMap. 

b. Create a HashMap that will contain String keys and Integer values called wordCounts

c. Create a file scanner for Frankenstein.txt (if you don't remember how, check the example from the Comparing Python and Java activity)

d. Loop over the first 5 words and add them and a count of 1 to your Map

e. Loop over your keySet and print out the word and the number of times it has been seen:

```
> javac Main.java
> java Main
"Project" has been seen 1 times.
"EBook" has been seen 1 times.
"of" has been seen 1 times.
"The" has been seen 1 times.
"Gutenberg" has been seen 1 times.
```

## Exercise 2
a. You may have realized that you won't actually increase your count of words with your previous code. Using `containsKey()` and `get()`, add an if statement that first checks if the key is in the map and increases the existing count if so. Otherwise, add the key and a count of 1 like before.

b. Change your loop to count the first twenty words in the file and verify that "of" occurs twice in the first twenty words.

## Exercise 3
Sometimes we want to know what words occur nearby other words during text analysis. To track that, we need to make a more complicated storage structure.

a. Create a new HashMap that has Strings for the keys and ArrayLists of Strings for the values:
```
Map<String,ArrayList<String>> nearbyWords = new HashMap<String,ArrayList<String>>();
```

b. We'll have to track what the previous word was before reading the next one, so make a variable that will hold it:
```
    String previousWord;
    String newWord = scanner.next();
```

c. Make a for loop that will loop over the next 500 words (leave your previous for loop so that we skip over some of the boring stuff). Within that for loop, save the newWord to the previousWord before reading the next word.

d. Again check if the Map already has the key and if it does, add the previousWord to the list:
```
nearbyWords.get(newWord).add(previousWord);
```

Notice that you don't need to use `put`. This is because the map is storing a *reference* to the ArrayList so any changes you make to it will stick. This is because Lists are mutable (changeable) and so you can change the existing one instead of making a new one (like with Strings). 

If the Map doesn't already have the key, make a new ArrayList, add the previousWord, and use `put` to add the key and ArrayList to the Map.

e. Finally, use you newly created map to output all of the words in this section of text that precede the word "of":

```
Here are words that appear before of
terms
photo-reprint
Publishers
one
account
origin
myself
daughter
persons
thought
formation
trains
formation
succession
suggestions
shores
eyry
creatures
```

## Submission
Download your files as a zip, and upload that zip to Moodle under the appropriate assignment.

This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the code to indicate things you tried but what went wrong/where you got stuck. 

## Extensions
There are a lot of ways that you could extend this code to better analyze text, here are just a few ideas to try if you have time and interest:
* Remove punctuation and convert all words to lowercase so that you don't have entries for 'of' and "Of" and "of."
* Track words that appear both before and after a given word
* Create a nested Map (a Map that stores another Map as a value) to track how often a given word appears before (or after) another word