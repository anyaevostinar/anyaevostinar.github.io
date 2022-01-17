---
layout: page
title: Binary and For-Loops Lab 
permalink: /classes/111-w22/binary-for
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.
The lab is purposefully longer than what I think you can finish in class so that you have plenty of opportunity for additional practice.

I recommend making a folder for today's lab in COURSES as you usually do.

## Exercise 1
For each snippet, what would it print out to the screen? If you think there will be an error, indicate the line with the error and explain why.
After you've made a prediction, test out the code.

``` 
for i in range(10):  
  if i % 2 == 0:  
    print(i, 'is even')  
  if i % 3 == 1:  
    print(i, 'is special')
```


```
for i in range(5, 0, -1):
    print(i)
```

```
for i in range(0):
    print("hi")
```

## Exercise 2
1. Write out the first 20 integers in binary. Watch the patterns of bits flipping -- this will become more and more familiar the more CS classes you take.

2. Perform the following computations:

    * Convert 111001<sub>2</sub> to base-10 (decimal)
    * Convert 1110001<sub>2</sub> to base-10 (decimal)
    * Convert 1112<sub>10</sub> to base-2 (binary)
    * Convert 324<sub>10</sub> to base-2 (binary)

3. Add the two number 11101010<sub>2</sub> and 10011001<sub>2</sub> together *(staying in binary)*. Check your answer in decimal. 

## Exercise 3

For the following, try using the `format` string method to output the information after you've calculated it:
```
print("some info: {} some more info: {}".format(info_one, info_two))
```

1. Write a snippet of code to count the number of vowels (“aeiouy”) in a given string. You can assume the string is all lowercase.

2. Write a snippet of code to compute the *factorial* of a positive integer given by the user. The factorial of a positive integer is the product of all of the numbers from 1 up to that integer. For example, 4 factorial (written “4!”) is equal to 1 * 2 * 3 * 4 = 24.


## Exercise 4
You can also nest loops inside of each other!
Think about what the output of each of these snippets will be and then test them.

```
# Snippet 1

n = 4
m = 3
for i in range(n):
  for j in range(m):
    print('*', end='')
  print()


# Snippet 2

n = 4
for i in range(n):
    for j in range(i+1):
        print('*', end='')
    print()


# Snippet 3

n = 4
for i in range(n):
    for j in range(i):
        print('-', end='')
    for j in range(i, n+i):
        print(j, end='')
    print()


# Snippet 4

n = 4
for i in range(0,n):
    for j in range(0,n-i-1):
        print(' ', end='')
    for j in range(n-i-1,n):
        print('*', end='')
    print()


# Snippet 5

n = 4
for i in range(0,n):
    for j in range(0,n-i-1):
        print(' ', end='')
    for j in range(n-i-1,n+i):
        print('*', end='')
    print()


# Snippet 6

n = 4
for i in range(n):
    for j in range(0,-1*n,-1):
        for k in range(2):
            print(j*k, end='*')
        print(i, end=' ')
    print()
```

## Exercise 5

1. Write a nested for-loop that creates the following output:
```
0 x 0 = 0   0 x 1 = 0   0 x 2 = 0   0 x 3 = 0
1 x 0 = 0   1 x 1 = 1   1 x 2 = 2   1 x 3 = 3
2 x 0 = 0   2 x 1 = 2   2 x 2 = 4   2 x 3 = 6
3 x 0 = 0   3 x 1 = 3   3 x 2 = 6   3 x 3 = 9
```


## Extra
If you have extra time, try these:

* Convert 221<sub>**3**</sub> to base-10 (decimal)
* Convert 242<sub>10</sub> to base-16 (hexadecimal, which uses the characters A-F for the extra digits)
* What is the biggest integer that you can store with:
    * 8 bits?
    * 32 bits?
    * 64 bits?
* Write a generalized algorithm for adding in any base.
* Take the 6-digit binary number 101010. What happens when you subtract it from 2<sup>6</sup>? See anything interesting about the relationship between these two numbers? Can you explain and generalize the pattern? (If you take 208, you'll learn about something called "two's complement", which is how negative integers are often stored.)

## Acknowledgements
This lab is based on labs from Profs. Eric Alexander and James Ryan.