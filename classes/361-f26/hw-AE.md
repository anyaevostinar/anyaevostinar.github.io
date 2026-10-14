---
layout: page
title: Artificial Ecologies Homework Assignment
permalink: /classes/361-f26/hw-ae
---

## Logistics
This assignment is due on Oct 28h, 2026 at 10pm.
As with all assignments, you will have the opportunity to revise this assignment based on the feedback that you get.

## Collaboration policy

For this assignment, you may discuss the assignment at a high level with other students, however you must type up all of the code yourself.  (It is therefore unexpected for two code submissions to be completely identical.)  You can discuss the assignment with Anya, our course staff, or any lab assistants.  

You should list any student or course staff with whom you discussed the assignment and the manner of discussion in your `README.md` file.

## AI policy
As discussed in the syllabus, there are both acceptable and unacceptable uses of genAI in this class. **Regardless of whether you use any genAI, you need to complete the** `AI Log` in the `README.md` to satisfy the advanced requirement.

If you choose not to use genAI at all, you may state that for your AI Log (and I fully support this choice). I'd be interested in your reasons, though it's not required to write them in the log for every assignment.

If you do choose to use genAI, you should log it in the `AI Log` section of the `README` in the following format:
* Date: Summary of use and assessment of usefulness

For example, a hypothetical log could be:
* 8/25/26: I asked Gemini how to do default values for a constructor and it helped me figure it out
* 8/26/26: I couldn't figure out the problem with the `ApplyLinearSpringForces` method and Gemini was completely useless
* 8/26/26: I googled the problem with the `ApplyLinearSpringForces` and the AI summary was helpful

This log requirement is both to give me an idea of how useful genAI is in this context and to make sure that your learning isn't being hampered. As mentioned in the hypothetical log, you should include any genAI resources that you use, even the AI summary shown in search results or GitHub Copilot (which shows up as autocomplete in VSCode now).

## Goal
The goal of this assignment is demonstrate your understanding of artificial ecologies. 
You'll be making an artificial ecology that runs in the web browser, [like my example here](https://anyaevostinar.github.io/AE-Assignment/).

## Setup
We'll be doing our usual setup:

1. Go to our [361-F26] Organization and find the `AEco-HW` repository for your account. Use `git clone --recurse-submodules [URL]` as usual or `git submodule update --init --recursive` if you cloned without the recurse submodules command.

3. Then, go to the `emsdk` folder and install and activate `emsdk`:
```
cd emsdk
./emsdk install 3.1.49
./emsdk activate 3.1.49
```

4. Then source `emsdk`. You'll need to do this command anytime you open a new Terminal, so if you are getting an error about `emcc` not existing, you probably forgot to do this:
```
source ./emsdk_env.sh
cd ..
```

5. Verify that everything is set up correctly by going back to the top level of your repository and running the `compile-run-web.sh` file:
```
./compile-run-web.sh
```
You should see a green field with one little black square in the upper corner along with a configuration panel.

6. You will also do a command-line version of this project, so make sure that runs as well with the `compile-run` command that is appropriate to your operating system (either `compile-run-mac.sh` or `compile-run-linux.sh` since WSL is Linux). You should see the updates printing to your Terminal.


## Assignment Specification
For this assignment, you need to add on to the code that I've provided so that, when the `compile-run-web.sh` file is run, an artificial ecosystem runs in the browser. In addition, when `compile-run-mac.sh` (since I run on Mac) is run, relevant data about your system is output.
This will require you to write code for your world, data, organisms, and interactions between organisms.
This is purposefully open-ended, so that you can make a system that is of interest to you!

### Implement Two (or More) Species
You need more than one species for an ecology. 
You'll need to decide on what kind of ecological interaction you want between your species and then expand on the `Organism` and `AEWorld` classes to implement the important behavior of each species. 
You could use inheritance for subclasses, but it ends up often not actually saving you much since you need to do so much of the organism interaction within your `World` subclass, so I recommend just using a variable in `Organism` to indicate species 1 or species 2 (you could also use an `enum` like from the artificial chemistry assignment!).

### Visualize Your Species
You'll need to update the drawing of organisms in `AEAnimate.cpp` so that your species are visually distinct. You could do a lot of different things, but they should at least be different colors. 
**Make sure to explain in your README Core section what the colors mean, along with any other visualization choices you make.**

### Output Data
Your command-line version needs to output relevant data about your populations. At a minimum, that should be the counts of each species, but definitely include any other data you'd like as well.

### Stability Exploration
The most interesting questions about ecosystems generally focus on their stability (or lack thereof). You should explore what parameter settings are necessary for your ecology to achieve stability. Specifically, you should have **default settings** that result in persistence of at least two species for a reasonable amount of time (obviously we can't test if they will persist forever, but I should be able to run your simulation for a minute or two and still see two species). You can have some of these things controlled by the configuration panel to make your exploration easier, but make sure to update the default values so that I see the stabilty immediately.

**Your task**: Once you have found stable parameter values, you should output data from your native command-line version. You should include at least three plots in your README report that include one stable version of parameters and two ways where the parameters lead to lack of stability. In your README you should then discuss (at least two paragraphs) the impacts of those parameters and why they have those impacts.

## Assessment

The **Core** requirements for your submission are:

* Run and display an artificial ecosystem with at least two species of organisms when the `compile-run-web.sh` script is run, using the web-browser and Empirical library
* Run and produce count data about your ecosystem when `compile-run-mac.sh` is called
* Specify in the `README.md` what your two species of organisms are, how they interact with each other, and how you visualized them

The **Advanced** requirements are:
* Complete the core requirements
* Have default settings that result in persistence of at least two species for a reasonable amount of time (obviously we can't test if they will persist forever, but I should be able to run your simulation for a minute or two and still see two species)
* Included the Advanced section of your README:
    * A plot of organism counts over time when the ecosystem is stable
    * Two plots where a parameter setting changes and leads to instability (one parameter changed per plot)
    * At least 2 paragraphs discussing what the plots are showing and what your results imply about ecosystem stability

## Submitting
Submit your code to GitHub with the usual add/commit/push steps. Then tag your most recent commit with the following:
```
git tag -a initial_submission -m "initial submission"
git push origin initial_submission
```

## Getting Help
Remember that you can and should ask for help on everything from annoying C++ bugs to Git to "is this a reasonable artificial ecosystem to implement?"
The CampusWire is probably the best place to ask, as long as you don't have to share too much of your code to do so, because you'll get faster responses on average.
You are also welcome to come to drop-in hours, and schedule a one-on-one meeting if that works better for you.
