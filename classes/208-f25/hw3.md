---
layout: page
title: HW3 - String Things
permalink: /classes/208-f25/hw3

---

**Due: Friday, Oct 3rd, at 10:00pm**

* Starter code: [a3.tar](a3.tar)
* Upload solutions via Gradescope as: `ds.c` and `ss.c`

## Goals
This assignment is designed to help you practice the following:

* understanding integer number types as possible containers for multiple data values
* parsing null-terminated strings
* thinking of contiguous bytes as having a continuous sequence of addresses

## Collaboration policy
For this assignment, you may work alone or with a partner, but you must type up all of the code yourself. (It is therefore unexpected for two code submissions to be completely identical.)

You may also discuss the assignment at a high level with other students.

You should list any student with whom you discussed the assignment, and the manner of discussion (high level, partner, etc.) in comments at the top of your C source file(s).

*If you work alone, you should say so instead.*

## Assessment
The **core** requirements for your submission are:

* pass the happy-path autograder tests (these have names starting with `"_CR"`)
* be somewhat [well-styled](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/style-guide)

The **advanced** requirements for your submission are:

* satisfy the core requirements
* pass all autograder tests
* be quite [well-styled](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/style-guide), particularly with well-chosen variable names, naming all magic numbers, good identation, and using helper methods/loops to reduce code duplication
* have well-chosen algorithms (i.e., don’t over-complicate this task!)
* have thorough error-handling
* include your name and collaboration statement at the top of your C source file(s)

## Assignment overview
This assignment is about fundamental operations that are useful in different "systems" areas, which we’ll explore throughout the rest of the term. Your work will be divided across two different programs:

* Data Store (`ds.h`/`ds.c`): Given a label and a string, stores/retrieves the string in/from the appropriate location in a Data Store. The label is provided as an `int` and contains multiple values which, together, indicate to/from where the string should be stored/read.

* String Splitter (`ss.h`/`ss.c`): Given one large string and a delimiter, splits the string into a series of substrings. The result is provided as an array of each substring (e.g., as an array of the addresses where each substring starts).

You are given a lot of starting code for this assignment —- a header file for each program, as well as a `main.c` file to test your code. You should read through `main.c` to see how your code will be used, and make sure to read the function documentation in the header files before starting.

## Getting the starter package
Like the previous assignment, this one has multiple files to comprise its starter code, including some testing tools. Like before, you can access the code package as a downloadable `.tar` file.

To get started on this assignment:

