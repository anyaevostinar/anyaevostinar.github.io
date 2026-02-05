from graphics import *
import random
import time

class Flower:

    def __init__(self, window, x, color):
        self.window = window
        self.x = x
        self.color = color
        self.height = 1
        self.age = 0
        self.petals = []
        self.stem = None
        self.draw_stem()

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
        self.center_circle = Circle(self.center, 3.5)
        self.center_circle.setFill(self.color)
        self.center_circle.draw(self.window)


    def move_flower(self):
        self.center_circle.move(0, 5)
        for petal in self.petals:
            petal.move(0, 5)
            self.refresh(petal)
        self.refresh(self.center_circle)

    def refresh(self, item):
        item.undraw()
        item.draw(self.window)

    def undraw(self):
        self.stem.undraw()
        self.center_circle.undraw()
        for petal in self.petals:
            petal.undraw()

    def grow(self):
        if self.age < 12:
            self.height += 5
            self.draw_stem()
            if self.age == 4:
                self.draw_flower()
            elif self.age > 4:
                self.move_flower()
        elif self.age == 14:
            self.undraw()
        self.age += 1

def check_new_flower(cur_flowers):
    colors = ["red", "purple", "pink", "blue"]
    user_click = win.checkMouse() #checks for mouse click but doesn't wait
    if user_click:
        new_x = user_click.getX()
        new_color = random.choice(colors)
        new_flower = Flower(win, new_x, new_color)
        cur_flowers.append(new_flower)

    
if __name__=='__main__':
    # Create the window
    win = GraphWin("Field of Flowers", 600, 600)
    win.setCoords(0, 0, 100, 100) # Make the coordinates more intuitive
    win.setBackground("white")

    my_flowers = [] #A list of flower part sublists

    #Instruct the user to click
    instructions = Text(Point(50, 75), "Click to place a flower")
    instructions.draw(win)

    while True:
        check_new_flower(my_flowers)
        time.sleep(0.5)
        for flower in my_flowers:
            flower.grow()
        
