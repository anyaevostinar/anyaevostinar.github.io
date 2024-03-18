/*
    charstar.c

	Jeff Ondich, 21 February 2022

    Pointers to characters in all their wacky forms.

        char *p
        char p[]
        p = &buffer[0]
        p = &buffer[7]

        char ch
        p = &ch

        etc.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s some_string\n", argv[0]);
        return 1;
    }
    
    char *p1 = "pointer to a literal"; // right side: const char *

    char p2[40] = "buffer initialized by literal"; // left side: char const *

    char p3[40];
    strcpy(p3, argv[1]);

    char *p4 = malloc(40);
    strcpy(p4, argv[1]);

    char *p5 = &p2[0];

    char *p6 = &p1[0];

    char *p7 = &p1[8];

    char my_character = 'Z';
    char *p8 = &my_character;

    // They're all pointers to a char. Which also makes them
    // pointers to a sequence of char (whether or not the programmer
    // intended that and allocated the required memory.
    printf("p1 [%p]: %s\n", p1, p1);
    printf("p2 [%p]: %s\n", p2, p2);
    printf("p3 [%p]: %s\n", p3, p3);
    printf("p4 [%p]: %s\n", p4, p4);
    printf("p5 [%p]: %s\n", p5, p5);
    printf("p6 [%p]: %s\n", p6, p6);
    printf("p7 [%p]: %s\n", p7, p7);
    printf("p8 [%p]: %s\n", p8, p8);

    // Stuff that's different
    strcpy(p3, "hello");
    printf("p3 gets hello: %s\n", p3);
    fflush(stdout);
    
    strcpy(p2, "hello");
    printf("p2 gets hello: %s\n", p2);
    fflush(stdout);
    
    strcpy(p1, "hello");
    printf("p1 gets hello: %s\n", p1);
    fflush(stdout);
    
    //
    p1 = p2; // OK
    p2 = p1; // not OK

    // Clean up after ourselves
    free(p4);

    return 0;
}
