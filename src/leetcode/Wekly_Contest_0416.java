package leetcode;

import java.awt.print.Printable;
import java.util.Arrays;

/**
 * @author huimin
 * @create 2022-04-16 22:58
 */
public class Wekly_Contest_0416 {
    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        while(sb.length()>k){
            StringBuilder newSb = new StringBuilder();
            for(int i=0; i<sb.length(); i+=k){
                int sum = 0;
                for(int j=i; j<i+k && j<sb.length(); j++){
                    sum += sb.charAt(j)-'0';
                }
                newSb.append(sum);
            }
            sb = newSb;
        }

        return sb.toString();
    }

    /**
     * Input: tasks = [2,2,3,3,2,4,4,4,4,4]
     * Output: 4
     * @param tasks
     * @return
     */
    public int minimumRounds(int[] tasks) {
        int round = 0;
        Arrays.sort(tasks);
        int count = 1;
        for(int i=1; i<tasks.length; i++){
            if(tasks[i] == tasks[i-1]){
                count++;
            }else{
                if(count ==1)
                    return -1;

                if(count % 3 == 2){
                    round += count / 3 + 1;
                }else if(count % 3 == 1){
                    round += (count-4)/3 + 2;
                }else{
                    round += count/3;
                }

                count =1;
            }
        }
        if(count ==1)
            return -1;

        if(count % 3 == 2){
            round += count / 3 + 1;
        }else if(count % 3 == 1){
            round += (count-4)/3 + 2;
        }else{
            round += count/3;
        }

        return round;
    }

    public int maxTrailingZeros(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        int globMax = 0;
        for(int i=0; i<ROW; i++){
            for(int j=0; j<COL; j++){
                if(grid[i][j] % 10 == 0){
                    grid[i][j] = 10;
                } else if (grid[i][j] % 5 == 0){
                    grid[i][j] = 5;
                } else if(grid[i][j] %2 == 0){
                    grid[i][j] = 2;
                } else{
                    grid[i][j] = 1;
                }
            }
        }
        for(int i=0; i<ROW; i++){
            for(int j=0; j<COL; j++){
                int dir1 =countByRowCol(i, j, 0, i, 0, j, grid);
                int dir2 =countByRowCol(i, j, 0, i, j, COL, grid);
                int dir3 =countByRowCol(i, j, i, ROW, 0, j, grid);
                int dir4 =countByRowCol(i, j, i, ROW, j, COL, grid);
                int max = Math.max(Math.max(dir1, dir2), Math.max(dir3, dir4));
                if(max > globMax)
                    globMax = max;
//                System.out.println(globMax);
            }
        }
        return globMax;
    }

    private int countByRowCol(int row, int col, int rowFrom, int rowTo, int colFrom, int colTo, int[][] grid) {
        int prod = 1;
        for(int i = rowFrom; i<rowTo; i++){
            prod *= grid[i][col];
        }
        for(int j=colFrom; j<colTo; j++){
            prod *= grid[row][j];
        }
        prod /= grid[row][col];
        int count = 0;
        while(prod % 10 == 0 && prod != 0){
//            System.out.println(prod);
            count ++;
            prod /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Wekly_Contest_0416 test = new Wekly_Contest_0416();
//        String s = "11111222223";
//        int k = 3;
//        String res = test.digitSum(s, k);
//        System.out.println(res);
//
//        int[] tasks  = {2,2,3,3,2,4,4,4,4,4};
//        int res2 = test.minimumRounds(tasks);
//        System.out.println(res2);

        int[][] grid = {{23,17,15,3,20},{8,1,20,27,11},{9,4,6,2,21},{40,9,1,10,6},{22,7,4,5,3}};
        int res = test.maxTrailingZeros(grid);
        System.out.println(res);

    }
}
