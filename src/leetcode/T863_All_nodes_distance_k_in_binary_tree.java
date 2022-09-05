package leetcode;

import java.util.*;

/**
 * First use DFS to get all node's parent
 * Then use BFS to find nodes with distance k to the target node
 * @author huimin
 * @create 2022-07-20 15:57
 */
public class T863_All_nodes_distance_k_in_binary_tree {
    Map<TreeNode, TreeNode> parentMap; // map child to parent
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parentMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        dfs(root);
        // run BFS, starting from the target node
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        Set<TreeNode> seen = new HashSet<>();
        for(; k>=1; k--){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode cur = q.poll();
                seen.add(cur);
                if(cur.left!=null && !seen.contains(cur.left))
                    q.offer(cur.left);
                if(cur.right != null && !seen.contains(cur.right))
                    q.offer(cur.right);
                if(parentMap.containsKey(cur) && !seen.contains(parentMap.get(cur)))
                    q.offer(parentMap.get(cur));
            }
        }
        for(TreeNode node: q){
            res.add(node.val);
        }
        return res;
    }
    public void dfs(TreeNode node){
        if(node == null)
            return;
        if(node.left != null){
            parentMap.put(node.left, node);
            dfs(node.left);
        }
        if(node.right != null){
            parentMap.put(node.right , node);
            dfs(node.right);
        }
    }
}
