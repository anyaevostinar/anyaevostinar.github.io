---
layout: page
title: Artificial Chemistry Homework Assignment
permalink: /classes/361-f26/hw-achem
---

## Logistics
This assignment is due on Sept 30th, 2026 at 10pm.
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
The goal of this assignment is to demonstrate your understanding of artificial chemistries and protocells.
You'll be making a artificial chemistry/protocell simulation with the Empirical framework.

## Setup
We'll be using the Empirical library for this assignment. I've provided a fair amount of starter code so that you can focus on implementing the functionality of the chemistry without needing to pull in a lot of physics. (You are welcome to tweak the physics if you are interested though!) 

1. Go to our [361-F26] Organization and find the `AChem-HW` repository for your account. Use `git clone --recurse-submodules [URL]` as usual.

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

5. Verify that everything is set up correctly by going back to the top level of your repository and running the `compile-run.sh` file:
```
./compile-run.sh
```
You should see yellow, purple, and green particles jittering around.


## Assignment Specification
For this assignment, you need to create a web GUI (in `AChemAnimate.cpp`) that results in a basic protocell. 

I have provided physics rules that have the particles move and respond to each other in fairly realistic ways, such that you should be able to finish the implementation for a basic protocell to emerge from a starting chemical soup.
You are welcome to change any aspects of `Physics` that you'd like, but you shouldn't need to.
You should do the following in `AChemAnimate.cpp`:

### Implement `ResolveCollisionsAndReactions`
Within `ResolveCollisionsAndReactions`, you should implement the following functionality:
* A way for substrate particles to turn into bonding particles via a catalyst
* A way for bonding particles to bond together

You can add further reactions if you'd like, but you need to have those two at a minimum.

To complete that functionality, you will want to look through and potentially change `Particle.hpp`. In particular, you may want to use:
* `GetSpecies`
* `IsColliding`
* `SetSpecies`
* `random.P(probability)`
* `CanBond`
* `AddBond()`

### Implement `DegradeAndRecycle`
Decay is inevitable! Within `DegradeAndRecycle`, implement at least one particle decaying down to a different one or disappearing all together. You can implement more than one degrading functionality, but you need to have at least one particle type undergo periodic decay.

### Exploration
There are a lot of directions you could go with this system. We don't have an easy way to collect data (yet), so you will need to just take screenshots of "typical" behavior under different conditions as your data for now. Choose one of the following experiments to implement and perform:
* Modify `theta_0` (preferred bonding angle, passed to `ApplyAngularSpringForces`) and `angular_k` (bending stiffness). Observe how vesicle size, stability, and catalyst-capture efficiency change with different angles of bonds.
* Add a fourth species, `ParasiticCatalyst`, which consumes substrate and replicates itself instead of creating more bonding particles. Under what parameters can your protocells still survive with parasite pressure?
* Add a fourth species, `ChannelBonding`, which bonds the same as `Bonding`, but actively pulls `Substrate` into the cell interior.
* Another idea! If there is another species you'd like to introduce or parameter set you'd like to explore, go for it. Just be sure to think critically about what question you are investigating, and probably check with me to make sure you are going in a good direction.

## Assessment
The **Core** requirements for this project are:
* Run and display an artificial chemistry system when the `compile-run.sh` script is run, using the web-browser, and Empirical libraries
* Have substrate convert to bonding particles
* Have bonding particles bond
* Have at least one particle decay/degrade
* Specify in a file `README.md` what particle decay you implemented and **why** you chose that functionality (this should be indicated with the `##Core` heading)

The **Advanced** requirements for this project are:
* Complete all core requirements
* Complete one of the exploration experiment implementations
* Detail in an `##Advanced` section of your `README.md`:
    1. What exploration experiment you chose, clearly detailing your question if you chose your own
    2. At least 3 screenshots of different parameter settings, along with clearly stating what parameters differed in each screen shot
    3. At least 2 paragraphs discussing what the screenshots are showing and what your results imply about protocell emergence.

## Submitting
You will submit your assignment by pushing your code to the GitHub repository that you start from.
If you are unsure how to use Git to push your code, please ask!

## Getting Help
Remember that you can and should ask for help on everything from annoying C++ bugs to Git to "is this a reasonable artificial chemistry to implement?"
The CampusWire is probably the best place to ask, as long as you don't have to share too much of your code to do so, because you'll get faster responses on average.
You are also welcome to come to drop-in hours, Lauren's help hours, and schedule a one-on-one meeting if that works better for you.

## Acknowledgements
The physics code is based off of [Evoke](https://github.com/devosoft/Evoke) and [Circle Replicators](https://github.com/amlalejini/my_empirical_examples/tree/master/simple_physics_example).
Gemini assisted with updates to older Empirical code and some of the physics implementation.

## Addendums
(Notes will go here if there are things that need to be fixed, hopefully this will remain empty!)