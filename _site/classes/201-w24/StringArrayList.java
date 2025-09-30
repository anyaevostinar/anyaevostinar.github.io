/**
 * A class that implements a list of strings using an array.
 * Authors: Anna Rafferty and Anya Vostinar
 */

import java.util.Arrays;

public class StringArrayList {
    private static final int DEFAULT_CAPACITY = 1;
    public int capacity = DEFAULT_CAPACITY;
    private int numItems;
    private String[] array;
    
    /**
     * Create an empty list.
     */
    public StringArrayList() {
        numItems = 0;//list starts off with nothing in it
        array = new String[DEFAULT_CAPACITY];
    }
    
    /**
     * Creates a list with a single item. (I've added
     * this constructor mainly for testing purposes
     * so that you can check your get before you've written
     * add.)
     */
    public StringArrayList(String initialItem) {
        numItems = 1;
        array = new String[DEFAULT_CAPACITY];
        array[0] = initialItem;
    }

    /** Returns the item at a given index.
     * @return the item, or throws an {@link IndexOutOfBoundsException}
     * if position is out of bounds.
     */
    public String get(int position) {
        if(position<0){
            throw new IndexOutOfBoundsException();
        } else if(position<numItems) {
          return array[position];
        } else {
          throw new IndexOutOfBoundsException();
        }
    }

        /** 
     * Replaces the item at a given index.
     * @return the element previously at that position, or throws an 
     * {@link IndexOutOfBoundsException} if position is out of bounds.
     */
    public String set(int position, String newItem) {
        //This method isn't implemented. 
        throw new UnsupportedOperationException();
    }
    
    /** Adds newItem at the given index.
     * Adds newItem at index newPosition, and shifts each item at or beyond
     * that index to the next higher index.
     * Postcondition: The item at newPosition is newItem.
     * throws an {@link IndexOutOfBoundsException}
     * if position is out of bounds. For this method (and only
     *   this method), the length of the list is considered in bounds.
     */
    public void add(int index, String newItem) {
        //This method isn't implemented.
        throw new UnsupportedOperationException();
        
    }

    /** Adds newItem to the end of the list. */
    public void add(String newItem) {
        if(numItems == capacity) {
            String[] oldArray = array;
            capacity = capacity * 2;
            array = new String[capacity];
            for(int i = 0; i<numItems; i++){
                array[i] = oldArray[i];
            }
        }
        array[numItems] = newItem;
        numItems++;
    }
    

    
    /** Removes the item at the given index.
     * Removes the item at the given index, shifts each item beyond that index
     * to the next lower index.
     * @return the removed item, or throws an {@link IndexOutOfBoundsException}
     * if position is out of bounds.
     */
    public String remove(int position) {
        //This method isn't implemented. It isn't required for this activity, although
        // you're welcome to fill it in as practice.
        throw new UnsupportedOperationException();
    }
    
    /** Removes all items from the list. */
    public void clear() {
        //This method isn't implemented. It isn't required for this activity, although
        // you're welcome to fill it in as practice.
        throw new UnsupportedOperationException();
    }
    
    
    /** Returns true if the list contains the target item. */
    public boolean contains(String targetItem) {
        //This method isn't implemented. It isn't required for this activity, although
        // you're welcome to fill it in as practice.
        throw new UnsupportedOperationException();
    }
    
    /** Returns the length of the list: the number of items stored in it. */
    public int size() {
        //This method isn't implemented yet. You'll write it in this activity.
        return numItems;
    }
    
    /** Returns true if the list has no items stored in it. */
    public boolean isEmpty() {
        //This method isn't implemented. It isn't required for this activity, although
        // you're welcome to fill it in as practice.
        throw new UnsupportedOperationException();
    }
    
    /** Returns an array version of the list.  Note that, for technical reasons,
     * the type of the items contained in the list can't be communicated
     * properly to the caller, so an array of Objects gets returned.
     * @return an array of length length(), with the same items in it as are
     *         stored in the list, in the same order.
     */
    public Object[] toArray() {
        //I've provided an implementation of this method to make
        //it easier for me to write tests.
        //Question to think about: Why not just return array?
        return Arrays.copyOf(array, numItems);
    }

    public String toString() {
        String returnString = "";
        for(int i=0; i<array.length; i++){
            returnString += array[i] + " ";
        }
        return returnString;
    }

    public static void main(String[] args) {
        StringArrayList test = new StringArrayList();
        test.add("hi");
        System.out.println(test);
        System.out.println(test.capacity);
        test.add("hi");
        System.out.println(test);
        System.out.println(test.capacity);
        test.add("hi");
        System.out.println(test);
        System.out.println(test.capacity);
        System.out.println(test);
        System.out.println(test.capacity);
        System.out.println(test);
        System.out.println(test.capacity);
        System.out.println(test.get(0));
    }
    
    
    
}