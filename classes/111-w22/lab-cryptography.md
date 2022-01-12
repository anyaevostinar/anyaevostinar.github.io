---
layout: page
title: Cryptography Lab 
permalink: /classes/111-w22/cryptography
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.
I also included a conversion chart on Moodle that you should download and have open as you work through today's lab.
You may also find [this list of Python string methods](https://docs.python.org/3/library/stdtypes.html#string-methods) helpful for reference (the Python docs will be a good place to look up methods as you learn more during the term!)

## Exercise 1
As you read, there are many ways of encoding or *encrypting* messages by changing the letters into numbers or other letters.

One common encryption algorithm is ROT-13. It derives its name from the fact that it rotates each letter in a message 13 places forward in the alphabet, rotating around to the beginning if necessary. So, for instance, the letter "A", which is 1st in the alphabet, will become the letter "N", which is 14th in the alphabet. "C" (3rd) becomes "P" (16th). "R" is the 18th letter in the alphabet. 18 + 13 = 31, which is more letters than we have--so once we go off the end, we start at the beginning with "A", which means that "R" will become "E" (5th).

There are a couple of advantages of this algorithm:

* Encrypting messages is easy! Just add 13 to each letter. (Though be careful about going off the edge... seem like a good use of modular arithmetic?)
* Decrypting messages is just as easy! In fact, because there are 26 letters in the alphabet, we decrypt messages using the same algorithm as decrypting them!

Take a minute to practice by decrypting this secret message:

```
PF VF NJRFBZR
```

Once you feel confident in how the algorithm works, write up a Python program that will apply ROT-13 to a string given by a user. In pseudocode, your algorithm should look something like this:

* Get a string from the user (using input())
* For each letter in the string:
    * Print out the letter 13 places down in the alphabet--being careful to wrap around to the beginning if necessary.

Some notes:

* You can assume the message is entirely in lowercase.
* Digits, spaces, and punctuation should be printed out as they are, without being rotated at all.
* The `ord()` function converts characters into their ASCII value (e.g., `ord("a")` will return 97, `ord("z")` will return 122).
* The `chr()` function goes in the opposite direction, converting an ASCII value to a string (e.g., `chr(97)` returns "a", `chr(122)` returns "z").

Create a short fun/happy message with your program and write it on the whiteboards!

## Exercise 2
Secret messages are no fun if you can't read them. 
Write a second Python program to decode/decrypt the messages, by moving the letters back 13 spaces.
Decrypt a few of the messages other people have written and see what they say.

## Exercise 3
By this point, you have likely surmised that ROT-13 isn't a very secure method of encryption. 
One way we could improve it a bit would be to generalize it away from the number 13, allowing users to use any agreed upon number from 1-26. (This generalization is sometimes called the *Caesar cipher*.)

Extend your program from Exercise 1 to take both a message and a rotation (an integer between -26 and 26) and then apply the rotation to the message. Be careful to check for the need to rotate around to the other side in both directions.

Create another short fun/happy message and write it on the board with the rotation amount (if you were trying to keep it a secret, you would agree with your friend ahead of time what the rotation amount would be).
Try also decoding some more messages from other people on the board.

## Extra
*Note: this part is much harder, but hopefully a fun extension!*

So that's a bit better, but still not quite secure. For one thing, we're assuming that we have a secure channel across which two people can tell each other what rotation to use. If they can communicate that... why not just communicate their message?

But maybe they shared the rotation in person and no one had the chance to overhear it. How, then, might an eavesdropper still decipher their message?

Write a program that takes as input a message that has been encoded using a Caesar cipher (with an unknown rotation) and **helps you determine what the original message was**. This part is intentionally more open-ended than the previous two. I would suggest first writing a program that might also require some intuition on the part of the user ("Here is a list of things the original message *might* be...") and then potentially modify that program to make some informed suggestions about which rotations are most likely to have been the original one.

Some things that you might consider:

* Here are [the frequency of letters in the English language](https://en.wikipedia.org/wiki/Letter_frequency), how could you count the most frequent letter in the input and use that information to help you?
* Also potentially useful could be [the most common words in the English language](https://en.wikipedia.org/wiki/Most_common_words_in_English)

There are many ways to approach this problem, and many of those are likely to take much longer than the class period. Brainstorming some pseudocode approaches is a good starting point!