package leetcode;

import java.util.Arrays;

/**
 *
 * --- 同向双指针的题 ---
 * ---- 1 ---------------
 *  * Leetcode 209. Minimum Size Subarray Sum
 *  * Input: target = 7, nums = [2,3,1,2,4,3]
 *  * Output: 2
 *  * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * @author huimin
 * @create 2022-12-05 23:22
 */
public class T209_Min_size_subarray_sum {
    // 同向双指针 滑动窗口
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int j=0; // fast pointer
        for(int i=0; i<n; i++){
            while(j < n && sum < target){
                sum += nums[j++];
            }
            if(sum >= target){
                min = Math.min(min, j-i);
            }
            sum -= nums[i];
        }

        return (min ==Integer.MAX_VALUE)? 0: min;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int minimumLength=Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right ++){
            sum += nums[right];
            while(left <= right && sum >= target){
                minimumLength = Math.min(minimumLength, right-left+1);
                sum -= nums[left];
                left ++;
            }
        }
        return (minimumLength == Integer.MAX_VALUE)? 0: minimumLength;
    }
}
