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
        /*
         * consider the two arrays in a whole, we should find a cut in nums1, and another cut in nums2
         * they will make all the numbers in left side are smaller than all numbers in right side for both array.
         * for example: nums1 = {1, 2, 3, | 7, 8}, nums2 = {4, 5, | 6, 9, 10}; "|" represents the cut place.
         * consider as a whole, left will be (<1, 2, 3,> <4, 5>); right will be (<7, 8,>  <6, 9, 10>);
         * all the numbers in left are smaller than all numbers in right.
         * the median of the whole will be (greatest of left(5) + least of right(6) ) / 2 = 5.5.
         *
         * More Detail Explainations:
         * lens: the total lens of nums1 + nums2.
         * Situation of lens % 2 == 1;         | Situation of lens % 2 == 0;
         * Median = Math.min(R1, R2);          | Median = (Math.max(L1,L2) + Math.min(R1, R2)) / 2
         *               L1 (cut1)  R1         |               L1 (cut1)  R1
         * nums1: [1, 2,  3,  |     7, 8];     | nums1: [1, 2,  3,   |    7, 8]
         * nums2: [4, 5,   |   6, 9, 10, 12];  | nums2: [4, 5,   |    6, 9, 10]
         *            L2 (cut2)  R2            |           L2 (cut2)  R2
         *
         * cut1: represents the numbers before the cut in nums1.
         * cut2: represents the numbers before the cut in nums2.
         * cut1 + cut2 = len / 2;
         * L1: the rightMost(greatest) element in nums1's left parts after the cut.
         * R1: the leftMost(least) element in nums1's right parts after the cut.
         * L2: the rightMost(greatest) element in nums2's left parts after the cut.
         * R2: the leftMost(least) element in nums2's right parts after the cut.
         * cutL/cutR: the range in nums1 for cutting.
         *
         * After the cut, we know L1 should smaller than R2; R1 should greater than L2
         * Then it will be a valid cut, otherwise we should change the cut place:
         *
         * cut1 to left (if L1 > R2) to let smaller ones in the left bucket of nums1
         * cut1 to right (if R1 < L2) to let greater ones in the right bucket of nums2
         *
         * the moving process will utilize binary search.
         */

        // make sure we are always dealing with nums1 with smaller array.
        // Time Complexity: O(log(min(m, n)));
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int cut1 = 0, cut2 = 0;
        int len = nums1.length + nums2.length;
        // halfLen: the count of numbers in left for nums1 and nums2 after cuts.
        int halfLen = len / 2;
        // cutL/cutR: for the binary search the cut point, we should give it a range
        int cutL = 0, cutR = nums1.length;

        while (cutL <= cutR)
        {
            // binary search.
            cut1 = (cutR - cutL) / 2 + cutL; // cut1 equals to the number less than nums1[cut1] in nums1
            cut2 = halfLen - cut1; // cut2 equals to the number less than nums2[cut2] in nums2
            // cut1 == 0, meaning no elements before the cut1
            // make L1 = MinValue to make sure the later compare go through.
            double L1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            // cut1 == nums1.length meaning all elements are in the left of the cut
            // make R1 = Maxvalue to make sure the later compare go through.
            double R1 = cut1 == nums1.length ? Integer.MAX_VALUE : nums1[cut1];

            double L2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R2 = cut2 == nums2.length ? Integer.MAX_VALUE : nums2[cut2];

            if (L1 > R2)	// meaning cut1 should move left (to make smaller ones in the left bucket)
                cutR = cut1 - 1;
            else if (R1 < L2) // cut1 should move right (to make larger ones in the right bucket)
                cutL = cut1 + 1;
            else	// this cut makes a perfect match.
            {
                if (len % 2 == 0)
                    return (Math.max(L1,L2) + Math.min(R1, R2)) / 2;
                else
                    return Math.min(R1, R2);
            }
        }

        return -1;
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
