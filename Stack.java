public class Stack<T> {


    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> top; 

    public Stack() {
        this.top = null;
    }

    public void push(T item) {
        
        Node<T> newNode = new Node<>(item);
        
        
        newNode.next = top;
        
        
        top = newNode;
    }


    public T pop() {
        
        if (top == null) {
            return null; 
        }
        
        // Save the data we want to return
        T item = top.data;
        
        // Move the pointer down
        top = top.next;
        
        
        return item;
    }

    public T peek() {
        if (top == null) {
            return null;
        }
        
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
        public static void main(String[] args) {
            // Test Integer Stack
            Stack<Integer> numStack = new Stack<>();
            System.out.println("Pushing 10, 20, 30");
            numStack.push(10);
            numStack.push(20);
            numStack.push(30);
    
            System.out.println("Popped: " + numStack.pop()); // Should be 30
            System.out.println("Peek: " + numStack.peek());   // Should be 20
    
            // Test String Stack (To prove Generics work)
            Stack<String> wordStack = new Stack<>();
            wordStack.push("Java");
            wordStack.push("Rocks");
            System.out.println("Popped: " + wordStack.pop()); // Should be "Rocks"
        }
    }
