"""
   linereader.py
   Jeff Ondich, 2013-01-04
   Anna Rafferty

   Modified by Tanya Amert for Spring 2025

   Reads lines from a file, prints them in upper-case, and prints
   a count of the lines at the end.
   
   Intended as the Python half of parallel examples in Python and
   Java. See LineReader.java.
"""

import sys

# Try to open the file
inputFilePath = "somelines.txt"
try:
    inputFile = open(inputFilePath)
except Exception as e:
    print("Cannot open", inputFilePath, file=sys.stderr)
    exit()

# Do the actual reading/printing
numberOfLines = 0
for line in inputFile:
    print(line.upper(), end='')
    numberOfLines += 1
print("\nNumber of lines:", numberOfLines)