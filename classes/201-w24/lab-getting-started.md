---
layout: page
title: Getting Started Lab 
permalink: /classes/201-w24/getting-started
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

## Exercise 0

1. [Mount the COURSES drive](https://stolafcarleton.teamdynamix.com/TDClient/3356/Portal/KB/ArticleDet?ID=152558)
2. Create a new folder in your STUWORK folder called `Lab1`
3. Open VSCode
4. Click and drag you `Lab1` folder to the VSCode window to open it
5. Create a new file named `Hello.java`
6. Drag up from the bottom of the VSCode screen to open a `Terminal`

## Exercise 1
You'll now test out using Gradescope.

1.	Navigate to Moodle, today’s class section and click on the “In Class Assignment” Gradescope link
2.	Upload `Hello.java` to Gradescope (yes, even though it’s empty)
3.	Notice what the autograder does when your code doesn’t work correctly
4.	In `Hello.java`, write the necessary code to print out "Hello world!"
5. Verify your program works by typing in the Terminal `javac Hello.java` and then `java Hello`
7.	Upload `Hello.java` to Gradescope again and make sure that you pass the "Check if it prints correctly" test case
8. Add your partner to the submission on Gradescope

## Exercise 2
You'll be required to include `README.md` documents for all your homework this term. `.md` is a Markdown file, which is a specific way of formatting files, commonly used in programming projects (including this website :D). You can see an [example README here](readme_example).

Here are the important formatting aspects:
* `#` makes a large heading, `##` medium, `###` small, use them to mark sections of your document
* `*` makes a bulletted list, you can also use numbers `1.`
* Three \` (the key to the left of 1) start a section of code and three more end that section
* One \` makes an inline "code" formatting `like this`, good for variables and class names
* `*word*` makes word *italic*
* `**word**` makes word **bold**

Use this information to make a README for your submission, along with a document `Collaborations.txt` that just has both partners' names. Verify that you pass all test cases once you upload these two documents as well.

## Exercise 3
Let me know that you've submitted your Gradescope assignment. I'll aim to give you 'feedback' right away so you can see what that looks like as well.

## Extra

The cool thing about object-oriented programming is that you can simulate nearly anything in the real world. If you have extra time, aim to practice private and class variables, creating objects of your own making, and other Java functionality, by making a basic class with the ingredients below. I include some ideas at the end if you would like to use one of them.

### Ingredients
* Create a new class in its own file, which I'll refer to here at `YourClass`
* `YourClass` has and uses at least one private variable
* `YourClass` tracks how many instances of `YourClass` have been created (using a class variable which uses the `static` keyword!) and uses that number
* `YourClass`'s `main` creates at least one instance of `YourClass` (more would be great!)
* `main` takes at least one command line argument and uses it meaningfully
* `YourClass` takes user input while the program is running and uses it meaningfully
* `YourClass` prints out something useful 

### Ideas
* Library catalog
* Sport stats displayer
* Song recommender
* Tweak the above ideas to be about cooking recipes, video games, workouts, or anything else that interests you
