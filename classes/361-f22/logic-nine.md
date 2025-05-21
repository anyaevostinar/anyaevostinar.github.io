---
layout: page
title: Logic 9 Tasks Guide
permalink: /classes/361-s25/logic-nine
---

## Overview
Many of you are doing 'classic' Avida experiments for your final project and therefore will want to be using the 'logic 9' tasks. There are a few adjustments you'll need to make to the starter code for the digital evolution assignment to achieve this, which are outlined here.

## Float to Int
The logic 9 tasks can't be performed on floats, so you'll need to change it so that organisms get and work with unsigned integers instead. To do this, you'll need to make changes to:

* `OrgState.h`
* `Instructions.h`
* `Task.h`

### OrgState
Within `OrgState.h`, you should change `float` to `uint32_t` for `last_inputs` and `add_input`.

### Instructions
Within `Instructions.h`, you should change `float` to `uint32_t` within the `IOInstruction` struct. This includes the type of `output` and the type of `input`. 

You'll also need to change how the new input value is randomly generated to be:

```cpp
uint32_t input = sgpl::tlrand.Get().GetUInt();
```

### Task
Within `Task.h`, you should change `float` to `uint32_t` in the parameters for the `CheckOutput` method of the `Task` class for both `output` and `inputs`. You'll also then use the new parameter types for the new tasks that you'll make soon.

## New Tasks
With this change, the good news is that calculating the logic tasks is actually pretty simple for us computer programmers (less so for the organisms). You don't have to worry about floating point numbers not being equal, so you can just use the normal `==` for checking equality. For example, the `NOT` task would be:

```cpp
class NOT : public Task {
public:
  double CheckOutput(uint32_t output, uint32_t inputs[4]) override {
    // did they calculate NOT of a number?
    for (int i = 0; i < 4; i++) {
    uint32_t not_val = ~inputs[i]; //~ is bitwise NOT in C++
      if (not_val == output) {
        // 10 points for success
        return 10.0;
    }
    // 0 points for failure
    return 0.0;
  }

  std::string name() const override { return "NOT"; }
};
```

The rest of the logic nine tasks are:
* NAND `~(x & y)`
* AND `x & y`
* ORN `x | ~y`
* OR `x | y`
* ANDN `x & ~y`
* NOR `~(x | y)`
* XOR `x ^ y`
* EQU `~(x ^ y)`

You'll want to make sure you're wrapping around the input buffer for the binary tasks.

## New Instructions
Finally, the arithmetic library is not the one that Avida generally provided to organisms. SGP-Lite has a `CompleteOpLibrary` prefab that you can switch to for now, though it will have a lot more than the instructions that Avida would have provided, so you may find your organisms having an easier time than they should. The [default instruction set included](https://journals.plos.org/plosone/article?id=10.1371/journal.pone.0083242):
* add
* sub
* decrement
* increment
* nand
* nop-A
* nop-B
* nop-C
* shift-r
* shift-l
* swap

It's fine to use the complete op library from SGP-Lite, but if you're interested in sticking more closely to the original default instruction set, go for it and check out the [other guide](instructions-guide) for how to make your own instructions.

