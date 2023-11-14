---
layout: page
title: Project Version 3 - Frontend
permalink: /classes/257-f23/project-3-front-end
---

## Overview

The goal of this component of your project is to add the front-end component to your Flask app.

The learning objectives for this component of your project are to be able to 1) create usable and accessible front-end for your website and 2) continue to create code that follows the principles of good function design.

## Collaboration

You should work with your team on this portion of the project.
You are able to get help from outside sources, as specified in the syllabus, but everything that your team submits should be your own.

## Due Date

This iteration of the project is due Monday Oct 23rd at 10pm on GitHub.

## Your Task

Your team should add a front-end GUI component to your Flask app that:
* Uses HTML and CSS correctly to create a usable and accessible website that follows the web design best principles we have discussed in class
* Allows the user to interact with your dataset in at least two meaningful ways (i.e. the features that you have been developing all along)
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

The criteria for "Demonstrates Proficiency" and "Demonstrates Mastery" are below.
When evaluating your project, the grader will pull down your team's repo and run both your production code and test suite, as well as look through your code for style.

### Proficiency Criteria
* Functionality:
  * The front-end works with the existing components (Flask and command-line)
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
    * [forms labeled correctly](https://webaim.org/techniques/forms/controls#input)
    * links make sense out of context
    * [correct use of bold vs strong](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/strong)
  * The HTML and CSS are in separate files
  * HTML code is acceptable, perhaps with minor presentation aspects bleeding in
  * HTML and CSS code is somewhat organized
  * CSS code is acceptable; Some aspects of the CSS could be accomplished more efficiently.

### Mastery Criteria
* All the Proficiency criteria are met
* Front-end:
  * Page does an excellent job enabling scanability, satisficing, and muddling through. Strong execution of conventions and best practices for content organization and accessibility.
  * HTML only deals with content structure and not any aspect of presentation. Code is clearly and concisely written. All tags used appropriately.
  * CSS clearly captures the look-and-feel of the site and renders correctly. Code is clearly and concisely written.

## Addendums

For mastery, your website needs to be complete, polished, and cohesive.