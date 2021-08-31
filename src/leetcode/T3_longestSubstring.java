package leetcode;

import java.nio.charset.CharacterCodingException;
import java.util.HashMap;
import java.util.HashSet;

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

}
