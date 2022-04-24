---
layout: page
title: Project Version 3 - Individual
permalink: /classes/257-s22/project-3-ind
---

## Overview

This is the individual component of the [Front end component](project-3-front-end) of your team's project.
For this component, you need to write a basic front-end for a portion of your website.
Much of this code won't end up in your team's repository because it will be duplicate. 
Instead, the goal is to get you to practice and start thinking about the front-end individually.

## Collaboration

You should work individually on this component.
You shouldn't coordinate with your team, since the goal is that you get practice individually, and so it's fine if there is some duplication.
You can get conceptual help from your team and others, however what you submit must be all your own work.

## Due Date

The individual deliverable for this iteration is due **Monday May 2nd** at 10pm on your individual GitHub.

## Your Task

You should write a new Flask app that has a front-end design that follows the best principles for web design and uses **mock data** instead of calling your team's project code. You are welcome to copy over code from your original basic Flask app, but instead of importing and using the functions from your team's code, you should create a single data function that simply returns hard-coded data, allowing you to focus on implementing the front-end design.

This is easiest to explain with an example.
If I was doing this for my books and authors dataset, one of the features that I would be interested in would be allowing the user to get information for any of the books in the dataset via a page for each book. For this assignment, I could focus on creating the book information page for the book that I'm currently reading, [Ancillary Justice by Ann Leckie](https://en.wikipedia.org/wiki/Ancillary_Justice) (it's great, you should read it).
I would create a function `getBookData(book_title)` that would do nothing except return a list with the information for this particular book.
In my Flask app, I would call this function and pass it the title and get back the correct result.
I could then focus on making an awesomely designed homepage that indicated to the user that they could get information on all these cool books and there would actually only be the one book that they could choose from, which would then lead them to the beautifully-designed page about that book.
How the user navigates from the homepage to the book page would depend on whether I was going for 'meets expectations' or 'exceeds expectations':
* 'meets expectations' option: just a good ol' fashioned hyperlink
* 'exceeds expectations' option: a form/dropdown/other interactive option that goes beyond a hyperlink (check with me if you want to do something other than a form/dropdown)

Now that you have that example, here are the specifics of the task to meet expectations:
* Flask app that runs without the need for your team's code
* Front-end that is designed following the principles of good web design that we've discussed in class
* A homepage and at least one other page that has data from your data (but hard coded)
* Navigation between the homepage and the other page can be either via hyperlink 

To exceed expectations you can:
* Have a fancier way of getting from the homepage to the other page (form/dropdown/something else)
* Have a fancier display of your data other than text ([displaying a plot](https://towardsdatascience.com/how-to-easily-show-your-matplotlib-plots-and-pandas-dataframes-dynamically-on-your-website-a9613eff7ae3) for example); note that adding a static image doesn't count!

The grader will grade your assignment by:
* Pull down your submission for this deliverable that should be tagged 'front-end'
* Run your new Flask app file
* Navigate from your homepage to your other page
* Examine your code for style and requirements

## Turning it in

You should submit the file with your individual front-end app to your individual deliverables repository with the tag `front-end` by typing the following:

```
git tag -a front-end -m "basic front-end app"
git push origin front-end
```


## Evaluation

The criteria for "Meets Expectations" and "Exceeds Expectations" are below.

### Meets Expectations Criteria
* Functionality:
  * The Flask app works (without the team's code!)
  * There is a homepage
  * There is at least one additional page that displays hard-coded data from the dataset
* Front-end:
  * Site makes a good attempt at providing navigation 
  * Accessibility partially addressed
  * The HTML and CSS are in separate files
  * HTML code is acceptable, perhaps with minor presentation aspects bleeding in
  * HTML and CSS code is somewhat organized
  * CSS code is acceptable; Some aspects of the CSS could be accomplished more efficiently.
* Code Design:
  * Flask code is reasonably easy to read and understand
  * The Flask app code has appropriate [docstrings](https://peps.python.org/pep-0257/) 
  * There isn't an excessive amount of repeated code
  * Style mostly follows the [style guide](https://peps.python.org/pep-0008/)

### Exceeds Expectations Criteria
* All the Meets Expectations criteria are met
* Functionality:
  * One of the following:
    * Navigation from homepage to other page is through form/drop-down/something other than a link
    * Data displayed in format other than text/static images, for example a generated plot
* Front-end:
  * Page does an excellent job enabling scanability, satisficing, and muddling through. Strong execution of conventions and best practices for content organization and accessibility.
  * HTML only deals with content structure and not any aspect of presentation. Code is clearly and concisely written. All tags used appropriately.
  * CSS clearly captures the look-and-feel of the site and renders correctly. Code is clearly and concisely written.
