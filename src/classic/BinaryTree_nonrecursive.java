package classic;

import java.util.PriorityQueue;
import java.util.Stack;
import java.util.function.Predicate;

/**
 * 非递归实现二叉树前序遍历
 * @author huimin
 * @create 2022-11-26 17:16
 */
public class BinaryTree_nonrecursive {

    public static void inorder_nonrecursive111(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();

        while(root != null){
            stack.add(root);
            root = root.left;
        }
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            System.out.println(cur.val);
            cur = cur.right;
            while(cur != null){
                stack.add(cur);
                cur = cur.left;
            }
        }
    }
    public static void inorder_nonrecursive(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }

        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            System.out.println(cur.val);
            cur = cur.right;
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
        }
    }

    public static void preorder_nonrecursive(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            System.out.println(cur.val);
            if(cur.right != null) stack.add(cur.right); // 先把right放栈底，后一次while pop出来的就是左边节点 如果左节点存在的话
            if(cur.left != null) stack.add(cur.left);
        }
    }

    public static void postorder_nonrecursive(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode cur, pre = null;
        while(!stack.isEmpty()){
            cur = stack.peek();

            if((cur.left == null &&cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))){
                System.out.println(cur.val);
                stack.pop();
                pre = cur;
                continue;
            }
            if(cur.right != null){
                stack.add(cur.right);
            }
            if(cur.left != null){
                stack.add(cur.left);
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

        System.out.println("Inorder traversal:");
        inorder_nonrecursive(node1);
        System.out.println();
        inorder_nonrecursive111(node1);
        // 4 2 5 1 7 6 3
        System.out.println("Preorder traversal:");
        preorder_nonrecursive(node1);
        // 1 2 4 5 3 6 7
        System.out.println("Postorder traversal:");
        postorder_nonrecursive(node1);
        // 4 5 2 7 6 3 1
        PriorityQueue<Integer> heap = new PriorityQueue<>();

    }


}
