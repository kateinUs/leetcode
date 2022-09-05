package leetcode;

import java.rmi.dgc.VMID;

/**
 * @author huimin
 * @create 2022-03-03 23:14
 */
public class T1064_Fix_point {
    // O(n) time
    public int fixedPoint(int[] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == i)
                return i;
        }

        return -1;
    }

    // since the arr is sorted, so we can think of using binary search to reach the O(logn) runtime
    // A = [-2, -1, 1, 3, 5, 6, 7, 8, 13]
    public static int fixedPoint2(int[] arr){
        int res = -1;
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] > mid){
                right = mid-1;
            }else if(arr[mid] < mid){
                left = mid +1;
            }else{
                res = mid;
                right = mid -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -1, 1, 3, 5, 6, 7, 8, 8};
        System.out.println(fixedPoint2(arr)); // 3
    }
}
