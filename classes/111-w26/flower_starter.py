'''
flower_starter.py
Author: Anya Vostinar
Date: Winter '26
Purpose: A starter program that draws flowers using graphics.py with functions
'''

from graphics import *
import random

def draw_stem(window, x, height):
    '''
    Purpose: Draws the stem of a flower
    @param: GraphWin, the window to draw the stem in
    @param: number (float or int), the x coordinate for the flower
    @param: number (float or int), the height of the stem
    @return: Rectangle, the newly drawn stem
    '''
    stem = Rectangle(Point(x + 2.5, height),
                Point(x-2.5, 0))
    stem.setFill("green")
    stem.draw(window)
    return stem

def draw_flower(window, x, height, color):
    '''
    Purpose: Draws the actual flower of a flowering plant
    @param: GraphWin, the window to draw in
    @param: number, the x coordinate for the flower
    @param: number, the height of the flower
    @return: Circle, the newly drawn flower
    '''
    center = Point(x, height)
    center_circle = Circle(center, 6)
    center_circle.setFill(color)
    center_circle.draw(window)
    return center_circle

if __name__=='__main__':
    # Create the window
    win = GraphWin("Field of Flowers", 600, 600)
    win.setCoords(0, 0, 100, 100) # Make the coordinates more intuitive
    win.setBackground("white")
    colors = ["red", "purple", "pink", "blue", "yellow"]

    my_flowers = [] #A list of flower part sublists

    #Draw five flowers where the user clicks
    for i in range(5):
        #Instruct the user to click
        instructions = Text(Point(50, 75), "Click to place a flower")
        instructions.draw(win)
        new_x = win.getMouse().getX()
        instructions.undraw()

        #Have flowers of different colors
        new_color = random.choice(colors)
        colors.remove(new_color)

        #Draw the flower and save its parts to a list
        new_flower_parts = []
        new_flower_parts.append(draw_stem(win, new_x, 20))
        new_flower_parts.append(draw_flower(win, new_x, 20, new_color))

        my_flowers.append(new_flower_parts)

    win.getMouse()