---
layout: page
title: Empirical Config Lab
permalink: /classes/361-f22/emp_config_lab
---

## Goals
To use Empirical's configuration management system in a command-line and web-version of a project.

## Setup
Follow the [usual steps](gradient-lab) for setting up a repository using Empirical and emsdk using the Configuration Lab starter code.

## Exercise 1
I've provided you with a basic artificial life simulation with just one species reproducing and filling the world (following the first few exercises of the [Empirical intro lab](empirical_intro_lab)). You can run `compile-run.sh` to get a command line version of the program and `compile-run-web.sh` to get a web version.

We'll start with making a configuration management system for the command-line version.

1. Following the [steps in the reading](config_intro), make a configuration system that handles at least:
    * The random number seed
    * The number of starting organisms in the world (you'll have to update the code to make this work)

2. Make sure that you can control these settings both through the "MySettings.cfg" file and through the command line.

## Exercise 2
Because Empirical supports cross-compilation, you can use the same configuration system for the web-based version of your program and Empirical even has several pre-made ways to make your configuration settings look nice on your web page!

1. It wouldn't be great to just copy and paste your configuration type declaration into `web.cpp`. Instead, you should put it into its own header file that can be included in both versions. Move the `EMP_BUILD_CONFIG()` to a new file `ConfigSetup.h` and include that in both `native.cpp` and `web.cpp` (it would be good to confirm that the native version still works at this point).

2. Your configuration object needs to exist outside of the animator class, like your `Document`, so add `MyConfigType config;` just under your declaration of your `Document` at the top of `web.cc`.

3. Empirical provides several [prefabricated UI elements](https://devosoft.github.io/empirical-prefab-demo/empirical-prefab-demo) to make development easier. We're going to use the `ConfigPanel` element. First though, we need to include some new files from Empirical:

    ```cpp
    #include "emp/config/ArgManager.hpp"
    #include "emp/prefab/ConfigPanel.hpp"
    #include "emp/web/UrlParams.hpp"
    ```

4. The config panel uses the URL to set and load configuration values when the webpage is loaded. The following code is necessary for this to work, though it's a bit complicated what it is actually doing, so don't worry about the specifics. Place this in the constructor for the animator:

    ```cpp
    // apply configuration query params and config files to config
    auto specs = emp::ArgManager::make_builtin_specs(&config);
    emp::ArgManager am(emp::web::GetUrlParams(), specs);
    am.UseCallbacks();
    if (am.HasUnused()) std::exit(EXIT_FAILURE);
    ```

5. Finally, we need to actually create the `ConfigPanel` object that will be tied to our existing `config` object and place it in the webpage:

    ```cpp
    // setup configuration panel
    emp::prefab::ConfigPanel config_panel(config);
    doc << config_panel;
    ```

6. At this point, you should build and view your page. You should see a somewhat comically large configuration panel along with the existing animation. The configuration panel won't actually control the animation yet though, but you can move the sliders and see how the URL parameters work.

## Exercise 3
You still need to change the provided `web.cpp` code so that it actually uses the configuration values. That process is the exact same as you did for the `native.cpp` version though, since you can interact with `config` the same way. Edit the code so that it uses the two configuration values correctly (this will be very similar to what you have in `native.cpp`). Make sure to test out the webpage to see it working at this point.

## Exercise 4
You might not be loving the layout that you currently have for this website. While this class isn't focused on HTML, a little bit of HTML (and [Bootstrap](https://getbootstrap.com/)) will help a lot in making the layout a bit better.

1. Open `index.html`. Most of what you see are external Javascript files that are being used to make the prefab configuration panel look nice. Skip down to the `<body>` tag.

2. HTML uses the `div` tag to mark out sections of a page and the Bootstrap toolkit defines a bunch of different `class`es of tags that have pre-set formatting for you to use. To make a basic page that looks a bit nicer, we'll use these. The existing `<div id="target">` is what hooks up your `Document` to the webpage (remember that `"target"` parameter that you have to pass when you make a `Document`?). 

3. First, place the tag `<div class="container"> </div>` around your existing `<div id="target">`, so that your body looks like this:

    ```html
    <body>
        <div class="container">
            <div id="target"> </div>
        </div>
    </body>
    ```

    Then refresh your page to take a look at what that changes.

4. It'd be nice to have the settings to the side of the canvas, and you can do that with a combination of changes. First, we're going to need a `row` and a couple of `col` (columns) within that row:

    ```html
    <body>
        <div class="container">
            <div class="row">
                <div class="col">
                    <div id="target"> </div>
                </div>
                <div class="col">
                </div>
            </div>
        </div>
    </body>
    ```

    You should now see your canvas in just the left column instead of the whole page.

5. Next, we're going to make a new `id` to hook the settings to and put that in the second column. Within the second `col` div tags, put `<div id="settings"></div>`

6. Now we need to go use that hook. Open `web.cpp` and add a new `Document` under your original `doc` that uses the `settings` id tag:

    ```cpp
    emp::web::Document doc("target");
    emp::web::Document settings("settings");
    ```

7. Finally, go down to where you had been putting `config_panel` into `doc` and put it into `settings` instead:

    ```cpp
    settings << config_panel;
    ```

    You should now recompile and see your settings panel in the right hand column.

8. You can make as many `id`s that you hook `Document`s to as you want. Try making one for your buttons so you can place them underneath of your canvas.

## Exercise 5
While the config panel is pretty good at picking ranges that are reasonable, it isn't perfect and you might want to force the range to something you know is correct.

1. You can set the range for a configuration setting on the panel using the `SetRange` method, though it takes only strings, which you probably don't expect. For example, to set the range of a configuration option `NUM_START` that holds an integer and should only be 1 or 2, I would do:

    ```cpp
    config_panel.SetRange("NUM_START", "1", "2");
    ```

2. You can also exclude settings from the panel that are useful for the native version of your program but not appropriate for the web GUI using `ExcludeSetting(setting_to_exclude);`. Try hiding the random number seed from the panel.

3. If you have some familiarity with CSS, you can adjust the default style settings through your C++ with the `SetCSS()` method. For example, you could do `settings.SetCSS("max-width", "500px");` to keep the settings document from stretching beyond 500 pixels. Explore some of the [CSS properties](https://www.w3schools.com/cssref/pr_dim_max-width.asp) that you might want to change.

## Extra
There are a bunch of other prefabricated GUI elements that you can use now that you are set up. Check out [this demonstration of each of them](https://devosoft.github.io/empirical-prefab-demo/empirical-prefab-demo) and try adding some more!