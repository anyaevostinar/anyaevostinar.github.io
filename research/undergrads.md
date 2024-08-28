---
layout: page
title: Research Info for Undergrads
permalink: /research/undergrad
---

If you are a Carleton student, there are two ways that you can do research with me: for pay or for academic credit. 
I sometimes have positions during the summer that are paid; I will announce those opportunities through the CS mailing list.
I am often open to supervising an independent study and/or research during the term, though it will need to be on a project that I am actively working so that it is a good use of my time.
If you are interested in working with me for academic credit, please email me and I'm happy to chat about the options. 
I also will give more detail on what that involves on this page.

## I want to be in your lab!
Awesome, I’m excited to hear of your interest! 
To best prepare for doing this kind of research with me, please read this page thoroughly, try out [Symbulation](https://anyaevostinar.github.io/SymbulationEmp/web/symbulation.html), and read [this review article](https://www.frontiersin.org/articles/10.3389/fevo.2021.739047/full). You can also read at least the introduction of [this paper](https://www.biorxiv.org/content/biorxiv/early/2018/08/20/393868.full.pdf). These will give you a solid grasp of what my research involves and what projects I’m looking to get students involved with. If you’re even more excited after reading these materials, check my calendar (linked on homepage) and email me a time you’d like to meet and talk further.

<!-- 
## Choose Your Own Adventure: Education questions
If you're interested in how computer programs can be used to teach biological concepts, this is the section for you.
This is a newer direction for the lab, but you can get a basic idea of the premise by reading this page thoroughly, and [this paper](https://arxiv.org/pdf/2007.03787.pdf).
The main idea is putting evolution into games and interactive websites to improve students' intuition about the tricky parts.
So far we've done this in the games [Stardew Valley](https://github.com/anyaevostinar/RealisticFishing) and [Minecraft](https://github.com/eliarbogast/evolution) and by setting challenges on the [Symbulation](https://anyaevostinar.github.io/SymbulationEmp/web/symbulation.html) GUI.
If you’re even more excited after reading these materials, check my calendar (linked on homepage) and email me a time you’d like to meet and talk further.
-->

## Symbu what?…..
The SymbuLab is a combination of [Symbulation](https://anyaevostinar.github.io/SymbulationEmp/web/symbulation.html), our main software, and Lab, the thing this is.

## Symbula what?….
[Symbulation](https://anyaevostinar.github.io/SymbulationEmp/web/symbulation.html) is an open-source, agent-based, digital evolution software library that specifically supports the evolution of symbiosis. Looking up each of those phrases will be a good starting place for learning more about what we do, but it usually involves some combination of the following:

* Work with biologists to understand their systems at an abstract level
* Code up software that implements the necessary pieces of our hypothesis
* Run repeated experiments over a larger range of parameters and longer time than is easily done in any biological system
* Use those results to better understand the dynamics that may be going on in biological systems

Symbulation is specifically aimed at creating a digital system that captures the relationship between symbionts (parasites/commensalists/mutualists) and their hosts. 
Symbiont is the term for all of these, mutualist is the term for mutually-beneficial relationships despite what the media likes to say. 
Parasites and mutualists are actually on a spectrum and how you define their relationship can vary greatly with the environment. 
For example, there is a bacteria that helps plants by getting nitrogen from the soil and exchanging it for sugar from the plant. 
When nitrogen-rich fertilizer is added to the soil, the plants no longer need these bacteria, but the bacteria are pretty invested in the relationship continuing and generally become parasitic. 
There are lots and lots of ideas of how mutualism and parasitism could have evolved, but a lot of complications that have made it difficult to test those ideas in biological systems.
Symbulation is the answer to this problem. 

## Evolution? Isn’t this a computer science lab?
Why yes it is, though we are definitely firmly interdisciplinary and publish in both fields. 
Evolution is simply a (very powerful) heuristic algorithm. Given:

* Inheritable traits (like DNA or computer code) 
* Variation in a population (of ants or computer objects, through mutations)
* Competition for survival (through limited resources or space, etc.)
* Sufficient time for generations of the organism

you’ll get evolution. It is logically impossible not to get evolution if all four of those elements are in a system.

You may have heard of Genetic Algorithms (if not, feel free to Google) and wonder if this is similar. 
The answer is yes, digital evolution is very similar to genetic algorithms/evolutionary computation and can be a subfield though not necessarily. 
GA/EC are usually used to try to solve an engineering or mathematical problem, where the organisms represent possible solutions and their ‘reproduction’ is determined by how well they solve the problem. 
Digital evolution is the other side of the coin: using evolution in a computer to better understand the biological systems that first inspired this field.

## Okay but what would I actually DO?
In my lab, you’ll be doing some mixture of software development of a large open-source project, reading and consulting biologists to catch up on the biology, running and analyzing big data experiments, and writing up your results.
Symbulation is written in a customized version of C++ ([Empirical](https://github.com/devosoft/Empirical)) that heavily uses template meta-programming (google it if you want your mind blown) to make using the tools very simple. 
If you aren’t making deep changes to Empirical, the software is designed so that biologists with an interest can customize a large range of things to run their own experience without much C++ knowledge.
To work on Symbulation, some knowledge of C++ would be good, but not necessary, depending on what project you want to work on. 
I use R for my data analysis and am happy to get you up to speed with the pieces I use.
Finally, I use Python for most of my scripting for prototypes. Having some knowledge of biology and evolution would be great, but I can get you up to speed with those aspects; you just need to bring the excitement.

## What are these projects you mentioned?
Empirical software and therefore Symbulation were designed to be excruciatingly modular.
You will never be touching the main Empirical codebase; instead you will design your own module that plugs into the existing code but does not interfere with others use of it. 
This can be annoying at times, but it is vital to avoid bloat in this large software project. 
It also means, however, that each student that works with me can work on their own project of whatever size is appropriate and basically in any order.
If you want to work on the education side of things, you could expand on one of the existing projects, or try modifying your own favorite game if it supports mods.
Any of these projects would definitely lead to findings that could be submitted to the ALife conference (a peer-reviewed conference) and/or many different journals.
Each project would also contribute to the over all relevance of Symbulation and our evolution education games because the features could be combined and used by future scientists to study ever more complicated systems (and therefore more and more similar to DNA-based systems).

Here are some potential projects. You probably won’t recognize some of these words, so reading up a bit on the biological concept would be important to know if it is interesting to you.

* Superhost immune system – to make matters more complicated, many symbiont/host pairs actually live inside another organism (such as viruses that infect bacteria that live in your gut). This extra ‘trophic level’ is likely to hugely influence evolution of symbionts.
* Serotype conversion – when viruses infect bacteria (the viruses are called bacteriophage or phage for short), sometimes they incorporate into the bacteria’s genome and sometimes when they do that they change what markers the bacteria has on the outside of its cell. These markers are what other phage and immune cells use to identify and infect the bacteria, so the virus is in a way helping hide the bacterial host. This is called seroconversion and we have a biology lab at Florida State University interested in doing parallel wet-lab experiments with us on this subject.
* Multiple symbiont species – up to this point, we’ve been talking about one symbiont species that infects one host species. However, many different bacteria and viruses can infect you and every other organism on the planet. How these species interact when trying to share a host is a huge and complicated box that would be excellent to explore.
* Quorum Sensing – bacteria lead much more complicated lives than we historically thought and quorum sensing is one of the main communication methods they use. As soon as we’re talking about multi-infection and multiple symbiont species, we can introduce quorum sensing mechanics to allow the organisms to communicate in basic ways.
* Internal vs. External – Quorum sensing involves the release of a small molecule and that molecule can stay inside of the host and therefore mostly be between symbionts and possibly the host, or it can escape the cell and allow the hosts to communicate as well.
* Parasitic manipulation – there is a class of parasites that not only steal resources from the host but also change the host’s behavior to better suit their needs. 
* Add physics for educational purposes – by default the organisms in Symbulation don’t move. There is a physics engine already coded into Empirical that allows circular organisms to bounce around in their environment and displays this world in real-time in a browser ([Evoke](https://devosoft.github.io/Evoke/evoke) as example). By implementing symbionts into the physics world, we could develop a useful educational and outreach tool as well as eventually allowing organisms to purposefully move (not this project though!).

If any of these or other questions along the same lines interest you, please email or stop by when I’m in the office and we can chat!

## In Progress/Completed/Retired Projects
* Lysis/Lysogeny - Symbulation now supports these two different modes of reproduction common to bacteriophage (viruses that infect bacteria)
* Ectosymbiosis - An ectosymbiont lives on a host instead of inside and therefore can have different things it has to deal with. Symbulation now supports ectosymbiosis.
* Multi-infection – currently Symbulation only allows one symbiont to infect a host, which is unusual in the natural world.
* Multi-birth – viruses birth thousands of offspring in one burst, which is a lot more than the one we started with.
* Stardew Valley evolution mod – this is an educational project. Many of you probably are aware of the push-back against evolution education in the United States and this project will work toward showing people that evolution isn’t scary or complicated. Stardew Valley is a farming simulation game that allows for heavy modification. I would like to create a mod that uses the existing animal and plant characteristics as a basis for evolution. The goal would be making the game both more fun and getting players to think about the evolutionary consequences of their actions. For example, if they always catch the largest fish, the fish population will evolve to be smaller over time. This project would be in C# as that is what Stardew Valley mods use and would be integrated with existing pixel art.