/* Adapted from Problem Solving with Algorithms and Data Structures using Java by Bradley N. Miller, David L. Ranum, Roman Yasinovskyy, J. David Eisenberg https://runestone.academy/ns/books/published/javads/javads.html?mode=browsing */

import java.util.ArrayList;
import java.util.NoSuchElementException;

class ArrayQueue<T> {
    ArrayList<T> items;

    public ArrayQueue() {
        this.items = new ArrayList<T>();
    }

    public void enqueue(T item) {
        this.items.add(0, item); // adding to position 0, which is the tail
    }

    public boolean isEmpty() {
        return (this.items.isEmpty());
    }

    public int size() {
        return this.items.size();
    }

    public T dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return this.items.remove(this.size() - 1); // removing the head, which is the last item
    }

    public String toString() {
        if (!this.items.isEmpty()) {
            String arrString = this.items.toString();
            return "tail ->" + arrString + "-> head";
        } else {
            return "<<empty queue>>";
        }
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> q = new ArrayQueue<Integer>();
        System.out.println(q);
        q.enqueue(1);
        System.out.println(q);
        q.enqueue(2);
    }
}

