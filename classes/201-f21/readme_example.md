---
layout: page
title: README Example
permalink: /classes/201-f21/readme_example
---

(Note, this README is formatted using Markdown, but you can format it with any rich-text program such as Word or Google Docs. 
You should make sure that it is nicely formatted though, not just plain text.)

## Overview
The Dragon Item Program contains a catalog of all of Dr. Anya Vostinar's dragon-themed items.
It provides information about the various items and allows the entry of new items when Anya gets more dragons (which is a regular occurence).
With this program, you can:

* Find out how many dragon-themed items Anya has currently
* Get a list of all items in Anya's collection
* Get more information about specific items in Anya's collection

## Usage
To use the Dragon Item Program, run the following after downloading the code:
```
$ javac *.java
$ java DragonItem mode
```
where `mode` is which mode you would like the program to run in. 
The options are `pirate` and `dragon` and will determine whether the program writes to you in pirate voice or dragon voice.

The program will then ask you what you'd like to do:
```
$ javac *.java
$ java DragonItem dragon
Welcome mortal, would you like to browse the collection or enter a new item? (browse/new)
$ new
Acceptable, what is the name of the new item?
$ 2021 Notebook
Wonderful, what is the description of the new item? Be sure to mention the dragon-related aspects, they are all that really matters after all....
$ Lined notebook with purple dragon on the cover, sitting on a stack of books and sipping coffee
```

## Rubric
Here I discuss how my project meets each of the rubric requirements and respond to the HW1 prompt.

### Compiles without warnings and runs
When my code compiles, it does not produce any warnings and it runs in each mode.
This can be seen by running the following:
```
javac *.java
java DragonItem dragon
```
and
```
javac *.java
java DragonItem pirate
```

### New class created correctly
The class that I created is called `DragonItem`. 
It is defined in the file `DragonItem.java`.

#### Prompt Response
The class is created correctly because (you should fill this in, I just don't want to give it away).

### Private variable used correctly
I use several private variables, but I will focus on the `name` variable of the `DragonItem` class. 
It is declared on line 7 of the `DragonItem.java` file and used by the method `getName` and `setName` of the `DragonItem` class.

To see an example of the `name` variable being used, run these commands:
```
Code example here
```

#### Prompt Response
It is appropriate to use a private variable for this task because....

### Class variable used correctly
I declare a class variable `count` in the `DragonItem` class:
```
private static count = 0;
```
I use this variable in `getCount` and the constructor for the `DragonItem` class. 

To see this variable being used, run these commands:
```
Code example here
```

#### Prompt Response
This is an appropriate use of a class variable because....

(You should have a similar heading for each rubric item)