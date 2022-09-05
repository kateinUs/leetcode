package leetcode;

/**
 * @author huimin
 * @create 2022-04-20 23:13
 */
public class T236_Lowest_common_ancestor_of_a_binary_tree {
    private TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurse(root, p, q);
        return this.ans;

    }

    private boolean recurse(TreeNode curr, TreeNode p, TreeNode q){
        if(curr == null)
            return false;
        int left = recurse(curr.left, p, q)? 1:0;
        int right = recurse(curr.right, p, q)? 1:0;
        int mid = (curr == p || curr== q)? 1:0;
        if(left + right + mid >=2){
            this.ans = curr;
        }
        return (mid+right+left > 0);
    }
}
