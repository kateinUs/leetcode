package leetcode;

import java.util.Arrays;

/**
 * @author huimin
 * @create 2022-08-28 22:56
 */
public class T279_Perfect_squares {
    // greedy + recursion + memo
    int[] memo;
    public int numSquares(int n) {
        // dp
        memo = new int[n+1];
        if(n<=3) return n;
        for(int i=1; i<=3; i++){
            memo[i] = i;
        }
        return helper(n);
    }
    int helper(int n){
        // System.out.println(n);
        if(n==0) return 0;
        if(memo[n] != 0) return memo[n];
        int k = (int)Math.sqrt(n);
        int min= Integer.MAX_VALUE;
        for(int i=k; i>=1; i--){
            memo[i*i] = 1;
            min = Math.min(min, 1+helper(n-i*i));

        }
        memo[n] = min;
        return min;
    }

    // dp
    public int numSquares_dp(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // bottom case
        dp[0] = 0;

        // pre-calculate the square numbers.
        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; ++i) {
            square_nums[i] = i * i;
        }

        for (int i = 1; i <= n; ++i) {
            for (int s = 1; s < max_square_index; ++s) {
                if (i < square_nums[s])
                    break;
                dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
            }
        }
        return dp[n];
    }
}
