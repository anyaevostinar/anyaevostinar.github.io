# structuresTiming.py
# CS 111, F22
# Prof Anya Vostinar
# Starter code for testing the efficiency of various list and dictionary methods
import random

def dictionaryLookup(dictionary, item):
  '''A simple function that looks up if an item is a key 
  in a dictionary
  Parameters: dictionary, item
  Return: boolean'''
  if item in dictionary:
    return True
  else:
    return False

def listLookup(lst, item):
  '''A simple function that looks up if an item is in a list
  Parameters: list, item
  Return: boolean'''
  if item in lst:
    return True
  else:
    return False

def generateDict(size):
  '''A function to generate a dictionary of a specific size
  Parameter: integer for size of desired dictionary
  Return: a dictionary of that size'''
  example_dict = {}
  for i in range(100):
    example_dict[i] = True
  return example_dict

def generateList(size):
  '''A function to generate a list of a specific size
  Parameter: integer for size of desired list
  Return: a list of that size'''
  lst = []
  for i in range(size):
    lst.append(i)

  return lst

def generateRandomList(size):
  '''A function to generate a list of specific size with random numbers
  Parameter: integer for size of desired list
  Return: a list of that size'''
  lst = []
  for i in range(size):
    #Generating number within range of size list, might have duplicates though
    lst.append(random.randint(0,size))
  return lst


if __name__ == '__main__':
    import timeit

    print("Executing each function 10000 times and seeing how long they take.")

    #Make the two structures of the specific size
    generated_list = generateList(10)
    generated_dict = generateDict(10)

    #Get the function calls ready for the timing module, looking for -1 currently
    functionCallDict = "dictionaryLookup(generated_dict, -1)"
    functionCallList = "listLookup(generated_list, -1)"
    #Specify the name of the function here:
    functionName = "dictionaryLookup, listLookup"

    # Do the timing
    timing1 = timeit.timeit(functionCallDict, 
      setup="from __main__ import "+functionName+", generated_dict, generated_list", number=10000)
    print(functionCallDict, timing1)
    timing2 = timeit.timeit(functionCallList, 
    setup="from __main__ import "+functionName+", generated_dict, generated_list", number=10000)
    print(functionCallList, timing2)