package leetcode;

import java.util.ArrayList;

/**
 * @author huimin
 * @create 2022-01-25 22:08
 */

public class T129_sum_root_to_leaf_numbers {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    ArrayList<Integer> res = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        recursion(root, 0);
        int sum = 0;
        for(Integer i: res){
            sum += i;
        }
        return sum;
    }

    public void recursion(TreeNode node, int preSum){
        if(node == null)
            return;
        if(node.left == null && node.right == null){
            res.add(preSum*10+ node.val);
            return;
        }
        if(node.left != null){
            recursion(node.left, preSum*10+ node.val);
        }
        if(node.right != null){
            recursion(node.right, preSum*10+ node.val);
        }
    }

    public void test(){
        T129_sum_root_to_leaf_numbers cls = new T129_sum_root_to_leaf_numbers();
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        int res = cls.sumNumbers(t1);
        System.out.println(res);

    }
    public static void main(String[] args) {
        T129_sum_root_to_leaf_numbers cls = new T129_sum_root_to_leaf_numbers();
        cls.test();

    }
}