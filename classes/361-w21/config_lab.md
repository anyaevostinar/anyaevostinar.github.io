---
layout: page
title: Empirical Config Lab
permalink: /classes/361-w21/empirical_config_lab
---

## Goals
To get started on your term project by setting up the configuration manager.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Wednesday Feb 10th, but it isn't due until Friday Feb 12th at 5:00pm Central.

## Setup
If you haven't already, open the appropriate starter project for your term project. If you already started it, open that Repl.it. If you have a partner, make sure that the group feature is working correctly, ie you both are looking at the same code and can see each other's changes.

## Exercise 1
(If you are using Symbulation as your base, skip this one)

Follow the reading on how to set up a config object. 

## Exercise 2
Add the functionality that if the file doesn't already exist, the program creates the default file.
```
bool success = config.Read("MySettings.cfg");
if(!success) config.Write("MySettings.cfg");
```

## Exercise 3
Hopefully you already have an idea of variables that you will want to change the value of to determine their effect on something for your project. Add these to your configuration file, even if you aren't able to use them yet.


## Exercise 4
A common idea I've heard from you all is starting off holding a trait constant at some value and then letting it evolve in subsequent experiments. If that is something you are planning to do, do this exercise, otherwise, you are welcome to skip it.

You can accomplish this feature easiest if there is a starting value that wouldn't be valid for the trait and then a configuration file setting of that invalid setting indicates that it should be allowed to evolve. 

For example, if I had a trait that is a probability so it can only be between 0 and 1 (where 0 is 0% chance and 1 is 100% chance), I could treat any negative value as an indication that the trait should be allowed to evolve. You could have this as two separate but dependent configuration options, but that is asking for trouble and confusion (trust me, I've done it).

Set up such a configuration setting in your config object now, even if you aren't ready to use it yet.

## Exercise 5
Set up the ability for command line arguments to override your configuration settings and verify that it works.

## Exercise 6
You hopefully have an idea of the first configuration setting that you are going to chance to see its effect. Use what you know from the DataFiles lab to make a non-functioning DataFile and set its name based on the random seed and at least one of your configuration settings and verify that it works.

## Submitting
