---
layout: page
title: HashMaps Intro
permalink: /classes/201-f21/hashmaps
---

## Overview
You've read about how a class or interface can support one or more *generic* types.
You've also already seen and possibly used one such class, the `ArrayList`, with the following syntax:
```
ArrayList<String> myList = new ArrayList<String>();
```
(And yes, you can leave out the second mention of `String` without a problem, but I'm old school and I like it.)

In this reading, I'll introduce you to how to use the Java built-in `HashMap` class that is a generic that supports two different types and is very convenient. 

## Pairs
You may have already heard about programming dictionaries or maps, and `HashMap` is just one kind of dictionary or map (those mean the same thing in programming generally, but different languages use one or the other unfortunately). 
If you haven't already heard about dictionaries or maps in programming, they are basically just collections of pairs of data and are often used to associate a `String` with some useful information, letting you look up that information from the `String`. 

For example, if you wanted to keep track of how many times each word appeared in a text document, you could make a `HashMap` that held words and their counts:
```
import java.util.HashMap;
public class Test {
    public static void main(String[] args) {
    HashMap<String, Integer> wordCounts = new HashMap<String, Integer>();
}
```

The `String` or whatever is in the first spot of the pair is called the **key** and the `Integer` or whatever is in the second spot of the pair is called the **value**.
Thus, we often talk about "key-value pairs" in maps. 
Keys in a `HashMap` must be unique, it wouldn't make any sense in this example to have multiple entries for a single word after all. 
You also should generally only try to look up a key in a map; looking up a value to get the key is difficult/weird and not what the structure is designed for.
In this example, that would mean that you can look up the word "hi" to find out how many times it appeared in a document, but it wouldn't make sense to look up the count 5 to find a key that appeared 5 times. 

## Using a HashMap
Okay, so hopefully you're convinced that this is a useful data structure to use, but how do you actually use it?
The main things that a `HashMap` allows are putting key-value pairs into the map and getting them out based on the key.

### put
First, let's put some key-value pairs into our map. 
If I wanted to record that I found one occurrence of the word "hi", I would use `put`:
```
wordCounts.put("hi", 1);
```

If I then found "hi" a second time, I could overwrite my previous entry with `put` again:
```
wordCounts.put("hi", 2);
```

### get
Information is of no use if you can't retrieve it, so how do you get the key-value pairs out of a `HashMap`? With the `get` function:
```
System.out.println("hi has been seen " + wordCounts.get("hi") + " times");
```

You can also use `get` and `put` together to increment the count of a word:
```
wordCounts.put("hi", wordCounts.get("hi")+1);
```

### keySet
The last major thing you might want to do with the information in your `HashMap` is looping over all the keys so that you can print out everything that is in your map. 
You can do that with the `keySet()` method, which gives you a `Set` of all your keys (don't worry exactly what a set is if you aren't sure, we'll talk about it soon; the important thing to know is that your keys aren't in any particular order).

Here is an example of looping over the words in your map:
```
    for(String word : wordCounts.keySet()) {
      System.out.println("\""+ word + "\" has been seen " + wordCounts.get(word) + " times.");
    }
```

### More functionality
As with all built-in Java data structures, `HashMap` has a lot more functionality than can be covered in one reading, but you are welcome to use it.
The best way to find out what all you can do with a data structure is to look at it's documentation. 
The documentation for `HashMap` is here: [https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashMap.html](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashMap.html).