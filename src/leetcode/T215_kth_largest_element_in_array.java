package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author huimin
 * @create 2021-09-12 23:07
 */
public class T215_kth_largest_element_in_array {
    // Method 1: sort
    // Time complexity: O(NlogN)
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // Method 2: Heap
    public int findKthLargest2(int[] nums, int k) {
        // init the heap smallest element first
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        /* TODO -> lamdba表达式用于integer
        PriorityQueue<Long> heap2 = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o1.compareTo(o2);
            }
        });*/
        // keep k largest elements in the heap
        for (int n : nums) {
            heap.add(n);
            if(heap.size()> k)
                heap.poll();
        }

        return heap.poll();
    }
}
