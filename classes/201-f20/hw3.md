---
layout: page
title: HW 3 Analyzing Country Data
permalink: /classes/201-f20/hw3
---

# Logistics
25 points, due Monday, Sept 28th by 10PM Central time. Like all assignments, there is a 48-hour, no questions asked extensions policy. If you have a tech issue, a health issue, or some other issue that impedes making the deadline, use this policy. You need to notify me that you're using the policy. Extensions beyond the 48-hour policy will only be considered in extenuating circumstances, and circumstances that arise between the original deadline and the extension are generally not extenuating - the deadline is still the deadline, not 48 hours later.

# Goals
To build a non-trivial program with Java that includes both test and images and works with the List ADT.

# Assignment Type and Collaborative Learning Expectations
This is a homework assignment that you'll be handing in on Moodle.

You're welcome to either complete this homework with input from one or more members of your collaborative learning group or to complete it on your own. You and the other members of your collaborative learning group should each write your own code, even if you're helping one another, but you may share your screens/use multiplayer mode to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

# Setup and Requirements
Go to our Course on Repl.it and open the project HW3. Make sure that the repl is private.

You should first create a Collaborations.txt document and update it with any sources (webpage or people) that you get help from.

The code that you write for this assignment will build on top of the List ADT and one of the implementations of List that we've seen in class. The code will also use a library for producing graphs called [JFreeChart](https://github.com/jfree/jfreechart), one additional class that Professor Anna Rafferty wrote to make it easy for you to interact with the graphing library, and a dataset containing information about countries, created using data from the World Bank:

