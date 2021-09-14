---
layout: page
title: HW 2 Country Stats Displayer
permalink: /classes/201-f21/hw2
---

## Logistics
30 points, due Friday Oct. 1st by 10PM Central time. Like all assignments, there is a 48-hour, no questions asked extensions policy. If you have a tech issue, a health issue, or some other issue that impedes making the deadline, use this policy.  You or your partner need to notify me that you're using the policy via email, CC'ing the partner. Extensions beyond the 48-hour policy will only be considered in extenuating circumstances, and circumstances that arise between the original deadline and the extension are generally not extenuating - the deadline is still Friday, not 48 hours later.

## Goals
To build a non-trivial program with Java that works with Java's ArrayLists and/or HashMaps and to start making design decisions about how users can interact with your program.

## Assignment Type and Collaborative Learning Expectations
This is a homework assignment that you'll be handing in on Moodle.

You must work on this homework with your assigned partner (if you have one) via pair programming. That means that you cannot write **any** code without your partner and you must both be fully engaged and discussing the code at all times while working. See the [collaboration policy](collaboration) for details.

## Setup and Requirements
Create a folder for HW2 on the COURSES drive. Remember to save here so that you don't lose your work!

Create a file Collaborations.txt and put in any help that you get on this assignment including sources that you reference and help from lab assistants or the prefect. Make sure to refer to the [Collaboration page](collaboration) on what collaborations are allowed for homework assignments.

The code that you write for this assignment will build on top of Java's ArrayList and/or HashMap data structures. The code will also use a dataset containing information about countries, created using data from the World Bank:

[CountryDataset.csv](/classes/201-f20/CountryDataset.csv)

The [official Java API documentation for ArrayList](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html) will likely be helpful for knowing what methods are supported by the `ArrayList`.
You may also want to use the documentation for [HashMap](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashMap.html).

## Specification
For this assignment, you will write a program that reads from a text file with one line for each country.
You will create two classes, `CountryDisplayer` and `Country`.
Your program will need to represent each country as an instance of `Country` and each data file as an instance of `CountryDisplayer` (you will only use one data file, but you can imagine having multiple data files).
When creating an instance of `CountryDisplayer` your program should convert the data file into an `ArrayList<Country>` and then display the data requested by the user.

This will give you practice working with the `ArrayList`, `String`, `File`, `Scanner`, loops, and classes.
It's also a chance to see how your programming skills might be used to interact with large datasets.

### The input file
The input file is a text file that contains 0 or more lines of countries, with an initial line that gives the meaning of each item in the line. After that first line, each line of the input file will represent a single country via a comma-delimited list. Here's an example of the representation of Afghanistan, the alphabetically first country:
```
Afghanistan,33.26,0.33,72.7,15.73,0.1,2.99,3.89
```       
Each of the numbers represents some information about the country. Specifically, the meaning of each of the items is as follows:
```
Country Name
Population total (in millions)
CO2 emissions (metric tons per capita)
Access to electricity (% of population)
Renewable energy consumption (% of total final energy consumption)
Terrestrial protected areas (% of total land area)
Population growth (annual %)
Urban population growth (annual %)
```

Click on the CSV file in Visual Studio Code to see all of the data.

