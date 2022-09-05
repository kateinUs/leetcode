package leetcode;

import java.util.LinkedList;

/**
 * @author huimin
 * @create 2022-08-01 14:41
 */
public class T112_Path_sum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }
    boolean dfs(TreeNode node, int sum, int target){
        // the node is a leaf
        if(node == null) return false;
        if(node.left == null && node.right == null){
            if(sum + node.val == target)
                return true;
            else return false;
        }
        return dfs(node.left, sum + node.val, target) || dfs(node.right, sum + node.val, target);
    }

}
