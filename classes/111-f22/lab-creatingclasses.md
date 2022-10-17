---
layout: page
title: Creating Classes Lab
permalink: /classes/111-f22/creating-classes
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.

## Exercise 1
You should again download the file [graphics.py](/classes/111-w22/graphics.py) and put it into the folder for today's lab. 
Then also download the file [example_prerefactor.py](example_prerefactor.py) and put it in your folder as well.

1. Run `example_prerefactor.py` to see the flower that is made. Your goal is going to be to make the exact same flower, but with improved code organization!

2. Create a file `Flower.py` and define a class `Flower` that will allow for the same exact flower to be drawn when the following code is run (which you should put in a `main` function in the `Flower.py` file):

    ```python
    win = GraphWin("My fancy window", 400, 400)
    my_flower = Flower(Point(200,200), "purple")
    my_flower.draw(win)
    input("Press Enter when done")
    ```

3. If the only method that you defined was your `draw` method, think about how you can split it up further. Ideally, you should have about six methods (including the constructor and `draw`) that are each no more than 5 lines long.

## Exercise 2
There are so many things you can do once you've bundled your shapes together into a class! Let's explore a few of them:

1. Update your `Flower` constructor so that it takes parameters for the center of the flower and the color of the petals.

2. In your `main`, draw several flowers of different colors and at different locations (maybe even draw some soil at the bottom of the window for them to be growing out of...).

3. The graphics library lets you get the location that a user clicks with the `getMouse()` method of the `GraphWin` class. It returns the information as a `Point` object. Use this method to draw a flower where ever the user clicks in the window!

4. The graphics library also lets you detect what key on the keyboard a user has pressed with the `getKey()` method of `GraphWin`. It returns the key as a string of the character key that was pressed. For example, if the user hit the 'Y' key, the method would return the string `"y"`. Experiment with this method by first printing what you get when you do:

    ```
    input_key = win.getKey()
    print(input_key)
    ```

    And then use it to allow the user to pick from a couple of different colors for their flower (for example, 'y' for yellow and 'p' for purple).


## Exercise 3
Object-oriented programming is very useful for both simulations and games since we are often thinking about things in terms of items in those contexts.
You're going to turn your flower program into a simple simulation (or even game?).

1. Add an `age` instance variable to your Flower class that starts equal to 0.

2. Add an `undraw` method to your Flower class that goes through and calls the `undraw()` method on each of the flower's components. If you hadn't already been saving the petals, stem, and center shapes as instance variables, you should do that now so that you can then undraw them.

3. Add a `dayPasses` method that adds one to the age of the flower and checks if the flower is older than 3 days. If it is, have it print out 'dead!' and call its undraw method.

4. Test to make sure that your `undraw` and `dayPasses` methods work on your existing flowers.

## Exercise 4
Simulations and games usually run until the user decides they are done. So let's update your `main` to do that.

1. We're going to soon have a lot of flowers, so make a list and add all your current flowers to that list.

2. Make a loop that calls the `dayPasses` method on each of the flowers in your list.

3. Nest your existing loop inside of another loop that first calls `dayPasses` on all the flowers, and then allows the user to place a new flower. When you run your program, you should now see some flowers dying while others continue because they were planted later by the user.

## Exercise 5
There are many more kinds of flowers and plants in the world! 

1. Make a new file `Plant.py` that defines another class that is a different kind of flower or plant (perhaps based on your design from previously). Perhaps it has different flowers/leaves and ages differently.

2. Create a new file `main.py` that imports both classes (and graphics). Move your flower simulation loop into this file.

3. Update your simulation so that it simulates some of each type of class (feel free to let the user choose or choose randomly or some other way). 

## Extra
There are a lot of ways to expand on your flower simulation/game, so try out any of these or your own ideas:
* Make the aging process slower by having one petal fall off each day until the whole flower dies
* Make the number of petals/leaves or length of the stem of the flower somewhat random and perhaps even influence how fast the flower dies
* Have the flowers "sway" slightly by shifting back and forth each day with the `move` method of each component shape
* Force the user-drawn flowers to all be at the right height so they aren't floating in the air (perhaps by making their stems longer too?)
* Make a caterpillar class that randomly moves around the screen and eats flowers that it runs into (this will be tricky, you'll have to calculate if it ran into any of the flowers based your calculations of the space they take up!)
* Add a chance for random events like storms or allow the user to water the flowers to keep them from dying (again this will be tricky, you'll have to see where the user clicks and see which flower, if any, it overlaps)