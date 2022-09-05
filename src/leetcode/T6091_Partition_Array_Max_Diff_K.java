package leetcode;

import java.util.*;

/**
 * @author huimin
 * @create 2022-06-04 22:54
 */
public class T6091_Partition_Array_Max_Diff_K {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        Integer min = null;
        int ans= 0;
        for(int i=0; i<nums.length; i++){
            if(min == null)
                min = nums[i];
            else{
                if(min + k < nums[i]){
                    min = nums[i];
                    ans++;
                }
            }
        }

        return ans+1;
    }

    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i=0; i<operations.length;i++){
            int orig = operations[i][0];
            int repl = operations[i][1];
            int idx= map.get(orig);
            nums[idx] = repl;
            map.remove(orig);
            map.put(repl, idx);
        }

        return nums;
    }
}
