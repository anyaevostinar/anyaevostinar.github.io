class Subject:
    def __init__(self):
        self.observers = []
        self.state = 0

    def attach(self, observer):
        self.observers.append(observer)

    def notify(self):
        for observer in self.observers:
            observer.update(self)

    def stateChanged(self):
        print("Subject: I'm doing something!")
        self.notify()

    def increment(self):
        self.state += 1
        self.stateChanged()