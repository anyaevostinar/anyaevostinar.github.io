---
layout: page
title: Finding PR Feedback Guide
permalink: /classes/257-s25/guide-migrate-project
---

## We made a cool website… Now what?
### Photo & Video Screen Captures of your Website
There are many resources online on how to do video & photo screen captures. Here are some tutorials on how to take a [photo screen capture](https://www.wikihow.com/Take-a-Screen-Shot-(Screen-Capture)), how to take a video screen capture on [Mac](https://support.apple.com/en-us/102618) and on [Windows](https://www.microsoft.com/en-us/windows/learning-center/how-to-record-screen-windows-11) machines.

Once you have your photo & video screen captures, you can upload them to your LinkedIn, portfolio, or whatever platform you use for professional development.

### Move your Team Project onto your own GitHub
1. Download the files in your team repo as a zip file:

![Download box highlight on git repo](/classes/257-f23/git-lab-images/Download.png)

2. Create a new public repo on your GitHub account with no README

3. Clone the new repo onto your local machine, move the files from the zip file into the repo, and push those files to the new repo.

4. Now that you have your own copy of your team project on GitHub. Make sure to:
* credit your teammates in the `README`
* describe **your own contributions** to the project in the `README`
* replace any team-specific credentials with your own (e.g. switch from the team’s database to your own database; if you used another teammate’s API key for the team project, replace it with your own)
remove any sensitive information (e.g. passwords in `psql_config.py`, API keys) & add those file names into your `.gitignore`

Spruce it up a little by making more of the design improvements in this deliverable or if you’re feeling particularly ambitious, add more features. As a public repository, you can now use it as a code sample when applying to internships & jobs.

### Moving your Database from Stearns to your Local Machine
Your account and (individual) database on `stearns` will remain active until you graduate. However, your team database is likely to get reused the next time I teach the course. If you want, you can recreate your team tables in your individual database, so you can  demonstrate your project (e.g. at job fairs or interviews) by connecting to `stearns` even after this class ends. However, the Director of IT for CS reserves the right to delete your tables if `stearns` server starts running out of space (they’ll let you know ahead of time of course!).

To move your database from `stearns` to your local machine so you can demonstrate everything locally, here are the tutorials for [Mac] and [Windows](https://stolafcarleton.teamdynamix.com/TDClient/3356/Portal/KB/ArticleDet?ID=162325).
