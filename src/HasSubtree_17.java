
/**
 * @author bys
 * @date 2019-10-11 19:44
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
public class HasSubtree_17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }
        return isSubtreeWithRoot(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
    private boolean isSubtreeWithRoot(TreeNode root1,TreeNode root2){
        if(root1==null){
            return false;
        }
        if(root2==null){
            return true;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return isSubtreeWithRoot(root1.left,root2.left) && isSubtreeWithRoot(root1.right,root2.right);
    }
}
