---
layout: page
title: Classes Lab
permalink: /classes/111-w22/classes
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.

## Exercise 0
This is a repeat of what we discussed at the beginning of class.

a) Download the [starter code for today's lab](Week6FridayStarter.zip) and move the two files into your lab folder.

b) In the file `broomballPlayer.py` create a `main` function outside of the class. In that function, make two `BroomballPlayer`s, call the `recordGame` method on each and print their names and talent by calling the respective methods. Make sure to call `main` at the end of the file and test that your code works.

c) In the file `broomballTeam.py` create a `main` function outside of the class. In that function, make two `BroomballTeam`s. None of the existing methods let you do something easy with the teams, so add a method `getName()` that just returns the name of the team and print each of them to make sure that the code works.

## Exercise 1
In this exercise, you'll create a new method for the `BroomballTeam` class called `getLeadingScorer`.
This method should return the player on the team with the most recorded goals.

a) This method will be much easier to implement if you first implement a new method in the `BroomballPlayer` class that returns the total number of recorded goals for that player. You should use the instance variable `self.goalsPerGame` and the `sum` function, which takes a list of numbers and returns the total.

b) Test your method in the `main` of the `BroomballPlayer` class by calling the `recordGame` method and then your new method to be sure that it works correctly.

c) Use your new method to implement the `getLeadingScorer` method.

d) To test the `getLeadingScorer` method, you should create a new file `main.py` that imports both of your class files:
```
from broomballPlayer import BroomballPlayer
from broomballTeam import BroomballTeam
```
In the `main` function of `main.py`, create two `BroomballTeam`s, create some players to add to those teams (feel free to get creative with their names and talents), record some games for each of the players, and add them to the teams. Then call your `getLeadingScorer` method to make sure that it is returning the correct player for each team.

Note that if you were just directly calling `main()` in your class files, that will now happen when you import them.
To prevent that from happening, use the `__name__` variable at the end of each class file:
```
if __name__ == "__main__":
    main()
```

## Exercise 2
Now, add a method to the `BroomballTeam` class called `simulateGame` that simulates a score for the team in a single game by getting a random number of goals for each player on the team between 0 and their talent level, and add them all together. 
(The `random` module's `randint` function should be helpful ([documentation](https://docs.python.org/3/library/random.html#random.randint)).) 
Your method should record each player's score using their `recordGame` method, and should return the total score of the whole team.

To design this method, I recommend you first write a header to document what the overall task for the method is, then write out pseudocode of what steps you'll need to do to accomplish the overall task, before then writing Python to accomplish each of the steps.

You should make sure to then test your code either in `BroomballTeam`'s `main` or in `main.py`'s `main`. You might find it useful to print out the goals of each player as well as the result of the simulated game to make sure that the result makes sense.

## Exercise 3
Write a **function** in `main.py` called `simGames` that takes as parameters two `BroomballTeam` objects (`team1` and `team2`) and a number of games (`n`) to simulate between them. 
Specifically, for a given number of games, your function should get a score for each `BroomballTeam` using `simulateGame`, compare them to see who won, and use the `recordGame` method to record that result for each `BroomballTeam`. 
At the end of the function, print out each team's winning percentage, and their leading scorer. 
(You should test these tasks incrementally.)