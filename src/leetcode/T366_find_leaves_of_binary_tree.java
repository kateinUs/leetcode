package leetcode;

import java.net.Inet4Address;
import java.util.*;

/**
 * Method 1: DFS + HashMap
 * @author huimin
 * @create 2022-01-26 22:18
 */
public class T366_find_leaves_of_binary_tree {
    // Method 1: DFS + HashMap
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        dfs(root);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<map.size(); i++){
            res.add(map.get(i));
        }
        return res;
    }
    int dfs(TreeNode node){
        if(node.left == null && node.right == null){
            List<Integer> levelList = map.getOrDefault(0, new ArrayList<Integer>());
            levelList.add(node.val);
            map.put(0, levelList);
            return 0;
        }
        int leftLevel = 0;
        int rightLevel = 0;

        if(node.left != null){
            leftLevel = dfs(node.left)+1;
        }
        if(node.right != null){
            rightLevel = dfs(node.right)+1;
        }
        int level = Math.max(leftLevel, rightLevel);
        List<Integer> levelList = map.getOrDefault(level, new ArrayList<Integer>());
        levelList.add(node.val);
        map.put(level, levelList);
        return level;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        T366_find_leaves_of_binary_tree cls= new T366_find_leaves_of_binary_tree();
        // Method 1 Testing: 
        List<List<Integer>> res = cls.findLeaves(t1);
        System.out.println(res);
    }
}
