/*
    args.c
    Jeff Ondich, 27 March 2023

    A tiny experiment with command-line arguments.

    Compile as usual:

        gcc -Wall -Werror -g -o args args.c

    Run with zero or more command-line arguments:

        ./args
        ./args howdy jeff
        ./args a b c d e f g whatever blah blah blah

    Read the code to figure out what:

        argc means
        argv[0] points to
        argv[k] points to for k > 0

    Also, read the code to figure out how to get a picture
    of a moose to print out.
*/

#include <stdio.h>
#include <string.h>

void print_moose();

int main(int argc, char *argv[]) {
    printf("Your command line includes %d arguments:\n", argc);
    for (int k = 0; k < argc; k++) {
        printf("  argv[%d] --> %s\n", k, argv[k]);
    }

    if (argc >= 3 && strcmp(argv[2], "moose") == 0) {
        printf("\nCongratulations! You get an extra surprise!\n\n");
        print_moose();
    }

    return 0;
}

void print_moose() {
    printf(" ___            ___\n");
    printf("/   \\          /   \\\n");
    printf("\\_   \\        /  __/\n");
    printf(" _\\   \\      /  /__\n");
    printf(" \\___  \\____/   __/\n");
    printf("     \\_       _/\n");
    printf("       | @ @  \\_\n");
    printf("       |\n");
    printf("     _/     /\\\n");
    printf("    /o)  (o/\\ \\_\n");
    printf("    \\_____/ /\n");
    printf("      \\____/\n");
    printf("\nhttps://www.asciiart.eu/animals/moose\n");
}
