---
layout: page
title: First Functions Lab 
permalink: /classes/111-w22/functions1
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.

## Exercise 1
For each of the following snippets of code, predict what they will do and then walk through their execution by clicking the Next button:

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=x%20%3D%203%0A%0Adef%20f%28x%29%3A%0A%20%20%20%20print%28x%2B3%29%0A%0Af%285%29%0Aprint%28x%29%0A&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=nevernest&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=def%20g%28y%29%3A%0A%20%20%20%20a%20%3D%204%0A%20%20%20%20print%28a%20%2B%20y%29%0A%0Ag%281%29%0Aprint%28a%29%0A&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=nevernest&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=def%20peacock%28%29%3A%0A%20%20%20%20print%28msg%29%0A%20%20%20%20print%28'Caw!'%29%0A%0Adef%20main%28%29%3A%0A%20%20%20%20msg%20%3D%20'Quiet...'%0A%20%20%20%20peacock%28%29%0A%20%20%20%20msg%20%3D%20'Wow!'%0A%20%20%20%20peacock%28%29%0A%0Amain%28%29%0A&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=nevernest&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

## Exercise 2

Let’s write a program that receives a phrase from the user, reverses the order of each word, and then prints the result back out to the screen. 
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

Write a program called `reverse.py` to carry out the above algorithm. 
Your program should contain at least three functions, with the following names and parameters (given in parentheses):
* `main()` should contain the high-level algorithm (Steps 1 – 3).
* `reverseAllWords(phrase)` should take a string phrase as a parameter and print a string containing the same phrase with every word reversed (Steps 2 and 3).
* `reverseWord(word)` should take a string word as a parameter and print a string containing the same word in reverse order (The subparts of Step 3). `reverseAllWords` should call this function.

Be sure to test your program on different inputs. 
Important tip: one benefit of modularization is the ability to test different parts of your program separately. 
Before writing and testing your entire program, try writing the `reverseWord(word)` function and test it on its own!

Here's a couple of string functions that might be helpful to you:
* `.split()` will split a string into a list of substrings that had been separated by whitespace in the original string. Note: this cannot be used to break a string into a list of each of its characters. If you want to do this, try something like `strList = list(str)` or just a for-loop.
* Remember you can go backwards in a for-loop by using `range()` with -1 as the third argument.
* Remember you can print without a newline or space by using `end=''`


## Extra
Here are more code snippets to predict and test:

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=b%20%3D%204%0A%0Adef%20h%28z%29%3A%0A%20%20%20%20print%28z%20%2B%20b%29%0A%0Ac%20%3D%203%0Ah%28c%29%0A%0A&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=nevernest&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=def%20foo%28n%29%3A%0A%20%20%20%20print%28n%29%0A%20%20%20%20n%20%2B%3D%201%0A%20%20%20%20print%28n%29%0A%0Ax%20%3D%203%0A%0Afoo%28x%29%0A%0Aprint%28x%29%0A%0A&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=nevernest&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

In addition, a great thing to do is think about programs like drafts of a paper.
It's good to get down a first draft and then revise or *refactor* it. 
Pull up some of your old lab assignments and try refactoring them to use functions