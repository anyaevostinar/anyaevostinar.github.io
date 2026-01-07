---
layout: page
title: Git Labs
permalink: /classes/257-w26/lab-git
---

* [Part 1 (Individual)](#part-1-objectives)
* [Part 2 (Team)](#part-2-objectives)

## Part 1 Objectives
* Introduce you to git and GitHub (or re-introduce you if you've used it before).
* Practice the git workflow for using version control on software projects, in an individual repository
* Practice the git command line interface
* Work with both your local repository (via git) and your personal remote repository (on GitHub).

## Collaboration
You should work individually on this part, but feel free to work simultaneously with nearby classmates for moral support and help.

## Prerequisites
From the [Getting Started Lab](getting-started), you should already have:

* A GitHub account
* A local installation of git on your machine

## Step 1: Accept the assignment
Normally you would make your own new repository at this point, but we're going to use a tool called Git Classroom that let's us keep all of your repositories a bit more organized.

**Accept the assignment by clicking on the link in Moodle "Git Individual Link"**, which will set up a new git repository for you that I also have access to. You should now see this (with your username instead):

![Empty git classroom repository](/classes/257-f23/git-lab-images/Image1.png)

There is some extra stuff that has to do with a feature for giving feedback that we are going to try out, but don't worry about it right now.

## Step 2: README
You should always have a README file for a repository and GitHub let's you do some editing of files like this right in the browser. Click the "Add a README" button:

![Green button says Add a README](/classes/257-f23/git-lab-images/Step2.png)

If the syntax doesn't look familiar to you, this is *markdown*, which is a quick way of adding rich text-like features to plain text. The "#" indicates a top-level heading; "normal" text is just typed. You can just type normal text and be just fine, but if you're interested in learning more, check out [this resource](https://www.markdownguide.org/basic-syntax/).

There is a lot of opinion out there on what should all be in a README, but at a minimum it should provide an overview of the contents and links to any relevant information such as documentation. You don't actually know what all is going to go into this repo yet, and that's okay. **Add the creation date and a description about how it is a test repository.**

**Scroll to the bottom to commit the file to the repository.** (Since this is our remote repository, we don't need to push the file this time.) Make sure you **add a commit message** to the log like I've done. This allows you to go back and read descriptions of what you've committed, rather than trying to deduce this later from the set of files you committed:

![Dialog box for adding a commit message](/classes/257-f23/git-lab-images/Step2-2.png)

So now your repo should look something like:

![Repository with a README.md file](/classes/257-f23/git-lab-images/Step2-3.png)

## Step 3: Make a local version of your repository
For this next set of steps, you should open VSCode and work through its Terminal.

We don't currently have a local version of our repository. To create one, we can clone the remote repository.

First, go to a terminal, and create a directory for this class `CS257`. This is where your local repository will live (and is a good place to keep all the other repositories you will use for this class). (Use your newly-acquired Unix skills to do so!)

Now we're ready to rock. Go to the GitHub page for the repository that you created. Click on the green "Code" button. You should see something that looks like this: 

![Code button selected and showing dropdown](/classes/257-f23/git-lab-images/Step3.png)

**Make sure you see https:// as the first part of the URL**. If you don't, click on "Use HTTPS" in the right hand corner of that box.

Copy the URL (pressing the clipboard icon next to the URL should do the trick). Then, in your terminal, type the following:

```bash
git clone [URL]
```

replacing `[URL]` with the URL that you copied and pasted from GitHub. For instance, past-me (who was doing a version of this lab with a different repository name) would do:

`git clone https://github.com/CS-257-S22/individual-deliverables-anyaevostinar.git`

List the contents of your current directory and make sure you see the name of your repo (for instance, current-me would see a directory named `git-lab-anyaevostinar`). Change into that directory. You should see `README.md` listed. If so, huzzah! You now have a local version of your repository.

## Step 4: Add files locally
Most of the work you'll do will be in your local repository. In other words, you'll create and edit files on your own computer. You'll then have to add and commit these to your local repository, and then make sure these edits are pushed to the remote repository, so that everything is in sync.

1. **Create a file for you repository, named `favorite_foods.txt`.** This is a plain text file, and should **list your three favorite foods**. Within VSCode, you can make a new file with the "File" menu option or there is a new file shortcut above the list of all the files on the left side.

2. Satisfied with the list? **Make sure you've saved the file in your local repo directory.** (Do an `ls` in the terminal to make sure it's there. If you don't see it, go back to the text editor and do a "Save As", making sure you're saving it to the right directory.)

Now let's add it to our local repository. To do this, we need to *stage* the file and then *commit* the file. Staging tells git we intend to make this change to the local repository, and commit follows through with this intention and actually makes the change.

3. In the terminal (make sure you're still in your repo directory!):

```bash
git add favorite_foods.txt
git commit -m "Some favorite foods"
```

The part `-m "Some favorite foods"` writes the message "Some favorite foods" to the git log, similarly to what we did when we directly edited our `README.md` file on GitHub.

4. We've changed our local repository; now let's change the remote repository to reflect these changes by pushing our changes "upstream". In the terminal:


```bash
git push
```

5. Now if you go back to GitHub and refresh the page, you should see the changes you made locally.

You should see something in that middle box that says "4 commits", or something similar:

![Git repository screen with 4 commits circled](/classes/257-f23/git-lab-images/Step4.png)

If you click on what I've circled, you can see a history of what you've committed, including the log messages you typed.

You can also see this history locally by typing in your terminal:

```bash 
    git log
```

## Step 5: Adding and modifying files
Anytime you add a new file OR make a change to an existing file, you need to stage the file using `git add`. If you want to add all of the files that have changed, you can type `git add *` (but I recommend you don't do that most of the time, since you might end up adding things that you didn't mean to add!).

Here are some things to try. After each one, make sure you add, commit, and push your changes as outlined above.

1. Modify your `favorite_foods.txt` file so that it lists a few more foods.
2. Add a text file named `favorite_hobbies.txt` that lists some of your favorite hobbies.
3. Add a text file named `least_favorite_foods.txt` listing a few of your least favorite foods.

## Step 6: Removing files but keeping them in the history
You've decided that you don't want that kind of negativity in your life right now, so you want to remove `least_favorite_foods.txt` so that you don't see it in your repository anymore. However, you do want to maintain its existence in the commit history. How do you do this?

Basically, you "reverse-stage" the file using `git rm`, and then commit and push as usual:

```bash 
git rm least_favorite_foods.txt
git commit -m "removed least favorite foods"
git push
```

You should no longer see it in your repository, although it will still be in the history.

## Step 7: Practicing merge conflicts on your own
One of the most annoying and frustrating aspects of working on a shared codebase is when two people make changes to the same file at the same time, and one commits and pushes before the other. How do you recover from this?

The fancy term for this scenario is a *merge conflict*, and it is quite common. There are some ways we can minimize the odds of a merge conflict occurring:

* Before you start working on your code, and before/after you commit/push changes, make sure you bring your local repository up to date. You can do this via either `git checkout` or `git fetch` in your repo directory.
* Try to have different people work on different branches, and merge the changes back in later. (We'll cover that in Part 2 of the lab.)
* Communicate about who's working on what, to avoid duplicating efforts. This is probably the easiest and most overlooked way to avoid merge conflicts!

For this part, you are going to create your own merge conflict, so that you can learn how to resolve merge conflicts when the stakes are low and you don't have to coordinate with other people.

1. First, update your repository before you start making local changes. In your repo directory (in a terminal):

```bash
    git checkout
 ```

It should tell you that "Your branch is up to date with origin/main" which is a happy moment!

2. Now, go back to GitHub and click on one of the files in your repository. You're going to edit this on GitHub directly, by clicking on the pencil icon:

![Github file view with pencil icon circled](/classes/257-f23/git-lab-images/Step5.png)

Edit, add a commit message, and then commit like we did with the `README.md` file earlier.

3. Now, go back to your local copy of the repository, and **edit the same file.** Add and commit as you normally do. When you push, however, you'll get an error that looks something like this:

```bash 

! [rejected]        main -> main (fetch first)
    error: failed to push some refs to 'https://github.com/CS-257-S22/individual-deliverables-anyaevostinar.git'
    hint: Updates were rejected because the remote contains work that you do
    hint: not have locally. This is usually caused by another repository pushing
    hint: to the same ref. You may want to first integrate the remote changes
    hint: (e.g., 'git pull ...') before pushing again.
    hint: See the 'Note about fast-forwards' in 'git push --help' for details.

```

Stay calm! Git messages are actually pretty helpful, and it's telling you why your update was rejected. It even gives you a hint of what to do next! 

4. To fix this, you will need to first pull:

```bash
git pull
```

You will then likely get another error that looks like this:
```bash
hint: You have divergent branches and need to specify how to reconcile them.
hint: You can do so by running one of the following commands sometime before
hint: your next pull:
hint: 
hint:   git config pull.rebase false  # merge
hint:   git config pull.rebase true   # rebase
hint:   git config pull.ff only       # fast-forward only
hint: 
hint: You can replace "git config" with "git config --global" to set a default
hint: preference for all repositories. You can also pass --rebase, --no-rebase,
hint: or --ff-only on the command line to override the configured default per
hint: invocation.
fatal: Need to specify how to reconcile divergent branches.
```

5. As that says you need to tell git how to handle the reconciliation that it needs to do. Again, the hints are pretty useful, and you can just do the first one. As it mentions, it's a good idea to have it be a global default so you don't have to do this again:

```bash
git config --global pull.rebase false
```

6. Now try pulling again and git will try to smoosh the changed files together, but it won't be able to do the merging automatically because it doesn't know which version of the changes you actually want to keep. This is a time when using VSCode is nice because it helps you with "merge conflicts" if you know what it's doing. 

5. Open the file that you changed in VSCode and you should see something like this:

![Merge conflict in VSCode](/classes/257-f23/git-lab-images/Step6.png)

Whether you are using VSCode or not, those funky "<<<<<<<<< HEAD" ">>>>>>>>>>>>>>>>" with a long alphanumeric string mean that git isn't sure which of these lines you want in this file. If you aren't using VSCode, you might have to just manually delete one or the other (or just get rid of two weird lines if you want to keep both), but VSCode gives you some nice buttons to speed up this process. 

6. You can click "Accept Current Change", "Accept Incoming Change", or "Accept Both Changes" and VSCode will fix the file for you.

7. Now you just need to save, add, commit, and push and everything will be fixed.

## Part 1 is done!
Make sure all of your lab files are committed and pushed to your GitHub repository.

## Part 2 Objectives

* Introduce, or re-introduce, you to git and GitHub.
* Practice the git workflow for using version control on software projects, in your team repositories
* Practice the git command line interface
* Work with both your local repository (via git) and your team's remote repository (on GitHub).

## Collaboration
Work with your project teams on this part of the lab. Make sure you finish Part 1 before attempting this part of the lab.

## Step 1: Make a team repository
You will need to set up your team's project repository before you begin. To do so, do the following:

* Have **one** member of your team make a repository and invite the other team members to this repository. **Name your repository "X", where you replace "X" with the (capitalized) letter of your team.**
    * That person should accept the invitation by clicking on the link in Moodle ("Team Git Repo")
    * Accept the assignment.
* Everyone else should accept the invitation and select your team

The team member that creates the team repository should update the README file. For now, just list your team members' names in this file. You can edit it directly in GitHub, as we did in Step 2 of Part 1.

## Step 2: Set up your local repository
Clone the team's repository in a VSCode terminal, as you did with your own repository in Part 1. `cd` into that directory and make sure you see the README file.

## Step 3: Creating your own working branch
In Part 1, I mentioned that one way you could minimize merge conflicts was to have team members work on separate branches of the code. We are going to practice branching in this part of the lab.

A branch can be thought of as a "parallel track" to the main track of the repository. The main is the "official", ready-to-deploy-if-necessary version of the codebase. Branches are works in progress that ideally will be integrated into main at some point. Branches allow you to try out ideas, or work on particular features, until you're satisfied with them.

[This article](https://thenewstack.io/dont-mess-with-the-master-working-with-branches-in-git-and-github/) is a nice, easy to follow introduction to branches and branching, and a lot of what we'll be doing in this part of the lab is similar to what you'll find in that article.

1. First, create a branch locally. In your terminal:

```bash
git checkout -b dev-branch-NAME
```

Replace NAME with your first name (no spaces or special characters). This command creates the branch, and then performs a checkout, which creates a "snapshot" of the codebase at that moment within your branch.

(If you want to check out a branch that's already been created, do `git checkout BRANCH_NAME`)

## Step 4: Making some changes
Since we'll eventually merge everyone's branches back into main, this next part will require a bit of coordination on the part of team members. If your team members aren't done with Part 1 yet, feel free to just pick two topics and start by listing your information and you can check with them as they are finished.

1. Each person's branch should contain two text files: 
    * one containing a list of each team member's favorite ____, 
    * one containing a list of each team member's least favorite ____. (This part will thus require you to communicate with your team, and will teach you a bit about your team members.)

The topics you can choose from, although feel free to substitute your own:

* Movies
* Foods
* Animals
* Hobbies
* Hot beverages
* Cold beverages
* Books

This is easier with an example, so I'm going to use the mythical Team Q to illustrate.

* Team Q decides to go with "movies", "foods", "animals", and "hot beverages".
* Team Q assigns one topic to each team member:
    * Radia is assigned "movies"
    * Manuel is assigned "foods"
    * Timnit is assigned "animals"
    * Joy is assigned "hot beverages"

* Let's follow Radia as she works on her branch:
    * Radia creates a branch named `dev-branch-radia`
    * Radia creates two text files: `favorite_animals.txt` and `least_favorite_animals.txt`
    * Radia asks everyone to let her know what their favorite and least favorite animals are.
    * A fight breaks out between the cat people and the dog people....
    * ...but Radia ignores the fight that's brewing, and adds everyone's favorite animal (along with their name) to the `favorite_animals.txt` file, and everyone's least favorite animal (along with their name) to `least_favorite_animals.txt`.
* Everyone else on Team Q does the same with their topics, on their own branches.

2. Once you've added the appropriate information to the appropriate text files, commit and push your branch upstream. To do so:

```bash
git add *
git commit -m "favorites from my teammates"
git push -u origin BRANCH
```

Replace BRANCH with your branch name.

3, Now, if you go to GitHub, you should be able to see your branch (and your teammates' branches too, if they've already pushed their branches). Go to the circled drop-down menu: 

![Git repository with main circled](/classes/257-f23/git-lab-images/TeamStep3-1.png)

When you click on it, you should see this drop-down:

![Main with drop down](/classes/257-f23/git-lab-images/TeamStep3-2.png)

Select your branch (or one of your teammate's branches), and you'll see the snapshot of that branch displayed.

## Step 5: Merging your branch back into main
Only what is on `main` will be considered for deliverable submissions, so you should make sure to regularly merge your branch into main once it is ready to be assessed or combined with your teammates work.
1. Run the following to merge your branch into main:

```bash 
git checkout main
git pull
git merge BRANCH -m "merging my branch into main"
git push
```

(Replace BRANCH with your branch name.)

2. Now go back to GitHub and switch back to viewing main. You should see your branch's files.

3. If you want to delete your branch, go ahead and do so:

```bash 
git branch -d BRANCH
```

(Replace BRANCH with your branch name.)

It is common practice to have a `dev` branch specific to a new feature such as `dev-book-page` that you then delete once the feature is merged into main. You can do everything from your named branch if you want, but it's good practice to instead have branches for each new feature that you are working on.

## Step 6: Practicing merge conflicts with your team
For this part of the lab, you will create a merge conflict and then resolve it within your team. You'll do this all through working directly on `main` to make things easier, but this can also happen when you merge a branch into main.

To create the merge conflict:

1. Make sure you all have the latest snapshot of the main branch locally:
```bash 
git checkout main
git pull
```
2. Agree on which file you'll edit simultaneously, in your local repository.
3. Everyone should edit and commit the file that they are working with locally.
4. One person should push changes to the repo first.
5. Once they have successfully pushed their changes, the other two should try to also push your changes. Bingo: merge conflict achieved!
6. Repeat the steps from Part 1 to resolve the conflicts.

## Part 2 is done!
You can now delete the favorite and least favorite files from your team repository and transfer the information from your team contract Google doc notes and data set into your team repository!

Make sure to add your dataset metadata and the dataset itself to the team git repository.

**If there is still time in class, keep working on your proposal and team contract!**

*This lab was adapted from one written by Prof. Amy Csizmar Dalal, thanks Amy!*