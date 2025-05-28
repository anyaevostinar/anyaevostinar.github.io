---
layout: page
title: FAQ
permalink: /classes/361-s25/faq
---

Here is a running list of questions that have come up and I suspect will come up again, feel free to comment with additional ones!

*Should I worry about the warning when I build?*   
* Nope, that's expected

*I'm getting an error about emcc not found*
* You probably forgot to do 'source ./emsdk_env.sh'

*I'm not seeing anything at 0.0.0.0:8000 on Windows WSL*
* You should go to localhost:8000 in your browser instead

*There's nothing in the Empirical and emsdk folders/I'm getting errors about files not found*
* You probably forgot to update the submodules after cloning

*I'm getting Permission denied when trying to compile and run my code or emsdk on Mac*
* You just need to change the permissions on the file with chmod +x filename

*I'm getting an error about -march=native when I try to run the compile-run.sh script.*
* Certain computers don't support this option, which I realized only after sending starter code out to you all. Open compile-run.sh and replace -march=native with -msse4.2

*When I run my web version, it crashes after a bit with an error about memory allocation.*
* You are using more memory than the browser thinks you should be. Make sure you aren't making excessive copies of things (and make sure that you are clearing your canvas each frame), but you can also increase the amount of memory the browser lets you use by opening compile-run.sh and adding -s TOTAL_MEMORY=268435456 just before AEAnimate.cpp. If you're still running out of memory, you should try to find where that might be happening since you should be able to work within that amount.

*I'm getting "Segmentation fault" when running native, how to fix?*
* "segfaults" mean that you are accessing memory that you shouldn't be. They are difficult to debug because you don't by default get much information about where the error is happening. There are several ways of finding the location of the problem. lldb or gdb are good tools depending on your operating system (lldb comes with Mac, gdb is the normal one to use with WSL). [Guide that previous course staff made.](GDB_Instructions.pdf)