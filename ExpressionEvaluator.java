// Expression evaluator that converts infix expressions to postfix
// and evaluates them using stacks. Also checks for balanced parentheses.
public class ExpressionEvaluator {
    
    // Recursively checks if parentheses/brackets/braces are balanced
    public boolean isBalanced(String expression) {
        return checkBalance(expression, 0, new StackDS<>());
    }
    
    // Helper method for recursive balance checking
    private boolean checkBalance(String expr, int index, StackDS<Character> stack) {
        // Base case: reached end of string
        if (index >= expr.length()) {
            return stack.isEmpty();
        }
        
        char current = expr.charAt(index);
        
        // If it's an opening bracket, push it
        if (current == '(' || current == '[' || current == '{') {
            stack.push(current);
            return checkBalance(expr, index + 1, stack);
        }
        
        // If it's a closing bracket, check if it matches
        if (current == ')' || current == ']' || current == '}') {
            if (stack.isEmpty()) {
                return false;
            }
            
            char top = stack.pop();
            boolean matches = (top == '(' && current == ')') ||
                            (top == '[' && current == ']') ||
                            (top == '{' && current == '}');
            
            if (!matches) {
                return false;
            }
        }
        
        // Continue with next character
        return checkBalance(expr, index + 1, stack);
    }
    
    // Converts infix expression to postfix using Shunting Yard algorithm
    public String infixToPostfix(String infix) {
        String result = "";
        StackDS<Character> operators = new StackDS<>();
        
        int i = 0;
        while (i < infix.length()) {
            char ch = infix.charAt(i);
            
            // Skip spaces
            if (ch == ' ') {
                i++;
                continue;
            }
            
            // If it's a digit, get the whole number
            if (Character.isDigit(ch)) {
                while (i < infix.length() && 
                       (Character.isDigit(infix.charAt(i)) || infix.charAt(i) == '.')) {
                    result += infix.charAt(i);
                    i++;
                }
                result += " ";
                continue;
            }
            
            // If it's opening parenthesis, push it
            if (ch == '(') {
                operators.push(ch);
            }
            // If it's closing parenthesis, pop until we find opening
            else if (ch == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    result += operators.pop() + " ";
                }
                if (!operators.isEmpty()) {
                    operators.pop(); // Remove the '('
                }
            }
            // If it's an operator
            else if (isOperator(ch)) {
                // Pop operators with higher or equal precedence
                while (!operators.isEmpty() && 
                       operators.peek() != '(' && 
                       getPrecedence(operators.peek()) >= getPrecedence(ch)) {
                    result += operators.pop() + " ";
                }
                operators.push(ch);
            }
            
            i++;
        }
        
        // Pop any remaining operators
        while (!operators.isEmpty()) {
            result += operators.pop() + " ";
        }
        
        return result.trim();
    }
    
    // Evaluates a postfix expression and returns the result
    public double evaluatePostfix(String postfix) {
        StackDS<Double> numbers = new StackDS<>();
        String[] tokens = postfix.split(" ");
        
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }
            
            // If it's a number, push it onto the stack
            if (!isOperator(token.charAt(0)) || token.length() > 1) {
                numbers.push(Double.parseDouble(token));
            }
            // If it's an operator, pop two numbers and apply it
            else {
                double num2 = numbers.pop();
                double num1 = numbers.pop();
                double result = calculate(num1, num2, token.charAt(0));
                numbers.push(result);
            }
        }
        
        return numbers.pop();
    }
    
    // Evaluates an infix expression directly
    public double evaluate(String infix) {
        // First check if parentheses are balanced
        if (!isBalanced(infix)) {
            throw new RuntimeException("Parentheses are not balanced!");
        }
        
        // Convert to postfix and evaluate
        String postfix = infixToPostfix(infix);
        return evaluatePostfix(postfix);
    }
    
    // Checks if a character is an operator
    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }
    
    // Returns the precedence of an operator
    // Higher number = higher precedence
    private int getPrecedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        }
        if (operator == '*' || operator == '/') {
            return 2;
        }
        if (operator == '^') {
            return 3;
        }
        return 0;
    }
    
    // Performs the calculation for two numbers and an operator
    private double calculate(double num1, double num2, char operator) {
        if (operator == '+') {
            return num1 + num2;
        }
        if (operator == '-') {
            return num1 - num2;
        }
        if (operator == '*') {
            return num1 * num2;
        }
        if (operator == '/') {
            if (num2 == 0) {
                throw new RuntimeException("Cannot divide by zero!");
            }
            return num1 / num2;
        }
        if (operator == '^') {
            return Math.pow(num1, num2);
        }
        throw new RuntimeException("Unknown operator: " + operator);
    }
}