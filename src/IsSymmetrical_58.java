import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:IsSymmetrical_59
 * @Description
 * @Author: yushengbi
 * @Date:2020/1/21 14:44
 */
public class IsSymmetrical_58 {
    /**
     * 非递归做法
     *
     * @param pRoot
     * @return
     */
    public static boolean isSymmetrical(TreeNode pRoot) {
        ArrayList<TreeNode> arrayListLeft = printTopToBottom(pRoot, 1);
        ArrayList<TreeNode> arrayListRight = printTopToBottom(pRoot, 0);
        if (arrayListLeft.size() != arrayListRight.size()) {
            return false;
        }
        for (int i = 0; i < arrayListLeft.size(); i++) {
            if (arrayListLeft.get(i).val != arrayListRight.get(i).val) {
                return false;
            }
        }
        return true;
    }

    /**
     * 层次遍历
     *
     * @param pNode
     * @return
     */
    public static ArrayList<TreeNode> printTopToBottom(TreeNode pNode, int flag) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        queue.add(pNode);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    arrayList.add(new TreeNode(0));
                    continue;
                }
                arrayList.add(node);
                if (flag == 1) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    queue.offer(node.right);
                    queue.offer(node.left);
                }

            }
        }
        return arrayList;
    }

    /**
     * 递归做法
     *
     * @param pRoot
     * @return
     */
    public static boolean isSymmetrical2(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymm(pRoot.left, pRoot.right);
    }

    public static boolean isSymm(TreeNode pLeft, TreeNode pRight) {
        if (pLeft == null && pRight == null) {
            return true;
        }
        if (pLeft == null || pRight == null) {
            return false;
        }
        if (pLeft.val != pRight.val) {
            return false;
        }
        //镜像条件为左右结点值相等+
        return isSymm(pLeft.left, pRight.right) && isSymm(pLeft.right, pRight.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(2);
        System.out.println(isSymmetrical2(root));

    }
}
