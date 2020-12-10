---
layout: page
title: Homework 1 - Guessing Game
permalink: /classes/201-w21/hw1-guessing-game
---

## Logistics
10 points, due Friday, Jan 8th by 10PM Central time. Like all assignments, there is a 48-hour, no questions asked extensions policy. If you have a tech issue, a health issue, or some other issue that impedes making the deadline, use this policy. You need to notify me that you're using the policy. Extensions beyond the 48-hour policy will only be considered in extenuating circumstances, and circumstances that arise between the original deadline and the extension are generally not extenuating - the deadline is still Friday, not 48 hours later.

## Goals
To practice writing some Java and working with object oriented code.

Required concepts:
* Reading and writing Java
* Looping
* Conditionals
* Object-oriented programming

Additional concepts:
* Input/output
* User-friendly interface
* Descriptive variable names
* Good style

## Guessing Game
In this assignment, you'll be creating a guessing game. 
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

### Set up and instructions
You're welcome to either complete this homework with a member of your homework group or to complete it on your own. 
You and the other members of your homework group should each write your own code, even if you're completing it together, but you may share your screens/use multiplayer mode to look at one another's code, make suggestions, and compare ideas. 
You're strongly encouraged to reach out to your group about questions you have or if there are things you were surprised by. 
You're also (as always) welcome to post questions on the forum to the whole class. 
**Please only post small amounts of code if you're posting code**. 
If you're not sure what part of the code you need help with, come to office hours, lab assistant hours, or post the code privately so only the course staff and I can see it. 
You might also check out the common Java Errors and Fixes document, linked on Moodle. 
You and your classmates will collaboratively add to this document, and if you're stuck, you might find a helpful suggestion there.

You'll complete this assignment on repl.it. Go to the student page and log in. Then click on the CS201 classroom. Under Projects, click "HW1". 
With every project you do in this class, you should make sure the repl is private. Click on the pencil icon next to the project name, and switch the toggle from public to private:

![Screenshot of Repl.it showing name of assignment circled and private slider](/classes/201-f20/PrivateRepl.PNG)


Your account shouldn't say that you need to upgrade because you should have the free Hacker plan from the upgrade. 
If you haven't gotten that set up, look at the page on "Tools for this class", linked on Moodle. 
You can work on the assignment without making it private, but it will be required that you make future projects private.

If you run into any issues logging on to repl.it or finding this project, please ask in Piazza right away!

### Getting Acquainted with the Guessing Game
Before writing any code, create a `Collaborations.txt` file in repl.it (using the "Add file" button). 
In that file, indicate in what ways (if any) you collaborate with other people on this assignment. 
It's easier to write these down as you go instead of trying to remember at the end of an assignment and possibly forgetting something! 
Did you and your homework group look at each other's code? 
Talk about strategies? 
These are fine things to do, and you should note them in the `Collaborations.txt` file. 
If you use any resources outside of our course materials, that is also something to note in `Collaborations.txt`.

* Now, read through the code in GuessingGame.java, and understand the structure. What state does a GuessingGame have? Jot down your answer on a piece of paper or in a text file. 
* Next, try compiling the code: At the command line (the black part of the screen in repl.it): `javac GuessingGame.java`
* Compiling the code should result in two errors. Read the compiler error messages and try to understand why it's giving you these errors.
* Fix these errors by implementing `getNumber()` and `getDefaultNumber()` (each of these methods only needs one line of code!). Each time you finish making a change in your code, compile the program. When you've finished this part, you should no longer get any compile errors.

Jot down any questions you have about the structure of the code or about understanding compiler error messages.

### Implementing the Game
To implement the guessing game, you'll need to change two methods: `playGame` and `main`. 
Both of these methods already exist in the code, but they don't do anything yet. 
As you're implementing these methods, jot down compiler errors and exceptions that you get, as well as how you fixed them. 
(Just like in Python, you'll find that it's helpful to have a mental library of what particular messages mean. 
Reflecting on how you fix an error can help you to build that mental library faster.)

