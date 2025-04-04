---
layout: page
title: HW7
permalink: /classes/111-f24/hw7
---

## Logistics

This is a paired assignment, so you should complete it with your assigned partner, if you have one, via **paired programming**. 
The whole time that you are working, you should both be present and actively working on the problem at hand. 
(Two brains, one keyboard.) 
Switch off the typing duties so that you each type for roughly half of the time. 

You are able to get help from many sources as detailed in the [collaboration](collaboration) policy.

This assignment is due on Wednesday Nov. 6th at 10pm. 
As with all assignments, you will have the opportunity to [revise this assignment individually](revision-process) based on the feedback that you get.

## Goals
Get practice with recursion.

## Setup

Again, I recommend you complete this assignment in Olin 310, though it isn't required to do so.

[Mount the COURSES drive](getting-started) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HW7`
* Open your `HW7` folder in VSCode

## Assessment
You will be assessed on the following rubric.
Be sure to remove the starter comments that are no longer relevant, add additional comments, and update or add headers as necessary.

To **demonstrate proficiency**:
* Correct functionality
* Header with three lines that start with `#` for each file
* Contain docstrings for each function and method (checked automatically)
* Other basic style that can be checked automatically
* `rec_max_finder` is recursive as specified
* von Koch snowflakes of levels 1, 2, 3, and 4 created and saved to correctly named files when `fractals.py` is run

To **demonstrate mastery**, your program needs to demonstrate proficiency as well as having:
* *Descriptive* headers
* *Descriptive* docstrings for each function and method
* Useful comments (and removal of non-useful starter comments)
* Descriptive variable and function/method names that follow `snake_case`
* Good line grouping and spacing
* Use variables to store intermediate results and prevent any unnecessary duplication of code
* von Koch snowflakes follow specification below

## rec_max_finder
In this homework, you’ll get a chance to play with a visual example of recursion, but, first, one warm-up exercise. 
In a file called `max.py`, write a *recursive* function `rec_max_finder` that takes a list of numbers as an argument and returns the **value of the maximum element** as follows:
* the maximum element in a list of length one is that one element.
* in a list of two or more numbers, the maximum element of the list is either the maximum element of the list containing all but the first element of the list (i.e., the maximum of `a_list[1:]`) or the first element of the list, depending on which is bigger. Note that you are **not allowed** to use the `max` or `min` functions.

For example:
```python
print(rec_max_finder([3, 4, 1, 10, 5]))
#Should print 10
print(rec_max_finder([3, 4, 1, 5]))
#Should print 5
```

Remember to save intermediate results to a variable instead of calling your function multiple times since that is a lot of extra computing work!

## Fractals

### Overview
A *fractal* is an image that is composed of smaller copies of itself. When drawing fractals, you typically specify a level, which tells you how “deep” to go in drawing smaller versions of the image. 
In this assignment, you’ll write a recursive function to generate the *von Koch snowflake*:

![A series of five progressively more complex snowflakes](/classes/111-w22/vonKochSnowflakes.png)

One way to think about a von Koch snowflake is as follows: 

Start with a triangle, for every line in the triangle (like the one on the left), replace it by a four-line piece (like the one on the right):

![A horizontal line](/classes/111-w22/vonKoch0.png) ![A horizontal line with an upward pointing trianguular section in the center](/classes/111-w22/vonKoch1.png)

Then you repeat the exact same process on the resulting lines, and do it again, and again. The level of a fractal is the number of times that you repeat this “expansion” process.

### Your Task

Copy the [`graphics.py`](/classes/111-w22/graphics.py) and [`canvasvg.py`](/classes/111-f24/canvasvg.py) modules into your folder.
In a file called `fractals.py`, first copy this starter code:
```python
#TODO

from graphics import *
import canvasvg
import math

def von_koch_segment(level,start,heading,length,window):
    '''TODO'''
    if level == 0:
        end = Point(start.getX() + length * math.cos(math.radians(heading)), 
            start.getY() - length * math.sin(math.radians(heading)))
        line = Line(start, end)
        line.draw(window)
        return end
    else:
        # your code here

def von_koch(length,level):
    '''TODO'''
    window = GraphWin("von Koch Snowflake", length * 1.5, length * 1.5)
    p1 = Point(length / 4, length)
    p2 = von_koch_segment(level, p1, 0.0, length, window)
    # more of your code here

    #At the very end, save the resulting image using canvasvg
    canvasvg.saveall("Snowflake"+str(level)+".svg", window)
```

#### von_koch_segment
The function `von_koch_segment` takes five arguments: a level (the
number of times that you do expansion), a starting point, a heading (in degrees counterclockwise from due east on the screen), a length of the line, and the graphics window in which to draw the resulting image. 
The function should return the ending point of the segment. 

I've provided the base case when the level is 0.
In this situation, the program calculates the ending point of the segment (this requires some trigonometry: go length units in the direction of the heading, which means length * cos(heading)
in the x direction and -length * sin(heading) in the y direction), and then draws a line from the starting point to the ending point in window.
This generates one third of a von Koch snowflake of level 0.

You need to fill in the recursive case when the level is at least 1.
For the recursive case, you should draw four `level - 1` segments by making **four recursive calls** with the appropriate arguments:
* segment #1 starts at the starting point and goes `length / 3` units in direction `heading`.
* segment #2 starts where segment #1 ends and goes `length / 3` units in direction `heading - 60`.
* segment #3 starts where segment #2 ends and goes `length / 3` units in direction `heading + 60`.
* segment #4 starts where segment #3 ends and goes `length / 3` units in direction `heading`.

Remember to test your code at this point to be sure that it draws a segment correctly.
For example, the call `von_koch(200, 3)` should result in an image like this:

![A partial von Koch snowflake](/classes/111-w22/vonKochPartial3.png)

#### von_koch
Finally, you should expand the `von_koch` function so that it draws three von Koch segments of level `level` arranged in an equilateral triangle. The first segment should head in direction 0, the second should head in direction 120 from the end of the first side, and the third should head in direction 240 from the end of the second side.

Include code that draws von Koch snowflakes of levels 1, 2, 3, and 4 when `fractals.py` is run and saves them to the files `Snowflake1.svg`, `Snowflake2.svg`, etc.
These names need to match exactly (and should if you didn't change the starter code) since the autograder will display the generated files with those names.

## Submission
You should submit through Gradescope as always. If you have a partner, remember only one of you should submit and you should add the other to the submission.