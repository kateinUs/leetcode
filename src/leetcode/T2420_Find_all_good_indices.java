package leetcode;

import java.util.*;

/**
 * @author huimin
 * @create 2022-09-25 1:43
 */
public class T2420_Find_all_good_indices {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n= nums.length;
        Set<Integer> dec = new HashSet<>();
        Set<Integer> inc = new HashSet<>();
        int decCount =1, incCount = 1;
        if(k == 1){
            List<Integer> res = new ArrayList<>();
            for(int i=1; i<n-1; i++)
                res.add(i);
            return res;
        }
        for(int i=1; i<n; i++){
            if(nums[i-1] >= nums[i]){
                decCount ++;
                if(decCount >= k) dec.add(i+1);
            }else
                decCount = 1;
            if(nums[i-1] <= nums[i]){
                incCount++;
                if(incCount >=k) inc.add(i-k);
            }else
                incCount =1;
        }
        dec.retainAll(inc);
        List<Integer> res = new ArrayList<>(dec);
        Collections.sort(res);
        return res;
    }


    // other good methods: DP
    //https://leetcode.com/problems/find-all-good-indices/discuss/2620472/JavaPython-3-Compute-the-increase-and-decrease-array.
    public List<Integer> goodIndices2(int[] nums, int k) {
        int n = nums.length;
        int[] non_dec = new int[n], non_inc = new int[n];
        Arrays.fill(non_dec, 1);
        Arrays.fill(non_inc, 1);
        for (int i = 1; i < n; ++i) {
            if (nums[i] == nums[i - 1]) {
                non_dec[i] = non_dec[i - 1] + 1;
                non_inc[i] = non_inc[i - 1] + 1;
            }else if (nums[i] < nums[i - 1]) {
                non_inc[i] = non_inc[i - 1] + 1;
            }else {
                non_dec[i] = non_dec[i - 1] + 1;
            }
        }
        List<Integer> good = new ArrayList<>();
        for (int i = k; i < n - k; ++i) {
            if (non_inc[i - 1] >= k && non_dec[i + k] >= k) {
                good.add(i);
            }
        }
        return good;
    }
}
