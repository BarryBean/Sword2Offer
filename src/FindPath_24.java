import java.util.ArrayList;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:FindPath_24
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/18 10:26
 */
public class FindPath_24 {
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (root == null || root.val > target) {
            return arrayLists;
        }
        arrayLists = process(root, target, arrayLists, new ArrayList<Integer>());
        return arrayLists;
     }

    public static ArrayList<ArrayList<Integer>> process(TreeNode root, int target, ArrayList<ArrayList<Integer>> arrayLists, ArrayList<Integer> list) {
        if(root==null){
            return arrayLists;
        }
        target -= root.val;
        list.add(root.val);
        if (target == 0 && root.right == null && root.left == null) {
            arrayLists.add(new ArrayList<>(list));
        }
        process(root.left, target, arrayLists, list);
        process(root.right, target, arrayLists, list);
        list.remove(list.size() - 1);
        return arrayLists;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.left.right.right = new TreeNode(2);
        root.right.right = new TreeNode(6);
        System.out.println(FindPath(root, 10));
    }
}
