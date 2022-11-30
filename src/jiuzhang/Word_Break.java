package jiuzhang;

import java.util.*;

/**
 * Lintcode 107: word break 1 (T/F)
 * Leetcode 139
 * 给定字符串 s 和单词字典 dict，确定 s 是否可以分成一个或多个以空格分隔的子串，并且这些子串都在字典中存在。
 * 例：Input: s = "lintcode", dict = ["lint", "code"]
 *     Output: True
 * 分析：返回T/F，可行性问题可以用动态规划，也可以DFS with memo
 *
 * Lintcode 582: word break 2 (求具体方案)
 * Leetcode 140
 * 给一字串s和单词的字典dict,在字串中增加空格来构建一个句子，并且所有单词都来自字典。返回所有有可能的句子。
 * 例：Input: s="lintcode", dict = ["de","ding","co","code","lint"]
 *     Output: ["lint code", "lint co de"]
 * 分析：返回的是单词的不同拆分方式，所以不能用动态规划，只能DFS，用memo可以优化普通DFS的解法
 *
 * Lintcode 683: word break 3 (求方案数 DP)
 * 给出一个单词表和一条去掉所有空格的句子，根据给出的单词表添加空格, 返回可以构成的句子的数量。忽略大小写
 * 例：Input: s = "CatMat", dict = ["Cat", "Mat", "Ca", "tM", "at", "C", "Dog", "og", "Do"]
 *     Output: 3 （以下三种拆分方式）
 *      "CatMat" = "Cat" + "Mat"
 *      "CatMat" = "Ca" + "tM" + "at"
 *      "CatMat" = "C" + "at" + "Mat"
 * 分析：求解方案数可以用动态规划
 * @author huimin
 * @create 2022-11-29 0:28
 */
public class Word_Break {
    public static void main(String[] args) {
        Word_Break test = new Word_Break();
        String s = "lintcode";
        String[] dictArr = {"de","ding","co","code","lint", "li", "nt"};
        Set<String> dictSet = new HashSet<String>(Arrays.asList(dictArr));
        System.out.println("Result of word search 2");
        List<String> res2 = test.wordBreak2(s, dictSet);
        res2.forEach(System.out::println);
        System.out.println("Result of word search 3");
        System.out.println(test.wordBreak3(s, dictSet));
    }
    public boolean wordBreak1(String s, Set<String> wordSet) {
        // write your code here

        return false;
    }

    // 例：Input: s="lintcode", dict = ["de","ding","co","code","lint"]
    //     Output: ["lint code", "lint co de"]
    public List<String> wordBreak2(String s, Set<String> wordDict) {

        HashMap<Integer, List<String>> memo = new HashMap<>();
        return dfstwo(s, wordDict, getMaxLen(wordDict), 0, memo);
    }
    int getMaxLen(Set<String> wordDict){
        int max = 0;
        for(String s: wordDict){
            if(s.length() > max)
                max = s.length();
        }
        return max;
    }
    List<String> dfstwo(String s, Set<String> dict, int maxLen, int start, HashMap<Integer, List<String>> memo){
        List<String> ans = new ArrayList<>();
        if(start == s.length()){
            ans.add("");
            return ans;
        }
        for(int i=start+1; i<=start+maxLen && i<=s.length(); i++){
            String tmp = s.substring(start, i);
            if(!dict.contains(tmp)){
                continue;
            }
            List<String> breakWays = dfstwo(s, dict, maxLen, i, memo);
            for(String way: breakWays){
                if(way.equals("")){
                    ans.add(tmp);
                    continue;
                }
                ans.add(tmp + " " + way);
            }
        }
        memo.put(start, ans);
        return ans;
    }

    public int wordBreak3(String s, Set<String> dict) {
        // Write your code here
        Map<Integer, Integer> memo = new HashMap<>();
        return dfsthree(s, dict, getMaxLen(dict), 0, memo);
    }

    int dfsthree(String s, Set<String> dict, int maxLen, int start, Map<Integer, Integer> memo){
        int ans = 0;
        if(start == s.length()){
            return 1;
        }
        for(int i=start+1; i<=start+maxLen && i<=s.length(); i++){
            String tmp = s.substring(start, i);
            if(!dict.contains(tmp)){
                continue;
            }
            int breakWays = dfsthree(s, dict, maxLen, i, memo);
            ans += breakWays;
        }
        memo.put(start, ans);
        return ans;
    }

}
