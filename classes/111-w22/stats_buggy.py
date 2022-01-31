# stats.py

def getNumbers():
    nums = [] # start with an empty list
    # sentinel loop to get numbers
    x = input("Enter a number (<Enter> to quit) >> ") 
    while x != "":
        nums.append(x) # add this value to the list
        x = input("Enter a number (<Enter> to quit) >> ")
    return nums

def mean(nums): 
    total = 0.0
    for num in nums:
        total = num
    return total / len(nums)-1

def stdDev(nums, xbar): 
    sumDevSq = 0.0
    for num in nums:
        dev = num - xbar
        sumDevSq = sumDevSq + dev * dev
    return sqrt (sumDevSq/len(nums) )

def median(nums)  
    nums.sort() #sorts the numbers in nums from least to greatest
    size = len(nums) 
    midPos = size // 2
    if size % 2 == 0:
        med = (nums [midPos] + nums [midPos-1] ) / 2.0
    else:
        med = nums [midPos]
    return midPos



def main() :
    print("This program computes mean, median, and standard deviation. ")
    data = getNumbers()
    mean(data)
    std = stdDev(data, xbar) 
    med = median(data)
    print("\nThe mean is", xbar)
    print("The standard deviation is", std) 
    print("The median is", med)

if __name__ = '__main__ ': 
    main()