package leetcode;

import java.util.HashMap;

/**
 * @author huimin
 * @create 2023-02-10 16:36
 */
public class T1027_Longest_Arithmetic_Subsequence {
    public int longestArithSeqLength(int[] nums) {
        int res = 2, n = nums.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int j = 0; j < nums.length; j++) {
            dp[j] = new HashMap<>();
            for (int i = 0; i < j; i++) {
                int d = nums[j] - nums[i];
                dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
                res = Math.max(res, dp[j].get(d));
            }
        }
        return res;
    }
}
