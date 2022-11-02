import turtle


def lineIter(branch_len, t):
    num_branches = int(branch_len/30)
    for i in range(num_branches-1):
        t.forward(branch_len)
        t.right(20)
        branch_len = branch_len-30

    

def tree(branch_len, t):
    if branch_len > 30:
        t.forward(branch_len)
        t.right(20)
        tree(branch_len - 30, t)
        t.left(40)
        tree(branch_len - 30, t)
        t.right(20)
        t.backward(branch_len)

def main():
    t = turtle.Turtle()
    my_win = turtle.Screen()
    t.left(90)
    t.up()
    t.backward(100)
    t.down()
    t.color("green")
    tree(120, t)
    t2 = turtle.Turtle()
    t2.up()
    t2.forward(10)
    t2.left(90)
    t2.backward(100)
    t2.down()
    t2.color("blue")
    lineIter(120, t2)
    my_win.exitonclick()

main()