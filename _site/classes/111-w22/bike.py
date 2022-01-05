# bike.py
# David Liben-Nowell and Anya Vostinar, CS 111
# usage: python3 bike.py <optional: filename>
import sys

# Get the filename from the command line if there is one
if(len(sys.argv)>1):
    filename = sys.argv[1] 
else:
    filename = "2021-august.csv"

try: 
    file = open(filename)
except IOError:
    print("ERROR!",  filename, "doesn't appear the current directory.")
    print("Please see the problem set instructions.")
    exit(1)

netChangeAtKennedy = 0
longestRideDuration = 0 
numRides = 0

for line in file:
    numRides = numRides + 1

    # Divide this line of the file into the above fields; we'll only care about
    # a few of them so we'll ignore the others.
    fields = line.split(",")
    duration, startStation, endStation = fields[0], fields[2], fields[5]

    # We'll convert the duration (stored as hours:minutes:seconds) to seconds.
    times = duration.split(":")   
    hours, minutes, seconds = 0, 0, 0 # YOU FILL THIS IN!
    durationInSeconds = 0 # YOU FILL THIS IN!

    if durationInSeconds > longestRideDuration:
        longestRideDuration = durationInSeconds
    
    # YOU FIX THESE CONDITIONS:
    if "this ride left one bike at station 'Kennedy Center'":
        netChangeAtKennedy = netChangeAtKennedy + 1
    if "this ride took one bike away from station 'Kennedy Center'":
        netChangeAtKennedy = netChangeAtKennedy - 1

file.close()

print("There were", numRides, "total rides.")

if netChangeAtKennedy > 0:
    print("There are now",
          netChangeAtKennedy,
          "more bikes at Kennedy Center than when we started.")
elif netChangeAtKennedy < 0:
    print("There are now ??? fewer bikes at Kennedy Center", # FIX THIS!
          "than when we started.")
else:
    print("There was no net change in the number of bikes at Kennedy Center.")

print("The longest ride lasted", longestRideDuration, "seconds.")
print("That's about", int(longestRideDuration / (60 * 60) ), "hours.")

print("The longest ride that departed from the Kennedy Center lasted ??? seconds or about ??? hours.") # FIX THIS
print("The mean docked-bike ride lasted X minutes.") # FIX THIS
