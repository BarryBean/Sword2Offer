import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bys
 * @date 2019-12-30 14:20
 */
public class PrintFromTopToBottom_22 {
    /**
     * 层次遍历 打印结点信息
     * 用辅助队列
     *
     * @param root
     * @return
     */
    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            while (count-->0){
                TreeNode node = queue.poll();
                if(node==null){
                    continue;
                }
                arrayList.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        System.out.println(printFromTopToBottom(root));

    }
}