The information in the data file [CountryDataset.csv](CountryDataset.csv) is based off of the [World Bank Indicators dataset](http://datatopics.worldbank.org/world-development-indicators/). The original dataset contains information about each country for each indicator (item) and year from 1960-2019 (although some years are missing for some countries). For each country, the dataset I've given you contains a single number for each indicator. That number is the average value of the indicator from 2012-2019, skipping any years where there wasn't data for that country.

For your testing, you can use the data file I've provided, but you can also test on smaller subsets of the data to make sure that your output is correct and that your program doesn't crash if there are no countries.

### User Interaction
Your program should allow the user to specify the data file that they want information from.
This can be via command line or interactive input.

Your program should then allow the user to get information from the data file in two ways
1. By the country's name, allowing the user to look up specific information about a specific country and handling the case that the user types a name that you do not have
2. By the indicator, allowing the user to look up the country with either the maximum or minimum (you only have to support one or the other) indicator value and displaying that information.

For example, I should be able to look up the population total of Libya as well as the country with the maximum (or minimum) population growth.
These can be separate modes of the program (i.e. it's okay if I have to rerun the program to be able to get these two pieces of information).

You also need to handle a user typing commands or words incorrectly by providing a friendly and informative message (called a usage statement) if they:
* Type too many or too few command line arguments
* Type an indicator that is not from the list
* Type a country that isn't in the list

### Code structure
Your code must be objected-oriented. What this means is that you must create instances of `Country` and `CountryDisplayer`. You should not create any additional static methods. You can and should create additional non-static methods however and aim to keep your methods short and focused.

## Advice
This is your first large assignment in this class and you might feel pretty overwhelmed. 
Remember that it's good to separate the way that your program will work from the Java that is necessary to get it to actually happen.
Feel free to first write pseudo-code for how you think a method should work and then get your reference sheet out to translate your pseudo-code to Java.

Here is how I advise you go about this project.

### Make your classes
First make your `Country` file. Think about what variables it will need.

Then make your `CountryDisplayer` file and class with its `ArrayList<Country>`.
Next write 'stubs' of the major methods that you will need for `CountryDisplayer` to work:
```
public class CountryDisplayer {
    //instance variables up here!
    ArrayList<Country> countries;
     
    public CountryDisplayer(String fileName) {
        // Read the country file and load the countries into this instance of CountryDisplayer.
    }
 
    public Country getCountryByName(String name) {
        // ...
    }
 
    public Country getCountryMaxIndicator(String indicator) {
        // ...
    }
     
     
    public static void main(String[] args) {
        // If there's no command-line argument, print a usage statement 
        // and exit. Otherwise, use args[0] as the input file path.
        if (args.length == 0) {
           // ...
        }
         
        //Construct a CountryDisplayer and call the methods you defined 
        //above to load, process, and display the countries
    }
}
```
A stub just means that the method is defined but doesn't actually do anything.

### Read in your countries
Complete the `CountryDisplayer` constructor by looking at the code from your reference sheet or the `LineReader.java`.
You will probably also want to make a better constructor for `Country` at this point.
It might be helpful to make a shorter version of the data file with just a few lines as you work on this part.
Make sure to test this code by creating a `CountryDisplayer` in the main of `CountryDisplayer.java`.

To split a line that is delimited by commas, you will probably find the `.split()` method of `String` helpful.
Look at [`String`'s documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html) for more information.

### Display a Country
Fill in your method `getCountryByName` so that you can make sure that everything is reading in correctly. 
Use that to print out a country when the program runs. 
Don't over think this.
You can simply loop over your list of countries and check the name of each until you find the correct country.

### Getting indicators
To display information about specific indicators, you'll need to grab those indicators from the countries by the string name. In `Country` make a method that takes a string and returns the indicator value for that country. 
This could be a long line of if-else statements or you could use a `HashMap`. Note that `==` compares whether two Strings are literally the same Object, not their values. You will want to use the method `.equals(String in)` to compare their values.

It's a good idea to test these small changes immediately in the `main()` method of your `Country.java` class. Create an instance of `Country` with dummy data and make sure you are able to get the data back out by the indicator name.

### Max or Min Indicator
You're now ready to grab out the country with the maximum or minimum value of indicator. 
Since you already have a method to get a specific indicator value for a country, you should be able to loop over your countries and keep track of the country with that largest (or smallest) value of the specified indicator.

### User Input
Now you want to allow the user to specify everything that they want from your program. Make sure to allow the user to specify the location of the data file and both ways of getting data, as specified above.
You have a lot of flexibility in how you get that information from the user, so try to think about what would be easiest for a user.

### README
As always, you should include a detailed README for this homework. 
It should include a brief overview of your project, a short example of how to run your program and see its interesting behavior, and a more detailed section that has **demonstration input for each of the rubric items**. Remember, you want to make it as easy as possible for the grader to see that your homework does everything its supposed to!

#### Prompts
In addition, you should specifically have sections discussing the following design choices (these should each be 1-2 paragraphs):
* Why did you choose the user interaction process that you did? Do you have everything on the command line or interactive input or a mix? 
* Why does it make sense to make this program object-oriented? You didn't have a choice, but you should reflect on the benefits of an object-oriented approach to this task instead of simply looking through the data file or lists, for example.

## Rubric
This is how you will be graded on this assignment:

| Item | Points |
|------|--------|
| README thorough and detailed | 6 |
| User can specify data file | 4 |
| User can look up a specific indicator about a specific country | 4 |
| User can look up country with max or min of a specific indicator | 4 |
| Handles user typing incorrect country name or indicator | 4 |
| Program is object-oriented as specified | 4 |
| Sufficient documentation | 2 |
| Style | 2 |

## Submission
Remember to update your Collaborations.txt file with any sources that you consulted.

Then make a .zip of your files and upload it to Moodle.
