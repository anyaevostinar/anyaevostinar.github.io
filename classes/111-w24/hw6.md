---
layout: page
title: HW6 
permalink: /classes/111-w24/hw6
---

## Logistics

This is a paired assignment, so you should complete it with your assigned partner, if you have one, via **paired programming**. 
The whole time that you are working, you should both be present and actively working on the problem at hand. 
(Two brains, one keyboard.) 
Switch off the typing duties so that you each type for roughly half of the time. 

You are able to get help from many sources as detailed in the [collaboration](collaboration) policy.
There is not an autograder for this assignment due to the use of graphics, so you should check carefully that you've followed the instructions and make sure that your programs work as they should.

This assignment is due on Friday February 16th at 10pm. As with all assignments, you will have the opportunity to revise this assignment individually based on the feedback that you get.

## Goals
Use and adapt classes for data visualization and image manipulation.

## Setup

Again, I recommend you complete this assignment in Olin 310. (This assignment will be especially difficult to complete on your own machine! If you really want to complete it on your own machine, you'll have to install additional packages Tkinter and Pillow, which is detailed at the bottom of the [installation guides](https://stolafcarleton.teamdynamix.com/TDClient/3356/Portal/KB/?CategoryID=24695) for this class.)

[Mount the COURSES drive](getting-started) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HW6`
* Download the starter code linked on Moodle and copy those files into your folder
* Open your `HW6` folder in VSCode

## Bluescreen
Everybody’s new favorite piece of software, Zoom, uses "green screening" to allow personalized backgrounds. 
(The same thing is done for TV weather forecasting, and in a lot of films.) 
In the simpler version, the participant is filmed in front of a green screen and then the green is removed from the scene and replaced with another background (the Monterey Bay Aquarium, a galaxy, whatever). 
Sometimes "blue screening" is used instead; there are some interesting tradeoffs related to skin tone and variations in film/camera quality. 
The non-green-screen version of the Zoom feature uses more complex image processing techniques: most likely looking for faces, and then doing image segmentation.

This problem will ask you to do something similar, though more akin to a basic form of the technology used to put the yellow line (first-down marker) on football broadcasts. 
The basic idea there is to use very precise geometric information, plus the palette of colors of the field (and not the players) to cause the players’ colors to automatically be displayed "on top of" (instead of, really) the virtual line’s colors.

First, some background. You can think of a digital image as a large two-dimensional array of pixels, each of which has a red (R) value, a green (G) value, and a blue (B) value. 
An R, G, or B value is just an integer between 0 and 255. 
To modify the image, you need to "loop through" all of these pixels, one at a time, and do something to some or all of the pixels. 

For example, an algorithm to remove all of the green color from each pixel:
```
 for every row in the image:
    for every column in the image:
        set to zero the green value of the pixel in this row and this column
```

To facilitate reading in, storing, and manipulating image files using some standard image formats (like `.gif` and `.png`), we will use the `images.py` module, provided in the starter code.

### Your Task Part 1
(Note: This one will be especially difficult to complete on your own machine. You need to install PIL/pillow, which can be tricky. Follow the instructions at [https://www.carleton.edu/computer-science/resources/source/](https://www.carleton.edu/computer-science/resources/source/), or just use the labs in Olin!)

Among the files that you have are a handful of sample images, including one of Dr. Anna Rafferty and one of Dr. Sneha Narayan, two of the other CS professors in the department. 
You also have a skeletal version of a program that loads the picture of Anna and then draws the image. 
You’ll need to do similar work with new images, so look through `images.py` enough to figure out how the code in `bluescreen.py` is working. 
To run this code, open a Terminal, and type `python3 bluescreen.py`.

Your task is to add the following functions to `bluescreen.py`:
  
1. `onlyRed(image)`. Creates and returns a new image containing only the red aspects of the original image. You can do this by setting all the values in the green and blue values for each pixel to 0. Note that you shouldn’t change the original image! You may find the `copy()` method helpful.

2. `deuteranopia(image)`. Creates and returns a new image that crudely simulates what a red–green colorblind (“deuteranopic”) viewer would see when looking at the image. To do so, set both the red and green pixel values to be the average of the original red and green pixel values. That way (128, 0, 0) and (0, 128, 0) will both come out as (64, 64, 0).

3. `negate(image)`. Creates and returns a new image that is a conversion of the original image to "negative" form, like a photographic negative. Modify all colors in a way that turns black into white, white into black, dark colors into light, light into dark, etc. (Don’t worry if you don’t exactly match the color correspondence between a photo negative and its print.) Again, don’t change the original image.

4. Update the `main()` function so that it tests the above functions by using the picture of Anna and making red, deuteranopic, and negative versions of it appear on the screen.

### Your Task Part 2

Now that you have the hang of manipulating images, let’s return to blue screening. 
We can “combine” an image of, say, a CS faculty member hanging around in front of a plain background (like `sneha.jpg`)— in this case, the plain background is a beach instead of a blue/green screen — with an image of scenery (`background1.jpg`) by replacing the “beach” pixels in a person picture with pixels from a background picture. 
To do this, we have to figure out which pixels correspond to the background (and can be changed) and which ones correspond to the person (and should be left alone). 
Identifying which pixels are in the beach is tricky. 
Here’s an approach that works reasonably well here: 
```
count any pixel that satisfies the following formula as part of the beach:
    red value is at least 100
    and green value is at least 100
    and the total value of red + blue + green is at least 450
```

Add to your `bluescreen.py`: 
1. A function `replaceBeach(originalImage, replacementImage)`. Creates a new image that replaces all “beach” pixels in the original image with the corresponding pixels taken from the replacement image. Note that the main image and the replacement image need to have the same dimensions for this technique to produce the desired effect.

2. Update your `main` function to test your new function by putting Sneha in front of the provided backgrounds. Feel free to use your own pictures, too (and try to figure out how to remove the background of those pictures, assuming you don’t hang out near neutral-colored empty beaches as much as the CS faculty).

## GIS
In `gis.py` — as in Geographic Information System — you will find the beginnings of a `ZipCode` class to represent a zip code region in the United States, or, more particularly, Minnesota. 

You should first run `python3 gis.py` to see what is already provided.
Try clicking.
You'll see the zipcode displayed of just one particular zipcode because the functionality of the `Zipcode` class isn't finished yet.


### Your Task Part 1
Your first task is to finish the `ZipCode` class. Specifically, add the following methods:
* `getPopulation(self)`: returns the population of the zipcode. (Skeleton code is there, but you’ll need to add code to return the actual population, don't overthink this though!)
* `distanceToPoint(self, window, point)`: compute how far away a given `Point` is from this `Zipcode`. Right now, the method exists but doesn’t do anything meaningful; you should fill in the code here to return the distance. For our purposes, the distance between two points
    * `a=⟨ax,ay⟩`
    * and `b=⟨bx,by⟩`

    is `sqrt( (ax−bx)**2 + (ay−by)**2 )`.
    Note that the `point` parameter has methods `getX()` and `getY()` that you should use. The `Zipcode` object's related methods required the `window` to be passed to them: `self.getX(window)` and `self.getY(window)`.

When you finish `distanceToPoint`, left-clicking should cause the nearest zip code object to display its name (not just the numerically first one). Right-clicking should cause all displayed names to disappear [“right clicks” may be the middle button on some mice, including those in the lab—that’s okay, and they may not be detected at all on computers with a touchpad, though sometimes they are Ctrl-click], and the loop at the bottom should output the state’s total population according to this data set.

Second, add the zip code’s **total** geographic area to the code. 
First, add a parameter to the `ZipCode` constructor to store the area, and fill it appropriately in the `loadData` function. 
Add a `getArea` method, too. 
Then add code to the final loop to output the total area of the state (convert from square meters to square miles); print the total area, it should be around 82,458. 
(It’s not totally consistent with statistics you may find on the web, probably because portions of the state are outside of any zip code, but I’m not 100% sure!)

### Your Task Part 2
Finally, it's time to improve the visualization a little bit. 

Make the size of the circle representing a zip code scale with its physical area, and its color represent its population, where redder means higher population and bluer means lower population. 
You’ll do this by modifying the `drawCircle` method appropriately. A good way to do this is taking the square root of the area and dividing by 5000, and taking the population divided by 100. 
You’ll want to make use of `min` or `max` functions to make sure that your dots are visible and your colors are in the range from 0 to 255.

You are welcome to go further with your improved visualization as well!


## Assessment
You will be assessed on the following rubric.
Be sure to remove the starter comments that are no longer relevant, add additional comments, and update or add headers as necessary.

To **demonstrate proficiency**:
* `bluescreen.py` functions `onlyRed`, `deuteranopia`, `negate`, and `replaceBeach` implemented correctly and called in `main` function
* `gis.py` displays an improved visualization of Minnesota zipcodes where the size of the circle scales with area and the color represents population size in some way.
* `gis.py` prints out the total square miles and population of Minnesota
* `gis.py` zipcode numbers show correctly based on mouse clicks
* Both files have updated and accurate headers
* Functions you added or updated have accurate docstrings with 1) description of why you would use the function, 2) the arguments, 3) the return value if any

To **demonstrate mastery**, your program needs to demonstrate proficiency as well as having:
* Useful comments (including removal of any outline/todo comments)
* Descriptive variable names
* Good spacing
* Use iteration, conditionals, and functions to organize your programs and prevent any unnecessary duplication of code

## Submission
You should submit through Gradescope as always.

