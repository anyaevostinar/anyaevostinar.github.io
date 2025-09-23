---
layout: page
title: Dynamic Memory Lab
permalink: /classes/208-f25/dynamic-lab
---


## Exercise 1
Let's start by looking at static memory allocation in `gdb`. 

1. Connect to `mantis` as usual and make sure that you still have `gdb_test.c` and `gdb_test`. If you don't, go grab it from the Samples page and compile.

2. Start running it in `gdb`: `gdb gdb_test`.

3. Put in a breakpoint at line 31 and 33: `b 31` and `b 33`

4. Run with input 6: `r 6`

5. `C`ontinue a couple of times so that you have a few recursive calls to look at.

6. Do `backtrace` so that you can get an idea of what address locations your function calls are saved on the stack.

7. There is a special memory location, called a register (which we'll learn about more later), `$rsp`, which saves the location of the current top of the stack. We want to take a look at what is in our stack at this point, and we can do so with examine:

    ```bash
    x/15gx $rsp
    ```

    This command says to give you 10 "giant words" in hex starting from the location saved in `$rsp`.

8. Examine the output and figure out what is saved on your stack. You should be able to compare to your backtrace and make some meaning out of the first five or so lines (depending on how many recursive calls you made).

9. Also take note of the address location of the top of your stack (the values in blue to the left). 

10. Continue a few more times until you start coming back out of the recursion.

11. Take a look at your stack again, what has changed? What are the implications for the idea of "scope"?

## Exercise 2
Now let's see how things differ with dynamic memory.

1. Copy the contents of [dynamic.c](dynamic.c) onto mantis and look through it to see what you'll be working with.

2. Compile it for `gdb` with `gcc -Wall -Werror -g -Og -o dynamic dynamic.c` and run in `gdb`.

3. Put breakpoints at lines 107 and 111.

4. Run the code until the first breakpoint and then print the value of `linked_list` with `print linked_list`. This should give you a memory address (to what?). Make note of this address since we'll want it again later.

5. Use examine to check out what is stored starting at that memory address: `x/40gx YOUR_ADDRESS_HERE`

6. Again, work on making sense of what you are seeing. You should be able to understand most of what prints out. Compare to what you know about the `struct` defined in `dynamic.c` and remember that the hexadecimal ASCII of `a` is 0x61. **Submit on Moodle the contents of memory and a sentence or two about what you are seeing for an engagement credit.**

7. Examine the call stack again with `x/10gx $rsp`. How does it differ compared to Exercise 1?

8. Continue to your next break point and then print the value of `linked_list` again. What do you think is going on?

9. Step once so you get back out into main and print the value of `linked_list` again. Does it still exist?

10. Examine the contents at the memory location that you saved previously. Is that all still there? What does this tell you about scope?

## Extra
We are leaving quite the mess after `making_a_list()` runs! Practice your dynamic memory management by trying out implementing `free_list` and then going back through Exercise 2 to see the memory clean up in action!