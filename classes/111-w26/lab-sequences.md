---
layout: page
title: Sequences Lab 
permalink: /classes/111-f24/sequences
---

## Setup
I recommend making a folder for today's lab in [COURSES as you usually do](getting-started).

Make sure to download [graphics.py](graphics.py) and place it in your lab folder for today.

## Exercise 1: Basic list operations
For this exercise, we’ll use the following statements:

```python
numbers = [3, 1, 4, 1, 5]
words = ["apple", "banana", "cat", "dog", "elephant"]
```

Predict the result of evaluating each of the following list expressions (and write down on your worksheet).

```python
#a)
numbers[-1]

#b) 
words[1:4]

#c) 
words[1] + words[2]

#d) 
len(numbers)

#e) 
numbers + words

#f) 
2 * numbers + words

#g) 
for word in words:
    print(len(word), word)

#h) 
"apple" in words

#i) 
"nana" in words
```

## Exercise 2: Going backwards
Write a function to print a sequence of words in reverse order. You cannot use slicing or the existing `reverse` list method.

(Hint: you should use `split` to turn the provided string into a `list`, and use the accumulator pattern to build the resulting list in reversed order. Think carefully about how you can change the typical body of an accumulator loop to put the new value at the *beginning* of the accumulator variable instead of the *end* of the variable.)

Here is an example interaction:

```
Please enter a sequence of words, separated by spaces: apple banana cat dog elephant fish

The sequence reversed:
fish elephant dog cat banana apple
```

## Exercise 3: `for`-loop patterns
Write a `for` loop using the variables `numbers` and `words` to generate each output. Think about whether you need the element and/or its index for each loop. (This is a good place to put each one into a function so you can test them separately!)

```python
numbers = [3, 1, 4, 1, 5]
words = ["apple", "banana", "cat", "dog", "elephant"]

#a) 
apple 5
banana 6
cat 3
dog 3
elephant 8

#b) 
0 apple
1 banana
2 cat
3 dog
4 elephant

#c) 
3
 1
  4
   1
    5
```

## Exercise 4: Drawing many shapes
Write a function that takes in lists of colors and radii and a `Point`, and draws concentric circles centered at that `Point`. The function signature and `main` are given for you.

```python
from graphics import *

def drawCircles(colorList, radiusList, point, win):
    """
    Draws circles all centered at the same point.

    colorList: color of each circle (a list of strings)
    radiusList: radius of each circle (a list of integers)
    point: the center of each circle (a Point)
    win: the window in which to draw (a GraphWin)
    """
    # TODO

def main():
    win = GraphWin("Circles!")

    colors = ["purple", "blue", "green", "yellow", "orange", "red"]
    radii = [100, 80, 60, 40, 50, 10]
    center = Point(100, 100)
    drawCircles(colors, radii, center, win)

    win.getMouse()

main()
```

## Submission
Submit the files containing your solutions to exercises 2-4 to Moodle for an extra engagement credit.

## Extra 1
Let’s switch up your previous `reverse` program so that it receives a phrase from the user, reverses the letters of *each word* (but not the order of the words anymore), and then prints the result back out to the screen.
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

## Extra 2
We'll get to all the many ways that you can change the contents of lists in a couple of weeks, but here are some operations to explore. Predict the values of `numbers` and `words` after executing each of the following statements. Assume that `numbers` and `words` are reset to their original values before each statement.

```python
numbers = [3, 1, 4, 1, 5]
words = ["apple", "banana", "cat", "dog", "elephant"]

#a) 
numbers.remove(1)

#b) 
numbers.sort()

#c) 
words.sort(reverse=True)

#d) 
numbers.append([words.index("cat")])

#g) 
words.pop(numbers.pop(3))

#h) 
words.insert(numbers[0], "fish")
```
