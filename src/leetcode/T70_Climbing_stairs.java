package leetcode;

/**
 * @author huimin
 * @create 2022-02-18 20:45
 */
public class T70_Climbing_stairs {
    // Method 1: Use memorization
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        return climb(0, n, memo);
    }
    public int climb(int i, int n, int[] memo){
        if(i > n)
            return 0;
        if(i == n){
            return 1;
        }
        if(memo[i] > 0)
            return memo[i];
        memo[i] = climb(i+1, n, memo) + climb(i+2, n, memo);
        return memo[i];
    }

    // Method 2: dynamic programming
    public int climnStairs2(int n){

        int[] dp = new int[n+1];
        dp[1] = 1; // 一层只有一只爬楼方式
        dp[2] = 2;// 2 or 1+1
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        return dp[n];
    }
}
