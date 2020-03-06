import java.util.Arrays;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:ReConstructBinaryTree_04
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/14 11:30
 */
public class ReConstructBinaryTree_04 {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                node.left = reConstructBinaryTree(
                        Arrays.copyOfRange(pre, 1, i+1),
                        Arrays.copyOfRange(in, 0, i));
                node.right = reConstructBinaryTree(
                        Arrays.copyOfRange(pre, i + 1, pre.length ),
                        Arrays.copyOfRange(in, i + 1, in.length ));
            }
        }
        return node;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode node = reConstructBinaryTree(pre, in);
        printPreOrder(node);
    }

    public static void printPreOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
}
