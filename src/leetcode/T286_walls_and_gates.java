package leetcode;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huimin
 * @create 2022-05-24 23:53
 */
public class T286_walls_and_gates {
    static int ROWS;
    static int COLS;
    int[][] DIRS = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    public void wallsAndGates(int[][] rooms) {
        ROWS = rooms.length;
        COLS = rooms[0].length;
        Queue<Pair<Integer, Integer>> q =new LinkedList<>();
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                if(rooms[i][j] == 0){
                    q.add(new Pair<>(i, j));
                }
            }
        }

        while(!q.isEmpty()){
            Pair<Integer, Integer> curr = q.poll();

            for(int i=0; i<4; i++){
                int dist = rooms[curr.getKey()][curr.getValue()];
                int x = curr.getKey() + DIRS[i][0]; // row
                int y = curr.getValue() + DIRS[i][1]; // col
//                System.out.println(x +" "+y);
                if(x>=0 && x<ROWS && y>=0 && y<COLS && rooms[x][y] == Integer.MAX_VALUE){
                    q.add(new Pair<>(x, y));
                    rooms[x][y] = dist+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        T286_walls_and_gates test = new T286_walls_and_gates();
        test.wallsAndGates(rooms);
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println();
        }

    }
}
