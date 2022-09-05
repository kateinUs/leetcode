package leetcode;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huimin
 * @create 2022-06-17 11:27
 */
public class T1091_Shortest_path_in_binary_matrix {
    int ROWS;
    int COLS;
    int[][] DIRS = { {1, -1},  {1, 1}, {-1, -1}, {-1, 1}, {0, -1}, {0, 1},{1, 0}, {-1, 0}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        this.ROWS = grid.length;
        this.COLS = grid[0].length;

        if(grid[0][0] == 1 || grid[ROWS-1][COLS-1] ==1 )
            return -1;

        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                if(grid[i][j] == 1)
                    grid[i][j] = -1;
            }
        }

        BFS(grid);

        if(grid[ROWS-1][COLS-1] == 0 || grid[ROWS-1][COLS-1] == -1)
            return -1;
        return grid[ROWS-1][COLS-1];// DFS(grid, 0, 0);
    }

    private void BFS(int[][] grid) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        grid[0][0] = 1;
        q.add(new Pair<>(0, 0));
        while(!q.isEmpty()){
            Pair<Integer, Integer> curr = q.remove();
            int currVal = grid[curr.getKey()][curr.getValue()];
            for(int i=0; i<DIRS.length; i++){
                int nr = curr.getKey() + DIRS[i][0];
                int nc = curr.getValue() + DIRS[i][1];
                if(nr < 0 || nc < 0 || nr >= ROWS || nc >= COLS || grid[nr][nc] != 0)
                    continue;
                grid[nr][nc] = currVal+1;
                q.add(new Pair<>(nr, nc));
                if(nr == ROWS-1 && nc == COLS-1)
                    return ;
            }
        }
    }


    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
        T1091_Shortest_path_in_binary_matrix test = new T1091_Shortest_path_in_binary_matrix();
        int res = test.shortestPathBinaryMatrix(grid);
        System.out.println(res);
    }
}
