package classic;

import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huimin
 * @create 2021-08-22 21:44
 */
public class BinaryTree {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, node7, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node6, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        preorder(node1);
        inorder(node1);
        postorder(node1);
    }

    public static void preorder(TreeNode root) {
        if(root == null)
            return ;
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);

    }

    public static void inorder(TreeNode root){
        if(root == null)
            return ;
        inorder(root.left);
        System.out.println(root);
        inorder(root.right);
    }

    public static void postorder(TreeNode root){
        if(root == null)
            return ;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }

    public static void levelorder(TreeNode root, int i, ArrayList list){
        if(root == null)
            return ;
        int len = list.size();
        if(len <= i){
            for(int j=0; j<i-len; j++){
                list.add(len+j, null);
            }
        }
        list.set(i, root.val);
        levelorder(root.left, 2*i, list);
        levelorder(root.right, 2*1+1, list);
    }
}
