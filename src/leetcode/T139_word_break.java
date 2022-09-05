package leetcode;

import java.util.*;

/**
 * @author huimin
 * @create 2021-09-18 23:11
 */
public class T139_word_break {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> list = Arrays.asList("leet", "code");
        boolean res = wordBreak(s, list);
        System.out.println(res);
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        // 这边数组需要多建一位，是因为String的substring方法中传入的第二个参数要比截取到的字符的最后一位大一
        boolean[] dp = new boolean[s.length()+1];
        // 第一位初始化是true，因为substring(0,0)，是null，一定包含在set中
        dp[0] = true;
        // i是从1循环到s.length()
        // i是快指针，j是满指针
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if(dp[j] && wordDictSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
