---
layout: page
title: Digital Evolution Homework Assignment
permalink: /classes/361-f26/hw-de
---

## Logistics
This assignment is due on Nov 6th, 2026 at 10pm.
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
The goal of this assignment is to demonstrate your understanding of digital evolution and work within a full artificial life research software project.
You'll be expanding a digital evolution project that runs in the web browser and command-line using the Symbulation platform, which is built with the Empirical and SGP-Lite frameworks.

## Setup
You'll be working in your own copy of the Symbulation software for this project. I've provided that copy for each of you along with a couple of scripts to help make things easier. You are welcome to tweak other aspects of the software, but there is a lot so definitely don't try to look through it all!

Symbulation has [extensive documentation](https://symbulation.readthedocs.io/en/latest/) along with [Empirical's documentation](https://empirical.readthedocs.io/en/latest/index.html), and I recommend you take advantage of the search functionality of both.

1. Go to our [361-F26](https://github.com/361-F26) Organization and find the `Symbulation` repository for your account. Use `git clone --recurse-submodules [URL]` as usual.

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

5. Verify that everything is set up correctly by going back to the top level of your repository and running the `compile-run-web.sh` file (there will be a lot of warnings, don't worry about them):
```
./compile-run-web.sh
```

## Supplemental info
As you are working on this project, you may find the supplemental material section F of [this paper](https://mmore500.com/pubs/moreno2021case) a helpful reference for what operations are available and what they do, as well as the [SGP-Lite lab](sgplite_lab).

## Assignment Specification
For this assignment, you will expand on the Symbulation starter code that is provided by implementing additional tasks and conducting experiments.

### Tasks
First, you should add at least two tasks to the `predefined_tasks` set in `source/sgp_mode/tasks/LogicTaskSet.h`. You will also need to edit `default-config-jsons/diff-reward-env.json` to include your new tasks. You may choose to remove any of the existing nine if you wish as well, or you can just add on.

Then, you need to edit `web/SGPSymAnimate.h` `task_map` and `matchColor` (or other places if you prefer) to visually show your tasks and report in your `README.md` which tasks you implemented and how you are visually representing them. You should be sure that they show up within a reasonable amount of time in the viewer.

### Basic Experiment
Now that you have your new tasks implemented, you should explore one of the existing settings/options and find two values of the setting that lead to your new tasks being more or less likely to evolve (you don't need to conduct rigourous statistics, but there should be a noticable difference between experiments). You can conduct your initial exploration with the web GUI by removing the relevant `ExcludeGroup` or by running in the command line and looking at the `Data/Tasks_data.csv` file.

Once you've found a setting/option that changes the evolution of your task based on its value, you should **run experiments with at least 5 different random seeds for each** and report your results in the core section of your README. You may either just include the raw numbers or you may plot your data using whatever plotting software you are comfortable with.

Here are some ideas for settings/options that are likely to influence the evolution of your tasks at different values (remember that you can see all possible settings by looking in the files `source/sgp_mode/SGPConfigSetup.h` and `source/ConfigSetup.h`):
* HOST_REPRO_RES
* WORLD_WIDTH
* WORLD_HEIGHT
* HOST_ONLY_FIRST_TASK_CREDIT
* SGP_MUT_PER_BIT_RATE
* Removing some of the other tasks from `default-config-jsons/diff-reward-env.json`

### Advanced Expansion
For the advanced portion of the project, you will further expand on Symbulation in a direction of your choosing and then conduct another experiment to determine the effect of that expansion (it's fine if there isn't one this time though).

Here are your options for expansions:
* Create a custom event type (separate from a `TaskValueEvent`)
* Create a custom spatial structure (which will be a represented as an adjacency list or matrix, examples are in `source/test/data/chain-edges.csv` etc)
* Create three additional tasks such that you have at least five new tasks that build up in an interesting/meaningful way (and have them visually represented in your GUI)
* Turn on symbionts via `START_MOI` set to 1 and explore something beyond what the papers did (if you choose this option, you should check with me that your focus is complex enough)

You should again run the software with at least 5 different random seeds each for at least two treatments (i.e. with and without your expansion for example), save the relevant data from `Data` and plot relevant values with your choice of plotting software. You should additionally include at least 1 paragraph discussing the meaning of your results.

## Assessment
The **core** requirements are:

* Run and display an updated digital evolution system when the `compile-run-web.sh` script is run, using the web-browser, SignalGP-Lite, Symbulation, and Empirical libraries
* Have at least two new tasks that organisms evolve to perform within a reasonable amount of time (running your code for about 10 minutes) which are visually represented in your GUI (you can choose whether to keep the default Logic 9 tasks, but you must implement two different tasks)
* Specify in the Core section of your `README.md` what your new tasks are and how they are visually represented in your GUI
* Conduct a basic experiment with your new tasks and report in your Core section of your README on your results (at least 1 paragraph, results must show a noticable difference between settings)

The **advanced** requirements are:
* Complete the core requirements (including the basic experiment)
* Implement one of the advanced expansions and experiments
* Specify in the Advanced section of your `README.md` what expansion you chose and a report of your results (at least 1 paragraph with a plot of your data)

## Submitting
Submit your code to GitHub with the usual add/commit/push steps. Then tag your most recent commit with the following:
```
git tag -a initial_submission -m "initial submission"
git push origin initial_submission
```

## Getting Help
Remember that you can and should ask for help on everything from annoying C++ bugs to Git to "is this a reasonable expansion to implement?"
The CampusWire is probably the best place to ask, as long as you don't have to share too much of your code to do so, because you'll get faster responses on average.
You are also welcome to come to drop-in hours and schedule a one-on-one meeting if that works better for you.

## Acknowledgements
Symbulation has many additional contributors, here is the full citation:
Vostinar, A., Johnson-Horrigan, K., Lalejini, A., Dolson, E., Hillman-Emelianoff, E., Shea, J., Kelley, D., Khalili, A. T., Welch, P., Cameron, A., Orion Hafner, L., Dorchen, S., Gormely, C., renztim, Ofria, C., Qin, Y., & mkmmnn. (2026). anyaevostinar/SymbulationEmp: ComplexFeatures (Version v1.0) [Computer software]. Zenodo. https://doi.org/10.5281/zenodo.20732915
