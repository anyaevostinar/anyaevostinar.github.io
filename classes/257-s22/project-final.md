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
The [third component of the project](project-3-front-end) is a polished front-end that uses HTML and CSS to create a well-structured, usable, and accessible website.

The criteria for "Meets Expectations" and "Exceeds Expectations" are below.
When evaluating your project, the grader will pull down your team's repo and run both your production code and test suite, as well as look through your code for style.

#### Meets Expectations Criteria
* Functionality:
  * There is a useful 404 page
  * There are two independent features that allow the user to get information from the chosen dataset
  * The automated test suite passes (no additional tests are required)
* Design:
  * Site makes a good attempt at providing navigation 
  * Accessibility features
    * resizing text to 150-200% works
    * headings used to structure page
    * alt text for any images
    * color and contrast chosen well for overall readability and colorblind-friendly
    * forms labeled correctly
    * links make sense out of context
  * The HTML and CSS are in separate files
  * HTML code is acceptable, perhaps with minor presentation aspects bleeding in
  * HTML and CSS code is somewhat organized
  * CSS code is acceptable; Some aspects of the CSS could be accomplished more efficiently.

#### Exceeds Expectations Criteria
* All the Meets Expectations criteria are met
* Front-end:
  * Page does an excellent job enabling scanability, satisficing, and muddling through. Strong execution of conventions and best practices for content organization and accessibility.
  * HTML only deals with content structure and not any aspect of presentation. Code is clearly and concisely written. All tags used appropriately.
  * CSS clearly captures the look-and-feel of the site and renders correctly. Code is clearly and concisely written.

### Back-end
The [fourth component of the project](project-4-backend) is a database back-end to support your website. 

The criteria for "Meets Expectations" and "Exceeds Expectations" are below.

#### Meets Expectations Criteria
* Files:
  * Database is contained in `data.sql`
  * Code is written to work for the database to be named `webapp`
  * Flask app file specified in the README
* Functionality:
  * Executes the expected queries correctly most of the time. Some strange queries may fail to execute completely correctly.
  * The automated test suite passes (no additional tests are required)
  * Data types match the types from the original dataset and/or are appropriate for the modified data from the dataset
  * Some separation of data into tables where applicable
* Design:
  * Good separation of responsibilities. Some minor tweaks to class design could improve the code (i.e., tighter cohesion and/or looser coupling). 
  * Model-view-controller paradigm followed.
  * Code contains appropriate names and mostly appropriate comments. 
  * Sufficient design of individual methods, with most best practices (parameters, return values, responsibilities) followed.
  * Method signatures adequately match most high-level queries
  * Column names somewhat signify the data they contain
  

#### Exceeds Expectations Criteria
* All the Meets Expectations criteria are met
* Functionality:
  * Executes robustly, without error or with very rare errors. All queries either succeed or fail gracefully.
  * Data is well-curated from the original dataset, with no extraneous data
  * Data types are well-chosen for the dataset
  * data tables contain little to no overlap (higher degree of normalization)
* Design:
   * Strong separation of responsibilities between classes, and between methods within classes. 
   * Tight cohesion in each class, and loose coupling between classes. 
   * Code is strongly self-documenting. 
   * Code contains excellent and appropriate comments. 
   * Design of individual methods is strong (parameters, return values, responsibilities). 
   * Code is appropriately tagged. 
   * There is a strong connection between the method signatures and the high-level actions of the website audience (which in turn strongly match the queries).
   * Column names strongly signify the data they contain