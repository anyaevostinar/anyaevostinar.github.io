---
layout: page
title: L-Systems Assignment
permalink: /classes/361-f26/hw-lsys
---


**In progress still**

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

## Assignment Specification

For this assignment, you will create a web GUI (in `LSysAnimate.cpp` within the new `LSystem-HW` repo on our [361-F26](https://github.com/361-F26) organization) that simulates procedural plant growth and biological morphogenesis using Lindenmayer systems. I've provided the string-rewriting engine and turtle stack vector math for you so that you can focus on coming up with a grammar and expanding the complexity of the states and visualization (i.e. the fun stuff!).

Complete the following in `LSysAnimate.cpp`:


### Multi-State Grammar Design 
The starter code has a method `SetupGrammar` that specifies a rather boring set of axiom and rule. 

**Your task:** Design an L-system grammar with at least **three distinct** symbol types representing different cell/tissue states (e.g., Vegetative Stem `F`, Active Apical Meristem `A`, Dormant Bud `B`, Terminal Leaf/Flower `L`, etc.). Make sure to have some general coherence to the resulting pattern (which might take some experimenting).

**Report:** Take screenshots of your resulting plant and discuss (2-3 sentences) how the different symbols are used to grow the plant.

### Tissue Maturation
In real organisms, tissue properties (thickness, color, flexibility) change as cells age and differentiate. The method `GetTissueProperties` is called to determine the thickness and color of a given stem. It has access to the parameters `branch_depth`, i.e. where this current branch is on the plant, and `current_depth`, i.e. how many iterations have happened so far overall. 

**Your Task:** Add at least one customization (color or stem thickness) based on depth/age of the branch. The color can be string words or hex, so feel free to get creative!

### Specialized Cell Rendering 

As you read, L-system symbols don't have to be just lines, they can also represent specialized organs. The method `DrawSpecializedSymbol` is called whenever a symbol other than `F + - [ ]` is encountered. 

**Your Task:** Implement `DrawSpecializedSymbol()` to define unique visual rendering for non-stem symbols (e.g. the `A` buds, flowers, or something else entirely).


### Exploration

As before, there are a lot of further extensions possible! You should again take screenshots of typical "behavior".


Options:
* Modify `angle_rad` and `step_decay` across multiple runs while holding your grammar rules constant. Observe how changing geometric parameters shifts your organism along a spectrum from a tall, narrow canopy to a dense, space-filling shrub. How do these parameters affect branch self-overlapping and light/space capture?
* Modify `Expand()` to use `emp::Random` for probabilistic rule selection (e.g., $70\%$ chance for symmetric branching $A \to F[+A][-A]A$ and $30\%$ chance for asymmetric branching $A \to F[+A]A$). How does developmental noise affect the visual realism, symmetry, and structural variance of your organisms?
* Introduce an environmental bias vector (such as gravitropism pulling branches down or phototropism pulling stems straight up) into the turtle traversal. How does an external force interact with an organism's strict genetic rules to produce adaptive, flexible body shapes?
* Introduce a branch depth limit or string length cap that stops expanding or actively prunes older inner branches (simulating light loss in dense inner canopies). How does self-pruning change the macro-shape of mature organisms compared to unconstrained exponential growth?
* Another Idea! If there is another parameter set, environmental feedback, or biological mechanism you'd like to explore (e.g., root/shoot double-ended growth, vascular scaling via Murray's Law), go for it! Just check with me first to make sure your question is well-scoped.

## Assessment

### Core Requirements
The Core requirements for this project are:
* Run and display an L-system growth visualization when compiled and run in the web browser using Empirical libraries.
* Implement a multi-state biological grammar in `SetupGrammar()` with at least 3 distinct cell/tissue symbol types.
* Implement dynamic tissue property mapping (lignification tapering or tissue maturation coloring) inside GetTissueProperties().
* Implement custom rendering logic for specialized terminal symbols/organs in DrawSpecializedSymbol().
* Specify in a file README.md under a `## Core`:
    * Your production rules and axiom.
    * What each symbol in your grammar represents biologically in your organism (with screenshots)
    * The mathematical or logical rules you used to map tissue depth to stem thickness and color transitions.
    
### Advanced Requirements
The Advanced requirements for this project are:
* Complete all core requirements.
* Complete one of the exploration experiment implementations.
* Detail in an `## Advanced` section of your `README.md`:
    * What exploration experiment you chose, clearly detailing your question if you chose your own.
    * At least 3 screenshots of different parameter settings, rule variants, or environmental conditions, along with clearly stating what parameters differed in each screenshot.
    * At least 2 paragraphs discussing what the screenshots show and what your results imply about procedural growth, genotype-to-phenotype mapping, and the dynamics of biological development.