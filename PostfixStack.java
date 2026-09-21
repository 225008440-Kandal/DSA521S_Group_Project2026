// PostfixStack.java
// Part A3 - Stack (Static/array) used to evaluate a postfix expression
 
public class PostfixStack {
 
    int size = 50;
    int[] stack = new int[size];
    int top = -1;
 
    // ---- push: add a value on top ----
    public void push(int value) {
        if (top == size - 1) {
            System.out.println("Stack Overflow!");
        } else {
            top++;
            stack[top] = value;
        }
    }
 
    // ---- pop: remove and return the top value ----
    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return 0;
        } else {
            int value = stack[top];
            top--;
            return value;
        }
    }
 
    // ---- peek: show the top value without removing ----
    public int peek() {
        return stack[top];
    }
 
    // ---- isEmpty ----
    public boolean isEmpty() {
        return (top == -1);
    }
 
    // ---- evaluatePostfix: evaluate an expression like "5 3 + 8 *" ----
    // Tokens are separated by spaces. Numbers are pushed;
    // operators (+ - * /) pop two values, compute, and push the result.
    public int evaluatePostfix(String expression) {
        String[] tokens = expression.split(" ");
 
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
 
            if (token.equals("+")  token.equals("-")
                     token.equals("*") || token.equals("/")) {
                int b = pop();      // second operand (top)
                int a = pop();      // first operand
                int result = 0;
                if (token.equals("+")) result = a + b;
                else if (token.equals("-")) result = a - b;
                else if (token.equals("*")) result = a * b;
                else if (token.equals("/")) result = a / b;
                push(result);
            } else {
                push(Integer.parseInt(token));  // it is a number
            }
        }
        return pop();   // the final answer is left on the stack
    }
}