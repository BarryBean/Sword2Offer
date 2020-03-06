/**
 * @author bys
 * @date 2019-10-11 20:06
 */
public class Mirror_18 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = null;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);

    }
}

