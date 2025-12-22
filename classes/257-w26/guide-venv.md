---
layout: page
title: Working with Python Virtual Environments
permalink: /classes/257-w26/venv-guide
---

*This guide is heavily based on the one by Prof Jean Salac.*

Python doesn't allow you (anymore) to install modules globally, and so to install modules (Python libraries that don't come with the standard installation), you need to work with a *virtual environment* or *venv*. You will need to use virtual environments periodically in this class.

This guide assumes that you've already finished the [Getting Started Lab](getting-started) and therefore are working in a Unix-based system and have Python.

## Setting up a new virtual environment
1. Open a Terminal through VSCode (within WSL if you're on Windows)
2. Make a directory to store your virtual environments. If you use Python for other purposes, you'll likely need different virtual environments.

```bash
mkdir -p ~/.venvs
```

3. Create a virtual environment for this class in your new folder:

```bash
python3 -m venv ~/.venvs/cs257_venv
```

Note: You may get an error message to install the `python3-venv` package. If you get this message, follow the instructions in that message on how to install it in your system.

## Activating a virtual environment
After the following command, you should see in your terminal that the left-hand side of each line will now have a prefix with the same name as your virtual environment:

```bash
source ~/.venvs/cs257_venv/bin/activate
```

Remember to deactivate when you are done:
```bash
deactivate
```

## Installing `pip`
To install new modules, you'll need the Python installer program, `pip`.

1. Check if you have `pip` installed in your virtual environment:

```bash
pip3 --version
```

If you have `pip` already, skip to the next section.

### WSL & Ubuntu
Before installing `pip`, you should make sure everything is up to date:

```bash
sudo apt update
sudo apt upgrade
```

Then install away:
```bash
sudo apt install python3-pip
```

### macOS
You should already have `pip3` since it comes with Python by default, but if you for some reason don't, you should update first:

```bash
brew update
brew upgrade
```

And then install Python again:

```bash
brew install python3
```

### Everyone
Remember to double check that `pip` is properly installed now:
```bash
pip3 --version
```

## Installing modules
There are several modules you'll likely want in this class, so we'll aim to get them all set up here. You don't have to install them all right away though.

### Coverage
To install `coverage` (for tests), make sure you have activating your virtual environment and then type the following:

```bash
pip3 install coverage
```

If that doesn't work, you can try:

```bash
python3 -m pip install coverage
```

### Flask
Install Flask (for the Flask deliverable):

```bash
pip3 install Flask
```

### records

We'll also be using a module called `records`:

```bash
pip3 install records
```