Start off by implementing `main()`. 
The main method executes when the user runs `GuessingGame` from the command line: `java GuessingGame`. 
You'll need to construct a new `GuessingGame` object, start the game (i.e., call the `startNewGame` method on the `GuessingGame` instance you created), and play the game. 
Remember that unlike Python, you need to use the word `new` when constructing an object. 
Test your code and make sure it runs. 
You'll still see a message about not being able to play, since you haven't implemented `playGame()`, but now you're ready to play once you get that method working.

Now you're ready to write `playGame()`. 
It will likely be helpful to write down a high level outline of the logic for the method before turning your ideas into code.
I like to outline my ideas as comments in the method so that I can then just write the code for one comment at a time.
Your code should first welcome the user, asking for their name like my example does above. 
After welcoming the user, this method should get input from the user and have them guess until they're correct. 
You might look back at the examples from the comparing Python and Java activity to see an example of getting input from the user and looping. 
Your game should provide feedback to the user about whether their guess is too high or too low. 

Once you think you have `playGame` working, compile your code and run it. 
You should be able to interact with the game! 
Try a few games to make sure that the program performs properly, and debug your code to fix any issues.

### Turning it in
You'll turn your code in on Moodle under the Guessing Game assignment.

After double checking you included everything necessary in `Collaborations.txt` and finishing the assignment, click on the three vertical dots next to the add file and add folder icons on repl.it, and choose "Download as zip" from the menu. 
Upload that zip on Moodle.


### Grading
The grading of your homework assignments is tiered to match the meaning of letter grades as listed in the syllabus. The C-Tier requires you demonstrate understanding of the required concepts while the later tiers cover additional concepts. 

**C-Tier** 7 points total
* Code compiles and runs
* Correct loop choice
* Correct use of if/else
* Constructs and correctly uses GuessingGame object in main()

**B-Tier** 8.5 points total
* Everything from C-Tier
* Correct use of input/output
* User-friendly interface as specified
* Descriptive variable names
* Good style

**A-Tier** 10 points total
* Everything from B-Tier
* All methods have JavaDocs-style comments
* Implement one extension from below in a file `GuessingGameExtended.java`


In addition to turning in your code on Moodle, you should go to the "Common Java Errors and Fixes" google doc, linked on Moodle, and add in any errors that you jotted down. 
This will help us to develop a shared understanding of common Java issues and ways to fix them, getting everyone unstuck faster.

### Extensions
Finished making your game? 
Great job! 
Here are some more things to try if you have extra time and desire to do more. 
Leave `GuessingGame.java` with your solution to the assignment above and create a new file called `GuessingGameExtended.java` if you want to submit these extensions for comments.
If you want comments, be sure to note in the header of that file what extensions you did.
* Print the player's score after they win the game. The score is the number of guesses they needed to win.
* Remove the default number, and instead make each new GuessingGame set the number to be guessed to a random value in the correct range. This should happen in the constructor, so the client doesn't have to remember to call `startNewGame()`.
* Allow multiple games. Ask the user after each game whether to play again, and if the response is yes, play another guessing game with a new number. Do you need a new `GuessingGame` for this?
* Modify `GuessingGame` to check if there's a single argument on the command line. If so, it's used as the number to guess. Make a second constructor as part of your changes. After you've implemented this extension, you should be able to run:
`java GuessingGame 13`
to play a guessing game where the correct number is 13. Why might it be useful to have this functionality?
* Modify `GuessingGame` to check if there are two arguments and the first one is a file flage "-f". If so, assume the second argument is a filename. The file should have one number per line. Each number corresponds to one guessing game with the player, where the number to guess is the number with the file. For example, if the file had two lines, the first with the number 59 and the second with the number 4, the game would first execute with the computer's number being 59. Once the player guessed correctly, a new game would start in which the computer's number was 4.
* Allow the user to choose between making a new guess and asking whether the number is a multiple of another number. For example, the user might ask if the number is a multiple of 3, and the program would respond yes or no.
* Make a new file `StringGuessingGame.java`, and copy your old code into it. Modify the game so that the user is now guessing a string rather than a number. I recommend just implementing the part where they guess some default string, rather than choosing a string at random. You can use the `compareTo` method of the `String` class to compare two strings; see the [Javadoc](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html) for more info.