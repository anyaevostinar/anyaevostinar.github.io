---
layout: page
title: Files Lab 
permalink: /classes/111-w22/files
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.

## Goals
Get practice with booleans and reading from/writing to files.

## Exercise 1
Predict what the following code will do when run:
```
filename = input("What is the file? ")

cur_file = open(filename, 'r')
out_file = open("output.txt", 'w')

count = 0
for line in cur_file:
    for word in line.split():
        count += 1
cur_file.close()

print("Count of words was: {}".format(count), file=out_file)
out_file.close()
```

Once you've made a prediction, create the necessary files and test your prediction.

## Exercise 2
Say that we define the following variables defined at the beginning of our program:
```
a = 3
b = 10
c = 15
```

What would we expect each of the following statements to print out? Discuss each one with your partner. If you think one might generate an error, discuss why that’s the case. Check your answers by typing in and running the lines as you proceed! Whenever one of them confuses you, throw up your hand to receive some clarification.
```
  print((a > b) or (c > b))
  print((c == a) or True)
  print((a == b - 7) and False)
  print(not ((a > b) or (c > b)))
  print(a in [1, 2, 3, 4])
  print(a == b and 1/0 == 1)
  print(1 or 0)
  if True or '': print('it prints!')
```

## Exercise 3
In this exercise, you’ll be working with reading and writing files in Python. 
First, make a new Python file and call it `citySelector.py`. Next, download the file [`us_cities.txt`](us_cities.txt) (by right-clicking on the link and selecting `Save Link As`).
This “text file” (hence .txt) contains a massive list of US cities, with one city name on each line.
Your task is to make your program:
1. Open the file,
2. Iterate over its contents, 
3. Retrieve all US cities that either 
    * start with B, M, or Q, or 
    * end with L or P. (For instance, Birmingham and Chapel Hill would each be retrieved. )
4. Place all of the retrieved cities in a list called `selectedCities`. This is a good point to run your code and print out part of the list to make sure that it is doing what you expect.

5. Next, update your code so that it excludes any city that ends with S, regardless of whether it begins with one of three chosen letters. As one example, Bonita Springs will now be excluded.
6. Create a new file called `selected_us_cities.txt` and write to it such that, once your program finishes running, this file will contain all the city names that you retrieved from the original `us_cities.txt` file. Each selected city name should be placed on its own line.

(Hint: don’t forget to close your file once you finish writing to it!)

## Extra
If you have extra time, come up with more analysis that you can do on the `us_cities.txt` file.
For example: Which city has the longest name? How many cities start with each letter of the alphabet?
