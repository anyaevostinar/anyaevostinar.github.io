---
layout: page
title: Conditionals Preparation
permalink: /classes/111-w26/conditionals-prep
---

<script type="module" src="https://pyscript.net/releases/2025.11.2/core.js"></script>

## Overview
Frequently you want a program to do one thing in one situation and a different thing some other time. The programming structure that allows for this is a *conditional*. Today will be focused on the conditional structures in Python and the necessary *Boolean* values.

## Basic Learning Objectives
Before class, you should be able to:

* Define what *Boolean* values are
* Recognize the `if`/`elif`/`else` syntax for *conditionals*
* Define what the `and`, `or`, and `not` *logical operators* do
* Define what the `in` operator does in the basic case

## Advanced Learning Objectives
After class, you should  be able to:

* Use basic, nested, and chained conditionals to solve a problem
* Use logical operators to solve a problem
* Predict what code will do when *short-circuit boolean evaluation* is used

## Resources
You should read/watch the following:
* [5.1 What we can do with Conditionals](https://runestone.academy/ns/books/published/foppff/conditionals_intro-what-we-can-do-with-conditionals.html?mode=browsing)
* [5.2 Boolean Values and Expressions](https://runestone.academy/ns/books/published/foppff/conditionals_boolean-values-and-boolean-expressions.html?mode=browsing)
* [5.3 Logical operators](https://runestone.academy/ns/books/published/foppff/conditionals_logical-operators.html?mode=browsing)
* [5.4 The `in` and `not in` opreators](https://runestone.academy/ns/books/published/foppff/conditionals_the-in-and-not-in-operators.html?mode=browsing)
* [5.6 Conditional Execution](https://runestone.academy/ns/books/published/foppff/conditionals_conditional-execution-binary-selection.html?mode=browsing)
* [5.7 Omiting the `else` Clause](https://runestone.academy/ns/books/published/foppff/conditionals_omitting-the-else-clause-unary-selection.html?mode=browsing)
* [5.8 Nested conditionals](https://runestone.academy/ns/books/published/foppff/conditionals_nested-conditionals.html?mode=browsing)
* [5.9 Chained conditionals](https://runestone.academy/ns/books/published/foppff/conditionals_chained-conditionals.html?mode=browsing)

## Checks
Submit answers to the following on Moodle.
* (Checkpoint 5.9.2) What will the following code print?

```python
x = 3
y = 5
z = 2

if x < y and x < z:
  print("a")
elif y < x and y < z:
  print("b")
else:
  print("c")
```

* Write a snippet of code that prints out whether the value in the variable `mystery` is greater than or less than 5.
<script type="py-editor">
  mystery = 10 #try out changing to different values
  #your code here
</script>