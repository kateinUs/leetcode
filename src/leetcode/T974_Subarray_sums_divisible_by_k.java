package leetcode;

import java.util.HashMap;

/**
 * @author huimin
 * @create 2022-09-04 16:07
 */
public class T974_Subarray_sums_divisible_by_k {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            sum+= nums[i];
            int mod = Math.floorMod(sum,k);
            count+= map.getOrDefault(mod,0);
            map.put(mod, map.getOrDefault(mod,0) + 1);
        }
        return count;
    }
}
