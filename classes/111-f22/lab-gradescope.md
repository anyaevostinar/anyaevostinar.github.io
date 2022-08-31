---
layout: page
title: Getting Started Lab 
permalink: /classes/111-w22/getting-started
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

## Exercise 0
This is a repeat of the walk through that we did together, in case you missed something.

1. [Mount the COURSES drive](https://wiki.carleton.edu/pages/viewpage.action?spaceKey=carl&title=CS+111+and+201+workflow+in+CS+labs)
2. Create a new folder in your STUWORK folder called `Lab1`
3. Open VSCode
4. Click and drag you `Lab1` folder to the VSCode window to open it
5. Create a new file named `hello.py`
6. Drag up from the bottom of the VSCode screen to open a `Terminal`

## Exercise 1
You'll now test out using Gradescope.

1.	Navigate to Moodle, today’s class section and click on the “In Class Assignment” Gradescope link
2.	Upload `hello.py` to Gradescope (yes, even though it’s empty)
3.	Notice what the autograder does when your code doesn’t work correctly
4.	In `hello.py` type: `print(“hello world!”)`
    a.	**Don't copy and paste!** You should always type out Python code even if copying and pasting it is an option. Copying often introduces errors to the code because of weird spaces and it is good practice for you to start getting used to typing Python commands.
5.	Save `hello.py`
6.	See what your program does by typing `python3 hello.py` in the VSCode Terminal (it should print out “hello world!” without the quotes)
7.	Upload `hello.py` to Gradescope again and make sure that you pass the first test case

## Exercise 2
We'll be doing a lot with getting input from the Terminal in these first few weeks and it's a little annoying to make sure that the formatting is just right for this sort of thing, so you'll now get some practice.

1. Make another file `hello_input.py`
2. You can accept input from the user with the command *`input`* and save it to use later in a *variable* (we'll learn more about exactly what variables and `input` do in the coming week). Type the following into your new file:
    ```python
    new_name = input("What is your name?")
    print(new_name)
    ```
3. Run your program by typing `python3 hello_input.py` in the Terminal.
4. Change your program so that it does the following when run:
```
python3 hello_input.py
What is your name? Anya
Hello, Anya!
```
5. Upload both of your files to the Gradescope In Class Assignment to check if all the test cases are now passing.

## Exercise 3
Switch who is logged in and go back through the exercises on the other partner's account.


