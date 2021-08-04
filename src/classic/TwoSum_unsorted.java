package classic;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用map，时间复杂度O(N)，空间复杂度O(N)，空间换时间
 * @author huimin
 * @create 2021-07-27 14:24
 */
public class TwoSum_unsorted {
    public static void main(String[] args) {
        int[] res = find2Sum(new int[]{1,2,3,4,5,6}, 10);
        for (int re : res) {
            System.out.print(re +" ");
        }
    }

    //标记法
    public static int[] find2Sum(int[] arr, int sum){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(sum - arr[i])){
                return new int[]{map.get(sum-arr[i]), i};
            }
            map.put(arr[i], i);
        }

        return new int[0];
    }
}
