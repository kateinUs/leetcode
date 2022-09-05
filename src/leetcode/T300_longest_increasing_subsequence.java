package leetcode;

import java.util.Arrays;

/**
 * @author huimin
 * @create 2022-06-14 14:43
 */
public class T300_longest_increasing_subsequence {
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len];
        int ans = 1;
        Arrays.fill(arr, 1);
        for (int i = 1; i < len; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i])
                    max = Math.max(max, arr[j]);
            }
            if (max != Integer.MIN_VALUE) {
                arr[i] = max + 1;
                ans = Math.max(ans, arr[i]);
            }
        }
        return len;
    }
}
