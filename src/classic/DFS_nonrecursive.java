package classic;

import java.util.Stack;
import java.util.function.Predicate;

/**
 * 非递归实现二叉树前序遍历
 * @author huimin
 * @create 2022-11-26 17:16
 */
public class DFS_nonrecursive {

    public static void inorder_nonrecursive(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();

        while(root != null){
            stack.add(root);
            root = root.left;
        }
        while(!stack.isEmpty()){
            System.out.println(stack.peek().val);
            TreeNode cur = stack.pop();
            cur = cur.right;
            while(cur != null){
                stack.add(cur);
                cur = cur.left;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, node7, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node6, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        // BT:
        //       1
        //    2    3
        //  4 5   6
        //       7

        inorder_nonrecursive(node1);
        // 4 2 5 1 7 6 3


    }
}
