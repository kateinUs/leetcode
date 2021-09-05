package leetcode;

/**
 * @author huimin
 * @create 2021-09-01 4:55
 */
public class T101_symmetric_tree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null)
            return true;
        if(node1 == null || node2 == null)
            return false;
        return (node1.val == node2.val) &&
                isMirror(node1.left, node2.right) &&
                isMirror(node1.right, node2.left);
    }
}
