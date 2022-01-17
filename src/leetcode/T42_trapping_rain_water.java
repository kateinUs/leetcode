package leetcode;


/**
 * Method:
 *     Calculate max height upto the given point to the left and right
 *     add then together and substract the block height itself
 * @author huimin
 * @create 2021-09-10 22:29
 */
public class T42_trapping_rain_water {
    public int trap(int[] height) {
        int len = height.length;
        if(len == 0)
            return 0;
        int ans = 0;
        int[] left_max = new int[len], right_max = new int[len];
        // find max height upto the given point from left end
        left_max[0] = height[0];
        for(int i=1; i<len -1; ++i){
            left_max[i] =  Math.max(height[i], left_max[i-1]);
        }
        // find max height upto the given point from right end
        right_max[len-1] = height[len-1];
        for(int i=len-2; i>=0; --i){
            right_max[i] = Math.max(height[i], right_max[i+1]);
        }
        // don't need to calculate the first and last cell, cas it can't retain water
        for(int i=1; i<len-1; ++i){
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }
}
