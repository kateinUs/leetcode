package leetcode;

/**
 * @author huimin
 * @create 2022-07-29 23:14
 */
public class T647_Palindromic_substrings {
    public static int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        boolean[][] dp = new boolean[n][n];
        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                if(i == j){
                    dp[i][j] = true;
                    count ++;
                    continue;
                }
                if(j - i==1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                    if(dp[i][j])
                        count++;
                }else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        for(boolean[] row: dp){
            for(boolean b:row){
                System.out.print(b + " ");
            }
            System.out.println();
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abc";
        int res = countSubstrings(s);
        System.out.println(res);
    }
}
