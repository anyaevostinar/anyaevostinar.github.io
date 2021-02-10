---
layout: page
title: Cluster Lab
permalink: /classes/361-w21/cluster_lab
---

## Goals
To get set up to run experiments on one of Carleton's computing clusters when Repl.it isn't doing the job.

## Logistics
You won't actually be handing anything in for this assignment.

# Exercise 1
a. Go to [https://mantis.mathcs.carleton.edu:9595/](https://mantis.mathcs.carleton.edu:9595/) and log in with your Carleton credentials.

b. On the right side of the page there is a button "New". Click that and select "Terminal" which should open a new page with a black terminal box.

c. Use the following command to get the teaching repo:
```
git clone --recurse-submodules -j8 https://github.com/anyaevostinar/teaching-alife.git
```

d. Change directory into the repo:
```
cd teaching-alife/
```

e. Make and run like your have in the Repls:
```
make
./evo-algo
```

# Exercise 2
I've provided a script in Python to run several experiments sequentially. The script is in `stats_scripts` and is called `simple_repeat.py`. 

a. Go back to the other browser window and click on the `teaching-alife` folder at the bottom. Then open the `stats_scripts` folder and the `simple_repeat.py` file. 

b. This Python script is a bit fancy in that it is able to submit commands to the command line, but you should be able to make the changes to the for-loops and other settings that you want for your project. For now, don't make any changes.

c. Go back to your Terminal screen and type the following command to make a directory called Example:
```
mkdir Example
```
It's good to keep your experiments organized so the script will put all the data files into this folder along with your configuration file.

d. Run the simple repeat script as follows:
```
python stats_scripts/simple_repeat.py
```
It will print out a bunch of stuff as it runs each experiment, which shouldn't take long for these very simple "experiments". Note that it runs each "treatment" (ie starting prob of 0, 0.5 and 1) 10 times with different random seeds. This is so that you have a better idea of what your simulation is likely to do since any one run could do unusual behavior. 

e. You can go back to the file directory window and look at the data files that have been put into the `Example` directory. It would have been annoying to run each of those experiments by hand!

# Exericse 3
These experiments ran prety quickly, but eventually your code is likely to take a bit longer to run and if you close your browser window, it would interrupt the script. There is a 

Using screen and simple_repeat to run a job
1.   On the command prompt, type screen.
2.   Run the desired program.
3.   Use the key sequence Ctrl-a + Ctrl-d to detach from the screen session.
4.   Logout or go about your other work.
5.   Reattach to the screen session by typing screen -r.

# Exercise 3
Using top to check on usage, warning about not going over
ensure it stays below 20, and use at most 100g of memory