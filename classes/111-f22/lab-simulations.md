---
layout: page
title: Making Simulations Lab
permalink: /classes/111-f22/lab-simulations
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on the final project so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do as well as pull up [Zelle's documentation for the library](https://mcsp.wartburg.edu/zelle/python/graphics/graphics/).

## Setup
Download the file [graphics.py](/classes/111-w22/graphics.py) and put it into the folder for today's lab. 
Then, make a new file `main.py` where you'll work today.

In `main.py`, you will first want to import everything from the graphics library. You can do this with an `import graphics` statement, but I suggest the following instead:

```
from graphics import *
```

This will import all of the class definitions in `graphics.py`, and will do so in a way that won't make you type `graphics.` before every use of these classes.

We'll also be using the `random` module today, so add an import for that:
```
import random
```

## Exercise 0

1. As always, you should make a `main` function and make your `GraphWin`:

    ```python
    def main():
        win = GraphWin("My fancy window", 400, 400)
    ```

2. For this lab, you'll be making a simple simulation/game involving circles and squares, but since you'll have some additional functionality for them, you'll need to make your own class. Create a `MovingCircle` class that takes three parameters: `centerX, centerY, color`. Your constructor should create the `Point` object, the `Circle` object, and `setFill` the color (refer to the [Graphics Lab](graphics-intro) if you don't remember how):

    ```python
    class MovingCircle:
        def __init__(self, centerX, centerY, color):
            #create your Point object
            #create the Circle object
            #setFill the color
    ```

## Exercise 1
Often in a simulation or game, you'll want your graphics to move. 

1. In `main`, create and draw a `MovingCircle` object. You can make a `draw` method within your class or `draw` the `MovingCircle`'s `Circle` directly.

2. All graphics objects support the `.move(dx, dy)` method, which takes two parameters, the amount you want it to move in the x direction and the amount to move in the y direction. Make a `move` method for your `MovingCircle` that moves the `Circle` a random amount:

    ```python
    def move(self):
        ranX = random.randint(-10,10)
        ranY = random.randint(-10,10)
        # call move on Circle object with ranX and ranY

3. In `main`, write a for-loop that calls the `move` method of your `MovingCircle` 5 times and make sure that it's working.

## Exercise 2
Generally, you want simulations and games to continue for a while.

1. The `GraphWin` class has an `isClosed()` method that lets you keep running your program until the user closes the window (by pressing the X in the upper left). Change your for-loop to a `while` loop that uses this method:

    ```python
    while not win.isClosed():
        #your code
    ```

2. A few more circles would make this more interesting. Before your while loop, create a list of `MovingCircle`s at different locations, draw them all, and then add a for loop within your while loop so that they all move randomly each time. Make sure that your code is working at this point.

3. If the circles are moving too fast for you, you can use the `time` module to have them move more slowly:

    ```python
    import time

    time.sleep(0.1) #sleeps 0.1 seconds before next line
    ```

## Exercise 3

You'll probably also want to respond to user input in your game or simulation. There are a couple of ways to do that. Let's start by letting the user draw some circles:

1. The graphics library lets you get the location that a user clicks with the `getMouse()` method of the `GraphWin` class. It returns the information as a `Point` object. Use this method to draw a circle where ever the user clicks in the window!

2. The graphics library also lets you detect what key on the keyboard a user has pressed with the `getKey()` method of `GraphWin`. It returns the key as a string of the character key that was pressed. For example, if the user hit the 'Y' key, the method would return the string `"y"`. Experiment with this method by first printing what you get when you do:

    ```
    input_key = win.getKey()
    print(input_key)
    ```

    And then use it to allow the user to pick from a couple of different colors for their circle (for example, 'y' for yellow and 'p' for purple).

3. You probably don't want to force the user to make a new circle each loop. You can instead use the `checkMouse()` method, which doesn't pause the program, but just checks if the user has clicked since the last time (there is also a `checkKey()` equivalent). `checkMouse()` returns `None` if there is no new click, so you'll need to use a conditional to see if there is actually input to use:

    ```python
    clickPoint = win.checkMouse()
    if clickPoint == None:
        #don't do anything
    else:
        #check on color and draw a new circle
    ```

    Switch to the `checkMouse()` method so that your circles wiggle around until the user clicks, and then a new circle is drawn and added to the list of moving circles.

## Exercise 4
Perhaps you want the user to be able to get rid of some of the circles if they click on one. This requires detecting a collision, which is a bit of a tricky process.

1. In your `MovingCircle` class, create a new method `collision` that takes a Point object.

2. All graphics objects have a "bounding box" formed by two or more Points. For `Circle`s, you can get access to the two points that form their bounding boxes with `getP1()` and `getP2()`. Together these two points form the rectangle that the `Circle` would fit in. It's not a perfect way to detect a collision, but it's good enough for our purposes. First, get the x and y coordinates of the two points of your circle, which I called `self.body`:

    ```python
    def collision(self, other_point):
        x1 = self.body.getP1().getX() #change self.body to what your Circle is
        x2 = self.body.getP2().getX()
        y1 = self.body.getP1().getY()
        y2 = self.body.getP2().getY()
    ```

3. We'll say there is a collision when the point's x is between `x1` and `x2` AND the point's y is between `y1` and `y2`:

    ```python
    if x1 < other_point.getX() < x2:
        #within x coordinates
        if y1 < other_point.getY() < y2:
            #within y coordinates
            return True
    ```

4. Now update your `main` code so that it first checks if the point where the user clicked collided with any of the existing circles. If it does, undraw that circle and remove it from your list of circles. If there wasn't a collision, draw a new circle like you were already doing. Make sure you code works at this point. (You might need to slow down your circles or make them bigger to be able to test this easily!)

## Exercise 5
You are already pretty far along in making something game/simulation like, but a frequent other way to control a game is with the arrow keys. You might have already figured out how to do that, but we'll walk it through here and combine the various things from previously.

1. Let's make a new class that is a `PredatorSquare` which will be controlled by the user to eat the `MovingCircle`s. You'll want your class constructor to take in a couple of points and create a `Rectangle` with them. Feel free to make it a specific color as well.

2. To control your predatory square, we'll use the `checkKey()` method again. If the user hits the arrow keys, it gets saved as "Up", "Down", "Left", or "Right". Create a conditional that moves your square based on if any of those arrow keys were pressed:

    ```python
    direction = win.checkKey()
    if direction == "Up":
        #move square up
    elif direction == "Down":
        #move square down
    elif direction == "Left":
        #move square left
    elif direction == "Right":
        #move square right
    ```

    Notice that there isn't an `else` because the `direction` could be a lot of other things, and we don't want the square to default to moving right!

    Make sure that you can now control your predatory square's movement.

3. Finally, you'll want to check if your square runs into any of the circles and eats them. Fortunately, you already have a method for your circles to check for collisions. Make a loop that loops over each of the circles in your list and check if they have collided with the square's `P1` or `P2`. (This again is not a perfect way of detecting collisions, but fine for now.) If there is a collision, undraw the circle and remove it from your list.

## Exercise 6
With that, you know about nearly everything that you need from the graphics library for making a simulation or game! Here are a couple of other things to check out:

1. Use the `Text` object to create some text by [checking the documentation](https://mcsp.wartburg.edu/zelle/python/graphics/graphics/node11.html).

2. Use the `Entry` object to [get text from the user](https://mcsp.wartburg.edu/zelle/python/graphics/graphics/node12.html).

3. [Add an image to your window](https://mcsp.wartburg.edu/zelle/python/graphics/graphics/node13.html) with the `Image` object.

## Exercise 7
Start planning out what classes you'll need for your final project and get implementing!