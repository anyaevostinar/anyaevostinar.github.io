---
layout: page
title: HW4 
permalink: /classes/111-w22/hw4
---

## Logistics

This is an individual assignment.
You are still able to get help from many sources as detailed in the [collaboration](collaboration) policy.

This assignment is worth 12 points total, 4 of which are checked on Gradescope automatically with an **autograder**, 4 for program style, and 4 for the Brutus algorithm.

This assignment is due on Wednesday Feb 2nd at 10pm. See the [syllabus](syllabus) for the late policy.

## Goals
Get practice with reading from files, loops, functions, and command-line arguments.

## Setup

Again, I recommend you complete this assignment in Olin 310, though it isn't required to do so.

[Mount the COURSES drive](https://wiki.carleton.edu/pages/viewpage.action?spaceKey=carl&title=CS+111+and+201+workflow+in+CS+labs) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HW4`
* Open your `HW4` folder in VSCode
* Download the starter code that is linked on Moodle

Both of these programs use command-line parameters as input to the program. 
Remember, those are things typed at the
prompt. 
Clicking the run button won’t work for this program (which is why hopefully you haven't been using it this whole time anyway). 
If you've forgotten how to run in the Terminal, open a terminal window (in VSCode: Terminal -> New Terminal, or ask the lab assistant if you’re having trouble). 
Then type something like `python3 name_of_program.py argument1 argument1` depending on which of the following programs you are running.

## Weather

### Overview
You've be given two files of local Carleton data (one about energy consumption on campus, one about weather on campus), and you’ll change the `weather.py` file to answer some basic questions about them.

The starter code that you are given is broken out into two functions for two different tasks, and which task is performed is controlled by command-line arguments.

The `demand` function of `weather.py` reads a data file kindly provided for the class by Martha Larson, the Manager of Campus Energy and Sustainability. This file gives you a reading the instantaneous demand from Carleton’s electrical system, in kilowatts, every 5 minutes for a (vaguely recent) ∼6-month period.
(There’s been a change in the sensors, so we don’t have exactly this data for the last several years. 
As a result, you’ll use outdated data for this assignment.) 
The lines of the file are of the following form: 

`[M]M/[D]D/YYYY,[H]H:MM:SS,demand`

When `demand == 0`, that’s because we’re generating enough wind power via Wind Turbine #2 to meet all of the campus’s energy demand at that moment.

`weather.py` also has a `weather` command-line option and function. In the `weather` function are a few skeletal lines that read the lines of a second data file kindly
provided for the class by Doug Foxgrover, the Curator of Weather Data at Carleton (among other
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

Second, modify the given `weather` function to compute the average high, average low, and average average temperature in the year 2017. 
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

## Caesar

### Overview

One crucially important application of computer science to day-to-day life — with billions of dollars at stake
every day — is in the area of digital security. 
When you log on to your bank’s website, pay your cell phone bill online, or log on to The Hub, you are typing secure information that you would like to (1) be readable to the
trusted party on the other end of the line, and (2) not be readable to anyone else. 
Cryptography is the broad area of computer science that attempts to design algorithms and build systems for these operations. 
If you decide to take CS 202 (Mathematics of Computer Science), CS 231 (Computer and Network Security), or CS 341 (Cryptography), you’ll learn more about some of the cryptographic systems that are actually in use today; here, you’ll explore a simpler approach that reaches all the way back to Julius Caesar.

Here is the idea of what is called the *Caesar cipher*. 
To encrypt a message written in English, you will take each letter that appears in the message and shift it forward alphabetically by some predetermined number of letters. 
For example, the “plaintext” `We are discovered; flee at once!` shifted forward by one letter becomes the “ciphertext” `Xf bsf ejtdpwfsfe; gmff bu podf!` because `X` is alphabetically one letter after `W`, `f` is alphabetically one letter after `e`, etc. 
(Notice that if you were to shift, say, `w` by five, you’d end up with `b`: `b` is after `a` is after `z` is after `y` is after `x` is after `w`.) 
Once your colleague receives the ciphertext `Xf bsf ejtdpwfsfe; gmff bu podf!`, they can decode it by shifting each of the letters backwards by one letter in the alphabet, and they will immediately know to head to the safe house that you’ve set up in Hoboken.

### Your Task
First, read through the provided starter code for `caesar.py`. 
Your task will be to complete this program.
Note that command-line arguments that are strings need to be in single quotes, for example:
```
python3 caesar.py ’We are discovered; flee at once!’ 3
```
(Depending on your computer setup, you may experience trouble if you use double quotes at the terminal and put an exclamation point inside. So, if weird things are happening, be sure you’re using `’We are discovered; flee at once!’` instead of `"We are discovered; flee at once!"` .)

Next, work on the function `caesar`. 
Right now, it goes through each character of plaintext and, one by one, adds that character to the end of ciphertext. 
The function then returns that computed ciphertext. 
Modify the function `caesar` so that it instead returns a string that matches plaintext, except that every letter is shifted `shift` letters forward in the alphabet (wrapping around to the beginning of the alphabet as necessary). 
You should leave all non-alphabetic characters unchanged, and you should maintain the capitalization of all letters. 
Make the changes to the function `caesar` so that it constructs ciphertext, again one character at a time, to use this new specification.

Here are some examples of how the function should work:
```
>>> caesar("This is the way the world ends, dontcha know?", 0)
’This is the way the world ends, dontcha know?’
>>> caesar("This is the way the world ends, dontcha know?", 1)
’Uijt jt uif xbz uif xpsme foet, epoudib lopx?’
>>> caesar("This is the way the world ends, dontcha know?", 25)
’Sghr hr sgd vzx sgd vnqkc dmcr, cnmsbgz jmnv?’
>>> caesar("This is the way the world ends, dontcha know?", 26)
’This is the way the world ends, dontcha know?’
```

Here are a few hints. 
The easier situation to handle is the one in which there’s no “wrapping around” the alphabet: that is, when you don’t have to go from `z` to `a`. 
Start by getting your code working when there are no shifts. You might consider the following general outline of code:
```
if we have a lower-case letter,
    add the offset
    while the resulting character isn’t in "a" ... "z",
    subtract 26
if we have an upper-case letter,
    do the analogous thing
otherwise,
    do nothing
```

Finally, you should add error-checking code to the main function. 
What happens if the user enters a non-integer as the shift? Make your program robust, so that it doesn’t crash regardless of what the user tries to enter as the number of letters by which to shift and informs the user of the problem with the following message:
```
$ python3 caesar.py "hi" a
Invalid argument, shift must be a number, given a.
```

## Brutus
One issue with the Caesar cipher is that it is relatively easy to break, as long as the cipher text is reasonably long. 
In other words, given a ciphertext like `Zh wkh shrsoh ri wkh Xqlwhg Vwdwhv, lq rughu wr irup d pruh shuihfw xqlrq, hvwdeolvk mxvwlfh, lqvxuh grphvwlf wudqtxlolwb, surylgh iru wkh frpprq ghihqvh, surprwh wkh jhqhudo zhoiduh, dqg vhfxuh wkh eohvvlqjv ri olehuwb wr rxuvhoyhv dqg rxu srvwhulwb, gr rugdlq dqg hvwdeolvk wklv Frqvwlwxwlrq iru wkh Xqlwhg Vwdwhv ri Dphulfd.` can you figure out what the original plaintext was? 
(I.e., even without knowing the shift in advance?)
One reason for the fragility of the Caesar cipher is that you can “attack” it by a letter-frequency based algorithm. In typical English text, the most common letters in descending order are `ETAOINSHRDLU`. 
So you should be able to “break” a Caesar cipher by computing observed frequencies in the ciphertext and comparing to `ETAOINSHRDLU` etc.

In a file entitled `brutus.txt`, describe a frequency-based algorithm to break Caesar ciphers. 
You can assume that your reader has been taking CS 111 all term and is now familiar with variables and counting and loops and that sort of thing, so you don’t have to use the excruciatingly detailed description from the first week of the term. 
That said, don’t skip steps; a list of steps (with some loops) is sufficient, but describe exactly what to do.
Remember that in this class we are always interested in algorithms that find the correct answer 100% of the time and randomness isn't a good strategy for achieving that.

For a completely optional challenge, if you want a bit more to chew on: try implementing your algorithm! Write a program called `brutus.py` that implements your algorithm in Python.

## Grading
You will be graded on the following rubric.
Be sure to remove the starter comments that are no longer relevant, add additional comments, and update or add headers as necessary.

|Item | Points |
|-----|--------|
| Autograder tests | 4 |
| Programming style (header, comments, variable names, spacing, no duplicated code, function headers) | 4 |
| Well-described Brutus algorithm | 4 |

## Submission
You should submit through Gradescope as always. 