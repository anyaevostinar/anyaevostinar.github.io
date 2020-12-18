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

