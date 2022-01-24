---
layout: post
title:  "Gradescope Autograder Tips"
date:   2022-01-24 10:00:00 -0500
categories: [Teaching]
---

This document is mostly for me to write down the things that I had to figure out for myself so that future me has an easier time remembering, though I hope they might also be helpful for others who are experienced programmers but figuring out [Gradescope](https://www.gradescope.com/)'s [autograder](https://gradescope-autograders.readthedocs.io/en/latest/) for the first time.

## Examples
Start from examples, it just makes life easier.
The [official Gradescope example](https://github.com/gradescope/autograder_samples/tree/master/python/src) for Python is a good starting place.
There are some others that I looked at but can't recall which now.

## Show output to students
Assuming there isn't secret information in your output (and if you are teaching intro like me, students probably wouldn't be able to exploit the output anyway), printing the output is very helpful for telling the students when they have a weird library or the wrong file name.

The file `run_tests.py` originally looks like this:
```
import unittest
from gradescope_utils.autograder_utils.json_test_runner import JSONTestRunner

if __name__ == '__main__':
    suite = unittest.defaultTestLoader.discover('tests')
    with open('/autograder/results/results.json', 'w') as f:
        JSONTestRunner(visibility='visible', stream=f).run(suite)
```

To show the output to students on Gradescope, you need to add the JSON `stdout_visibility = "visible"`, which then makes `run_tests.py` look like this:

```
import unittest
from gradescope_utils.autograder_utils.json_test_runner import JSONTestRunner

if __name__ == '__main__':
    suite = unittest.defaultTestLoader.discover('tests')
    with open('/autograder/results/results.json', 'w') as f:
        JSONTestRunner(visibility='visible', stdout_visibility = "visible", stream=f).run(suite)
```

## Don't cut off the diff
Gradescope by default has a maximum diff that it will show to students when they aren't passing a test, which is fine when they are using functions, but since I'm teaching intro and they don't learn functions until a third of the way in, I'm doing a whole lot with print statements and the diff was getting cut off.

You can test any print statements with an integration test, shown in [`test_integration.py`](https://github.com/gradescope/autograder_samples/blob/master/python/src/tests/test_integration.py).
To get the full difference to be displayed, even if they have a lot of print statements, make the beginning of the `TestIntegration()` class look like this:

```
class TestIntegration(unittest.TestCase):
    maxDiff = None
```

## Command line arguments that are strings
I spent too much time fighting to write a test for a cryptography assignment where the command line arguments included a string with spaces such as "hi this is a string".

The problem is that a line like this for an integration test:
```
calc = subprocess.Popen('python3 -u calculator.py'.split(),
                                stdin=subprocess.PIPE, stdout=subprocess.PIPE,
                                encoding='utf8')
```
is trying to be too fancy by writing a string for the command, which then just gets split to be a list anyway, accidentally splitting my command line argument on the way there.

Sure, you could be fancy with escaping things, or you can just write the list directly in the first place:
```
code = subprocess.Popen(['python3', '-u', 'caesar.py', "This is the way the world ends, dontcha know?", 'a'],
                                stdin=subprocess.PIPE, stdout=subprocess.PIPE,
                                encoding='utf8')
```

## Testing functions (not class methods)
I thought life would get easier once I taught students about functions, but it's not obvious from the example how to test functions instead of class methods.

For getting access to the students' function, it's just a normal Python import fortunately. 
For example, my students have submitted files named `caesar.py` in which they have a function `caesar()`.
I just added an import line to the top of my test file:
```
from caesar import caesar
```

And then to test, it is just calling the function like normal and checking what it returned:
```
@weight(0.25)
    def test_caesar1(self):
        """Check if caesar function works for first example"""
        result = caesar("This is the way the world ends, dontcha know?", 0)
        self.assertEqual(result, "This is the way the world ends, dontcha know?")
```

I'm happy to share my autograders with educators, they are in a private git repo along with my solutions so it's easy to do, I just don't really want to make them public on the off chance one of my students goes looking for them :).
Just email me (vostinar at carleton dot edu)!