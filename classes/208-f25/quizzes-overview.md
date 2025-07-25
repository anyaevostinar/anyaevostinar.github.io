---
layout: page
title: Exams Overview
permalink: /classes/208-sf25/exams-overview
---

## Exam Structure
As discussed in the [syllabus](syllabus), the exams in this class are meant to assess your proficiency on a specific set of learning objectives.
Each exam will have a posted set of learning objectives that you can demonstrate your understanding of for that quiz, and each learning objective will appear on at least 2 exams.

## Quiz Learning Objectives
The learning objectives that will be on exams are:

### Number representations
* NR1: Using binary notation
    * Core: Converting from unsigned binary to decimal
    * Advanced: Converting from unsigned binary to hexademical
* NR2: Using hexadecimal notation
    * Core: Converting from hexadecimal to binary and decimal
    * Advanced: Adding/Subtracting two hexadecimal numbers
* NR3: Using 2's complement representation
    * Core: Negating a binary value with 2's complement
    * Advanced: Converting from decimal to 2's complement

### Data representations
* DR1: Struct layout
    * Core: Demonstrate how a struct is stored in memory with arrays (no buffer bytes)
    * Advanced: Demonstrate how a struct is stored in memory with buffer bytes and/or unions
* DR2: Array layout
    * Core: Demonstrate how elements of an array are stored in memory
    * Advanced: Demonstrate how complex elements (e.g. structs with nested arrays) of an array are stored in memory
* DR3: Encoding UTF-8 (with table provided)
    * Core: Encode a codepoint (given the byte count)
    * Advanced: Encode a codepoint and determine the appropriate byte count
* DR4: Decoding UTF-8 (with table provided)
    * Core: Decode an encoded byte sequence (<= 2 bytes)
    * Advanced: Decode a multi-character encoded byte seqeuence (any byte count)
* DR5: Interpreting char arrays
    * Core: Explain how bytes are interpreted with `%c` and `%d`
    * Advanced: Explain how bytes are interpreted with `%c`, `%d`, `%x`, `%s`, and `%p`
* DR6: Integer byte ordering
    * Core: Demonstrate how an integer is stored in big- and little-endian
    * Advanced: Demonstrate how an array of integers are stored in big- and little-endian
* DR7: C Strings
    * Core: Demonstrate the use of `\0` to null-terminate a string
    * Advanced: Explain the difference and risks between `strcpy` and `strncpy`
* DR8: Using pointers
    * Core: Demonstrate the difference between a value and its address
    * Advanced: Demonstrate how pointers are stored in memory

### Operators
* OP1: Bitwise and logical
    * Core: Perform a given bitwise/logical operation
    * Advanced: Provide bitwise/logical operations for a given affect (e.g. via masking)
* OP2: Shift
    * Core: Perform a given logical shift operation
    * Advanced: Perform a given arithmetic shift operation
* OP3: Resizing
    * Core: Resize an integer value to a small size
    * Advanced: Resize an integer value to a larger size (signed or unsigned)
* OP4: Overflow
    * Core: Identify when overflow will occur in addition
    * Advanced: Identify when overflow will occur in addition or subtraction and perform the computation
* OP5: Addressing and dereferencing
    * Core: Identify incorrect use of `&` and `*` operators
    * Advanced: Demonstrate the correct use of `&` and `*` operators
* OP6: Pointer arithmetic
    * Core: Use addresses of members of a struct or elements in a `char` array correctly
    * Advanced: Use addresses of complex elements (or their parts) of an array correctly

### Assembly Instructions
* AI1: Interpreting assembly addressing modes
    * Core: Interpret operands with constants, registers, and basic memory lookups
    * Advanced: Interpret operands with offsets, indexing, and scaling
* AI2: Move instructions
    * Core: Determine the type/operands of `mov` instructions
    * Advanced: Interpret `mov` instructions
* AI3: Arithmetic instructions
    * Core: Interpret a basic arithmetic instruction
    * Advanced: Interpret an arithmetic instruction with condition codes
* AI4: Pointer arithmetic
    * Core: Interpret instructions using pointer arithmetic
    * Advanced: Provide instruction(s) given array/struct statement(s)
* AI5: Jump instructions
    * Core: Determine the outcome of a cmp jump sequence
    * Advanced: Determine the outcome of a test jump sequence
* AI6: Stack
    * Core: Identify locations on the stack with offsets
    * Advanced: Draw the stack given push/pop/add/sub instruction(s)

### Assembly code
* AC1: Control patterns
    * Core: Distinguish between recursion/looping/branching
    * Advanced: Distinguish the specific type of loop/branching
* AC2: Functionality
    * Core: Identify parameter count/types and return type of given a given assembly program
    * Advanced: Describe the functionality of a given assembly program
* AC3: Reverse engineering
    * Core: Reconstruct part of a C program from the given assembly
    * Advanced: Reconstruct all of a C program from given assembly

### Security
* SEC1: Trusting trust
    * Core: Provide a high-level explanation of the trusting-trust attack
    * Advanced: Provide a deep explanation of the trusting-trust attack or defense
* SEC2: Buffer overflows
    * Core: Provide a high-level explanation of buffer-overflow attack and defense
    * Advanced: Interpret or provide string input to cause a buffer-overflow attack

### Networking
* NW1: DNS
    * Core: Provide a high-level explanation of DNS
    * Advanced: Provide a deep explanation of DNS or an attack against it

### Operating Systems
* OS1: File systems
    * Core: Provide a relative path for a given file system structure
    * Advanced: Provide Unix commands with redirection and/or piping
* OS2: Fork
    * Core: Interpret programs with one fork call
    * Advanced: Interpret programs with multiple fork calls

### Memory Hierarchies
* MH1: Addresses
    * Core: Interpret given cache parameters
    * Advanced: Interpret given addresses
* MH2: Cache impact
    * Core: Provide a high-level explanation of cache benefits
    * Advanced: Explain the performance implications of loop ordering


You can see how you are doing on each of these on Moodle under the "Grades" tab.
