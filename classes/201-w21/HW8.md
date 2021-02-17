---
layout: page
title: HW 8 Flashcard Displayer
permalink: /classes/201-w21/hw8
---

## Logistics
25 points, due Friday March 5th by 10PM Central time. Like all assignments, there is a 48-hour, no questions asked extensions policy. If you have a tech issue, a health issue, or some other issue that impedes making the deadline, use this policy. You need to notify me that you're using the policy. Extensions beyond the 48-hour policy will only be considered in extenuating circumstances, and circumstances that arise between the original deadline and the extension are generally not extenuating - the deadline is still the deadline, not 48 hours later.

## Goals
To implement a heap and use it as a priority queue. You'll deepen your understanding of the heap operations by adapting them to a new application.

## Assignment Type and Collaborative Learning Expectations
This is a homework assignment that you'll be handing in on Moodle.

You're welcome to either complete this homework with input from one or more members of your collaborative learning group or to complete it on your own. You and the other members of your collaborative learning group should each write your own code, even if you're helping one another, but you may share your screens to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

## Setup and Requirements
Open the HW 8 project on Repl.it.

In this assignment, you'll build a flashcard displaying program. You'll allow the user to load flashcards from a file, which will include a priority level for the flashcard, and display all the flashcards until the user decides they are done for the session. The highest priority level flashcard should be shown to the user next and the priority will be updated based on if the user gets it right or not. If the user gets the flashcard right, the priority level will be lowered. If the user gets it wrong, the priority level will be increased. You'll also save the flashcards with their updated priority levels so a user could then continue studying at a later time. 

Create a file Collaborations.txt and put in any collaboration with your learning group or references to outside websites.

## Storing Flashcards
First create a `Flashcard` class that stores the front and back of the flashcard as well as its priority level. It should have the following methods:

```
/**
 * Creates a new flashcard with the given
 * priority level, text for the front of the card (front),
 * and text for the back of the card (back).
 */
public Flashcard(Integer priority, String front, String back);

/**
 * Gets the text for the front of this flashcard.
 */
public String getFrontText();
 
/**
 * Gets the text for the Back of this flashcard.
 */
public String getBackText();
 
/**
 * Gets the priority level of this flashcard.
 */
public Integer getPriority();

/**
 * Compares the priority levels of the current flashcard and another flashcard
 */
 public int compareTo(Flashcard b);

/**
 * Returns a string in the format "priority,front,back\n"
 */
 public String toString();

/**
 * Updates the priority of the card but doesn't allow priority to become negative.
 */
 public void setPriority(Integer newPriority);
```

Your Flashcard will also need to implement the `Comparable` interface for it to work with the priority queue you'll create later:
```
public class Flashcard implements Comparable<Flashcard> {}
```

You are welcome to implement other methods in addition to these if you find them helpful.

## Implementing a Priority Queue
Next you'll write a class `FlashcardPQ` that implements a priority queue by making a max-heap. Your class should implement the provided interface `PriorityQueue` for `Flashcard`s:
```
public class FlashcardPQ implements PriorityQueue<Flashcard>
```

You should adapt the code from the reading to make an **array-based max heap**. You may use an array or an `ArrayList` (remember that if you use an array, you have to deal with resizing it).

You must check that each method from the interface works by calling them in `main` of `FlashcardPQ.java`. I recommend making at least five flashcards and making sure that a flashcard is able to move to the top of your heap correctly.

## Implementing a Flashcard Displayer
Finally, write a `FlashcardDisplayer` class that allows the user to store and display flashcards. It must have the following methods:

```
/**
 * Creates a FlashcardDisplayer with the flashcards in file. 
 * File has one flashcard per line. Each line is formatted as:
 * priority,front,back
 */
 public FlashcardDisplayer(String file);

/**
 * Writes out all flashcards to the same file
 * they were read from so that they can be loaded by
 * the FlashcardDisplayer(String file) constructor. 
 * The FlashcardDisplayer should still have 
 * all the same flashcards after this method is called 
 * as it did before the method was called.
 */
 public void saveFlashcards();

 /**
  * Continuously displays flashcards to the user
  * and checks their answers, updating the priority
  * of each flashcard based on if the user answered 
  * correctly or not. Displays the highest priority
  * flashcard first. Ends when the user enters 'save'.
  */
  public void displayFlashcards();
```

Remember the `split` method will be useful for breaking each line into its pieces.

For the `saveFlashcards()` method, you will need to write to a file, which we haven't done in class before. It is fairly similar to reading from a file, here is an example:
```
try {
    FileWriter myWriter = new FileWriter(fileName);
    myWriter.write("hi");
    myWriter.close();
} catch (IOException e) {
    System.err.println(e);
    System.exit(1);
}
```
I recommend you create a `toString()` method in `FlashcardPQ` and use that to get a string of all the flashcards.

Here is the `displayFlashcards()` method running (**you must match this exactly!**):
```
Welcome! This program will display your 
flashcards to you, check if you entered the 
correct answer and then ask you save or next? 
Saving will update the information in the file 
you provided. Here is your first card.
Card:
Beijing
Your answer: China
Correct!
save or next? next
Card:
Kabul
Your answer: Afghanistan
Correct!
save or next? next
Card:
Ottawa
Your answer: Canda
Not quite!
Correct answer: Canada
save or next? next
Card:
Ottawa
Your answer: Canada
Correct!
save or next? save
```

The amount you adjust the priority based on correct or incorrect answers is up to you. A good enough adjustment is +2 for incorrect and -1 for correct, though you are welcome to do different amounts as long as incorrect answers increase the priority of the card and correct answers decrease the priority of the card. Also remember that when comparing String objects, you should use `.equals`.

## Command line interface
Finally, you should accept the name of the flashcards text file via command line arguments:
```
> java FlashcardDisplayer SampleFlashcards.txt
Welcome! This program will display your flashcards 
to you, check if you entered the correct answer 
and then ask you save or next? Saving will update
 the information in the file you provided. Here is 
 your first card.
...
```

## Grading
Your assignment will be graded with the following rubric:

| Item | Points |
|-------|-------|
| Flashcard class has all required methods | 7 |
| PriorityQueue interface methods implemented and tested | 5 |
| Command line interface correct | 2 |
| FlashcardDisplayer constructor works correctly | 2 |
| saveFlashcards updates file correctly | 2 |
| displayFlashcards continuously loops until 'save' | 2 |
| displayFlashcards checks answers | 2 |
| displayFlashcards updates priorities | 2 |
| JavaDocs style method comments | 1 |