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
These experiments ran prety quickly, but eventually your code is likely to take a bit longer to run and if you close your browser window, it would interrupt the script. There is a program that allow your script to keep running even if your connection to the cluster gets interrupted. The program is called "screen".

a. First we need to make the code take a bit longer to run so you can actually see things happen. Open `teaching-alife/source/native.cpp` and increase the number of updates that are run to 10000 (you just need to add a 0).

b. Back on your command prompt, run:
```
screen python stats_scripts/simple_repeat.py
```

c. Use the key sequence Ctrl-a + Ctrl-d to detach from the screen session. At this point you could close the window or go do other things while this is running.

d. To reattach, on the command prompt type
```
screen -r
```

# Exercise 4
We share this cluster with another CS class (Parallel, in case you're interested), and so need to be good citizens and not take up too much space on the cluster. Whenever you start a job running (following the above steps or not), you should check to make sure that it isn't taking up too many resources.

a. If your screen job has finished, start it up again so that you can see it running.

b. While your job is running and you've detached from the screen, run:
```
top
```

c. This will pop up a whole lot of information. You should be able to see your username somewhere in the `user` column and both `top` and `evo-algo` since it shows all the commands that you are running.

d. There are a couple of things to check whenever you start a job. The first is the `load average`. Find that label. You should always make sure that it is below 20 and if it goes above 20, reattach to your screen and kill the job (Ctrl-c or Ctrl-d).

e. You should also check on the memory usage. For your job row, look at the `RES` column. That number should stay below 2,000,000. (If you want the details, that's in kilobytes and you should stay below 2 gigabytes, which is 2,000,000 kilobytes.) Again if your job is going above that, you should kill it and figure out why that is happening.

# Exercise 5
Follow the same steps to get your final project code onto Mantis and try running it. Feel free to grab whatever parts of `simple_repeat.py` are useful to you when you start wanting to run multiple replicates of different treatments. I encourage you to copy the whole script over and just change the couple of places that things differ.
