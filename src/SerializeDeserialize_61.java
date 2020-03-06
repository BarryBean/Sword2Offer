import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bys
 * @date 2020-01-03 21:54
 */
public class SerializeDeserialize_61 {
    /**
     * 这里以前序遍历序列化
     *
     * @param root
     * @return
     */
    public static String Serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String res = root.val + "!";
        res += Serialize(root.left);
        res += Serialize(root.right);
        return res;
    }

    /**
     * 从前序序列化的字符串解析重构为二叉树
     *
     * @param str
     * @return
     */
    public static TreeNode Deserialize(String str) {
        String[] strings = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String tmp : strings) {
            queue.offer(tmp);
        }
        return reConByPreOrder(queue);
    }

    /**
     * 重构二叉树
     *
     * @param queue
     * @return
     */
    public static TreeNode reConByPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        //重建
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = reConByPreOrder(queue);
        head.right = reConByPreOrder(queue);
        return head;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        String s = Serialize(root);
        TreeNode treeNode = Deserialize(s);
    }
}
