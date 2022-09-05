package leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author huimin
 * @create 2022-02-21 15:43
 */
public class T31_Next_Permutation {
    public void nextPermutation(int[] nums) {
        // find the first non decreasing element
        int i = nums.length-2;
        while(i>=0 && nums[i] >= nums[i+1])
            i--;
        // if i =0, means this permutation is increasing, so can't find next permutation
        if(i >= 0){
            // find the element exactly larger than A[i]
            int j= nums.length-1;
            while(nums[j] <= nums[i])
                j--;
            swap(nums, i, j);

        }

        reverse(nums, i+1);
    }
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
