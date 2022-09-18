package oa;

import java.util.*;

/**
 * @author huimin
 * @create 2022-09-16 22:14
 */
public class Robolx_oa {
    // 1. bubble explosion
    public void testBubble(){
        int[][] bubbles = {
                {3, 1, 2, 1},
                {1, 1, 1, 4},
                {3, 1, 2, 2},
                {3, 3, 3, 4}};
        int[][] res = bubbleExplosion(bubbles);
        for(int i=0; i<res.length; i++){
            for(int j=0; j<res[0].length; j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }

    public int[][] bubbleExplosion(int[][] arr){
        //1 先for循环找到周围四个中有>=两个和自身一样的元素 然后dfs这个元素把他和他周围的数字设置成0
        //2 第一步结束后非0 数字往下落
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                int cur = arr[i][j];
                if(cur == 0) continue;
                int count = 0;
                if(i-1>=0 && arr[i-1][j] == cur) count ++;
                if(j-1>=0 && arr[i][j-1] == cur) count ++;
                if(i+1<arr.length && arr[i+1][j] == cur) count ++;
                if(j+1<arr[0].length && arr[i][j+1] == cur) count ++;
                if(count >=2) dfs(arr, i, j, arr[i][j]);
            }
        }

        // all non-zero values fall down
        for(int j=0; j<arr[0].length; j++){
            int up=arr.length-1, dn=arr.length-1;
            while(up>=0 && dn >=0){
                while(up >=0 && arr[up][j] == 0) up--; // find first non-zero number
                if(up<0) break;
                arr[dn][j] = arr[up][j];
                dn --; up--;
            }
            while(dn >=0)  arr[dn--][j]=0;
        }

        return arr;
    }
    // 把周围相同的数字都设成0，且继续dfs
    int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    private void dfs(int[][] arr, int i, int j, int num) {
        if(i<0 || i>= arr.length || j<0 || j>= arr[0].length || arr[i][j]!=num)
            return;
        arr[i][j] = 0;
        for(int[] dir: dirs){
            dfs(arr, i+dir[0], j+dir[1], num);
        }
    }


    /**
     *给你一串binary string 和一组操作；操作只有两种，分别是：count和flip;
     * count要求计算string中1的个数'，并在result 中对应的index返回这个值。
     * flip：是返回这个string 最左0的位置，并且[O,index]的区间内的 string 全部反转，0->1,1->0.
     * 例子:input['101000'], [count, flip, flip, flip,count])
     * 这道题的逻辑不难，但会有4s的run tim
     * @param args
     */
    public static void main(String[] args) {
        Robolx_oa test = new Robolx_oa();
//        test.testBubble();

        test.testCleanRobot();
    }


    /**
     * Given 3 arrays, A, B and queries. there are 2 forms of query. [0, i, j] means we need to update B[i] = j.
     * Another type is [1, k], which means we need to find out the number of pairs in in A and B that sums up to k
     * (1 from A and another from B).
     * The number in a and b is guaranteed to be greater than or equal to 0.
     * For example:
     * a = [1,2,3]
     * b = [2,4]
     * query = [[1,5], [0, 0, 1], [1, 5]]
     * For the first query, [1, 5], we can find 2 pairs, (1,4) and (3,2)
     * For the second query, we update b[0] = 1, so now b = [1,4]
     * For the third query, we can only find one pair to sum up to 5, which is (1,4)
     *
     */

    public List<Integer> execute(int[] a, int[] b, int[][] query){
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : a)
            map.put(i, map.getOrDefault(i, 0)+1);

        for(int[] arr : query) {
            if(arr[0]==1)
                res.add(pairs(map, b, arr[1]));
            else
                b[arr[1]]=arr[2];
        }
        return res;
    }

    public int pairs (Map<Integer, Integer> map, int[] b, int sum) {
        int res =0;
        for(int i : b)
            res += map.getOrDefault(sum-i, 0);
        return res;
    }

    /**
     * 机器人打扫灰尘
     *
     */
    public void testCleanRobot(){
        char[][] field = {
                {'A', 'X', 'B', 'O', 'X'},
                {'X', 'A', 'O', 'B', 'O'},
                {'X', 'X', 'B', 'O', 'X'},
                {'X', 'X', 'A', 'O', 'X'},
                {'A', 'O', 'X', 'O', 'B'},
        };
        char[][] res = cleanRobot(field);


    }

    private char[][] cleanRobot(char[][] field) {
        // 每行找AB 的位置，若差偶数个，那么会碰撞
        Map<Integer, Integer> mapA = new HashMap<>(); // 记录A的位置， key->row index, value ->col index
        Map<Integer, Integer> mapB = new HashMap<>();
        // init setA/B
        for(int i=0; i<field.length; i++){
            for(int j=0; j<field[0].length; j++){
                if(field[i][j] == 'A'){
                    mapA.put(i,j);
                }else if(field[i][j] == 'B'){
                    mapB.put(i,j);
                }
            }
        }
        List<int[]> collisions;
        int col;
        while(!mapA.isEmpty() || !mapB.isEmpty()){
            collisions = new ArrayList<>();// return the collision loc in List
            // move 1 step
            List<Integer> listA = new ArrayList<>(mapA.keySet());
            for(int row: listA){
                if(mapB.getOrDefault(row, -1) - mapA.get(row) == 2){
                    col = mapA.get(row);
                    collisions.add(new int[]{row, col+1});
                    mapB.remove(row);
                    mapA.remove(row);
                    // AB 走过的位置变成 O
                }else{ // 没有碰撞
                    col = mapA.get(row);
                    field[row][col] = 'O';
                    if(col+1>=field[0].length) mapA.remove(row);
                    else mapA.put(row, col+1);
                }
            }
            List<Integer> listB = new ArrayList<>(mapB.keySet());
            for(int row: listB){
                col = mapB.get(row);
                field[row][col] = 'O';
                if(col-1<0) mapB.remove(row);
                else mapB.put(row, col-1);
            }
            // spread collision

            for(int[] c: collisions){
                for(int i=-1; i<=1; i++){
                    for(int j=-1; j<=1; j++){
                        if(c[0] +i >=0 && c[0]+i <field.length && c[1]+j >= 0 && c[1]+j < field[0].length){
                            field[c[0]+i][c[1]+j] = 'X';
                        }
                    }
                }
            }
            printMatrix(field);
            System.out.println();
        }
//        checkCollision();
        return field;
    }

    public void printMatrix(char[][] field){
        for(int i=0; i<field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j]+" ");
            }
            System.out.println();
        }
    }
}
