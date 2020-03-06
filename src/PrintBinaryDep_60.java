import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bys
 * @date 2020-01-03 21:34
 */
public class PrintBinaryDep_60 {
    /**
     * 相当于层次打印，每层多封装一个打印的行
     * 二叉树的层次打印，需要一个Queue作为辅助队列
     * @param pRoot
     * @return
     */
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        queue.add(pRoot);
        while (!queue.isEmpty()){
            ArrayList<Integer> arrayList = new ArrayList<>();
            //count为每一层的结点个数
            int count = queue.size();
            while (count-->0){
                TreeNode node =queue.poll();
                if(node==null){
                    continue;
                }
                arrayList.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if(arrayList.size()!=0){
                lists.add(arrayList);
            }
        }
        return lists;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        System.out.println(Print(root));
    }
}
