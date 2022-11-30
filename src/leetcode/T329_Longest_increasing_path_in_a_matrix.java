package leetcode;

/**
 * @author huimin
 * @create 2022-09-29 1:52
 */
public class T329_Longest_increasing_path_in_a_matrix {
    // Method1: dif with memo
    int[][] dirs = {{1,0}, {0, 1}, {-1, 0}, {0, -1}};
    int[][] matrix;
    int[][] memo;
    int ROWS;
    int COLS;
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        this.ROWS = matrix.length;
        this.COLS = matrix[0].length;
        memo = new int[ROWS][COLS];
        int max = 0;
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                max = Math.max(max, dfs(i, j, -1));
            }
        }
        return max+1;
    }
    int dfs(int i, int j, int lastNum){
        if(i<0 || i>=ROWS || j<0 || j>=COLS || matrix[i][j] <= lastNum){
            return -1;
        }
        int max = -1;
        if(memo[i][j] != 0) return memo[i][j];
        // max = Math.max(max, step);
        for(int[] dir: dirs){
            max = Math.max(dfs(i+dir[0], j+dir[1], matrix[i][j])+1, max);
        }
        memo[i][j] = max;
        return max;
    }
}
