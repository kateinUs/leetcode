package leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author huimin
 * @create 2022-07-21 14:25
 */
public class T25_Search_insert_position {
    public static int searchInsert(int[] nums, int target) {
        // binary search
        int l = 0;
        int r = nums.length -1;
        while(l <= r){
            int mid = l + (r -l)/2;
            System.out.println(l + " " + mid + " "+ r);
            if(nums[mid] < target){
                l = mid + 1;
            } else if(nums[mid] > target){
                r = mid -1;
            }else{
                return mid;
            }
        }
        return r+1; // 或者 return l;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6};
        int res = searchInsert(arr, 2);
        System.out.println(res);
    }
}
