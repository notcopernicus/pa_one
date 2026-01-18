class myQ {
    private int [] arr;
    private int front;
    private int size;
    private int capacity;
    
    //constructor to initialize queue
    public myQ (int capacity) {
        this.capacity = capacity;
        arr = new int [capacity];
        front = 0;
        size = 0;
    }

    //insert element at rear
    public void enqueue (int x) {
        //check for overflow
        if (size == capacity) {
            System.out.print("Queue Overflow");
            return;
        }
        int rear = (front + size) % capacity;
        arr[rear] = x;
        size++; 
    }
    
    //remove from front
    public int dequeue() {
        //check for underflow
        if (size == 0) {
            System.out.print("Queue Underflow");
            return -1;
        }
        int e = arr[front];
        front = (front + 1) % capacity;
        size--;
        return e; 
    }

    //get front element
    public int getFront() {
        //check for underflow
        if (size == 0) return -1;
        return arr[front];
    }

    //get rear element
    public int getRear() {
        //check for underflow
        if (size == 0) return -1;
        int rear = (front + size - 1) % capacity;
        return arr[rear];
    }

    //check isFull
    public boolean isFull() {
        return (size == capacity) ? true : false;
    }

    //check isEmpty
    public boolean isEmpty() {
        return (size == 0) ? true : false;
    }
}

