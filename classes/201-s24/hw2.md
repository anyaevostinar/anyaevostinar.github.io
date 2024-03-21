---
layout: page
title: HW 2 Country Stats Displayer
permalink: /classes/201-s24/hw2
---

* [Logistics](#logistics)
* [Assessment](#assessment)
* [Specification](#specification)
* [Advice](#advice)
* [README](#readme)


## Logistics
This is a paired assignment, so you should complete it with your assigned partner, if you have one, via **paired programming**. 
The whole time that you are working, you should both be present and actively working on the problem at hand. 
(Two brains, one keyboard.) 
Switch off the typing duties so that you each type for roughly half of the time. 

You are able to get help from many sources as detailed in the [collaboration](collaboration) policy.

This assignment is due on Wednesday April 10th at 10pm. 
As with all assignments, you will have the opportunity to [revise](revision-process) this assignment individually based on the feedback that you get.

### Goals
To build a non-trivial program with Java that works with Java's ArrayLists and HashMaps and classes.

## Assessment

To **demonstrate proficiency**, your program needs to:
* Pass all tests on Gradescope
* Follow the specifications for the command-line, `name`, and `max` modes
* Be object-oriented
* Handle incorrect command-line user input as specified
* Have a README with an overview, example, and response to the prompt
* Be somewhat [well-styled](style-reference)

To **demonstrate mastery**, your program needs to:
* Demonstrate proficiency
* Have JavaDocs documentation for all public methods
* Have clear and helpful output
* Use private variables correctly and effectively
* Use `ArrayLists` and `HashMaps` effectively
* Be extremely [well-styled](style-reference) and clear by choosing descriptive variable names and including useful comments 
* Have a thorough, well-styled README with thoughtful prompt response
* Have clear and thorough documentation

### Setup
Again, I recommend you complete the programming portion in Olin 310. 

[Mount the COURSES drive](getting-started) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HW2`
* Open your `HW2` folder in VSCode
* Create a file Collaborations.txt and put in any help that you get on this assignment including sources that you reference and help from lab assistants or the prefect. Make sure to refer to the [Collaboration page](collaboration) on what collaborations are allowed for homework assignments.

The code that you write for this assignment will build on top of Java's ArrayList and HashMap data structures. The code will also use a dataset containing information about countries, created using data from the World Bank:

[CountryDataset.csv](/classes/201-f20/CountryDataset.csv)

The [official Java API documentation for ArrayList](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html) will likely be helpful for knowing what methods are supported by the `ArrayList`.
You may also want to use the documentation for [HashMap](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashMap.html).

You may find [resources on this list](resources) helpful for Java-specific things.

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

The information in the data file [CountryDataset.csv](/classes/201-f20/CountryDataset.csv) is based off of the [World Bank Indicators dataset](http://datatopics.worldbank.org/world-development-indicators/). The original dataset contains information about each country for each indicator (item) and year from 1960-2019 (although some years are missing for some countries). For each country, the dataset I've given you contains a single number for each indicator. That number is the average value of the indicator from 2012-2019, skipping any years where there wasn't data for that country.

For your testing, you can use the data file I've provided, but you can also test on smaller subsets of the data to make sure that your output is correct and that your program doesn't crash if there are no countries.

### User Interaction
Your program should have the following *usage statement*, i.e. the command-line arguments that the user provides when they run the program:

```bash
java CountryDisplayer CSVFile name/max
```

This means that the first thing the user types after `CountryDisplayer` should be the name of the csv file they want to use, such as `CountryDataset.csv`. The second thing should be *either* `name` or `max` to indicate the two different ways that they can get information from the program, as explained below.

You also need to handle a user typing commands or words incorrectly by providing a friendly and informative message (called a usage statement) if they type too many or too few command line arguments. The usage statement should be this:
```Usage: CSVFile name/max```

### `name` Mode

If the user indicates `name` as the second command-line argument, your program should:
1. Prompt them to enter the name of a country
2. Then prompt them to enter one of the column titles: `Population Total`, `CO2 Emissions`, `Access To Electricity`, `Renewable Energy Consumption`, `Terrestrial Protected Areas`, `Population Growth`, or `Urban Population Growth` (**these need to be exact since the autograder will be putting in these exact strings**)
3. Output the corresponding data

Here is an example of the program running. Your text shouldn't match exactly, the autograder will be only checking that it can put in the name of a country and one of the indicator strings and that the corresponding number is printed out. **You should make your text more user-friendly and clear**:

```bash
java CountryDisplayer CountryDataset.csv name
Country?
Libya
Indicator?
Population Total
Libya's Population Total: 6.4
```

### `max` Mode
Your program should also allow the user to look up the country with the maximum value of each indicator. Here is an example of that mode (again, the text shouldn't match this other than the indicator string and the country name):

```bash
java CountryDisplayer CountryDataset.csv max
Which indicator would you like the information for?
Population Total
China
```

### Country
Your `Country` class must use the following methods:

```java
public class Country {
    HashMap<String, String> stats = new HashMap<String, String>();

    /**
     * @param String the line with data about the country
     */
    public Country(String line_in){

    }

    /**
     * @param String the indicator to get the data for
     * @return Double the data for the associated indicator
     */
    public Double getStat(String indicator) {
        
    }

    /**
     * @return String the name of the Country
     */
    public String getName() {

    }

}
```

### CountryDisplayer
Your code must be objected-oriented. What this means is that you must create instances of `Country` and `CountryDisplayer`. You should not create any additional static methods. You can and should create additional non-static methods however and aim to keep your methods short and focused.

Your `CountryDisplayer` class must use the following methods:

```java
public class CountryDisplayer {
    //instance variables up here!
    ArrayList<Country> countries;
     
    /**
     * Read the country file and load the countries into this instance of CountryDisplayer.
     * @param fileName
     */
    public CountryDisplayer(String fileName) {

    }
 

    /**
     * Insert documentation here!
     */
    public Country getCountryByName(String name) {
        
    }
 
     /**
     * Insert documentation here!
     */
    public Country getCountryMaxIndicator(String indicator) {

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

## Advice
This is your first large assignment in this class and you might feel pretty overwhelmed. 
Remember that it's good to separate the way that your program will work from the Java that is necessary to get it to actually happen.
Feel free to first write pseudo-code for how you think a method should work and then get your reference sheet out to translate your pseudo-code to Java.

Here is how I advise you go about this project.

### Make your classes
First make your `Country` file and make sure that it works by making some `Country` objects with dummy data in the `main` of `Country.java`.

Then make your `CountryDisplayer` file and class with its `ArrayList<Country>`.
Next write 'stubs' of the major methods that you will need for `CountryDisplayer` to work.
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
To display information about specific indicators, you'll need to grab those indicators from the countries by the string name. In `Country`, finish your `getStat` method.
Note that `==` compares whether two Strings are literally the same Object, not their values. You will want to use the method `.equals(String in)` to compare their values if you need to. You will probably find the `Double.parseDouble` method helpful as well.

It's a good idea to test these small changes immediately in the `main()` method of your `Country.java` class. Create an instance of `Country` with dummy data and make sure you are able to get the data back out by the indicator name.

### Max Indicator
You're now ready to grab out the country with the maximum value of indicator. 
Since you already have a method to get a specific indicator value for a country, you should be able to loop over your countries and keep track of the country with that largest value of the specified indicator.

### User Input
Now you want to allow the user to specify everything that they want from your program. Make sure to allow the user to specify the location of the data file and both ways of getting data, as specified above.

## README
As always, you should include a detailed README for this homework. 
It should include a brief overview of your project and a short example of how to run your program and see its interesting behavior.

### Prompts
In addition, you should specifically have a section discussing the following design choice (this should be 1-2 paragraphs):
* Why does it make sense to make this program object-oriented? You didn't have a choice, but you should reflect on the benefits of an object-oriented approach to this task instead of simply looking through the data file or lists, for example.



## Submitting
Remember to update your `Collaborations.txt` file with any sources that you consulted.

Then upload all of your files to the Gradescope link on Moodle, at which point the autograder will run and let you know if your code works correctly. You are able to submit your code as many times as you wish before the deadline to fix any issues. If you have questions about what the autograder is telling you is wrong, please ask!
