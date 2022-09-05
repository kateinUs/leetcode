package oa;

import jdk.nashorn.api.tree.Tree;

import java.util.*;

/**
 * @author huimin
 * @create 2022-03-10 15:12
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
    }

}
public class Hoffman_Tree {

    HashMap<Character, Integer> map;
    TreeNode root;

    Hoffman_Tree(HashMap<Character, Integer> map){
        this.map = map;
    }

    public TreeNode buildTree(HashMap<Character, Integer> map){
        TreeNode root = null;
        HashMap<Integer, TreeNode> freqTreeMap = new HashMap<>();
        char curr = 0;
        while(map.size()>1){
            List<Character> nodes = findLeastFrequnt(map);
            int rightVal = map.get(nodes.get(0));
            map.remove(nodes.get(0));
            TreeNode rightNode;
            if(freqTreeMap.containsKey(rightVal))
                rightNode = freqTreeMap.get(rightVal);
            else
                rightNode = new TreeNode(rightVal);

            int leftVal = map.get(nodes.get(1));
            map.remove(nodes.get(1));
            TreeNode leftNode;
            if(freqTreeMap.containsKey(leftVal))
                leftNode = freqTreeMap.get(leftVal);
            else
                leftNode = new TreeNode(leftVal);
            TreeNode parent = new TreeNode(rightNode.val +leftNode.val);
            map.put(curr++,parent.val);
            freqTreeMap.put(parent.val, parent);
        }
        int maxFreq= 0;
        for(int i: map.values())
            maxFreq = i;

        return freqTreeMap.get(maxFreq);
    }

    public List<Character> findLeastFrequnt(HashMap<Character, Integer> map){
        List<Character> res = new ArrayList<>();
        Queue<Character> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            Character c = entry.getKey();
            Integer i = entry.getValue();
            heap.add(c);
            if(heap.size()>2)
                heap.remove();
        }
        res.add(heap.remove());
        res.add(heap.remove());
        return res;
    }

    public String encode(Character ch){
        root = buildTree(map);
        int freq = map.get(ch);

//        String path = findPath(ch, root);
        return null;
    }

    private String findPath(Character ch, TreeNode root, String path) {
        if(root == null)
            return "";
        if(map.get(ch) == root.val)
            return path;
        if(map.get(ch) < root.left.val)
            findPath(ch, root.left, path+"0");
        if(map.get(ch) < root.right.val)
            findPath(ch, root.right, "1");

        return path;
    }

    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 9);
        map.put('B', 2);
        map.put('C', 4);
        map.put('D', 5);
        map.put('E', 8);
        map.put('F', 1);

        Hoffman_Tree ht= new Hoffman_Tree(map);
        ht.root =ht.buildTree(map);
        System.out.println(ht.root.val);

    }
}
