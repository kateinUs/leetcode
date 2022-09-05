package leetcode;

/**
 * Use prefix sum
 * @author huimin
 * @create 2022-09-04 15:11
 */
public class T370_Range_addition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];

        for(int[] up: updates){
            res[up[0]] += up[2];

            if(up[1]< length-1){
                res[up[1]] -= up[2];
            }
        }
        for(int i=1;i<length; i++){
            res[i] += res[i-1];
        }
        return res;
    }
}
