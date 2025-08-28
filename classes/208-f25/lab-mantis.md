---
layout: page
title: Mantis Lab
permalink: /classes/208-f25/mantis-lab
---

## Overview

In this class, we will learn about computer systems in part by using the C programming language and exploring its relationship to the Intel x86-64 machine language and assembly language. To ensure that we all have a consistent computing environment, you should plan to do your work on the CS department’s Linux server `mantis.mathcs.carleton.edu`. This short lab will help you get started working on `mantis` by connecting from another computer. (Note: For some assignments, you’ll be able to use your own laptop without the extra step of connecting to `mantis`, but the only supported computing environment for actually running your code in this course will be `mantis`.)

## Step 1: Connect to `fern`

(If you are used to using VSCode to connect to servers, sorry, you can't anymore because VSCode ultimately crashes the server due to a bug.)
(If you get stuck, there are screenshots in [this guide](https://stolafcarleton.teamdynamix.com/TDClient/3356/Portal/KB/ArticleDet?ID=168271).)

**Go** to [https://fern.mathcs.carleton.edu/jupyter/hub/login](https://fern.mathcs.carleton.edu/jupyter/hub/login) and log in with your Carleton credentials

`fern` shares a filesystem with all the other servers and so you'll possibly see things from previous classes and anything you do on `fern` will also show up on `mantis`.


## Step 2: Set up your working space on the file system

* **Open a `Terminal`** by clicking the icon with a $ sign and a black box.

* **Set up a long-term working directory named cs208:** In that terminal, create a folder named `cs208`, where you will do your work for the term:

    ```bash
    mkdir cs208
    ```

    If you type the command `ls` in the terminal after that (and then hit enter/return), you’ll see the new folder listed. You can also look at the file explorer, and the folder should show up there, too.

## Step 3: Log in to `mantis`

In the Terminal, type 
```bash
ssh YOUR_USER_NAME@mantis.mathcs.carleton.edu
```

And then your password. This is where you would be able to run your files for this class after you edit them on `fern`.

## A typical work session
You’re all set up now, and you won’t need to repeat most of the previous steps anymore. This section describes a typical session with VS Code and `mantis`.

1. **Restart, but with the `cs208` working directory:** The next time you log in to `fern`, the folder will already be there and so you can open it and interact with the files inside as usual.

2. **Start a new program:** Go to `File->New Python File`. Type a hello-world program (e.g., `hello.py` with a single print statement). Save the file.

**NOTE:** You should get into the habit of saving frequently, as it may not autosave for you.

3. **Test your program:** Connect to `mantis` via ssh and in the `mantis` terminal, type a suitable command (e.g., `python3 hello.py`) to run your program.

4. **Pause to reflect:** Ponder the following questions and submit answers to them on Moodle for an engagement credit:

* Where is your `hello.py` file stored? 

* Will your file still be on `mantis` after you close the browser window?

* Is there a copy on your computer after you close the browser window?

5. **Download a file from `mantis`:** Copy a file from `mantis` to your local computer (e.g., so you can submit homework via Moodle in your web browser). To do so, in the `fern` file explorer, right-click on the file you want to download and select `Download` from the right-click menu. There doesn’t seem to be a drag-and-drop option for this.

6. **Upload a file to `mantis`:** Open the folder containing your file (e.g., `new_hello.c`) on your local machine. This will be a Windows Explorer, macOS Finder, or Linux folder display. Drag the icon of your file into the files panel on `fern`.

## Next steps
Now that you’re able to connect to `mantis`, you’re almost ready to work on the first assignment! Take a look at [Assignment 1 - Bits & Bytes](hw1) to get an idea of what you need to do, and then upload a few [samples](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/samples/), compile, and run them on mantis.

After you’ve tried some samples, you can get started with Assignment 1. Follow the instructions on the assignment page for getting the code and testing it out.

## If you can't connect to `fern`

`mantis` might get overwhelmed with connections during the term. If that happens, don't get stuck. You don't need `fern` to work on `mantis`!

### Getting a Terminal
If you are on Mac, open the `Terminal` app separate from VSCode (it's just called Terminal). If you are on Windows, you can use several things, including Command Prompt or [Windows Terminal](https://learn.microsoft.com/en-us/windows/terminal/install).

### SSH
You can connect just the same way, type in:
```bash
ssh YOUR_CARLETON_USER_NAME@mantis.mathcs.carleton.edu
```

And then your password (don't worry that it looks like you aren't typing, just keep typing and hit enter).

### Running files
You now run everything just like you would through `fern`'s Terminal, yey!

### Editing files
The tricky part is editing files. You can either explore using [Emacs](https://quickref.me/emacs.html) or [Vi](https://www.atmos.albany.edu/daes/atmclasses/atm350/vi_cheat_sheet.pdf) or you can download to your local computer, make changes, and then upload back to `mantis`.

* To download a file, you use `scp`:
```bash
scp your_username@mantis.mathcs.carleton.edu:/Accounts/YOUR_USER_NAME/cs208/YOUR_FILE WHERE_YOU_WANT_IT_TO_GO
```

* To send a file, just reverse the commands:
```bash
scp LOCAL_FILE_TO_SEND your_username@mantis.mathcs.carleton.edu:/Accounts/YOUR_USER_NAME/cs208/YOUR_FILE
```