# File: search_timer.py
# Purpose: Compare the runtime of searching operations
# Author: Anya Vostinar
# Based on searchTimer.py by Tanya Amert

import time
import random


def merge(left_half, right_half):
    """Merges two sorted lists into a single sorted list."""
    pass #TODO: DELETE THIS LINE AND PLACE YOUR CODE HERE

def merge_sort(lst):
    """Sorts a list using the merge sort algorithm."""
    pass #TODO: DELETE THIS LINE AND PLACE YOUR CODE HERE

def insertion_sort(lst):
    for i in range(1, len(lst)):
        cur_val = lst[i]
        cur_pos = i

        while cur_pos > 0 and lst[cur_pos - 1] > cur_val:
            lst[cur_pos] = lst[cur_pos - 1]
            cur_pos = cur_pos - 1
        lst[cur_pos] = cur_val


def selection_sort(lst):
    for i in range(len(lst)):
        small = i
        for j in range(i+1, len(lst)):
            if lst[j] < lst[small]:
                small = j
        if small != i:
            lst[i], lst[small] = lst[small], lst[i]

def bubble_sort(lst):
    for i in range(len(lst) - 1, 0, -1):
        for j in range(i):
            if lst[j] > lst[j + 1]:
                temp = lst[j]
                lst[j] = lst[j + 1]
                lst[j + 1] = temp

def run_trials(input_size, num_trials):
    ''' Run trials of various functions and prints results '''


    time_insertion_sort = 0
    time_merge_sort = 0
    time_selection_sort = 0
    time_bubble_sort = 0
    time_built_in = 0
    for i in range(num_trials):

        random_list = list(range(input_size))
        random.shuffle(random_list)
       
        # Test time of selection_sort
        t = time.time()
        selection_sort(random_list)
        time_selection_sort += (time.time() - t)

        # New random list for insertion sort
        random_list = list(range(input_size))
        random.shuffle(random_list)

        # Test time of insertion_sort
        t = time.time()
        insertion_sort(random_list)
        time_insertion_sort += (time.time() - t)

        # New random list for merge sort
        random_list = list(range(input_size))
        random.shuffle(random_list)

        # Test time of merge_sort
        t = time.time()
        merge_sort(random_list)
        time_merge_sort += (time.time() - t)

        # New random list for bubble sort
        random_list = list(range(input_size))
        random.shuffle(random_list)

        # Test time of bubble_sort
        t = time.time()
        bubble_sort(random_list)
        time_bubble_sort += (time.time() - t)

        # New random list for built-in sort
        random_list = list(range(input_size))
        random.shuffle(random_list)

        # Test time of built-in sort
        t = time.time()
        sorted(random_list)
        time_built_in += (time.time() - t)


    #print average results
    print("------------------------------------")
    print(f"Average time for insertion sort with input size {input_size}: {time_insertion_sort / num_trials * 1000:.6f} milliseconds")
    print(f"Average time for selection sort with input size {input_size}: {time_selection_sort / num_trials * 1000:.6f} milliseconds")
    print(f"Average time for bubble sort with input size {input_size}:    {time_bubble_sort / num_trials * 1000:.6f} milliseconds")
    print()
    print(f"Average time for merge sort with input size {input_size}:     {time_merge_sort / num_trials * 1000:.6f} milliseconds")
    print(f"Average time for built-in with input size {input_size}:       {time_built_in / num_trials * 1000:.6f} milliseconds")


def time_of_functions():
    """
    Run trials of various functions and prints results
    """
    # Parameters
    input_size = 10 #TODO: change this to 1000, 5000, 10000 etc to see how runtime changes with size
    num_trials = 10000 #TODO: Decrease this to 100 for larger input sizes


    # Get data for this value of input_size
    print("Working on input size:", input_size)  
    run_trials(input_size, num_trials)



def main():
    time_of_functions()

if __name__ == "__main__":
    main()