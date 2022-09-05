package leetcode;

import java.util.LinkedList;

/**
 * @author huimin
 * @create 2021-09-12 21:27
 */
public class T33_search_in_roteted_sorted_array {
    int[] nums;
    int target;
    public int search(int[] nums, int target) {
        LinkedList list = new LinkedList();

        this.nums = nums;
        this.target = target;
        int len = nums.length;
        if(len == 1)
            return nums[0] == target? 0: -1;
        // 1. search the rotation index
        int rotation_index = find_ratate_index(0, nums.length - 1);
        // if the rotation index is 0, means this case has no rotation
        if(rotation_index == 0)
            return binary_search(0, len-1);
        if(target >= nums[0] && target <= nums[rotation_index-1])
            return binary_search(0, rotation_index-1);
        else if(target >= nums[rotation_index] && target <= nums[len-1])
            return binary_search(rotation_index, len-1);
        else
            return -1;
    }

    private int find_ratate_index(int left, int right) {
        if(nums[left] < nums[right])
            return 0;
        while (left <= right){
            int pivot = (left + right)/ 2;
            if(nums[pivot] > nums[pivot+1])
                return pivot+1;
            else{
                if(nums[pivot] < nums[left])
                    right = pivot -1;
                else
                    left = pivot +1;
            }
        }
        return 0;
    }
    public int binary_search(int left, int right){
        while(left <= right){
            int pivot = (left +right)/2;
            if(nums[pivot] == target)
                return pivot;
            else if(nums[pivot] > target)
                right = pivot -1;
            else
                left = pivot +1;
        }
        return -1;
    }
}
