---
layout: page
title: HW2 
permalink: /classes/111-f22/hw2
---

## Logistics

This is a paired assignment, so you should complete it with your assigned partner, if you have one, via **paired programming**. 
The whole time that you are working, you should both be present and actively working on the problem at hand. 
(Two brains, one keyboard.) 
Switch off the typing duties so that you each type for roughly half of the time. 

You are able to get help from many sources as detailed in the [collaboration](collaboration) policy.

This assignment is due on Wednesday Sept 28th at 10pm. 
As with all assignments, you will have the opportunity to revise this assignment individually based on the feedback that you get.

## Goals
Get practice with various numerical operations and functions in Python.

## Setup

Again, I recommend you complete the programming portion in Olin 310. 

[Mount the COURSES drive](https://wiki.carleton.edu/pages/viewpage.action?spaceKey=carl&title=CS+111+and+201+workflow+in+CS+labs) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HW2`
* Open your `HW2` folder in VSCode
* Create a file `solar.py`.


## Solar
In this problem, you will write a program that asks the user for information about their house — namely, the length and width of the house (both in feet) — and then computes the amount of energy that can be generated with rooftop solar for this house.

Here is a sample interaction of the way that your program should work (the numbers 30 and 40 are entered by the user; the rest is automatically produced as output):

```
Enter the width (in feet): 30
Enter the length (in feet): 40
You have 1200.0 square feet of roof area.
You have 450.0 square feet of south-facing roof, excluding the setback.
You can fit 25 solar panels on your roof.
That leaves 762.5 square feet of unused roof area for a rooftop garden.
You can install a system rated for 6625 watts.
You can generate about 8268 kilowatt-hours in a year.
That's equivalent to about $992.16 of electricity.
```

To perform the calculations shown in this sample, we will make some highly simplifying assumptions about the energy production capacity of a roof and of solar panels — but they’re not too far off (see https://solarpowerrocks.com/square-feet-solar-roof/). 

Here are the assumptions:

* Exactly half of the area of the roof of a house faces south (towards the sun); only the south-facing roof is suitable for solar panels. Of the south-facing roof, only 75% can be used for panels, because there must be a setback (to allow walking space for firefighters if they need to access the roof).

* A single solar panel takes up 17.5 ft<sup>2</sup> of roof. You cannot cut solar panels in half, so the number of solar panels that you can fit on a roof that’s, say, 100 ft<sup>2</sup> is 100/17.5 = 5.71... *rounded down*, otherwise known as 5 panels. We’ll assume that the shape of the roof is such that it’s possible to tile the usable part completely with solar panels, without any wasted space.

* A single solar panel is rated for 265 watts. In Minnesota, you can expect to generate 1.248 kilowatt-hours per year for each watt of your system, and electricity costs about $0.12 per kilowatt-hour. The dollar amount should be always printed with exactly two digits after the decimal place. (So it’s “$1.00” and not “$1.0”, for example.) See [section 9.9 of your textbook](https://runestone.academy/ns/books/published/intro-cs/TransformingSequences/NonmutatingMethodsonStrings.html) for a useful method for accomplishing the dollar amount.

Fill in `solar.py` with a program that performs as specified here.


## Submission
You should submit your file through the Gradescope link on Moodle for this assignment.
You are able to submit your code as many times as you wish before the deadline to fix any issues.
If you have questions about what the autograder is telling you is wrong, please ask!

If you have a partner for this assignment, you can indicate who they are via Gradescope, so be sure to set that up correctly and then between the two of you, you should only need to submit once.

## Assessment
To **demonstrate proficiency**, your program needs to pass all the tests in Gradescope and contain descriptive headers.

To **demonstrate mastery**, your program needs to demonstrate proficiency as well as having:
* Useful comments
* Descriptive variable names
* Good spacing
