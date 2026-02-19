---
layout: page
title: Recursion Lab
permalink: /classes/111-w26/recursion-lab
---

## Setup
I recommend making a folder for today's lab in [COURSES as you usually do](getting-started).

In it, make a file `recursion_lab.py` and place the following functions into it. Remember that you'll need to call each function to test it!

<!--> Note: should really put in example tests to get them to run it probably<-->

## Exercise 1
Write a recursive function called `get_min(lst)` that returns the minimum element from a given list of integers.

## Exercise 2
Write a recursive function called `fib(n)` that returns the `n`th Fibonacci number. For the record, the first and second Fibonacci numbers are defined to be `0` and `1`, respectively. 
After that, the `n`th Fibonacci number is defined as the sum of the two Fibonacci numbers that precede it. For example, the sequence begins `0 1 1 2 3 5 8 13`...

## Exercise 3
Write a recursive function called `count_val(val, lst)` that returns a count representing the number of times that the value `val` is present in the list `lst`.

## Exercise 4
Write a **recursive** function called `count_down(n)` that takes a positive integer `n` and prints out each value from `n` to 0, decreasing by 1 at each step, printing each value on its own line. (Note: this function asks you to print values, not return them. What, if anything, needs to be returned in that case?)

## Exercise 5
Write a recursive function called `count_up(n)` that takes a positive integer `n` and prints out each value from 0 to `n`, increasing by 1 at each step, printing each value on its own line.

## Exercise 6
Write a modified version of the recursive Fibonacci function from Problem 2 above, and call it `count_fib(n)`. This function should return a list with two items (or a tuple if you prefer) containing a) the `n`th Fibonacci number and b) the number of times `count_fib()` is called. The easiest approach will be to modify the `fib(n)` from above.

## Exercise 7
Write a recursive function called `mod(a, b)` that computes the remainder we get when we divide `a` by `b`. This is precisely what the `%` operator does in Python, but your function should instead use recursion to compute this remainder.

## Exercise 8
Write a **recursive** function called `power(b, n)` that returns `b` raised to the `n`th power. You can assume that they are both non-negative integers. (You should not use Python's `**` functionality for this one.)

## Submission
Submit your complete `recursion_lab.py` to Moodle for an extra engagement credit.

## Extra 1: Fractals
(This used to be a homework assignment, and it's pretty cool, so give it a try!)
### Overview
A *fractal* is an image that is composed of smaller copies of itself. When drawing fractals, you typically specify a level, which tells you how “deep” to go in drawing smaller versions of the image. 
In this assignment, you’ll write a recursive function to generate the *von Koch snowflake*:

![A series of five progressively more complex snowflakes](/classes/111-w22/vonKochSnowflakes.png)

One way to think about a von Koch snowflake is as follows: 

Start with a triangle, for every line in the triangle (like the one on the left), replace it by a four-line piece (like the one on the right):

![A horizontal line](/classes/111-w22/vonKoch0.png) ![A horizontal line with an upward pointing trianguular section in the center](/classes/111-w22/vonKoch1.png)

Then you repeat the exact same process on the resulting lines, and do it again, and again. The level of a fractal is the number of times that you repeat this “expansion” process.

### Your Task

Copy the [`graphics.py`](/classes/111-w22/graphics.py) module into your folder.
In a file called `fractals.py`, first copy this starter code:
```python
from graphics import *
def vonKochSegment(level,start,heading,length,window):
    if level == 0:
        end = Point(start.getX() + length * math.cos(math.radians(heading)), 
            start.getY() - length * math.sin(math.radians(heading)))
        line = Line(start, end)
        line.draw(window)
        return end
    else:
        # your code here

def vonKoch(length,level):
    window = GraphWin("von Koch Snowflake", length * 1.5, length * 1.5)
    p1 = Point(length / 4, length)
    p2 = vonKochSegment(level, p1, 0.0, length, window)
    # more of your code here
```

#### vonKochSegment
The function `vonKochSegment takes five arguments: a level (the
number of times that you do expansion), a starting point, a heading (in degrees counterclockwise from due east on the screen), a length of the line, and the graphics window in which to draw the resulting
image. 
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
For example, the call `vonKoch(200, 3)` should result in an image like this:

![A partial von Koch snowflake](/classes/111-w22/vonKochPartial3.png)

#### vonKoch
Finally, you should expand the `vonKoch` function so that it draws three von Koch segments of level `level` arranged in an equilateral triangle. The first segment should head in direction 0, the second should head in direction 120 from the end of the first side, and the third should head in direction 240 from the end of the second side.


## Extra 2
Write a recursive that will generate all the anagrams (rearrangements of the letters) of a string. For example, all the anagrams of the string `abca` are `['abca', 'abac', 'acba', 'acab', 'aabc', 'aacb', 'baca', 'baac', 'bcaa', 'bcaa', 'baca', 'baac', 'caba', 'caab', 'cbaa', 'cbaa', 'caba', 'caab', 'abca', 'abac', 'acba', 'acab', 'aabc', 'aacb']`.

This is a tricky problem! I recommend you take the following approach:

1. What is your base case? What string has the simplest list of anagrams?
2. If the string is longer than your base case:
    a. For each character in that string:
        i. Create a copy of the string with the character removed (you can do this with `string.replace(letter, "", 1)` to replace `letter` with the empty string one time)
        ii. Generate all the anagrams of the remaining letters with a recursive call
        iii. For each of those generated anagrams, attach the removed character to the front of the anagram
