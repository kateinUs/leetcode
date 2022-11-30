package jiuzhang;

/**
 * @author huimin
 * @create 2022-11-30 1:47
 */
public class T89_Ksum {

    public int kSum(int[] a, int k, int target) {
        // 只能用DP，DFS with memo也超时
        int[][][] dp = new int[a.length+1][k+1][target+1];
        // 初始化
        // 取0个数 target=0 有一种取法
        for(int i=0; i<a.length+1; i++){
            dp[i][0][0] = 1;
        }
        // i表示前i个数
        // j表示取几个数
        // t表示目标总数是多少
        for(int i=1; i<=a.length; i++){
            for(int j=1; j<=k && j<=i; j++){
                for(int t=1; t<=target; t++){
                    if(t>= a[i-1]){
                        dp[i][j][t] = dp[i-1][j][t]+ dp[i-1][j-1][t-a[i-1]];
                    }else{
                        dp[i][j][t] = dp[i-1][j][t];
                    }
                }
            }
        }

        return dp[a.length][k][target];
    }
}
