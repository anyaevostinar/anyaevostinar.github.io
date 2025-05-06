---
layout: page
title: Project Version 4 - Frontend
permalink: /classes/257-s25/project-4-front-end
---

## Overview

The goal of this component of your project is to add the front-end component to your Flask app.

The learning objectives for this component of your project are to be able to 1) create usable and accessible front-end for your website and 2) continue to create code that follows the principles of good function design.

## Collaboration

You should work with your team on this portion of the project.
You are able to get help from outside sources, as specified in the syllabus, but everything that your team submits should be your own.

## Due Date

This iteration of the project is due Monday May 19th at 10pm on GitHub.

## Your Task

Your team should add a front-end GUI component to your Flask app that:
* Uses HTML and CSS correctly to create a usable and accessible website that follows the web design best principles we have discussed in class
* Allows the user to interact with your dataset in at least two meaningful ways (i.e. the user stories that you have been working to support all along)
* Has a useful message when the user enters an incorrect URL
* Keeps the HTML and CSS separate and uses them for their appropriate purposes
* Organizes the HTML and CSS so that the files are readable

You should be building off of your existing code and focusing mostly on the front-end design, though you may find that you need to update some of your core functionality to provide you with data in the format that you want now. Remember to then adjust your tests too!

## Turning it in

Your team should submit this component of the project on your team repo with the tag `front-end` by typing the following:

```
git tag -a front-end -m "front-end Flask app"
git push origin front-end
```

## Evaluation

The criteria for "Proficiency" and "Exemplary" are below.
When evaluating your project, the grader will pull down your team's repo on `stearns` and run both your production code and test suite, as well as look through your code for style.

### Proficiency Criteria
* Functionality:
  * The command-line interface still works
  * The Flask component still works
  * There is a useful 404 page with instructions on how to correctly use the website features
  * There are two independent features that allow the user to get information from the chosen dataset
  * The automated test suite passes (no additional tests are required)
  * Coverage is still at 50%
* Design:
  * `README.md` explains how your website enables:
    * Scanability
    * Satisficing
    * Muddling through
  * Accessibility features
    * resizing text to 150-200% works
    * headings used to structure page
    * alt text for any images
    * color and contrast chosen well for overall readability and colorblind-friendly
    * [forms labeled correctly](https://webaim.org/techniques/forms/controls#input)
    * links make sense out of context
    * [correct use of bold vs strong](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/strong)
  * The HTML and CSS are in separate files
  * HTML code only deals with content structure and not any aspect of presentation
  * CSS code is acceptable; Some aspects of the CSS could be accomplished more efficiently.
  * All HTML tags used appropriately
  * Style checks at all at 5 or higher

### Exemplary Criteria
* All the Proficiency criteria are met
* Coverage is at 90% still
* Front-end:
  * Style checks are all at 10
  * Website is complete, polished, and cohesive. It can be a simple and clean design, but it should look professional.
    * Refer to examples in the [Inspiration section of the Project Proposal](/classes/257-s25/project-proposal#inspiration)
