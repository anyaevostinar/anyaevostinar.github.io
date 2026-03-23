---
layout: page
title: Mergesort Lab
permalink: /classes/201-f25/mergesort-lab
---

## Set up
Follow the steps from the [Scavenger Hunt](kotlin-lab) to mount the COURSES drive. Make a folder `MergesortLab` in your STUWORK/username folder and open it in VSCode for today's labwork.

Download and copy over the [`MergesortLab.kt`](/classes/201-f25/MergesortLab.kt) starter code.

## Mergesort
Start off by implementing the recursive `mergesort`. Note that you shouldn't split the list and instead should adjust the index locations to be for smaller sublists.

Make sure that your code compiles after implementing this function, though it won't run yet.

## Merge
The real work is done in the merge step, so now implement that, following the comments.

Compile and run your code to be sure that your sorting is working.

## Extra
We don't have the tools to formally analyze the time complexity of recursive functions, but think about what you do now about the following:
* How many recursive calls will happen before the base case is reached, i.e. the depth of the recursion?
* How many comparisons happen to fill in each spot in the merged list at a single "level" of the merging?
* How can you put those two pieces of information together?