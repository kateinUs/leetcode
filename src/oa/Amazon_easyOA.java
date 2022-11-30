package oa;

import javafx.util.Pair;

import java.util.*;

/**
 * @author huimin
 * @create 2022-09-19 18:13
 */
public class Amazon_easyOA {
    // https://www.1point3acres.com/bbs/thread-920909-1-1.html
    // 无序的整型数组，求出平方数序列的最大长度，比如对于[2, 8, 9, 16, 4, 3]应该输出3，对应的平方数
    //序列是2，4，16。2是起始值，这样的序列对应长度是3，如果序列是2，3，5这样的就是长度0，找出符合条件的序列的最
    //大长度

    static int findLonestConsecutivePerfectSqaure(int[] arr){
        Set<Integer> set = new HashSet<>();
        for(int i:arr){
            set.add(i);
        }
        int len, max = 0;
        for(int i=0; i<arr.length; i++){
            int cur =arr[i];
            if(set.contains(cur)){
                len = 1;
                // find the number of perfect square
                while(set.contains(cur * cur)){
                    len ++;
                    set.remove(cur * cur);
                    cur = cur * cur;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }

    /**
     * T2386 find-the-k-sum-of-an-array
     * https://leetcode.com/problems/find-the-k-sum-of-an-array/
     * https://leetcode.com/problems/find-the-k-sum-of-an-array/discuss/2459149/Java-Priority-Queue-with-Thought-Process-and-Explanation
     * combo问题
     * 给一个长度n的列表代表商品的受欢迎程度，给一个数字k，要求输出欢迎程度和 前k个
     * e.g. arr = [3, 5, -2] k=3
     * 组合共有8种， [0, 3, 5, -2, 8, 3, 1, 6]
     * 返回最大的3种： [8, 6, 5]
     *
     */
    public static int[] getKMostPopularCombo(int[] arr, int k){


        return null;
    }

    public long kSum(int[] nums, int k) {
        // Calculate maxSubsequenceSum and abs.
        long maxSubsequenceSum = 0;
        int[] abs = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            if (num > 0) {
                maxSubsequenceSum += num;
            }
            abs[i] = Math.abs(num);
        }
        Arrays.sort(abs);

        // Max heap to maintain the largest subsequence sums.
        // The first number in the pair is the subsequence sum.
        // The second number is the index of the last "change" we made to obtain this subsequence sum.
        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>((p1, p2) -> {
            return Long.compare(p2.getKey(), p1.getKey());
        });

        // List of subsequence sums in order.
        ArrayList<Long> subsequenceSums = new ArrayList<>();
        subsequenceSums.add(maxSubsequenceSum);

        // Start with the smallest "change" we can make.
        pq.add(new Pair(maxSubsequenceSum - abs[0], 0));
        while (subsequenceSums.size() < k) {
            // Get previous largest subsequence sum and add it to list.
            Pair<Long, Integer> subsequenceSum = pq.poll();
            long lastSubsequenceSum = subsequenceSum.getKey();
            int lastChange = subsequenceSum.getValue();
            subsequenceSums.add(lastSubsequenceSum);

            if (lastChange < nums.length - 1) {
                // Continue with the last "change"
                pq.add(new Pair(lastSubsequenceSum - abs[lastChange + 1], lastChange + 1));
                // Replace the last "change"
                pq.add(new Pair(lastSubsequenceSum + abs[lastChange] - abs[lastChange + 1], lastChange + 1));
            }
        }

        Integer[] res = subsequenceSums.toArray(new Integer[0]);
        // return res
        return subsequenceSums.get(k - 1);
    }

    public static void main(String[] args) {
        int[] test = {2, 8, 9, 16, 4, 3, 256};
        System.out.println(findLonestConsecutivePerfectSqaure(test));
    }
}
