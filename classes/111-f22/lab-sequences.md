---
layout: page
title: Sequences Lab 
permalink: /classes/111-f22/sequences
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and quizzes so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.


## Exercise 1
For each snippet, what would it print out to the screen? If you think there will be an error, indicate the line with the error and explain why.
After you've made a prediction, test out the code.

<iframe width="800" height="800" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=words%20%3D%20%5B'limitless',%20'knowledge',%20'provoking',%20'quadruple',%20'happiness'%5D%0Ai%20%3D%200%0Afor%20word%20in%20words%3A%0A%20%20%20%20print%28word%5Bi%5D,%20end%3D''%29%0A%20%20%20%20i%20%3D%20i%20%2B%202%0A%0Aprint%28'%20',%20end%3D''%29&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=true&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

<iframe width="800" height="800" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=words%20%3D%20%5B'limitless',%20'knowledge',%20'provoking',%20'quadruple',%20'happiness'%5D%0Aj%20%3D%20-1%0Afor%20k%20in%20range%283,%200,%20-1%29%3A%0A%20%20%20%20print%28words%5Bk%5D%5Bj%5D,%20end%3D''%29%0A%20%20%20%20j%20%3D%20j%20-%201%0A%0Aprint%28%29&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=true&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

## Exercise 2

1. Create a new file and write a program to count the number of vowels (“aeiouy”) in a user-given string. You can assume the string is all lowercase.

2. Update your program so that instead of counting vowels, it asks the user for characters to count in a given string (could be just one, or more than one).

## Exercise 3
Now that you know how to make lists of strings, you could make a list of colors or stamps that the turtles use to generate rainbows, random combinations, and other fun creations. 
Create a program that uses 1) the random module, 2) the turtle module, and 3) a list of colors and/or shapes to generate random turtle artwork.

## Extra
If you finish early, try out the [end of chapter exercises](https://runestone.academy/ns/books/published/intro-cs/Sequences/week2a1.html) or the [XKCD password generator lab](https://runestone.academy/ns/books/published/intro-cs/Projects/xkcd_pass.html#xkcd-pass) for more practice.