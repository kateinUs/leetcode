package leetcode;

/**
 * 这题重点在于找到一个节点的值的上限和下限
 * @author huimin
 * @create 2021-09-01 3:43
 */
public class T98_validate_binary_search_tree {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    public boolean validate(TreeNode root, Integer low, Integer high) {
        if(root == null)
            return true;
        if((low != null && root.val <= low) || (high != null && root.val >= high))
            return false;

        return validate(root.left, low, root.val) && validate(root.right, root.val, high);
    }
}
