---
layout: page
title: Graphics Lab
permalink: /classes/111-w22/graphics
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.

## Exercise 0
This is a repeat of what we walked through together at the start of class for your reference. (You'll want to walk through these steps yourself to get setup.)

Download the file [graphics.py](graphics.py) and put it into the folder for today's lab. 
Then, make a new file `main.py` where you'll work today.

In `main.py`, you will first want to import everything from the graphics library. You can do this with an `import graphics` statement, but I suggest the following instead:

```
from graphics import *
```

This will import all of the class definitions in `graphics.py`, and will do so in a way that won't make you type `graphics.` before every use of these classes.

Once you have imported the library, you will want to create yourself a window upon which to draw shapes. This can be done with the following code:

```
win = GraphWin("My fancy window", 400, 400)
```

The call above creates an *object* of the `GraphWin` *class* and stores it in the `win` variable. 
We are using the **constructor** of the `GraphWin` class, which is a special method that you will read/learn more about for next class. 
This particular constructor takes 3 parameters: the name of the window, its width, and its height. ([Here is the documentation for this class which says more.](https://mcsp.wartburg.edu/zelle/python/graphics/graphics/node3.html)
)

Run `main.py` to see what happens. 
You'll notice that your window seems to just close right away, because the program runs and then closes the window when it's done.
An easy way to keep that from happening, so you can actually see what you're doing, is to add a line at the end of your program that waits for input from the user:

```
input("When done, press Enter")
```

Now run again and make sure that you see a blank window that claims that it's fancy.

It's time to make some shapes!
The different shapes you can make are listed under "Graphics Objects" in [Zelle's documentation for the library](https://mcsp.wartburg.edu/zelle/python/graphics/graphics/). 
Each specific shape has its own constructor (described in its own page). 
So, for instance, to create a [`Point`](https://mcsp.wartburg.edu/zelle/python/graphics/graphics/node5.html), I can call:

```
my_point = Point(100,100)
```

This will create a point at the coordinate 100, 100. 
You might notice though that you don't actually *see* the point object.
To see it, you need to tell Python which window to draw it in:

```
my_point.draw(win)
```

The `draw` method, which is shared across [all Graphics Objects](https://mcsp.wartburg.edu/zelle/python/graphics/graphics/node4.html), takes a `GraphWin` object as its single parameter, and draws the object on the given window. 
The above is an example of dot notation again, which is used to specify which object it is of which we want to execute a method. (I.e., the above code draws `my_point`, not some other object.)
Make sure that you can now see a small dot on your window.

Points aren't very interesting, so let's draw a circle.
To create a `Circle`, I need to pass it both a `Point` (which will represent the center of the `Circle`) and a radius, like this:

```
my_circle = Circle(Point(50,50), 25)
my_circle.draw(win)
```

This will create and draw a `Circle` with a radius of 25 and centered at 50,50. 
Notice that we actually created a `Point` *within* our call to `Circle`'s constructor. 
We can't just pass in coordinates to the `Circle` constructor.


## Exercise 1
After you've gotten set up with your window displaying at least, click through [Zelle's documentation](https://mcsp.wartburg.edu/zelle/python/graphics/graphics/graphref.html) to see what other shapes you can draw, and try them out! 
Note that each shape has its own specific methods, listed in their respective pages, but they also all can use the methods that apply to all Graphics Objects (like `draw`, `setFill`, `move`, etc.).

Be sure to try out at least a few more circles and a rectangle.
Try filling them with colors as well!

## Exercise 2
It's time to revisit your Paper Flowers!
Using at least 3 different classes from the graphics library (and probably multiple *objects* of some classes), make a flower!

Make your flower colorful using the `.setFill()` and `.setOutline()` methods on your objects. 
You can also change the background color of your window using the [GraphWin class'](https://mcsp.wartburg.edu/zelle/python/graphics/graphics/node3.html) .`setBackground()` method.


## Extra
Finally, note that you can also have objects *move* using the `.move()` method. If you'd like, try turning your flower into a moving animation! 
For this, you'll likely need some sort of loop to control which objects move and when. 
You might also want to `import time` and use `time.sleep` ([documentation here](https://docs.python.org/3/library/time.html#time.sleep)) to slow down the execution of your program so that your animations don't get to frenetic.

You may have found yourself with many lines of code to create your flower. 
Use functions to organize that code into meaningful sets of things.

(As an extra extension, you can get user *mouse* input through `GraphWin`'s `.getMouse()` method--incorporate this if you would like, as well!)