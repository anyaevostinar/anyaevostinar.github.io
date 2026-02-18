---
layout: page
title: HW6 - GIS 
permalink: /classes/111-w26/hw6
---

## Logistics

Due: Friday Feb 20th at 10pm

You may work alone or with a partner, but you must type up the code yourself.  You may also discuss the assignment at a high level with other students.  You should list any student with whom you discussed each part, and the manner of discussion (high-level, partner, etc.) in a comment at the top of each file.  **You should only have one partner for an entire assignment.**

You should submit your assignment on Gradescope. You submit the files `gis.py`, and `readme.txt`.

Here is the [homework helper bot for HW6](https://gemini.google.com/gem/1SDs0ne_rMDPoYj16VveGBQsD5h3R7UGv?usp=sharing).

---
## Goals
Use and adapt classes for data visualization.

## Assessment
There is only a partial autograder for this assignment due to the use of graphics, so you should check carefully that you've followed the instructions and make sure that your program works as it should.

You will be assessed on the following rubric.
Be sure to remove the starter comments that are no longer relevant, add additional comments, and update or add headers as necessary.

The **core requirements** are that your program has:
* Correct functionality
* Header with three lines that start with `#` for each file
* Basic style that can be checked automatically (not complete!)
* `gis.py` displays a basic visualization of Minnesota zipcodes
    * For core, this can be just circles of all your favorite color and a single size
* Collaboration statement at the top of the file (even if it just says that you worked alone)
* `readme.txt` contains a reflection

The **advanced requirements** are that your program has:
* Satisfied core requirements
* *Descriptive* headers
* *Descriptive* docstrings for each function and method
* Useful comments (and removal of non-useful starter comments)
* Descriptive variable and function/method names that follow `snake_case`
* Good line grouping and spacing
* Use iteration, conditionals, and methods/functions to organize your programs and prevent any unnecessary duplication of code
* Visualization of Minnesota follows specification (larger circles for larger physical area, red-blue scale where redder is higher population)

## Setup

Again, I recommend you complete this assignment in Olin 310 or 308.

[Mount the COURSES drive](getting-started) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HW6`
* Download the [starter code](/classes/111-w26/HW6StarterFiles.zip) and copy those files into your folder
* Open your `HW6` folder in VSCode

## GIS
In `gis.py` — as in Geographic Information System — you will find the beginnings of a `ZipCode` class to represent a zip code region in the United States, or, more particularly, Minnesota. 

You should first run `python gis.py` to see what is already provided.
You will find you now have a file `Minnesota.svg`, which just has the text TODO. 


### ZipCode Class
Your first task is to finish the basics of the `ZipCode` class. Specifically, add/complete the following methods:
* Constructor (`__init__`): save all the incoming parameters to appropriate instance variables
* `get_zip(self)`,`get_population(self)`, `get_latitude(self)`, `get_longitude(self)`: return the appropriate instance variable
* `get_area(self)`: add the zip code’s **total** geographic area in square meters to the code. You'll need to update the constructor as well as adding this method. (Place the new parameter for the constructor at the end of the existing ones.)
    * Note that the constructor should take just one parameter for the `area`, NOT `land_area` and `water_area` separately

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

## Reflection

Were there any particular issues or challenges you dealt with in completing this assignment?  How long did you spend on this assignment?  Write a brief discussion (a sentence or two is fine) in your `readme.txt` file.

## Submission
You should submit your file through the Gradescope link on Moodle for this assignment.
You are able to submit your code as many times as you wish before the deadline to fix any issues (and you should do so).
If you have questions about what the autograder is telling you is wrong, please ask!

