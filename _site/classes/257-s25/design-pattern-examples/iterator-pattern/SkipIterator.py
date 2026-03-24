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
