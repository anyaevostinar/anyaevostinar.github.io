---
layout: page
title: Empirical Configuration Management
permalink: /classes/361-w21/config_intro
---

*(Note: This reading is a work in progress and there may be typos, please let me know if you find any!)*

Needing to recompile every time you change a variable value in a simulation is not ideal and can make it difficult to track what values you had when you got specific data.
Instead, you can have a file of these values that your code references so that you can change values at run time.
The use of a configuration file is very common and slightly annoying to setup, so Empirical provides a set of tools through the [`ArgManager`](https://empirical.readthedocs.io/en/latest/api/classemp_1_1ArgManager.html) class that handles both a configuration file for settings as well as support for overriding those values at the command line and URL when using a GUI.

## Include
The `ArgManager` is in the `config` directory of Empirical and so you need the following include statement:
```
#include "emp/config/ArgManager.hpp"
```

## Creating your config object
Empirical provides a way to make a class at compile time for your configuration manager. The macro `EMP_BUILD_CONFIG` is what does this. **Outside of any function** in your `native.cpp` file, you would put:
```
EMP_BUILD_CONFIG(MyConfigType,
    VALUE(SEED, int, 10, "What value should the random seed be?"), 
    VALUE(START_PROB, double, 0.5, "What cooperation probability value should the starting organism have?"),
    VALUE(FILE_NAME, std::string, "_data.dat", "Root output file name")
)
```

This creates the type `MyConfigType` and gives it three instance variables, `SEED`, `START_PROB`, and `FILE_NAME` with the respective types and default values.

In your `main` function in your `native.cpp` file, you can then declare your configuration object:
```
MyConfigType config;
```

And have it read in all the settings from a file in the top level of your project's directory:

```
config.Read("MySettings.cfg");
```

It'd be nice to check if the file is read in successfully, and if not, write out the default configuration file. You can do so like this:
```
bool success = config.Read("MySettings.cfg");
if(!success) config.Write("MySettings.cfg");
```


## Accessing config values
Getter methods are automatically created for each of the instance variables in your configuration object, so to access and use the random seed number for example, you would type:
```
emp::Random random(config.SEED());
```

You can also pass this configuration object to your organisms so that they can access all the settings directly, which can lead to much cleaner code!

## Command line arguments
You can also easily override the settings in your settings file with command line arguments, which is very useful when you want to automatically run a range of parameter settings. 

To get command line arguments to override your config settings along with a helpful error message, you type:
```
auto args = emp::cl::ArgManager(argc, argv);
if (args.ProcessConfigOptions(config, std::cout, "MySettings.cfg") == false) {
cerr << "There was a problem in processing the options file." << endl;
exit(1);
}
if (args.TestUnknown() == false) {
cerr << "Leftover args no good." << endl;
exit(1);
}
```

To then enter a command line argument for one of your settings such as your FILE_NAME, you should type:

```
./evo-algo -FILE_NAME "hi"
```

## Naming data files well
Now that you can run your simulation with different command line arguments, it would be good to make sure that your data files are named after the settings that you are going to be changing so that you can easily save all your data and are unlikely to accidentally overwrite some of it.

The most basic thing that you should include in your data file name is the random number seed:
```
world.SetupOrgFile("OrgValues_"+config.SEED()+config.FILE_NAME());
```

If you were varying the value of a variable to see what effect that had on a trait of the organisms, you should add that to your file name as well. 
It's much better to have files named automatically to track the important values than to rely on you remembering to change the file names correctly every time, trust me!

## Submitting
Click 'Submit' in the upper right corner of your project and **on Moodle paste in the link to your project**.

## Extensions
Continue working on your project! Feel free to grab whatever code from the labs and examples that is useful. Empirical has a [number of example projects](https://github.com/devosoft/Empirical/tree/master/examples/Evolve) that may be useful as well.