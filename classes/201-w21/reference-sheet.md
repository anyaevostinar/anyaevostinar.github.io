---
layout: page
title: Reference Sheet
permalink: /classes/201-w21/reference-sheet
---

One of the downsides of videos about code is that it's difficult to quickly skim through the video to find the example code if you need a reminder about syntax while working on the labs in class. 
To deal with that, I've prepared this reference sheet for the first few videos in class, organized by video.
This page is not at all a substitute for watching the videos, hence why there is no explanation for what the code means.

# Classes and Variables Video

```
javac *.java
java DieGame
```

In `DieGame.java`:
```
public class DieGame {
  public static void main(String[] args) {
    Die die1 = new Die(4);
    Die die2 = new Die(6);
    System.out.println("This many dice: " + Die.getNumberOfDice()); 
    //Above added to show calling class methods
    System.out.println("Here is the die value: " + die1.getValue());
  }
}
```

Relevant and additional pieces of `Die.java`:
```
import java.util.Random;

public class Die {
  private int numberOfSides;
  private int value;
  private Random randomNumberGenerator;
  private static int numberOfDiceCreated = 0; //added to show class variable

  public Die(int n) {
    numberOfSides = n;
    value = 1;
    randomNumberGenerator = new Random();
    numberOfDiceCreated += 1; //added to show class variable
  }

  public static int getNumberOfDice() {
    return numberOfDiceCreated;
  }
  
  public void roll() {
    int temp = 1; //added to show local variable
    value = randomNumberGenerator.nextInt(numberOfSides) + temp;
  }

  public int getValue() {
    return value;
  }
}
```

# Try/Catch and JavaDocs

```
class Main {
  public static void main(String[] args) {
    File inputFile = new File("somelines.txt");
    Scanner scanner = null;
    try {
      scanner = new Scanner(inputFile);
    } catch (FileNotFoundException e) {
      System.err.println(e);
      System.exit(1);
    }
    System.out.println("I just want to read a file!");
  }
}
```

# Inheritance
```
import java.util.List;
import java.util.ArrayList;

public class Student {
  private Name name;
  private double gpa;
  private List<String> classes;

  public Student () {
    name = new Name();
    gpa = 4.0;
    classes = new ArrayList<String>();
  }

  public Student(Name name, double gpa) {
    this.name = name;
    this.gpa = gpa;
    classes = new ArrayList<String>();
  }

  public Name getName() {
    return this.name;
  }

  public void displayClasses() {
    for (String aClass : classes) {
      System.out.println(aClass);
    }
  }

  public void addClass(String newClass){
    classes.add(newClass);
  }

  public void display() {
    System.out.println("I'm in Student!");
    System.out.format("%s \nClasses:\n", this.getName().getFullName());
    displayClasses();
  }
}
```

```
public class Name {
  private String firstName;
  private String lastName;
  
  public Name(){
    firstName = "";
    lastName = "";
  }

  public Name(String first, String last){
    firstName = first;
    lastName = last;
  }

  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }
}
```

```
public class CollegeStudent extends Student {
  private int graduationYear;
  private String department;

  public CollegeStudent() {
    super();
    graduationYear = 2020;
    department = "[undeclared]";
  }
  
  public CollegeStudent(String firstName, String lastName, double gpa, int year) {
    super(new Name(firstName, lastName), gpa);
    graduationYear = year;
    department = "[undeclared]";
  }

  @Override
  public void display() {
    System.out.println("I'm in CollegeStudent!");
    System.out.format("%s (year %d)\nMajor: %s\nClasses:\n",
    this.getName().getFullName(), 
    this.graduationYear,
    this.department);
    displayClasses();
  }

  public void collegeStudentMethod() {
    System.out.println("Only for college students");
  }

}
```

```
class Main {
  public static void main(String[] args) {
    
    CollegeStudent test = new CollegeStudent("this", "test", 4.0, 2020);
    test.collegeStudentMethod();

    Student test2 = new CollegeStudent();
    test2.display();
    

  }
}
```

# Interfaces
```
/**
 * Interface for a Plant. Specifies the behaviors that all plants
 * must implement.
 * @author Anna Rafferty
 *
 */
public interface Plant {
    /**
     * Returns the name of the plant. 
     * @return String representing plant's name
     */
    public String getName();
    
    /**
     * Waters the plant with how much water it needs.
     */
    public void waterPlant();
    
    /**
     * Ages the plant by a day. This could change the 
     * plant's water level or other characteristics.
     */
    public void elapseDay();
    
    /** 
     * Returns a string describing the state of the plant. E.g., might say "overly dry" or 
     * "abundantly happy". State of the plant may vary with water level or other
     * characteristics.
     * @return String representing status
     */
    public String getStatus();
    
    /** 
     * Returns the current water level for the plant. Each plant has a water level indicating 
     * whether it is dry, water-logged, or somewhere in between. 
     * @return int representing water level
     */
    public int getWaterLevel();
    

}
```

```
public class Strawberry implements Plant {
  private int waterLevel = 0;

  @Override
  public void waterPlant() {
    waterLevel += 1;
  }

  @Override
  public void elapseDay() {
    waterLevel -= 1;
  }

  @Override
  public String getName() {
    return "Strawberry";
  }
    
    
    /** 
     * Returns a string describing the state of the plant. E.g., might say "overly dry" or 
     * "abundantly happy". State of the plant may vary with water level or other
     * characteristics.
     * @return String representing status
     */
  public String getStatus() {
    return "Always happy";
  }
    
    /** 
     * Returns the current water level for the plant. Each plant has a water level indicating 
     * whether it is dry, water-logged, or somewhere in between. 
     * @return int representing water level
     */
  public int getWaterLevel() {
    return waterLevel;
  }
}
```

```
/**
 * Garden is a simulation of an actual garden that instantiates plants, waters them,
 * and displays them. (Add details if you change things about the class)
 * Look at the lab description for details about what to do with the Garden class.
 */
public class Garden {

    
    
    public static void main(String[] args) {
    	Plant test = new Strawberry();
    }
}
```

# Lists and Generics in Java
```
List<String> animalList = new ArrayList<String>();
```

```
List<Die> myDiceList = new ArrayList<Die>();
//...
myDiceList.get(0).roll();
```

```
import java.util.List;
import java.util.ArrayList;

class Main {
  public static void mystery(List<Character> list) {
    for(int i = 0; i < list.size() - 1; i++) {
      list.add(i, list.remove(list.size()-1));
    }
  }

  public static void main(String[] args) {
    List<Character> myList = new ArrayList<Character>();
    for (char c = 'a'; c<= 'h'; c++) {
      myList.add(c);
    }
    mystery(myList);
  }
}
```

# Sets and Maps in Java
```
import java.util.Map;
import java.util.HashMap;

class Main {
  public static void main(String[] args) {
    Map<String, Integer> wordCounts = new HashMap<String, Integer>();

    wordCounts.put("hi", 1);
    wordCounts.put("hi", 2);
    wordCounts.put("friend", 1);

    for(String word : wordCounts.keySet()) {
      System.out.println("\""+ word + "\" has been seen " + wordCounts.get(word) + " times.");
    }
  }
}
```

```
import java.util.Set;
import java.util.HashSet;

public class SetTest{
  public static void main(String[] args){
    Set<Integer> mySet = new HashSet<Integer>();
    for (int i=0; i<5; i++) {
      mySet.add(i);
      mySet.add(2*i);
    }

    int myInt = Integer.parseInt("1");
    double myDouble = Double.parseDouble("1.0");
  }
}
```