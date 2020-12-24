---
layout: post
title:  "Difficulties in controls in digital evolution"
date:   2020-12-24 10:00:00 -0600
categories: research
---

I just finished reading [The Surprising Creativity of Digital Evolution: A Collection of Anecdotes from the Evolutionary Computation and Artificial Life Research Communities](https://www.mitpressjournals.org/doi/full/10.1162/artl_a_00319) by Joel Lehman and colleagues since I plan to include it in my class CS 361 Evolutionary Computing and Artificial Life this coming term. While reading, I was reminded of an experience that I had while working on my paper [Suicidal selection: Programmed cell death can evolve in unicellular organisms due solely to kin selection](https://onlinelibrary.wiley.com/doi/full/10.1002/ece3.5460) which I of course forgot all about when the call for this collection went out, but I am going to record now!

My work for that paper focused on the evolution of altruism where a digital organism could greatly harm itself (often to the point of death) in exchange for either helping its kin (organisms with close to matching genomes) or harm its non-kin. 
I am interested in how such a trait could evolve and at one point was trying to gain data from a control treatment where I forced the organisms to retain the detrimental behavior in an environment where it was not beneficial so that I could then know exactly how beneficial it was in the other environment.
This work was done in Avida, which has a rich set of behaviors that organisms can evolve, including instructions that allow organisms to skip over sections of their genome.
You can probably see where this is now going....

I was very confused why I wasn't seeing any organisms being harmed by this behavior that I knew should definitely be harmful even though I was not allowing mutations that would remove the gene from their genomes.
In the end I carefully watched the gene-by-gene execution of the organisms and watched the skip happen so that they didn't actually perform the behavior even though I wasn't letting them get rid of it.
To get around this, I had to run offspring through a test environment to make sure that they actually performed the behavior before allowing them to be born.
I'm just glad I didn't run into the scenario another Avida researcher did where the organisms learned how to fake out the test environment too!

I highly recommend the creativity in digital evolution paper I linked above for more excellent anecdotes that show that even in a system where you are supposed to have complete control, evolution is shockingly good at thwarting you.