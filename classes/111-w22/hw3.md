---
layout: page
title: HW3 
permalink: /classes/111-w22/hw3
---

## Logistics

This is a paired assignment, so you should complete it with your assigned partner, if you have one, via **paired programming**. 
The whole time that you are working, you should both be present and actively working on the problem at hand. 
(Two brains, one keyboard.) 
Switch off the typing duties so that you each type for roughly half of the time. 

You are able to get help from many sources as detailed in the [collaboration](collaboration) policy.

This assignment is worth 8 points total, 4 of which are checked on Gradescope automatically with an **autograder** and 4 for program style.

This assignment is due on Wednesday Jan 26th at 10pm. See the [syllabus](syllabus) for the late policy.

## Goals
Get practice with conditional statements, numbers, and output.

## Setup

Again, I recommend you complete this assignment in Olin 310.

[Mount the COURSES drive](https://wiki.carleton.edu/pages/viewpage.action?spaceKey=carl&title=CS+111+and+201+workflow+in+CS+labs) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HW3`
* Open your `HW3` folder in VSCode
* Create a file `writeout.py`

## Overview

One apparently trivial — but, in fact, fairly daunting - task in any language-oriented automated system (e.g., Siri or Alexa) is to figure out how to pronounce abbreviations. 
Go ahead, try it for yourself! 
Pronounce the following fake mailing address:
```
Dr. Steven E. St. John
123 E. 1st St.
Missouri St. University
St. Louis, MO
```

How did you decide on a pronunciation for each one of those “St."s? You were using a lot of common sense and context to say “saint”/”street”/”state”/”saint” – and common sense and context are hard to define well enough to put into code. In this assignment, you'll get to work on one small piece of this kind of puzzle, focused on pronouncing numbers.

## The Task
In your file `writeout.py` write a program that does the following:
* Prompts the user to enter an integer between 1 and 999
* Prints that number in words.

Use the following specific format:
```
Enter a number between 0-999: <user input>
Your number is pronounced: <pronounciation>
```

Here are a few examples:
```
Enter a number between 0-999: 229
Your number is pronounced: two hundred and twenty-nine
```

```
Enter a number between 0-999: 3
Your number is pronounced: three
```

```
Enter a number between 0-999: 400
Your number is pronounced: four hundred 
```

In writing your program, try to make your life easier by avoiding excess duplication of code. 
For example, you might want to use the following steps to produce your output:
1. Figure out whether there is a hundreds digit or not.
    * That is, is the number greater than or equal to 100? If so, figure out what that digit is. (Perhaps consider how integer division and modulus (%) could help you out.) Then figure out how to render it in text.
2. Figure out whether you should output the word "and".
    * The answer is yes if you're outputting both a hundreds digit and something after the hundreds digit.
3. Figure out whether you're outputting a word for the tens digit.
    * Teens may be a hassle.
4. Figure out whether you're outputting a hyphen after the tens digit.
5. Figure out whether you're outputting a ones digit.

Another hint that will make your life easier: take a look at Section 5.3 of Zelle. You will also find code like the following helpful:
```
digits = ['', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
decades = ['', '', 'twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety']
print(decades[4], digits[5]) # Notice how this prints "forty five", due to clever list construction
```

In the past, students have sometimes over-complicated this program. 
You can solve this problem with about 40 lines (including blank lines and comments), so if you are going beyond that, you should think about how you can simplify.

## Grading
You will be graded on the following rubric.

|Item | Points |
|-----|--------|
| Autograder tests | 4 |
| Programming style (header, comments, variable names, spacing, no duplicated code) | 4 |

## Submission
You should submit through Gradescope as always and make sure both partners are listed in the group. 