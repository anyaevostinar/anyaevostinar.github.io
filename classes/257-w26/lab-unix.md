---
layout: page
title: Unix Scavenger Hunt
permalink: /classes/257-w26/unix-scavenger-hunt
---

## Goal
The purpose of this scavenger hunt activity is to give you some additional practice working with Unix commands and a bit with the vi/vim editor and to help make you more comfortable working with a Unix command line.

## Setup
You should complete this lab on your own computer.

You can and should consult with your neighbors if you get stuck at any point in this activity! (And of course raise your hand and ask for help!)

Note that generating the clues takes a few seconds, but shouldn't take more than a minute or two, so if it is hanging, ask for help or kill it and try again.

## First though
If you didn't finish the Laptop Setup portion of the [Getting Started](getting-started) lab, you need to do that first.

## Unix Scavenger Hunt
This activity uses a Git repository. We'll discuss what those are and what is going on with them next week, but in the mean time, open a Terminal and do the following.

1. Make sure you are at your top level directory within your Unix environment:
```bash
cd ~
```

2. Then get the scavenger hunt:
```
git clone https://github.com/acdalal/scavenger-hunt.git
cd scavenger-hunt
```

Then take a look at the file `README.md` either in the folder you've created or [here](https://github.com/acdalal/scavenger-hunt/blob/master/README.md) and follow the steps there (you shouldn't need to install git though).

## Q&A
A few things seem to go wrong for some people, so things to keep in mind:
* If you don't have `words` and `ispell` doesn't work, try just installing `words` or `wamerican`
* Remember that you need to include your secret number and the next clue number for each `next_clue` call
* Remember that you should put all your hints in " "

## Extras
If you finish the scavenger hunt before the end of class (congrats!), you should either keep working on refreshing on Python (possibly by solving the lab activities linked from the [Getting Started Lab](getting-started)), keep working on your team proposal, or start on the [preparation for Wednesday](git-prep).