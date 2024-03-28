---
layout: page
title: Maps Lab
permalink: /classes/201-s24/maps-lab
---

## Goals
Get practice using maps.

## Logistics
This is a lab assignment and so you will not be submitting it. However, the concepts and practice will help you on both the homework and quizzes so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

## Setup
* [Mount the COURSES drive](getting-started)
* Create a new folder in your STUWORK called `MapsLab`
* Download [`Frankenstein.txt`](/classes/201-s24/Frankenstein.txt) and move it into your folder
* Create a file `Main.java`
* Open the [reading](https://moodle.carleton.edu/mod/lti/view.php?id=928121) for reference

## Exercise 1
a. In `Main.java` import `Map` and `HashMap`. 

b. Create a `HashMap` that will contain `String` keys and `Integer` values called `wordCounts`

c. Create a file scanner for `Frankenstein.txt` (if you don't remember how, check the example from the [Comparing Python and Java](java_scavenger) activity)

d. Loop over the first 5 words and add them and a count of 1 to your Map

e. Loop over your `keySet` and print out the word and the number of times it has been seen (your ordering might be different, why is that??):

```bash
> javac Main.java
> java Main
"The" has been seen 1 times.
"eBook" has been seen 1 times.
"Project" has been seen 1 times.
"of" has been seen 1 times.
"Gutenberg" has been seen 1 times.
```

## Exercise 2
a. You may have realized that you won't actually increase your count of words with your previous code. Using `containsKey()` and `get()`, add an if statement that first checks if the key is in the map and increases the existing count if so. Otherwise, add the key and a count of 1 like before.

b. Change your loop to count the first twenty words in the file and verify that "of" occurs twice in the first twenty words.

## Exercise 3
Sometimes we want to know what words occur before other words during text analysis. To track that, we need to make a more complicated storage structure.

a. Create a new HashMap that has `String`s for the keys and `ArrayList`s of `String`s for the values:

```java
Map<String,ArrayList<String>> nearbyWords = new HashMap<String,ArrayList<String>>();
```

b. We'll have to track what the previous word was before reading the next one, so make a variable that will hold it:

```java
    String previousWord;
    String newWord = scanner.next();
```

c. Make a for loop that will loop over the next 500 words (**leave your previous for loop** so that we skip over some of the boring stuff). Within your new for loop, save the `newWord` to the `previousWord` before reading the next word.

d. Again check if the `Map` already has the key and if it does, add the `previousWord` to the list:
```java
nearbyWords.get(newWord).add(previousWord);
```

Notice that you don't need to use `put`. This is because the map is storing a *reference* to the `ArrayList` so any changes you make to it will stick. This is because `List`s are mutable (changeable) and so you can change the existing one instead of making a new one (like with `String`s). 

If the Map doesn't already have the key, make a new `ArrayList`, add the `previousWord`, and use `put` to add the key and `ArrayList` to the `Map`.

e. Finally, use you newly created map to output all of the words in this section of text that precede the word "of":

```bash
[parts, terms, laws, commencement, sister, success, north, streets, foretaste, wind,
 seat, region, phenomena, country, sight, part, foot, fear]
```

## Extensions
There are a lot of ways that you could extend this code to better analyze text, here are just a few ideas to try if you have extra time:
* Remove punctuation and convert all words to lowercase so that you don't have entries for 'of' and "Of" and "of."
* Track words that appear both before and after a given word
* Create a nested Map (a Map that stores another Map as a value) to track how often a given word appears before (or after) another word