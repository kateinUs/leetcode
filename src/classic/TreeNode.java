package classic;

/**
 * @author huimin
 * @create 2021-08-22 21:46
 */
public class TreeNode {
    int val;
    int deep;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
