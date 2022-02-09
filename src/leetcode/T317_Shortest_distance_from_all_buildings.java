package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Method 1: bfs
 * @author huimin
 * @create 2022-01-29 17:27
 */
public class T317_Shortest_distance_from_all_buildings {
    private int bfs(int[][] grid, int row, int col, int numOfHouse) {
        int dirs[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> visit = new LinkedList<>();
        int visitedHouse = 0;
        int distSum = 0;
        boolean[][] visGrid = new boolean[grid.length][grid[0].length];
        visit.add(new int[]{row, col});
        visGrid[row][col] = true;
        int step = 0;
        while(!visit.isEmpty() && numOfHouse > visitedHouse){
            for(int i=visit.size(); i>0; --i){
                int[] curr = visit.remove();
                row = curr[0];
                col = curr[1];

                if(grid[row][col] == 1){
                    distSum += step;
                    visitedHouse++;
                    continue;
                }
                for(int[] dir: dirs){
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];

                    if(nextRow>=0 && nextCol>=0 && nextRow<grid.length && nextCol<grid[0].length){
                        if(!visGrid[nextRow][nextCol] && grid[nextRow][nextCol] != 2){
                            visGrid[nextRow][nextCol] = true;
                            visit.add(new int[]{nextRow, nextCol});
                        }
                    }

                }
            }
            step++;
        }
        // If we did not reach all houses, then any cell visited also cannot reach all houses.
        // Set all cells visted to 2 so we do not check them again and return MAX_VALUE.
        if(numOfHouse != visitedHouse){
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
                    if(grid[i][j] == 0 && visGrid[i][j]){
                        grid[i][j] = 2;
                    }
                }
            }
            return Integer.MAX_VALUE;
        }
        return distSum;
    }

    public int shortestDistance(int[][] grid) {
        int numOfHouse = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    numOfHouse++;
                }
            }
        }
        int minDist = Integer.MAX_VALUE;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 0){
                    minDist = Math.min(minDist, bfs(grid, i, j, numOfHouse));
                }
            }
        }
        if(minDist == Integer.MAX_VALUE)
            return -1;
        return minDist;
    }
}
