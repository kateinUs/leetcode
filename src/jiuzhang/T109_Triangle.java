package jiuzhang;

import java.util.*;

/** 数字三角形题 （经典） 可以用多种方法求解
 * 给定一个数字三角形，找到从顶部到底部的最小路径和。
 * 每一步可以移动到下面一行的相邻数字上
 * Input：
 * [[2],
 *  [3, 4],
 *  [6, 5, 7],
 *  [4, 1, 8, 3]]
 * Output: 11 (2 -> 3 -> 5 -> 7 )
 * @author huimin
 * @create 2022-11-13 18:23
 */
public class T109_Triangle {
    // 1. DFS
    public int findMinPath1(int[][] arr){

        return 0;
    }

    // 2. DFS with memo
    public int findMinPath2(int[][] arr){

        return 0;
    }

    // 3. DP -> 坐标性动态规划
    public int findMinPath3(int[][] arr){

        return 0;
    }

    public static void main(String[] args) {
        Map<int[], Integer> map = new HashMap<>();
        map.put(new int[]{1, 2}, 3);
        System.out.println(map.containsKey(new int[]{1, 2}));
        int[] arr = {1, 3, 4};
    }
}
