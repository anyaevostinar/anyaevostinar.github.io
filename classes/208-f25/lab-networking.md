---
layout: page
title: Networking Lab
permalink: /classes/208-f25/networking-lab
---

## Goals
Your primary goal for this lab is to write a simple socket-based client to connect to a given server.

## Getting started
First, download the [`networking.tar`](/classes/208-f25/networking.tar) file to get the code for the lab. Make sure you are on `mantis`.

```bash
wget https://anyaevostinar.github.io/classes/208-f25/networking.tar
```

Copy it into a folder for today’s lab, and then un-tar the file:

```bash
tar xvf networking.tar
```

You should find the following files in a folder `sockets_lab`:

* `client.c`: The client code you’ll be modifying.
* `common.h`: Some useful `#define`s used by both the client and the server.
* `server.c`: The code for the server you’ll be connecting to.

## Part 1: Read through what you’ve got to work with
Take a look through `server.c`, trying to get a feel for how it sets up its end of the socket(s) to accept connection(s).

Then, look at `client.c`. There are a bunch of `// TODO`s for you to fill in.

Think back on what we talked about today – how will the client and server interact? Can multiple users interact with the server at the same time?

## Part 2: Implementing a socket-based client
Now you’ll actually implement your client. Again, make sure you’re on `mantis`, or this will be less exciting (by some definitions of exciting :) ). Try compiling your code after each step below, and make sure to run it once you think it works.

1. Find the comment `// 1) TODO` in `client.c`. You need to add code to call `socket()` to create a UDP socket. Take a look at `server.c` for an example. [This page](https://man7.org/linux/man-pages/man2/socket.2.html) might also be helpful.

2. Find the comment `// 2) TODO` in `client.c`. Now, you need to use `connect()` to connect to the server using the `servaddr` info. Don’t forget to check for errors! [This page](https://man7.org/linux/man-pages/man2/connect.2.html) might be helpful.

    Note: [This page](https://beej.us/guide/bgnet/html/split-wide/system-calls-or-bust.html#connect) might also be really helpful in figuring out how to use `connect()`. We aren’t using `getaddrinfo` here, but you can get away with casting a `struct sockaddr_in *` as `struct sockadd *`. You also might find it handy to compare to the `bind()` call in `server.c`.

3. Find the comment `// 3) TODO` in `client.c`. Add a call to `send()` the message. This should be analagous to the `recv` call in `client.c`, but you don’t need the loop. You should store the return value in a variable named `sent_bytes`.

4. Un-comment the line after `// 4) TODO` to print out the number of bytes sent.

Try running it – check the screen up front to see if the server receives your message!

## Part 3: Next steps
Once you have all that, play around some more!

* Find the `// 5) TODO` comment and maybe prompt the user to type a message to send (read it with `scanf()` or `fgets()` (but NOT `gets`), or maybe take the message as a command-line argument.

* Maybe try setting up a loop to continually prompt the user to type new messages, sending each one.