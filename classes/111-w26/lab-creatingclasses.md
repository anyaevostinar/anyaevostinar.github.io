---
layout: page
title: Flower Lab
permalink: /classes/111-w26/creating-classes-lab
---

This is a lab assignment, so it isn't required to complete.
However, the concepts and practice will help you on the homework, exams, and final project so I encourage you to make a serious effort on it during class and consider finishing it outside of class. If you do finish it and submit it to Moodle, you'll earn an extra engagement credit.

I recommend creating a folder in COURSES for this lab as you usually do.

## Exercise 1: A minimal class
You should again download the file [graphics.py](/classes/111-w22/graphics.py) and put it into the folder for today's lab. Also remember that you can refer to the [graphics documentation](https://mcsp.wartburg.edu/zelle/python/graphics/graphics/graphref.html) for more details on the methods of `graphics` classes.. 
Then also download the file [flower_starter.py](/classes/111-w26/flower_starter.py) and put it in your folder as well.

1. Run `flower_starter.py` to see the flowers that are made. Your first goal will be to make the same flowers but with improved code organization.

2. Create a file `flower.py`. In it, import `graphics` and `random` and define a class `Flower`, like so:
    ```python
    from graphics import *
    import random

    class Flower:
    ```

3. Copy over the `draw_stem` and `draw_flower` functions and turn them into methods of the `Flower` class by adding the `self` parameter to both and indenting them.

4. Copy over `main` (and the `if __name__ == '__main__'` block) and then edit it to work with your new `Flower` class by:
    * Creating a new instance of `Flower` called `new_flower`
    * Calling `new_flower.draw_stem()` and `new_flower.draw_flower()` with the right parameters

5. You should always aim to make small changes and then test that those changes work, so this is a good time to run your `flower.py` with `python flower.py` to make sure that you are still successfully drawing the flowers.

## Exercise 2: Adding state to your class

You may have noticed that you aren't really taking advantage of the `Flower` class at the moment, especially since it doesn't have any state! Let's fix that by making a constructor and using state to organize our program.

1. Create a constructor with `def __init__` that takes a window, x coordinate, height, and color as parameters and sets them to instance variables using `self.`. Remember that the first parameter needs to be `self`. 

2. Change your `draw_stem` and `draw_flower` to rely on the instance variables instead of needing parameters. 

3. Update your `main` to pass parameters to `Flower()` instead of the drawing methods. Remember to test your code at this point to make sure that it works still.

4. We can do some further streamlining by having the drawing methods set instance variables instead of returning. Remove the return values from both `draw_stem` and `draw_flower` and have them create instance variables `self.stem` and `self.center_circle` instead.

5. A flower doesn't really exist unless it's drawn, so switch to calling `self.draw_stem()` and `self.draw_flower()` in `Flower`'s constructor instead of in `main`.

6. You can now cut out several lines of code in `main` (yey!) and just append your `new_flower` to `my_flowers` immediately after creating it! Doesn't that look much tidier?

## Exercise 3: Leveraging OOP
Now that we have much more contained logic for our flowers, we can add new functionality more easily. Let's make our flowers grow!

1. If our flowers are going to grow, then they need to start off small, so change their initial `self.height` to 1 and remove the `draw_flower` call in the constructor. You should also remove the `height` parameter, since we don't need it anymore (remember to update `main` accordingly). 

2. Add a new instance variable `self.age` that starts at 0.

3. Define a new method `grow`, which does the following:
    * adds 5 to the height;
    * undraws the current stem with `self.stem.undraw()`;
    * draws a new stem by calling `self.draw_stem()`;
    * checks if `self.age` is equal to 4, if it is, calls `self.draw_flower()`;
    * increments `self.age` by 1.

4. Add an `import time` at the top of your file and the following to your `main` **outside of the existing for loop**:
    ```python
    for i in range(7):
        time.sleep(0.5) #pauses for 0.5 seconds so we can savor the flowers
        for flower in my_flowers:
            flower.grow()
    ```
    Remember to run your code at this point to see how it is looking!

5. You probably noticed that the flowers didn't continue to grow with the stems, oops! Fix that by using the `move` method of `Circle` like so:
    ```python
    elif self.age > 4:
        self.center_circle.move(0, 5) #doesn't move along x, just 5 up
    ```
    Run your code again to see how your flowers are doing.

6. Hmm, that stem is not cooperating! You can call `undraw` and then `draw` to get the flower `center_circle` to stay on top:
    ```python
    self.center_circle.undraw()
    self.center_circle.draw(self.window)
    ```

7. Verify that you now have lovely growing flowers!

## Exercise 4: Better flowers
You can definitely make better flowers than just a circle, though `graphics` is a little bit limited. Check out [flower_with_petals.py](/classes/111-w26/flower_with_petals.py) for an idea of how to use `move` and more `Circle`s to make a flower that looks like this:

![Flower with purple petals](/classes/111-w26/FlowerWithPetals.png)

A few things to think about while you do it:
* I recommend that you make a `draw_petal` method as well as a `draw_petals` method.
* You'll want to save your petals into a list that is an instance variable and add any other instance variables that make sense.
* I recommend also making a `move_flower` method and possibly a `refresh` method that handles the `undraw` and `draw` combo.
* You should generally aim for your methods to be 10 lines or less, it's not always easy to write them that way, but it is a lot easier to read them!
* Remember to make small, incremental changes and run your code frequently.

## Submission
Submit your completed `flower.py` to Moodle for an extra engagement credit.

## Extra
There is so much that you can do to expand your flower simulation! Here are some ideas:
* Allow for lots more colors with [`color_rgb`](https://mcsp.wartburg.edu/zelle/python/graphics/graphics/node14.html)
* Have your flowers stop growing and start losing petals at a certain age (and perhaps even dying!)
* Change your "time" loop in `main` to be an indefinite `while` loop and allow the user to add more flowers. You can use `checkMouse()` to check for a user click without locking up your simulation. `checkMouse()` returns `None` if the user hasn't clicked and otherwise returns the `Point` like usual. This is probably a good time to make a `check_for_new_flower` **function** outside of your `Flower` class.
* Add leaves!
* Make the number of petals/leaves or length of the stem of the flower somewhat random and perhaps even influence how fast the flower dies
* Make a new file `Plant.py` that defines another class that is a different kind of flower or plant. Perhaps it has different flowers/leaves and ages differently. You can use `input` to let the user choose which kind of plant they want after they click.
* Have the flowers "sway" slightly by shifting back and forth each day with the `move` method of each component shape
* Make a caterpillar class that randomly moves around the screen and eats flowers that it runs into (this will be tricky, you'll have to calculate if it ran into any of the flowers based your calculations of the space they take up!)
* Add a chance for random events like storms or allow the user to water the flowers to keep them from dying (again this will be tricky, you'll have to see where the user clicks and see which flower, if any, it overlaps)

