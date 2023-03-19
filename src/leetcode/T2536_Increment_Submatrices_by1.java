package leetcode;

import java.util.Arrays;

/**
 * @author huimin
 * @create 2023-01-14 23:07
 */
public class T2536_Increment_Submatrices_by1 {
    public static void main(String[] args) {
//        n = 3, queries = [[1,1,2,2],[0,0,1,1]]
        int n = 3;
        int[][] queries = {{1, 1, 2, 2}, {0, 0, 1, 1}};
        int[][] res = rangeAddQueries(n, queries);
        for(int[] row: res){
            Arrays.stream(row).forEach(a-> System.out.print(a+" "));
            System.out.println();
        }
        
    }
    public static int[][] rangeAddQueries(int n, int[][] qs) {
        int[][] res = new int[n][n];
        if(n ==0 || qs == null || qs.length == 0) return res;
        for(int i=0; i<qs.length; i++){
            int[] q = qs[i];
            for(int row=q[0]; row<= q[2]; row++){
                for(int col = q[1]; col<= q[3]; col++){
                    res[row][col]+= 1;
                }
            }
        }
        return res;
    }
}
