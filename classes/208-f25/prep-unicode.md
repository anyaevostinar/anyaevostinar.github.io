---
layout: page
title: Unicode Preparation
permalink: /classes/208-f25/unicode-prep
---

## Overview
As you know, bits can be interpreted to be pretty much anything! One thing that we obviously need them to represent are the characters that human languages rely on. However, there are several different standard ways of encoding characters into bits and we'll be thinking about two of them in depth: ASCII and UTF-8. Today, you'll read about the ideas behind these two so we can think more deeply about these encodings in class.

## Basic Learning Objectives
Before class you should be able to:
* Explain the high level of ASCII
* Explain the problem with ASCII and the idea of UTF-8 at a high level

## Advanced Learning Objectives
After class, you should be able to:
* Encode and decode ASCII characters
* Encode and decode Unicode codepoints using the UTF-8 encoding
* Implement UTF-8 in C

## Resources
Read the following:
* [An Introduction to Character Encodings](https://dev.to/ravimashru/an-introduction-to-character-encodings-4od4)
* [UTF-8 Intro](https://en.wikipedia.org/wiki/UTF-8)
* [UTF-8 Naming](https://en.wikipedia.org/wiki/UTF-8#Naming)
* [UTF-8 Encoding](https://en.wikipedia.org/wiki/UTF-8#Encoding)
* [Jeff's UTF-8 Encoder](https://sandbox.jeffondich.com/encoder/)
* [Homework 2](hw2)

## Checks
Submit answers to the following on Moodle (I recommend you do them by hand with [this table](https://en.wikipedia.org/wiki/UTF-8#Description) )as reference to practice for the [exam)](exams-overview):
1. Convert the codepoint `1F` to its UTF-8 binary encoding.
2. Decode the following UTF-8 binary encoding to its codepoint: `11000110 10111010`.
3. Have you been able to run the starter code for homework 2?