---
layout: page
title: Debugging Lab 
permalink: /classes/111-w26/lab-debugging
---

This is a lab assignment, so it isn't required to complete.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class. If you do finish it and submit it to Moodle, you'll earn an extra engagement credit.

I recommend creating a folder in COURSES for this lab as you usually do.

## Exercise 1
Debugging poorly written and buggy code is a valuable skill.
To help you practice it, I've written a painfully bad program called `bad.py` (or is it??) that attempts to convert Celsius temperature to Fahrenheit.
That calculation should be `(C * 9/5) + 32` where `C` is the value in Celsius.
Download [this code](/classes/111-w24/bad-1.py), move it to your folder for today, and open it in VSCode.

This code is both badly styled, making it very difficult to read, and has a bug or two.
You should aim to improve it, which will probably involve:
* Drawing out a memory reference diagram of what is going on with each of the variables
* Fixing variable names
* Getting it to output something
* Fixing a logical bug
* Making the variable names useful and rearranging things
* Writing comments and documentation

## Exercise 2
Here is a another buggy program. 

Scenario: You are going shopping for meat and milk, but there is tax. You buy $2.00 of milk and $4.00 of meat, and the tax rate is 3%. Print out the total cost of your groceries (you don't need to print the dollar sign).

Steps:
* First, work out with a calculator what the price should be for $6 of food and

```python
meatPrice = 4.00
meatTax = 0.03 * meatPrice
milkPrice = 2.00
milkTax = 0.03 * milkPrice
print(meatTax + meatPrice + milkTax + meatPrice)
```

*Source: https://cscircles.cemc.uwaterloo.ca/1e-errors/ *