[jfreechart-1.5.0.jar](http://www.cs.carleton.edu/faculty/arafferty/cs201_spr2020/assignments/hw03-dataAnalysis/jfreechart-1.5.0.jar)

[BarChart.java](http://www.cs.carleton.edu/faculty/arafferty/cs201_fa2020/assignments/hw03-dataAnalysis/BarChart.java)

[CountryDataset.csv](http://www.cs.carleton.edu/faculty/arafferty/cs201_fa2020/assignments/hw03-dataAnalysis/CountryDataset.csv)

You should not make any changes to any of these files. The Javadoc for the BarChart class is at:

[BarChart](http://www.cs.carleton.edu/faculty/arafferty/cs201_fa2020/assignments/hw03-dataAnalysis/javadoc/BarChart.html)

It may be useful to refer to the code from class and the Java Reference file on Moodle. The official Java API documentation will likely be helpful for choosing what implementation of a List you'll use, and for seeing what methods are available.

## Note
We're using a separate Java library to do the plotting, which means that we'll need to tell the compiler and the Java virtual machine about that library. Specifically, we have to tell it to include those classes on the classpath - the set of classes that the program has access to (see this [StackOverflow question and answer for a little more info](https://stackoverflow.com/questions/2396493/what-is-a-classpath-and-how-do-i-set-it)). You'll do this by adding a classpath argument when you compile and run the program. So, when you want to compile on repl.it run:
```
javac -classpath .:jfreechart-1.5.0.jar *.java
```     
That tells the compiler to include the current directory (.) and the classes in the jar file when compiling. Then to run your program, type:
```
java -classpath .:jfreechart-1.5.0.jar CountryDisplayer
```    
and put your command-line arguments after `CountryDisplayer`. For this assignment, we're using a slightly older version of Java as newer versions on repl.it do not support graphics.

# Specification
For this assignment, you will write a program that reads from a text file with one line for each country.
You will create two classes, `CountryDisplayer` and `Country`.
Your program will need to represent each country as an instance of `Country` and each data file as an instance of `CountryDisplayer` (you will only use one data file, but you can imagine having multiple data files).
When creating an instance of `CountryDisplayer` your program should convert the data file into a `List<Country>` and then display the data in one of two forms:
* As a graph of the top 10 countries for a given indicator, in sorted order, along with the information from a second indicator (detailed below). An "indicator" is one of the types of data in the file - e.g., CO2 emissions per capita.
* As a test list of all countries, in sorted order for a given indicator.

This will give you practice working with the List ADT, `String`, `File`, `Scanner`, loops, and classes.
It's also a chance to see how your programming skills might be used to analyze large datasets.

## The input file
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

Click on the CSV file in repl.it to see all of the data.

The information in the data file (CountryDataset.csv) is based off of the [World Bank Indicators dataset](http://datatopics.worldbank.org/world-development-indicators/). The original dataset contains information about each country for each indicator (item) and year from 1960-2019 (although some years are missing for some countries). For each country, the dataset I've given you contains a single number for each indicator. That number is the average value of the indicator from 2012-2019, skipping any years where there wasn't data for that country.

For your testing, you can use the data file I've provided, but you can also test on smaller subsets of the data to make sure that your output is correct and that your program doesn't crash if there are no countries. For instance, you might make a file SmallCountries.csv where you just include the first 10 countries.

## Command-line syntax
Your main method in `CountryDisplayer.java` should be structured so that the program expects three or four command-line arguments. The meaning of the command line arguments is as follows:

1. The path to the file containing the country data. This includes the name of the file, and any directory information if the file is not in the same directory as the java program you're making. E.g., if the country file is in a subdirectory of the directory containing the java program and that subdirectory is named data, this argument would be data/CountryDataset.csv. (Note: there's nothing special you have to do to handle “CountryDataset.csv” versus “data/CountryDataset.csv”. File will do the right thing in both without you having to think about it.)
2. The name of the indicator that we should sort the data on. This should be one of: 
* `PopulationTotal`
* `CO2Emissions`
* `AccessToElectricity`
* `RenewableEnergy`
* `ProtectedAreas`
* `PopulationGrowth`
* `UrbanPopulationGrowth.`
3. The string `greatestToLeast` if we want to sort from greatest to least or the string `leastToGreatest` if we want to sort from least to greatest.
4. A second indicator that we also want to display. This should be from the same list of indicators represented above. If this second indicator is present, then the program should display a graph (see more below). Otherwise, the program should display text.

## Expected outcome
Your program should produce output based on whether three or four command-line arguments were present.

### Three command line arguments: Test display
The program should print to standard output (i.e. `System.out`) one country per line in sorted order. The sorted order should be based on the indicator and ordering passed in as the second and command-line arguments. The format of the text should be the same as from the original data file (so it would work well to save the line from reading in the data for this). For example, if "PopulationTotal" was the second command line argument and "leastToGreatest" was the third command-line argument, then the list of countries should begin with the the country with the smallest population total, followed by the one with the second to smallest population total, and so on. Here's an example of the first few lines of my output when I use the following command line:
```
> javac -classpath .:jfreechart-1.5.0.jar *.java
> java -classpath .:jfreechart-1.5.0.jar CountryDisplayer CountryDataset.csv RenewableEnergy leastToGreatest
Antigua and Barbuda,0.09,5.8,99.13,0,18.82,1.16,0.2
Bahrain,1.37,22.76,100,0,6.65,3.12,3.21
Cayman Islands,0.06,9.38,100,0,10.75,1.65,1.65
Gibraltar,0.03,14.25,100,0,30.51,0.05,0.05
Kuwait,3.63,28.6,100,0,17.5,4.25,4.25
Oman,3.98,16.12,100,0,2.57,5.76,7.14
```

There are 250 total lines of output as there are 250 countries in the file. (Note that some of you might be thinking "there aren't 250 countries in the world..." The "countries" we're using are whatever the WorldBank data listed as a country. That means that some territories, like Puerto Rico and Greenland, have their own data, and even some groups of countries, like "Euro area", are included.)

Note that for sorting, ties can be broken however you want. If you are stuck on the sorting, see the advice below.

### Four command line arguments: Graph display
If there are four command line arguments, your program should provide a graph of the top 10 countries based on sorting by a given indicator. Sorting should follow the same rules as for the text display. Your graph will include two series: one has the data for the indicator you sorted by, and the other has the data for the second indictor that was provided on the command line (as the fourth command line argument). For example, here's what gets displayed when I run the following line:
```
java -classpath .:jfreechart-1.5.0.jar CountryDisplayer CountryDataset.csv RenewableEnergy greatestToLeast AccessToElectricity
```
![Plot showing red and blue bars](/classes/201-f20/HW3Screenshot.png)

To do this, you should create an instance of `BarChart` and add data using `addValue(String country, double value, String series)` where series is the indicator, and then use `displayChart()`. You can look at the JavaDoc or code to learn more details, but should only need those methods.

### Code structure
Your code must be objected-oriented. What this means is that you must create instances of `Country` and `CountryDisplayer`. You should not create any additional static methods. You can and should create additional non-static methods however and aim to keep your methods short and focused.

You should not have repeated code and you will be especially tempted to repeat code for your sorting algorithm. You should structure your sorting so that there is no need to repeat code for different indicators and direction of order. If you're unsure how to do that, see the advice below.

You should make sure your code works with a dataset that is shorter than 10 countries. It should not throw an error, it should just plot that data. You do not need to handle the user putting in a file that is the wrong format however.

You do however need to handle a user typing other commands incorrectly by providing a friendly message (called a usage statement) if they:
* Type too many or too few parameters
* Type an indicator that is not from the list
* Type something other than 'leastToGreatest' or 'greatestToLeast'

# Advice
This is your first large assignment in this class and you might feel pretty overwhelmed. Here is how I advise you go about this project.

## Make your classes
First make your `Country` file. Think about what variables it will need.

Then make your `CountryDisplayer` file and class with its `List<Country>`.
Next write 'stubs' of the major methods that you will need for `CountryDisplayer` to work:
```
public class CountryDisplayer {
    //instance variables up here!
    List<Country> countries;
     
    public CountryDisplayer(String fileName) {
        // Read the country file and load the countries into this instance of CountryDisplayer.
    }
 
    public void sortCountryList(String indicatorName, boolean isGreatestToLeast) {
        // ...
    }
 
    public void displayTextCountries(??) {//I've put ?? for the parameters - brainstorm what should go there!
        // ...
    }
     
    public void displayCountryChart(??) {//I've put ?? for the parameters - brainstorm what should go there!
        // ...
    }
     
    public static void main(String[] args) {
        // If there's no command-line argument, print a usage statement 
        // and exit. Otherwise, use args[0] as the input file path.
        if (args.length == 0) {
           // ...
        }
         
        //Construct a CountryDisplayer and call the methods you defined above to load, process, and display the countries
    }
}
```
A stub just means that the method is defined but doesn't actually do anything.

## Read in your countries
Complete the `CountryDisplayer` constructor by looking at the code from the `LineReader.java`.
You will probably also want to make a better constructor for `Country` at this point.
It might be helpful to make a shorter version of the data file with just a few lines as you work on this part.
Make sure to test this code by creating a `CountryDisplayer` in the main of `CountryDisplayer.java`.
You don't need to get the file from the command line yet, just write the filename into your code for now.

## Display text of your countries
Complete the `displayTextCountries` method so that you can make sure that you successfully read the countries in.
You don't have the sorting function yet, so they will just display in the order from the text file and that's okay:
```
> javac -classpath .:jfreechart-1.5.0.jar *.java
> java -classpath .:jfreechart-1.5.0.jar CountryDisplayer
Afghanistan,33.26,0.33,72.7,15.73,0.1,2.99,3.89
Albania,2.89,1.76,100,38.62,17.56,-0.23,1.61
Algeria,39,3.47,99.51,0.15,7.5,1.98,2.91
Andorra,0.08,5.93,100,19.41,24.88,-1.03,-1.13
Angola,27,1.27,37.13,51.7,6.97,3.49,4.64
```

## Display a BarChart
It's always good to start off with a simple test when you are using a new library. 
Start your `displayCountryChart` method by just creating a `BarChart` and using `addValue` to add a couple of test values, then display it. 

Now change it to loop over the first ten countries in your list and add the values from one of their indicators. Remember to compile and run each time you change your code to make sure it works!

To chart two specific indicators, you'll need to grab those indicators from the countries by the string name. In `Country` make a method that takes a string and returns the indicator value for that country. This will look like a long line of if-else statements. 

Using your new method, update `displayCountryChart` to take two strings and add the correct indicator values and countries to the chart. Also make sure to add the name of the indicator for the series argument.

## Sorting
You're now ready to write a sorting function. Remember that one way of sorting is to make a new list and then look through your old list and repeatedly find and remove the largest value and put that value into your new list. Since you already have a method to get a specific indicator value for a country, you should be able to make a single sorting function that works for any indicator value. You should also use an if-else statement to control if you are sorting from least to greatest or greatest to least. Remember that you shouldn't have two separate sorting algorithms for this. You should think about what those two things have in common and what the one difference is.

## Command line
Now it's time to enable all of this to be controlled by command line arguments. Remember that all command line arguments are captured in `args` so you can just grab things out `args[0]`, `args[1]`, etc. 

Remember that you should check the arguments and if they aren't correct, you should print out a helpful message about what the correct argument options are and then quit.

# Rubric
This is how you will be graded on this assignment:

| Item | Points |
|------|--------|
| Sorting works | 4 |
| BarChart works | 3 |
| Text option works | 3 |
| Country and CountryDisplayer object oriented | 5 |
| All indicators and sorting options | 3 |
| Files with less than 10 countries | 2 |
| Sufficient documentation | 3 |
| Style | 2 |

# Submission
Make sure Collaborations.txt is accurate and includes any sources that you used including any conversations. Did you share strategies with anyone else? Talk about any annoying compiler error and get advice? These are fine things to do, and you should note them in the Collaborations.txt file. Give the names of people you talked with. If you used any resources outside of our course materials, that is also something to note in Collaborations.txt. If you didn't talk with anyone, please note that explicitly in Collaborations.txt.

After making Collaborations.txt and finishing the assignment, click on the three vertical dots next to the add file and add folder icons on repl.it, and choose "Download as zip" from the menu. Upload that zip on Moodle.

# Extras
If you finish everything above and want to do more, here are some ideas. Remember to submit the assignment above before doing these.

* If you're looking for further practice on your Java skills, use try/catch blocks to fail gracefully if the file is not found or if the file is not properly formatted. You might also try to partially recover if part of a file is not properly formatted - e.g., skip improperly formatted lines.
* Optionally allow a fifth command-line argument that indicates how many countries should be displayed in the graph. If this argument isn't included, the program should default to 10 countries.
