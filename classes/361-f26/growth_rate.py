'''
10/30/26
Anya Vostinar
A simple script to take a file of "update,count" and 
calculate the growth rate of the species recorded.
'''

import os.path
import numpy as np
import math


inputFileName = "data.csv"
world_size = 100


inputFile = open(inputFileName, 'r')

x_vals = []
y_vals = []

for line in inputFile:
    if (line[0] != "u"):
        splitline = line.strip().split(',')
        
        x_vals.append(int(splitline[0]))
        
        y_proportion = float(splitline[1])/world_size
        y_vals.append(math.log(y_proportion)) #defaults to natural log amusingly

slope, intercept = np.polyfit(x_vals, y_vals, 1)


print("Slope, i.e. growth rate: " , slope)


