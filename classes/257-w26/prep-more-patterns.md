---
layout: page
title: Specific Patterns Prep
permalink: /classes/257-w26/more-patterns-prep
---

## Overview
There are four design patterns that you've likely used and will find useful, so we're going to focus on those today.

## Basic Learning Objectives
Before class, you should be able to:
* Define what the Observer, Iterator, Decorator, and State design patterns are

## Advanced Learning Objectives
After class, you should be able to:
* Implement these four patterns in Python
* Explain how code smells, class design principles, and design patterns reinforce each other or possibly conflict

## Readings
To achieve the basic learning objectives, read the following:
* [Observer Design Pattern](https://refactoring.guru/design-patterns/observer) - skip the pseudocode, look at the [Python](https://refactoring.guru/design-patterns/observer/python/example) example if you want
* [Iterator Design Pattern](https://refactoring.guru/design-patterns/iterator) - ditto, [Python](https://refactoring.guru/design-patterns/iterator/python/example) example
* [Decorator Design Pattern](https://refactoring.guru/design-patterns/decorator) - ditto, [Python](https://refactoring.guru/design-patterns/decorator/python/example) example
* [State Design Pattern](https://refactoring.guru/design-patterns/state) - ditto, [Python](https://refactoring.guru/design-patterns/state/python/example)

## Checks
Submit answers to the following on Moodle. Given the following code snippets that should be refactored, which pattern do you think they need and why? (Note, the TODOs are hints, not things that you should do.)

1. ```python
    class WeatherStation:
        def __init__(self):
            self.temp = 0
            self.phone_app = PhoneApp()
            self.window_display = WindowDisplay()
            #TODO: Add the rest of the displays

        def set_temperature(self, temp):
            self.temp = temp
            self.phone_app.update(temp)
            self.window_display.update(temp)
            #TODO: Add the rest of the displays
    ```

2. ```python
    class BookShelf:
        '''Must store books as a dictionary of lists grouped by genre'''
        def __init__(self):
            self.books_by_genre = {"Sci-Fi": ["Dune"], "Tech": ["Clean Code"]}
            #TODO: add the rest of the books from the library

    #Client code below
    shelf = BookShelf()
    for genre in shelf.books_by_genre:
        for book in shelf.books_by_genre[genre]:
            print(book)
    ```
3. ```python
    class SimpleCoffee:
    def get_cost(self): return 2.0

    class CoffeeWithMilk(SimpleCoffee):
        def get_cost(self): return 2.5

    class CoffeeWithMilkAndSugar(CoffeeWithMilk):
        def get_cost(self): return 2.7
    
    #TODO: Add the rest of the extra option subclasses along with all combos
    ```
4. ```python
    class VendingMachine:
        def __init__(self, count):
            self.count = count
            self.state = "NO_QUARTER" if count > 0 else "OUT_OF_STOCK"

        def insert_quarter(self):
            if self.state == "HAS_QUARTER":
                print("You can't insert another quarter.")
            elif self.state == "NO_QUARTER":
                self.state = "HAS_QUARTER"
                print("Quarter inserted.")
            elif self.state == "OUT_OF_STOCK":
                print("Machine is out of stock.")
            elif self.state == "SOLD":
                print("Please wait, we're already giving you a soda.")
            #TODO: Add those additional states the customer was asking about

        def turn_crank(self):
            if self.state == "HAS_QUARTER":
                print("You turned...")
                self.state = "SOLD"
                self.dispense()
            elif self.state == "NO_QUARTER":
                print("You turned, but there's no quarter.")
            #TODO: add the rest of the states, my fingers are tired...
    ```