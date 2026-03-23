"""
   conditionals.py
   Jeff Ondich, 2013-01-03
   Anna Rafferty

   Modified by Tanya Amert for Spring 2025

   A tiny illustration of if-statements and console input.

   Intended as the Python half of parallel examples in Python and
   Kotlin. See Conditionals.kt.
"""

# Get the number from the user
numberString = input("Number, please: ")
number = int(numberString)

# Print a message based on the number
if number > 100:
    print(f"Gosh, {number} is a big number")
elif number == 3:
    print("3 is my lucky number")
elif number >= 0:
    print(f"{number} is pretty little")
else:
    print(f"{number} is negative")