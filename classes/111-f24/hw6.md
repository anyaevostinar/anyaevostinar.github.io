---
layout: page
title: HW6 
permalink: /classes/111-f24/hw6
---

## Logistics

This is a paired assignment, so you should complete it with your new assigned partner, if you have one, via **paired programming**. 
The whole time that you are working, you should both be present and actively working on the problem at hand. 
(Two brains, one keyboard.) 
Switch off the typing duties so that you each type for roughly half of the time. 

You are able to get help from many sources as detailed in the [collaboration](collaboration) policy.
There is only a partial autograder for this assignment due to the use of graphics, so you should check carefully that you've followed the instructions and make sure that your program works as it should.

This assignment is due on Wednesday October 30th at 10pm. As with all assignments, you will have the opportunity to [revise this assignment individually](revision-process) based on the feedback that you get.

## Goals
Use and adapt classes for data visualization.

## Assessment
You will be assessed on the following rubric.
Be sure to remove the starter comments that are no longer relevant, add additional comments, and update or add headers as necessary.

To **demonstrate proficiency**:
* Correct functionality
* Header with three lines that start with `#` for each file
* Contain docstrings for each function and method (checked automatically)
* Other basic style that can be checked automatically
* `gis.py` displays a basic visualization of Minnesota zipcodes

To **demonstrate mastery**, your program needs to demonstrate proficiency as well as having:
* *Descriptive* headers
* *Descriptive* docstrings for each function and method
* Useful comments (and removal of non-useful starter comments)
* Descriptive variable and function/method names that follow `snake_case`
* Good line grouping and spacing
* Use iteration, conditionals, and functions to organize your programs and prevent any unnecessary duplication of code
* Visualization of Minnesota follows specification (larger circles for larger physical area, red-blue scale where redder is higher population)

## Setup

Again, I recommend you complete this assignment in Olin 310. (This assignment will be especially difficult to complete on your own machine! If you really want to complete it on your own machine, you'll have to install additional packages Tkinter, which is detailed at the bottom of the [installation guides](hw1) for this class.)

[Mount the COURSES drive](getting-started) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HW6`
* Download the starter code linked on Moodle and copy those files into your folder
* Open your `HW6` folder in VSCode

## GIS
In `gis.py` — as in Geographic Information System — you will find the beginnings of a `ZipCode` class to represent a zip code region in the United States, or, more particularly, Minnesota. 

You should first run `python3 gis.py` to see what is already provided.
You will find you now have a file `Minnesota.svg`, which just has the text TODO. 
(SVG is a type of image format like JPEG and PNG, but one that we can save Graphics windows to!)


### ZipCode Class
Your first task is to finish the basics of the `ZipCode` class. Specifically, add/complete the following methods:
* Constructor (`__init__`): save all the incoming parameters to appropriate instance variables
* `get_zip(self)`,`get_population(self)`, `get_latitude(self)`, `get_longitude(self)`: return the appropriate instance variable
* `get_area(self)`: add the zip code’s **total** geographic area in square meters to the code. You'll need to update the constructor as well as adding this method. (Place the new parameter for the constructor at the end of the existing ones.)

(Leave `draw_circle` alone for now, you'll come back to it later.)

### Loading the data
* The `load_data` function is started and already has pulled out the relevant data into local variables for you. You should complete `load_data` so that it creates and returns the list of `ZipCode` objects, as specified by the documentation.

* Next create the `total_population(zips)` function, which takes in your list of `ZipCode`s and returns the total population of the state, which should be 5,534,466 based on this data. You can call this from `main` to make sure you are getting the right answer.

* Next create the `total_area(zips)` function, which takes in your list of `ZipCode`s and returns the total area of the state **in square miles** (convert from square meters to square miles) and rounded to the nearest whole number. It should be 82,458. (It’s not totally consistent with statistics you may find on the web, probably because portions of the state are outside of any zip code, but I’m not 100% sure!)

### Visualization
Finally, it's time to make a cool visualization of this data!
The `draw_circle(self, window)` method should draw a `Circle` (from the `graphics.py` library that you have been using) in `window` centered at the location of the center of the `ZipCode` such that 1) the circle's size scales with the zipcode's physical area and 2) the circle's color represents the population total, where redder means higher population and bluer means lower population (and shades of purple in between).
There are many ways of accomplishing this, but here are suggestions for both: 

* Area: take the square root of the area and divide by 5000 to get the radius of the circle. You’ll want to make use of the `max` function to make sure that your dots are visible (i.e. don't let them get too small, even for very small zipcodes).

* Population: divide the population by 100 to get the amount of red that the circle should have (the amount of blue plus red should total 255). Then use the [`color_rgb` function](https://mcsp.wartburg.edu/zelle/python/graphics/graphics/node14.html) to set the circle's fill to that custom color. 
You’ll want to make use of the `min` or `max` functions to make your color amounts are in the range from 0 to 255.

When you run your code, your `Minnesota.svg` file should now have a data visualization in the shape of Minnesota with circles of varying sizes and shades from red to purple to blue.
This visualization can't be autograded, but you will see on Gradescope what the graders will see when they assess your submission.

## Submission
You should submit through Gradescope as always.

