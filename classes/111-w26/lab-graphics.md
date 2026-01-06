---
layout: page
title: Graphics Intro Lab
permalink: /classes/111-w26/graphics-intro
---

## Setup
I recommend making a folder for today's lab in [COURSES as you usually do](getting-started).

Make sure to download [graphics.py](graphics.py) and place it in your lab folder for today.

(Fun aside: [this file](https://www.cs.carleton.edu/faculty/tamert/courses/cs111-f25/resources/tkinterColors.py) will let you visualize all of the named colors you can use with Tkinter (which `graphics` is built on).)

## Exercise 1: Creating and using graphical objects
For each of the following code snippets, think about what attributes the graphics object has, and then run the code and see what gets displayed.

```python
from graphics import *

# (a)

win = GraphWin("Exercise 1a: Point")

p = Point(130, 130)
p.draw(win)

win.getMouse()
win.close()

# (b)

win = GraphWin("Exercise 1b: Circle")

circ = Circle(Point(30,40), 25)
circ.setFill("blue")
circ.setOutline("red")
circ.draw(win)

win.getMouse()
win.close()

# (c)

win = GraphWin("Exercise 1c: Rectangle")

rect = Rectangle(Point(20,20), Point(40,40))
rect.setFill("DarkOliveGreen4")
rect.setWidth(3)
rect.draw(win)

win.getMouse()
win.close()

# (d)

win = GraphWin("Exercise 1d: Line")

line = Line(Point(100,100), Point(100,150))
line.setOutline("dark violet")
line.setArrow("first")
line.draw(win)

win.getMouse()
win.close()

# (e)

win = GraphWin("Exercise 1e: Oval")

oval = Oval(Point(50, 50), Point(60, 100))
oval.draw(win)

win.getMouse()
win.close()

# (f)

win = GraphWin("Exercise 1f: Polygon")

shape = Polygon(Point(50,50), Point(100,100),
                Point(50,100), Point(100,50))
shape.setFill("orange")
shape.draw(win)

win.getMouse()
win.close()

# (g)

win = GraphWin("Exercise 1g: Text")

text = Text(Point(100,100), "Hello, world!")
text.setFace("courier")
text.setSize(16)
text.setStyle("italic")
text.draw(win)

win.getMouse()
win.close()
```

## Exercise 2: Understanding the coordinate system
Copy over the following program into VS Code. Use it to explore the coordinate system and answer these questions:

* In what direction does x increase?
* What about y?
* What is the coordinate of the bottom-left corner of the screen?
* What is the coordinate of the top-right corner of the screen?

```python
from graphics import *

def main():
    # Set up the window
    winWidth, winHeight = 800, 600
    win = GraphWin("Coordinate System Exploration", winWidth, winHeight)
    #win.setCoords(0, -2, 10, 8) # run first, then uncomment this line
    win.setBackground("white")

    # Print a welcome message to the user
    messageLocation = Point(winWidth / 2, winHeight - winHeight * 0.1)
    #messageLocation = Point(5, -1) # run first, then uncomment this line
    message = Text(messageLocation,
                   "Click 10 times to print click coordinates.")
    message.draw(win)

    # Take in 10 clicks, printing their location
    for i in range(10):
        clickPoint = win.getMouse()
        x = clickPoint.getX()
        y = clickPoint.getY()
        message.setText("You clicked at x=" + str(x) + ", y=" + str(y))

    # Wait for another click to exit
    message.setText("Click anywhere to quit.")
    win.getMouse()
    win.close()

main()
```

Afterwards, uncomment the following lines:
```python
    #win.setCoords(0, -2, 10, 8) # run first, then uncomment this line
```
and
```python
    #messageLocation = Point(5, -1) # run first, then uncomment this line
```
How does using `win.setCoords()` change the coordinate system? What are the coordinates of the different corners of the screen, and how does that relate to the parameters to the `win.setCoords` function call?

## Exercise 3: Interactive graphics
Imagine you want to draw a triangle based on where a user clicks. The following code will get you most of the way there. How would you fill in the two `# TODO` to do this?

```python
from graphics import *

def main():
    # Set up the window
    winWidth, winHeight = 800, 600
    win = GraphWin("Draw a triangle", winWidth, winHeight)
    win.setCoords(0, 0, 10, 5)
    win.setBackground("white")

    # Print a welcome message to the user
    message = Text(Point(5, 0.5),
                   "Click on three points to make a triangle")
    message.draw(win)

    # Get and draw three vertices of a triangle
    point1 = win.getMouse()
    # TODO

    # Somehow draw the triangle
    triangle = # TODO
    triangle.setFill("peachpuff")
    triangle.setOutline("cyan")
    triangle.draw(win)

    # Wait for another click to exit
    message.setText("Click anywhere to quit.")
    win.getMouse()
    win.close()

main()
```

## Submission
If you'd like an extra engagement credit, submit the following to Moodle:
* Answers to the questions in Exercise 2
* A finished solution to Exercise 3

## Extra
Try drawing a flower!
Using at least 3 different classes from the graphics library (and probably multiple *objects* of some classes), make a flower!

Make your flower colorful using the `.setFill()` and `.setOutline()` methods on your objects. Remember that you can use `move` to position your objects relative to each other (for example petals around the center of a flower).
You can also change the background color of your window using the [GraphWin class'](https://mcsp.wartburg.edu/zelle/python/graphics/graphics/node3.html) .`setBackground()` method.

Read about how to generate any color you want [here](https://mcsp.wartburg.edu/zelle/python/graphics/graphics/node14.html).
