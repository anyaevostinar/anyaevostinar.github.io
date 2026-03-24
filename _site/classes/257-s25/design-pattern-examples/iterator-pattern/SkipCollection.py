


class SkipCollection:

    class SkipIterator():

        def __init__(self, collection):
            self.collection = collection
            self.position = 0

        def __next__(self):
            try:
                value = self.collection[self.position]
                self.position += 2

                return value
            except IndexError:
                raise StopIteration()


    def __init__(self, collection=[]):
        self.collection = collection

    def __iter__(self):
        return self.SkipIterator(self.collection)

if __name__ == "__main__":
    test = SkipCollection([1, 2, 3, 4, 5, 6])
    for item in test:
        print(item)