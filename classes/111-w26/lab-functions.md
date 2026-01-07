---
layout: page
title: Functions Lab 
permalink: /classes/111-w26/functions-lab
---

## Setup
I recommend making a folder for today's lab in [COURSES as you usually do](getting-started).

Make sure to download [graphics.py](graphics.py) and place it in your lab folder for today.


## Exercise 1: Predictions
For each of the following snippets of code:

1. Predict what will happen when the snippet runs
2. Walk through their execution by clicking the Next button to check your prediction
3. If relevant, figure out why your prediction was wrong
4. If the existing code has errors, predict what would fix it

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=x%20%3D%203%0A%0Adef%20f%28x%29%3A%0A%20%20%20%20print%28x%2B3%29%0A%0Af%285%29%0Aprint%28x%29%0A&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=nevernest&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=def%20g%28y%29%3A%0A%20%20%20%20a%20%3D%204%0A%20%20%20%20print%28a%20%2B%20y%29%0A%0Ag%281%29%0Aprint%28a%29%0A&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=1&heapPrimitives=nevernest&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=def%20peacock%28%29%3A%0A%20%20%20%20print%28msg%29%0A%20%20%20%20print%28'Caw!'%29%0A%0Adef%20main%28%29%3A%0A%20%20%20%20msg%20%3D%20'Quiet...'%0A%20%20%20%20peacock%28%29%0A%20%20%20%20msg%20%3D%20'Wow!'%0A%20%20%20%20peacock%28%29%0A%0Amain%28%29%0A&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=1&heapPrimitives=nevernest&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

## Exercise 2: Refactoring code to use functions
The following code is... a bit repetitive. Find repeated chunks and rewrite them to use functions instead. The output when you run the program should still be the same, and it may not even be shorter, but it should be simpler to read. Don’t forget to add a `main` function, too!

```python
x = 10
y = 12
print(x + y)
x = 15
y = 30
print(x + y)
x = 83
y = 11
print(x + y)
a = 4
print("The remainder when dividing", a, "by 2 is", a % 2)
a = 7
print("The remainder when dividing", a, "by 2 is", a % 2)
a = 15
print("The remainder when dividing", a, "by 2 is", a % 2)
```

## Exercise 3: Drawing a shape
Adapt our simple code snippet to draw a triangle into a function that takes in a list of `Point` objects, a color name, and a `GraphWin` object and draws a triangle in the window. The function *signature* and `main` are given for you. Also, the docstring (the stuff in triple quotes) helps users of your function learn about what it does and how to use it.

```python
from graphics import *

def drawTriangle(pointList, colorName, win):
    """
    Draws a triangle in the given window.

    @param pointList: the Point objects that give triangle bounds (a list)
    @param colorName: the color (a string)
    @param win: the window in which to draw (a GraphWin)
    """
    # TODO

def main():
    win = GraphWin("Triangle!")

    p1 = win.getMouse()
    p1.draw(win)
    p2 = win.getMouse()
    p2.draw(win)
    p3 = win.getMouse()
    p3.draw(win)

    points = [p1, p2, p3] # the square brackets mean it's a list
    drawTriangle(points, "thistle", win)

    win.getMouse()

main()
```


## Exercise 4: Creating and drawing shapes
Modify your function from above to not only draw the triangle, but also return it. The updated signature, docstring, and `main` are given to you.

```python
from graphics import *

def drawTriangle(pointList, colorName, win):
    """
    Draws a triangle in the given window.

    @param pointList: the Point objects that give triangle bounds (a list)
    @param colorName: the color (a string)
    @param win: the window in which to draw (a GraphWin)

    @ return: the created triangle object (a Polygon)
    """
    # TODO: copy your previous code, but now also return

def main():
    win = GraphWin("Triangle!", 300, 300)

    p1 = win.getMouse()
    p1.draw(win)
    p2 = win.getMouse()
    p2.draw(win)
    p3 = win.getMouse()
    p3.draw(win)

    points = [p1, p2, p3]
    triangle = drawTriangle(points, "blue", win) # different!

    # Make a copy of the triangle (not an alias!)
    triangle_copy = triangle # bug!  use .clone() instead
    triangle_copy.setFill("yellow")
    triangle_copy.move(100, 0) # move 100 to the right
    triangle_copy.draw(win)

    win.getMouse()

main()
```


## Exercise 5: Values and side effects
### Part a: Prediction
Consider the following two functions:

```python
def addTen(x):
    return x + 10

def printSum(a, b):
    print(a + b)
```

For each function, what is its **value**? What is its **side effect**?

### Part b: Try it out!
Now copy this code in a small Python program, with this main function:

```python
def main():
    print("Calling the two functions.")
    print("Any side effects resulting in print statements will happen now.")
    
    res1 = addTen(4)
    res2 = printSum(3, 7)

    print("Done calling the functions!")
    print() # add a blank line

    print("The value of addTen(4) is:", res1)
    print("The value of printSume(a, b) is:", res2)
```
How did your predictions compare to what you saw? Make sure to ask any questions you have!

## Submission
Submit your Python files for Exercise 2 and 4 to Moodle for an extra engagement credit.

## Extra: Writing functions that return values
### Part a: Summing values
Write two functions:

* `sumN(n)` returns the sum of the first n natural numbers, i.e., 1+2+3+...+n
* `sumNSquares(n)` returns the sum of the squares of the first n natural numbers

Here are their signatures:
```python
def sumN(n):
    """
    Computes the sum of the first n natural numbers.

    n: the number of ints to sum (an int)

    returns: the sum of numbers 1-n (an int)
    """
    # TODO

def sumNSquares(n):
    """
    Computes the sum of the squares of the first n natural numbers.

    n: the number of ints' squares to sum (an int)

    returns: the sum of the squares of 1-n (an int)
    """
    # TODO
```

Now, write a program that asks the user for a value of `n`, and uses these functions to print out the sum of the first `n` natural numbers and the sum of their squares.

```python
def main():
    n = # TODO

    # TODO
```

Question: does the code still run even if you name your variable something else in main?