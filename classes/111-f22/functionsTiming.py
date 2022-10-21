# functionsTiming.py
# F22 CS111
# A set of functions and code for timing them using the timeit module

def avgList(lst):
  ''' Return the mean of a list of integers. '''
  tot = 0
  for i in range(len(lst)):
    tot = tot + lst[i]
  return tot / len(lst)

def add(a, b):
  ''' Return the sum of two integers. '''
  tot = a + b
  return tot


def containsDuplicates(lst):
  ''' Return whether or not there are any duplicate values in given list. '''
  for i in range(len(lst)):
    for j in range(len(lst)):
      if i !=j and lst[i] == lst[j]:
        return True
  return False

def getMin1(lst):
  ''' Return the minimum element from given list of NON-NEGATIVE integers. '''
  if len(lst) == 1:
    return lst[0]
  else:
    minRest = getMin1(lst[1:])
    if minRest > lst[0]:
      return minRest
    else:
      return lst[0]

def getMin2(lst):
  ''' Return the minimum element from given list of NON-NEGATIVE integers. '''
  if len(lst) == 1:
    return lst[0]
  else:
    mid = len(lst) // 2
    minLeft = getMin2(lst[:mid])
    minRight = getMin2(lst[mid:])
    if minLeft < minRight:
      return minLeft
    else:
      return minRight

def fibInefficient(n):
    if n <= 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fibInefficient(n-1) + fibInefficient(n-2)
        
def fibEfficient(n):
    if n <= 0:
        return 0
    elif n == 1:
        return 1
    else:
        # Call a helper function that tracks the last two numbers
        # and indicates what number we're currently calculating
        # (here, the previous number is the first fib number, so
        # we'll be calculating the second one)
        return fibEfficientHelper(1, 0, 2, n) 

def fibEfficientHelper(prevNum, prevPrevNum, curLevel, target):
    if curLevel >= target:
        return prevNum + prevPrevNum
    else:
        newPrevNum = prevPrevNum + prevNum
        prevPrevNum = prevNum
        prevNum = newPrevNum
        return fibEfficientHelper(prevNum, prevPrevNum, curLevel + 1, target)

if __name__ == '__main__':
    import timeit

    print("Executing each function 10000 times and seeing how long they take.")

    #Specify what function call you would like to be timed below, note that
    #the calls are in strings (yes, it's weird)
    #For functions that take lists, you can use range to generate a list
    #   a list of the correct length
    functionCallSmall = "avgList(range(0,10))"
    functionCallLarge = "avgList(range(0,10000))"
    #Specify the name of the function here:
    functionName = "avgList"


    timing1 = timeit.timeit(functionCallSmall, 
      setup="from __main__ import "+functionName, number=10000)
    print(functionCallSmall, timing1)
    timing2 = timeit.timeit(functionCallLarge, 
    setup="from __main__ import "+functionName, number=10000)
    print(functionCallLarge, timing2)