package leetcode;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Method: BFS
 * @author huimin
 * @create 2022-02-04 18:50
 */
public class T314_Binary_tree_vertical_order_traversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));
        while(!q.isEmpty()){

            Pair<TreeNode, Integer> currPair = q.remove();
            TreeNode currNode = currPair.getKey();
            Integer vertIndex = currPair.getValue();
            List<Integer> oldLst = map.getOrDefault(vertIndex, new ArrayList<>());
            oldLst.add(currNode.val);
            map.put(vertIndex, oldLst);
            if(currNode.left != null){
                q.add(new Pair<>(currNode.left, vertIndex -1));
            }
            if(currNode.right != null){
                q.add(new Pair<>(currNode.right, vertIndex +1));
            }
        }

        Set set = map.keySet();
        Integer[] arr = (Integer[]) set.toArray(new Integer[0]);
        Arrays.sort(arr);

        for(Integer i: arr){
            res.add(map.get(i));
        }
        return res;
    }
}
