---
layout: page
title: Open-Ended Evolution Lab
permalink: /classes/361-f26/oee_lab
---

## Goals
To practice measuring how open-ended a system is with the MODES metrics.

## Setup
* Remember to start WSL if you are on Windows
* Pull down the new `OEE-Lab` starter code repository from the [361-F26](https://github.com/361-F26) GitHub Organization with `git clone --recurse-submodules [URL]` or `git submodule update --init --recursive` if you cloned without the recurse submodules command.
* (No need to setup Emscripten today)

## Exercise 1
Empirical has a built-in `OEETracker` for the MODES metrics and you'll be hooking it in to the simple evolving example from the Data Lab today. The `OEETracker` relies on the phylogeny produced by Empirical's `Systematics` module, so we'll first get that set up. 

1. In the `OrgWorld` constructor, you'll first need to make a `Systematics` object. The systematics class is templated off of your organism type and the type of whatever you want your phylogeny to be constructed from (i.e. the organism's genome, phenotype, etc). Our organism only has one "gene", i.e. its `cooperation_probability`, so declare your systematics object like so:
```cpp
emp::Ptr<emp::Systematics<Organism, double> > sys;
```

2. You next need to initialize the systematics object. To do so, you need to tell it how to turn an object of it's first type (`Organism`) into an object of its second type (`double`). You do so by passing it a function that does that mapping, which we can do with a lambda (but you could have done with a normal function as well):
```cpp
sys.New([](Organism & o){return o.GetCooperationProbability();});
```

3. Finally, you need to attach your new systematics manager to your world, with `AddSystematics(sys);`. This is a good time to compile and run to make sure you don't get any errors, though nothing will be printed either.

## Exercise 2
Now you're ready to set up your `OEETracker` to hook up to the systematics manager.

1. First you'll need to include `"emp/Evolve/OEE.hpp"` at the top of your world file.

2. Then you'll need to declare your `OEETracker`. You should do this outside of the constructor, since you'll want it to be an instance variable of `OrgWorld`. Just below `public:` is a good spot. Your `OEETracker` is templated off both the systematics type and the "skeleton" type, which is whatever type the simplified/meaningful version of the genome is. Since we have such simple genomes, we have no need to skeletonize, and so our skeletons will still be of type `double`:
```cpp
emp::Ptr<emp::OEETracker<emp::Systematics<Organism, double>, double>> oee;
```

3. In the `OrgWorld` constructor, we still need to initialize our `oee` object. We're going to need two lambdas to pass to its constructor, and it'll be easiest to save them to intermediate variables so we can understand them better. The first one will take in a pointer to a "taxon" that holds the type of our genomes. Taxons are the unit that phylogenies use and therefore what the systematics manager will hold and pass to our `OEETracker`. Since we're not doing anything fancy, we just need a simple lambda that pulls out the genotype that the given taxon was created to hold:
```cpp
auto get_genotype_lambda =  [](emp::Ptr<emp::Taxon<double>> taxon){return taxon->GetInfo();};
```

4. The second lambda is used to calculate a complexity score for a given skeleton. If our genomes were more complicated, this could mean that we count their length, number of nodes/layers, etc. It's important that this lambda takes in the type returned by the first lambda, i.e. the genome. Since there isn't really any kind of "increasing complexity" that makes sense for our system, we'll just have a lambda that always returns 1:
```cpp
auto no_complexity_lambda = [](double org_prob){ return 1;};
```

5. With those two lambdas ready, our initialization of the `oee` is straightforward:
```cpp
oee.New(sys, get_genotype_lambda, no_complexity_lambda);
```

6. The last thing you'll need to do is actually tell the world to update the OEE tracker every update. You can do that by hooking in to the `OnUpdate` signal with:
```cpp
OnUpdate([this](int cur_update){oee->Update(cur_update);});
```

7. Make sure to compile and run to check for errors. You still won't see anything printed out though.

## Exercise 3
We are doing a lot of tracking without actually printing out any of the data that we've so carefully recorded! It's time to add a data file for tracking the MODES metrics.

1. Add a data file to the instance variables for the world class with `emp::DataFile oee_file;` and call its constructor by adding it to the sequence of instance variables that are set up during construction:
```cpp
OrgWorld(emp::Random &_random) : emp::World<Organism>(_random), random(_random), oee_file("oee.csv") {
```

2. You can either make a separate method for setting up your new data file or just do it right in the constructor. We'll add several columns to the data file, though the OEE tracker makes the set up pretty straightforward:
```cpp
oee_file.AddVar(update, "generation", "Current Generation (i.e. update in this case)"); //first argument is instance variable, second is column header, third is the more full column description
oee_file.AddCurrent(*oee->GetDataNode("change"), "change", "change potential metric");
oee_file.AddCurrent(*oee->GetDataNode("novelty"), "novelty", "novelty potential metric");
oee_file.AddCurrent(*oee->GetDataNode("diversity"), "ecology", "ecology potential metric");
oee_file.AddCurrent(*oee->GetDataNode("complexity"), "complexity", "complexity potential metric");
oee_file.PrintHeaderKeys();
oee_file.SetTimingRepeat(1);
```

3. To make sure that your data file is actually updated on each update, add `oee_file.Update(cur_update);` to the `OnUpdate` signal lambda you made previously. 

4. Now you can finally compile and run and you should see a file output called `oee.csv` which should have some data in it!

## Exercise 4
You may have noticed that there seems to be a A LOT of change and "novelty" showing up in your data output. As you read, the amount of components counted as novel is strongly based on the rigor of your persistence filter and what you actually count as a separate component. We'll now explore those effects.

1. You didn't have to set up a length of generation to be used for the persistence filter at first, but let's think about what that should actually be. Take a look at the file `data.csv` to see how long it takes an organism to reproduce (you can also look in `Org.h` to see how many resources they need to reproduce and think through how long it should take them). Once you've decided how long a generation is, call `oee->SetGenerationInterval(YOUR_CHOICE);` to set that up and see what difference that makes to your data. 

2. Investigate what happens when you set the generation interval even longer, how does that affect the amount of novelty and change you see reported?

3. Another issue to our large amount of change and novelty is the question of what is actually meaningful difference. Because the genome is a double, tiny differences are currently being considered different genomes. To avoid that, we can make our systematics manager form taxa based on "bins" of doubles. Edit your intialization of the systematics manager so that instead of the lambda just returning `o.GetCooperationProbability()`, it uses `std::round(o.GetCooperationProbability() * 100.0) / 100.0;` to bin into 100 different bins.

4.  What do you expect to be the effect on the change and novelty metrics? Is there now an upper bound? Compile and run to see if your predicitons are correct.

5. As you have seen, you can impact the amount of change and novelty (and ecology) recorded by your system with changes to the parameters used. What does that mean about what meaning you can derive from these metrics? How do you think these parameters should be decided for a given system? 

## Submission
You aren't required to submit labs in this class, but you can for an extra engagement credit. Complete the implemention of the world file and then push it to GitHub:
```bash
git add World.h
git commit -m "finished oee tracking"
git push
```

## Extensions
* The system doesn't actually do that much, so therefore not a lot of interesting OEE metrics emerge. Try out setting up minimal interesting interactions between organisms to see what you get! 
* We sidestepped the question of complexity in the current system. Come up with the simplest way of having real complexity growth that you can think of in this system.