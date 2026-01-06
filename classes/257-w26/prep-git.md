---
layout: page
title: Version Control (Git) Prep
permalink: /classes/257-w26/git-prep
---

## Overview
Version control is a vital tool when working with a team on software. While there are several different tools that support version control, Git is the most popular and widely used today. Today we'll focus on learning the most important functionalities of Git and how Git works under the hood.

## Basic Learning Objectives

Before class, you should be able to:
* Explain what a code repository is and why we use code repositories.
* Explain the basic git workflow, so that you are ready to complete the git lab.
* Identify the circumstances which lead to merge conflicts
* Explain the basic strategies to resolve merge conflicts when they arise

## Advanced Learning Objectives
After class, you should be able to:
* Add, change, and remove files from a git repository
* Create and resolve merge conflicts in your own and team git repositories
* Work with branches and merge branches
* Have your team repository setup

## Readings
There are a couple of ways that you can go about achieving the basic learning objectives before class, depending on your preferred way of learning new information today. You should definitely read some combination of these things, and I think this order is ideal, but feel free to skip around if it seems better for you:
* [About Version Control](https://git-scm.com/book/en/v2/Getting-Started-About-Version-Control) - an overview of the idea of version control
* [What is Git?](https://git-scm.com/book/en/v2/Getting-Started-What-is-Git%3F) - even if you've used Git before, I recommend reading this section, since it highlights how Git actually works under the hood
* [Git Basics](https://git-scm.com/book/en/v2/Git-Basics-Recording-Changes-to-the-Repository) - an overview of the core git commands (if you want to just focus on them for now), other sections of the early chapters of [this book](https://git-scm.com/book/en/v2) are great to read also if you like reading about more context
* [Basic Branching and Merging from Pro Git](https://git-scm.com/book/en/v2/Git-Branching-Basic-Branching-and-Merging)
* [Learn Git Branching Game](https://learngitbranching.js.org/) - a browser based game that presents much of the same information as the Pro Git reading but in interactive game form. If this sounds helpful, you can jump right to it.
* [Git's Data Model](https://missing.csail.mit.edu/2020/version-control/) - a slightly deeper introduction to how Git actually works from MIT and the argument for why it is useful to know that deeper level

## Checks
Submit answers to the following on Moodle:
5. What is the typical git workflow, from start to finish, when you want to add or modify a file in a repository and make sure the changes are on GitHub?
7. Describe a situation in which a merge conflict might occur.
8. What are the markers in a file that indicate where the conflict is?
9. Describe the workflow you would use to resolve a merge conflict (i.e. what sequence of git commands would you use?).