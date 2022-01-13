---
layout: page
title: Lists and While Loops 
permalink: /classes/111-w22/lists-while
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.
You may find the [Python documentation on list methods](https://docs.python.org/3/tutorial/datastructures.html) helpful today.


## Exercise 1
For each snippet, what would it print out to the screen? If you think there will be an error, indicate the line with the error and explain why.
After you've made a prediction, test out the code.

```
words = ['limitless', 'knowledge', 'provoking', 'quadruple', 'happiness']
i = 0
for word in words:
    print(word[i], end='')
    i = i + 2

print(' ', end='')
```

```
j = -1
for k in range(3, 0, -1):
    print(words[k][j], end='')
    j = j - 1

print()
```

```
x = 15
while True:
  x = x + 2
  print(x)
```

## Exercise 2
Consider the following code (with blanks that you will fill in):

```
ranks = ['Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten', 'Jack', 'Queen', 'King', 'Ace']
suits = ['Clubs', 'Diamonds', 'Hearts', 'Spades']
deck = []

for _________________:
    for _________________:
        #f"{x}" is another way of doing the format function
        deck.append(f"{rank} of {suit}")

for card in deck:
    print(card)
```

a. Fill in the blanks above such that the cards are printed out increasing by number (e.g., all of the twos, then all of the threes, then all of the fours, etc.) as below:

```
Two of Clubs
Two of Diamonds
Two of Hearts
Two of Spades
Three of Clubs
...
King of Spades
Ace of Clubs
Ace of Diamonds
Ace of Hearts
Ace of Spades
```

b. Fill in the blanks such that the cards are printed out by suit (i.e., all of the clubs, then all of the diamonds, then all of the hearts, then all of the spades), as below:

```
Two of Clubs
Three of Clubs
Four of Clubs
...
Ace of Clubs
Two of Diamonds
Three of Diamonds
...
King of Spades
Ace of Spades
```

## Exercise 3
Write the following as an indefinite (while) loop:
```
for i in range(10, 2, -1):
  x = 2*i + 3
  print(x)
```

## Exercise 4
a. I want to print out the first 20 powers of 5 (e.g., 1, 5, 25, 125...). Write both a for loop and a while loop that will do so.

b. Change them both to save the numbers in two separate lists instead and then compare the lists to make sure that they have the same values. Print out whether the two lists have the same values (should be true obviously, but how do you check to make sure that it works if it wasn't true?).

## Exercise 5
Consider the following code:
```
i = 2
while i < 100:
  j = 2
  count = 0

  while j < i:
    if i % j == 0:
      count = count + 1
    j = j + 1

  if count == 0:
    print(i)

  i = i + 1
```

a. What task does this code accomplish?

b. Write a set of nested for loops to accomplish the same task.

## Extra
The code for making these plots:

![Two heat maps showing Host Interaction Value and Symbiont Interaction Value](https://raw.githubusercontent.com/anyaevostinar/Dirty-Transmission-Hypothesis-Paper/main/Analysis/HeatMaps/ComparisonRegions.png)

is simple enough (though a bit messy) that you now know almost everything you need to to be able to make your own or change mine. 
All of my research code is *open-source* meaning it is freely available for anyone to see, use, and build on.
The code for that plot is [here](https://github.com/anyaevostinar/Dirty-Transmission-Hypothesis-Paper/blob/main/Analysis/HeatMaps/fitnessHeatmap.py). 
If you have extra time, copy and paste it (yes this time it's okay!) into a new VSCode document and try running it (it will take a minute or two the first time).
Then look through it and try changing things to see what happens.
Note that the labels won't show up when you make the plot, I've put those in after the fact so that you can see what is going on better.

The main thing you won't fully understand are the lines for drawing the plots:
```
hm = sns.heatmap(data = sym_repro, xticklabels = sym_int_vals, yticklabels = host_int_vals)

# displaying the plotted heatmap
plt.show()
```

`data = sym_repro` is setting what data the plot should show and you can change `sym_repro` to `host_res`, `sym_res` or `host_repro`. Otherwise you probably shouldn't change those lines.