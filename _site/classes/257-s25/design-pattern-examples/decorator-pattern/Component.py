from Decorators import *

class Component():

    def operation(self):
        return "Component"


def client_code(component):
    print("Result:", component.operation())

if __name__ == "__main__":
    simple = Component()
    client_code(simple)

    decorator1 = DecoratorA(simple)
    decorator2 = DecoratorB(decorator1)
    client_code(decorator2)