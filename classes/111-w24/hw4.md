---
layout: page
title: HW4 
permalink: /classes/111-w24/hw4
---

## Logistics
This is a paired assignment, so you should complete it with your **new** assigned partner, if you have one, via **paired programming**. 
The whole time that you are working, you should both be present and actively working on the problem at hand. 
(Two brains, one keyboard.) 
Switch off the typing duties so that you each type for roughly half of the time. 

You are able to get help from many sources as detailed in the [collaboration](collaboration) policy.

This assignment is due on Friday Feb 2nd at 10pm. 
As with all assignments, you will have the opportunity to revise this assignment individually based on the feedback that you get.

## Goals
Get practice with reading from files, loops, functions, and command-line arguments.

## Setup

Again, I recommend you complete this assignment in Olin 310, though it isn't required to do so.

[Mount the COURSES drive](getting-started) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HW4`
* Open your `HW4` folder in VSCode
* Download the starter code that is [linked on Moodle](https://moodle.carleton.edu/mod/resource/view.php?id=908003) and move the starter files into your folder

Both of these programs use command-line arguments as input to the program. 
Remember, those are things typed at the prompt in Terminal. 
Clicking the run button won’t work for this program (which is why hopefully you haven't been using it this whole time anyway). 
If you've forgotten how to run in the Terminal, open a terminal window (in VSCode: Terminal -> New Terminal, or ask the lab assistant if you’re having trouble). 
Then type something like `python3 name_of_program.py argument1 argument1` depending on which of the following programs you are running.

## Weather

### Overview
You've be given two files of local Carleton data (one about energy consumption on campus, one about weather on campus), and you’ll change the `weather.py` file to answer some basic questions about them.

The starter code that you are given is broken out into two functions for two different tasks, and which task is performed is controlled by command-line arguments.

The `demand` function of `weather.py` reads a data file kindly provided for the class by Martha Larson, the former Manager of Campus Energy and Sustainability. This file gives you readings of the instantaneous demand from Carleton’s electrical system, in kilowatts, every 5 minutes for a ∼6-month period (from a little while ago now).
(There’s been a change in the sensors, so we don’t have exactly this data for the last several years. 
As a result, you’ll use outdated data for this assignment.) 
The lines of the file are of the following form: 

`[M]M/[D]D/YYYY,[H]H:MM:SS,demand`

When `demand == 0`, that’s because we’re generating enough wind power via Wind Turbine #2 to meet all of the campus’s energy demand at that moment.

`weather.py` also has a `weather` command-line option and function. In the `weather` function are a few skeletal lines that read the lines of a second data file kindly provided for the class by Doug Foxgrover, the Curator of Weather Data at Carleton (among other
titles!). 
The lines of this file are of the form:

`MM/DD/YYYY,hiTemp,loTemp,avgTemp`

where those daily temperatures are measured in Fahrenheit.

### Your Task - Demand
First, you should modify the given `weather.py` to output the following for the `demand` command-line option:

```
Carleton was on full wind power for 12105 minutes, which is 201.75 hours or approximately 8 days.
The fraction of time on full wind power was approximately 7.11% of the total time.
```

To achieve this output, you should:

* Compute the number of minutes during the time period of the given dataset in which Carleton was operating on full wind power. 
(Assume that each measurement is accurate for the next 5 minutes.)
* Print the number of minutes that we were on full wind power.
* Convert this number of minutes into hours, and print that number.
* Also convert this number to days, and print that number rounded to the nearest whole number.
* Also print the percent of the time that we were on full wind power, rounded to two decimal places. 

You should be sure to add a function header for the `demand` function.


### Your Task - Weather

Second, modify the given `weather` function to compute the "average high", "average low", and "average average" temperature in the year 2017. 
(We don’t have full data for 2018, 2019, 2020, or 2021, because of the move to the new Science Complex.) 
**Note:** There are many lines from the file that contain data from other years, so you will need to figure out which lines should count as part of the average. (Hint: use split twice.)

You should report the average temperatures of 2017 in the following format:
```
In 2017, the average high temperature was 52.91F, the average low temperature was 35.86F and the average average temperature was 45.25F.
```

Finally, also in the `weather` function, you'll calculate the longest streak of *stifling* weather days.
Let’s call a day stifling if the low temperature that day is **greater** than 32 degrees — that is, if it never gets below
freezing that day. 
Report the length of the longest sequence of stifling days
in 2017 in addition to the averages, such that your full output is:

```
$python3 weather.py weather
In 2017, the average high temperature was 52.91F, the average low temperature was 35.86F and the average average temperature was 45.25F.
The longest sequence of stifling days in 2017 was 164.
```

You should be sure to add a function header for the `weather` function.

## Scrabble

### Overview
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

### Your Task
Get started, as usual, with the starter code on Moodle. Take a look through `scrabble.py`; you’re going to be adding some functionality to it in this assignment, and it will pay to know how what’s already there works.

### scoreWord
Fill in `scoreWord(word)`, which should compute the score of the `word` given to it by adding up the scores of all of the letters in it, and adding a bonus if appropriate. (Do not check whether `word` is actually in the dictionary in `scoreWord`.)

A great way to check if your `scoreWord` implementation is working is to start the Python shell with `python3` and then `import scrabble` and call your method on the provided examples, for example `scrabble.scoreWord("TSKTSK")` should return 14.

### playable
Fill in `playable(word, hand)`, which should return `True` if `word` can be produced solely by using the tiles in `hand`. (Do not check whether `word` is actually in the dictionary in `playable`.)
*(Think through this question before you start typing! There are easy ways and hard ways to attack this problem. It’s worth thinking about how to make sure that you don’t repeat a letter more than the number of times you have that tile.)* **Hint**: if you see apparently bizarre behavior when you run your
function, think about how you are changing lists when you might not mean to. Are you doing something that causes you trouble down the road?

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

## Assessment
To **demonstrate proficiency**, your programs need to:
* Pass all the tests in Gradescope 
* Contain descriptive headers
* Contain descriptive docstrings for each function
* Not have an excessive amount of duplicated code

To **demonstrate mastery**, your program needs to demonstrate proficiency as well as having:
* Useful comments (and non-useful starter ones removed)
* Descriptive variable names
* Good spacing
* Use iteration, conditionals, and functions to organize your programs and prevent any unnecessary duplication of code