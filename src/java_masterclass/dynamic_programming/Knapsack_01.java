package java_masterclass.dynamic_programming;

/**
 * 0-1背包问题
 * 1. 借助 dp数组，状态转移方程式
 * 2. divide and conquer method 使用递归来做
 *
 *
 *
 * @author huimin
 * @create 2022-01-18 1:27
 */
public class Knapsack_01 {
    /**
     * 借助 dp数组，状态转移方程式
     * @param W 存放物品重量的数组
     * @param C 存放物品价值的数组
     * @param m 背包最大承重
     * @return 返回背包可以存放物品的最大价值
     */
    public static int knapsack1(int[] W, int[] C, int m){
        int n = W.length-1;
        int[] dp = new int[m+1];
        for(int i=1; i<=n; i++){
            for(int j=m; j>=1; j--){
                if(j >= W[i])
                    dp[j] = Math.max(dp[j], dp[j-W[i]]+C[i]);
            }
        }
        return dp[m];
    }

    public static int knapsack2(int[] W, int[] C, int m, int i){
        if(m<0 || i<0 || i>=C.length)
            return 0;
        int profit1 = 0;
        int profit2 = 0;
        if(W[i] <= m){
            // 两种状态，拿当前的物品和不拿
            // 1. 拿
            profit1 = C[i] + knapsack2(W, C, m-W[i], i+1);
            // 2. 不拿
            profit2 = knapsack2(W, C, m, i+1);


        }

        return Math.max(profit1, profit2);
    }

    public static void main(String[] args) {
        int[] weights = new int[]{2, 3, 4, 7};
        int[] values = new int[]{1, 3, 5, 9};
        int capacity = 10;
        long timer1 = System.currentTimeMillis();
        int ans1 = knapsack1(weights, values, capacity);
        long timer2 = System.currentTimeMillis();
        System.out.println(ans1);
        System.out.println("DP method time used: "+ (timer2-timer1));
        int ans2 = knapsack2(weights, values, capacity, 0);
        long timer3 = System.currentTimeMillis();
        System.out.println(ans2);
        System.out.println("Recursive method time used: "+ (timer3-timer2));
        System.out.println("Result shows that DP method runs faster than recursive method");
    }
}

/**
 *  modified:   ../classic/Fibonacci.java
 *         modified:   ../java_masterclass/divide_and_conquer/Min_cost_to_reach_last_cell.java
 *         modified:   ../java_masterclass/divide_and_conquer/NumberFactor.java
 *         modified:   ../java_masterclass/dynamic_programming/Knapsack_01.java
 *         modified:   ../java_masterclass/graph_exer/GraphNode.java
 *         modified:   ../java_masterclass/graph_exer/Graph_Route_btw_nodes.java
 *         modified:   ../leetcode/T692_topK_frequent_words.java
 *         modified:   ../leetcode/T938_range_sum_of_BST.java
 *         modified:   ../oa/BinaryPalindrome.java
 *         modified:   ../oa/Huawei_vo1.java
 *         modified:   ../oa/Quora_Q1.java
 *         modified:   ../oa/TikTok_OA.java
 */
// git add ../java_masterclass/graph_exer/GraphNode.java ../java_masterclass/graph_exer/Graph_Route_btw_nodes.java  ../leetcode/T692_topK_frequent_words.java ../leetcode/T938_range_sum_of_BST.java
// git add ../classic/Fibonacci.java ../java_masterclass/divide_and_conquer/Min_cost_to_reach_last_cell.java ../java_masterclass/divide_and_conquer/NumberFactor.java ../java_masterclass/dynamic_programming/Knapsack_01.java
