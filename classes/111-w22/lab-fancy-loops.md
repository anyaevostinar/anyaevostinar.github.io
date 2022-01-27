---
layout: page
title: Fancy Loops Lab
permalink: /classes/111-w22/fancy-loops
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.

## Exercise 1
There is a game where you try to guess a number between 1 and 100, being told if you guess is too high or too low. 
Here is code that mostly works for that game:
```
import random

number = random.randint(0, 100)
print("Welcome to the Guessing Game! Guess a number between 1 and 100")
guess = -1
while guess != number:
    guess = int(input("Guess a number: "))
    if guess < number:
        print("Too low!")
    else:
        print("Too high!")
```

There is a bug, however. 
In what situation will this code not work correctly?

## Exercise 2
Fixing that bug is actually slightly annoying and brings up a common situation in programming, which the reading suggested several different remedies for.
Fix the bug in three different ways using each of the following *design patterns* from the reading (you will probably want three different functions to contain each of your different versions of the game):
* a post-test loop started by seeding the initial value
* a post-test loop using `while True` and `break`
* a loop and a half

## Exercise 3
Consider the following code, predict what it will print, and then walk through the steps:

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=my_list%20%3D%20%5B1,%202,%203,%204,%20%5B5,%206%5D%5D%0Amy_other_list%20%3D%20my_list%0Aslice_list%20%3D%20my_list%5B2%3A4%5D%0Acopy_list%20%3D%20my_list%5B%3A%5D%0A%0Acopy_list%5B0%5D%20%3D%2010%0Acopy_list%5B4%5D%5B0%5D%20%3D%2011%0A%0Aprint%28my_list%29&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=nevernest&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

Based on what you see there, what rules can you conclude about how to use slicing to copy a list?

## Exercise 4
The game code still isn't very robust. 
Improve it by:
* prompting the user repeatedly if they enter something that isn't an int between 1 and 100
* allowing the game to go from any negative number to any positive number to increase the difficulty
* whatever other expansions or improvements you can think of!

## Exercise 5
Many of the functions for lists aren't actually needed since you can implement them yourself, though they are convinient.
Try writing the following functions which are your own versions of built-in list methods (make sure to use a different name than the built-in!):
* my_reverse(a_list)
* my_index(a_list, item_to_find)
* my_count(a_list, item)
* my_remove(a_list, item) - use `del` for this
* my_pop(a_list, index) - use `del` for this
* my_insert(a_list, location, item)
* Slicing (that makes a new list remember!)
* my_sort(a_list) - we'll talk about sorting in a few weeks, but think about how you could do it

