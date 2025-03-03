---
layout: page
title: R/Ggplot2 Lab
permalink: /classes/361-f22/r-lab
---

## Goals
To get an introduction to using RStudio to make plots of your data.

## Exercise 0
Get the starter code through the Moodle link to the Plot Lab repository. You are welcome to complete this lab with a team member or individually.

Then get all your submodules initiated as always:
```
git submodule update --init --recursive
```

## Exercise 1
First you'll need some data to analyze. I've provided a solution to the Data Lab so that `native.cpp` actually uses the configuration settings and you'll get somewhat more interesting results.

a. Run `compile.sh` to get your executable.

b. Create a folder `Example`, where your data will go.

c. Run `python3 stats_scripts/simple_repeat.py` to get some data. Check in the `Example` folder that your data files are there.

## Exercise 2
You can turn that data into something useful in R right away, but in the interest of using Python to do more, I have a Python script called `munge_data.py` that takes each of the individual files and puts it into one file to load into R, reducing the amount of things you need to do in R. 

a. Go into the `Example` directory on the Terminal with `cd`: `cd Example`

b. Then run the munge script: `python3 ../stats_scripts/munge_data.py`. This creates a file `munged_basic.dat` in this directory, which is good for keeping things organized.

## Exercise 3
Open up RStudio (either on your laptop if you installed it or using a lab machine).

a. Within RStudio, open the file `stats_scripts/BasicStats.R`.

b. R is a language that was written by statisticians, not computer programmers, so it works a bit differently. Instead of running the whole file at once, you can run each line by having your cursor on it and typing `Cmd + Return`. (You can also run the whole file at once, but for this lab we won't.)

c. Run the two lines that start with `require`, we'll use these packages to make plots that are prettier than the basic ones.

d. In R, assignment is done with `<-` as you can see for the list of colors. The default R colors are fine, but they aren't color-blind or printer friendly, so I prefer my homebrew. (I actually use the [Viridis package](https://cran.r-project.org/web/packages/viridis/vignettes/intro-to-viridis.html) now in my own research, but we'll stick with the homebrew for the lab.) Run the `colors` line.

e. Whenever you are working in R (and therefore RStudio), you should use the `setwd` command to indicate the working directory that R should look in for the files. You should update `PATH_TO_YOUR_FOLDER` to be the path to the project folder, where ever you put it. If you aren't sure where it is, you can go in the VSCode Terminal and type `pwd` to get the path to working directory.

f. Read through the rest of the lines and comments and run them each in order to see what they do. You are welcome to just adapt these commands to suit your needs and ask me if there are types of plots that you want to do that aren't included here. You can also [explore more ggplot options](http://r-statistics.co/ggplot2-Tutorial-With-R.html) on your own if you'd like.

## Exercise 4
The main thing that you'll need to change first for your project is probably the `munge_data.py` file. Open it and note how it works and what you'd need to change to get different data from your data files. Feel free to copy it over to your project and use it.

As soon as your project is printing out some basic data, try out this work flow to get a plot, even if it isn't an interesting plot, it's still useful to see your data!