class Decorator():
    def __init__(self, component):
        self.component = component

    def component(self):
        return self.component

    def operation(self):
        return self.component.operation()

class DecoratorA(Decorator):
    

    def operation(self):
        return "DecoratorA+" + self.component.operation()


class DecoratorB(Decorator):

    def operation(self):
        return "DecoratorB+" + self.component.operation()