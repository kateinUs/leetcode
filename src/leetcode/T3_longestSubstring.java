package leetcode;

import java.nio.charset.CharacterCodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author huimin
 * @create 2021-08-23 10:08
 */
public class T3_longestSubstring {
    public static void main(String[] args) {
        String str = "tmmzuxt";
        int res = longestSubstring(str);
        System.out.println(res);
    }

    public static int longestSubstring(String s) {
        if(s == "")
            return 0;
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int curMax = 0;
        int globalMax = curMax;
        int n=0;
        for(int i=0; i<len; i++){
            if(!map.keySet().contains(s.charAt(i))){
                map.put(s.charAt(i), i);
                curMax = i-n+1;
                globalMax = Math.max(curMax, globalMax);
            }else{
                n = map.get(s.charAt(i)) + 1;
                map.clear();
                for(int j=n; j<=i; j++){
                    map.put(s.charAt(j), j);
                }
            }
        }
        return globalMax;
    }

    // Method 1: Sliding window by HashMap
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    // Method 2: use array to store the occurence time of each char
    public int lengthOfLongestSubstring3(String s){
        int[] chars = new int[128];
        int left = 0;
        int right = 0;

        int ans =0;
        while(right < s.length()){
            char r = s.charAt(right);
            chars[r] ++;

            while(chars[r] > 1){
                char l = s.charAt(left);
                chars[l] --;
                left++;
            }
            ans = Math.max(ans, right-left+1);

            right++;
        }
        return ans;
    }

}
