---
layout: page
title: DISHTINY Lab
permalink: /classes/361-f26/dishtiny_lab
---

## Goals
To explore the dynamics observed in DISHTINY and think about the evolution of multicellularity.

## Setup

You won't be downloading anything today! Instead, you'll be running the externally-hosted DISHTINY in your browser.
So that you have a couple of samples, you should be in a group of three and each of you should navigate to [https://mmore500.com/dishtiny/master/?N_CELLS=900&RNG_PRESEED=9&&click=clear-views+kin-group-id-selector+resource-stockpile-selector+spawn-arrest-selector](https://mmore500.com/dishtiny/master/?N_CELLS=900&RNG_PRESEED=9&&click=clear-views+kin-group-id-selector+resource-stockpile-selector+spawn-arrest-selector). 
**You should then each change the value for `RNG_PRESEED` in the URL to something unique** so that you each are using a different random seed and can therefore look at what differs across your different replicates. 
If you'd like to get even more replicates going, feel free to log into a lab machine or two and have them start running other seeds!

**Click Start so that it starts running while you read the rest of the instructions since it's takes a little while for interesting things to happen.**


You should have only three views open (Spawn Request, Kin Group ID, and Resource Stockpile), that correspond to the three keys on the worksheet. Read over the worksheet keys to understand what each view is showing you. You can also zoom out your window to be able to see all the views at once more easily, since the font is pretty big by default.

## Spawn Arrest Analysis
One of the metrics for a fraternal transition that we discussed is reproductive division of labor where some cells stop reproducing and just help other cells reproduce. 

1. Take screenshots of just your groups three (or more) `Spawn Arrest` views and `Kin Group ID` views (ideally in the same screenshot) and put them into your group's tab of the shared Google doc with labels for the different seeds and how many updates they were at.  (You can also unselect "Every" and click "Save" to download PNGs from the website directly.)

2. Discuss: if you were only considering the spawn arrest data combined with the kin group data, what does it indicate about what is happening in each of these replicates? 

3. Write down a summary of what your group concludes from that data

## Resource Sharing Analysis
We also discussed cooperation and sharing of resources as an element of a fraternal transition.

1. Take screenshots now of the `Resource Stockpile` and `Kin Group ID` views of all of your replicates and add those to a new section of your Google Doc.

2. Discuss: What does the resource stockpiling data indicate? Can you see example cell groups in both the stockpile view and the group ID view? 

3. When you consider the resource stockpiling in conjunction with the spawn arrest, is there conflict between the stories the data tell or are they consistent?

4. Be sure to write down your groups conclusions from this data as well.

5. Briefly brainstorm on what additional data from this system would be helpful to have an idea of whether a fraternal transition has actually occurred. 

## Explore
There are obviously a lot more views, so check some more out and discuss in your group any others that shed light on what is going on in the world. Here are some to consider:
* Most Recent Cause of Death
* Incoming Inter Message Counter
* Received Resource
* Eligible Spawn Request

You can also change many additional configuration settings. Check out the Configuration information section at the bottom of the page and add one or more of the following to your URL to see the effect (add additional configs immediately after the `?` in the URL):
* `STATE_INPUT_JUMP_SERVICE_FREQUENCY=0&INTER_MESSAGE_LAUNCHING_SERVICE_FREQUENCY=0&` - this will turn off anyway for cells to recognize group versus non-group, does it break any multicellular dynamics?
* `BASE_HARVEST_RATE=0.2&COLLECTIVE_HARVEST_RATE=[+0+0+]&` - this will turn off the resource advantage of multicell groups, what do you think will happen?
* `RESOURCE_DECAY_SERVICE_FREQUENCY=0&` - this will turn off the penalty against groups getting too large


Take some screenshots of a couple of additional views with the other original views and add those and a description to your Google Doc. Be ready to share out about the data your group collected and what your group concluded from it.