---
layout: page
title: Pointers Lab
permalink: /classes/208-f25/pointers-lab
---

## Exercise 1
a. What mistake is the following code demonstrating?

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=%23include%20%3Cstdio.h%3E%0A%0Avoid%20swap_bad%28int%20a,%20int%20b%29%20%7B%0A%20%20int%20temp%20%3D%20a%3B%0A%20%20a%20%3D%20b%3B%0A%20%20b%20%3D%20temp%3B%0A%7D%0A%0Aint%20main%28%29%20%7B%0A%20%20int%20first%20%3D%201%3B%0A%20%20int%20second%20%3D%202%3B%0A%20%20swap_bad%28first,%20second%29%3B%0A%20%20printf%28%22first%20value%3A%20%25d%22,%20first%29%3B%0A%20%20return%200%3B%0A%7D&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=nevernest&origin=opt-frontend.js&py=c_gcc9.3.0&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

b. Write a correct `swap` function for two `int`s in a file `swap.c`:

```c
// compile with gcc -Wall -Werror -g -o swap swap.c
#include <stdio.h>
void swap(______ a, ________ b) {

	
}
int main() {
	int first = 1;
	int second = 2;
	swap(_________, _________);
	printf("first value is: %d\n", first);
	return 0;
}
```

c. Recompile `swap.c` for use with gdb (`gcc -Wall -Werror -g -Og -o swap swap.c`) and explore `swap` with gdb by trying out the following:

* Put a breakpoint just before going into swap (check the [GDB lab](c-gdb-lab) if you don't remember the commands)
* Print out the addresses of `first` and `second` with `p &first` etc
* Step into `swap` and check what the values of `a` and `b` are
* What happens when you print the addresses of `a` and `b`? 

d. You can also "examine" specific locations in memory with `x/ YOUR_LOCATION`. For example, my value of `a` is `0x7fffffffe980` (yours may be different), and so I can see the data at that location with `x/0x7fffffffe980`, which should be 1 before any swapping happens. 

## Exercise 2
a. Predict what the following will print:

```c
#include <stdio.h>
int main() {
  char buffer[4] = "cat";
  char *ptr = buffer;
  
  printf("What is this? %c\n", *ptr);
  printf("What about this? %s\n", buffer);

 
 return 0; 
}
```

b. Which of the following two lines will throw an error if added to the code above and why?

```c
  *ptr = 'b';
  buffer = 'b';
```

## Exercise 3
a. Predict what the following code will output:

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=%23include%20%3Cstdlib.h%3E%0A%23include%20%3Cstdio.h%3E%0A%0A%23define%20BUFFER_SIZE%209%0A%0Aint%20main%28%29%20%7B%0A%0A%20%20char%20creature%5BBUFFER_SIZE%5D%20%3D%20%22capybara%22%3B%0A%20%20char%20beast%5BBUFFER_SIZE%5D%20%3D%20%22null%22%3B%0A%20%20printf%28%22Before%20copying%3A%20%25s%20%28creature%29,%20%25s%20%28beast%29%5Cn%22,%20creature,%20beast%29%3B%0A%20%20char%20*source_pointer%20%3D%20creature%3B%0A%20%20char%20*destination_pointer%20%3D%20beast%3B%0A%20%20while%20%28*source_pointer%20!%3D%20'%5C0'%29%20%7B%0A%20%20%20%20*destination_pointer%20%3D%20*source_pointer%3B%0A%20%20%20%20destination_pointer%2B%2B%3B%0A%20%20%20%20source_pointer%2B%2B%3B%0A%20%20%7D%0A%20%20*destination_pointer%20%3D%20'%5C0'%3B%0A%20%20printf%28%22After%20copying%3A%20%25s%20%28creature%29,%20%25s%20%28beast%29%5Cn%22,%20creature,%20beast%29%3B%0A%20%20printf%28%22%5Cn%22%29%3B%0A%0A%20%20return%200%3B%0A%7D&codeDivHeight=400&codeDivWidth=350&cppShowMemAddrs=true&cumulative=false&curInstr=0&heapPrimitives=nevernest&origin=opt-frontend.js&py=c_gcc9.3.0&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

b. What would happen if you changed `BUFFER_SIZE` to 8?

## Exercise 4
What will be printed after this code runs:

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=%23include%20%3Cstdio.h%3E%0A%0Aint%20main%28%29%20%7B%0A%20%20int%20a%20%3D%205%3B%0A%20%20int%20*a_ptr%20%3D%20%26a%3B%0A%20%20int%20**b_ptr%20%3D%20%26a_ptr%3B%0A%20%20*a_ptr%20%3D%206%3B%0A%20%20**b_ptr%20%3D%207%3B%0A%20%20printf%28%22Value%3A%20%25d%5Cn%22,%20a%29%3B%0A%20%20return%200%3B%0A%7D&codeDivHeight=400&codeDivWidth=350&cppShowMemAddrs=true&cumulative=false&curInstr=0&heapPrimitives=nevernest&origin=opt-frontend.js&py=c_gcc9.3.0&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

## Exercise 5
Copy the following into a file `calculate.c`:

```c
#include <stdio.h>
//// compile with gcc -Wall -Werror -g -o calculate calculate.c
/* Returns the sums two numbers. */
int compute_sum(int x, int y) {
    return x + y;
}

/* Returns the product of two numbers. */
int compute_product(int x, int y) {
    return x * y;
}

/* Function to perform calculations on input parameters x and y and set the
 * sum_result and prod_result parameters to their results.
 */
void calculate(int x, int y, int *sum_result, int *prod_result) {
    //TODO
}

int main(void) {
    int a = 3, b = 4;
    int sum, product;
    
    //Call calculate here!
    printf("sum of %d and %d is %d \n", a, b, sum);
    printf("product of %d and %d is %d \n", a, b, product);    
    return 0;
}
```

Complete the calculate function and call it in `main`.

## Submission
You can submit your completed `swap.c` and `calculate.c` to the assignment on Moodle for an extra engagement credit.


## Extra
If you finish the lab early, you can work on your homework and revisions.

You can also check out [this blog post](https://jvns.ca/blog/2021/05/17/how-to-look-at-the-stack-in-gdb/) that has some more fun things to do with GDB to see how things are stored in memory. We'll be doing a lot more of this in the coming weeks!