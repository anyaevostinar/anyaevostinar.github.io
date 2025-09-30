/*
    hello.c

    Started in C++ by Jeff Ondich on 30 March 1998
	Rewritten in C on 11 December 2021

    This program says hello to the user, and
    squares the number 6. Exciting!
*/

#include <stdio.h>

int main() {
    printf("Hello, world!\n");

    // Take a look at the %d below. That's what's known as a "format specifier",
    // and tells printf in what way to print the corresponding parameters.
    // Here, we're saying "print both number and number*number
    // as decimal (i.e., base ten) numbers.

    int number = 6;
    printf("%d squared is %d\n", number, number * number);

    return 0;
}
