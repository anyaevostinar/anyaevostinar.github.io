---
layout: page
title: C++ References and Pointers Reference Sheet
permalink: /classes/361-w21/ref_pointer_ref
---

In case you want to quickly reference the code from the video that you watched on References and Pointers, here it is. This is not a substitute for watching the video!

```
int a = 5;
cout << a << endl;
cout << &a << endl;

string b = "Ham Sandwich";
cout << b << endl;
cout << &b << endl;
```

```
int a = 5;
int& my_ref = a;
cout << a << endl; 
cout << my_ref << endl; 
cout << &a << endl; 
cout << &my_ref << endl; 
```

```
int a = 5;
cout << *&*&a << endl; 
```

```
int a = 5;
int* p1 = &a;
int* p2 = &a;
cout << &a << endl;
cout << p1 << endl;
cout << p2 << endl; 
cout << *&a << endl; 
cout << *p1 << endl;
```

```
int a = 5;
int* p1;
p1 = &a;
int* p2 = p1;

cout << p1 << endl;
cout << p2 << endl;
```

```
int a[] {1, 2, 3};
int* p1 = &a[0];

cout << *p1 << endl;
cout << p1[0] << endl; 
cout << p1[1] << endl; 
cout << p1[2] << endl; 
cout << '' << endl; 
```

```
cout << a << endl;
cout << p1 << endl;
cout << p1+1 << endl;
cout << &p1[1] << endl;

int b = 777;
int* p2 = &b;
cout << p2[0] << endl;
```
