---
layout: page
title: Empirical Data Recording Intro
permalink: /classes/361-w21/data_intro
---

*(Note: This reading is a work in progress and there may be typos, please let me know if you find any!)*

[Empirical](https://empirical.readthedocs.io/) provides a robust set of tools for [collecting data](https://empirical.readthedocs.io/en/latest/library/data/data.html) from your simulation at regular intervals. We'll look at a few specific approaches to doing so in this reading.

# Include
Empirical's data tools are located in `include/emp/data/DataFile.hpp` and so you'll need to include that in your `World` file:

```
#include "emp/data/DataFile.hpp"
```

# Recording a count
A common thing you'll likely want to do is record how many of something there are in your world every so many timesteps. You will output the count every interval and so don't need your `DataNode` to worry about previous recordings. This is a common enough pattern that there is a built-in version of the `DataNode` that does this called the `DataMonitor`:
```
usingDataMonitor = DataNode<T, data::Current, data::Info, data::Range, data::Stats, MODS...>
```
"A node that stores data about the most recent value it recieved, as well as the distribution (min, max, count, total, and mean) of values it has recieved since the last reset. It also allows you to give it a name, description, and keyword."

If I wanted to save a count of how many symbionts there are in the world in my software [Symbulation](https://github.com/anyaevostinar/SymbulationEmp/blob/master/source/SymWorld.h), I would declare a `DataMonitor` in my `SymWorld` class like so:
```
emp::Ptr<emp::DataMonitor<int>> data_node_symcount;
```

## Destruction
Because C++ doesn't manage memory for us, we need to make sure that our `DataNode`s are cleaned up once our world is done, otherwise we'll get memory leaks. The destructor for a class is called when an object of that class is destroyed and always starts with `~` and then the name of the class (the example  below is for my class `SymWorld`):

```
~SymWorld() {
    if(data_node_symcount) data_node_symcount.Delete();
}
```

DataNodes know how to delete themselves, so as long as the world makes sure to tell them to do so, everything else will be taken care of.

## Initializing the node
There are a number of ways of initializing our data monitor node, but here is one that we'll look at:
```
emp::DataMonitor<int>& GetSymCountDataNode() {
if(!data_node_symcount) {
    data_node_symcount.New();
    OnUpdate([this](size_t){
    data_node_symcount -> Reset();
    for (size_t i = 0; i < pop.size(); i++)
        if(IsOccupied(i))
        data_node_symcount->AddDatum((pop[i]->GetSymbionts()).size());
    });
}
return *data_node_symcount;
}
```

There's a lot going on there, so let's look at each piece. 

```
emp::DataMonitor<int>& GetSymCountDataNode() {
```
Our code is a getter for the actual DataMonitor and so it'll either create it and/or return the initialized instance variable.

```
if(!data_node_symcount) {
    data_node_symcount.New();
```
If the DataMonitor doesn't already exist, we need to create it.

```
OnUpdate([this](size_t){
```
This part is weird and is using a fancy functionality within Empirical called signaling. What it is doing is calling the `World` method `OnUpdate` and passing it a function that should be called everytime the world runs the `update` method. This is a [lambda expression](https://en.cppreference.com/w/cpp/language/lambda) that is capturing `this` which is the world object and the function takes a `size_t` parameter. You don't need to fully understand what is going on in this code, just enough so that you can change it to suit your needs.

```
    data_node_symcount -> Reset();
```
This calls the `Reset` method on the data node, which clears out the current log of data. This makes sure that we are only recording the count for a single update instead of continuing to add every update, which isn't what we want.

```
for (size_t i = 0; i < pop.size(); i++)
        if(IsOccupied(i))
        data_node_symcount->AddDatum((pop[i]->GetSymbionts()).size());
    });
```
This for loop is just looping over the population and finding the occupied spaces. For host in an occupied space, it is adding the count of the symbionts to the data node. Remember that this is the function that will be called every update.

## Setting up the file
We have a data node now but also need to actually get data out of it via a data file. In the interest of modularity, we'll have a method for that as well:

```
emp::DataFile & SetupSymFile(const std::string & filename) {
    auto & file = SetupFile(filename);
    auto & node1 = GetSymCountDataNode();
    file.AddVar(update, "update", "Update");
    file.AddTotal(node1, "count", "Total number of symbionts");

    file.PrintHeaderKeys();

    return file;
  }
```

You could (and we will a bit later) add lots of other data columns to this file. Currently it will print out just two columns, one for the update number and one for the count at that update. 

Let's look at a couple of pieces of this individually.

```
auto & file = SetupFile(filename);
```

`auto` is a C++ keyword that lets you not have to actually say what the type is and is useful for awkwardly long types or such. It doesn't mean that there isn't a type, since C++ is still a strongly-typed language, but in situations where the compiler can figure it out (because SetupFile specifies what it returns), you can use it so you don't have to look it up. Note that you still need to specify that it will be returning a reference with `&`.

`SetupFile` is a method provided by `World` that handle behind the scenes things like opening the file and preparing to write to it. 

```
auto & node1 = GetSymCountDataNode();
```

This line is calling the function we just made earlier in this reading. Arguably we could not save what is returned and just use the instance variable, but it would be less clear that that is what is going on in the method call. It's ultimately a style preference which you do.

```
file.AddVar(update, "update", "Update");
```

`update` is a variable in the `World` class and this function adds a column for recording it.

```
file.AddTotal(node1, "count", "Total number of symbionts");
```
`AddTotal` is a function that grabs the current total value from the data node, and this is why we have to reset the data node every update. The second argument is the header of the column and the third is the explanation of the column.

```
file.PrintHeaderKeys();
```
This method just prints the column header information to the file right away.

## Calling the setup file
You call the method(s) to set up your data file(s) in your `native.cpp` file:
```
world.SetupSymFile("example.data").SetTimingRepeat(10);
```

Since the method `SetupSymFile` returns the file, we can chain method calls and set how frequently we want data written the file with `SetTimingRepeat`, which specifies the interval of updates that should pass between times that the file is written to. What value you put for this will vary quite a bit depending on what you are interested in and how long you are running your experiments. Writing to the file is time consuming and if you are running for a long time, the files can get really big. Generally you want to aim for as infrequent as possible while still achieving your goals. It's also better to be a little more frequent if that data might be helpful once you are confident that you know what experiments you want to run since it's better not to have to redo a run just to get more frequent data timepoints.

# Other kinds of data
We saw how to get count data, but there are a number of other pieces of information you may want and Empirical provides support for most of the common ones.

## Means
Often you will want an average/mean of a behavior value of your population. You do everything the same, but when you add the node to your file, you use the `AddMean` method:
```
file.AddMean(node, "mean_val", "Average symbiont value");
```

It automatically calculates the mean of the values that you've added.

## Histogram data
Averages can obscure interesting information in your data, so it's good to collect distribution data in addition. A good example of this is for a behavior value in my software, the value can be between -1 and 1. I was getting averages of 0, which didn't make sense. What was actually going on was that there was a coexistence of negative and positive values, which was really cool to see!

Getting histogram data to record is a little bit awkward, but supported.

When you create a pointer to the data node, you need to specify that it will be monitoring a histogram as well as a double (if you are going to pull the mean as well):

```
emp::Ptr<emp::DataMonitor<double, emp::data::Histogram>> data_node_orgcoop;
```

Then when setting up the file, if you want the histogram to have a certain number of bins, for example -1 to 1 at 0.1 distances, you would first set them up:

```
node.SetupBins(-1.0, 1.1, 21);
```
If you want it to end at 1, you need to write 1.1 because it follows the convention of being exclusive at the upper range. Also to avoid an uneven amount of the range being in one bin, we need 21 bins instead of 20. You could instead count either 1 or -1 as part of the adjoining bin, there isn't a perfect way to do it.

To then add each of the bins:
```
file.AddHistBin(node, 0, "Hist_-1", "Count for histogram bin -1 to <-0.9");
file.AddHistBin(node, 1, "Hist_-0.9", "Count for histogram bin -0.9 to <-0.8");
file.AddHistBin(node, 2, "Hist_-0.8", "Count for histogram bin -0.8 to <-0.7");
file.AddHistBin(node, 3, "Hist_-0.7", "Count for histogram bin -0.7 to <-0.6");
file.AddHistBin(node, 4, "Hist_-0.6", "Count for histogram bin -0.6 to <-0.5");
file.AddHistBin(node, 5, "Hist_-0.5", "Count for histogram bin -0.5 to <-0.4");
file.AddHistBin(node, 6, "Hist_-0.4", "Count for histogram bin -0.4 to <-0.3");
file.AddHistBin(node, 7, "Hist_-0.3", "Count for histogram bin -0.3 to <-0.2");
file.AddHistBin(node, 8, "Hist_-0.2", "Count for histogram bin -0.2 to <-0.1");
file.AddHistBin(node, 9, "Hist_-0.1", "Count for histogram bin -0.1 to <0.0");
file.AddHistBin(node, 10, "Hist_0.0", "Count for histogram bin 0.0 to <0.1");
file.AddHistBin(node, 11, "Hist_0.1", "Count for histogram bin 0.1 to <0.2");
file.AddHistBin(node, 12, "Hist_0.2", "Count for histogram bin 0.2 to <0.3");
file.AddHistBin(node, 13, "Hist_0.3", "Count for histogram bin 0.3 to <0.4");
file.AddHistBin(node, 14, "Hist_0.4", "Count for histogram bin 0.4 to <0.5");
file.AddHistBin(node, 15, "Hist_0.5", "Count for histogram bin 0.5 to <0.6");
file.AddHistBin(node, 16, "Hist_0.6", "Count for histogram bin 0.6 to <0.7");
file.AddHistBin(node, 17, "Hist_0.7", "Count for histogram bin 0.7 to <0.8");
file.AddHistBin(node, 18, "Hist_0.8", "Count for histogram bin 0.8 to <0.9");
file.AddHistBin(node, 19, "Hist_0.9", "Count for histogram bin 0.9 to 1.0");
```
Like I said, not beautiful, but functional. This will then give you the count of values that fall into each range.

There are even more things (such as min, max, median, percentile, etc) supported and feel free to look through the [documentation for the DataFile](https://empirical.readthedocs.io/en/latest/api/classemp_1_1DataFile.html) to see them.
