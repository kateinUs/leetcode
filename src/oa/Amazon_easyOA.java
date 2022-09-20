package oa;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huimin
 * @create 2022-09-19 18:13
 */
public class Amazon_easyOA {
    // https://www.1point3acres.com/bbs/thread-920909-1-1.html
    // 无序的整型数组，求出平方数序列的最大长度，比如对于[2, 8, 9, 16, 4, 3]应该输出3，对应的平方数
    //序列是2，4，16。2是起始值，这样的序列对应长度是3，如果序列是2，3，5这样的就是长度0，找出符合条件的序列的最
    //大长度

    static int findLonestConsecutivePerfectSqaure(int[] arr){
        Set<Integer> set = new HashSet<>();
        for(int i:arr){
            set.add(i);
        }
        int len, max = 0;
        for(int i=0; i<arr.length; i++){
            int cur =arr[i];
            if(set.contains(cur)){
                len = 1;
                // find the number of perfect square
                while(set.contains(cur * cur)){
                    len ++;
                    set.remove(cur * cur);
                    cur = cur * cur;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] test = {2, 8, 9, 16, 4, 3, 256};
        System.out.println(findLonestConsecutivePerfectSqaure(test));
    }
}
