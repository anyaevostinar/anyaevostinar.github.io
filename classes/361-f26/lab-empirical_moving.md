---
layout: page
title: Moving Organisms Lab
permalink: /classes/361-f26/moving_lab
---

## Goals
To enable organisms to move around in an Empirical world to accomplish a swarming task.

## Setup

* Remember to start WSL if you are on Windows
* Pull down the new `MovingOrgs-Lab` starter code repository from the [361-F26](https://github.com/361-F26) GitHub Organization with `git clone --recurse-submodules [URL]` or `git submodule update --init --recursive` if you cloned without the recurse submodules command.
* Set up Emscripten as normal:
    ```
    cd emsdk
    ./emsdk install 3.1.49
    ./emsdk activate 3.1.49
    source ./emsdk_env.sh
    cd ..
    ```

## Running web GUI
Start the web GUI starter code running with `./compile-run-web.sh` and you should see a grid of yellow circles with a little black square hiding somewhere.

## Exercise 1

You'll start by making your organism move around the world. Empirical doesn't actually support moving organisms very well, so I provided a `MoveOrganism` method already in `World.h`. Empirical does provide a very useful `GetRandomNeighborPos(i)` that will return a neighboring world position based on the structure already set for the world.

**Your task:** Use those two methods to have your organism run around the world randomly by editing the `Update` method in `World.h`. Make sure to compile and run to see the little critter go!

## Exercise 2

As you read, a basic algorithm that allows a single ant to build a heap of sand particles is the following:
* If it finds a grain and it's not already holding one, pick up the grain and move randomly
* If it finds a grain and it is already holding another one, drop the grain and move randomly
* Otherwise, move randomly

Implement this algorithm in `Org.h`. You can access the world's methods through the `world` variable. Make whatever changes are needed in `World.h` as well. Remember to compile and run the web version to see the ant forming a heap!

## Exercise 3

Part of the point of this algorithm is that it works with just one ant or multiple. Edit `MoveOrganism` in `World.h` to have ants avoid colliding with each other and `web.cpp` to introduce more ants. Make sure your small colony is now even better at building a heap!

## Submission
You aren't required to submit labs in this class, but you can for an extra engagement credit. Complete through exercise 3 and then push it to GitHub:
```bash
git add World.h web.cpp Org.h
git commit -m "finished basic heap-building"
git push
```

## Extensions
If you have extra time, there are a lot of expansions to the system that you could try:
* Add in a config panel and data collection to the native mode to quantitatively see how well the ant it doing. What data do you need to output?
* Have the ants use up energy points and need to rest or eat
* Have the ants respond to each other by more than just not colliding, perhaps following?
* Introduce another type of ant (via another class) that follows a different algorithm to see how much it messes things up