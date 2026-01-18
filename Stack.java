public class Stack<T> {

    // The Inner Class: The container for your data
    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // The Only Pointer You Need
    private Node<T> top; 

    // Constructor
    public Stack() {
        this.top = null; // Stack starts empty
    }

    // 1. Add item to the top
    public void push(T item) {
        // Create new node
        // Point new node to current top
        // Update top to be the new node
    }

    // 2. Remove and return item from the top
    public T pop() {
        // If empty, return null (or throw exception)
        // Save data from top
        // Move top to top.next
        // Return saved data
    }

    // 3. Look at top without removing
    public T peek() {
        // Check if empty
        // Return top.data
    }

    public boolean isEmpty() {
        return top == null;
    }
}