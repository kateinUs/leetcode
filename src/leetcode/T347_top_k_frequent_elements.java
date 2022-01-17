package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
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
}
