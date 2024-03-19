---
layout: page
title: Style Reference
permalink: /classes/201-w24/style-reference
---

## Overview
There are various bits of information that you need to do for style in particular and this is a page that collects them together for you.

## JavaDocs

Throughout the course you’ll be required to include informative comments above each method in “JavaDocs” style. This style allows for a website to be generated with those comments nicely formatted and looking like the Java documentation that you’ll become quite familiar with.

JavaDocs style is the following:
```java
/**
* Generally descriptive few sentences about the method.
* @param nameOfParameter description of the parameter if useful, probably should mention the type
* @param anotherParameter if you have multiple parameters
* @return description of what if anything is returned, should definitely mention the type
*/
public int exampleMethod(int nameOfParameter, int anotherParameter){
  return 0;
}
```

## README
Writing good and detailed documentation for your code is an important skill, so important that [whole communities](https://www.writethedocs.org/) exist in industry that are focused on good documentation. 
One part of good documentation is the JavaDocs method comments that you'll already be doing. 
However, another part is a ```README``` that is generally the first thing that people look at when they look into your project.
If you are planning on applying for internships or full-time jobs in the computer science industry, a [GitHub](https://github.com/) account with projects with good READMEs is a really helpful part of your application. 
READMEs are generally written in a language called [MarkDown](https://www.markdownguide.org/), which is fairly straightforward to get the hang of and you can keep yours very simple.

In general (and so therefore for all homework in this class), a README should include:

* An overview section that describes at a high level what your program does, for someone that just found it randomly
* A small example of your code running and showing its main functionality

For this class in particular, your README must also include answers to any README prompts, which will often ask you to include discussion of the pros and cons of a certain data structure or implementation choice. 

I have an [example README](/classes/201-w24/readme_example) that you can look at for a project that is a bit more involved. 

## Method size
You should aim for your methods to be short, as in they fit on the screen, certainly no more than 20 lines. You should achieve this by making lots of smaller methods for the logical groups of actions that you are doing, which we usually call 'helper' methods. You can make these methods `private` so you don't have to do JavaDocs for them :).

## Commenting
You should aim to have comments for blocks of code that are a logical unit. If you have many small methods, you might not actually need many comments. However, if you have a longer method, you should use comments to explain why each block of code is doing what it is doing.