---
layout: page
title: Hashing Lab
permalink: /classes/201-f25/hashing-lab
published: true
---

## Goals
To *refactor* an existing codebase to use a hash table instead of a list. Along the way, you will need to think about what should be part of a hash function for a custom class and the pros and cons of different collision resolution approaches given a specific problem.

## Setup
Mount the COURSES drive and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HashingLab`
* Download the [starter code]() and put it into your lab folder
* Open your `HashingLab` folder in VSCode

## Scenario
You're starting at a new job for a shipping distribution company. Their existing tracking software keeps all the packages in a list and just iterates over it to find a package. The previous intern had an idea for improving the performance using a hash table, but they didn't get very far before they got distracted by the latest Pokemon game (can't blame them really). 

The company also had a contractor design a simulation to show how the performance of the software, but it doesn't actually work apparently.