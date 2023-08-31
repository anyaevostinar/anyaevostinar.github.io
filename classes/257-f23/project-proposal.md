---
layout: page
title: Project Proposal
permalink: /classes/257-f23/project-proposal
---

## Overview
The purpose of this project as a whole is to introduce you to the design, testing, and implementation of database-driven web applications. The purpose for this particular piece of the project is to give you practice in developing a project plan, identifying a dataset of interest, and establishing grounds rules for your team.

## Collaboration
Work with your project team on this deliverable.

## Due Date
Monday Sept 25th at 10pm on Team Deliverable GitHub.

## Your Task
Your proposal has two components 1) selecting a dataset and 2) writing a team contract.

What you submit should include the following information:

* The working title of your project

* A summary of the dataset(s) you will use in this project and its metadata (URL, date downloaded, authorship, exact name and version, terms of use, suggested citation)

* A copy of your dataset in the "Data" folder (assuming it isn't too big, which it shouldn't be!). Remember your data must be less than 100MB!

* 2-4 interesting/meaningful ways that a user could interact with the data

* Your team contract (see below for what that should answer)

### Team Contract Requirements
The team contract helps build group cohesion and accountability; removes much of the cognitive load in keeping track of tasks, responsibilities, and deadlines; and gives teams the opportunity and space to reflect on their individual and team goals and expectations.

Your team contract should be submitted as a Markdown document (refer to [this cheatsheet](https://www.markdownguide.org/cheat-sheet/) for formatting help). The team contract will form part of the peer/team evaluation component of the term-long project.

In your team contract, you should address the following prompts.

1. **What are the goals of our team?** What do you, as a team, want to gain from this project experience? What goals and skills do you want to attain and/or hone? Start your contract with a **goals statement**.

2. **What are the strengths of our team and its members?** Individually, think about the strengths you bring to the project. These could include technical strengths ("I am really good at finding bugs in code", "I organize my code really well", "I can find answers very efficiently by searching") and broader life skills strengths ("I take excellent notes", "I am an excellent listener", "I like to find and build consensus when there's disagreement"). If you already know some of your teammates and/or have worked with them previously, feel free to add to their strengths. **List these out for each team member in your contract.**

3. **How will we capitalize on the strengths of each member?** Think about your team goals and how each person might contribute to achieving them based on their strengths. Does assigning roles make sense for your team, or perhaps rotating roles? Note that exact roles and responsibilities will likely change over the lifetime of this project, and that's ok. Is someone in charge of setting meetings? Two people focused on reviewing code or testing?

4. **What are the rules that will guide your team?** Specifically:

    * When will your team meet? What time, how often, for how long, where?
    * What roles will members take on in your meetings? Is someone responsible for setting agendas, taking notes, facilitating discussions, etc?
    * How will you communicate with each other? (to share work, to ask questions, notify the group if someone is running late or if someone will miss a meeting, etc)
    * How will you make sure communication stays respectful? (How does your team define "respectful"?)
    * What are the rules for dealing with a teammate who hasn't been communicating? How frequently should team members communicate / check in?
    * What technologies will you use to support team meetings and work? (Google Drive, Hangouts, Zoom, Facetime, etc)
    * How will you make decisions? (Unanimous, consensus, majority rule, by assigned roles, rock-paper-scissors, etc.)
    * How will you divide the work?
    * How will you ensure that everybody participates meaningfully? How will you make sure that everyone's contribution is valued?
    * What expectations do you have for satisfactory participation? (How much time will each group member spend per week on project activities?)
    * What process will you follow if someone does not live up to their responsibilities and/or meet the standards for work set by the team?
    * How will you address conflict or deal with disagreements within the team?

## Dataset Questions
*"I want to use a dataset that's not listed in the research guide. How do I know if I can use it?"*

The safest thing to do is to select a dataset that is available for public use. If you're not sure where to look, ask Anya and/or contact the library liaison for Computer Science, and we can help you find the relevant information.

*"If a dataset says it's ok for academic use, is that sufficient?"*

Usually. We won't be publishing our sites outside of Carleton, so often even "restricted" datasets are ok to use. That said, check the restrictions carefully, and ask the librarian or Anya if you have questions.

*"What's the maximum size allowable dataset for this project?"*

The database file size per group needs to be around 20MB. However, there is some wiggle room, so long as everyone does not exceed the 20MB limit. There are ways to limit the size of the data you're storing in your database -- for instance, you may not need every field from the dataset. If you want to work with a large dataset, I can help you figure out a way to make it manageable. The main thing is no images or movies!

*"I want to use Reddit data..."*

A word of caution: Reddit data is certainly rich, and sometimes entertaining, but in the past student teams have struggled a lot to make viable and interesting projects with this data. The data itself is hard to wrangle and work with, and it's hard to distill the essence of Reddit into a web project that can be completed in 7 weeks. I would suggest rethinking your project idea.

*"I want to write a recommender system to..."*

Whoa there, we only have 7 weeks for this project! A good way to think about how to scope your project is to think about what interesting questions you might be able to answer with your chosen data. What aspects of the data do you want to highlight? Some of the best projects in recent memory aimed to answer a few core questions with a dataset and built a compelling and intuitive web site around this data. For example: word frequencies in Billboard Top 100 songs; Oscar winners by category, year, genre; wildlife in national parks.

*"The data I want exists on a website, but there's no dataset available per se."*

It's not common, but every once in a while a team wants to use data from, say, the Registrar, or some other site that doesn't have a downloadable dataset. In these cases, you might be able to write a "web scraper", which is a program that reads off the HTML from a website and extracts the data. First, you need to make sure that the site allows web scraping before you proceed. Once you've established that you have permission, there are some resources I can point you towards that other student teams have found helpful. Please talk to me if you want to go this route, but if there are other ideas that you have, those will probably be better given the limited time that you have.

## How to Submit
Turn in your proposal (which includes your team contract) and data on GitHub, by pushing these items to your team's repository. You data must be in the `Data` folder and your proposal should be titled `Proposal.md`. Tag the commit with the tag "proposal" with the following command:

```bash
git tag -a proposal -m "project proposal"
git push origin proposal
```

## Evaluation

The criteria for "Demonstrates Proficiency" and "Demonstrates Mastery" are below.

### Proficiency
* Dataset if clearly identified and appropriate
* Dataset is less than 100MB
* Every team member has a defined role. The plan outlines responsibilities and accountability mechanisms.
* Documents are organized and answer all of the questions

### Mastery
* All requirements for proficiency are met
* All required metadata is included in the submission for the dataset
* Documents are are clear and concise, easy to read, with few to no spelling or grammar errors
