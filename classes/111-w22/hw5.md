---
layout: page
title: HW5 
permalink: /classes/111-w22/hw5
---

## Logistics

This is a paired assignment, so you should complete it with your assigned partner, if you have one, via **paired programming**. 
The whole time that you are working, you should both be present and actively working on the problem at hand. 
(Two brains, one keyboard.) 
Switch off the typing duties so that you each type for roughly half of the time. 

You are able to get help from many sources as detailed in the [collaboration](collaboration) policy.

This assignment is worth 12 points total, 8 of which are checked on Gradescope automatically with an **autograder** and 4 for program style.

This assignment is due on Wednesday Feb 16th at 10pm. See the [syllabus](syllabus) for the late policy.

## Goals
Revisit Scrabble and bring together many of the ideas from the first half of the term by implementing some useful Scrabble functionality.

## Setup

Again, I recommend you complete this assignment in Olin 310.

[Mount the COURSES drive](https://wiki.carleton.edu/pages/viewpage.action?spaceKey=carl&title=CS+111+and+201+workflow+in+CS+labs) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HW5`
* Download the starter code linked on Moodle and copy those files into your folder
* Open your `HW5` folder in VSCode

## Overview
(You’ve already thought about this game quite a bit in the first week of the term, but here’s a reminder.)
Scrabble is a word game in which players form words from a collection of tiles in their hand. 
There are multiple players — usually up to four in the living-room version of the game, and precisely two in the *Word Freak* version). (*Word Freak* is a real book about the high-rolling world of international Scrabble contestants.)

* The first player draws a “hand” of seven tiles from a collection of 100, each of which has a letter printed on it. They then form a legal word and place it in the middle of the 15-by-15 grid that serves as the gameboard. The player then randomly draws tiles from the unused tiles from the original set of 100
to replenish their hand up to seven tiles.
* All subsequent turns proceed as follows. The current player forms another legal word by adding one or more tiles from their hand to one or more tiles already on the board (so a new word must build off an already-played tile). The player then randomly draws tiles from the unused tiles from the original
set of 100 to replenish their hand up to seven tiles (or until the pool of unused tiles is empty).
* Scoring: each letter has a number of points (more common letters are worth 1 point; rarer letters are worth as many as 10 points). The total point value of a word is the sum of the point values of each letter played in the word, plus a bonus of 50 points if the word played is seven letters long. The player
who has scored the most total points at the end of the game wins.

In this assignment, you’ll concentrate on the very first move of the game, where there’s nothing yet on the board (and thus so that every letter in the words that you find must come from the seven tiles in the hand).
Of course, you are welcome to think about how you would attack the more complicated question of how to play as part of a game when there are some tiles already on the board, but you’re not required to do so.

## Your Task
Get started, as usual, with the starter code on Moodle. Take a look through `scrabble.py`; you’re going to be adding some functionality to it in this assignment, and it will pay to know how what’s already there works.

### scoreWord
Fill in `scoreWord(word)`, which should compute the score of the `word` given to it by adding up the scores of all of the letters in it, and adding a bonus if appropriate. (Do not check whether `word` is actually in the dictionary in `scoreWord`.)

A great way to check if your `scoreWord` implementation is working is to start the Python shell with `python3` and then `import scrabble` and call your method on the provided examples, for example `scrabble.scoreWord("TSKTSK")` should return 14.

### playable
Fill in `playable(word, hand)`, which should return `True` if `word` can be produced solely by using the tiles in `hand`. (Do not check whether `word` is actually in the dictionary in `playable`.)
*(Think through this question before you start typing! There are easy ways and hard ways to attack this problem. It’s worth thinking about how to make sure that you don’t repeat a letter more than the number of times you have that tile.)* **Hint**: if you see apparently bizarre behavior when you run your
function, go reread Zelle §6.6. Are you doing something that causes you trouble down the road?

### allPlayable
Add a function `allPlayable(hand, words)` that returns a list of all valid words from `words` that can be played using only the tiles from `hand`. One suggestion for an approach to this is to implement something like the following:

```
make an empty list of playable words
for every word in the dictionary:
    if that word is playable given this hand:
        add that word to the list of playable words
return the list of playable words
```

Be sure to add a function header for your new function.
To test this function in the Python shell, you can make a call like this:
```
>>> import scrabble
>>> scrabble.allPlayable("PYTHONS", scrabble.loadDictionary())
```

### bestPlayable
Add a function `bestPlayable(hand, words)` that computes and returns a list of the highest-scoring word(s) that can be played from the tiles in hand.
If the best score that can be achieved is X and only one word scores X, then you should return a list with one item.
If multiple words can achieve X, you should return a list with each of them.

I recommend first figuring out how to return just one best-scoring word and then working on how to maintain a list of only the best-scoring words.

### main
Add to `main` such that the user can specify via command-line argument if they want to provide their hand (`provide`) or get a random hand (`random`) and then allow them to have the following interactions:
```
$ python3 scrabble.py random
Your hand is: ['E', 'D', 'C', 'N', 'D', 'U', 'U']
The best possible play(s) will earn you 8 and are: ['DUNCE']
$ python3 scrabble.py provide
What is your hand? PYTHONS
The best possible play(s) will earn you 65 and are: ['PHYTONS', 'PYTHONS', 'TYPHONS']
```

## Grading
You will be graded on the following rubric.
Be sure to remove the starter comments that are no longer relevant, add additional comments, and update or add headers as necessary.

|Item | Points |
|-----|--------|
| Autograder tests | 8 |
| Programming style (header, comments, variable names, spacing, no duplicated code, function headers) | 4 |

## Submission
You should submit through Gradescope as always.
