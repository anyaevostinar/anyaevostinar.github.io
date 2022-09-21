---
layout: page
title: HW3 
permalink: /classes/111-f22/hw3
---

## Logistics

This is a paired assignment, so you should complete it with your assigned partner, if you have one, via **paired programming**. 
The whole time that you are working, you should both be present and actively working on the problem at hand. 
(Two brains, one keyboard.) 
Switch off the typing duties so that you each type for roughly half of the time. 

You are able to get help from many sources as detailed in the [collaboration](collaboration) policy.

This assignment is due on Wednesday Oct 5th at 10pm. 
As with all assignments, you will have the opportunity to revise this assignment individually based on the feedback that you get.

## Goals
Demonstrate your understanding of conditionals and iteration to solve problems and write well-structured code.

## Setup

Again, I recommend you complete the programming portion in Olin 310. 

[Mount the COURSES drive](https://wiki.carleton.edu/pages/viewpage.action?spaceKey=carl&title=CS+111+and+201+workflow+in+CS+labs) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HW3`
* Open your `HW3` folder in VSCode
* Create a file `writeout.py`
* Download the two starter files from Moodle (`bike.py` and the CSV file) and put them into your folder

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

3. Note the code from the previous question (computing the net change at the Kennedy Center) with two separate if statements, rather than a single if ... elif statement. Why would this be the best choice? Add a comment to `bike.py` to explain why it’s structured this way.

4. Let’s combine and extend the modifications that you made in the last two questions to find the **duration of the longest ride that departs from the Kennedy Center**. You’ll need to create a second variable analogous to `longestRideDuration`, which will store the length of the longest ride from Kennedy Center that you’ve encountered so far. You’ll need to update that variable at the appropriate times in the program, as we did with `longestRideDuration` — that is, whenever we encounter a ride leaving the Kennedy Center whose duration is longer than all previously encountered rides leaving the Kennedy Center. Finally, you’ll need to update this line:

    ```
    print("The longest ride that departed from the Kennedy Center lasted ??? seconds or about ??? hours.") # FIX THIS
    ```

    You should round the number of hours to the nearest integer.

5. Also add code to compute the *average* length of all docked-bike rides in the dataset, in minutes and fix this line:

    ```
    print("The mean docked-bike ride lasted X minutes.") # FIX THIS
    ```


## Writeout

One apparently trivial — but, in fact, fairly daunting - task in any language-oriented automated system (e.g., Siri or Alexa) is to figure out how to pronounce abbreviations. 
Go ahead, try it for yourself! 
Pronounce the following fake mailing address:
```
Dr. Steven E. St. John
123 E. 1st St.
Missouri St. University
St. Louis, MO
```

How did you decide on a pronunciation for each one of those “St."s? You were using a lot of common sense and context to say “saint”/”street”/”state”/”saint” – and common sense and context are hard to define well enough to put into code. In this assignment, you'll get to work on one small piece of this kind of puzzle, focused on pronouncing numbers.

### The Task
In your file `writeout.py` write a program that does the following:
* Prompts the user to enter an integer between 1 and 999
* Prints that number in words.

Use the following specific format:
```
Enter a number between 0-999: <user input>
Your number is pronounced: <pronounciation>
```

Here are a few examples:
```
Enter a number between 0-999: 229
Your number is pronounced: two hundred and twenty-nine
```

```
Enter a number between 0-999: 3
Your number is pronounced: three
```

```
Enter a number between 0-999: 400
Your number is pronounced: four hundred 
```

In writing your program, try to make your life easier by avoiding excess duplication of code. 
For example, you might want to use the following steps to produce your output:
1. Figure out whether there is a hundreds digit or not.
    * That is, is the number greater than or equal to 100? If so, figure out what that digit is. (Perhaps consider how integer division and modulus (%) could help you out.) Then figure out how to render it in text.
2. Figure out whether you should output the word "and".
    * The answer is yes if you're outputting both a hundreds digit and something after the hundreds digit.
3. Figure out whether you're outputting a word for the tens digit.
    * Teens may be a hassle.
4. Figure out whether you're outputting a hyphen after the tens digit.
5. Figure out whether you're outputting a ones digit.

Another hint that will make your life easier: take a look at Section 5.3 of Zelle. You will also find code like the following helpful:
```
digits = ['', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
decades = ['', '', 'twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety']
print(decades[4], digits[5]) # Notice how this prints "forty five", due to clever list construction
```

In the past, students have sometimes over-complicated this program. 
You can solve this problem with about 40 lines (including blank lines and comments), so if you are going beyond that, you should think about how you can simplify.


## Assessment
To **demonstrate proficiency**, your programs need to:
* Pass all the tests in Gradescope 
* Contain descriptive headers
* Contain an answer to Bike question 3 that demonstrates proficient understanding of conditional structures
* Not have an excessive amount of duplicated code

To **demonstrate mastery**, your program needs to demonstrate proficiency as well as having:
* Useful comments
* Descriptive variable names
* Good spacing
* Use iteration and conditionals to prevent any unnecessary duplication of code