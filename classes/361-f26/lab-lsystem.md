---
layout: page
title: L-Systems Lab
permalink: /classes/361-f26/lsys-lab
---

## Goals
To practice with the main dynamics of l-systems.

## Setup

* Remember to start WSL if you are on Windows
* Pull down the new `LSystem-Lab` starter code repository from the [361-F26](https://github.com/361-F26) GitHub Organization with `git clone --recurse-submodules [URL]` or `git submodule update --init --recursive` if you cloned without the recurse submodules command.
* Set up Emscripten as normal:
    ```
    cd emsdk
    ./emsdk install 3.1.49
    ./emsdk activate 3.1.49
    source ./emsdk_env.sh
    cd ..
    ```

### Running the starter
With that all in place, the starter code is functional. Check it out with:

```
./compile-run.sh
```


## Taxonomy
L-system rules can feel abstract, so let's ground them in the typical *phenotypes* (i.e. the observed traits/patterns) of plants. In `SetupGrammar` do the following for each set of axioms and rules:
1. Type up just the single axiom and rule, keeping the execution (`max_depth`) to only one time step
2. Compile and run and observe what the starting state is and what the rule changes after one iteration. Write down both in the table on your worksheet
3. Update the number of time steps to 4 to see how the rule plays out over more steps
4. Write down a description of what that rule does at a high level

Here are the rules and axioms to observe:
* Axiom: `F`, Rule: `F -> FF`
* Axiom: `F`, Rule: `F -> F[+F][-F]`
* Axiom: `A`, Rule: `A -> F[+A][-A]`
* Axiom: `A`, Rule: `A-> F[++A][-A]FA`

## Changing Colors
L-system rules can cause growth, but they can also cause changes in state. Pick whichever starting rules you want from the previous taxonomy and then add a new state `W` that is a mature woody stem. This should happen when several lengths of `F` are together and probably makes sense to be brown and a bit thicker than the green stems. Here are some hints to achieve this:
* Add a new rule to get `W` from some `F`'s
* Add another `else if` to `DrawLSystem` for `W` that is based on the logic for `F` but uses "green" and something larger for the line_width

## Config Panel
It's time to use the config panel! 

1. Uncomment the line `settings << config_panel;` in the constructor and recompile to see the config panel.
2. The panel doesn't do anything yet. To access values, you just use the name of the configuration setting defined at the top of the file. So to access the value for `ITERATIONS`, you would do `config.ITERATIONS()`. Edit `SetupGrammar` to use the config panel iterations value for `max_depth`. Remember to compile and run to try it out!
3. Add one or two more `VALUE`s to the config at the top (remember to include a `,` between each `VALUE`) and connect them to your code to explore effects of other parameters.


## Submission
You aren't required to submit labs in this class, but you can for an extra engagement credit. Complete the implementions above and then push it to GitHub:
```bash
git add LSysAnimate.cpp
git commit -m "finished config"
git push
```

## Extra
There are a lot of extensions to L-systems to explore (and some of them you'll explore in the homework as well). Try out some of these:
* Add probabilistic changes
* Add rules based on neighboring states as well as the state that changes
* Add decay rules
* Add more states and [draw more things](https://empirical.readthedocs.io/en/latest/library/web/api/Canvas.html)