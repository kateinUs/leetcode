package leetcode;

import java.util.Arrays;

/**
 * @author huimin
 * @create 2022-07-20 16:31
 */
public class T128_Longest_consecutive_sequence {
    /** Method 1: Sort and greedy
     * Time complexity : O(nlgn)O(nlgn).
     * Space complexity: O(1)
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int globMax = 1;
        int currMax = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] - nums[i-1] == 1){
                currMax += 1;
            } else if(nums[i] != nums[i-1]){
                globMax = Math.max(globMax, currMax);
                currMax = 1;
            }
        }
        globMax = Math.max(globMax, currMax);
        return globMax;
    }
}
