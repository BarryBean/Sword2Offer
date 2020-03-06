import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:PrintZhiBinary
 * @Description
 * @Author: yushengbi
 * @Date:2020/1/21 16:50
 */
public class PrintZhiBinary_59 {

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        queue.add(pRoot);
        //初始变量标记奇偶
        int num = 1;
        while (!queue.isEmpty()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int count = queue.size();
            while (count-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    //arrayList.add(-1);
                    continue;
                }
                arrayList.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (arrayList.size() == 0) {
                continue;
            }
            if (num % 2 == 1) {
                arrayLists.add(arrayList);
            } else {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i = arrayList.size()-1; i >= 0; i--) {
                    tmp.add(arrayList.get(i));
                }
                arrayLists.add(tmp);
            }
            num++;
        }
        return arrayLists;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        System.out.println(Print(root));
    }
}
