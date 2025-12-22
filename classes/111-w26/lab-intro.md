---
layout: page
title: Intro Lab 
permalink: /classes/111-w26/lab-intro
---

This is a lab assignment, so it isn't required to complete.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class. If you do finish it and submit it to Moodle, you'll earn an extra engagement credit.

## Exercise 0
This is what you already did hopefully, just a reminder.

([This link has screenshots](https://stolafcarleton.teamdynamix.com/TDClient/3356/Portal/KB/ArticleDet?ID=152558) to accompany these instructions if you want them.)
1. Mount the COURSES drive by double clicking the courses Desktop icon (if you didn't use the checkbox when you logged in)
2. Create a new folder in your STUWORK folder called `Lab0`
3. Open VSCode
4. Click and drag you `Lab0` folder to the VSCode window to open it
5. Create a new file named `hello.py`
6. Drag up from the bottom of the VSCode screen to open a `Terminal`

## Exercise 1: Hello, world!

For this exercise, predict the output and then execute each of the following commands in VS Code.

```python
# 1a
print("Hello, world!")
## Prints:  FILL IN HERE

# 1b
print("Hello", "world!")
## Prints:  FILL IN HERE

# 1c
print("Hello")
print()
print("world!")
## Prints:  FILL IN HERE
```

## Exercise 2: Getting user input
In this exercise, you’ll practice using the `input()` function to ask the user for input.

### Part a: getting multiple inputs
We can use the `input` function to ask the user for multiple inputs.

```python
print("Please type 4 numbers (ints or floats), hitting enter/return after each.")
num1 = input()
num2 = input()
num3 = input()
num4 = input()
print("Their product is:", float(num1) * float(num2) * float(num3) * float(num4))

## This program does the following:  FILL IN HERE
```
What do you think will happen when this program runs? Predict the result and then type it up in VS Code to find out.

### Part b: your first function
We can also include a parameter to `input` to prompt the user. Type the following lines of code in VS Code and observe the output.

```python
# 2a: Get user input
animal = input("What is your favorite type of animal? ")
print("Your favorite type of animal is:", animal)

# 2b: Write and use a function to congratulate the user
def congratulate(firstName):
    print("Congratulations,", firstName, ":)")

congratulate("Lulu")
congratulate("Hobbes")
congratulate(Milo) # what's different here?

## This program does the following:  FILL IN HERE
```

*Food for thought: How could you add punctuation after the name, without a space in between?*

## Submission
Submit your commented file to Moodle for an engagement credit. Be sure to share the code with your partner.

## Acknowledgements
This lab is from Prof. Tanya Amert, with the cool pet names.