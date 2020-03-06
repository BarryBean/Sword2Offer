/**
 * @author bys
 * @date 2019-10-13 18:47
 */
import java.util.Stack;

public class IsPopOrder_21 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length!=popA.length){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.empty() && stack.peek()==popA[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        return stack.empty();
    }
}
