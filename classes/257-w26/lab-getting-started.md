---
layout: page
title: Getting Started
permalink: /classes/257-w26/getting-started
---

## Goal
Get your laptop setup for the course and start refreshing on Python.

## VSCode
You are likely already familiar with [VSCode](https://code.visualstudio.com/download). **You should download it if you don't already have it.**

## Laptop Setup
(Note this guide is heavily based on [Prof. Jeff Ondich's](https://cs.carleton.edu/faculty/jondich/courses/cs257_f21/assignments/01_setup.html#unix))

As you know from your prep, [Unix](https://en.wikipedia.org/wiki/Unix) is a family of operating systems and both [Linux](https://en.wikipedia.org/wiki/Linux) and [macOS](https://en.wikipedia.org/wiki/MacOS) are Unix-based. You've likely already been using Unix a lot if you have used the lab computers at all since they run macOS. Today's goal is to get you setup with a Unix system on your own laptop.

### macOS
Mac comes with the Terminal app (in Applications/Utilities) where you can work with a Unix command line.
However, VSCode comes with the same Terminal, so it's usually nicest to just use that (Terminal->New Terminal).

### Linux
If you are running Linux, you have a terminal app somewhere, though the name varies. You can also just use VSCode's Terminal.

### Windows
If you are running Windows, you will need to install a few more things. Follow [this guide](https://code.visualstudio.com/docs/remote/wsl) for getting the "Windows Subsystem for Linux" installed on your machine and connected to VSCode. You will do everything through VSCode using the WSL extension.

A few notes:
* If your system supports it, go for WSL 2
* Under "Install your Linux distribution of choice", I recommend that you choose Ubuntu 22.04 LTS (or something 22 LTS, which stands for "long term support")

### Everyone
I recommend also installing this extension for easier pair programming:
* [Live Share](https://code.visualstudio.com/learn/collaboration/live-share)


## Package managers
[Package managers](https://en.wikipedia.org/wiki/Package_manager) make it easier to install and update software on your machine for the kinds of software that you will use in this class. Which package manager you use will depend on your system.

### Windows
You should now have `apt` installed through WSL. Double check with `which apt` in your Terminal. If you don't have it, you should definitely have `apt-get`, so check for that.

### Linux
You should have `apt` or `apt-get`; double check with `which` (in your Terminal `which apt`).

### macOS
Mac doesn't have a proper built-in manager and so you should download [Homebrew](https://brew.sh/) "The Missing Package Manager for MacOS" :). Follow the instructions on that page to install (if you don't already have it).

## Vi(m), Python3, Git
Now let's make sure you have everything you need and install anything you are missing.

Open your Terminal VSCode and type:

```bash
which vi
```

Hopefully the answer will be `/usr/bin/vi`. The "which" command is asking where the `vi` command is located (yes, "where" would probably make more sense). Do it again with two more commands:

```bash
which python3
which git
```

If you don't have either of those installed, you'll need to install them using your package manager:

### macOS
`brew install git` and/or `brew install python3`

### WSL and Linux
`sudo apt install git` and/or `sudo apt install python3` (or `apt-get` if that's what you have.)

## Git
You know how when you are working on a programming project with a partner and one of you makes some changes and emails it to the other, and then the other makes some changes and emails it back? What about when you accidentally both make changes and forget to use the updated version and aren't sure which you need? Or what about when you break your code and can't remember how to get it working again?

[Version control software](https://en.wikipedia.org/wiki/Version_control) is the answer to all of these problems and it will change your life (no guarantees, but I do really love it). The most popular kind of version control is [git](https://git-scm.com/) and the most popular hosting company for git is [GitHub](https://github.com//). GitHub has a lot of great features, including an educational wrapper and student packs with additional features.

1. If you already have a GitHub account and you want to use it for 257, great, just make sure that your Carleton email address is associated with it (Settings->Emails).
    1. If you don't have one or want a new one, go to [https://github.com/](https://github.com/) and use your Carleton email address to make it. I strongly recommend you pick a name that you'd be comfortable putting on a resume.
3. Create a ["classic Personal Access Token"](https://docs.github.com/en/github/authenticating-to-github/keeping-your-account-and-data-secure/creating-a-personal-access-token) (**not a fine-grained PAT**, they are still in beta). Save your **classic** PAT somewhere safe. This will serve as your password when downloading your repositories for class. Some notes:
    1. Set the expiration date past the end of term
    2. In the "Select the scopes", just check "repo", nothing else needed
    3. Remember to copy and paste it into a note on your local machine!
4. Fill out [this survey](https://docs.google.com/forms/d/e/1FAIpQLSeT50VfJMYEZLGVm2o3tScHXAz_nv1ZMEiOS74u8uqAppZC6A/viewform?usp=publish-editor) to let me know your GitHub username.

## Venv
Work through [this guide](/classes/257-s25/venv-guide) to get your Python virtual environment setup with the packages we'll need.

## Python Refreshing
Work through exercises 1 and 3 of [this lab](https://anyaevostinar.github.io/classes/111-w22/files) (skip Exercise 2). Ignore references to COURSES, that's just for the intro students to worry about.
If you need a reference, check out [W3 Schools' Python tutorial](https://www.w3schools.com/python/default.asp).

## Data Exploration
If you've gotten this far, feel free to [start looking for datasets](prep-data) that you might want to use with your team, which is the prep for Friday.