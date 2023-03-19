package leetcode;

/**
 * @author huimin
 * @create 2023-02-14 23:17
 */
public class T416_Partition_Equal_Subset_Sum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums){
            sum += i;
        }
        // 找不同组合使得合等于sum/2
        if(sum % 2 != 0){
            return false;
        }
        int n = nums.length;
        sum = sum/2;
        // 变成0-1背包问题
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0; i<=n; i++){
            dp[i][0] = true;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(j >= nums[i-1]){
                    dp[i][j] = (dp[i-1][j] || dp[i-1][j-nums[i-1]]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // 空间优化
        /*boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for (int curr : nums) {
            for (int j = subSetSum; j >= curr; j--) {
                dp[j] |= dp[j - curr];
            }
        }*/

        return dp[n][sum];
    }
}
