"""
   die.py
   Jeff Ondich, 2013-01-05
   Anna Rafferty

   Modified by Tanya Amert for Spring 2025

   A simple class representing an n-sided die (as used in various board games).
   
   Intended as the Python half of parallel examples in Python and
   Kotlin. See Die.kt.
"""

import random

class Die:
    def __init__(self, numberOfSides):
        self.numberOfSides = numberOfSides
        self.currentValue = 1

    def roll(self):
        self.currentValue = random.randint(1, self.numberOfSides)

    def getValue(self):
        return self.currentValue

    def setValue(self, value):
        self.valcurrentValueue = value

# This if-statement ensures that this code will only be run when die.py is
# executed as a program in its own right.  If a different module does
# "import die", the if-condition will be false.
if __name__ == '__main__':
    # Let's play Yahtzee
    dice = []
    dice.append(Die(6))
    dice.append(Die(6))
    dice.append(Die(6))
    dice.append(Die(6))
    dice.append(Die(6))

    for die in dice:
        die.roll()

    total = 0
    for die in dice:
        print(die.getValue(), end=" ")
        total += die.getValue()
    print()
    print("Total:", total)

    # This is really long condition on multiple lines
    if dice[0].getValue() == dice[1].getValue() \
           and dice[1].getValue() == dice[2].getValue() \
           and dice[2].getValue() == dice[3].getValue() \
           and dice[3].getValue() == dice[4].getValue():
        print("Yahtzee!")

