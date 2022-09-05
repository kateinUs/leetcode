package leetcode;

/**
 * @author huimin
 * @create 2021-09-18 12:59
 */
public class T5_longest_palindromic_substring {
    // Method 1: 使用二维数组，空间复杂福 O(N^2) 时间也是
    public String longestPalindrome(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n]; // dp[i][j] will be 'true' if the string from index 'i' to index 'j' is a palindrome
        int max = 0;
        int start = 0, end = 0;

        // every string with one character is a palindrome
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {

                if(s.charAt(i) == s.charAt(j)) {
                    // if it's a two character string or if the remaining string is a palindrome too
                    if(j - i == 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;

                        // 判断此结果是否为max，如果是把start和end替换成新的
                        int len = j - i + 1;
                        if(len >= max) {
                            max = Math.max(max, len);
                            start = i;
                            end = j;
                        }
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }
}
