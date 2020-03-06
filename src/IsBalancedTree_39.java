/**
 * @author bys
 * @date 2019-12-29 15:01
 */
public class IsBalancedTree_39 {
    public static ResultData isBalanced_Solution(TreeNode root) {
        if (root == null) {
            return new ResultData(0, true);
        }
        ResultData left = isBalanced_Solution(root.left);
        if (!left.isBalanced) {
            return new ResultData(0, false);
        }
        ResultData right = isBalanced_Solution(root.right);
        if (!right.isBalanced) {
            return new ResultData(0, false);
        }
        if (Math.abs(left.height - right.height) > 1) {
            return new ResultData(0, false);
        }
        return new ResultData(1 + Math.max(left.height, right.height), true);
    }

    public static boolean IsBalanced_Solution(TreeNode root) {
        ResultData resultData = isBalanced_Solution(root);
        return resultData.isBalanced;
    }

    private static class ResultData {
        int height;
        boolean isBalanced;

        public ResultData(int height, boolean isBanlanced) {
            this.height = height;
            this.isBalanced = isBanlanced;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        System.out.println(IsBalanced_Solution(root));
    }

}
