---
layout: page
title: README Example
permalink: /classes/201-w24/readme_example
---

(Note, I'm displaying this README in its raw Markdown so that you can borrow the syntax, it will show more nicely formatted normally.)

```md

## Overview
The Dragon Item Program contains a catalog of all of Dr. Anya Vostinar's dragon-themed items.
It provides information about the various items and allows the entry of new items when Anya gets more dragons (which is a regular occurence).
With this program, you can:

* Find out how many dragon-themed items Anya has currently
* Get a list of all items in Anya's collection
* Get more information about specific items in Anya's collection

## Usage
To use the Dragon Item Program, run the following after downloading the code:
    ```
    $ javac *.java
    $ java DragonItem mode
    ```
where `mode` is which mode you would like the program to run in. 
The options are `pirate` and `dragon` and will determine whether the program writes to you in pirate voice or dragon voice.

The program will then ask you what you'd like to do:
    ```
    $ javac *.java
    $ java DragonItem dragon
    Welcome mortal, would you like to browse the collection or enter a new item? (browse/new)
    $ new
    Acceptable, what is the name of the new item?
    $ 2021 Notebook
    Wonderful, what is the description of the new item? Be sure to mention the dragon-related aspects, they are all that really matters after all....
    $ Lined notebook with purple dragon on the cover, sitting on a stack of books and sipping coffee
    ```

## Prompt Response
Printing with `System.out.println` was easy for me. Figuring out for loop syntax was difficult for me.

```