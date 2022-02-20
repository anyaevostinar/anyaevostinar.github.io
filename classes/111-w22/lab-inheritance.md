---
layout: page
title: Inheritance Lab
permalink: /classes/111-w22/inheritance-lab
---

## Logistics
This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do and opening the [reading for today](https://runestone.academy/ns/books/published/thinkcspy/Inheritance/toctree.html) for reference.

## Exercise 0
We'll first make some classes, remember to run your code after each step to catch any errors early!

a. Create a `Plant` class with a constructor that sets the instance variable `waterLevel` to `0` and `status` to `thirsty`.

b. Create a subclass of `Plant` that is called `Carrot` that doesn't do anything:
```
from plant import Plant
class Carrot(Plant):
    pass
```

c. In `main` of the carrot file, create some instances of `Carrot`, put them in a list called `garden`, and print their status.

## Exercise 1
a. Expand your `Carrot` class so that it defines its own `__init__` that calls the superclass's constructor and also creates an instance variable `name` set to `carrot`. Make sure to test your code at this point to ensure that you can print the name of your carrots.

b. Create another subclass of `Plant` that is another kind of plant and set its `name` correctly.

## Exercise 2
a. Add the methods `waterPlant` and `elapseDay` to your `Plant` class. Feel free to be creative with how watering the plant impacts its status and how much water a plant uses up each day.

b. Create a new file `garden.py`, import all your classes, and create a `main` function that creates several of each subclass, places them into a list, and simulates several days passing (during which you should probably water them).

## Exercise 3
Get creative! Overwrite the superclass methods for your subclasses if you plant type need different amounts of water, add more ways of interacting with your plants, or make `draw` methods for your plants that uses `graphics.py` to draw them all.