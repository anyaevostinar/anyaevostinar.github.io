---
layout: page
title: Final Project
permalink: /classes/361-f26/hw-final
---

## Logistics
The final as a whole is due at the end of exams, Nov 23rd, 9:30pm.
Because there is not a further opportunity to revise, there are intermediate draft deadlines to get feedback and be sure you are going in the right direction.

## Collaboration policy

For this assignment, you will be assigned to work with 1-2 students from the ODEs class. You should discuss your implementation in depth with your partner(s). Further, you may discuss the project at a high level with other students in our class, however you must type up all of the code yourself.  (It is therefore unexpected for two code submissions to be completely identical.)  You can discuss the assignment with Anya, our course staff, or any lab assistants.  

You should list any student or course staff with whom you discussed the assignment and the manner of discussion in your `README.md` file.

## AI policy
As discussed in the syllabus, there are both acceptable and unacceptable uses of genAI in this class. **Regardless of whether you use any genAI, you need to complete the** `AI Log` in the `README.md` to satisfy the advanced requirement.

If you choose not to use genAI at all, you may state that for your AI Log (and I fully support this choice). I'd be interested in your reasons, though it's not required to write them in the log for every assignment.

If you do choose to use genAI, you should log it in the `AI Log` section of the `README` in the following format:
* Date: Summary of use and assessment of usefulness

For example, a hypothetical log could be:
* 8/25/26: I asked Gemini how to do default values for a constructor and it helped me figure it out
* 8/26/26: I couldn't figure out the problem with the `ApplyLinearSpringForces` method and Gemini was completely useless
* 8/26/26: I googled the problem with the `ApplyLinearSpringForces` and the AI summary was helpful

This log requirement is both to give me an idea of how useful genAI is in this context and to make sure that your learning isn't being hampered. As mentioned in the hypothetical log, you should include any genAI resources that you use, even the AI summary shown in search results or GitHub Copilot (which shows up as autocomplete in VSCode now).

## Goal
The goals of this project are:
* To develop and demonstrate interdisciplinary communication skills
* To expand your ability to create an artificial life model to capture key dynamics of a system
* To explore the strengths of different modeling approaches to the same problem

## Setup
You'll again be using the Empirical library for this project. I've provided starter code similar to the Artificial Ecology homework to give you a starting place, though you will obviously need to further customize it depending on the ODE your group is working from.

1. Go to our [361-F26](https://github.com/361-F26) Organization and find the `Final-Project` repository for your account. Use `git clone --recurse-submodules [URL]` as usual.

3. Then, go to the `emsdk` folder and install and activate `emsdk`:
```
cd emsdk
./emsdk install 3.1.49
./emsdk activate 3.1.49
```

4. Then source `emsdk`. You'll need to do this command anytime you open a new Terminal, so if you are getting an error about `emcc` not existing, you probably forgot to do this:
```
source ./emsdk_env.sh
cd ..
```

5. Verify that everything is set up correctly by going back to the top level of your repository and running the appropriate compile-run script.

## Assignment Specification
For this assignment, you will:
* work with your ODE partner(s) to understand the key dynamics in the published ODE model and their extension.
* implement the biological system modeled, possibly including the extension
* compare your system's results to the ODE predictions
* create and record a group presentation explaining your implementations and comparing your results

## Intermediate Feedback
You should submit a nearly-complete version of your code and README by Monday, Nov 16th at 10pm. I will then give you feedback on those components so that you are prepared to create the presentation and do any final updates.

## Assessment

### Core Requirements
The Core requirements for this project are:
* Run and output data to a file when `compile-run-mac.sh` is run (i.e. the non-GUI version)
* Reasonably captures the key dynamics of the ODE
* Report in the README the exact paper that your group is replicating (include a link)
* Report in the README what the key dynamics of the ODE were and how you implemented them in the `Core` section
* Submit a group presentation where you explain your implementation and results
    
### Advanced Requirements
The Advanced requirements for this project are:
* Complete all core requirements.
* Run and display a GUI of your system when `compile-run-web.sh` is run
* Closely capture the key dynamics of the ODE
* Report in the README `Advanced` section where your results match and diverge from the ODE predictions
* Your portion of the group presentation is clear and insightful


## Submission
As always, you should **add/commit/push** your files to GitHub and then tag your commit:

```
git tag -a initial_submission -m "initial submission"
git push origin initial_submission
```