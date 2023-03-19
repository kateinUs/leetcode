package leetcode;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author huimin
 * @create 2023-03-09 1:32
 */
public class T321_Burst_Balloons {
    public int maxCoins(int[] nums) {
        if(nums == null) return 0;

        int n = nums.length +2;
        int[] arr = new int[n];
        for(int i=0; i<nums.length; i++){
            arr[i+1] = nums[i];
        }
        arr[0] = arr[n-1] = 1;

        int[][] dp = new int[n][n];
        for(int len = 3; len<=n; len++){
            for(int i=0; i<n-len+1; i++){
                int j=i+len-1;
                for(int k=i+1; k<j; k++){
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k] + dp[k][j] + arr[i]*arr[k]*arr[j]);
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        int[] a = new int[3];
        List<Integer> list = new ArrayList<>();
        int i = Collections.binarySearch(list, 4);
        a[0] = a[2] =1;
        System.out.println(Arrays.toString(a));
    }
}
