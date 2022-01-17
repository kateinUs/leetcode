package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huimin
 * @create 2021-09-12 13:55
 */
public class T4_median_of_two_sorted_arrays {
    // Time complexity is O(M + N)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int p = 0, q = 0, i = 0;
        boolean isEven = ((len1 + len2) % 2 == 0)? true:  false;
        int median = (len1+len2) / 2;
        int[] merged = new int[len1+len2];
        // if total length is odd, then we get the median th number in the merged and sorted array
        // if is even, we get the average of (median-1) and median th number in the merged and sorted array
        while (p < len1 || q < len2){
            if(p == len1 || q == len2)
                merged[i] = (p == len1)? nums2[q++]: nums1[p++];
            else if(nums1[p] < nums2[q]){
                merged[i] = nums1[p++];
            } else{
                merged[i] = nums2[q++];
            }
            if(i == median){
                return (isEven)? ((double) merged[median-1] + merged[median])/2: merged[median];
            }
            i++;
        }
        return (isEven)? (merged[median-1] +merged[median])/2: merged[median];
    }

    // time complexity: O(lg(m+n))
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
        System.out.println(args[0]);
        HashMap<Integer, Integer> count = new HashMap<>();
        int prod_id = 0;
        count.put(prod_id, count.getOrDefault(prod_id, 0)+1);

        int max_count = 0;
        ArrayList<Integer> out = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if(entry.getValue() > max_count){
                out.clear();
                out.add(entry.getKey());
            } else if(entry.getValue() == max_count){
                out.add(entry.getKey());
            }
        }
        Collections.sort(out);
        return;
    }
}
