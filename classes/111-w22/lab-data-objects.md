---
layout: page
title: Data Analysis with Objects Lab
permalink: /classes/111-w22/data-objects
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.

## Exercise 0
(As usual, this is a repeat of what was demonstrated at the beginning of class.)

Download the `BroomballPlayer` and `BroomballTeam` solution files from the previous lab and put them in your folder for today's lab.

Now create a new file called `broomballLeague.py`. 
You’ll want to import the `BroomballPlayer` and `BroomballTeam`  classes into this file, which can be done by placing the following code at the top of this new file:
```
from broomballPlayer import BroomballPlayer
from broomballTeam import BroomballTeam
```

Now, in this file, create a class called `BroomballLeague`. This class’s constructor (i.e., `__init__()` method) should accept a single argument, `teams`, which is a list of `BroomballTeam` objects representing all the teams in a Broomball league.

As always, you should test your code immediately after you've written a short segment, so also create a `main` function in `broomballLeague.py`.
In that function, create a list of teams and then use that to create a league object and print the league's teams to ensure that your constructor worked correctly. 
(You could also make an accessor method to do this, which would be a good addition.)

## Exercise 1

Write a method for the `BroomballLeague` class called `simulateGame()` that takes as its arguments two `BroomballTeam` objects, `home` and `away`, representing the home team and the away team for a game. 
This method should do the following:
* Get a score for each `BroomballTeam` object by calling their respective `simulateGame()` methods.
* Add one goal to the home team’s total — this models home-field advantage.
* Compare those two scores to see who won (note: it may be a tie).
* Use the teams’ `recordGame()` methods to record the result from that team’s perspective (win, loss, or tie). (You will need to refactor `simulateGame()` a bit to make this work, which is a normal part of programming when you realize that you need a method to work a little bit different than you first thought!)
* Remember to test your code at this point.

## Exercise 2
Now, make a method for the `BroomballLeague` class called `simulateSeason()`. 
This will simulate an entire Broomball season in which all the teams in the league vie for its championship! 
Specifically, this method should simulate each team playing both a home and an away game against each of the other teams in the league. Here’s a hint for this part:
```
for homeTeam in self.teams:
    for awayTeam in self.teams:
        # Do stuff, but make sure a team doesn’t play itself!
```

Remember to test this code at this point.

## Exercise 3
Finally, make another method for the `BroomballLeague` class called `results()` that prints out the following:
* Each team’s winning percentage, leading scorer, and the number of goals scored by that scorer.
* The champion of the league, that being the team with the highest winning percentage.
* The MVP of the league, that being the player who scored the most goals.
* For fun, print out their talent level, too — due to a relatively short season, it’s possible that a middling player could happen to have an MVP-caliber year!

## Extra
Check out the file called `leagueCreator.py` in the `ExtraFiles.zip` on Moodle for today. 
In this file, Prof James Ryan has written code that will allow you to procedurally generate players, teams, and a league! 
Make sure to place all of the extra files in your lab folder.

Add a new file called `simulate.py`. 

In this file, write code that will do the following:

* Instantiate a `BroomballLeague` object by calling the `createLeague()` function defined in `leagueCreator.py`. This will require you to import the function into `simulate.py`.
* Simulate a season in that league by calling its `simulateSeason()` method.
* Print out the results of the season by calling its `results()` method.
