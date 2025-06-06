---
layout: page
title: Project Design Improvements
permalink: /classes/257-s25/project-improvements
---

## Overview
Hooray, you’ve made a functional database-driven website! Now it’s time to refactor your code to make it easier for other developers to understand and maintain and improve your front-end to improve the user experience.

## Collaboration

You should work with your team on this project.
You are able to get help from outside sources, as specified in the syllabus, but everything that your team submits should be your own.

## Due Date

Your final design improvements are due Monday June 9th at 8:30pm and there can be no revisions or late work accepted per [official college policy](https://apps.carleton.edu/handbook/academics/?policy_id=21449&a=student).

## Your Task
You will make improvements to either your codebase or your front-end (or both for exemplary) as specified below.

After you are done, you might be interested in following [this guide](guide-migrate-project) for getting your project onto your own repository for your portfolio.

### Submit
* **Individually** submit your [final reflection](reflection-final)
* **As a team** make design improvements as described below.
* **As a team** submit an edited `README.md` that explains what you did for the design improvement option(s) you chose. What to include in `README.md` will depend on the design improvement option.
**You should make sure to label everything very clearly in your README since there won't be a chance for revisions.**

### Option A: Code Design Improvements
Refactor out at least **TWO** code smells/naming & commenting issues from your code base. 

In `README.md`, for each code smell/naming & commenting issue:
* Identify & describe what the code smell/naming & commenting issue was
* Identify the file(s) and approximate lines with your solution to refactor out the code smell/naming & commenting issue
* Explain what you did to refactor out the code smell/naming & commenting issue
	
Potential resources include Chapter 2, 4, and 17  of [Clean Code](https://bridge.primo.exlibrisgroup.com/discovery/fulldisplay?context=PC&vid=01BRC_INST:CCO&search_scope=CCO_MyCampus_PCI&tab=Everything&docid=cdi_askewsholts_vlebooks_9780136083252) and [this article on Code Smells](https://refactoring.guru/refactoring/smells).

### Option B: Front-End Design Improvements
Make at least **TWO** improvements to your front-end design to address usability issues. These can be issues identified after the initial front-end submission, or during the in-class code review, usability testing, or the final project showcase.

In `README.md`, for each front-end improvement:
* Describe the usability issue
* Identify the page where you made the change
* Explain what you did to address the usability issue

## How to Submit
Your team should submit this component of the project on your team repo with the tag `improved-design` by typing the commands below. Make sure your repo is updated by checking it on the GitHub website as well.

```bash
git tag -a improved-design -m "improved final website design"
git push origin improved-design
```

Tags tell us which commit (i.e. version of your code) to evaluate. If you don’t tag your commit, we’ll checkout the commit closest to the deadline, which may not be the version of your code that you want us to evaluate.
If you forgot to tag your commit, you can retroactively tag them with [these instructions](https://docs.google.com/document/d/1gt8cAmhFV9YxFE5ml2ReiGyVvwoum1MH9L0wzttqdkA/edit?usp=sharing).

## Evaluation Criteria
The criteria for “Proficiency” and “Exemplary” are below. 

The grader will evaluate your project by:
* Looking at your `README.md` to know what design improvements you made to your codebase and/or front-end
* Git checkout the tag `front-end` to see what your codebase and/or front-end looked like before your design improvements
* Git checkout the tag `improved-design` to see what your codebase and/or front-end looks like after your design improvements

### Proficiency
* All the previous components (Command Line, Flask, Database, Front-End, & Tests) still work.
* Your team’s code fulfilled the requirements below for EITHER the code OR front-end design improvement option

#### Option A: Code Design Improvements
For each of the **TWO** code smells/naming & commenting issues:
* `README.md` contains an identification & description of what kind of code smell/naming & commenting issue it was
* `README.md` contains the file(s) and approximate lines with the solution to refactor out the code smell/naming & commenting issue
* `README.md` contains an explanation of what you did to refactor out the code smell/naming & commenting issue
* The refactoring of the code smell/naming & commenting issue is evident when comparing the relevant files in the codebase from the front-end tag & the  improved-design tag.

#### Option B: Front-End Design Improvements
For each of the **TWO** usability issues:
* `README.md` includes a description of the usability issue
* `README.md` identifies the page where you made the change
* `README.md` includes an explanation of what you did to address the usability issue
* The front-end improvement is evident when comparing the relevant files in the codebase from the `front-end` tag & the `improved-design` tag

### Exemplary
Your team’s code fulfilled the Proficiency requirements for BOTH the code and front-end design improvement options.
