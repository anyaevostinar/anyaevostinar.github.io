---
layout: page
title: Instructions Guide
permalink: /classes/361-s25/instructions-guide
---

## Overview
Many of you are using the SGP-Lite framework and will be needing to make new instructions. This guide is aimed at explaining the syntax for doing so.

## Instruction syntax
The general syntax of an instruction is the following:

```cpp
struct NAME { //struct is similar to class but everything is default public
    template <typename Spec>
    static void run(sgpl::Core<Spec> &core, const sgpl::Instruction<Spec> &inst,
                  const sgpl::Program<Spec> &,
                  typename Spec::peripheral_t &state) noexcept {

        //Whatever you want to happen when the instruction is executed by the organism

    }

    static std::string name() { return "NAME"; } //Whatever you want the human readable name to be
    static size_t prevalence() { return 1; } //How prevalent you want this instruction to be relative to others, 1 is a good value
}
```

## Parameters
There are quite a few complicated parameters that an instruction's `run` has access to and you might want to use. The provided `IOInstruction` demonstrates using the important ones:

```cpp
uint32_t output = core.registers[inst.args[0]];
```

To access the values in the organism's registers, you get the registers through the `core` with `core.registers`. This is basically an array so you can access it with `[]` as you would expect.
Typically you want to access the register that the instruction specified. 
You can access information about the instruction that the organism just executed through the `inst` parameter and specifically find out about which of the registers the instruction was trying to act on by indexing into `inst.args`.

For example, if the organism had just done `io          r3`, `inst.args[0]` would return the `r3` register information, which is then used to look up what is in that register with `core.registers[inst.args[0]]`.

You can also make changes to what is in any of the organism's registers, for example when IO gets a new random number and puts it into the same register:

```cpp
uint32_t input = sgpl::tlrand.Get().GetUInt();
core.registers[inst.args[0]] = input;
```

You can access your `World` subclass through the `state` parameter with `state.world`, for instance when IO checks if the organism solved a task with `CheckOutput`: 

```cpp
state.world->CheckOutput(output, state);
```

## Adding to library
Once you've made your new instructions, you just need to add them to the type declaration for your `Library` at the end of `Instructions.h`:

```cpp
using Library = sgpl::OpLibraryCoupler<sgpl::CompleteOpLibrary, IOInstruction,
                           ReproduceInstruction, NewInstruction, OtherNewInstruction>;
                           //Just add a comma and your instruction name with the <>
```

## Printing nicely
Since the printing of the genome is a custom method in the starter code, any instructions you add, including using more of the SGP-Lite provided instructions, will need to be added to the print genome functionality.

In `CPU.h`, there is a method `PrintGenome` that creates a map of instruction names and how many registers the instruction uses ("arity"). To add a new instruction, just add a new pair to this map:

```cpp
{%raw %}
std::map<std::string, size_t> arities{{"Multiply", 3}, {"Add", 3},
                                          {"Subtract", 3}, {"Divide", 3},
                                          {"IO", 1},       {"Reproduce", 0}, 
                                          {"NEW", 3}}; //NEW instruction uses 3 registers
{%endraw %}
```

## Avida Instruction Set
To get close to the original default Avida instruction set, I recommend grabbing the following from SGP-Lite (it's not a perfect list or a perfect match, but will get your organisms started, feel free to play around with others from the [CompleteOpLibrary](https://github.com/mmore500/signalgp-lite/blob/master/include/sgpl/library/prefab/CompleteOpLibrary.hpp)):

* sgpl::Nop<0>
* sgpl::Nop<1>
* sgpl::Nop<2>
* sgpl::BitwiseShift
* sgpl::Increment
* sgpl::Decrement
* sgpl::Add
* sgpl::Subtract
* sgpl::global::JumpIfNot
* sgpl::local::JumpIfNot
* sgpl::global::Anchor

And making a `Nand` instruction, with the following internal logic:

```cpp

uint32_t reg_b = core.registers[inst.args[1]]; //grab value from second register
uint32_t reg_c = core.registers[inst.args[2]]; //grab value from third register
uint32_t nand_val = ~(reg_b & reg_c); //compute NAND

core.registers[inst.args[0]] = nand_val; //place NAND value in first register
```