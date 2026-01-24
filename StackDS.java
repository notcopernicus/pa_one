// A simple generic Stack implementation using an array.
// Demonstrates basic stack operations: push, pop, peek
public class StackDS<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    
    public StackDS() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    
    // Adds an item to the top of the stack
    public void push(T item) {
        // If array is full, make it bigger
        if (size == elements.length) {
            expandCapacity();
        }
        elements[size] = item;
        size++;
    }
    
    // Removes and returns the top item from the stack
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot pop from empty stack");
        }
        size--;
        T item = (T) elements[size];
        elements[size] = null; // Help garbage collection
        return item;
    }
    
    // Returns the top item without removing it
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot peek at empty stack");
        }
        return (T) elements[size - 1];
    }
    
    // Checks if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Returns the number of items in the stack
    public int size() {
        return size;
    }
    
    // Doubles the capacity of the internal array
    private void expandCapacity() {
        Object[] newArray = new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }
}