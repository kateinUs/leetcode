package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author huimin
 * @create 2021-09-14 23:31
 */
public class T56_merge_intervals {
    public int[][] merge(int[][] intervals) {
        // lambda 表达式 简化 Comparator 从小到大
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            // 如果正在遍历的区间和上一个区间无交集，则直接add这个区间
            if(merged.isEmpty() || merged.getLast()[1] < interval[0])
                merged.add(interval);
            //如果有交集，则把上一个区间的big bound设成这个区间和上个区间big bound的最大值
            else
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
