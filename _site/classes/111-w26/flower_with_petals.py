from graphics import *

win = GraphWin("My fancy window", 400, 400)
win.setCoords(0, 0, 100, 100) # Make the coordinates more intuitive
center_x = 50
height = 20
flower_center = Point(center_x, height)
stem = Rectangle(Point(center_x+2.5, height), Point(center_x-2.5, 0))

stem.setFill("green")
stem.draw(win)

petal_radius = 5.5

petal1 = Circle(flower_center, petal_radius) #start the petal at the center
petal1.move(-2, -2) #move it down and left by 2
petal1.setFill("purple")
petal1.draw(win)

petal2 = Circle(flower_center, petal_radius) #start the petal at the center
petal2.move(2, -2) #move it up and left by 2
petal2.setFill("purple")
petal2.draw(win)

petal3 = Circle(flower_center, petal_radius)
petal3.move(-2, 2) #move it down and right by 2
petal3.setFill("purple")
petal3.draw(win)

petal4 = Circle(flower_center, petal_radius)
petal4.move(2, 2) #move it up and right by 2
petal4.setFill("purple")
petal4.draw(win)

center = Circle(flower_center, 3.5)
center.setFill("yellow")
center.draw(win)

win.getMouse()