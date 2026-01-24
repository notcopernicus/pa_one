public class DataStructuresTest {
    
    public static void main(String[] args) {
        System.out.println("Running Tests...\n");
        
        testStackBasicOperations();
        testStackEmpty();
        testStackPopEmpty();
        testStackResize();
        
        testQueueBasicOperations();
        testQueueEmpty();
        testQueueDequeueEmpty();
        
        testBalancedParentheses();
        testUnbalancedParentheses();
        testInfixToPostfixConversion();
        testPostfixEvaluation();
        testInfixEvaluation();
        testUnbalancedExpression();
        testDivisionByZero();
        
        testTaskCreation();
        testTaskProcessing();
        testSchedulerExecution();
        testEmptyScheduler();
        
        System.out.println("\nAll tests completed!");
    }
    
    public static void testStackBasicOperations() {
        StackDS<Integer> stack = new StackDS<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        if (stack.size() == 3 && stack.peek().equals(30)) {
            stack.pop();
            stack.pop();
            if (stack.size() == 1) {
                System.out.println("Stack basic operations test passed");
                return;
            }
        }
        System.out.println("Stack basic operations test failed");
    }
    
    public static void testStackEmpty() {
        StackDS<String> stack = new StackDS<>();
        if (stack.isEmpty()) {
            stack.push("hello");
            if (!stack.isEmpty()) {
                stack.pop();
                if (stack.isEmpty()) {
                    System.out.println("Stack empty test passed");
                    return;
                }
            }
        }
        System.out.println("Stack empty test failed");
    }
    
    public static void testStackPopEmpty() {
        StackDS<Integer> stack = new StackDS<>();
        try {
            stack.pop();
            System.out.println("Stack pop empty test failed");
        } catch (RuntimeException e) {
            System.out.println("Stack pop empty test passed");
        }
    }
    
    public static void testStackResize() {
        StackDS<Integer> stack = new StackDS<>();
        for (int i = 0; i < 50; i++) {
            stack.push(i);
        }
        if (stack.size() == 50 && stack.peek().equals(49)) {
            System.out.println("Stack resize test passed");
        } else {
            System.out.println("Stack resize test failed");
        }
    }
    
    public static void testQueueBasicOperations() {
        QueueDS<String> queue = new QueueDS<>();
        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");
        
        if (queue.size() == 3 && queue.peek().equals("first")) {
            queue.dequeue();
            queue.dequeue();
            if (queue.size() == 1) {
                System.out.println("Queue basic operations test passed");
                return;
            }
        }
        System.out.println("Queue basic operations test failed");
    }
    
    public static void testQueueEmpty() {
        QueueDS<Integer> queue = new QueueDS<>();
        if (queue.isEmpty()) {
            queue.enqueue(100);
            if (!queue.isEmpty()) {
                queue.dequeue();
                if (queue.isEmpty()) {
                    System.out.println("Queue empty test passed");
                    return;
                }
            }
        }
        System.out.println("Queue empty test failed");
    }
    
    public static void testQueueDequeueEmpty() {
        QueueDS<String> queue = new QueueDS<>();
        try {
            queue.dequeue();
            System.out.println("Queue dequeue empty test failed");
        } catch (RuntimeException e) {
            System.out.println("Queue dequeue empty test passed");
        }
    }
    
    public static void testBalancedParentheses() {
        ExpressionEvaluator eval = new ExpressionEvaluator();
        
        if (eval.isBalanced("()") && eval.isBalanced("()[]{}") && 
            eval.isBalanced("(3 + 4)") && eval.isBalanced("{[()]}")) {
            System.out.println("Balanced parentheses test passed");
        } else {
            System.out.println("Balanced parentheses test failed");
        }
    }
    
    public static void testUnbalancedParentheses() {
        ExpressionEvaluator eval = new ExpressionEvaluator();
        
        if (!eval.isBalanced("(") && !eval.isBalanced(")") && 
            !eval.isBalanced("(]") && !eval.isBalanced("([)]")) {
            System.out.println("Unbalanced parentheses test passed");
        } else {
            System.out.println("Unbalanced parentheses test failed");
        }
    }
    
    public static void testInfixToPostfixConversion() {
        ExpressionEvaluator eval = new ExpressionEvaluator();
        
        if (eval.infixToPostfix("3 + 4").equals("3 4 +") &&
            eval.infixToPostfix("(3 + 4) * 2").equals("3 4 + 2 *")) {
            System.out.println("Infix to postfix conversion test passed");
        } else {
            System.out.println("Infix to postfix conversion test failed");
        }
    }
    
    public static void testPostfixEvaluation() {
        ExpressionEvaluator eval = new ExpressionEvaluator();
        
        if (Math.abs(eval.evaluatePostfix("3 4 +") - 7.0) < 0.001 &&
            Math.abs(eval.evaluatePostfix("3 4 + 2 *") - 14.0) < 0.001) {
            System.out.println("Postfix evaluation test passed");
        } else {
            System.out.println("Postfix evaluation test failed");
        }
    }
    
    public static void testInfixEvaluation() {
        ExpressionEvaluator eval = new ExpressionEvaluator();
        
        if (Math.abs(eval.evaluate("(3 + 4) * 2") - 14.0) < 0.001 &&
            Math.abs(eval.evaluate("3 + 4 * 4") - 19.0) < 0.001) {
            System.out.println("Infix evaluation test passed");
        } else {
            System.out.println("Infix evaluation test failed");
        }
    }
    
    public static void testUnbalancedExpression() {
        ExpressionEvaluator eval = new ExpressionEvaluator();
        try {
            eval.evaluate("(3 + 4");
            System.out.println("Unbalanced expression test failed");
        } catch (RuntimeException e) {
            System.out.println("Unbalanced expression test passed");
        }
    }
    
    public static void testDivisionByZero() {
        ExpressionEvaluator eval = new ExpressionEvaluator();
        try {
            eval.evaluate("5 / 0");
            System.out.println("Division by zero test failed");
        } catch (RuntimeException e) {
            System.out.println("Division by zero test passed");
        }
    }
    
    public static void testTaskCreation() {
        TaskScheduler.Task task = new TaskScheduler.Task("Test", 10);
        
        if (task.getName().equals("Test") && task.getTimeRemaining() == 10 && !task.isFinished()) {
            System.out.println("Task creation test passed");
        } else {
            System.out.println("Task creation test failed");
        }
    }
    
    public static void testTaskProcessing() {
        TaskScheduler.Task task = new TaskScheduler.Task("Test", 10);
        task.processTime(3);
        
        if (task.getTimeRemaining() == 7 && !task.isFinished()) {
            task.processTime(7);
            if (task.getTimeRemaining() == 0 && task.isFinished()) {
                System.out.println("Task processing test passed");
                return;
            }
        }
        System.out.println("Task processing test failed");
    }
    
    public static void testSchedulerExecution() {
        TaskScheduler scheduler = new TaskScheduler(3);
        scheduler.addTask(new TaskScheduler.Task("A", 5));
        scheduler.addTask(new TaskScheduler.Task("B", 3));
        
        try {
            scheduler.run();
            System.out.println("Scheduler execution test passed");
        } catch (Exception e) {
            System.out.println("Scheduler execution test failed");
        }
    }
    
    public static void testEmptyScheduler() {
        TaskScheduler scheduler = new TaskScheduler(5);
        try {
            scheduler.run();
            System.out.println("Empty scheduler test passed");
        } catch (Exception e) {
            System.out.println("Empty scheduler test failed");
        }
    }
}