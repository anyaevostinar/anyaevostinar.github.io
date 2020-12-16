---
layout: page
title: Guessing Game Lab
permalink: /classes/201-w21/guessing-game-lab
---

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Wednesday Jan 6th, but it isn't due until Friday Jan 8th at 5:00pm Central.

Open the Guessing Game project on Repl.it as well as the Common Java Errors and Fixes Google Doc linked on Moodle.

You're welcome to work on this lab with input from one or more members of your collaborative learning group. You should write all of your own code, but you're welcome to share your screen/use multiplayer mode with members of your collaborative learning group to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

## Goals
To practice writing some Java and working with object oriented code.

## Introduction
In this lab, you'll be creating a guessing game. 
In a guessing game, the computer picks a number between 1 and 100 at random, and it asks the user to guess a number. 
After each guess, it tells the user if they are too high or too low, and then lets them guess again. 
If the user ever guesses correctly, the computer should congratulate the user and end the program. 
Here's an example of me interacting with my Guessing Game:
```
> javac GuessingGame.java
> java GuessingGame
Welcome to the Guessing Game!
What's your name? Anya
Hello Anya! The computer's job is to select a number between 1 and 100. Your job is to guess that number!
Guess the number: 27
Too low!
Guess the number: 30
Too low!
Guess the number: 60
Too high!
Guess the number: 50
Too low!
Guess the number: 55
Too low!
Guess the number: 57
Good job! 57 was my number. You win!
```

## Exercise 0
Before writing any code, create a `Collaborations.txt` file in repl.it (using the "Add file" button). 
In that file, indicate in what ways (if any) you collaborate with other people on this assignment. 
It's easier to write these down as you go instead of trying to remember at the end of an assignment and possibly forgetting something! 
Did you and your collaborative learning group look at each other's code? 
Talk about strategies? 
These are fine things to do, and you should note them in the `Collaborations.txt` file. 
If you use any resources outside of our course materials, that is also something to note in `Collaborations.txt`.

## Exercise 1
a. Now read through the code in GuessingGame.java, and understand the structure. What state does a GuessingGame have? Jot down your answer on a piece of paper or in a text file. 

b.  Next, try compiling the code: At the command line (the black part of the screen in repl.it): `javac GuessingGame.java`

c. Compiling the code should result in two errors. Read the compiler error messages and try to understand why it's giving you these errors.

d. Fix these errors by implementing `getNumber()` and `getDefaultNumber()` (each of these methods only needs one line of code!). Each time you finish making a change in your code, compile the program. When you've finished this part, you should no longer get any compile errors.

e. Type any questions you have about the structure of the code or about understanding compiler error messages in the Common Java Errors and Fixes Google Doc linked on Moodle.

## Exercise 2
To implement the guessing game, you'll need to change two methods: `playGame` and `main`. 
Both of these methods already exist in the code, but they don't do anything yet. 
As you're implementing these methods, add any compiler errors and exceptions that you get to the Google doc if they aren't already there, as well as how you fixed them. 
(Just like in Python, you'll find that it's helpful to have a mental library of what particular messages mean. 
Reflecting on how you fix an error can help you to build that mental library faster.)

a. Start off by implementing `main()`. 
The main method executes when the user runs `GuessingGame` from the command line: `java GuessingGame`. 
You'll need to construct a new `GuessingGame` object, start the game (i.e., call the `startNewGame` method on the `GuessingGame` instance you created), and play the game. 
Remember that unlike Python, you need to use the word `new` when constructing an object. 

b. Test your code and make sure it runs. 
You'll still see a message about not being able to play, since you haven't implemented `playGame()`, but now you're ready to play once you get that method working.

c. Now you're ready to write `playGame()`. 
It will likely be helpful to write down a high level outline of the logic for the method before turning your ideas into code.
I like to outline my ideas as comments in the method so that I can then just write the code for one comment at a time.
Your code should first welcome the user, asking for their name like my example does above. 
After welcoming the user, this method should get input from the user and have them guess until they're correct. 
You might look back at the examples from the comparing Python and Java activity to see an example of getting input from the user and looping. 
Your game should provide feedback to the user about whether their guess is too high or too low. 

d. Once you think you have `playGame` working, compile your code and run it. 
You should be able to interact with the game! 
Try a few games to make sure that the program performs properly, and debug your code to fix any issues.

## Exercise 3
Throughout the course you'll be required to include informative comments above each method in "JavaDocs" style. This style allows for a website to be generated with those comments nicely formatted and looking like the Java documentation that you'll become quite familiar with.

JavaDocs style is the following:
```
/**
* Generally descriptive few sentences about the method.
* @param nameOfParameter description of the parameter if useful, probably should mention the type
* @param anotherParameter if you have multiple parameters
* @return description of what if anything is returned, should definitely mention the type
*/
public int exampleMethod(int nameOfParameter, int anotherParameter){
  return 0;
}
```

a. For each method in `GuessingGame.java`, adapt the existing comment to include the `@param` and `@return` tags and the relevant information if needed.

## Submitting
This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the document to indicate things you tried but what went wrong/where you got stuck. Feedback on labs and activities is less detailed than on homework.

Download the zip of your code from Repl.it and upload it to Moodle.

## Extensions
Finished making your game? 
Great job! 
Here are some more things to try if you have extra time and desire to do more. 
These extensions are completely optional (and don't come with any extra credit).
Leave `GuessingGame.java` with your solution to the assignment above and create a new file called `GuessingGameExtended.java` if you want to submit these extensions.
Be sure to note in the header of that file what extensions you did.
* Print the player's score after they win the game. The score is the number of guesses they needed to win.
* Remove the default number, and instead make each new GuessingGame set the number to be guessed to a random value in the correct range. This should happen in the constructor, so the client doesn't have to remember to call `startNewGame()`.
* Allow multiple games. Ask the user after each game whether to play again, and if the response is yes, play another guessing game with a new number. Do you need a new `GuessingGame` for this?
* Modify `GuessingGame` to check if there's a single argument on the command line. If so, it's used as the number to guess. Make a second constructor as part of your changes. After you've implemented this extension, you should be able to run:
`java GuessingGame 13`
to play a guessing game where the correct number is 13. Why might it be useful to have this functionality?
* Modify `GuessingGame` to check if there are two arguments and the first one is a file flage "-f". If so, assume the second argument is a filename. The file should have one number per line. Each number corresponds to one guessing game with the player, where the number to guess is the number with the file. For example, if the file had two lines, the first with the number 59 and the second with the number 4, the game would first execute with the computer's number being 59. Once the player guessed correctly, a new game would start in which the computer's number was 4.
* Allow the user to choose between making a new guess and asking whether the number is a multiple of another number. For example, the user might ask if the number is a multiple of 3, and the program would respond yes or no.
* Make a new file `StringGuessingGame.java`, and copy your old code into it. Modify the game so that the user is now guessing a string rather than a number. I recommend just implementing the part where they guess some default string, rather than choosing a string at random. You can use the `compareTo` method of the `String` class to compare two strings; see the [Javadoc](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html) for more info.