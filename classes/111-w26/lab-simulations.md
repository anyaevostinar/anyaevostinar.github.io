---
layout: page
title: Making Simulations Lab
permalink: /classes/111-w26/lab-simulations
---

This is a lab assignment, so it isn't required to complete.
However, the concepts and practice will help you on the homework, exams, and final project so I encourage you to make a serious effort on it during class and consider finishing it outside of class. If you do finish it and submit it to Moodle, you'll earn an extra engagement credit.

I recommend creating a folder in COURSES for this lab as you usually do.


## Setup
Download the file [graphics.py](/classes/111-w22/graphics.py) and put it into the folder for today's lab. 
Then, make a new file `main.py` where you'll work today.

In `main.py`, you will first want to import everything from the graphics library:
```python
from graphics import *
```

We'll also be using the `random` module today, so add an import for that:
```python
import random
```

## Exercise 0

1. As always, you should make a `main` function and make your `GraphWin`:

    ```python
    def main():
        win = GraphWin("My fancy window", 400, 400)
            win.setCoords(0, 0, 400, 400) # Make the coordinates more intuitive
    ```

2. For this lab, you'll be making a simple simulation/game involving circles and squares, but since you'll have some additional functionality for them, you'll need to make your own class. Create a `MovingCircle` class that takes three parameters: `centerX, centerY, color`. Your constructor should create the `Point` object, the `Circle` object, and `setFill` the color (refer to the [Graphics Lab](graphics-intro) if you don't remember how):

    ```python
    class MovingCircle:
        def __init__(self, centerX, centerY, color):
            #create your Point object
            center = #TODO
            #create the Circle object
            self.body = #TODO
            #setFill the color
            #TODO
    ```

## Exercise 1
Often in a simulation or game, you'll want your graphics to move. 

1. In `main`, create and draw a `MovingCircle` object. Make a `draw` method within your class that calls the `Circle`'s `draw` method.

2. All graphics objects support the `.move(dx, dy)` method, which takes two parameters, the amount you want it to move in the x direction and the amount to move in the y direction. Make a `move` method for your `MovingCircle` that moves the `Circle` a random amount:

    ```python
    def move(self):
        ranX = random.randint(-10,10)
        ranY = random.randint(-10,10)
        # call move on Circle object with ranX and ranY
    ```

3. In `main`, write a for-loop that calls the `move` method of your `MovingCircle` 5 times and make sure that it's working.

## Exercise 2
Generally, you want simulations and games to continue for a while.

1. The `GraphWin` class has an `isClosed()` method that lets you keep running your program until the user closes the window (by pressing the X in the upper left). Change your for-loop to a `while` loop that uses this method:

    ```python
    while not win.isClosed():
        #your code
    ```

2. A few more circles would make this more interesting. Before your while loop, create a list of `MovingCircle`s at different locations, draw them all, and then add a for loop within your while loop so that they all move randomly each time. **Make sure that your code is working at this point.**

3. If the circles are moving too fast for you, you can use the `time` module to have them move more slowly:

    ```python
    import time #add this at the top with the other imports

    #add this where ever you want to pause
    time.sleep(0.1) #sleeps 0.1 seconds before next line
    ```

## Exercise 3

You'll probably also want to respond to user input in your game or simulation. There are a couple of ways to do that. Let's start by letting the user draw some circles:

1. The graphics library lets you get the location that a user clicks with the `getMouse()` method of the `GraphWin` class. It returns the information as a `Point` object. Use this method to draw a circle where ever the user clicks in the window!

2. The graphics library also lets you detect what key on the keyboard a user has pressed with the `getKey()` method of `GraphWin`. It returns the key as a string of the character key that was pressed. For example, if the user hit the 'Y' key, the method would return the string `"y"`. Experiment with this method by first displaying what you get when you do:

    ```
    input_key = win.getKey()
    instructions = Text(Point(50, 75), input_key)
    instructions.draw(win)
    ```

    And then use it to allow the user to pick from a couple of different colors for their circle (for example, 'y' for yellow and 'p' for purple).

3. You probably don't want to force the user to make a new circle each loop. You can instead use the `checkMouse()` method, which doesn't pause the program, but just checks if the user has clicked since the last time (there is also a `checkKey()` equivalent). `checkMouse()` returns `None` if there is no new click, so you'll need to use a conditional to see if there is actually input to use:

    ```python
    click_point = win.checkMouse()
    if click_point == None:
        #don't do anything
    else:
        #check on color and draw a new circle
    ```

    Switch to the `checkMouse()` method so that your circles wiggle around until the user clicks, and then a new circle is drawn and added to the list of moving circles.


## Exercise 4
You are already pretty far along in making something game/simulation like, but a frequent other way to control a game is with the arrow keys. You might have already figured out how to do that, but we'll walk it through here and combine the various things from previously.

1. Let's make a new class that is a `PredatorSquare` which will be controlled by the user to eat the `MovingCircle`s. You'll want your class constructor to take in a couple of points and create a `Rectangle` with them, which you should save as `self.body`. Feel free to make it a specific color as well. (This is a good time to break out each class into its own file `predator_square.py` and `moving_circle.py` and then just import from both at the top of your `main.py`)

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

    **Make sure that you can now control your predatory square's movement.**

## Exercise 5
Finally, you'll want to check if your square runs into any of the circles and eats them. This requires detecting a collision, which is a bit of a tricky process. We're going to make it easier by assuming everything is a circle (even the rectangle) since collisions with circles are a lot easier to detect. This will mean that the predatory rectangle doesn't quite match up, but that's okay.

1. Create a method in your `MovingCircle` class `collision` that takes another object `other` as a parameter (along with `self`).

2. All graphics objects have a `getCenter` which returns a `Point` that is at the center of the object at that moment. The `math` module also has a `dist` function for calculating distances. Here is how to combine them to determine the distance between two centers:

    ```python
    import math #add at the top with other imports!

    #Add to collision:
    my_x = self.body.getCenter().getX()
    my_y = self.body.getCenter().getY()
    other_x = other.body.getCenter().getX()
    other_y = other.body.getCenter().getY()
    distance = math.dist([my_x, my_y], [other_x, other_y])
    ```

3. We need the radii of both objects to compare to the distance. Add a `self.radius` to your rectangle class that is just the length of one of the sides (don't worry about checking for a longer side etc right now). (There is a `abs` method built in to Python for absolute value.) Add a `self.radius` for your `MovingCircle` as well.

4. Check to see if the distance you calculated is less than the two radii added together. Return True or False depending on if there is a collision or not.

4. Now update your `main` code so that it loops through all the circles and checks to see if the rectangle collided with any of them. If it does, undraw the circle.

## Submission
Submit your completed file(s) to Moodle for an extra engagement credit.

## Extra
With that, you know about nearly everything that you need from the graphics library for making a simulation or game! Here are a couple of other things to check out:

1. Use the `Text` object to create some text by [checking the documentation](https://mcsp.wartburg.edu/zelle/python/graphics/graphics/node11.html).

2. Use the `Entry` object to [get text from the user](https://mcsp.wartburg.edu/zelle/python/graphics/graphics/node12.html).

3. [Add an image to your window](https://mcsp.wartburg.edu/zelle/python/graphics/graphics/node13.html) with the `Image` object.
