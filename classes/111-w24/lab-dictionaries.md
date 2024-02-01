---
layout: page
title: Dictionaries Lab
permalink: /classes/111-w24/dictionaries
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.

## Exercise 0
(This is a repeat of the demonstration at the start of class.)

Download the [starter files](/classes/111-f22/DictionaryLabStarterFiles.zip) for today's lab and copy those files into your folder for today.

### Overview
In text analysis, **n-grams** are phrases that are *n* words long that appear in sequence together. 
So, for instance "hello" is a *one-gram*, "black knight" is a *two-gram*, "spam and eggs" is a *three-gram*, etc.

A common first step in analyzing the contents of a document is to count up all the individual instances of each n-gram within it, generally for all values of n smaller than some relatively small number, like 3 or 4. 
Say we were going to count all the two-grams in the following text:
```
    To be, or not to be, that is the question.
```

The first two-gram is "to be", the second is "be or", the third is "or not", etc. 
Notice that the two-grams overlap with one another. 
In this particular text, the only two-gram that would have a count higher than 1 would be "to be", which appears twice. 
*(Note: capitalization and punctuation are often ignored when performing n-gram analysis, though not always.)*

Though this is a simple process as far as statistical analyses go, it can tell us quite a lot. As an example, comparing relative values of the proportions of n-grams within documents can help us algorithmically determine who wrote given documents (part of a broader branch of analysis called [stylometry](https://en.wikipedia.org/wiki/Stylometry)).

In this lab you'll do some of this kind of analysis yourself using Python dictionaries.

### Your Task
The zip that you downloaded contains:

* `ngrams.py`: the beginnings of an implementation that will let us count n-grams
* `main.py`: A file with some testing code for `ngrams.py`
* `corpora/`: a directory of text files written by various famous authors.

Open `ngrams.py` and take a look at `getOneGrams()`, a function that should count all the one-grams (i.e., words, otherwise known as "unigrams") in a given file and returns the counts as a Python dictionary.
You'll see that there is currently pseudocode where the main functionality should be.
**Turn that pseudocode into Python to complete the function.**
When you are done, running `main.py` should print out the top 10 most frequent words in Hamlet. 

You should get:
```
the 1097
and 899
to 742
of 658
you 550
i 536
my 514
a 511
it 415
in 414
```

## Exercise 1
As interesting as Hamlet is, you will likely find that these top 10 words aren't very interesting - at least, not in a way that would distinguish them from the top 10 words for any other play. 
Try changing the code to print out the top 10 words from A Midsummer Night's Dream. 
Despite being a very different play, the words won't have changed much. 
While we can learn a surprising amount from these small "function" words, they do tend to drown out more interesting topic/content words in frequency analysis.
An easy way to address this issue is to simply ignore such words when making our counts. Words that a researcher removes before performing analysis are typically called **stopwords**.

**Add another parameter to the `getOneGrams()` function called `ignoreStopwords`.**
This parameter should contain a Boolean value (`True` or `False`) indicating whether or not the function should ignore stopwords or consider them as it performs its counting. To implement this, you will need to:

* Check whether or not `ignoreStopwords` is True, using a conditional statement
* Read in all of the words from `corpora/stopwords.txt` and store them in a list (take a glance inside this file to see what it contains)
* For each word encountered in the given file, check to see whether or not that word is in the stopword list before adding its count to the `oneGramCounts` dictionary.

Be sure to add code to `main()` to test your new functionality. What words pop up now? Do they tell you more about what the play is about?

## Exercise 2
For your second task of this lab, you will be implementing a similar function to `getOneGrams()` called `getTwoGrams()`. 
As the name suggests, this function will count all of the two-grams (or "bigrams") contained in a given file, returning the counts as a dictionary.

Much of this function will do the same thing as `getOneGrams()`, but think about what extra variables you will need and how you will go about updating them. 
How will you keep track of not just the *current* word, but the *previous* word? 
**How will you be able to make sure that you count two-grams that straddle across two lines of text?**

*Note: do not bother to exclude stopwords as you count bigrams.*

As you implement this function, add code to the `main()` function to test that your function is working.

## Exercise 3
The code you were given removes all punctuation before counting any n-grams. This lets us keep track of all occurrences of each word, regardless of whether or not they might come at the end of a sentence, or after a quotation mark. However, we can incorporate punctuation into our n-grams if we want to. In particular, terminal punctuation marks (periods, question marks, exclamation points) contain useful information. If, say, the word "goodbye" occurs frequently at the end of a sentence, that is something we can capture by treating `('goodbye', '.')` as a bigram.

**Update your `getTwoGrams()` function so that it counts periods, exclamation points, and question marks *as their own words* when counting bigrams.** 
(We can use the word "token" to refer to a single countable unit that could be a word or a punctuation mark.) 
This should be doable just by adding/changing a few lines of code!