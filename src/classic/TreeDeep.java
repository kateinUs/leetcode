package classic;


import java.util.Queue;

/**
 * 要求： 求二叉树的最小深度
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量
 * 1. 深度优先
 * 2. 广度优先
 * @author huimin
 * @create 2021-08-02 19:32
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class TreeDeep {

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, node7, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node6, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println();
    }

    // 深度优先
    // Rule：
    // 1、没有左右子节点的node深度为1
    // 2、有子节点的node，深度为左右子节点中较小的深度+1
    public static int minDepth_depthFirst(TreeNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;

        int depth = Integer.MAX_VALUE;
        if(root.left != null){
            depth = Math.min(depth, minDepth_depthFirst(root.left));
        }
        if(root.right != null){
            depth = Math.min(depth, minDepth_depthFirst(root.right));
        }

        return depth+1;
    }

    public static int minDepth_widthFirst(TreeNode root){
        if(root == null)
            return 0;


        return 0;
    }
}
