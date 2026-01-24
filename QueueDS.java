// A simple generic Queue implementation using a linked list.
// Demonstrates basic queue operations: enqueue, dequeue, peek
public class QueueDS<T> {
    
    // Inner class to represent each node in the queue
    private class Node {
        T data;
        Node next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node front;  // Points to first element
    private Node rear;   // Points to last element
    private int count;   // Keeps track of size
    
    public QueueDS() {
        front = null;
        rear = null;
        count = 0;
    }
    
    // Adds an item to the back of the queue
    public void enqueue(T item) {
        Node newNode = new Node(item);
        
        // If queue is empty, new node is both front and rear
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            // Add to the end and update rear
            rear.next = newNode;
            rear = newNode;
        }
        count++;
    }
    
    // Removes and returns the front item from the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot dequeue from empty queue");
        }
        
        T item = front.data;
        front = front.next;
        
        // If queue is now empty, update rear too
        if (front == null) {
            rear = null;
        }
        
        count--;
        return item;
    }
    
    // Returns the front item without removing it
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot peek at empty queue");
        }
        return front.data;
    }
    
    // Checks if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }
    
    // Returns the number of items in the queue
    public int size() {
        return count;
    }
}