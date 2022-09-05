package oa;

/**
 * In an interview I was asked this question: given some array of positive integers s, find the length of the
 * longest subarray such that the sum of all its values is less than or equal to some positive integer k. Each
 * input will always have at least one solution. The array is not circular.
 *
 * Input1:s = [1,2,3], k = 4
 * Output1: 2
 *
 * Input2: s=[3,1,2,1], k = 4
 * Output2: 3
 * @author huimin
 * @create 2022-09-04 17:09
 */
public class Length_of_longest_subarray_with_sum_bounded_by_k {
    public static int findLongestSubarray(int[] arr, int k){
        int l=0, r=0, len = arr.length;
        int sum = 0;
        int ans = 0;
        while(r < len){
            sum += arr[r];
            // shrink the window if sum is larger than k
            while(sum > k && l<=r){
                sum -= arr[l++];
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] test1 = {3,1,2,1};
        int k1 = 4;
        int[] test2 = {1, 0, 3, 4, 2, 1, 0, 1, 1, 3};
        int k2 = 6;
        System.out.println(findLongestSubarray(test1, k1));
        System.out.println(findLongestSubarray(test2, k2));
    }
}
