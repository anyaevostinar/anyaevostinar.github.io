from Observer import *
from Subject import *

if __name__ == "__main__":
    subject = Subject()
    subject2 = Subject()
    observer1 = Observer()
    subject.attach(observer1)
    subject2.attach(observer1)
    observer2 = Observer()
    subject.attach(observer2)

    for i in range(3):
        print("----------")
        subject.increment()
        subject2.increment()
    
    print("Done")