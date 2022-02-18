---
layout: page
title: More Classes Lab
permalink: /classes/111-w22/more-classes
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.
I also recommend opening the [readings](https://runestone.academy/ns/books/published/thinkcspy/ClassesBasics/ConvertinganObjecttoaString.html) [for today](https://runestone.academy/ns/books/published/thinkcspy/ClassesDiggingDeeper/toctree.html) for reference

## Exercise 0
In this lab, you are going to implement a couple of classes to represent playing cards. This class (which we'll call `Card`) will have two instance variables:

* A suit (represented by one of the letters: 'S', 'H', 'D', 'C')
* A value (represented by an `int` from 1 to 13)

Note: For the purposes of data storage, we will represent an Ace as 1, a Jack as 11, a Queen as 12, and a King as 13.

Our `Card` class will start relatively simple, but we'll add to it to make it more interesting!

First, let's make an initial version of the `Card` class. Make a new file `card.py`, and enter the following:

```
class Card:
    ''' A class for representing a single playing card. '''

    def __init__(self, value, suit):
        ''' Creates Card object with given suit and value. '''
        self.value = value
        self.suit = suit
    
    def getSuit(self):
        ''' Returns the suit of the Card. '''
        return self.suit
        
    def getValue(self):
        ''' Returns the value of the Card. '''
        return self.value
        
    def __str__(self):
        ''' Return a string representation of the Card. '''
        return 'This is a card!'
        
    def getBlackjackValues(self):
        ''' Get a list of possible Blackjack values for the card. '''
        return []
```

A couple of these methods aren't implemented yet (`getBlackjackValues` and `__str__`), but make sure you understand what the other implemented methods are doing! 
In a `main()` function, write some brief code that creates some `Card`s and uses their "getter"/accessor methods to print out their data. 
Make sure it's doing what you expect.

### `__str__` Method
As you know from your reading, the `__str__` method is another "special" Python method like `__init__`. 
Whereas `__init__` tells Python how to *create* new objects of a particular class, `__str__` tells Python how to represent objects in *string form*. 
By default, when Python is told to print out an object, it will create a string indicating the object's type and its memory location, something like this:
```
<playingCards.Card object at 0x000002C22D85A160>
```

However, if we define a `__str__` method within our class definition, then we can change what gets printed out, or passed to the `str` function. 
Again in the `main` function or the interpreter, try creating a new card and printing it out, something like this:
```
>>> myCard = Card(3, 'H')
>>> print(myCard)
```
Did you get what you expected to see? Read the current code in the `__str__` method to see what's going on.

## Exercise 1
You're going to rewrite the `__str__` to be something more meaningful. 
Namely, you are going to have the method return a string giving the English description of the card, including both its value and its suit. This should allow us to get responses like this:
```
>>> print(Card(3, 'H'))
Three of Hearts
>>> print(Card(1, 'D'))
Ace of Diamonds
>>> print(Card(13, 'S'))
King of Spades
```

## Exercise 2
For the `getBlackjackValues` method, it helps to know some rules of Blackjack. 
In this game, each card is worth its number in value (e.g., a Nine is worth 9, a Two is worth 2, etc.). 
However, each of the royal cards (Jack, Queen, King) are worth 10. Finally, an Ace can be worth either 1 or 11 -- it is up to the player which they would like it to be.

Fill in code for the `getBlackjackValues` method such that it returns a list of all the possible values it could be worth in a game of Blackjack. For most cards, this list will just be one element, but for Aces, it will be two elements.

## Exercise 3
Next, try your hand at writing a new class called `Hand`. 
Your class should take a player's name as a parameter to its constructor and should contain a list of `Card` objects. 
Some methods that would be worth implementing include:

* `addCard(card)` Add a given `Card` object to the `Hand`.
* `removeCard(card)` Remove a given `Card` object from the `Hand`.
* `getPlayer()` Return the player's name.
* `getCards()` Return the list of `Card`s in the `Hand`.
* `__str__()` Returns a list of the `Card`s in string form, separated by commas. (This should call the `__str__` method for each `Card` in the `Hand`.)
* `getBlackjackScores()` This method should return a list of all the possible scores that the `Hand` could create in a game of Blackjack. This is tricky! Think about what your algorithm is going to be and develop it in pseudocode before launching right into programming!

You can create this class in the same file. Make sure to write tests for it as you go!

## Extra
If you still have time, start working on the additional classes that you would need to create a functional Blackjack game!