1. Login to `mantis.mathcs.carleton.edu` using [fern](https://fern.mathcs.carleton.edu/jupyter/) and open your `CS208` folder. Go back and look at [Lab 0](mantis-lab) if you have any questions about how to do this.

2. In your terminal, run:

    ```bash
    wget https://anyaevostinar.github.io/classes/208-f25/a3.tar
    ```

3. Still in your terminal, extract the `a3` folder:

    ```bash
    tar xvf a3.tar
    ```

    This will create a folder named `a3` with some stuff in it.

4. Read the function documentation in `ds.h` and `ss.h` and get started.

## Your assignment
Read through the code to see what each part needs to be able to do. If you don’t understand what a docstring says or what I’m looking for, just ask!

### Core
In order to satisfy the core requirements, you must complete the basic functionality for each program.

#### Part A: Data Store
You’ll implement a Data Store that can hold many different strings. Look at the top of `ds.h`: there are `#defines` to indicate how many entries are in the table and how much data (in bytes) each entry can hold. The provided values are 16 entries with 16 bytes each, giving a total of 256 bytes you can store in the Data Store.

Every string we want to store has an associated *label*, represented as a 32-bit integer. The label is actually a combination of different information for storing the string. The last `DS_DATA_BITS` (4 by default) are used when reading from the Data Store, to indicate where to start reading within the 16 bytes in that entry. The next DS_ENTRY_BITS (working right-to-left) indicate which entry. The remaining bits (by default, the leftmost 24 bits of the label) hold the "ID" for the string; with only 256 bytes we can store, many different labels may map to the same entry, and we want to indicate what we’ve most recently stored.

For example, a label of `0x1234abcd` would be broken up into `0x1234ab` for the ID, `0xc` for the entry number, and `0xd` for the data start position. The breakup of the bits is illustrated in the figure below:

![Data Store Label](/classes/208-f25/a3_ds.png)

Your first task is to implement `split_label` to divide this integer label into its three parts, storing each in the appropriate provided addresses:

```c
void split_label(int label, int *id_addr, int *entry_num_addr, int *data_pos_addr);
```

You can test your implementation by running `main.c` and specifying not to test storage or lookup (you’ll complete that later):

```bash
$ make
gcc -O0 -g -Wall -Werror -o a3 ds.c ss.c main.c
$ ./a3 ds 0 0
Split s1's label (0x78901234) into id=0x789012, entry=0x3, data pos=0x4
```

Make sure your code works for any values of `DS_DATA_BITS` and `DS_ENTRY_BITS`. For example, change the `#defines` in `ds.h`:

```c
#define DS_ENTRY_BITS 3
#define DS_DATA_BITS 3
#define DS_NUM_ENTRIES 8
#define DS_NUM_BYTES_PER_ENTRY 8
```

Then, you can test your code again:

```bash
$ make
gcc -O0 -g -Wall -Werror -o a3 ds.c ss.c main.c
$ ./a3 ds 0 0
Split s1's label (0x78901234) into id=0x1e24048, entry=0x6, data pos=0x4
```

#### Part B: String Splitter
For this part, you’ll implement a program in `ss.c` that can divide one large string up into several small strings. To satisfy the core requirements, you’ll need to implement the following function:

```c
int split_string(char *s, char delim, char **substrings);
```

Given the input string `s` and a character `delim`, you should store the address of the start of each substring in `substrings`, and return the total number stored. You do not need to copy the strings.

Note: Make sure to check if any provided pointers are `NULL`! Also, you may assume that `substrings` is large enough to store an address for each substring.

For example, if `s` points to the string `"abc-def-gh-i"` that begins at address `0x100`, then the call `split_string(s, '-', substr_arr)` should return `4` and store the following in `substr_arr`:

* `substr_arr[0]` should now contain `0x100` (the address of the `'a'` in `"abc"`)
* `substr_arr[1]` should now contain `0x104` (the address of the `'d'` in `"def"`)
* `substr_arr[2]` should now contain `0x108` (the address of the `'g'` in `"gh"`)
* `substr_arr[3]` should now contain `0x10b` (the address of the `'i'` in `"i"`)

Hint: You are strongly encouraged to use the `strtok` function. [The documentation page](https://cplusplus.com/reference/cstring/strtok/?kw=strtok) has a really helpful code sample.

You can test your code similarly to Part A, but change the first command-line argument to `ss`:

```bash
$ make
gcc -O0 -g -Wall -Werror -o a3 ds.c ss.c main.c
$ ./a3 ss "banana" "a"
The string to split is: "banana"       
The delimiter is: 'a'
0: 'b'
1: 'n'
2: 'n'
```

```bash
$ ./a3 ss "abc-def-gh-i" "-"
The string to split is: "abc-def-gh-i" 
The delimiter is: '-'
0: 'abc'
1: 'def'
2: 'gh'
3: 'i'
```

### Advanced
For the advanced requirements, you must add sufficient error handling and additional functionality to the two programs.

Note: Check the list at the top of this page to make sure you have everything you need (e.g., collaboration statement, good code style, etc.).

#### Part A: Data Store
For the advanced requirements, you’ll need to finish the implementation of the Data Store. First, implement `store_string` to store the given string in its appropriate entry in the data store:

```c
void store_string(data_store_t *data_store, int label, char *s);
```

Make sure to [clear out the data bits](https://cplusplus.com/reference/cstring/memset/) in the entry and copy over the provided string. After you’ve completed this function, you should be able to test the code again by running `main.c`:

```bash
$ make
gcc -O0 -g -Wall -Werror -o a3 ds.c ss.c main.c
$ ./a3 ds 1 0
Split s1's label (0x78901234) into id=0x789012, entry=0x3, data pos=0x4

[entry ID: 0x0, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0x1, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0x2, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0x3, id: 0x00789012]   h  o  b  b  e  s \0 \0 \0 \0 \0 \0 \0 \0 \0 \0
[entry ID: 0x4, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0x5, id: 0x00abcd97]   l  u  l  u \0 \0 \0 \0 \0 \0 \0 \0 \0 \0 \0 \0
[entry ID: 0x6, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0x7, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0x8, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0x9, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0xa, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0xb, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0xc, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0xd, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0xe, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0xf, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
```

Finally, fill in the implementation of `lookup_string`:

```c
int lookup_string(data_store_t *data_store, int label, char *dest);
```

This function uses the data position in the label to choose the location to start reading the string within the entry. Additionally, if you didn’t already, make sure to add a null terminator to any string longer than the data for that entry (like entry `0xe` in the last example below).

You can test the full Data Store functionality using `main.c`:

```bash
$ make
gcc -O0 -g -Wall -Werror -o a3 ds.c ss.c main.c
$ ./a3 ds 1 1
Split s1's label (0x78901234) into id=0x789012, entry=0x3, data pos=0x4

[entry ID: 0x0, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0x1, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0x2, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0x3, id: 0x00789012]   h  o  b  b  e  s \0 \0 \0 \0 \0 \0 \0 \0 \0 \0
[entry ID: 0x4, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0x5, id: 0x00abcd97]   l  u  l  u \0 \0 \0 \0 \0 \0 \0 \0 \0 \0 \0 \0
[entry ID: 0x6, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0x7, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0x8, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0x9, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0xa, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0xb, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0xc, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0xd, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0xe, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0xf, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -

New label: 0x78901330 for data: ':)'

New label: 0xbad0beef for data: 'This string is super long'

[entry ID: 0x0, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0x1, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0x2, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0x3, id: 0x00789013]   :  ) \0 \0 \0 \0 \0 \0 \0 \0 \0 \0 \0 \0 \0 \0
[entry ID: 0x4, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0x5, id: 0x00abcd97]   l  u  l  u \0 \0 \0 \0 \0 \0 \0 \0 \0 \0 \0 \0
[entry ID: 0x6, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0x7, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0x8, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0x9, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0xa, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0xb, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0xc, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0xd, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
[entry ID: 0xe, id: 0x00bad0be]   T  h  i  s     s  t  r  i  n  g     i  s    \0
[entry ID: 0xf, id: 0x00000000]   -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -

Found strings: 'es', 'u', ''
Success values: 0, 0, -1
```

#### Part B: String Splitter
For the advanced requirements, you need to extend your String Splitter implementation to implement the `build_substrings` function. This function is very similar to `split_string` except that it must allocate and return the array, rather than storing the substrings (as pointers to the first characters) in a provided array. Also, the number of parsed substrings is stored in a provided address rather than returned:

```c
char ** build_substrings(char *s, char delim, int *num_elts);
```

For example, if `s` points to the string `"abc-def-gh-i"` that begins at address `0x100`, then the call `build_substrings(s, '-', num_ptr)` should allocate a new `char **` with space for five `char *` elements, store `4` in the location pointed to by `num_ptr`, and store the four addresses (see above) followed by `NULL` in the returned `char **`.

**Note:** To test your code, un-comment `#define SS_ADVANCED` in `ss.h`. Then you can re-run `make` and run the same tests as before.

Also note: Typically you need to free any memory you malloc. For this function, you can assume that the caller will do that freeing.

## Submitting your work
To submit this assignment, you should upload your `ds.c` and `ss.c` files to Gradescope; we will use our own `main.c`, `.h` files, and `Makefile` to do our testing and grading.

## Advice
* **Read the function definitions in `ds.h`/`ss.h`. They are there to help you!**

* Start with `split_label` in `ds.c`; you can add function calls to the testing code in `main.c` to try splitting different labels.

* Try to complete the core requirements for one of the programs, then upload to Gradescope to test the upload flow (you should be uploading two `.c` files) and see if that one works -- if you get stuck with one program, switch to the other for a bit!