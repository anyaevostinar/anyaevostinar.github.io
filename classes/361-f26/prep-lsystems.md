---
layout: page
title: L-Systems Preparation
permalink: /classes/361-f26/lsystems-prep
---

## Overview
We're now going to be focusing on a specific dynamic of life: growth. How do multi-cellular organisms grow in such complex and organized ways without top-down control? We'll start by considering a set of systems that isolate and capture the dynamic of growth: L-systems.

## AI Policy
As a reminder, you are not allowed to use genAI to summarize or produce your reading check responses. These checks are for you to engage with the material and start thinking about things before class. It's okay if you don't understand everything ahead of time!

## Basic Learning Objectives
Before class, you should be able to:

* Explain how L-systems relate to organism growth
* Demonstrate the expansion process of an L-system string

## Advanced Learning Objectives
After class, you should be able to:

* Implement an L-system to capture organism growth dynamics

## Reading
Read the following:

* [Biological Bits](/classes/361-s25/BiologicalBits_PDF_edn1.pdf) Section 4.2 Lindenmayer systems

## Checks
Submit answers to the following on Moodle:
* Consider the following L-system grammar and write out the full string for iterations 0, 1, and 2:
    * Axiom 'A'
    * Rules:
        * `A -> F[+A][-A]`
        * `F -> FF`
* There is a brown seaweed species called Bladderwrack that grows by an active tip splitting equally into two identical growing tips, forming a symmetrical Y structure. The older stem segments don't stretch further after forming, i.e. growth only occurs at those active tip sections. Here is a picture: 

    <img src="https://upload.wikimedia.org/wikipedia/commons/c/c9/Fucus_vesiculosus_closeup.jpg" alt="Bladderwrack picture" height=100> 

    By User <a href="https://en.wikipedia.org/wiki/User:Stemonitis" class="extiw" title="en:User:Stemonitis">Stemonitis</a> on <a class="external text" data-mw-original-href="http://en.wikipedia.org" href="https://en.wikipedia.org">en.wikipedia</a> - Taken by <a href="https://en.wikipedia.org/wiki/User:Stemonitis" class="extiw" title="en:User:Stemonitis">Stemonitis</a>, <a href="https://creativecommons.org/licenses/by-sa/2.5" title="Creative Commons Attribution-Share Alike 2.5">CC BY-SA 2.5</a>, <a href="https://commons.wikimedia.org/w/index.php?curid=1366410">Link</a>
    
    **Write the starting axiom and rules** that would capture this growth pattern in an L system. Hint, you'll want two rules, though one is fairly simple.