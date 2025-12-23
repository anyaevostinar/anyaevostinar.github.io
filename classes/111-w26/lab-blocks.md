---
layout: page
title: Building Blocks Lab 
permalink: /classes/111-w26/building-blocks
---

Make a folder for today's lab in COURSES ([here are the instructions from the previous lab](getting-started)).

## Exercise 1
Predict the output from the following code fragments (and then check your predictions in VSCode):

### 1a: Regular loop sequences
Write your answers on the worksheet.
```python
#a)  
for i in [2, 4, 6, 8]:
    print(i * i)

#b)  
for i in range(5):
    print(i, i % 2)

#c)  
for i in range(3):
    print("Hello", end=" ")
```

### 1b: Bounds testing range
These are trickier to write out answers for, so just talk with your partner.
```python
#d)  
for i in range(0):
    print("Hola")

#e)  
for i in range(3, 4):
    print("你好")

#f)  
for i in range(3, 3):
    print("안녕하세요")

#g)  
for i in range(3, 2):
    print("🐉")
```

## Exercise 2

### 2a: generating a sequence of numbers
What inputs to range() would give each of the following sequences? Be sure to test any that you aren't confident about and write your answers on the worksheet.

```
a) 0, 1, 2, 3, 4, 5, 7, 8

b) 12, 13, 14

c) 0, 4, 8, 12

d) -3, -1, 1, 3, 5, 7

e) 5, 4, 3, 2, 1

f) 1, 3, 5, 7, 9, 11
```

### 2b: generating an alternating sequence
Using `range()` and a `for` loop, write a program to print out the values `1, -1, 1, -1, 1, ....` The program should prompt the user for `n` (how many numbers to print) and then print each number. *Hint: you don't need to directly use the values from `range`.*

Here is an example interaction:
```bash
What is n? 5
Results:
1
-1
1
-1
1
```

### 2c: putting it all together
Write a program to print out the following sequence: `1, -3, 5, -7, 9, -11, … `. The program should prompt the user for `n` (how many numbers to print) and then print each number.

Here is an example interaction:

```bash
What is n? 3
Results:
1
-3
5
```
*Hint:* Think carefully about how the values you get from range() relate to the values you need to print.

## Exercise 3: Summing by accumulation
Write a program to find the sum of the first `n` natural numbers, where the value of `n` is provided by the user. (*Hint:* you should use the accumulator pattern.)

Here is an example interaction:
```bash
What is n? 10
The sum of 1 to 10 is: 55
```

## Exercise 4: Approximating pi
Write a program that approximates the value of pi by summing the terms of this series: 4/1 - 4/3 + 4/5 - 4/7 + 4/9 - 4/11 + … . The program should prompt the user for `n` (the number of terms to sum) and then output the sum of the first `n` terms of this series. Have your program subtract the approximation from the value of `math.pi` to see how accurate it is.

Here is an example interaction:

```bash
What is n? 3
The sum of the first 3 terms of 4/1 - 4/3 + 4/5 + ... is: 3.466666666666667
```

And another:
```bash
What is n? 10000000
The sum of the first 10000000 terms of 4/1 - 4/3 + 4/5 + ... is: 3.1415925535897915
```

To compare to `math.pi`:

```python
import math
print(math.pi) # prints 3.141592653589793
```

## Submission
Submit your code for exercises 2b-4 to Moodle for an extra engagement credit.

## Extra
Next time, we'll be starting on making some graphical programs using this module: [`graphics.py`](graphics.py). 
Download that file and save it to your folder for today's lab, then make a file `simpleShapes.py` in that same folder and paste in this demo code:

```python
# File: simpleShapes.py
# Purpose: A simple graphics program.
# Author: Tanya Amert

from graphics import *

def main():
    # Create a point object
    point = Point(50, 100)

    # Print out some information about that point
    x = point.getX()
    y = point.getY()
    print("The point is at ({0},{1})".format(x, y))

    # Create a circle object
    radius = 20
    circle = Circle(point, radius)

    # Print out some information about that circle
    circleLoc = circle.getCenter()
    cx = circleLoc.getX()
    cy = circleLoc.getY()
    r = circle.getRadius()
    print(f"The circle is at ({cx},{cy}) and has radius {r}")
    #     ^ documentation for format strings: https://docs.python.org/3/tutorial/inputoutput.html#tut-f-strings

    # Give each a color
    point.setFill("white")
    circle.setFill("blue")

    # Create a window object
    win = GraphWin("My window for simple shapes")

    # Draw the circle and the point in the window
    circle.draw(win)
    point.draw(win)

    ## Questions:
    # - Does anything change if you swap the order of the draw statements?
    # - How can you change the size of the circle?
    # - How can you change the color of the circle?
    # - How big is a Point?
    # - Which direction has increasing x values?  What about increasing y values?

    # Wait for the user to click, then exit
    win.getMouse()
    win.close()

main()
```

Try running it and exploring the questions in the comments.