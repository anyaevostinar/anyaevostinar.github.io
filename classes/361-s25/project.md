---
layout: page
title: Project Specification
permalink: /classes/361-f22/project-overview
---

## Introduction
As you know, the field of artificial life is interested in how the dynamics of life can be separated from the typical substrates of DNA and RNA so that we can better understand life and life-like dynamics.
The goal of this particular course is that you learn how we can use *computational and algorithmic approaches* to understand the dynamics of biological life, both as it currently is on Earth and as it could be!
You've done some small projects to build up your skills in particular areas of artificial life, but there are a lot of areas we haven't explored and a lot of depth left to those areas we have explored.

Therefore, this project is focused on allowing you to dive in to an area of artificial life that is of interest to you (and your team, if you have one) and create computational software focused around it.

## Specifics
To give you some structure, your project will need to meet the following requirements:
* (Attempt to) replicate a published result from the scientific literature using the Empirical platform
* Visually present an aspect of that result in a browser-based GUI using the Empirical platform
* Expand beyond the published result in some way
* Write a short report on what results you (attempted to) replicate and how you expanded on them
* Additional requirements for mastery, see assessment criteria below

You will submit your full project through the associated GitHub Classroom assignment.

## Collaboration
You can work in groups of 1-3 people, meaning you can work alone if you wish or with up to two others. While every group will need to produce a project that meets the same general criteria, my expectation of size/scope will scale with the group size to a small degree.

## Timeline
You will ultimately be assessed on the state of your project at the end of finals, like all other work in this course.
However, there is a lot to this project, and so you will have intermediate opportunities for feedback and checking in, as shown below.

| Item | Due date |
|------|----------|
| Project topic checkin | 10/24 |
| Project proposal | 10/28 |
| Replication first drafts | 11/9 |
| Final project peer review | 11/16 |
| Final project | 11/21 |

## Proposal
The proposal is your chance to make sure that your plan is feasible before you get too far into your project.
Your team will submit just one proposal.

### Topic checkin
Your team will first submit a topic checkin by 10/24 at 10pm.
This checkin must include the following:
* A link/citation to the paper with the result that you are going to try to replicate.
* A summary of the specific published result that you are going to try to replicate. This should be a specific paper and a specific result in that paper, either a figure or a section. Most scientific papers present several related results and you only need to attempt to replicate one. You should summarize the result so that I can understand the idea without needing to read the paper.

If you haven't settled on one paper, you can submit a document with several possibilities to get my thoughts on which would be best.
I will be aiming to get you feedback quickly on this topic checkin, so you can submit it earlier to possibly get earlier feedback.

#### Ideas
Some things I mentioned in class when thinking about ideas for the project:
* "Classic" results a great, more likely to be able to replicate and then build from
* Traditional mathematical modeling results using ODEs could be interesting to replicate in an agent-based model
* The [Avida Encyclopedia page](https://alife.org/encyclopedia/digital-evolution/avida/) has a long list of papers published that used Avida and most of those would be ideal for this project

### Full proposal
Your full proposal is due 10/28 at 10pm, but we will be doing peer review/discussion of your proposals in class that day so that you can see what other people are doing and get some last minute feedback as you finish your own proposal.

Your proposal must include the following:
* A link/citation to the paper with the result that you are going to try to replicate. (Either updated or not based on feedback from checkin.)
* A summary of the specific published result that you are going to try to replicate. This should be a specific paper and a specific result in that paper, either a figure or a section. Most scientific papers present several related results and you only need to attempt to replicate one. You should summarize the result so that I can understand the idea without needing to read the paper. (Either updated or not based on feedback from checkin.)
* A sketch of how you are thinking of visually presenting the system. This shouldn't be a data plot, but instead something similar to the UIs that you've made for the projects so far.
* Two ideas (at least) of extensions to the result that you would like to try. These don't need to be big, but they shouldn't repeat the other results in the paper. They can be along the lines of 'try this with two other mutation rates' or 'try adjusting population size.' One of them can be more ambitious, but one should be something that you think will be trivial to do.

## Replication Drafts

You should aim to have your preliminary replicated results by 11/9. 
To enable this, you will submit a draft of your system and replication report by this date to then get feedback and help on ideas.

Your draft report for 11/9 should be submitted as a Google Doc through the form on Moodle and should include the following sections:
* Summary of the methodology of the original paper (i.e. the system and approach used)
* Summary of the result from the original paper that you attempted to replicate
* Description of your reimplementation and any changes you needed to make from the original approach (i.e. description of how your program works and how it differs from the original methodology)
* Description of your replication results so far
* (If relevant) Initial analysis on why you results differ from original results

Your final report should be a `.md` or `.pdf` file in your Git repository.

### Helpful things
If you are doing an Avida paper, check out the guide for [logic nine tasks](logic-nine) and [new instructions](instructions-guide).

## Assessment
Generally, you will be assessed based on the specifications above. 

To demonstrate proficiency on this project:
* Report details which scientific result you attempted to replicate (report is `.md` or `.pdf` file in repository and cleared labeled, see previous sections for required sections)
* If you weren't able to replicate the result, report includes preliminary analysis as to why
* When `compile-run-web.sh` is run, your project displays a basic GUI of your system
* You have a simple expansion of the published result, which is explained in your report

To demonstrate mastery on this project, everything from proficiency as well as:
* If you weren't able to replicate the result, report includes thorough analysis as to why
* System includes data output from a command-line version
* GUI intuitively demonstrates results from the paper and helps the user understand the underlying system and dynamics
* GUI includes configuration panel and suggestions for what the user should try
* Your expansion(s) go beyond simple additional parameter testing
* GUI clearly demonstrates your expanded results as well
* Report includes plotted data for your replicated and expanded results
