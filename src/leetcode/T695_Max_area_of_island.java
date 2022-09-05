package leetcode;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/**
 * @author huimin
 * @create 2022-02-28 23:20
 */
public class T695_Max_area_of_island {
    int ROWS;
    int COLS;
    int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.ROWS = grid.length;
        this.COLS = grid[0].length;
        int maxArea = 0;
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                if(grid[i][j] == 1){
                    int area = dfs(i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int dfs(int row, int col){
        if(row<0 || row>= ROWS || col<0 || col>= COLS || grid[row][col] == 0){
            return 0;
        }
        grid[row][col] = 0;
        int area = 1;
        for(int i=0; i<4; i++){
            area += dfs(row +dirs[i][0], col+dirs[i][1]);
        }

        return area;
    }

    public static void main(String[] args) {
        T695_Max_area_of_island cls = new T695_Max_area_of_island();
        int[][] grid = {{0, 1, 0}, {1, 1, 0}, {0,0,0}};
        System.out.println(cls.maxAreaOfIsland(grid));
    }
}
