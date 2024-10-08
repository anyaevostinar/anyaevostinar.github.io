---
layout: page
title: More Functions and Loops Lab 
permalink: /classes/111-f24/lab-return-while
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES [as you usually do](getting-started).

## Exercise 1

What do you think this snippet will print to the screen? Make a prediction and then test it. If you find you need to stop the program running, hit Ctrl+c to kill it.

```python
x = 15
while True:
  x = x + 2
  print(x)
```

Predict what this code will do and then walk through its execution by clicking the Next button:

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=def%20bar%28lst%29%3A%0A%20%20%20%20print%28lst%29%0A%20%20%20%20lst%5B0%5D%20%2B%3D%2010%0A%20%20%20%20print%28lst%29%0A%0AmyList%20%3D%20%5B1,%202,%203%5D%0A%0Abar%28myList%29%0A%0Aprint%28myList%29%0A%0A&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=nevernest&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

## Exercise 2
Write the following as an indefinite loop:

```python
for i in range(10, 2, -1):
  x = 2*i + 3
  print(x)
```

## Exercise 3

The [previous lab](functions1) had you make several functions to reverse the letters in words which just printed their information to the output.
Often, it is useful to instead *return* values so that they can be used by other parts of a program.

Here is my version of the code from the previous lab:
```python
def reverse_word(word):
  '''Reverses a word and prints it out
  Input: word (string)
  Output: None'''
  rev_word = ""
  for i in range(len(word) - 1, -1, -1):
    rev_word = rev_word + word[i]
  print(rev_word, end=" ")

def reverse_all_words(phrase):
  '''Reverses each word in a phrase and prints it out
  Input: phrase (string)
  Output: None'''
  words = phrase.split()
  for i in range(len(words)):
    reverse_word(words[i])

def main():
  phrase = input("Input a phrase: ")
  reverse_all_words(phrase)
  print()

main()
```

Update my functions so that the `reverse_word()` and `reverse_all_words()` functions return their results instead of printing them, and then `main()` takes care of the printing.

## Exercise 4
A "palindrome" is a word that can be written the same way both forwards and backwards. 
For instance, "racecar" and "anna" are palindromes, while "sedan" and "david" are not.

Create a new file called `palindrome.py`. 
This program will take a word as input from the user and then tell the user whether or not it is a palindrome. 
You should include at least two function definitions: one for `main()` and one for `is_palindrome(word)` which takes a string as a parameter and returns a boolean value indicating whether or not the given word is a palindrome.

Your program should also make use of the `reverse_word` function that you created in `reverse.py`. 
To allow for this function to be used in another program, you should not copy and paste the function into the new file, but instead `import` the function from `reverse.py` into `palindrome.py`. 
This will allow you to use that function in `palindrome.py`, even though it was defined in another program! 
This is a very common practice in Python programs, which often span multiple files. 
To import and use the `reverse_word` function from `reverse.py` in `palindrome.py`, use code like this (import statements should always go at the top of a file):
```python
from reverse import reverse_word

name = "Anya"
reversedName = reverse_word(name)
```

Note that this will only work if `palindrome.py` and `reverse.py` are in the same folder on your computer. 
But you may now experience a strange issue: whenever you run `palindrome.py`, it bizarrely runs the `main()` function of your `reverse.py`. 
The reason is as follows. 
Whenever Python imports code from one file, what it’s actually doing is running every line in the file that you’re importing, because this is necessary to execute the definitions for all the functions that you want to import! 
But the problem is that it will eventually get to the line in `reverse.py` with your `main()` call, which it will execute, because it’s executing every line in `reverse.py` as part of the import process. 
To fix this issue, replace the line `main()` in your `reverse.py` file with the following two lines:

```python
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
In what situation will this code not work correctly? Fix it once you identify the problem.

## Exercise 6
The game code still isn't very robust. 
Improve it by:
* prompting the user repeatedly if they enter something that isn't an int between 1 and 100
* allowing the user to specify the range of possible values to increase the difficulty
* whatever other expansions or improvements you can think of!

## Extra
If you have extra time, try to write another version of the `is_palindrome` function from above that does not make use of `reverse_word`, and does not make use of an additional string variable at all — rather, it should determine its answer purely by looping through the given word to the function.

Functions can also be useful for making nested loops easier to read by putting the inner loops into a function. Revisit the [Nested Loops Lab](lab-nested) and try making small functions for the inner loops to make the snippets easier to understand.
