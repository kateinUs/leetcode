package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javafx.util.Pair;
/**
 * @author huimin
 * @create 2022-08-29 0:14
 */
public class T115_Distinct_subsequences {
    Map<Pair<Integer, Integer>, Integer> memo;
    public int numDistinct(String s, String t) {
        memo = new HashMap<>();
        return recurse(s, t, 0, 0);
    }
    int recurse(String s, String t, int i, int j){
        int M = s.length();
        int N = t.length();

        if(i ==M || j == N || M- i < N-j){
            return j == N? 1:0;
        }
        Pair<Integer, Integer> key = new Pair<>(i, j);

        if(memo.containsKey(key)){
            return memo.get(key);
        }
        // 就算两个char相等也可以跳过去
        // 两种case都需要计算这个recursion
        int ans = recurse(s, t, i+1, j);
        if(s.charAt(i) == t.charAt(j)){
            ans += recurse(s, t, i+1, j+1);
        }

        memo.put(key, ans);
        return ans;
    }
}
