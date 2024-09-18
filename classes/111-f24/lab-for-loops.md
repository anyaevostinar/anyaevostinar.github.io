---
layout: page
title: Iteration Lab 
permalink: /classes/111-w24/iteration-lab
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and quizzes so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES [as you usually do](getting-started).

Remember you can refer to the [textbook readings](https://moodle.carleton.edu/mod/lti/view.php?id=905616) if you forget the syntax for something.


## Exercise 1
For each snippet, what would it print out to the screen? If you think there will be an error, identify the line with the error and why.
After you've made a prediction, test out the code.

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=for%20i%20in%20range%285,%200,%20-1%29%3A%0A%20%20%20%20print%28i%29&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=true&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=for%20i%20in%20range%280%29%3A%0A%20%20%20%20print%28%22hi%22%29&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=true&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

<iframe width="800" height="800" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=words%20%3D%20%5B'limitless',%20'knowledge',%20'provoking',%20'quadruple',%20'happiness'%5D%0Aj%20%3D%20-1%0Afor%20k%20in%20range%283,%200,%20-1%29%3A%0A%20%20%20%20print%28words%5Bk%5D%5Bj%5D,%20end%3D''%29%0A%20%20%20%20j%20%3D%20j%20-%201%0A%0Aprint%28%29&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=true&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

## Exercise 2
Create a new file and write short program to compute the *factorial* of a positive integer given by the user. The factorial of a positive integer is the product of all of the numbers from 1 up to that integer. For example, 4 factorial (written “4!”) is equal to 1 * 2 * 3 * 4 = 24.

## Exercise 3
Write a program, `reverse.py` that receives a word from the user and reverses the letters, so "sea" would become "aes".

## Exercise 4
Now let’s expand on your previous program so that it receives a phrase from the user, reverses the order of each word, and then prints the result back out to the screen.
The order of the words relative to one another should remain the same, but each word's letters should be reversed, as in the following example:
```
Input a phrase: stay warm out there
yats mraw tuo ereht
```

As with any program, we should start out by laying out our algorithm, which at a high level might look something like this:
1. Get phrase from user.
2. Split phrase into words
3. For each word in the phrase
    * Reverse the letters
    * Combine the letters back together
    * Print the reversed word

Expand on `reverse.py` to carry out the above algorithm.
[Here is a link](https://moodle.carleton.edu/mod/lti/view.php?id=905590) to the sequences reading if you need to refresh on working with strings.

## Extra
If you finish all of the above, try out some of the [end of chapter exercises](https://moodle.carleton.edu/mod/lti/view.php?id=906151) for more practice.