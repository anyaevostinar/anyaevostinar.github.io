---
layout: page
title: Project Final Version
permalink: /classes/257-s22/project-final
---

## Overview
As you know, for this course you are developing a data-driven website using the Flask framework with a team.
This page details the final expectations for your team project and will be added to throughout the term as you construct each of the pieces.

## Collaboration

You should work with your team on this project.
You are able to get help from outside sources, as specified in the syllabus, but everything that your team submits should be your own.

## Due Date

The final version of the project is due Monday June 6th at 5pm on GitHub.
There are no revisions allowed after this point and no late submissions can be graded per [official college policy](https://apps.carleton.edu/handbook/academics/?policy_id=21449&a=student).

## Your Task
Your overall task is to create a data-driven website using the Flask framework, which you will do throughout the term.
There are several subcomponents, which you will have the opportunity to submit and receive feedback on before the final evaluation at the end of the term.
Each subcomponent is listed below with a link to its page and the final evaluation criteria for it.

## Revising subcomponents
You will have submitted the subcomponents, received feedback on them, and submitted revised versions of them by the end of the term.
If your revised versions needed further revision, you may make further revisions before the end of the term.
You may request that a subcomponent revision is evaluated again (after the first round of revision), but I make no guarantee of how soon that will happen. 
Assessment and feedback will be prioritized for the initial submission and first round of revision, and any further revisions may or may not be assessed before the end of the term.
To request assessment of a subcomponent after the first round of revision, [fill out this Revision assessment request form](https://docs.google.com/forms/d/e/1FAIpQLScSenY2oAvj8HOSNQMCwikqLcNW_ymrPRf-45PKY0cRc4LlQg/viewform?usp=sf_link), which will email me. 

### Project Description
You originally submitted a project proposal that included the dataset, interesting features, and the team contract.
That can now be considered your project description.
See the [Moodle page for the requirements](https://moodle.carleton.edu/mod/assign/view.php?id=751800).

### Command line/core functionality

The [first subcomponent of the project](project-command-line) is a command line interface and the core functionality.
Your final version should still support command line functionality even though it will also have a browser-based functionality (this is a common practice to enable more automated interaction with your database).

The requirements for this subcomponent are:
#### Meets Expectations Criteria
* Functionality:
  * There is a functional usage statement
  * There are two independent features controlled by a command line interface that allows the user to get information from the chosen dataset
  * There is an automated test suite that covers all the typical cases and some of the edge cases
* Design:
  * The functions/methods are mostly written at a single layer of abstraction
  * Function names, return values, and parameters generally follow the principles of good design
  * Function/method [docstrings](https://peps.python.org/pep-0257/) generally provide the required information
  * There isn't an excessive amount of repeated code
  * Style mostly follows the [style guide](https://peps.python.org/pep-0008/)

#### Exceeds Expectations Criteria
* All the Meets Expectations criteria are met
* Functionality:
  * The test suite covers nearly all edge cases
  * The test suite includes sufficient integration tests
  * The usage statement is thorough and clear
  * The features are interesting and enable the user to gain a large amount of information from the dataset
* Design:
  * The functions/methods are all written at a single layer of abstraction
  * Function names, return values, and parameters all follow the principles of good design
  * Function/method [docstrings](https://peps.python.org/pep-0257/) all provide the required information
  * There is barely any duplicated code



### Flask App
The [second subcomponent is the Flask app](project-2-flask) that connects your core functionality to the browser.

The requirements for this subcomponent are:

#### Meets Expectations Criteria
* Functionality:
  * Uses the Flask framework correctly
  * There is a useful 401 page
  * There are two independent features controlled by separate routes that allows the user to get information from the chosen dataset
  * One of the routes uses a route parameter that has some influence on what is displayed
  * There is an automated test suite that covers all the typical cases and some of the edge cases
* Design:
  * The functions/methods are mostly written at a single layer of abstraction
  * Function names, return values, and parameters generally follow the principles of good design
  * Function/method [docstrings](https://peps.python.org/pep-0257/) generally provide the required information
  * There isn't an excessive amount of repeated code
  * Style mostly follows the [style guide](https://peps.python.org/pep-0008/)

#### Exceeds Expectations Criteria
* All the Meets Expectations criteria are met
* Functionality:
  * The test suite covers nearly all edge cases
  * The test suite includes sufficient integration tests
  * The 401 page is thorough and clear
  * The features are interesting and enable the user to gain a large amount of information from the dataset
  * The route parameter(s) are highly effective in enabling the user to gain specific information from the dataset
* Design:
  * The Flask-specific functionality is separate from the core functionality in separate files
  * The functions/methods are all written at a single layer of abstraction
  * Function names, return values, and parameters all follow the principles of good design
  * Function/method [docstrings](https://peps.python.org/pep-0257/) all provide the required information
  * There is barely any duplicated code

### Front-end
The third component of the project is a polished front-end that uses HTML and CSS to create a well-structured, usable, and accessible website.

More details will be added once we have started this component.

### Back-end
The fourth component of the project is a database back-end to support your website. 

More details will be added once we have started this component.