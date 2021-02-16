---
layout: page
title: R/Stats Lab
permalink: /classes/361-w21/r-lab
---

## Goals
To get an introduction to using RStudio to make plots of your data and do a basic non-parametric test.

## Logistics
You won't actually hand anything in for this lab.

## Exercise 0
On Mantis, go back into your `teaching-alife` git repository and type `git pull` to get the changes that I've added. If it says that you can't because of changes you've made to files, go through for each file that it says has conflicts and type:
```
git checkout -f filename
```

This will overwrite changes that you made to these files, so if you want to keep them, you should rename them first:
```
mv fileToChange newName
```

Use the `git pull` command again to make sure you have the things I've added. Don't proceed until you get the message `Already up to date`.

## Exercise 1
First you'll need some data to analyze. I updated the `native.cpp` so that it actually uses the configuration settings and so you'll get somewhat more interesting results.

a. Run `make` since I've changed `native.cpp`

b. Make sure you have a folder `Example` and if not, type `mkdir Example`

c. Run `python stats_scripts/simple_repeat.py` to get some data

## Exercise 2
You can turn that data into something useful in R right away, but in the interest of using Python to do more, I have a Python script called `munge_data.py` that takes each of the individual files and puts it into one file to load into R, reducing the amount of things you need to do in R. 

a. Go into the `Example` directory on the Console with `cd`: `cd Example`

b. Then run the munge script: `python ../stats_scripts/munge_data.py`. This creates a file `munged_basic.dat` in this directory, which is good for keeping things organized.

## Exercise 3
Mantis doesn't actually have R installed, so you'll need to open another browser and navigate to `maize.mathcs.carleton.edu` and log in with your Carleton username and password. 

a. You should now have an RStudio window in front of you. You'll see that the files sync between Mantis and Maize, which is quite useful. Open the `teaching-alife` folder and then the `stats_scripts` folder and then the file `BasicStats.R`.

b. R is a language that was written by statisticians, not computer programmers, so it works a bit differently. Instead of running the whole file at once, you can run each line by having your cursor on it and typing `Cmd + Return`.

c. Run the two lines that start with `require`, we'll use these packages to make plots that are prettier than the basic ones.

d. In R, assignment is done with `<-` as you can see for the list of colors. The default R colors are fine, but they aren't color-blind or printer friendly, so I prefer my homebrew. Run the `colors` line.

e. Read through the rest of the lines and comments and run them each in order to see what they do. You are welcome to just adapt these commands to suit your needs and ask me if there are types of plots that you want to do that aren't included here. You can also [explore more ggplot options](http://r-statistics.co/ggplot2-Tutorial-With-R.html) on your own if you'd like.

## Exericse 4
The main thing that you'll need to change first for your project is probably the `munge_data.py` file. Open it and note how it works and what you'd need to change to get different data from your data files (sorry that it's a bit messy!). Feel free to copy it over to your project and use it.

As soon as your project is printing out some basic data, try out this work flow to get a plot, even if it isn't an interesting plot, it's still useful to see your data!