---
layout: page
title: HW2 
permalink: /classes/111-w22/hw2
---

## Logistics

This is a paired assignment, so you should complete it with your assigned partner, if you have one, via **paired programming**. 
The whole time that you are working, you should both be present and actively working on the problem at hand. 
(Two brains, one keyboard.) 
Switch off the typing duties so that you each type for roughly half of the time. 

You are able to get help from many sources as detailed in the [collaboration](collaboration) policy.

This assignment is worth 15 points total, 4 of which are checked on Gradescope automatically with an **autograder**, 7 for written answers, and 4 for program style.

This assignment is due on Wednesday Jan 19th at 10pm. See the [syllabus](syllabus) for the late policy.

## Goals
Get practice with various numerical operations in Python and using conditionals as well as thinking about more algorithms.

## Setup

Again, I recommend you complete the programming portion in Olin 310. 

[Mount the COURSES drive](https://wiki.carleton.edu/pages/viewpage.action?spaceKey=carl&title=CS+111+and+201+workflow+in+CS+labs) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HW2`
* Open your `HW2` folder in VSCode
* Create two files `coins.txt` and `solar.py`.
* Download the two starter files from Moodle (`bike.py` and the CSV file) and put them into your folder

## Coins
In the file `coins.txt`, answer the following question. It’s a question from a different era (in more than one sense).

There used to be a bakery on Division Street called Quality Bakery that only took cash. Imagine that you go into Quality Bakery to get a donut. Since Quality only accepts cash, you hand over a bill, and get some coins back. If the baker/cashier is paying attention, you’ll get as little small change as possible — first you’ll get as many dollars as possible, then as many quarters as possible, and so on. (So if you’re supposed to pay $5.42 and you give a $10, you’ll get back 4 dollars, then you’re owed $0.68. You get two quarters, and you’re owed $0.18. You get one dime, and you’re owed $0.08. Etc.)

The algorithm that the baker is using is an example of a *greedy algorithm*, because at every step you greedily use as many dollar bills (then quarters, then dimes, etc.) as you can, without any long-term consideration of whether using fewer quarters might result in you needing fewer total coins to give back to the customer. It turns out that for the American change system (25/10/5/1), the greedy algorithm is optimal — that is, it always gives the customer the fewest total coins. However, this property does not hold for all sets of coins!

(a) Give an example coin set in which the greedy algorithm does not give the smallest possible set of coins. Explain. (Hint: there’s an example in which the greedy algorithm fails that has only three coins, each of which is worth at most five cents.) Assume there is a penny in every coin system.

(b) Suppose that you are given a list of coin values — assume that a penny is included in the list — and an amount x of change to make. Describe an algorithm that will find the smallest number of coins that total to x in value. Do not worry about making your algorithm fast/efficient/clever. Just try to think of an approach that will find the smallest possible set of coins. In writing up the description of your algorithm, you should aim to give a description that is sufficiently detailed for a smart-but-completely-ignorant-of-computer-science person to optimally make change. 

(Warning: this will require some thinking! If you’re stuck, think about the “brute-force” strategy that worked for the in-class office-hours-scheduling example. Suppose that the coin system has coins worth 17 cents, 5 cents, and 1 cent. Suppose that you’re trying to make change for 42 cents. You could potentially give 0, 1, or 2 seventeen-cent coins as change. How would you figure out which one of those three choices is the best?)


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

* A single solar panel is rated for 265 watts. In Minnesota, you can expect to generate 1.248 kilowatt-hours per year for each watt of your system, and electricity costs about $0.12 per kilowatt-hour. The dollar amount should be always printed with exactly two digits after the decimal place. (So it’s “$1.00” and not “$1.0”, for example.) Zelle’s Section 5.8.2 may be helpful.

Fill in `solar.py` with a program that performs as specified here.

## Bikes
An increasing number of cities in the United States have begun to offer bikeshare programs: there are a number of stations scattered across the city, with kiosks, pay stations, and locked bikes. People can rent a bike for a short period of time, picking up at any one of the stations and dropping off at the same station or any other station. There’s Nice Ride in Minneapolis/St. Paul, Citi Bike in New York, among many others. Here we’ll play around with a bit of data from Capital Bikeshare, in Washington DC. You will have access to a file reporting all rides from Capital Bikeshare in August 2021. (The original data came from https://www.capitalbikeshare.com/system-data; there are a few formatting modifications to make your lives easier.) A typical line of the file is of the form

```
0:23:9,2021-08-14 10:25:18,6th & K St NE,31645,2021-08-14 10:48:27,14th & V St NW,31101,classic_bike,casual
```

Each line corresponds to one ride, and it reports several facts about the ride:
* ride duration (0:23:9 means 0 hours, 23 minutes, 9 seconds). 
* start time (2021-08-14 10:25:18)
* start station (6th & K St NE)
* start terminal ID number (31645)
* destination time (2021-08-14 10:48:27)
* destination station (14th & V St NW)
* destination terminal ID number (31101)
* the type of the bike used (electric_bike or docked_bike or classic_bike)
* casual or member indicating whether the rider is a member of the bikeshare system.

There are all sorts of fascinating questions you could ask about these data. Where should the next station be built? How should bikes be reallocated among stations during the day (a.k.a. are there places that are more popular destinations than departure points late at night, and the other way around during the day)? How should rides be priced? These questions are beyond the scope of this class, though totally fascinating questions at the intersection of CS and urban planning. But here, you’ll do some much simpler tasks with the bike system, as a first project that deals with large data sets and some relatively simple Python.

1. First, take a look at the `bike.py`. Your task in this assignment will be to add some functionality to this program. First, fill in the code that calculates the **duration of each ride in seconds**. The lines

```
times = duration.split(":")
hours, minutes, seconds = 0, 0, 0 # YOU FILL THIS IN! 
durationInSeconds = 0 # YOU FILL THIS IN!
```

are where the calculation is done. Be careful: as written, the data in `times[0]`, `times[1]`, and `times[2]` (which you might want to store as the variables hours/minutes/seconds) are strings rather than integers; you can convert them to integers if you want, but it’s up to you to do so! Modify the calculation to correctly find the duration of this ride in seconds. When you run the program, you should now see the length of the longest ride in the whole dataset.

(Hint: don’t panic if you see a crazily large number. It is more likely to indicate a mistake made by a Washingtonian bike rider than a mistake made by a Carletonian programmer!)

2. Let’s figure out the net traffic into/out of the Kennedy Center station. The `netChangeAtKennedy` variable should count how many more bikes arrive at Kennedy Center in the data than leave Kennedy Center. This variable needs to be updated for every ride. Here are the lines that ought to do it:

```
# YOU FIX THESE CONDITIONS:
if "this ride left one bike at station ’Kennedy Center’":
    netChangeAtKennedy = netChangeAtKennedy + 1
if "this ride took one bike away from station ’Kennedy Center’":
    netChangeAtKennedy = netChangeAtKennedy - 1
```

Modify the conditions of the two if statements so that they correctly update the number of bikes entering/leaving this station. Also correct the “???” in the following lines to be the correct value:

```
elif netChangeAtKennedy < 0:
    print("There are now ??? fewer bikes at Kennedy Center", # FIX THIS!
"than when we started.")
```

3. Note the code from the previous question (computing the net change at the Kennedy Center) with two separate if statements, rather than a single if ... elif statement. Why would this be the best choice? Add a comment to bike.py to explain why it’s structured this way.

4. Let’s combine and extend the modifications that you made in the last two questions to find the **duration of the longest ride that departs from the Kennedy Center**. You’ll need to create a second variable analogous to `longestRideDuration`, which will store the length of the longest ride from Kennedy Center that you’ve encountered so far. You’ll need to update that variable at the appropriate times in the program, as we did with `longestRideDuration` — that is, whenever we encounter a ride leaving the Kennedy Center whose duration is longer than all previously encountered rides leaving the Kennedy Center. Finally, you’ll need to update this line:

```
print("The longest ride that departed from the Kennedy Center lasted ??? seconds or about ??? hours.") # FIX THIS
```

You should round the number of hours to the nearest integer.

5. Also add code to compute the *average* length of all docked-bike rides in the dataset, in minutes and fix this line:

```
print("The mean docked-bike ride lasted X minutes.") # FIX THIS
```

## Submission
You should submit your three files through the Gradescope link on Moodle for this assignment.
You are able to upload them individually to Gradescope, at which point the autograder will run and let you know if your code works correctly.
You are able to submit your code as many times as you wish before the deadline to fix any issues.
If you have questions about what the autograder is telling you is wrong, please ask!

If you have a partner for this assignment, you can indicate who they are via Gradescope, so be sure to set that up correctly and then between the two of you, you should only need to submit once.
(This is our first test of using groups with Gradescope linked to Moodle, so let me know if your score isn't showing up correctly in Moodle!)

## Grading

Your assignment will be graded using the following rubric:

| Item | Points |
| Correct coins example | 1 |
| Explanation for coins example accurate | 1 |
| Well-described coins algorithm | 4 |
| Correct answer for bike | 1 |
| Autograder tests | 4 |
| Programming style (header, comments, variable names, spacing) | 4 |