package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author huimin
 * @create 2022-02-18 0:07
 */
public class T828_Count_unique_character_of_all_substring_of_a_given_string {
    public int uniqueLetterString(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        HashMap<Character, Integer> map = new HashMap<>();
        // loop from left to right
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            // left[i]存放当前字符 到 左边相同字符的距离，如果不存在则设为-1
            left[i] = map.getOrDefault(c, -1);
            map.put(c, i);
        }

        map.clear();
        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            right[i] = map.getOrDefault(c, s.length());
            map.put(c, i);
        }
        int res = 0;
        for(int i=0; i<s.length(); i++){
            int numToLeft = i - left[i];
            int numToRight = right[i] - i;
            res += (numToLeft * numToRight);
        }
        return res;

    }


}
