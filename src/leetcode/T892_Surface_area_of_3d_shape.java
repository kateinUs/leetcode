package leetcode;

/**
 * @author huimin
 * @create 2022-06-10 15:06
 */
public class T892_Surface_area_of_3d_shape {
    public int surfaceArea(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        // scan row to row
        int cubeCount = 0;
        int glueCount = 0;
        for(int i=0; i< rows; i++){
            for(int j=0; j< cols; j++){
                cubeCount += grid[i][j];
                if(grid[i][j] > 1)
                    glueCount += grid[i][j]-1;
                if(j>0)
                    glueCount += Math.min(grid[i][j], grid[i][j-1]);
                if(i>0)
                    glueCount += Math.min(grid[i][j], grid[i-1][j]);
            }
        }
        return cubeCount*6 - glueCount*2;
    }
}
