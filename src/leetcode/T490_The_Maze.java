package leetcode;

/**
 * @author huimin
 * @create 2022-12-05 14:24
 */
public class T490_The_Maze {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    // U R D L
    // 0 1 2 3
    // DFS+BACKTRACK
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start[0], start[1], dest, visited);
    }
    boolean dfs(int[][] maze, int row, int col, int[] dest, boolean[][] visited){
        // System.out.println(row+ " "+ col);
        if(visited[row][col]) return false;
        visited[row][col] = true;
        if(row == dest[0] && col == dest[1]) return true;
        for(int i=0; i<4; i++){
            // create new variable to store current row and col,
            // so don't need to backtrack when the dfs return
            int ni = row;
            int nj = col;

            while(isValid(maze, ni+dirs[i][0], nj+dirs[i][1]) ){
                ni += dirs[i][0];
                nj += dirs[i][1];
            }

            if(dfs(maze, ni, nj, dest, visited)) return true;
        }

        return false;
    }

    boolean isValid(int[][] maze, int i, int j){
        if(i < 0 || i>= maze.length || j<0 || j>= maze[0].length || maze[i][j] == 1){
            return false;
        }
        return true;
    }
}
