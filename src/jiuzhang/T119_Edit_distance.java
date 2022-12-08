package jiuzhang;

import java.util.HashSet;
import java.util.Set;

/**
 * Lintcode 119: 求最短编辑距离
 * 给出两个单词word1和word2，计算出将word1 转换为word2的最少操作次数。
 * 你可进行三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * e.g. word1 = "horse"
 *      word2 = "ros"
 *      Output = 3
 * 解释：
 *      horse -> rorse (替换 'h' 为 'r')
 *      rorse -> rose (删除 'r')
 *      rose -> ros (删除 'e')
 * @author huimin
 * @create 2022-12-01 16:34
 */
public class T119_Edit_distance {

    public int minDistance(String word1, String word2) {
        // write your code here
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            dp[i][0] = i;
        }
        for(int j=1; j<=n; j++){
            dp[0][j] = j;
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<= n; j++){
                dp[i][j] = Integer.MAX_VALUE;
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    // edit
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]+1);
                    // add
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+1);
                    // remove
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+1);
                }

            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        System.out.println(set.contains(null));
        set.add(null);
        System.out.println(set.contains(null));
        Math.ceil(1);

    }
}
