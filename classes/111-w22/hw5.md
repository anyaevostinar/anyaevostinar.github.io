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

This assignment is worth X points total, 4 of which are checked on Gradescope automatically with an **autograder** and 4 for program style.

This assignment is due on Wednesday Feb 9th at 10pm. See the [syllabus](syllabus) for the late policy.

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

