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

    // Method1: DP
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        // 这边数组需要多建一位，是因为String的substring方法中传入的第二个参数要比截取到的字符的最后一位大一
        // dp数组中每个数的涵义是 从0到这位数是否可以拼成，比如 substring(0, 3)
        // 比如 dict = {leet, code}, word = leetcode
        // dp[4] = true, because leet is in the dict
        // then dp[8] = true beacause dp[4] = true and substring(4, 8) -> code is in dict
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

    // method 2: DFS with memo
    public boolean wordBreak2(String s, List<String> dict){
        if(s == null || s.length() == 0)
            return true;
        if(dict == null || dict.size()==0 )
            return false;
        int maxLen = 0;
        Set<String> dictSet = new HashSet<>();

        for(String word: dict){
            dictSet.add(word);
            maxLen = Math.max(maxLen, word.length());
        }
        return dfs(s, 0, maxLen, dictSet, new HashMap<Integer, Boolean>());
    }

    private boolean dfs(String s, int index, int maxLen, Set<String> dict, Map<Integer, Boolean> memo){
        // if the current has been calculated, return what is cached in the memo dict
        if(memo.containsKey(index)) return memo.get(index);
        // if we reach the last index, then means of those word in dict, we can construct the word we want
        if(index == s.length()) return true;

        for(int end = index+1; end<s.length(); end++){
            // 剪枝 如果(end-index)对最长单词长度，那么从index到end的这个单词一定不出现在dict中，直接break，缩短查找时间
            if(end - index > maxLen) break;

            String word = s.substring(index, end);
            if(!dict.contains(word))
                continue;
            if(dfs(s, end, maxLen, dict, memo))
                return true;
        }
        memo.put(index, false);
        return false;
    }
}
