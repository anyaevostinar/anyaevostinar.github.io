---
layout: page
title: Files Lab 
permalink: /classes/111-f24/files
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES [as you usually do](getting-started).

## Goals
Get practice with reading from/writing to files.

## Exercise 1
Predict what the following code will do when run:
```python
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
In this exercise, you’ll be working with reading and writing files in Python. 
First, make a new Python file and call it `citySelector.py`. Next, download the file [`us_cities_small.txt`](/classes/111-w24/us_cities_small.txt) (by right-clicking on the link and selecting `Save Link As`).
This "text file" (hence `.txt`) contains a short list of the alphabetically first 10 US cities, with one city name on each line.
Your task is to make your program:
1. Open the file,
2. Iterate over its contents, 
3. Retrieve all cities from the file that end with either 'y' or 'a'. 
    * If you run into trouble, print out each of the last characters to see what they are. Remember that they might not be what you expect.
4. Place all of the retrieved cities in a list called `selectedCities`. This is a good point to run your code and print out part of the list to make sure that it is doing what you expect.
6. Create a new file called `selected_us_cities.txt` and write to it such that, once your program finishes running, this file will contain all the city names that you retrieved from the original `us_cities_small.txt` file. Each selected city name should be placed on its own line.

(Hint: don’t forget to close your file once you finish writing to it!)

## Exercise 3
Now that you've got a basic program working and tested, update it so that it takes the file as a command line argument. Here is the typical way of using command line arguments:

```python
import sys
if(len(sys.argv)>1):
	#do something with the argument
else:
	#tell the user what they should do and then end program
    print("Usage: python3 my_program argument1")
    sys.exit("Command line argument needed")
```

Download the file [us_cities.txt](/classes/111-w22/us_cities.txt), which has all of the US cities in a massive file. Test out your program with this larger file.

## Exercise 4
Let's expand the functionality of your program now that it can take other files. Update your code so that it will:

1. Retrieve all US cities that either 
    * start with B, M, or Q, or 
    * end with L or P. 
    * (For instance, Birmingham and Chapel Hill would each be retrieved. )
2. Exclude any city that ends with S, regardless of whether it begins with one of three chosen letters. As one example, Bonita Springs will now be excluded.

## Extra
If you have extra time, come up with more analysis that you can do on the `us_cities.txt` file.
For example: Which city has the longest name? How many cities start with each letter of the alphabet?

You can also try some of the [end of chapter exercises](https://moodle.carleton.edu/mod/lti/view.php?id=968122) and chapter assessment for more practice.