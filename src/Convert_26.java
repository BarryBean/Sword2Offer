/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Convert_26
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/19 10:44
 */
public class Convert_26 {
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return pRootOfTree;
        }
        process(pRootOfTree);
        while (pRootOfTree.left != null) {
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }

    public static TreeNode pre = null;

    public static void process(TreeNode root) {
        if (root == null) {
            return;
        }
        process(root.left);

        root.left = pre;
        if (pre != null) {
            pre.right = root;
        }
        pre = root;

        process(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        Convert(root);
    }

}
