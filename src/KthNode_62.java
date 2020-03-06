/**
 * @author bys
 * @date 2020-01-04 12:30
 */
public class KthNode_62 {
    private TreeNode resNode;
    private int count=0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        inOrder(pRoot,k);
        return resNode;
    }

    public void inOrder(TreeNode node,int k){
        if(node==null || count>=k){
            return;
        }
        inOrder(node.left,k);
        if(++count==k){
            resNode = node;
        }
        inOrder(node.right,k);
    }
}
