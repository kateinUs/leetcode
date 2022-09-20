package oa;

import com.sun.source.doctree.EndElementTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huimin
 * @create 2022-09-19 16:16
 */
public class Amazon_getkConsistency {
    // T1: getkConsistency score
    // 删掉最多K个元素得到元素相同的subarray，这个subarray最长的可能长度。
    // 思路：hashmap<int,vector> key是stockprice，value是出现的index。
    // 然后对于每个元素做sliding window，找到最长的可能。
    // e.g. stock_pric‍‍‍‍‌‌‍‍‍‌‍‌‌‍‌‌‌‌‍es = [1, -2, 1, 1, 3, 2, 1, -2] and K = 3.
    //      return: 4
    static int getkConsistencyScore(int[] stockPric‍‍, int k){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<stockPric‍‍.length; i++){
            int p = stockPric‍‍[i];
            map.putIfAbsent(p, new ArrayList<>());
            map.get(p).add(i);
        }

        // sliding window
        // 如果delete的数量大于k了，left指针就往右移，以缩减delete数量
        int max = 1;
        for(List<Integer> list: map.values()){
            int len = list.size();
            if(len == 1) continue;

            int left = 0;
            int right = 1;
            int deleted = list.get(right) - list.get(left) -1;
            while(left < len && right < len){
                max = Math.max(max, list.get(right) - list.get(left)+1- deleted);
                while (deleted > k){
                    deleted -= list.get(left+1) - list.get(left)-1;
                    left ++;
                }

                right ++;
                if(right <len) deleted +=  list.get(right)-list.get(right-1)-1;
            }
        }
        return max;
    }

    public static int test(int[] stock_prices, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < stock_prices.length; i++) {
            int p = stock_prices[i];
            map.putIfAbsent(p, new ArrayList());
            map.get(p).add(i);
        }
        int res = 1;
        for (List<Integer> list : map.values()) {
            int curLongest = 0;
            int n = list.size();
            if (n == 1) continue;
            int deleted = list.get(1) - list.get(0) - 1, left = 0, right = 1;
            while (left < n && right < n) {
                curLongest = Math.max(right - left + 1, curLongest);
                while (deleted > k) {
                    deleted -= (list.get(left) - list.get(left - 1) - 1);
                    left++;
                }
                right++;
                if (right < n) deleted += (list.get(right) - list.get(right - 1) - 1);
            }
            res = Math.max(curLongest, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 1, 2, 1, 2, 1}, test2 = {7, 5, 7, 7, 1, 1, 7, 7};
        int k1 = 3, k2 = 3;
        System.out.println(getkConsistencyScore(test1, k1));
        System.out.println(getkConsistencyScore(test2, k2));
    }
}
