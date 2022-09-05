package leetcode;

/**
 * @author huimin
 * @create 2022-02-21 13:10
 */
public class T1020_Number_of_Enclaves {
    int ROWS;
    int COLS;
    public int numEnclaves(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                if(i == 0 || i == ROWS-1 || j == 0 || j == COLS-1){
                    if(grid[i][j] == 1)
                        dfs(grid, i, j);
                }
            }
        }
        int count = 0;
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                if(grid[i][j] == 1)
                    count++;
            }
        }

        return count;
    }
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void dfs(int[][] grid, int row, int col){
        if(row < 0 || row >= ROWS || col < 0 || col >= COLS || grid[row][col] == 0)
            return;
        grid[row][col] = 0;
        for(int i=0; i<4; i++){
            dfs(grid, row+dirs[i][0], col+dirs[i][1]);
        }
    }
}
