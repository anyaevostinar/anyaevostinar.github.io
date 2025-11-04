---
layout: page
title: Cache Aware Code Prep
permalink: /classes/208-f25/cache-aware-prep
---

## Overview
Now that we understand how caches work, how can you write code that takes advantage (or at least doesn't fight against) the typical cache design?

## Basic Learning Objectives
Before class, you should be able to:
* Define temporal and spatial locality
* Identify tools that can be used to analyze cache performance

## Advanced Learning Objectives
After class, you should be able to:
* Explain the performance implications of loop ordering

## Resources
Read the following:
* [DIS 2.5.2 Two-Dimensional Arrays](https://diveintosystems.org/book/C2-C_depth/arrays.html#_two_dimensional_arrays)
* [DIS 11.3 Locality](https://diveintosystems.org/book/C11-MemHierarchy/locality.html)
* [DIS 11.5 Cache Analysis](https://diveintosystems.org/book/C11-MemHierarchy/cachegrind.html)

## Checks
Submit answers to the following on Moodle:
* Describe a programming practice that would be inefficient with regards to temporal locality (i.e. how could you write code that would specifically break the assumptions of temporal locality?)
* Describe a programming practice that would be inefficient with regards to spatial locality