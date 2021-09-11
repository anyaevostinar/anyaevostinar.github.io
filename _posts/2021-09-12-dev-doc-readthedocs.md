---
layout: post
title:  "Dev & Doc: ReadTheDocs"
date:   2021-09-12 07:00:00 -0600
categories: [Research, Symbulation]
---

It's been a busy summer full of lots of new functionality in [Symbulation](https://anyaevostinar.github.io/SymbulationEmp/web/symbulation.html)!
I'll be doing a blog post for each of these new features (and they're already available in the code), but to give you a sneak peek:
* Lysis and Lysogeny support in Bacterium and Phage classes
* Free-living symbiont population
* PGGHost and PGGSymbiont classes that enable symbionts sharing a host to engage in a public goods game
* A new symbiont class with an 'efficiency' trait
* The possibility of setting the mutation rates and sizes separately for horizontal and vertical transmission

## New Documentation
Today's post, though is to highlight the new documentation put together by [Piper Welch](https://www.linkedin.com/in/piper-welch-8357591aa/)!
[Symbulation's documentation](https://symbulation.readthedocs.io/) is now through ReadTheDocs and contains some exciting new additions.

### Projects Using Symbulation
There is now a page listing the [active and past projects](https://symbulation.readthedocs.io/en/latest/projects/index.html) that use Symbuluation. 
As you can see from it, we have several ongoing projects that we are excited about and we hope that more will continue to get added.

### Quick Start Guides
There are a lot of quick start guides in the works, but currently there are now guides for getting Symbulation's default setup [running at the command line](https://symbulation.readthedocs.io/en/latest/QuickStartGuides/1-GettingRunning.html) and [collecting data](https://symbulation.readthedocs.io/en/latest/QuickStartGuides/2-CollectingData.html) with a little Python script.

We're planning on making many more guides that will be appropriate for an undergraduate who has taken a couple of CS classes, so let me know if there are particular things that you'd like to be prioritized.

Future guides that I'm currently thinking about are 

* Building and running the web version locally
* Using a provided R script to get the data files into lovely plots
* Recreating the results from the major previous papers

### Library API
We have most of the public methods for all the classes documented nicely and showing up in the [auto-generated documentation](https://symbulation.readthedocs.io/en/latest/api/library_root.html).
Piper worked hard on getting them formatted so that they show up in a readable format. 
Our goal is for all of this documentation to be easily understandable when you are trying to use existing functions or make your own, so let us know if that isn't the case.

### Contributing to Symbulation
Finally, we have a set of guides on how to [contribute to Symbulation](https://symbulation.readthedocs.io/en/latest/dev/getting-started.html) that includes discussion of first-time setup, coding guides, documentation, and testing. 

## Philosophy
I wanted to take a final minute to discuss my philosophy behind this documentation and Symbulation in general.
There are several refactors of the internals of Symbulation coming up, first to organize the many classes that have been developed this summer, and then to port it to [MABE2](https://mabe2.readthedocs.io/en/latest/) when that is reasonable.
However, as with most refactoring, the goal is that external features will remain mostly the same (I can't promise that that will be true with the MABE2 port, we'll see).
Since I work with primarily undergraduates, a lot of this documentation is what I have to teach each year's incoming students anyway, so it just makes sense to have it written down. 
While the current documentation hasn't been stress-tested by new undergraduates yet, it will be in the coming year, and I'm looking forward to the improvements they will suggest.

With that all in mind, if you try to use the documentation and run into problems, please contact me either through email or GitHub, I really would love to improve any misunderstandings!

Until next time,

Anya
