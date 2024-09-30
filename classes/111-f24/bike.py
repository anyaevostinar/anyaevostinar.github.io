# bike.py
# Original author: David Liben-Nowell 
# Updated style and added file support: Anya Vostinar
# CS 111
# usage: python3 bike.py <optional: filename>
import sys

# Get the filename from the command line if there is one
if len(sys.argv)>1:
    filename = sys.argv[1] 
else:
    filename = "2021-august.csv"

try: 
    file = open(filename)
except IOError:
    print("ERROR!",  filename, "doesn't appear the current directory.")
    print("Please see the problem set instructions.")
    exit(1)

net_change_at_kennedy = 0
longest_ride_duration = 0 
num_rides = 0

for line in file:
    num_rides = num_rides + 1

    # Divide this line of the file into the above fields; we'll only care about
    # a few of them so we'll ignore the others.
    fields = line.split(",")
    duration, start_station, end_station = fields[0], fields[2], fields[5]

    # We'll convert the duration (stored as hours:minutes:seconds) to seconds.
    times = duration.split(":")   
    hours, minutes, seconds = 0, 0, 0 # YOU FILL THIS IN!
    duration_in_seconds = 0 # YOU FILL THIS IN!

    if duration_in_seconds > longest_ride_duration:
        longest_ride_duration = duration_in_seconds
    
    # YOU FIX THESE CONDITIONS:
    if "this ride left one bike at station 'Kennedy Center'":
        net_change_at_kennedy = net_change_at_kennedy + 1
    if "this ride took one bike away from station 'Kennedy Center'":
        net_change_at_kennedy = net_change_at_kennedy - 1

file.close()

print("There were", num_rides, "total rides.")

if net_change_at_kennedy > 0:
    print("There are now",
          net_change_at_kennedy,
          "more bikes at Kennedy Center than when we started.")
elif net_change_at_kennedy < 0:
    print("There are now ??? fewer bikes at Kennedy Center", # FIX THIS!
          "than when we started.")
else:
    print("There was no net change in the number of bikes at Kennedy Center.")

print("The longest ride lasted", longest_ride_duration, "seconds.")
print("That's about", int(longest_ride_duration / (60 * 60) ), "hours.")

print("The longest ride that departed from the Kennedy Center \
      lasted ??? seconds or about ??? hours.") # FIX THIS
print("The mean docked-bike ride lasted X minutes.") # FIX THIS