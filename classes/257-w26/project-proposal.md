---
layout: page
title: Project Proposal
permalink: /classes/257-w26/project-proposal
---

## Overview
The purpose of this project as a whole is to introduce you to the design, testing, and implementation of database-driven web applications. The purpose for this particular piece of the project is to give you practice in developing a project plan, identifying datasets of interest, and establishing grounds rules for your team.

Additionally, through this project, you will demonstrate and reflect on how software can contribute to making systematic change in economic, environmental, or social sustainability and therefore your project must address one or more of the [UN Sustainable Development Goals](https://sdgs.un.org/goals). 

## Collaboration
Work with your project team on this deliverable.

## Due Dates
* Your TWO datasets metadata is due Monday 1/12 at 10pm in your team github
* Your team contract and proposal are due Monday 1/19 at 10pm on Team Deliverable GitHub.

## What to submit
This deliverable has three components
- [ ] a [team contract](#team-contract-requirements) 
- [ ] a [project proposal](#project-proposal)
    - [ ] including metadata
- [ ] a copy of your two [datasets](#dataset-questions) in the "Data" folder. Remember your total data must be less than 100MB, ideally less than 25MB for advanced!


### Team Contract Requirements
The team contract helps build group cohesion and accountability; removes much of the cognitive load in keeping track of tasks, responsibilities, and deadlines; and gives teams the opportunity and space to reflect on their individual and team goals and expectations.

Your team contract should be submitted as a Markdown document (refer to [this cheatsheet](https://www.markdownguide.org/cheat-sheet/) for formatting help). The team contract will form part of the peer/team evaluation component of the term-long project.

In your team contract, you should fill in the following.

1. **Roles**: You must specify who is going to take on each of the following roles in the first and second sprints (one week each). You must change roles between the first and the second sprints and then after that you can choose to continue to rotate or maintain. Here are the roles (each must be filled, so one or two people will need to do an extra role):
    * Organizer: organizes the meetings outside of class and makes sure that the team deliverables are submitted
    * Gluer: checks on everyone's progress regularly and coordinates shared functionality
    * Researcher: does necessary deep dives into technical issues and bugs
    * Ambassador: attends drop-in hours for the team as needed (must be able to make one or more drop-in times)
    * Note-taker: takes notes at the team meetings and saves them into a shared team folder

2. **Meetings**: Proactive meetings are essential to the success of a large project. To facilitate that:
    * Your team must have at least one 1-hour weekly in-person meeting time each week that everyone agrees they can attend. When is it?
    * Consult my drop-in hour times (on the syllabus and Moodle) and list out which team member can make which times on a regular basis.

3. **Communication**: Answer the following.
    * How will you communicate with each other? (to share work, to ask questions, notify the group if someone is running late or if someone will miss a meeting, etc)
    * How frequently should team members communicate / check in?
    * What are the expectations for dealing with a teammate who hasn't been communicating? 
    * What technologies will you use to support team meetings and work? (Google Drive, Hangouts, Zoom, Facetime, etc)
    * How will you make decisions? (Unanimous, consensus, majority rule, by assigned roles, rock-paper-scissors, etc.)
    * What expectations do you have for satisfactory participation? (How much time will each group member spend per week on project activities?)

4. **Conflict resolution**: Answer the following.
    * What process will you follow if someone does not live up to their responsibilities and/or meet the standards for work set by the team?
    * How will you address conflict or deal with disagreements within the team?

### Project proposal
In your project proposal, you should fill in the following.

1. The working title of your project

2. Which [UN Sustainable Development Goal(s)](https://sdgs.un.org/goals) are you aiming to contribute to with your project? How could your project contribute to that goal?

3. Each person on your team will be responsible for one "full-stack" feature, meaning from the data to the HTML. A feature is some way that the user interacts with the data, such as "look up all the information about a book by its title" or "find books published in the specified range of dates". Some features can deal with just one of your datasets, but at least one should cut across the datasets (since that is the point of having two). 
    * List out each team member and what their feature will be.
    * For each feature, include at least one user story and the acceptance criteria

4. Metadata for the (at least) two datasets from the [research guide](https://gouldguides.carleton.edu/c.php?g=972072&p=8845115) (URL, date downloaded, authorship, exact name and version, terms of use, suggested citation)
    * If you’re having trouble filling out the following fields for your dataset, it may be a sign that you need to double-check the source of your dataset.

5. A pencil-paper sketch "mock up" of what you are hoping your final webpage could look like. Dream big! Get excited!

6. The story of how you found the datasets. Who found them? Why is your team excited about them? Be honest, I just want to know.



## Dataset Questions
* *"I don't know where to even start!*

Check out [this Sustainability Resources page](sustainability-resources) for a list of inspiration, datasets, and ideas

*"I want to use a dataset that's not listed in the [research guide](https://gouldguides.carleton.edu/cs257). How do I know if I can use it?"*

The safest thing to do is to select a dataset that is available for public use. If you're not sure where to look, ask Anya and/or contact the library liaison for Computer Science, and we can help you find the relevant information.

*"If a dataset says it's ok for academic use, is that sufficient?"*

Usually. We won't be publishing our sites outside of Carleton, so often even "restricted" datasets are ok to use. That said, check the restrictions carefully, and ask the librarian or Anya if you have questions.

*"What's the maximum size allowable dataset for this project?"*

The database file size per group needs to be around 100MB. However, there is some wiggle room, so long as everyone does not exceed the 100MB limit. There are ways to limit the size of the data you're storing in your database -- for instance, you may not need every field from the dataset. If you want to work with a large dataset, I can help you figure out a way to make it manageable. The main thing is no images or movies!

*"I want to use Reddit data..."*

A word of caution: Reddit data is certainly rich, and sometimes entertaining, but in the past student teams have struggled a lot to make viable and interesting projects with this data. The data itself is hard to wrangle and work with, and it's hard to distill the essence of Reddit into a web project that can be completed in 7 weeks. I would suggest rethinking your project idea.

*"I want to write a recommender system to..."*

Whoa there, we only have 7 weeks for this project! A good way to think about how to scope your project is to think about what interesting questions you might be able to answer with your chosen data. What aspects of the data do you want to highlight? Some of the best projects in recent memory aimed to answer a few core questions with a dataset and built a compelling and intuitive web site around this data. For example: word frequencies in Billboard Top 100 songs; Oscar winners by category, year, genre; wildlife in national parks.

*"The data I want exists on a website, but there's no dataset available per se."*

Given the limited time you have, I would suggest rethinking your project idea or finding an existing dataset that relates to similar themes to the data you were originally interested in. You might be able to write a "web scraper", which is a program that reads off the HTML from a website and extracts the data. There are many risks to this approach that could delay your progress on other deliverables for this project.

## How to Submit
* Turn in your proposal, team contract, and data on GitHub, by pushing these items to your team's repository on the `main` branch. 
* Your team contract should be titled `Contract.md`, your project proposal should be titled `Proposal.md` and your data must be in the `Data` folder.
* Tag the commit with the tag "proposal" with the following command:

```bash
git tag -a proposal -m "project proposal"
git push origin proposal
```

**Tags tell us which commit (i.e. version of your code) to evaluate.** If you don’t tag your commit, we’ll checkout the commit closest to the deadline, which may not be the version of your code that you want us to evaluate.
If you forgot to tag your commit, you can retroactively tag them with [these instructions](https://docs.google.com/document/d/1gt8cAmhFV9YxFE5ml2ReiGyVvwoum1MH9L0wzttqdkA/edit?usp=sharing).

## Evaluation

The "Core" and "Advanced" requirements are below. I will put your grade (and only your grade) on Moodle. Because the evaluation criteria exceeds the Moodle character limit, I'll put feedback on your deliverable as a [Pull Request](https://anyaevostinar.github.io/classes/257-f23/pr-guide) on your repo.

### Core
- [ ] Team contract answers all four high-level sections (Team Contract Requirements sections 1-4)
- [ ] Proposal includes clear answers for sections 1-3 (Title, UN SDG, features, user stories, acceptance criteria)
- [ ] Datasets are clearly identified and appropriate
- [ ] Datasets are less than 100MB total

### Advanced
- [ ] All core requirements are met
- [ ] Team contract addresses all the listed expectations (all subquestions for each section)
- [ ] The commit to evaluate on the team repo is tagged with `proposal` (See instructions in [How to Submit](#how-to-submit))
- [ ] The user stories and acceptance criteria are detailed enough that they could be turned into tests immediately
- [ ] Proposal includes answers to sections 3-6
- [ ] Both the team contract and proposal are clear and concise, easy to understand, with few to no spelling or grammatical errors
- [ ] Datasets are 25MB or smaller


## Inspiration

Here are screenshots of final products of the previous CS 257 courses for future students' inspiration (note that these were before the sustainability and two datasets requirements, though many already addressed (and therefore inspired) those requirements):

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
    <a href="/assets/images/S25-257-UFOs.png">
    <div class="card">
    <img src="/assets/images/S25-257-UFOs.png" alt="Screenshot of UFOs website" style="width:100%">
        <div class="container">
            <h4><b>UFO Sightings</b></h4>
             <br>
        </div>
    </div></a>
  </div>
  <div class="column">
  <a href="/assets/images/S25-257-BannedBooks.png">
  <div class="card">
    <img src="/assets/images/S25-257-BannedBooks.png" alt="Screenshot of Banned Books website " style="width:100%">
        <div class="container">
            <h4><b>The Forbidden Library</b></h4>
             <br>
        </div>
    </div></a>
    <a href="/assets/images/S25-257-Recipes.png">
    <div class="card">
    <img src="/assets/images/S25-257-Recipes.png" alt="Screenshot of Recipes website " style="width:100%">
        <div class="container">
            <h4><b>Flavor Finder</b></h4>
            <br>
        </div>
    </div></a>
    <a href="/assets/images/S25-257-Covid.png">
    <div class="card">
    <img src="/assets/images/S25-257-Covid.png" alt="Screenshot of Covid website " style="width:100%">
        <div class="container">
            <h4><b>COVID-19 Data</b></h4>
             <br>
        </div>
    </div></a>
    </div>
</div>