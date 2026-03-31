---
layout: page
title: Homework 2 - Computational Complexity
permalink: /classes/201-s26/hw2
---

**Due Friday April 17th at 10pm**

* Starter file: None, see prompts below
* Upload solutions via Gradescope

# Goals

This assignment is designed to help practice the following:
* analyzing nested loops for computational complexity
* start thinking about functions in terms of big-O

# Collaboration policy

For this assignment, you may work alone or with a partner, but you must write up all of your answers yourself.  (It is therefore unexpected for two submissions to be completely identical.)  You may have at most one partner.

You may also discuss the assignment at a high level with other students.  You can discuss the assignment with Anya, our prefect, or any course staff.

You should list any student or course staff with whom you discussed the assignment (you don't have to include prefect sessions), and the manner of discussion (high level, partner, etc.) in the reflection at the end of the assignment.

_If you work alone, you should say so instead._

## AI policy

Generative AI is all around you whenever you are using technology lately. As discussed in the syllabus, there are both acceptable and unacceptable uses of genAI in this class. **Regardless of whether you use any genAI, you need to complete the** `AI Log` at the end of the assignment to satisfy the advanced requirement. I am experimenting with custom-made Gemini chatbots ("Gems") that hopefully will help you on the homework without undermining your learning. [Here is the one for homework 2](https://gemini.google.com/gem/1ukzM0rlPexEDGqpCGky3hmq-MuOssqgt?usp=sharing). 

If you choose not to use genAI at all, you may state that for your AI Log (and I fully support this choice). I'd be interested in your reasons, though it's not required to write them in the log for every assignment.

If you do choose to use genAI, you should log in in the `AI Log` comment at the end of the assignment in the following format:
* Date: Summary of use and assessment of the bot's usefulness

For example, a hypothetical log could be:
* 3/31/26: I asked the helper bot how to start on 1d and it walked me through it
* 4/1/26: I couldn't figure out how to upload to Gradescope and the helper bot was completely useless
* 4/2/26: I googled the problem with the Gradescope test and the AI summary was helpful

This log requirement is both to give me an idea of whether the chatbots are providing correct information and if they are actually being helpful. If you manage to get them to produce solutions or otherwise inappropriate responses, please let me know asap so that I can prevent it from undermining everyone's learning further. As mentioned in the hypothetical log, you should also include any external genAI resources that you use, even the AI summary shown in search results.

# Assessment

The **core** requirements for your submission are:

* give correct numerical and formulaic answers to all the questions
* give accurate justifications for at least three answers
* include your collaboration statement in your response to the last question of the assignment 

The **advanced** requirements for your submission are:

* satisfy the core requirements
* give compelling justifications for all answers
* include a reflection in your response to the last question of the assignment
* include your AI Log in your response to the last question of the assignment 

# Assignment overview

This is assignment does not require you to write any code (though you can type up the code to help you understand it).

For this assignment, you can once again work with up to one partner, but you must write up all
of your answers yourself. You can, however, have high-level discussions with your classmates.
This assignment needs to be **written in your own handwriting (not typed)**. You can complete it on paper or on a tablet, but it must be hand-written (life in the age of LLMs).  You will need to submit a PDF to Gradescope, and make sure to select the regions in your PDF that correspond to each solution -- be sure to keep your answers somewhat separated from each other. (Gradescope also has a mobile app, in case you find that more
handy.)

## Problem 1
For each of the following code fragments:
* indicate how many times the output statement is displayed (the exact number, not an
approximation, relative to 𝑛)
* indicate whether that number is better described as O(n) or O(n^2)
* provide a brief but accurate justification of your answer

### a. 
```kotlin
for (i in 0..<n) {
    for (j in 0..<n) {
        println("$i $j")
    }
}
```

### b.
```kotlin
for (i in 0..<n) {
    for (j in 0..<2) {
        println("$i $j")
    }
}
```

### c.
```kotlin
for (i in 0..<n) {
    for (j in n-1 downTo 0) {
        println("$i $j")
    }
}
```

### d.
```kotlin
for (i in 0..<n) {
    for (j in 0..<i) {
        if (j % i == 0) {
            println("$i $j")
        }
    }
}
```

## Problem 2. 
Below is a code snippet to match students with advisors:
```kotlin
fun makeAdvisingMatch(students:List<String>, professors:List<String>){
    for (student in students){
        for(professor in professors){
            println("Possible Match: $student & $professor")
        }
    }
}
```

a. What is the Big-O run time of this function?
b. Provide a brief but accurate justification for your answer.

## Reflection 
* Were there any particular issues or challenges that you dealt with in completing this assignment? 
* How long did you spend on this assignment?
* Write a brief discussion (a sentence or two is fine). Also include your collaboration statement
here; if you worked alone, say so.

Here are some examples:

* Reflection:
>>
>>I had some trouble making sense of question 1(d), so I wrote out the expected print statements on paper first.
>>
>>I had to refer to my course notes to find out what `O(n)` and `O(n^2)` meant
>>
>>I spent 6 hours on this assignment.


* Reflection:
>>
>>I started late, so I had to rush my explanations.
>>
>>I really don't understand how the counts and Big-O are different
>>
>>I spent 5 hours on this assignment.

* Reflection:
>>
>>This went fine; I couldn't figure things out some of them right away so I had to type them up and run them with different inputs.
>>
>>I spent 3.5 hours on this assignment.

&nbsp;