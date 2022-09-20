package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author huimin
 * @create 2021-09-14 23:50
 */
public class T347_top_k_frequent_elements {
    // Method1: use HashMap to store the occurrence of Integer
    // 这个方法可以用因为LinkedHashMap是有顺序的，所以可以保留sort交换后的顺序，才能完成value从大到小的遍历
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> frequent = new HashMap<>();
        int[] res = new int[k];
        for (int i = 0; i < nums.length; i++) {
            frequent.put(nums[i], frequent.getOrDefault(nums[i], 0)+1);

        }
        // this step sort the map by value in descending order
        HashMap<Integer, Integer> finalOut = new LinkedHashMap<>();
        frequent.entrySet()
                .stream()
                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                .collect(Collectors.toList()).forEach(ele -> finalOut.put(ele.getKey(), ele.getValue()));
        // get the top k frequent Integer by getting key
        int i=0;
        for(Integer key: finalOut.keySet()){
            res[i++] = key;
            if(i == k)
                break;
        }

        return res;
    }
    public int[] topKFrequent2(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }

        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> count.get(n1) - count.get(n2));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: count.keySet()) {
            heap.add(n);
            // 因为是最小堆，当堆里元素的数量大于k是，poll出去的就是最小值，那么堆里剩下的就是当前最大的k个
            if (heap.size() > k) heap.poll();
        }

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }
}
