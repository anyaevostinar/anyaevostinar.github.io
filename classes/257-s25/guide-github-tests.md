---
layout: page
title: Checking tests on GitHub
permalink: /classes/257-s25/test-guide
---

Some of your deliverables will have GitHub "Actions" set up to automatically test your code. This guide helps you find more details on the tests that are failing.

1. Click on the "Actions" tab near the top of your repository landing page:

![Screenshot of GitHub page with Actions tab highlighted](/classes/257-s25/test-screenshot1.png)

2. Click on the text of your most recent commit (or earlier if you want). If it is failing, it will have a red circle with an X:

![Screenshot of GitHub Actions page with failing test highlighted](/classes/257-s25/test-screenshot2.png)


3. Click on the box that says 'run-autograding-tests':

![Screenshot of GitHub tests page](/classes/257-s25/test-screenshot3.png)

4. Click the step "Run tests for Basic Command Line App" to get the details of which test failed:

![Screenshot of action output](/classes/257-s25/test-screenshot4.png)

5. Read the information in the Traceback carefully, it likely points to exactly the difference between your test and the correct output. If you aren't sure how to fix it, reach out for help!

6. Note that you can also look at the results of "Coverage report" to see how much of the production code you are testing at a basic level, i.e. is that code even run when the tests run:

![Screenshot of coverage report](/classes/257-s25/test-screenshot5.png)