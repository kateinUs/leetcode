package leetcode;


/**
 * @author huimin
 * The core is to use resursion method.
 * Imagine you are merge two tree with only root node, then you should add the two value of root nodes and return it;
 * If the left tree is empty, but right tree has number, then you just return the right tree value; and vice versa
 * Then if you have a node that is not a empty node and not a single node tree, then you should add its left tree and
 * right tree perspectively, and use the recursion method to calculate its subtrees.
 * @create 2021-07-17 17:08
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class T617_merge_two_binary_tree {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        TreeNode sum = new TreeNode(t1.val + t2.val);
        sum.left = mergeTrees(t1.left, t2.left);
        sum.right = mergeTrees(t1.right, t2.right);

        return sum;

    }
}
