package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Method:
 *      Using DFS
 * Time complexity: O(n)
 * only call the function recursively when current node's val:
 * 1) node.val > low -> means left tree may have some values in the range
 *      so call func(root.left)
 * 2) node.val < high -> means right tree may have some values in the range
 *      so call func(root.right)
 * @author huimin
 * @create 2022-01-18 0:21
 */
public class T938_range_sum_of_BST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;
        int sum = 0;
        if(root.val >= low && root.val <= high)
            sum += root.val;
        if(root.val > low)
            sum += rangeSumBST(root.left, low, high);
        if(root.val <high)
            sum += rangeSumBST(root.right, low, high);
        return sum;
    }
}
