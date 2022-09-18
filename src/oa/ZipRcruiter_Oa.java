package oa;

import java.util.Arrays;

/**
 * @author huimin
 * @create 2022-09-15 23:56
 */
public class ZipRcruiter_Oa {
    /**
     * 给一个vector （a， b）是灯照的范围从a到b，给出几个这样的灯 要找出那几个点是所有灯光
     * 重合的地方 所有灯都可以照到的地方的数量如果没有就返回最左边的点的数值-1
     * 比如给了 （2，3）（3，4）就返回1, 因为有个点3被所有灯照到了
     * (2.3）（4.5）就返回-1
     */
    static int findNumOfLambs(int[][] ranges){
        Arrays.sort(ranges, (a,b) -> (a[0]==b[0])?a[1]-b[1]: a[0]-b[0]);
        int left=ranges[0][0];
        int right = ranges[0][1];
        for(int i=1; i<ranges.length; i++){
            if(ranges[i][0] > right) return -1;
            else left = ranges[i][0];
        }

        return right-left+1;
    }

    public static void main(String[] args) {
        int[][] test = {{2, 4},{3, 5}};
        System.out.println(findNumOfLambs(test));
    }
}
