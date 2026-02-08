from graphics import *
import random
import time

class Flower:

    def __init__(self, window, x, color):
        self.window = window
        self.x = x
        self.color = color
        self.height = 20
        self.stem = None
        self.draw_stem()
        self.draw_flower()

    def draw_stem(self):
        '''
        Purpose: Draws the stem of a flower
        @param: GraphWin, the window to draw the stem in
        @param: number (float or int), the x coordinate for the flower
        @param: number (float or int), the height of the stem
        '''
        if self.stem:
            self.stem.undraw()
        self.stem = Rectangle(Point(self.x + 2.5, self.height),
                    Point(self.x-2.5, 0))
        self.stem.setFill("green")
        self.stem.draw(self.window)

    def draw_flower(self):
        '''
        Purpose: Draws the actual flower of a flowering plant
        @param: GraphWin, the window to draw in
        @param: number, the x coordinate for the flower
        @param: number, the height of the flower
        '''
        self.center = Point(self.x, self.height)
        self.center_circle = Circle(self.center, 6)
        self.center_circle.setFill(self.color)
        self.center_circle.draw(self.window)



if __name__=='__main__':
    # Create the window
    win = GraphWin("Field of Flowers", 600, 600)
    win.setCoords(0, 0, 100, 100) # Make the coordinates more intuitive
    win.setBackground("white")
    colors = ["red", "purple", "pink", "blue", "yellow"]

    my_flowers = [] #A list of flowers

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

        new_flower = Flower(win, new_x, new_color)

        my_flowers.append(new_flower)

    win.getMouse()