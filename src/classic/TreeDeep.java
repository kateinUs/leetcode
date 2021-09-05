package classic;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 要求： 求二叉树的最小深度
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量
 * 1. 深度优先 空间O(logN) 时间O(N)
 * 2. 广度优先 空间O(N) 时间O(N)
 * @author huimin
 * @create 2021-08-02 19:32
 */

public class TreeDeep {

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, node7, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node6, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(minDepth_depthFirst((node1)));
        System.out.println(minDepth_widthFirst((node1)));
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

    // 广度优先
    // 需要新建一个queue
    // 并且要求TreeNode 有deep属性
    public static int minDepth_widthFirst(TreeNode root){
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        root.deep = 1;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left == null && node.right == null){
                return node.deep;
            }
            if(node.left != null){
                node.left.deep = node.deep + 1;
                queue.offer(node.left);
            }
            if(node.right != null){
                node.right.deep = node.deep + 1;
                queue.offer(node.right);
            }
        }

        return 0;
    }
}
