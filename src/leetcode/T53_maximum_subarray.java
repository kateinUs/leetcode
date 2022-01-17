package leetcode;

/**
 * @author huimin
 * @create 2021-09-18 22:35
 */
public class T53_maximum_subarray {
    // Method 1: dynamic programming
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            max = Math.max(sum, max);
            if(sum < 0)
                sum = 0;
        }
        return max;
    }
    // method2: dynatic programming
    public int maxSubArray2(int[] nums) {
        // Initialize our variables using the first element.
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];

        // Start with the 2nd element since we already used the first one.
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
            currentSubarray = Math.max(num, currentSubarray + num);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }

        return maxSubarray;
    }
}
