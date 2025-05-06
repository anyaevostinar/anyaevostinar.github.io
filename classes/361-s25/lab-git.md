---
layout: page
title: Git Labs
permalink: /classes/361-s25/lab-git
---

In this lab, you'll get some practice with the git commands and resolving merge conflicts, which will probably be relevant as you work on your final project in a team. **If you're already comfortable with resolving merge conflicts, you don't need to complete this lab.** (If you've taken Software Design with me, this lab will look very familiar....)

* [Part 1 (Individual)](#part-1-objectives)
* [Part 2 (Team)](#part-2-objectives)

## Part 1 Objectives
* Introduce you to git and GitHub (or re-introduce you if you've used it before).
* Practice the git workflow for using version control on software projects, in your individual repositories
* Practice the git command line interface
* Work with both your local repository (via git) and your personal remote repository (on GitHub).

## Collaboration
You should work individually on this part, but feel free to work simultaneously with nearby classmates for moral support and help.

## Step 1: Accept the assignment

**Accept the assignment by clicking on the link in Moodle "Git Individual Link"**, which will set up a new git repository for you that I also have access to. You should now see this (with your username instead):

![Empty git classroom repository](/classes/257-f23/git-lab-images/Image1.png)

There is some extra stuff that has to do with a feature for giving feedback that we are going to try out, but don't worry about it right now.

## Step 2: README
You should always have a README file for a repository and GitHub let's you do some editing of files like this right in the browser. Click the "Add a README" button:

![Green button says Add a README](/classes/257-f23/git-lab-images/Step2.png)

As a reminder, the README uses markdown. The "#" indicates a top-level heading; "normal" text is just typed. You can just type normal text and be just fine, but if you're interested in learning more, check out [this resource](https://www.markdownguide.org/basic-syntax/).

There is a lot of opinion out there on what should all be in a README, but at a minimum it should provide an overview of the contents and links to any relevant information such as documentation. You don't actually know what all is going to go into this repo yet, and that's okay. **Add the creation date and a description about how it is a test repository.**

**Scroll to the bottom to commit the file to the repository.** (Since this is our remote repository, we don't need to push the file this time.) Make sure you **add a commit message** to the log like I've done. This allows you to go back and read descriptions of what you've committed, rather than trying to deduce this later from the set of files you committed:

![Dialog box for adding a commit message](/classes/257-f23/git-lab-images/Step2-2.png)

So now your repo should look something like:

![Repository with a README.md file](/classes/257-f23/git-lab-images/Step2-3.png)

## Step 3: Make a local version of your repository and file
1. Clone the repository to your folder for this class as you usually do.

2. **Create a file for you repository, named `favorite_foods.txt`.** Put in at least three lines. Add/commit/push as usual.

## Step 4: Practicing merge conflicts on your own
One of the most annoying and frustrating aspects of working on a shared codebase is when two people make changes to the same file at the same time, and one commits and pushes before the other. How do you recover from this?

The fancy term for this scenario is a *merge conflict*, and it is quite common.
For this part, you are going to create your own merge conflict, so that you can learn how to resolve merge conflicts when the stakes are low and you don't have to coordinate with other people.

1. First, update your repository before you start making local changes. In your repo directory (in a terminal):

```bash
    git checkout
 ```

It should tell you that "Your branch is up to date with origin/main" which is a happy moment!

2. Now, go back to GitHub and click on the favorite foods file in your repository. You're going to edit this on GitHub directly, by clicking on the pencil icon:

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

Git will then have a different issue:

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

Again, the message is actually pretty helpful. You need to tell git which strategy you want it to use for resolving merge conflicts in this repository. The first option is the one that you can generally go with.

5. Run the following:
```bash
git config pull.rebase false
git pull
```

6. And git will try to smoosh the changed files together, but it won't be able to do the merging automatically because it doesn't know which version of the changes you actually want to keep. This is a time when using VSCode is nice because it helps you with "merge conflicts" if you know what it's doing. 

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
Work with your final project partner on this part of the lab (if you have one). Make sure you finish Part 1 before attempting this part of the lab.

## Step 1: Make a team repository
You will need to set up your team's project repository before you begin. To do so, do the following:

* Accept the invitation by clicking on the link in Moodle ("Final Project GitHub Link")
* Accept the assignment.
* Have **one** member of your team make a repository and invite the other team member to this repository. **Name your repository with your first names.**

The team member that creates the team repository should update the README file. For now, just list your team member's name in this file. You can edit it directly in GitHub, as we did in Step 2 of Part 1.

## Step 2: Set up your local repository
Clone the team's repository in a VSCode terminal, as you did with your own repository in Part 1. `cd` into that directory and make sure you see the README file.

## Step 3: Creating your own working branch
In Part 1, I mentioned that one way you could minimize merge conflicts was to have team members work on separate branches of the code. We are going to practice branching in this part of the lab.

A branch can be thought of as a "parallel track" to the main track of the repository. The main is the "official", ready-to-deploy-if-necessary version of the codebase. Branches are works in progress that ideally will be integrated into main at some point. Branches allow you to try out ideas, or work on particular features, until you're satisfied with them.

[This article](https://thenewstack.io/dont-mess-with-the-master-working-with-branches-in-git-and-github/) is a nice, easy to follow introduction to branches and branching, and a lot of what we'll be doing in this part of the lab is similar to what you'll find in that article.

1. First, create a branch locally. In your terminal:

```bash
git checkout -b my-branch-NAME
```

Replace NAME with your first name (no spaces or special characters). This command creates the branch, and then performs a checkout, which creates a "snapshot" of the codebase at that moment within your branch.

(If you want to check out a branch that's already been created, do `git checkout BRANCH_NAME`)

## Step 4: Making some changes
Since we'll eventually merge everyone's branches back into main, this next part will require a bit of coordination on the part of team members. 

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

* Team Q decides to go with "foods", and "animals"
* Team Q assigns one topic to each team member:
    * Radia is assigned "animals"
    * Manuel is assigned "foods"

* Let's follow Radia as she works on her branch:
    * Radia creates a branch named `my-branch-radia`
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
1. Once you're satisfied with your changes, and your teammates agree, it's a good idea to merge your branch back into the main track, and delete the branch.

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

## Step 6: Practicing merge conflicts with your team
For this part of the lab, split up again (if you are working solo, you can again edit a file on GitHub's website directly, or skip this part). You'll create a merge conflict and resolve it.

To create the merge conflict:

1. Make sure you both have the latest snapshot of the main branch locally:
```bash
git checkout main
git pull
```

2. As a team, agree on which file to edit simultaneously, in your local repository. 
3. Both of you should edit and commit the file that you are working with locally.
4. One of you should push changes to the repo first.
5. Once one of you has successfully pushed your changes, the other should try to push their changes. Bingo: merge conflict achieved!
6. Repeat the steps from Part 1 to resolve the conflict.

## Part 2 is done!
You can now delete the favorite and least favorite files from your team repository.

**If there is still time in class, keep working on your project topic checkin and proposal!**

*This lab was adapted from one written by Prof. Amy Csizmar Dalal, thanks Amy!*