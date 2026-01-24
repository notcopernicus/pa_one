// Demo program to showcase all assignment components
public class Main {
    
    public static void main(String[] args) {
        
        demonstrateExpressionEvaluator();
        System.out.println();
        demonstrateTaskScheduler();
    }
    
    // Demonstrates the Expression Evaluator functionality
    private static void demonstrateExpressionEvaluator() {
        System.out.println("PART 1: EXPRESSION EVALUATOR");
    
        
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        
        // Test 1: Balanced Parentheses Checker
        System.out.println("test one");
        String[] testExpressions = {
            "(3 + 4) * 2",
            "((1 + 2) * (3 + 4))",
            "(3 + 4",
            "([)]"
        };
        
        for (String expr : testExpressions) {
            boolean balanced = evaluator.isBalanced(expr);
            String status = balanced ? "BALANCED" : "UNBALANCED";
            System.out.println("  \"" + expr + "\" -> " + status);
        }
        
        // Test 2: Infix to Postfix Conversion
        System.out.println("\nTest 2: Infix to Postfix Conversion");
        
        String[] infixTests = {
            "3 + 4",
            "(3 + 4) * 2",
            "2 ^ 3 + 4",
            "3 + 4 * 2"
        };
        
        for (String infix : infixTests) {
            String postfix = evaluator.infixToPostfix(infix);
            System.out.println("  Infix:   " + infix);
            System.out.println("  Postfix: " + postfix);
            System.out.println();
        }
        
        // Test 3: Expression Evaluation
        System.out.println("Test 3: Expression Evaluation");
        
        String[] expressions = {
            "(3 + 4) * 2",
            "10 / 2 + 3",
            "2 ^ 3",
            "(5 + 3) * (2 + 2)"
        };
        
        for (String expr : expressions) {
            try {
                double result = evaluator.evaluate(expr);
                System.out.println("  \"" + expr + "\" = " + result);
            } catch (Exception e) {
                System.out.println("  \"" + expr + "\" -> ERROR: " + e.getMessage());
            }
        }
    }
    
    // Demonstrates the Task Scheduler functionality
    private static void demonstrateTaskScheduler() {
        System.out.println("\nPART 2: TASK SCHEDULER (Round-Robin)");

        
        // Create scheduler with time quantum of 3
        TaskScheduler scheduler = new TaskScheduler(3);
        
        // Add tasks
        System.out.println("Adding tasks to scheduler:");
        System.out.println("  Task A - 5 units");
        System.out.println("  Task B - 8 units");
        System.out.println("  Task C - 2 units");
        System.out.println();
        
        scheduler.addTask(new TaskScheduler.Task("Task A", 5));
        scheduler.addTask(new TaskScheduler.Task("Task B", 8));
        scheduler.addTask(new TaskScheduler.Task("Task C", 2));
        
        // Run the scheduler
        scheduler.run();
    }
}