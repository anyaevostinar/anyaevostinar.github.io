---
layout: page
title: Style Reference
permalink: /classes/201-s24/style-reference
---

## Overview
There are various bits of information that you need to do for style in particular and this is a page that collects them together for you.


## Capitalization: 
* Class names always start with a capital letter (e.g. `String`).
* Variable names start with a lower case letter (e.g. `word`), but if they contain multiple words, they use "camel case'" where all words except for the first start with a capital letter (e.g. `myLongVariableWithManyWords`) (and long variable names are good!)
* If you are declaring a constant variable, you use all capital letters (e.g. `public static final double PI = 3.14159;`).  If the constant variable uses multiple words, use an underscore to separate the words (e.g. `MINIMUM_SIZE`).

## Comments: 
* Use Javadoc style comments (`/** ... */`) to summarize the whole class, and as a comment for each method that describes what the method does.  You may also use these comments to indicate the purpose of all the fields in a class.
* As appropriate use regular comments (`/* ... */` or `//...`) within methods to provide further detail on any underlying logic.  I suggest writing comments by considering an audience that knows Java, but is not familiar with the details of what exactly you are trying to implement.
* You should aim to have comments for blocks of code that are a logical unit. If you have many small methods, you might not actually need many comments. However, if you have a longer method, you should use comments to explain why each block of code is doing what it is doing.
* When writing a single line comment use `//` instead of `/* ... */`.
* This is what I mean by JavaDocs style comments:
  ```java
  /**
  * Generally descriptive few sentences about the method.
  * @param nameOfParameter description of the parameter if useful, probably should mention the type
  * @param anotherParameter if you have multiple parameters
  * @return description of what if anything is returned, should definitely mention the type
  */
  public int exampleMethod(int nameOfParameter, int anotherParameter){
  return 0;
  }
  ```


## File Organization: 
* Import statements go at the top of the file.  
* Javadoc comments (those that start with `/**`) about the class/interface should include your name and go in between the import statements and the declaration of the class/interface. 
* Instance variables and static fields go before any constructors or methods.
* All constructors appear before any methods.
If you have a `main` method, it goes after all other methods.


## Variable and Method Names:
* Use descriptive names for variables and methods.  The names should give you some clue as to what data a variable stores or what the method does.  It's fine to use names like i or j for the incrementor in a loop.
* Class Design:  Think carefully about how you design your classes.  In particular, consider the following:
  * Should fields be public or private?  Don't make them public unless you have a good reason to do so.
  * Instance variable vs local variable? If it refers to a persistent state it should probably be an instance variable.  If it will only be used once, or only by one specific method that resets it value at the beginning, then it should probably be a local variable.
  * Should fields be static or non-static? (usually non-static)

## Braces:
* Always include braces around the body of if/else/for/while/etc., even if the body is only one line long. I tend to start my braces on the same line as the if/else/for/etc.  For example,
  ```java
  if (line != null) {
    System.out.println(line);
  }
  ```

* You can also line up your braces on the left side, like so:
  ```java
  if (line != null)
  {
    System.out.println(line);
  }
  ```

## Indentation:  
* Use indentation to separate out blocks of code (like you do for Python).  For example, indent the bodies of methods, the bodies of loops, etc.  Note: Unlike Python, this type of indentation is not required, but is quite useful for making code more readable.

## White Space: 
* Do not use whitespace before a comma, semicolon, or colon.
* Do use whitespace after a comma, semicolon, or colon except at the end of a line.
* Surround binary operators (+, -, =, /, etc.) by a single space on either side.
* Surround comparisons (==, <, >, !=, <=, =>) by a single space on either side.
* Surround booleans (&&, ||) by a single space on either side.
* Not (!) can be placed directly in front of a variable or method without a space after it.

## Commented Out Code:  
* Do not include any code you've commented out when submitting an assignment (e.g. an old version of a method that didn't work correctly), unless you are explicitly told to do so.  You would never turn in an essay with paragraph simply struck through with a pen, so don't turn in code that does that.


## README
Writing good and detailed documentation for your code is an important skill, so important that [whole communities](https://www.writethedocs.org/) exist in industry that are focused on good documentation. 
One part of good documentation is the JavaDocs method comments that you'll already be doing. 
However, another part is a ```README``` that is generally the first thing that people look at when they look into your project.
If you are planning on applying for internships or full-time jobs in the computer science industry, a [GitHub](https://github.com/) account with projects with good READMEs is a really helpful part of your application. 
READMEs are generally written in a language called [MarkDown](https://www.markdownguide.org/), which is fairly straightforward to get the hang of and you can keep yours very simple.

In general (and so therefore for all homework in this class), a README should include:

* An overview section that describes at a high level what your program does, for someone that just found it randomly
* A small example of your code running and showing its main functionality

For this class in particular, your README must also include answers to any README prompts, which will often ask you to include discussion of the pros and cons of a certain data structure or implementation choice. 

I have an [example README](/classes/201-w24/readme_example) that you can look at for a project that is a bit more involved. 

## Method size
You should aim for your methods to be short, as in they fit on the screen, certainly no more than 20 lines. You should achieve this by making lots of smaller methods for the logical groups of actions that you are doing, which we usually call 'helper' methods. You can make these methods `private` so you don't have to do JavaDocs for them :).



## Acknowledgements
This style guide is adapted from one written by Layla Oesper, with modifications by Eric Alexander and Sneha Narayan.