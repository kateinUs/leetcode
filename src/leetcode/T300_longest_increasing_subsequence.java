package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huimin
 * @create 2022-06-14 14:43
 */
public class T300_longest_increasing_subsequence {
    // Greedy with DP
    // O(nlogn)
    // 用ArrayList实现dp数组
    public int lengthOfLIS(int[] nums) {
        // boundary check
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for(int i=1; i<nums.length; i++){
            if(nums[i] > sub.get(sub.size()-1)){
                sub.add(nums[i]);
            }else{
                // 直接掉包
                // int index= Collections.binarySearch(sub, nums[i]);
                // if(index < 0)
                // index= -index-1;
                // 自己实现一个binarySearch，返回的是插入位置，如果找到这个数直接返回这个数的位子
                int index = findInsertPos(sub, nums[i]);
                sub.set(index, nums[i]);
            }
        }
        return sub.size();
    }

    // 用数组实现dp数组
    int findInsertPos(List<Integer> list, int target){
        int left =0, right = list.size()-1;
        while(left<= right){
            int mid = left +(right-left)/2;
            if(list.get(mid) == target){
                return mid;
            } else if(list.get(mid) > target){
                right = mid-1;
            } else{
                left= mid+1;
            }
        }
        return left;
    }

    // 答案里的方法
    // public int lengthOfLIS(int[] nums) {
    //     int[] dp = new int[nums.length];
    //     int len = 0;
    //     for (int num : nums) {
    //         int i = Arrays.binarySearch(dp, 0, len, num);
    //         if (i < 0) {
    //             i = -(i + 1);
    //         }
    //         dp[i] = num;
    //         if (i == len) {
    //             len++;
    //         }
    //     }
    //     return len;
    // }

    // O(n^2) solution by DP
     public int lengthOfLIS_dp(int[] nums) {
         int n = nums.length;
         int[] dp = new int[n];
         Arrays.fill(dp, 1);
         for(int i=1; i<n; i++){
             for(int j=0; j<i; j++){
                 if(nums[i] > nums[j]){
                     dp[i] = Math.max(dp[i], dp[j]+1);
                 }
             }
         }
         return Arrays.stream(dp).max().getAsInt();
     }
}
