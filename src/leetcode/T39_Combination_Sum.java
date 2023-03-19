package leetcode;

import java.sql.ConnectionBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给一个candidates列表，每个candidate可以用无数多次，求有多少种不同的组合
 * 例：
 *  Input: candidates = [2, 3, 7], target = 7
 *  Output: [2,2,3] and [7]
 * @author huimin
 * @create 2022-07-21 15:02
 */
public class T39_Combination_Sum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 7};
        int target = 7;
        System.out.println(combinationSumCount(candidates, target));
    }
    // 输出combination的数量
    public static int combinationSumCount(int[] candidates, int target) {
        // 完全背包问题
        //
        int n = candidates.length;
        int[][] dp = new int[n+1][target+1];
        for(int i=0; i<n+1; i++){
            dp[i][0] = 1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<target+1; j++){
                // 不同的方案总数
                for(int k=0; k*candidates[i-1]<=j; k++){
                    // 相当于i排你拿了K个，然后不能再拿i了，只能往i-1之前看
                    dp[i][j] += dp[i-1][j-k*candidates[i-1]];
                }
            }
        }
        /*for(int i=0; i<=n; i++) {
            for (int j =0; j < target + 1; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/

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
            // 如果arr里数据有重复，需要先排序，再加这个判断
            if(i > start && candidates[i] == candidates[i-1]){
                continue;
            }
            curr.add(candidates[i]);
            recursion(curr, i, left - candidates[i]);
            curr.remove(curr.size()-1);
        }
    }
}
