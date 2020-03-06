/**
 * @author bys
 * @date 2019-10-12 16:16
 */

import java.util.Stack;

public class Stack_20 {

    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        if (minStack.empty()) {
            minStack.push(node);
        } else if (minStack.peek() >= node) {
            minStack.push(node);
        }else {
            minStack.push(minStack.peek());
        }
        //minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
