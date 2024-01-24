---
layout: page
title: Analysis Lab
permalink: /classes/201-w24/analysis-activity
published: true
---

## Goals
To get a better understanding of how to calculate the efficiency of algorithms - developing both your ability to work through calculations mathematically and your intuitive sense of estimating big-O, as well as refreshing on the time complexity of some familiar algorithms.

## Setup
There is no coding for this lab. Instead you should get out paper and pencil to work out your solutions.

## Exercise 1
For each of the code snippets below answer the following: 

1) How many times is the output statement printed? Your answer should be in terms of n. 

2) How does the number of times the statement is **printed** grow with the size of n, in big-O notation? Write the tightest bound you can (e.g., if the statement is printed O(n) times, saying it's printed O(n<sup>500</sup>) times will not be considered correct here, even though it's technically accurate).

a.
```
for (int i=0; i < 2*n; i++) {
    for (int j=0; j < n; j++) {
        System.out.println(i + " " + j);
    }
}
```

b.
```
for (int i=0; i < n; i++) {
    for (int j=0; j < 5; j++) {
        System.out.println(i + " " + j);
    }
}
```

c.
```
for (int i=0; i < 7*n; i++) {
    System.out.println(i);
}               
for (int j=0; j < n; j++) {
    System.out.println(j);
}
```

## Exercise 2
Now we will use the definition of big-O to show the asymptotic order of an algorithm. Remember that these still aren't formal proofs, we're just aiming to find values of a C and an n<sub>0</sub> that work and demonstrate that they work (by showing the calculation). 

For this exercise, you will show that (1/5)n+30 is in O(n) by finding a C and an n<sub>0</sub> that demonstrates this property.

(If you already have a strategy for how to find a C and an n<sub>0</sub> that demonstrates this, you are welcome to use that and show the calculation that verifies your values. If you aren't sure how to find the values, walk through the parts of this exercise.)

a. A good starting place is to try n<sub>0</sub> = 1 and try to find a C that works. We want to find a C such that our function is less than or equal to C*n for all n greater than or equal to n<sub>0</sub> which we've started with as 1. Write down that mathematical expression.

<details><summary>Show solution</summary>
<p>
<img src="/classes/201-w21/analysis1.png">
For all n >= 1.
</p>
</details>
<br>

b. When solving for a specific variable, we always want to try to get that variable on one side of the inequality sign, so divide both sides by n.

<details><summary>Show solution</summary>
<p>
<img src="/classes/201-w21/analysis2.png">
</p>
</details>
<br>

c. We now need to figure out how to get n out of our expression. Because we are dealing with an inequality, we can change the value on one side as long as we are respecting the rules of the inequality. How can you change the expression so that you can eventually factor out n as long as n >= 1?

<details><summary>Show solution</summary>
<p>
Because this is an inequality that we are trying to show, you can increase what is on the smaller side because it will still prove that (1/5)n +30 <= Cn
<br>
<img src="/classes/201-w21/analysis3.png">
</p>
</details>
<br>

d. Now factor out n so that you are left with a value for C. 

<details><summary>Show solution</summary>
<p>
<br>
<img src="/classes/201-w21/analysis4.png">
        
</p>
</details>
<br>

e. Report your n<sub>0</sub> and C values that show that (1/5)n+30 is in O(n) by writing: "Thus if C = ?? and n<sub>0</sub> = ??, then Cn >= (1/5)n+30 for all n>=n<sub>0</sub>, so by the definition of big-O, (1/5)n+30 is in O(n)."

<details><summary>Show solution</summary>
<p>
<img src="/classes/201-w21/analysis5.png">
        
</p>
</details>
<br>

## Exercise 3
Now you'll follow the same steps as in Exercise 2 to show that 7n<sup>3</sup>+2<sup>n</sup> is O(2<sup>n</sup>).

a. Repeat steps a and b from Exercise 2 for the new expression (you won't be dividing by n this time).

b. We want to do something similar to 2c to deal with the n<sup>3</sup> term. However we have to respect the inequality and substitute something larger. Is 2<sup>n</sup> larger than n<sup>3</sup> when n is 1? What about when n is 2? 

c. Even though the expressions are equal when n is 1, we need to respect the inequality for all n larger than n<sub>0</sub> so you should always check a couple of larger values when doing substitutions. We have to change our n<sub>0</sub> so that we can make the substitution. Try out larger values of n until you find one where for it and all values larger than it, 2<sup>n</sup> is larger than n<sup>3</sup>. You could use software to plot both functions and find where they intersect, but for this exercise, you can probably just try a few values.

Here is a plot to give you a hint:
<iframe src="https://www.desmos.com/calculator/v2dmt3orun?embed" width="500" height="500" style="border: 1px solid #ccc" frameborder=0></iframe>

d. With our new n<sub>0</sub>, we know that 2<sup>n</sup> will always be larger than n<sup>3</sup> and so can make the substitution in our expression. 

e. Simplify your expression until you have a value for C and report your values the same as in 2e.

## Exercise 4
The same as in Exercises 2 and 3, show that 8n<sup>2</sup> + 3n is in O(n<sup>3</sup>) (not a typo!). 

## Exercise 5
The following two programs are two different ways of searching for an item in a sorted list:

```java
public class SequentialSearchExample {

    public static boolean sequentialSearch(int[] list, int item) {
        int index = 0;
        while (index < list.length) {
            if (list[index] == item) {
                return true;
            }
            index = index + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] testList = {1, 2, 32, 8, 17, 19, 42, 13, 0};

        System.out.println("Search for 3 returns " +
            sequentialSearch(testList, 3));
        System.out.println("Search for 13 returns " +
            sequentialSearch(testList, 13));
    }
}
```

```java
public class BinarySearchExample {

    public static boolean binarySearch(int[] list, int item) {
        int first = 0;
        int last = list.length - 1;
        while (first <= last) {
            int midpoint = (first + last) / 2;
            if (list[midpoint] == item) {
                return true;
            } else if (list[midpoint] < item) {
                last = midpoint - 1;
            } else {
                first = midpoint + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] testList = {0, 1, 2, 8, 13, 17, 19, 32, 42};

        System.out.println("Binary search for 3 returns " +
            binarySearch(testList, 3));
        System.out.println("Binary search for 13 returns " +
            binarySearch(testList, 13));
    }
}
```

Analyze the time complexity of each (you'll have to think about how many times the while loop in Binary Search will actually run). How does your analysis change if the list isn't already sorted?

## Extensions
* Find values of C and n<sub>0</sub> that demonstrate the big-O notation for the earlier exercises.
