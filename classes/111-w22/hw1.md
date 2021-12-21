---
layout: page
title: HW1 First Python Programs
permalink: /classes/111-w22/hw1
---

## Logistics

This is an individual assignment, so you should complete it on your own, though you are able to get help from many sources as detailed in the [collaboration](collaboration) policy.

This assignment is worth 8 points total, 4 of which are checked on Gradescope automatically with an **autograder** and 4 of which are based on style, which will be explained below.

This assignment is due on Wednesday Jan 12th at 10pm. See the [syllabus](syllabus) for the late policy.

## Goals
The goal of this assignment is two-fold. First, to get started with basic Python programming and thinking algorithmically. Second, to test out the Gradescope autograding process and work out any issues. Like the Paper Flower assignment, this one is easier and has less requirements than future assignments will.

## Setup
I recommend that you complete this assignment in Olin 310.

[Mount the COURSES drive](https://wiki.carleton.edu/pages/viewpage.action?spaceKey=carl&title=CS+111+and+201+workflow+in+CS+labs) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HW1`
* Open your `HW1` folder in VSCode
* Create two files `helloworld.py` and `input.py`

If you really want to use your personal machine, there are instructions for installing VSCode and Python available: [Mac](https://wiki.carleton.edu/pages/viewpage.action?pageId=92275629) and [Windows](https://wiki.carleton.edu/pages/viewpage.action?pageId=92275633). You can also [remotely connect to COURSES](https://wiki.carleton.edu/display/itskb/Network+Drives). If you run into trouble with these setups, you can ask me or Mike Tie for help, but I do really recommend just working in Olin 310.

## Hello World

* In `helloworld.py` type out the following (don't copy and paste, copying even comments in Python often leads to weird errors):
```
# helloworld.py
# CS 111, Winter 2022
# This is the traditional first program to write in any programming language.
```
This is a header.
The lines that begin with `#` are comments, which are ignored when your program is being executed. 
(They’re there to help people who are reading the program understand what it’s doing.)
You should include a similar header on all programs you submit for this class (and in general).
Such headers and comments will contribute to your *style* points for an assignment.

* Now make it so that when the program runs, it prints out the following **exactly**:
```
Hello, world!
```
When I say exact, I mean exact. 
In this class, I have written **autograders** for most assignments, which run on your code as soon as you submit it and let you know if you are passing the tests that I've written.
Those tests check if your output matches what I've specified down to the spaces, so it's very important that you follow my specifications exactly.
(This may seem annoying, but it is a valuable skill to master. It is very common in computer science for you to have very specific instructions that you need to follow for something to work or for a client to be happy.)
The benefit of the autograders is that you can know right away if you code isn't doing exactly the right thing and fix it before the deadline!

* You should always check that your code works after writing a small piece, so open a Terminal window in VSCode (either by clicking 'Terminal'->'New Terminal' from the menu at the top or by dragging up from the bottom of your screen) and type the following:
```
python3 helloworld.py
```
Make sure that it matches the above output exactly.

## Input
Now you'll do some more complicated tasks in Python. 
Everything that I ask of you here is something that you can accomplish with just the code that you've seen in Zelle 1.6-1.7.

* Create a header for your file (you don't know what it does yet, so remember to go fill that in once you've figured that out)

* Have your program print the following by storing the year in a **variable**:
```
It is currently the year 2021
```

* Next have your program ask for the user's name:
```
What is your name? 
```

* Next have your program greet the user by name:
```
Hi, <name>
```

* Remember to test your program after every chunk of code that you write to make sure it is working. This is what you should have so far, if your name is Anya:
```
$python3 input.py
It is currently the year 2021
What is your name? Anya
Hi, Anya
```

* Next have your program ask the user's age:
```
How old are you?
```

* Next have your program print the square of the user's age:
```
The square of your age is <value>
```

* This is a good time to check to make sure your code is working correctly again:
```
$ python3 input.py
It is currently the year 2021
What is your name? Anya
Hi, Anya
How old are you? 200
The square of your age is 40000
```

* Now have your program also print out the following:
```
You are now twice the age you were in <answer>
```
One slightly strange thing that you might have noticed is that you might be being told a year that’s represented using a decimal point, which is probably not how you think of years. 
(Was the Magna Carta really signed in year 1215.0?) 
We’ll talk about this issue more in a little while — it’s related to the way that numbers are stored internally in Python — but you can fix it right now. Instead of printing the value of `currentYear - age/2` for example, you can print the value of `currentYear - int(age/2)`, or `int(currentYear - age/2)`. The function `int` stands for **int**eger, and it converts any number it’s given into an integer. (The function `int` is “generous” about your age: it rounds down.)

You should now get the following:
```
$python3 input.py
It is currently the year 2021
What is your name? Anya
Hi, Anya
How old are you? 200
The square of your age is 40000
You are now twice the age you were in 1921
```

* Also print out the year that the user will be twice their current age:
```
You will be twice your current age in <year>
```

* Finally, have your program print out the first U.S. presidential election in which the user could vote. (Assume that the user’s birthday is not between today and Election Day, the second Tuesday in November, and that the user is otherwise eligible to vote.) This calculation is a bit trickier in its logic, because: 1) a voter must be 18 years old to vote. 2) Presidential elections happen only every four years, in years that are divisible by 4 (like 2008 or 2020, because 2008 = 502 * 4 and 2020 = 505 * 4).

You’ll have to figure out a formula to express the first year that the user is at least 18 years old and the year is divisible by 4. (Yes, you could look up some more advanced features of Python to accomplish this task, and it’s fine to — but I also promise that you can do it using only the elements from this problem set.) Here’s a small hint (about decades instead, but still relevant):
```
year = 2021
decade = int(year / 10)
print("I love the", decade, "0s.")

# Or, for comparison, with better spacing:
print("I love the " + str(decade) + "0s.")
```

Here is the final output that your program should handle:
```
$ python3 input.py
It is currently the year 2021
What is your name? Anya
Hi, Anya
How old are you? 200
The square of your age is 40000
You are now twice the age you were in 1921
You will be twice your current age in 2221
Eligible to vote in: 1836
```

* Any program with more than a few lines of code (so nearly all of them), should have comments describing what blocks of the code do. We'll learn more about how to better organize code in the future, but for now you should put in a couple of comments describing what blocks of code are doing so that someone reading your program can easily see what is going on. You should also make sure any variables you used are named well and make sure your header describes what the program does. Finally, be mindful of the spacing in your program: how can you use an extra line here or there to make it easier to read, but not too many? There are several right answers to these style questions, so go with what you think makes it easiest to read and stay consistent. The graders will give feedback on style to help you improve it.

## Rubric
Your assignment will be graded with the following rubric:

| Item | Points |
|------|--------|
| Passes tests | 4 |
| Style (header, comments, variable names, spacing) | 4 |

## Submission
You should submit your two files through the Gradescope link on Moodle for this assignment.
You are able to upload them individually to Gradescope, at which point the autograder will run and let you know if your code works correctly.
You are able to submit your code as many times as you wish before the deadline to fix any issues.
If you have questions about what the autograder is telling you is wrong, please ask!
