package leetcode;

import java.util.Arrays;

/**
 * @author huimin
 * @create 2022-11-26 20:05
 */
public class T1918_Kth_smallest_subarray_sum {

    public int kthSmallestSubarraySum(int[] nums, int k) {
        int lo = 1, hi = Arrays.stream(nums).sum();

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (countLessEqual(nums, mid) >= k) hi = mid;
            else lo = mid + 1;
        }
//        while(low <= high){
//            int mid = low + (high-low)/2;
//            if(countLessEqual(nums, mid) >= k){
//                high = mid-1;
//            }else{
//                low = mid+1;
//            }
//        }
        return lo;
    }

    private int countLessEqual(int[] nums, int target) {
        int count = 0, sum = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > target) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

    public long thekthSubarray(int[] a, long k) {
        int n = a.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + a[i - 1];
        }

        long start = prefixSum[1], end = prefixSum[n];
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            long count = countLessOrEqual(prefixSum, mid);
            if (count >= k) {
                end = mid;
            } else {
                start = mid;
            }
        }

        long lessThanOrEqualStart = countLessOrEqual(prefixSum, start);
        if (lessThanOrEqualStart >= k) {
            return start;
        }
        return end;
    }

    private long countLessOrEqual(long[] prefixSum, long value) {
        long count = 0;
        int n = prefixSum.length;
        int right = 1;
        for (int left = 0; left < n; left++) {
            while (right < n && prefixSum[right] - prefixSum[left] <= value) {
                count += (right - left);
                right++;
            }
            if (right == n) {
                break;
            }
        }
        return count;
    }
}

