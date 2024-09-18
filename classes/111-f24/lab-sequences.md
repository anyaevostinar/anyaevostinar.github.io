---
layout: page
title: Sequences Lab 
permalink: /classes/111-f24/sequences
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and quizzes so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in [COURSES as you usually do](getting-started).


## Exercise 1
For each snippet, what would it print out to the screen? If you think there will be an error, indicate the line with the error and explain why.
After you've made a prediction, test out the code.

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=words%20%3D%20%5B'limited',%20'knowledge',%20'provoking',%20'quadruple',%20'happiness'%5D%0A%0Awords%5B0%5D%20%3D%20'limitless'%0A%0Aone_word%20%3D%20words%5B1%5D%0Aone_word%20%3D%20'hello'%0A%0Aprint%28%22%20%22.join%28words%29%29&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=nevernest&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=words%20%3D%20%5B'limited',%20'knowledge',%20'provoking',%20'quadruple',%20'happiness'%5D%0A%0Aletter%20%3D%20words%5B0%5D%5B0%5D%0Aprint%28letter%29%0A%0Awords%5B0%5D%5B5%5D%20%3D%20'l'&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=nevernest&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>


This last snippet gives you a preview of the cool things that you can do with for-loops, which we'll officially get to next time. Play around with it to see what happens!
<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=words%20%3D%20%5B'limitless',%20'knowledge',%20'provoking',%20'quadruple',%20'happiness'%5D%0Ai%20%3D%200%0Afor%20word%20in%20words%3A%0A%20%20%20%20print%28word%5Bi%5D,%20end%3D''%29%0A%20%20%20%20i%20%3D%20i%20%2B%202%0A%0Aprint%28'%20',%20end%3D''%29&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=true&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

## Exercise 2

1. Create a new file and write a program to count the number of vowels (“aeiouy”) in a user-given string. You can assume the string is all lowercase. You don't need to use any loops to solve this problem, remember to refer to the different methods [in the reading](https://moodle.carleton.edu/mod/lti/view.php?id=965301).

2. Update your program so that instead of counting vowels, it asks the user for characters to count in a given string (could be just one, or more than one, so you will need a for-loop for this problem).

## Exercise 3
Now that you know how to make lists of strings, you could make a list of colors or stamps that the turtles use to generate rainbows, random combinations, and other fun creations. 

A particularly powerful function from the random module is `choice`:

```python
import random
colors = ["red", "blue", "green", "yellow", "purple", "orange"]
random_color = random.choice(colors)
```

Create a program that uses 1) the random module, 2) the turtle module, and 3) a list of colors and/or shapes to generate random turtle artwork.
You should reference the [Turtle methods](https://moodle.carleton.edu/mod/lti/view.php?id=965490) from the previous lab for this.

## Extra
If you finish early, try out the [end of chapter exercises](https://moodle.carleton.edu/mod/lti/view.php?id=965770).