// 1. Add <T> to the class name
public class Queue<T> {
    private T[] arr;          // 2. Array holds type T
    private int front;
    private int size;
    private int capacity;
    
    public Queue(int capacity) {
        this.capacity = capacity;
        arr = (T[]) new Object[capacity]; 
        front = 0;
        size = 0;
    }

    // 4. Input is type T
    public void enqueue(T x) {
        if (isFull()) { //could/not use helper mehtod
            System.out.println("Queue Overflow");
            return;
        }
        int rear = (front + size) % capacity;
        arr[rear] = x;
        size++; 
    }
    
    // 5. Return type is T
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return null; // 6. Return null for objects, not -1
        }
        T e = arr[front];
        arr[front] = null; // Good practice: Help the Garbage Collector
        front = (front + 1) % capacity;
        size--;
        return e; 
    }



    public boolean isFull() {
        return size == capacity; // one-line solution!
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
