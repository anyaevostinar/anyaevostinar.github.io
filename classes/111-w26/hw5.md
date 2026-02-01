---
layout: page
title: HW5 - Scrabble
permalink: /classes/111-w26/hw5
---

## Logistics

Due: Friday Feb 13th at 10pm

You may work alone or with a partner, but you must type up the code yourself.  You may also discuss the assignment at a high level with other students.  You should list any student with whom you discussed each part, and the manner of discussion (high-level, partner, etc.) in a comment at the top of each file.  **You should only have one partner for an entire assignment.**

You should submit your assignment on Gradescope. You submit the files `scrabble.py`, and `readme.txt`.

---
## Goals
Get practice with reading from files, loops, functions, and command-line arguments.

## Assessment
The **core requirements** are:
* Correct implementation of `scrabble` such that you pass the autograder tests
* Header with at least five lines that start with `#` for each file
* Basic style that can be checked automatically (not complete!)
* Collaboration statement at the top of the file (even if it just says that you worked alone)
* A `readme.txt` that includes your reflection (detailed below)

The **advanced requirements** are:
* Satisfy the core requirements
* *Descriptive* headers
* *Descriptive* docstrings for each function
* Useful comments (and removal of non-useful starter comments)
* Descriptive variable and function names that follow `snake_case`
* Good line grouping and spacing
* Use iteration, conditionals, and functions to organize your programs and **prevent any unnecessary duplication of code**
* Not do any extra work, like calling a function multiple times when not needed

## Setup

Again, I recommend you complete this assignment in Olin 310, though it isn't required to do so.

[Mount the COURSES drive](getting-started) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HW5`
* Open your `HW5` folder in VSCode
* Download the [starter code](/classes/111-w26/HW5Starter.zip) move the starter files into your folder

This program uses command-line arguments as input to the program. 
Remember, those are things typed at the prompt in Terminal. 
Clicking the run button won’t work for this program (which is why hopefully you haven't been using it this whole time anyway). 
If you've forgotten how to run in the Terminal, open a terminal window (in VSCode: Terminal -> New Terminal, or ask the lab assistant if you’re having trouble). 
Then type something like `python3 name_of_program.py argument1 argument1`.

### Overview
Scrabble is a word game in which players form words from a collection of tiles in their hand. 
There are multiple players — usually up to four in the living-room version of the game, and precisely two in the *Word Freak* version. (*Word Freak* is a real book about the high-rolling world of international Scrabble contestants.)

* The first player draws a “hand” of seven tiles from a collection of 100, each of which has a letter printed on it. They then form a legal word and place it in the middle of the 15-by-15 grid that serves as the gameboard. The player then randomly draws tiles from the unused tiles from the original set of 100
to replenish their hand up to seven tiles.
* All subsequent turns proceed as follows. The current player forms another legal word by adding one or more tiles from their hand to one or more tiles already on the board (so a new word must build off an already-played tile). The player then randomly draws tiles from the unused tiles from the original
set of 100 to replenish their hand up to seven tiles (or until the pool of unused tiles is empty).
* Scoring: each letter has a number of points (more common letters are worth 1 point; rarer letters are worth as many as 10 points). The total point value of a word is the sum of the point values of each letter played in the word, plus a bonus of 50 points if the word played is seven letters long. The player
who has scored the most total points at the end of the game wins.

In this assignment, you’ll concentrate on the very first move of the game, where there’s nothing yet on the board (and thus so that every letter in the words that you find must come from the seven tiles in the hand).

### Your Task
Take a look through `scrabble.py`; you’re going to be adding some functionality to it in this assignment, and it will pay to know how what’s already there works.

### score_word
Fill in `score_word(word)`, which should compute the score of the `word` given to it by adding up the scores of all of the letters in it, and adding a bonus if appropriate. (Do not check whether `word` is actually in the dictionary in `score_word`.)

A great way to check if your `score_word` implementation is working is to start the Python shell with `python3` and then `import scrabble` and call your method on the provided examples, for example `scrabble.score_word("TSKTSK")` should return 14.

### playable
Fill in `playable(word, hand)`, which should return `True` if `word` can be produced solely by using the tiles in `hand`. (Do not check whether `word` is actually in the dictionary in `playable`.)
*(Think through this question before you start typing! There are easy ways and hard ways to attack this problem. It’s worth thinking about how to make sure that you don’t repeat a letter more than the number of times you have that tile.)* **Hint**: if you see apparently bizarre behavior when you run your
function, think about how you are changing lists when you might not mean to. Are you doing something that causes you trouble down the road?

### all_playable
Add a function `all_playable(hand, words)` that takes a *string* `hand` and list of strings `words` and returns a list of all valid words from `words` that can be played using only the tiles from `hand`. One suggestion for an approach to this is to implement something like the following:

```
make an empty list of playable words
for every word in the dictionary:
    if that word is playable given this hand:
        add that word to the list of playable words
return the list of playable words
```

Be sure to add a function header for your new function. Note that if you have a string `"HI"` and want a list of each separate letter, you can use `list("HI")` to get `['H','I']`. It isn't necessary to use this information to solve this problem, but you might find it useful.

### best_playable
Add a function `best_playable(hand, words)` that computes and returns a list of the highest-scoring word(s) that can be played from the tiles in hand. 
(Again `hand` is a string and `words` is a list of words.)
If the best score that can be achieved is X and only one word scores X, then you should return a list with one item.
If multiple words can achieve X, you should return a list with each of them.

I recommend first figuring out how to return just one best-scoring word and then working on how to maintain a list of only the best-scoring words.

### main
Add to `main` such that the user can specify via command-line argument if they want to provide their hand (`provide`) or get a random hand (`random`) and then allow them to have the following interactions:
```bash
$ python3 scrabble.py random
Your hand is: ['E', 'D', 'C', 'N', 'D', 'U', 'U']
The best possible play(s) will earn you 8 and are: ['DUNCE']
$ python3 scrabble.py provide
What is your hand? PYTHONS
The best possible play(s) will earn you 65 and are: ['PHYTONS', 'PYTHONS', 'TYPHONS']
```
---

## Reflection

Were there any particular issues or challenges you dealt with in completing this assignment?  How long did you spend on this assignment?  Write a brief discussion (a sentence or two is fine) in your `readme.txt` file.



## Submission
You should submit your file through the Gradescope link on Moodle for this assignment.
You are able to submit your code as many times as you wish before the deadline to fix any issues (and you should do so).
If you have questions about what the autograder is telling you is wrong, please ask!