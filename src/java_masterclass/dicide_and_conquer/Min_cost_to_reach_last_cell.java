package java_masterclass.dicide_and_conquer;

/**
 * @author huimin
 * @create 2022-01-16 22:05
 */
public class Min_cost_to_reach_last_cell {
    /**
     * Use divide and conquer method
     * @param cost
     * @param row
     * @param col
     * @return
     */
    public static int findMinCost(int[][] cost, int row, int col){
        if(row == -1 || col == -1)
            return Integer.MAX_VALUE;
        if(row == 0 && col == 0)
            return cost[0][0];

        int minCost1 = findMinCost(cost, row, col-1);
        int minCost2 = findMinCost(cost, row-1, col);
        int minCost = Integer.min(minCost1, minCost2);
        return minCost + cost[row][col];
    }

    /**
     * Use dynamic programming
     * @param cost
     * @return
     */
    public static int findMinCost_Dp(int[][] cost){
        printArray(cost);
        int m = cost.length; // row #
        int n = cost[0].length; // col #
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0 ;j--){
                if(i == m-1 && j == n-1)
                    continue;
                else if(i == m-1)
                    cost[i][j] += cost[i][j+1];
                else if(j == n-1)
                    cost[i][j] += cost[i+1][j];
                else
                    cost[i][j] += Math.min(cost[i][j+1], cost[i+1][j]);
            }
        }
        printArray(cost);

        return cost[0][0];
    }

    public static void printArray(int[][] arr){
        System.out.println("--- Start print 2-D array ---");
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 7, 8, 6, 4},
                {6, 7, 3, 9, 2},
                {3, 8, 1, 2, 4},
                {7, 1, 7, 3, 7},
                {2, 9, 8, 9, 3}
        };
        int res = findMinCost(arr, arr.length-1, arr[0].length-1);
        System.out.println(res);
        int res2 = findMinCost_Dp(arr);
        System.out.println(res2);
    }
}
