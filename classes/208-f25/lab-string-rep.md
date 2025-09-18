---
layout: page
title: String Representation Lab
permalink: /classes/208-f25/string-rep-lab
---

This is a short lab exploring how Unicode codepoints can be stored.

There will likely be parts of this lab that you don't understand right away.  Keep reading, keep experimenting, collect your questions, and ask them!  Gradually, things will start to make more sense.

## Character encodings

Do the following.  Remember to collect questions, play around, and take notes.

* Connect to `mantis` through `fern`

* Create a new text file named `something.txt`.  Type two or three short lines of ASCII text (e.g., just a few English words) and save your file.

* In the terminal, make sure you are `cd`'d into the directory containing `something.txt` and run this command:

    ```bash
    hexdump -C something.txt
    ```

* Do the hex values you see in your file correspond to the characters you entered?  Do the characters come in the order you expect?  Do you see any newline characters?  (You may find it helpful to open an [ASCII chart](https://simple.wikipedia.org/wiki/ASCII) in a browser tab or view the chart in a terminal by running `man ascii`.)

* Copy the word `"résumé"` and the Greek letters `"αβγδ"` from this page into `something.txt`.  Note that `é` and the Greek letters are not ASCII characters.  Save and run `hexdump -C something.txt` again.  Which bytes correspond to `é`, `α`, `β`, `γ`, and `δ`?

Now, let's explore some [alternate encodings](https://xkcd.com/927/).

<!-- !!!! This is broken and needs to be updated to work for fern -->
* Change the encoding from  `UTF-8` to `UTF-16LE` with this command:

    ```bash
    iconv -f UTF-8 -t UTF-16LE -o something16le.txt something.txt
    ```

* Run `hexdump -C` on your new file.

* **Answer this** to submit: Copy over both your hexdumps and explain what changed with the new encoding.

* Now switch to UTF-16BE with the following command:

    ```bash
    iconv -f UTF-8 -t UTF-16BE -o something16be.txt something.txt
    ```

* Run `hexdump -C` on your new file.  

* **Ansewr this** to submit: Copy over your new hexdump and explain what changed.  Which byes correspond to which characters?  How is this different from UTF-8?  What about UTF-16 LE?

* You are hopefully starting to make some sense of the difference between _Unicode codepoints_ and the _character encodings_ using different encoding formats, like UTF-8, UTF-16 LE, and UTF-16 BE.  If these are still fuzzy, do a little internet exploration (after class) to figure out the differences between them.

## String functions
Look through the sample code `strings.c` (remember to find the sample code, go to the link on the right bar of Moodle), run each of the "games", and read through the comments.