---
layout: page
title: Artificial Chemistry Lab
permalink: /classes/361-f26/achem-lab
---

## Goals
To get more familiar with Empirical and make a two-atom chemistry.

## Setup

* Remember to start WSL if you are on Windows
* Pull down the new `A-Chem-Lab` starter code repository from the [361-F26](https://github.com/361-F26) GitHub Organization with `git clone --recurse-submodules [URL]` or `git submodule update --init --recursive` if you cloned without the recurse submodules command.
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

You should be able to see some teals atoms jittering around.

## Bonds (forming and breaking)
As you know, most interesting chemical things happen through particles bonding and breaking apart. 
I've provided you with most of the logic needed to manage bonds already in `Particle.hpp`:

* `CanBond()` -> says whether the particle is able to form a new bond
* `IsBondedWith(size_t other_id)` -> checks if the two particles are bonded
* `AddBond(size_t other_id)` -> checks if the bond is allowed and adds it if so
* `RemoveBond(size_t other_id)` -> removes given bond if it exists
* `ClearBonds()` -> clears all bonds for a particle

In the main animator, there is also `ApplySpringForces` which makes any bonded particles pull/push on each other based on the `spring_constant` at the top of the class. You don't need to edit any of this stuff, but you can if you want to.

1. Your first actual task is to make a bond form when two particles collide. The collision logic is handled in `ResolveCollisionsAndReactions`. Add to this method to add a bond to any two colliding particles. You'll also need to increase the value for `max_bonds` found in `Particle.hpp`. Make sure to then run `./compile-run.sh` to see your mass of bonded particles form! 

2. Generally, particles aren't stuck together forever if they bond. While the breaking of a bond could be due to outside factors, it's easiest (and reasonable) to have bonds just decay naturally. Implement that with the following steps:
    1. Create a new variable at the top of the class to capture the probability that a bond breaks.
    2. Make a new function to go through all the particles and break some of their bonds on that probability (remember you can use `random.P(value)` for this).
    3. Call your function in `DoFrame` near the other processing functions.
    4. Compile and run again to see how it looks. You may want to try out a few different probabilities to try to find one where there is a nice mix of bonded and unbonded particles at once, or perhaps even some nice rings forming! Feel free to try out different values for the other parameters as well.

## Making More Elements
To have interesting chemistry, you need more than one element. While you could do this with inheritance, your particles will be switching their element frequently, and making new objects for each reaction isn't computationally efficient. Instead, you could use just basic numbers or strings. However, numbers are hard for humans to remember and strings are inefficient to compare. C++ (and other languages) has a solution to this in the form of an enumerator. In `Particle.hpp` you'll see:

```cpp
enum class Species {
    Substrate
};
```

This `enum` is where you will add more "species" i.e. types of particles/elements.

We know that a main difference between different atoms is what bonds they can make. Try out having one particle type that can make 2 bonds and one particle type that doesn't make any bonds. The one that doesn't make bonds should really be called `Substrate`, so you might need to switch up behaviors and labels. Here are a few things to remember to do:
* Add to `GetColor` to be able to tell the difference between the species
* Make sure that the bonding methods work correctly for each species' behavior
* Make sure to generate some amount of each particle species in the initial set up

Be sure to compile and run to see your chemical soup! And feel free to add more species at this point if you want.

## Reactions
A key aspect of chemistry is that reactions occur and turn particles from one species into another. It's time for you to add reactions! 

1. Some reactions can happen spontaneously, so we'll focus on that first. Change your code so that any "bonding" species particle that isn't actually bonded has a chance of randomly decaying to a non-bonding particle. You'll probably want the following:
    1. A new variable for the probability of bonding-particle decay.
    2. Adding to your code a check for if a bonding-particle doesn't have any bonds that uses `random.P` to probabilistically decay it (you probably want this somewhere that you are already checking the bonds of each particle to reduce the number of loops you need to do).
    3. Remember to compile and run to see what happens! You may notice that your system doesn't seem very stable at this point....

2. Some reactions can happen spontaneously but happen much more quickly/easily with a catalyst particle (or energy). Create a new catalyst species that changes your non-bonding particles to bonding particles on collision. You'll need to add to your code in various places and remember to compile and run. 

## Submission
You aren't required to submit labs in this class, but you can for an extra engagement credit. Complete the implemention of the three particle system and then push it to GitHub:
```bash
git add AChemAnimate.cpp Particle.cpp
git commit -m "finished three particles"
git push
```

## Extra
There are a lot more aspects of chemistry that you can play around with including:
* Having smaller energy particles in the system that are required or released by bonds or reactions
* Having more methods of particle generation/replication/decay/spontaneous generation
* Having the temperature influence decay, reaction, or bonding rates
* More particles with different behavior, more bonds! Allowing particles of different species to bond with each other!