---
layout: page
title: HW 7 Flashcard Displayer
permalink: /classes/201-f21/hw7
---

## Logistics
30 points, due Friday Nov 5th by 10PM Central time. Like all assignments, there is a 48-hour, no questions asked extensions policy. If you have a tech issue, a health issue, or some other issue that impedes making the deadline, use this policy.  You or your partner need to notify me that you're using the policy via email, CC'ing the partner. Extensions beyond the 48-hour policy will only be considered in extenuating circumstances, and circumstances that arise between the original deadline and the extension are generally 

## Goals
To implement a heap and use it as a priority queue. You'll deepen your understanding of the heap operations by adapting them to a new application.

## Assignment Type and Collaborative Learning Expectations
This is a homework assignment that you'll be handing in on Moodle.

You must work on this homework with your assigned partner (if you have one) via pair programming. That means that you cannot write **any** code without your partner and you must both be fully engaged and discussing the code at all times while working. See the [collaboration policy](collaboration) for details.

## Setup and Requirements
Mount COURSES, download the [HW 7 Starter Code](HW7Starter.zip) and move it to your StuWork/username folder. You should follow the same process of compressing your files and uploading them to Moodle to submit your homework. 

Create a file `Collaborations.txt` and put in any help that you get on this assignment including sources that you reference and help from lab assistants or the prefect. Make sure to refer to the [Collaboration page](collaboration) on what collaborations are allowed for homework assignments.

## Setup and Requirements
In this assignment, you'll build a flashcard displaying program. You'll allow the user to load flashcards from a file, which will include a priority level for the flashcard, and display all the flashcards until the user decides they are done for the session. The highest priority level flashcard should be shown to the user next and the priority will be updated based on if the user gets it right or not. If the user gets the flashcard right, the priority level will be lowered. If the user gets it wrong, the priority level will be increased. You'll also save the flashcards with their updated priority levels so a user could then continue studying at a later time. 

Create a file Collaborations.txt and put in any collaboration with your learning group or references to outside websites.

### Storing Flashcards
First look at the starter code for the `Flashcard` class that stores the front and back of the flashcard as well as its priority level. You should implement the methods that are in that file.

You are welcome to implement other methods in addition to these if you find them helpful.

### Implementing a Priority Queue
Next you'll implement the class `FlashcardPQ` that implements a priority queue by making a max-heap. Your class implements the provided interface `PriorityQueue` for `Flashcard`s, though the methods are just stubs currently.

You should adapt the code from the reading to make an **array-based max heap**. You may use an array or an `ArrayList` (remember that if you use an array, you have to deal with resizing it).

You must check that each method from the interface works by calling them in `main` of `FlashcardPQ.java`. I've provided you five sample flashcards, but you **must make at least 5 of your own** and demonstrate that a flashcard is able to move to the top of your heap correctly.

### Implementing a Flashcard Displayer
Finally, complete your `FlashcardDisplayer` class that allows the user to store and display flashcards. I've provided the following methods:

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
```

And you need to implement the `main` and other remaining method:
```
 /**
  * Continuously displays flashcards to the user
  * and checks their answers, updating the priority
  * of each flashcard based on if the user answered 
  * correctly or not. Displays the highest priority
  * flashcard first. Ends when the user enters 'save'.
  */
  public void displayFlashcards();
```

Here is one way of the `displayFlashcards()` method running, though you can of course make different decisions about how the user interacts with your program:
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

Also, the amount you adjust the priority based on correct or incorrect answers is up to you. A good enough adjustment is +2 for incorrect and -1 for correct, though you are welcome to do different amounts as long as incorrect answers increase the priority of the card and correct answers decrease the priority of the card. Also remember that when comparing String objects, you should use `.equals`.

### User interface
Finally, the user should be able to do the following:
* Specify the file to load and store the flashcards in
* Go through the flashcards as many times as they wish
* Save their progress on the flashcards
* The flashcard displayer should automatically check if the user answered correctly, they shouldn't have to check themselves

The filename can be specified with command-line or interactive input.
The rest of the  behavior should be through interactive input.

## README
As always, you should include a detailed README for this homework. 
It should include a brief overview of your project, a short example of how to run your program and see its interesting behavior, and a more detailed section that has **demonstration input or code/line numbers for each of the rubric items**. Remember, you want to make it as easy as possible for the grader to see that your homework does everything its supposed to!

Remember that you should use Word or Google Docs or Markdown to make a nicely formatted README. 
You should not have a README in plain text!

There is no additional prompt for this homework.

## Grading
Your assignment will be graded with the following rubric:

| Item | Points |
|-------|-------|
| README clear and complete | 6 |
| Flashcard class has all required methods | 5 |
| PriorityQueue interface methods implemented and tested | 5 |
| At least 5 new flashcards provided | 3 |
| User can specify flashcard file | 2 |
| Program saves the state of the flashcards to the same file | 2 |
| displayFlashcards continuously loops until user indicates to stop | 2 |
| displayFlashcards checks answers | 2 |
| displayFlashcards updates priorities | 2 |
| JavaDocs style method comments | 1 |