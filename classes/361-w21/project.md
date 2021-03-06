---
layout: page
title: Project Specification
permalink: /classes/361-w21/project
---

# Introduction
A goal of this course is for you to come up with an interesting research question and implement an artificial life simulation that helps you answer that question. You will then present your results in several ways. 

Coming up with that research question, simulation, and experiments is no small feat and you will be guided through the process with check-in assignments throughout the term. The deadlines for those are:

| Item | Deadline |
|------|----------|
| Proposal outline | 1/25|
| Proposal draft | 2/1 |
| Proposal final | 2/5 |
| Progress report 1 | 2/10 |
| Part 1; Progress report 2 | 2/17 |
| Progress report 3 | 2/24 |
| Progress report 4 | 3/3 |
| ALIFE deadline (optional) | 3/7 |
| Presentations | 3/13 |
| Final project | 3/15 |

# Topics
There are several topics that I suggest both because they are near enough to my research that I can be the most help and because they are fertile ground for interesting evolutionary questions that artificial life simulations can contribute to. There is a section in the course Library Research Guide for each of these topics as well:

* Quorum Sensing
* Kin Selection
* Parasitism
* Mutualism
* Major Evolutionary Transitions

You are allowed to select a topic outside of these, however I recommend you only do so if you have previous background in the topic and therefore won't need as much assistance in finding that information.

# Platform
You will use the [Empirical](https://empirical.readthedocs.io/en/latest/) platform to build your simulation, which uses C++. Empirical provides many tools that are needed in artificial life simulations, allowing you to focus on the interesting behavior. Empirical is also heavily optimized, allowing you to run much larger simulations on your own machine than you would be able to do if you wrote everything from scratch.

You will have the option of either creating your own Empirical-based simulation or creating an extension to my software, [Symbulation](https://anyaevostinar.github.io/SymbulationEmp/web/symbulation.html). If you are interested in parasitism or mutualism, I especially recommend you consider an extension to my software because it provides a base for simulating symbiosis.

# Research question
Ideally your research question/hypothesis will be novel and interesting, however it is difficult to come up with such a question without a thorough review of the literature and a lot more time than ten weeks! Therefore you are not require to come up with a completely novel research question, though it should be non-trivial and interesting still. The goal of the many iterations of the [proposal](/classes/361-w21/proposal) is to allow us to have a conversation to get your research question to that point so that once you start developing your simulation, you are able to be confident that you are pursuing a question that I have determined will work for this project. In general your research question should be able to fit into the phrasing:

**Does X select for Y given Z?**

Which can then be the hypothesis:

**X selects for Y given Z.**

# Paper/GUI
To report on your findings, you will write a traditional scientific paper and create a GUI using Empirical's GUI tools. We will spend time in class discussing both of these and more details will be provided on how they will be graded.

If you would like, the main artificial life conference, [ALIFE](https://www.robot100.cz/alife2021), has a virtual component this year, and I will be able to work with a couple of groups to submit your research paper to the conference. The conference deadline is March 7th (though this is often extended by a week, but we can't count on that). If this is something that interests you, please make sure that I'm aware as we get closer to the deadline.

# Groups
You will be allowed to work with one other person on your term project or work by yourself. Keep in mind that my expectations for two-person projects will be higher and the final products should have twice the amount of content. I will assist in forming groups by sending out a form asking about which topics are of interest and who you would/would not like to work with if anyone. Given the remote nature of the course, I will prioritize preferences of who if anyone you would like to group with.

# Grading
Most of your grade in this course relates to the project in one way or another:

| Item | Contribution to grade |
|------|-------|
| Proposal | 10%|
|Peer review of project related items | 10%|
|Progress reports | 10%|
|Software of project | 25%|
|Paper/GUI | 25%|
|Presentation | 10%|

I will give more details about each of these components as their deadlines approach and am always happy to answer questions if you would like to know details earlier than I've written them down.

# Examples
Here are the research questions that I have previously investigated:
* Does kin selection select for programmed cell death given no other confounding factors?
* Does spatial structure select for cooperation given the existence of accurate quorum sensing?
* Does vertical transmission select for mutualism given no spatial structure?
* Does spatial structure select for mutualism given varying vertical transmission rates?
* Does division of labor select for mutualism given varying vertical transmission rates?

Here are open research questions that you could pursue if you aren't able to decide on one (you'll notice they are basically all about parasitism/mutualism since that is what I currently study):
* Can mutualists co-exist with parasites if the parasites have selected for highly defensive hosts?
* Does a rapidly changing spatial or temporal environment select for mutualism?
* Does the presence of a mutualist select for or against another mutualist co-existing?
* Does the ability of hosts' to perform program cell death select for mutualism given low vertical transmission rates?
* Does serotype conversion select for mutualism given the presence of parasitic strains?
* Does quorum-sensing controlled cooperation select for mutualism with a symbiont given low vertical transmission rates?
* Does the presence of a competing host species select for parasitism given an existing symbiosis with one host species?
* Does the presence of a parasite prevent host range expansion given the range expansion is into a hostile area?
* Does the presence of a mutualist symbiont select for group living given hosts can choose how closer to associate with each other?
* Does chronic infection of a parasite/virus in the same host select for escaping the immune system more than infection across several hosts given immune response to the virus?