---
layout: page
title: Random Turtle Lab 
permalink: /classes/111-f22/random-turtle
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and quizzes so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.

## Exercise 1
There are a lot of things that you can tell the turtles to do, so open up the [list of turtle methods](https://runestone.academy/ns/books/published/intro-cs/PythonTurtle/SummaryOfTurtleMethods.html) from the reading for reference today.
You might also want to open the [list of common turtle problems](https://runestone.academy/ns/books/published/intro-cs/PythonTurtle/WPCommonTurtleErrors.html) to check if you are getting weird behavior from your turtle.

1. Create a new file in your folder for today's lab called `random_turtle.py`.

2. In that file, import both the `turtle` and `random` modules:
```python
import turtle
import random
```

3. Create your window and one turtle, and tell the window not to close until you click:

```python
window = turtle.Screen()
my_turtle = turtle.Turtle()

window.exitonclick()
```

4. It's good to run your code frequently to make sure that there aren't errors, so open a `Terminal` (by dragging up from the bottom of the screen), and run your program:
```
python3 random_turtle.py
```

Your turtle won't do anything interesting yet, but you should see it and the screen should wait for you to click before closing.

## Exercise 2
Now you're ready to have your turtle do something! 

1. Use the `random.randrange()` method to have your turtle go forward by a random amount between 10 and 100.

2. Have your turtle make a square with a side length randomly between 10 and 100.
Remember that you can use a for-loop to repeat several lines of code multiple times:
```python
for x in range(3):
    #do something
    #do some more things
```

## Exercise 3
There are several more turtle methods that do some fun things. 
Create a new file `example_one.py` to test out the following.

1. Here is some code that uses a couple of new turtle methods:

```python
import turtle

window = turtle.Screen()
turtle1 = turtle.Turtle()

turtle1.fillcolor("purple")
turtle1.begin_fill()

for side in range(2):
    turtle1.forward(30)
    turtle1.right(90)

turtle1.end_fill()

window.exitonclick()
```

Copy and paste it into your file, run it, and figure out what the three new methods do. 
Feel free to experiment by changing the code to see what happens when you move lines around or change values.

2. Expand on the provided code to make several more connected shapes in different colors.

## Exercise 4
Let's look at some more example code (from section 5.6 of the book).
Create another new file `example_two.py` and paste in the following:

```python
import turtle
wn = turtle.Screen()
wn.bgcolor("lightgreen")
tess = turtle.Turtle()
tess.color("blue")
tess.shape("turtle") #other shape options: arrow, blank, circle, classic, square, triangle

dist = 5
tess.up()                     # this is new
for _ in range(30):    # start with size = 5 and grow by 2
    tess.stamp()                # leave an impression on the canvas
    tess.forward(dist)          # move tess along
    tess.right(24)              # and turn her
    dist = dist + 2
wn.exitonclick()
```

There are quite a few new methods, experiment by removing them or changing them one at a time to see what they do!
You can always refer to the list of turtle methods to double check your prediction.

## Exercise 5
With all those methods, you can draw a lot! 
Make a new file `drawing.py` and make something new with the turtle drawing.
You could use `random` to shake things up in your drawing, but be sure to use lots of colors and shapes. 
Try making multiple turtles and having them be in charge of different aspects of your drawing.
If you are stuck on what to draw, try making a house with some trees.

There are also even more methods that you can use with the turtle, so feel free to look through the [official documentation](https://docs.python.org/3/library/turtle.html) and play around with them.