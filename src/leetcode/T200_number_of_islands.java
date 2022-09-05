package leetcode;

/**
 * @author huimin
 * @create 2021-11-29 21:25
 */
public class T200_number_of_islands {

    char[][] grid;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        this.grid = grid;
        int count =0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        for(int k=0; k<dirs.length; k++){
            dfs(i+ dirs[k][0], j+dirs[k][1]);
        }

    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        T200_number_of_islands test =new T200_number_of_islands();
        int res = test.numIslands(grid);
        System.out.println(res);
    }
}
