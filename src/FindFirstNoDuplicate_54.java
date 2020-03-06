import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bys
 * @date 2020-01-03 14:17
 */
public class FindFirstNoDuplicate_54 {

    int[] chars = new int[256];
    Queue<Character> queue = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        chars[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && chars[queue.peek()] > 1) {
            queue.poll();
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
