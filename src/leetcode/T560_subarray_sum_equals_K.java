package leetcode;

import java.util.HashMap;

/**
 * Method:
 * 使用hashmap记录从nums[0] 到 当前遍历到的 nums[n]的和
 * 比如一开始是0,则在hashmap中加入(0, 1)；这里的0代表从前n位的和，1代表这个和出现的次数
 * 在之后的每次遍历中, 把当次的和减去 hashmap中有的和, 若差值为K，count+1, 代表又找到一个subarray和为K
 * @author huimin
 * @create 2022-01-16 20:35
 */
public class T560_subarray_sum_equals_K {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
