"""
   loops.py
   Jeff Ondich, 2013-01-05
   Anna Rafferty

   Modified by Tanya Amert for Spring 2025

   Demonstrates a few simple loops.
   
   Intended as the Python half of parallel examples in Python and
   Kotlin. See Loops.kt.
"""

print("Counting up with a while loop")
k = 0
while k < 5:
    print(k)
    k += 1

print("Counting up with a for/in loop")
for k in range(5):
    print(k)

print("Counting evens with a for/in loop")
for k in range(0, 5, 2):
    print(k)

print("Counting down with a for/in loop")
for k in range(5, 0, -1):
    print(k)