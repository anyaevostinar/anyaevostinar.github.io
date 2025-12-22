---
layout: page
title: HW1 - Intro
permalink: /classes/111-w26/hw1
---

## Logistics

This assignment is due on Wednesday Jan 14th at 10pm. 
As with all assignments, you will have the opportunity to [revise](revision-process) this assignment based on the feedback that you get.

You will submit two files to Gradescope: `intro.py` and `mornings.py`

## Collaboration policy

For this assignment, you may work alone or with a partner, but you must type up all of the code yourself.  (It is therefore unexpected for two code submissions to be completely identical.)  You may have at most one partner.

You may also discuss the assignment at a high level with other students.  You can discuss the assignment with Anya, our prefect, or any course staff.

You should list any student or course staff with whom you discussed the assignment (you don't have to include prefect sessions), and the manner of discussion (high level, partner, etc.) in comments at the top of your source code files.

_If you work alone, you should say so instead._

Note: Remember, you should not be using search engines or generative AI when completing your assignments (this includes the Copilot extension in VS Code!). You can, however, search within the official Python documentation: https://docs.python.org/3/.


## Goals
The primary goal for this assignment is to get you up and running with Python. You will need to make sure you can write and execute Python programs to complete this assignment and test it; the actual code you write will be quite simple. 

## Assessment
The **core requirements** are:
* Correct functionality, include exact output detailed below
* Header with at least five lines that start with `#` for each file
* Basic style that can be checked automatically (not complete!)
* Collaboration statement at the top of each file (even if it just says that you worked alone)

The **advanced requirements** are:
* Satisfy the core requirements
* Do not use any `if` statements
* Descriptive headers
* Descriptive variable names that follow `snake_case`
* Good line grouping and spacing (i.e. use blank newlines to group your lines of code)
* No unnecessary parentheses
* A reflection at the bottom `intro.py`

## Setup
I recommend that you complete this assignment in Olin 310.

[Mount the COURSES drive](getting-started) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HW1`
* Open your `HW1` folder in VSCode
* Create two files `intro.py`, and `mornings.py`.

If you really want to use your personal machine, there are instructions for installing VSCode and Python available: [Mac](https://stolafcarleton.teamdynamix.com/TDClient/3356/Portal/KB/ArticleDet?ID=160547) and [Windows](https://stolafcarleton.teamdynamix.com/TDClient/3356/Portal/KB/ArticleDet?ID=160545). You can also [remotely connect to COURSES](https://stolafcarleton.teamdynamix.com/TDClient/2092/Carleton/KB/ArticleDet?ID=148546). If you run into trouble with these setups, you can ask me or Mike Tie for help, but I do really recommend just working in Olin 310.

## Parts of this assignment:
* [Part 1: Hello, user!](#part-1-hello-user)
* [Part 2: Early mornings](#part-2-early-mornings)
* [Polishing](#polishing)
* [Reflection](#reflection)


## Comments and collaboration

For each assignment in this course, you are expected to provide top-level comments (lines that start with `#` at the top of the file) on any `.py` source code files with your name and a collaboration statement. For this assignment, your programs should be named `intro.py` and `mornings.py`.

Here is an example of how you can start your file:

```python
# File: intro.py
# Author: Lulu Amert
# Purpose: Assignment #1 - Hello, Python!
#
# Collaboration statement:
# - Milo: partner (worked on code together)
# - Hobbes: discussed issues with spaces in print() output
# - Mal (Course Staff): how to find print() in Python documentation
# - I asked the HW1 chat bot for help on tuples
```

Here is another example:

```python
# File: intro.py
# Author: Hobbes Amert
# Purpose: Assignment #1 - Hello, Python!
#
# Collaboration statement: I worked alone.
```

## Gemini Bot
As mentioned in the syllabus, I am experimenting with custom-made Gemini chatbots ("Gems") that hopefully will help you on the homework without undermining your learning. [Here is the one for homework 1](https://gemini.google.com/gem/1KQHTVvCv_PWtwoRhLC_Qp3FUrAk17E-R?usp=sharing). If you use this, I would appreciate you copying some example interactions with it to a text document and uploading that to Gradescope along with your submission. This is both to give me an idea of whether it is providing correct information and if it is actually being helpful. If you manage to get it to produce solutions or otherwise inappropriate responses, please let me know asap so that I can prevent it from undermining everyone's learning further.

## Part 1: Hello, user!

For this part, you should write a program that asks the user for their first and last name, and then greets them by name. Your program should also ask their age and give them an estimate on the number of days old they are (assuming exactly 365 days per year). This code should live in a file named `intro.py`.

Here is an example interaction that your program should be able to mimic:

```python
Hello there!
What is your first name? Lulu
What is your last name? Amert
How old are you, in years? 13

Have a great day, Lulu Amert!
You are approximately 4745 days old.
```

Here is another example:

```python
Hello there!
What is your first name? Cheddar
What is your last name? Amert
How old are you, in years? 1

Have a great day, Cheddar Amert!
You are approximately 365 days old.
```

## Part 2: Early mornings

Python has the ability to group data, for example into pairs (called `tuples`):

```python
tup1 = ("cat", 3)
tup2 = ("mouse", 5)
tup3 = ("giraffe", 7)
```

You can even make one of these pairs using variables:

```python
animal = "elephant"
length = 8
tup4 = (animal, length)
```

There is also a handy built-in function `min` that can give us the "smallest" of two or more inputs. This behaves logically for numbers, and for strings it compares "alphabetically" (it’s more complicated, but we’ll explore that later). For example:

```python
a = min(4, 2)
b = min(tup1, tup2, tup3, tup4) # defined in the previous code snippets
print(a) # prints 2
print(b) # prints ('cat', 3)
```

You may also find it helpful to give separate names to the parts of a tuple:

```python
animalName, nameLength = b # ('cat', 3), so animalName = 'cat' and nameLength = 3
print("Animal:", animalName)
print("Length:", nameLength)
```

For this part, you should write a program in `mornings.py` to ask the user to type in three students' names and earliest class times on Mondays/Wednesdays/Fridays (e.g., the user will type `2a` or `6a`). You should make pairs for students' names and class times and use the `min` function to find the student with the earliest classtime.

Note: For the advanced requirements, you must not use any `if` statements, even if you already know about them from prior CS experience.

For example, if Boris has a 2a, Miyeon has a 3a, and Juan has a 1a, then the program would print out that Juan has the earliest class (1a). In this example, the interaction should look like this:

```bash
Please enter three students' names and hit enter after each:
Boris
Miyeon
Juan

Please enter their earliest classtimes and hit enter after each:
2a
3a
1a

Juan has the earliest class (1a).
```

Here is another example:

```bash
Please enter three students' names and hit enter after each:
Alicia
Sven
Ming

Please enter their earliest classtimes and hit enter after each:
2a
5a
4a

Alicia has the earliest class (2a).
```

Keep in mind that for credit, you will need to match this interaction exactly, including punctuation and spaces.

## Polishing
Any program with more than a few lines of code (so nearly all of them), should have comments describing what blocks of the code do. We'll learn more about how to better organize code in the future, but for now you should put in a couple of comments describing what blocks of code are doing so that someone reading your program can easily see what is going on. You should also make sure any variables you used are named well and make sure your header describes what the program does. Finally, be mindful of the spacing in your program: how can you use an extra line here or there to make it easier to read, but not too many? There are several right answers to these style questions, so go with what you think makes it easiest to read and stay consistent. The graders will give feedback on style to help you improve it.

## Reflection

Were there any particular issues or challenges you dealt with in completing this assignment? How long did you spend on this assignment?

Write a brief discussion (a sentence or two is fine) at the bottom of your `intro.py` file (in comments, so each line should start with `#`).

Here are some examples:

```python
##### Reflection #####
# I had trouble getting the spaces right in the output.
# I had to look up how to use print() in the Python documentation.
# I spent 4 hours on this assignment.
```
```python
##### Reflection #####
# I started late, so I had to rush to make sure I knew how to use VS Code.
# It may be good to start early next time.
# I spent 3 hours on this assignment.
```
```python
##### Reflection #####
# It went fine; I found what I needed in my notes.
# I spent 1 hour on this assignment.
```



## Submission
You should submit your two files through the Gradescope link on Moodle for this assignment.
You are able to upload them both to Gradescope, at which point the autograder will run and let you know if your code works correctly.
You are able to submit your code as many times as you wish before the deadline to fix any issues.
If you have questions about what the autograder is telling you is wrong, please ask!

## Acknowledgements
This homework is from Prof. Tanya Amert, she has the fun pet names :).