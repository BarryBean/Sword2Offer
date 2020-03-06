import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bys
 * @date 2019-12-29 14:47
 */
public class TreeDepth_38 {

    /**
     * 递归版本
     *
     * @param root
     * @return
     */
    public static int treeDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(treeDepth1(root.left), treeDepth1(root.right));
    }

    /**
     * 非递归方法，用层次遍历获得树的高度
     *
     * @param root
     * @return
     */
    public static int treeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int height = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
            height++;
        }
        return height - 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        root.left.right.left.right = new TreeNode(8);
        System.out.println(treeDepth1(root));
        System.out.println(treeDepth2(root));
    }


}
