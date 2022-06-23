---
layout: page
title: Summer Research 2022
permalink: /classes/summer-22/schedule
---

Information for summer students:

## Every Week
The structure on a typical week will be:
* One-on-one meeting with Anya ~30 minutes
* Daily group 'stand-up' meeting ~15 minutes (9:30 everyday)
* Weekly longer group meeting ~1 hour (2-3 on Tuesdays)
* Expectation that you work 40 hours and make the meetings but otherwise schedule is flexible, but remember you need to submit your hours on the Hub
* You are encouraged to work in our room, Olin 312, but not required
* You are encouraged to ask each other for help and advice first and help each other when asked, though always also welcome to get help from me

## June 27th

### Group meeting at 9:30am
We'll have initial group meeting at 9:30am in our meeting room, Olin 312, which is on the third floor of Olin.

At that meeting we'll discuss:
* Anya's schedule this week (it's busy)
* Introductions and expectations
* The subprojects for the summer
* RCR training (see below)
* When the group meetings will be

### RCR (Responsible and Ethical Conduct of Research)

Many federal grant making agencies – including the National Science Foundation and the National Institutes of Health – require grantees like me to prove that they provide appropriate training and oversight for all researchers on a project in the responsible and ethical conduct of research (RCR).

To meet these requirements, Carleton has subscribed to [Collaborative Institutional Training Initiative (CITI)](http://www.citiprogram.org/) to provide “RCR for Undergraduate Researchers” that can be used by anyone involved in a federal grant to obtain RCR training, including but not limited to research trainees such as undergraduates. If you have already completed RCR training as an undergraduate, you need not do so again.

The step-by-step instructions to access the CITI training modules are provided on the [College's Responsible Conduct of Research](https://apps.carleton.edu/cfr/grants_adminstration/RCR/) page. The training includes 6 required modules and 3 elective modules.

These quizzes must be completed by June 27. Once you complete the quizzes, I will be notified.

## Rest of Week 1

### Project preferences
You should email or Slack message me what your preferences are for subproject and partner or that you don't have a preference.

### Readings
There are more background readings linked in the shared drive to give you a better idea of the subprojects.

### Computer Setup

(This should be review from the term, but make sure that everything still works.)

You'll be running experiments on my two research servers which only support `ssh`. 
Verify that you can log on to both (though you'll probably only use one, we'll divide them by project):
* edmonstone.mathcs.carleton.edu
* margulis.mathcs.carleton.edu

(Curious about the names? Read about [John Edmonstone](https://en.wikipedia.org/wiki/John_Edmonstone) and [Lynn Margulis](https://en.wikipedia.org/wiki/Lynn_Margulis))

I recommend you use [VSCode](https://code.visualstudio.com/) for working with the code base locally, though it's not required.
We'll use `git` to share code and move it between your local machine and the research servers, so if you aren't familiar with `git` and GitHub or would like a refresher, look through [this guide](https://guides.github.com/introduction/git-handbook/).
I also recommend RStudio for when you eventually want to make plots/graphs, so you can [download that](https://www.rstudio.com/products/rstudio/download/) right away (the free version!).

### Symbulation
We'll be making additions to my software, Symbulation, so download it (with `git`) from [here](https://github.com/anyaevostinar/SymbulationEmp) along with [Empirical](https://github.com/devosoft/Empirical) and try running it. Explore the different settings in `SymSettings.cfg` and try changing them to see what happens!

### Handy Commands
(Anya forgets about these and so this is somewhat a reminder for them but also useful for students)

To see the load on the cores on the servers:
```
htop
```

To get C++17 working on the servers, run:
```
scl enable devtoolset-9 bash
```

To run a process in the background:
```
screen python stats_scripts/simple_repeat.py
```

Use the key sequence `Ctrl-a` + `Ctrl-d` to detach from the screen session. At this point you could close the window or go do other things while this is running.

To reattach, on the command prompt type

`screen -r`