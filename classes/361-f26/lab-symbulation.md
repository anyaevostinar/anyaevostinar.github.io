---
layout: page
title: Symbulation Lab
permalink: /classes/361-f26/symbulation_lab
---

## Goals
To get familiar with Symbulation's sgp-mode and be prepared to start the assignment.

## Setup
You'll be working directly in your repository for the [Digital Evolution](hw-de) assignment, so hopefully you already have it cloned down. If not, go through the set up steps in there.

## Exercise 1
Adding a task to Symbulation is similar in idea to the SGP-Lite lab, though the specific syntax surrounding the logic is slightly different.

1. While you could make a new task set, it's easiest to just add to the `LogicTaskSet` and fine to do so for this assignment. Open up `source/sgp_mode/tasks/LogicTaskSet.h` and find the set `predefined_tasks`.

2. You can see that these tasks are still taking in `inputs` and returning a `uint32_t`. For organization sake, the existing task logic is all defined in `boolean_logic_impls.h`, and you could add yours there, but you can also just have it right in place here. **Copy one of the existing tasks and change it to be called SQUARE**. 

3. Instead of returning the result of calling the logic function, change to returning `inputs[0] * inputs[0]`. (The task infrastructure handles rotating through the possible inputs, so you don't have to worry about that, you just have to define the task for one input value. It also handles making sure that 0 doesn't solve the task.)

4. While you can make a new task environment configuration file, it'll be easiest for now to change the the one currently being used in `default-config-jsons` to include your new  SQUARE task. Give it whatever reward you want!

5. Make sure that your code runs in the terminal version by running `make sgp-mode` and then `./symbulation_sgp`. Check in `Data/Tasks_data.csv` and make sure that your new task has a column showing. 

## Exericse 2
Let's have your new task show up in the GUI.

1. Open `web/SGPSymAnimate.h`. 

2. Edit `task_map` and `matchColor` to have your task show a new color

3. Make sure you can compile and see your new task with `./compile-run-web.sh`

## Exercise 3
You can also add new events to Symbulation.

Follow [this guide](https://github.com/anyaevostinar/SymbulationEmp/blob/doc-event-type.md/docs/QuickStartGuides/5-Events.md) section to create an event that just prints out "Event happened!" every 100 updates.

Remember to compile and run to make sure that your event is working as expected.

## Exericse 4
Work through the [Collecting and Analyzing](https://symbulation.readthedocs.io/en/latest/QuickStartGuides/2-CollectingData.html) sections of the Quickstart guides for some data in your files. You'll need to update the scripts in the `stats_scripts` folder to work for some data that you have. I recommend analyzing the file `CurrentUpdateInfo_data.csv` and the 1th column `host_mean_generations` just to get used to plotting data.

## Keep going
You're pretty well set to explore different functionality and make progress on the homework. In class is a great time to ask about specific functionality that you are interested in!