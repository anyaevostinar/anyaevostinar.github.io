---
layout: page
title: Project Proposal
permalink: /classes/257-fs25/project-proposal
---

## Overview
The purpose of this project as a whole is to introduce you to the design, testing, and implementation of database-driven web applications. The purpose for this particular piece of the project is to give you practice in developing a project plan, identifying a dataset of interest, and establishing grounds rules for your team.

## Collaboration
Work with your project team on this deliverable.

## Due Date
Monday April 14th at 10pm on Team Deliverable GitHub.

## What to submit
This deliverable has three components
- [ ] a [team contract](#team-contract-requirements) 
- [ ] a [project proposal](#project-proposal)
- [ ] a copy of your [dataset(s)](#dataset-questions) in the "Data" folder. Remember your data must be less than 100MB!


### Team Contract Requirements
The team contract helps build group cohesion and accountability; removes much of the cognitive load in keeping track of tasks, responsibilities, and deadlines; and gives teams the opportunity and space to reflect on their individual and team goals and expectations.

Your team contract should be submitted as a Markdown document (refer to [this cheatsheet](https://www.markdownguide.org/cheat-sheet/) for formatting help). The team contract will form part of the peer/team evaluation component of the term-long project.

In your team contract, you should address the following prompts.

1. **What are the goals of our team?** What do you, as a team, want to gain from this project experience? What goals and skills do you want to attain and/or hone? Start your contract with a **goals statement**.

2. **What are the strengths of our team and its members?** Individually, think about the strengths you bring to the project. These could include technical strengths ("I am really good at finding bugs in code", "I organize my code really well", "I can find answers very efficiently by searching") and broader life skills strengths ("I take excellent notes", "I am an excellent listener", "I like to find and build consensus when there's disagreement"). If you already know some of your teammates and/or have worked with them previously, feel free to add to their strengths. **List these out for each team member in your contract.**

3. **How will we capitalize on the strengths of each member?** Think about your team goals and how each person might contribute to achieving them based on their strengths. Does assigning roles make sense for your team, or perhaps rotating roles? Note that exact roles and responsibilities will likely change over the lifetime of this project, and that's ok. Is someone in charge of setting meetings? Two people focused on reviewing code or testing?

4. **What are the rules that will guide your team?** Specifically:

    * Meetings: When will your team meet? What time, how often, for how long, where?
    * Roles: What roles will members take on in your meetings? Is someone responsible for setting agendas, taking notes, facilitating discussions, etc?
    * Communication:
        * How will you communicate with each other? (to share work, to ask questions, notify the group if someone is running late or if someone will miss a meeting, etc)
        * How will you make sure communication stays respectful? (How does your team define "respectful"?)
        * What are the expectations for dealing with a teammate who hasn't been communicating? How frequently should team members communicate / check in?
    * Technologies: What technologies will you use to support team meetings and work? (Google Drive, Hangouts, Zoom, Facetime, etc)
    * Decision-Making: How will you make decisions? (Unanimous, consensus, majority rule, by assigned roles, rock-paper-scissors, etc.)
    * Delegation:
        * How will you divide the work?
        * How will you ensure that everybody participates meaningfully? How will you make sure that everyone's contribution is valued?
        * What expectations do you have for satisfactory participation? (How much time will each group member spend per week on project activities?)
    * Conflict Resolution:
        * What process will you follow if someone does not live up to their responsibilities and/or meet the standards for work set by the team?
        * How will you address conflict or deal with disagreements within the team?

### Project proposal
In your project proposal, you should include the following:

1. The working title of your project

2.  A summary of the dataset(s) you will use in this project (e.g. topic, interesting variables, etc.)

3. Metadata for the dataset(s) from the Dataset Records (URL, date downloaded, authorship, exact name and version, terms of use, suggested citation)
    * If you’re having trouble filling out the following fields for your dataset, it may be a sign that you need to double-check the source of your dataset.

4. 3 interesting/meaningful ways that a user could interact with the data. For each user interaction, include descriptions of:
    * Potential Users: Who may interact with your data? What are their motivations for interacting with the data?
    * Interaction Mechanism: How may they interact with the data? (e.g. Search bar? Different tabs? Which variables in your dataset?) What are the pros and cons to different interaction mechanisms?
    * Potential Benefits: How may interacting with your data benefit users? Why?
        * If you don’t think users will benefit, then why bother developing that user interaction? ¯\_(ツ)_/¯ 
    * Potential Harms: How may interacting with your data harm or exclude users? Why? 
        * If you don’t think users will feel harmed or excluded by interacting with your data, explain why.



## Dataset Questions
*"I want to use a dataset that's not listed in the [research guide](https://gouldguides.carleton.edu/cs257). How do I know if I can use it?"*

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

Given the limited time you have, I would suggest rethinking your project idea or finding an existing dataset that relates to similar themes to the data you were originally interested in. You might be able to write a "web scraper", which is a program that reads off the HTML from a website and extracts the data. There are many risks to this approach that could delay your progress on other deliverables for this project.

## How to Submit
* Turn in your proposal, team contract, and data on GitHub, by pushing these items to your team's repository. 
* Your team contract should be titled `Contract.md`, your project proposal should be titled `Proposal.md` and your data must be in the `Data` folder.
* Tag the commit with the tag "proposal" with the following command:

```bash
git tag -a proposal -m "project proposal"
git push origin proposal
```

**Tags tell us which commit (i.e. version of your code) to evaluate.** If you don’t tag your commit, we’ll checkout the commit closest to the deadline, which may not be the version of your code that you want us to evaluate.
If you forgot to tag your commit, you can retroactively tag them with [these instructions](https://docs.google.com/document/d/1gt8cAmhFV9YxFE5ml2ReiGyVvwoum1MH9L0wzttqdkA/edit?usp=sharing).

## Evaluation

The criteria for "Proficiency" and "Exemplary" are below. I will put your grade (and only your grade) on Moodle. Because the evaluation criteria exceeds the Moodle character limit, I'll put feedback on your deliverable as a [Pull Request](https://anyaevostinar.github.io/classes/257-f23/pr-guide) on your repo.

### Proficiency
- [ ] Team contract answers all four high-level questions (Team Contract Requirements Questions 1-4; the ones in bold)
- [ ] Proposal includes a working title, a summary of the dataset, and descriptions of 3 user interactions (user, interaction, potential benefits, and potential harms)
- [ ] Dataset if clearly identified and appropriate
- [ ] Dataset is less than 100MB

### Exemplary
- [ ] All requirements for proficiency are met
- [ ] Team contract addresses all the listed expectations (Team Contract Requirements Subquestions to 4)
- [ ] The commit to evaluate on the team repo is tagged with `proposal` (See instructions in [How to Submit](#how-to-submit))
- [ ] Descriptions of 3 user interactions include considerations of (1) the advantages and disadvantages of their chosen dataset and interaction mechanisms and (2) different types of benefits and harms. If the team does not think a user may be harmed, they have provided a detailed justification. 
- [ ] Proposal includes the metadata for the dataset(s)
- [ ] Both the team contract and proposal are clear and concise, easy to understand, with few to no spelling or grammatical errors
- [ ] Dataset is 25MB or smaller


## Inspiration
Here are screenshots of final products of the F23 257 course for future students' inspiration:

<div class="row">
  <div class="column">
    <a href="/assets/images/F23-257-Exoplanets.png">
    <div class="card">
    <img src="/assets/images/F23-257-Exoplanets.png" alt="Screenshot of Exoplanets website" style="width:100%">
        <div class="container">
            <h4><b>Exoplanets!</b></h4>
             <br>
        </div>
    </div></a>
    <a href="/assets/images/F23-257-Cancer.png">
    <div class="card">
    <img src="/assets/images/F23-257-Cancer.png" alt="Screenshot of WATCH website" style="width:100%">
        <div class="container">
            <h4><b>Web Analysis Tool of Cancer History</b></h4>
             <br>
        </div>
    </div></a>
    <a href="/assets/images/F23-257-BirthControl.png">
    <div class="card">
    <img src="/assets/images/F23-257-BirthControl.png" alt="Screenshot of Birth Control website" style="width:100%">
        <div class="container">
            <h4><b>Reproductive Health</b></h4>
             <br>
        </div>
    </div></a>
  </div>
  <div class="column">
    <a href="/assets/images/F23-257-PySpill.png">
    <div class="card">
    <img src="/assets/images/F23-257-PySpill.png" alt="Screenshot of PySpill website" style="width:100%">
        <div class="container">
            <h4><b>PySpill</b></h4>
             <br>
        </div>
    </div></a>
    <a href="/assets/images/F23-257-PySpillMap.png">
    <div class="card">
    <img src="/assets/images/F23-257-PySpillMap.png" alt="Screenshot of PySpill Map " style="width:100%">
        <div class="container">
            <h4><b>PySpil Map page</b></h4>
             <br>
        </div>
    </div></a>
    <a href="/assets/images/F23-257-World.png">
    <div class="card">
    <img src="/assets/images/F23-257-World.png" alt="Screenshot of World Data website " style="width:100%">
        <div class="container">
            <h4><b>World Bank Financial Data</b></h4>
             <br>
        </div>
    </div></a>
  </div>
  <div class="column">
  <a href="/assets/images/F23-257-Justice.png">
  <div class="card">
    <img src="/assets/images/F23-257-Justice.png" alt="Screenshot of Supreme Court website " style="width:100%">
        <div class="container">
            <h4><b>Supreme Court Database</b></h4>
             <br>
        </div>
    </div></a>
    <a href="/assets/images/F23-257-Food.png">
    <div class="card">
    <img src="/assets/images/F23-257-Food.png" alt="Screenshot of Food website " style="width:100%">
        <div class="container">
            <h4><b>Chick-fil-A Nutrition</b></h4>
            <br>
        </div>
    </div></a>
    <a href="/assets/images/F23-257-Stocks.png">
    <div class="card">
    <img src="/assets/images/F23-257-Stocks.png" alt="Screenshot of Stock Data website " style="width:100%">
        <div class="container">
            <h4><b>Stock Data</b></h4>
             <br>
        </div>
    </div></a>
    </div>
</div>