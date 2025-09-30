/*
    character_counter.c
    Jeff Ondich, 5 Jan 2022

    Illustrates (barely) the use of command-line arguments and
    file input by opening the specified file, reading one character
    at a time from the file, and keeping count of the characters.
*/

#include <stdio.h>

// These are "prototypes" of functions that are defined later in the
// file. Putting prototypes here tells the compiler about these functions
// so it won't be confused when it encounters them in main().

void print_usage_statement(const char *program_name);
int get_character_count(const char *file_name);


int main(int argc, char *argv[]) {
    // Parse the command line
    if (argc != 2) {
        print_usage_statement(argv[0]);
        return 1;
    }
    const char *input_file_name = argv[1];

    // Do the work
    int character_count = get_character_count(input_file_name);
    if (character_count < 0) {
        fprintf(stderr, "Trouble counting the characters in %s\n", input_file_name);
        return 1;
    }

    // Print the results
    printf("Number of characters: %d\n", character_count);

    return 0;
}

void print_usage_statement(const char *program_name) {
    fprintf(stderr, "Usage: %s inputfile\n", program_name);
    fprintf(stderr, "  prints to standard output the number of chars\n");
    fprintf(stderr, "  (as a decimal integer) in the specified file\n");
}

// Returns the number of chars in the specified file, or -1 if an error
// occurs. Errors include failure to open or read from the file.
int get_character_count(const char *file_name) {
    // Open the file for reading
    FILE *input_file = fopen(file_name, "r");
    if (input_file == NULL) {
        return -1;
    }

    // Loop through the file one char/byte at a time, counting as we go.
    int character_count = 0;
    char ch = fgetc(input_file);
    while (ch != EOF) {
        character_count++;
        ch = fgetc(input_file);
    }

    // fgetc will return EOF in either of two conditions: the normal
    // situation where we've finished reading through the file, or the
    // exceptional situation where there's been some sort of system error
    // during our attempt to read a character. To figure out which
    // situation we're in, we can use either the ferror function or the
    // feof function. ferror will return true if a system error occurred.
    //
    // Error-checking is usually a huge pain in the neck, but it's super-duper
    // important to do thoroughly. Errors really do occur, and we need to
    // decide how we want our software to behave when they do.
    if (ferror(input_file)) {
        fclose(input_file);
        return -1;
    }

    // Clean up after ourselves.
    fclose(input_file);

    return character_count;
}

