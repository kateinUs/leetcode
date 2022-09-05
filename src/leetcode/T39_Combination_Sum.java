package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huimin
 * @create 2022-07-21 15:02
 */
public class T39_Combination_Sum {
    // 输出combination的数量
    public int combinationSumCount(int[] candidates, int target) {
        // 完全背包问题
        int n = candidates.length;
        int[][] dp = new int[n+1][target+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<target+1; j++){
                int sum = 0;
                for(int k=1; k*candidates[i-1]<=j; k++){
                    sum += dp[i][j-k*candidates[i-1]];
                }
                dp[i][j] = sum + dp[i-1][j];
            }
        }
        return dp[n][target];
    }

    List<List<Integer>> res;
    int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        this.candidates = candidates;
        recursion(new ArrayList<Integer>(), 0, target);
        return res;
    }
    public void recursion(List<Integer> curr, int start, int left){
        if(left == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(left < 0) return;
        for(int i=start; i<candidates.length; i++){
            curr.add(candidates[i]);
            recursion(curr, i, left - candidates[i]);
            curr.remove(curr.size()-1);
        }
    }
}
