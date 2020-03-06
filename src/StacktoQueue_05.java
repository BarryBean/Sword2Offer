import java.util.Stack;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:StacktoQueue_05
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/14 12:46
 */
public class StacktoQueue_05 {
    Stack<Integer> stackData = new Stack<>();
    Stack<Integer> stackBack = new Stack<>();

    public void push(int node) {
        stackData.push(node);
    }

    public int pop() {
//        if (stackBack.isEmpty()) {
//            while (!stackData.isEmpty()) {
//                stackBack.push(stackData.pop());
//            }
//        }
//        return stackBack.pop();
        if (!stackBack.isEmpty()) {
            return stackBack.pop();
        }
        while (!stackData.isEmpty()) {
            stackBack.push(stackData.pop());
        }
        return stackBack.pop();
    }


}
