package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huimin
 * @create 2022-08-01 16:55
 */
public class T113_Path_sum_2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, new LinkedList<Integer>(), targetSum, res);
        return res;
    }
    void helper(TreeNode node, LinkedList<Integer> path, int sum, List<List<Integer>> res){
        if(node == null) return;
        sum -= node.val;
        path.add(node.val);
        if(node.left == null && node.right == null){
            if(sum == 0)
                res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }

        helper(node.left, path, sum, res);
        helper(node.right, path, sum, res);
        path.removeLast();

    }
}
