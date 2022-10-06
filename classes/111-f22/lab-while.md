---
layout: page
title: Indefinite Loops Lab 
permalink: /classes/111-f22/while-loops
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and quizzes so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.

## Exercise 1
What do you think this snippet will print to the screen? Make a prediction and then test it. If you find you need to stop the program running, hit Ctrl+c to kill it.

```python
x = 15
while True:
  x = x + 2
  print(x)
```

## Exercise 2
Write the following as an indefinite loop:

```python
for i in range(10, 2, -1):
  x = 2*i + 3
  print(x)
```

## Exercise 3
a. I want to print out the first 20 powers of 5 (e.g., 1, 5, 25, 125...). Write both a for loop and a while loop that will do so.

b. Change them both to save the numbers in two separate lists instead and then compare the lists to make sure that they have the same values. Print out whether the two lists have the same values (should be true obviously, but how do you check to make sure that it works if it wasn't true?).

## Exercise 4
Consider the following code:

```python
i = 2
while i < 100:
  j = 2
  count = 0

  while j < i:
    if i % j == 0:
      count = count + 1
    j = j + 1

  if count == 0:
    print(i)

  i = i + 1
```

a. What task does this code accomplish?

b. Write a set of nested for loops to accomplish the same task.

## Exercise 5
There is a game where you try to guess a number between 1 and 100, being told if you guess is too high or too low. 
Here is code that mostly works for that game:

```python
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

## Exercise 6
Fixing that bug is actually slightly annoying and brings up a common situation in programming.
Fix the bug in three different ways using each of the following *design patterns*  (you will probably want three different functions to contain each of your different versions of the game):
* a post-test loop started by seeding the initial value (nearly what is already there, but adding another conditional check)
* a post-test loop using `while True` and `break` (where the `break` is at the end of the loop)
* a loop and a half (where the `break` is earlier in the loop)

## Exercise 7
The game code still isn't very robust. 
Improve it by:
* prompting the user repeatedly if they enter something that isn't an int between 1 and 100
* allowing the game to go from any negative number to any positive number to increase the difficulty
* whatever other expansions or improvements you can think of!