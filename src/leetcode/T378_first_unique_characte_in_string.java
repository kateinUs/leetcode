package leetcode;

import javax.net.ssl.SSLEngine;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author huimin
 * @create 2021-09-09 21:34
 */
public class T378_first_unique_characte_in_string {
    // Method1: use hashmap,
    // key is the char and value is the position of its first occurrence
    // Time complexity: O(N)
    public int firstUniqChar(String s) {
        int first_char = -1;
        HashMap<Character, Integer> unique = new HashMap<>();
        for(int i=0; i<s.length(); ++i) {
            char ch = s.charAt(i);
            if(!unique.keySet().contains(ch)){
                unique.put(ch, i);
            } else {
                unique.put(ch, -1);
            }
        }
        for (Integer value: unique.values()) {
            if(first_char == -1)
                first_char = value;
            if(value > 0 && value < first_char)
                first_char = value;
        }
        return first_char;
    }

    // Method2: Use HashMap too
    // but key is char, value is the occurrence time of the char
    public int firstUniqChar2(String s) {
        HashMap<Character, Integer> occur = new HashMap<>();

        for(int i=0; i<s.length(); ++i){
            char ch = s.charAt(i);
            /*if(!occur.keySet().contains(ch))
                occur.put(ch, 1);
            else
                occur.put(ch, occur.get(ch) + 1);*/
            // TODO: 这四行可以简写成以下这行 ***getOrDefault***
            occur.put(ch, occur.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<s.length(); ++i){
            if(occur.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
