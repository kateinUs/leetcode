package leetcode;

import java.util.Arrays;

/**
 * @author huimin
 * @create 2022-02-21 1:55
 */
public class T16_3Sum_Closet {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        // fix a number
        for(int i=0; i<=len-3; i++){
            int lo = i+1;
            int hi = len-1;
            while(lo<hi){
                int sum =nums[i] + nums[lo] + nums[hi];
                if(Math.abs(target - sum) < Math.abs(diff)){
                    diff = target - sum;
                }
                if(sum == target)
                    return target;
                else if(sum > target){
                    hi--;
                }
                else{
                    lo++;
                }
            }
        }

        return target - diff;
    }
}
