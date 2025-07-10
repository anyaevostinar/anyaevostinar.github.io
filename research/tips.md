---
layout: page
title: Tips
permalink: /research/tips
---

(Various commands and things that Anya and research students need to know.)

Research machine addresses:
* `margulis2024.crug.carleton.edu`
* `edmonstone.crug.carleton.edu`
* `lederberg.crug.carleton.edu`
* `carver.crug.carleton.edu`

Access them with your Carleton login.

Head crug node: `shiver.crug.carleton.edu`

You can ssh on to shiver and then push jobs to our two servers like so:
* `srun -p facultynode --nodelist=margulis2024 python3 /Accounts/yourUserName/simple_repeat.py`


(Curious about the names? Read about [John Edmonstone](https://en.wikipedia.org/wiki/John_Edmonstone) and [Lynn Margulis](https://en.wikipedia.org/wiki/Lynn_Margulis))


## Software 
I recommend you use [VSCode](https://code.visualstudio.com/) for working with the code base locally, though it's not required.
We'll use `git` to share code and move it between your local machine and the research servers, so if you aren't familiar with `git` and GitHub or would like a refresher, look through [this guide](https://guides.github.com/introduction/git-handbook/).
I also recommend RStudio for when you eventually want to make plots/graphs, so you can [download that](https://www.rstudio.com/products/rstudio/download/) right away (the free version!).

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

To clone a git repository recursively (i.e. to get all its submodules as well):

`git clone --recurse-submodules https://github.com/anyaevostinar/SymbulationEmp.git`

To get the submodules after you've cloned a repository normally (and then realize you forgot to get the submodules):

`git submodule update --init --recursive`