package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huimin
 * @create 2022-08-30 23:09
 */
public class T1065_Index_pairs_of_a_string {
    public int[][] indexPairs(String text, String[] words) {
        // build Trie
        List<int[]> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        for(String word: words){
            TrieNode curr = root;
            for(char c: word.toCharArray()){
                if(!curr.map.containsKey(c)){
                    curr.map.put(c, new TrieNode());
                }
                curr = curr.map.get(c);
            }
            curr.word = word;
        }

        for(int i=0; i<text.length(); i++){
            // char ch = text.charAt(i);
            int j = i;
            TrieNode curr = root;
            while(j< text.length() &&curr.map.containsKey(text.charAt(j))){

                curr = curr.map.get(text.charAt(j));
                if(curr.word != null){
                    res.add(new int[]{i, j});
                }
                j++;
            }
        }
        return res.toArray(new int[0][]);
    }
}

class TrieNode{
    Map<Character, TrieNode> map = new HashMap<>();
    String word = null;
    TrieNode(){

    }
}
