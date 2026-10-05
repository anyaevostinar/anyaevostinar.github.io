---
layout: page
title: Reaction-Diffusion Lab
permalink: /classes/361-f26/react-diffuse-lab
---

## Goals
To see how a reaction-diffusion system can be combined with an L-system.

## Setup

* Remember to start WSL if you are on Windows
* Pull down the new `Reaction-Diffusion-System` starter code repository from the [361-F26](https://github.com/361-F26) GitHub Organization with `git clone --recurse-submodules [URL]` or `git submodule update --init --recursive` if you cloned without the recurse submodules command.
* Set up Emscripten as normal:
    ```
    cd emsdk
    ./emsdk install 3.1.49
    ./emsdk activate 3.1.49
    source ./emsdk_env.sh
    cd ..
    ```

### Running the starter
With that all in place, the starter code is functional. Check it out with:

```
./compile-run.sh
```

You should be able to see the typical L-system with a gradient traveling around the edge.

## Morphogen Sources
The functionality of the reaction-diffusion system is provided, since it's mostly just a lot of annoying PDE calculations. However, you should introduce a few more morphogen sources so that the L-system actually interacts with them. 

1. In `ReactionDiffusion.hpp`, find the `Reset` method. 
2. In that method, there is a list of lists `seed_coords` that currently has only `{0,0}` being added, hence the reaction system starting in the upper left corner and traveling around. Add another pair or two of coordinates (so that you have `{0,0},{50,20}` for example) and observe how that changes the reaction-diffusion background and the L-system's response. (If you're interested, feel free to also experiment with the `Gray-Scott` parameters in the `ReactionDiffusion` constructor.)

## Differential Development
Standard L-systems are context-free `(A -> B)`. You are going to change the L-system to be sensitive to spatial morphogen levels so that the environment dictates gene expression. 

**Your task:** Modify `ExpandAndDraw` in `RDLSysAnimate.cpp` by using `rd_grid.GetVAtCanvas(cur_x, cur_y)` to have the symbol expansion depend on the local environment state. For example, if the concentration of V is high, perhaps `F` turns into `FAF` and if its low, `F` doesn't change. `GetVAtCanvas(cur_x,cur_y)` retuns a concentration of `V` that is between 0 and 1 and takes the current x and y coordinates of the turtle.

Remember to recompile and run to see how your plant responds to the differential growth rules!

## Chemotaxis
Many plants grow towards light, but you can imagine them also growing towards nutrient in water (for aquatic plants) or toward multiple light sources, or away from something damaging. 

**Your task**: Modify `DrawSubstring` so that the angle chosen for `+` or `-` is influenced by the density of `V` at the new location. You should use `rd_grid.SampleOffset(x, y, angle, distance)` to gather data on a couple of possible angles and choose one based on the chemical densities (either aiming for higher or lower or in the middle, your choice!)

## Niche Construction
Organisms actively alter their spatial environment as they grow and move, such as fungal mycelium or slime mold path network formation. You're going to have your plant influence its environment!

**Your Task**: Use `rd_grid.DepositAtCanvas(x, y, amount)` in `DrawSubstring` to have certain characters increase or decrease the amount of `V` at the current location. Be sure to think about what differential growth rules you put in place earlier and how they will interact. For example, plants often have mechanisms where growth tips (`A`) suppress other growth around them to keep the plant from overcrowding itself.


## Submission
You aren't required to submit labs in this class, but you can for an extra engagement credit. Complete the implemention of the niche construction and differential growth and then push it to GitHub:
```bash
git add RDLSysAnimate.cpp ReactionDiffusion.hpp
git commit -m "finished niche construction"
git push
```

## Extra
There is so much more to explore! You could add additional chemicals that interact in more complex ways to start, but you can probably already think of a lot more possibilities.