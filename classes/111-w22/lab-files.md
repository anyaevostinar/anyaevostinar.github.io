---
layout: page
title: Files Lab 
permalink: /classes/111-w22/files
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.

## Exercise 1
In this exercise, you’ll be working with reading and writing files in Python. First, make a new Python file and call it citySelector.py. Next, download the file us_cities.txt, which is available on Moodle as one of the files associated with this lab. This “text file” (hence .txt) contains a massive list of US cities, with one city name on each line.
Your task is to make your program open the file, iterate over its contents, and retrieve all US cities that either a) start with B, M, or Q, or b) end with L or P. For instance, Birmingham and Chapel Hill would each be retrieved. Place all of the retrieved cities in a list called selectedCities. Now update your code so that it excludes any city that ends with S, regardless of whether it begins with one of three chosen letters. As one example, Bonita Springs will now be excluded.
Create a new file called selected_us_cities.txt and write to it such that, once your program finishes running, this file will contain all the city names that you retrieved from the original us_cities.txt file. Each selected city name should be placed on its own line.
(Hint: don’t forget to close your file once you finish writing to it!)
