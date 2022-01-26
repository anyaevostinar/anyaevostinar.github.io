---
layout: page
title: More Functions Lab
permalink: /classes/111-w22/functions2
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.

## Exercise 1
For each of the following snippets of code, predict what they will do and then walk through their execution by clicking the Next button:

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=def%20bar%28lst%29%3A%0A%20%20%20%20print%28lst%29%0A%20%20%20%20lst%5B0%5D%20%2B%3D%2010%0A%20%20%20%20print%28lst%29%0A%0AmyList%20%3D%20%5B1,%202,%203%5D%0A%0Abar%28myList%29%0A%0Aprint%28myList%29%0A%0A&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=nevernest&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=def%20addTileToHand%28tile,%20hand%29%3A%0A%20%20%20%20tile%20%3D%20'-'%20%2B%20tile%20%2B%20'-'%0A%0A%20%20%20%20hand.append%28tile%29%0A%0AmyTile%20%3D%20'a'%0AmyHand%20%3D%20%5B'-b-',%20'-c-'%5D%0AaddTileToHand%28myTile,%20myHand%29%0Aprint%28myTile%29%0Aprint%28myHand%29%0A%0A&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=nevernest&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=def%20mystery%28n%29%3A%0A%20%20%20%20total%20%3D%201%0A%20%20%20%20while%20n%20%3E%200%3A%0A%20%20%20%20%20%20%20%20total%20*%3D%20n%0A%20%20%20%20%20%20%20%20n%20-%3D%201%0A%20%20%20%20return%20total%0A%0Ax%20%3D%204%0Amystery%28x%29%0A&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=nevernest&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

## Exercise 2

The [previous lab](functions1) had you make several functions to reverse the letters in words which just printed their information to the output.
Often, it is useful to instead *return* values so that they can be used by other parts of a program.
Pull up your code (or finish that problem if you didn't previously) and update it so that the `reverseWord()` and `reverseAllWords()` functions return their results instead of printing them, and then `main()` takes care of the printing.

## Exercise 3
A "palindrome" is a word that can be written the same way both forwards and backwards. 
For instance, "racecar" and "anna" are palindromes, while "sedan" and "david" are not.

Create a new file called `palindrome.py`. 
This program will take a word as input from the user and then tell the user whether or not it is a palindrome. 
You should include at least two function definitions: one for `main()` and one for `isPalindrome(word)` which takes a string as a parameter and returns a boolean value indicating whether or not the given word is a palindrome.

Your program should also make use of the `reverseWord` function that you created in `reverse.py`. 
To allow for this function to be used in another program, you should not copy and paste the function into the new file, but instead `import` the function from `reverse.py` into `palindrome.py`. 
This will allow you to use that function in `palindrome.py`, even though it was defined in another program! 
This is a very common practice in Python programs, which often span multiple files. 
To import and use the `reverseWord` function from `reverse.py` in `palindrome.py`, use code like this (import statements should always go at the top of a file):
```
from reverse import reverseWord

name = "Anya"
reversedName = reverseWord(name)
```

Note that this will only work if `palindrome.py` and `reverse.py` are in the same folder on your computer. 
But you may now experience a strange issue: whenever you run `palindrome.py`, it bizarrely runs the `main()` function of your `reverse.py`. 
The reason is as follows. 
Whenever Python imports code from one file, what it’s actually doing is running every line in the file that you’re importing, because this is necessary to execute the definitions for all the functions that you want to import! 
But the problem is that it will eventually get to the line in `reverse.py` with your `main()` call, which it will execute, because it’s executing every line in `reverse.py` as part of the import process. 
To fix this issue, replace the line `main()` in your `reverse.py` file with the following two lines:
```
if __name__ == "__main__":
    # Any code indented below this line will only
    # be executed if this file is *directly* invoked,
    # not merely imported from another file.
    main()
```

Remember that `__name__` is just another variable, one that is set when your code is run. 
That variable is set to `__main__` if you program is run directly, but to something else if your code is imported.
That means that these lines are telling Python “Only run the code in this block if you’re directly running this file — if you’re just importing this file into another one, do not run all the code under this block."
You can put any code there, to be clear; there’s nothing special about `main()` in this case, though this is a frequent use of this block.

## Extra
If you have extra time, try to write another version of the `isPalindrome` function from above that does not make use of `reverseWord`, and does not make use of an additional string variable at all — rather, it should determine its answer purely by looping through the given word to the function.
