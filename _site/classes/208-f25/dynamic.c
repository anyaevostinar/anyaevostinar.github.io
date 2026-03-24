/*
    dynamic.c
    Modified from memory.c by Jeff Ondich and Tanya Amert
    Created by Anya Vostinar for Fall 2025

    Playing with dynamic memory in gdb
    
    Compile with:
    gcc -Wall -Werror -g -Og -o dynamic dynamic.c
    
*/



#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define BUFFER_SIZE 3

//////////////////////////////////

typedef struct node {
    char value[BUFFER_SIZE];
    struct node *next;
} node_t;

typedef struct {
    node_t *head;
} linked_list_t;

// Print a linked list.
void print_list(linked_list_t *linked_list)
{
    printf("[");

    if (linked_list != NULL)
    {
        node_t *current = linked_list->head;
        while (current != NULL)
        {
            printf(" %s", current->value);
            current = current->next;
        }
    }

    printf("]\n");
}


void free_list(linked_list_t *linked_list)
{
    // ??? what should be here ???
}

void making_a_list()
{
    linked_list_t *linked_list;
    node_t *node;
    node_t *last_node;

    // Allocate and initialize the list
    linked_list = malloc(sizeof(linked_list_t));
    if (linked_list == NULL)
    {
        return;
    }

    linked_list->head = NULL;

    // Allocate and initialize the first node
    node = malloc(sizeof(node_t));
    if (node == NULL)
    {
        free_list(linked_list);
        return;      
    }

    strcpy(node->value, "aa");
    linked_list->head = node;
    last_node = node;
    
    // Allocate and initialize the second node
    node = malloc(sizeof(node_t));
    if (node == NULL)
    {
        free_list(linked_list);
        return;        
    }

    strcpy(node->value, "bb");
    last_node->next = node;
    last_node = node;

    // Allocate and initialize the third and final node
    node = malloc(sizeof(node_t));
    if (node == NULL)
    {
        free_list(linked_list);
        return;        
    }

    strcpy(node->value, "cc");
    last_node->next = node;
    node->next = NULL;

    // Print the list we've built
    print_list(linked_list);    
    printf("\n");

    // Clean up
    free_list(linked_list);
}


int main() {
    making_a_list();
    printf("Some extra things");
    printf("Don't mind us");
}