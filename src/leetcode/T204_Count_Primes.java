package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author huimin
 * @create 2022-12-01 23:58
 */
public class T204_Count_Primes {
    // 埃筛法
    public int countPrimes(int n) {
        if(n <= 1) return 0;
        boolean[] composite = new boolean[n];
        for(int i=2; i<=Math.sqrt(n); i++){
            if(!composite[i]){
                for(int j=i*i; j<n; j+=i){
                    composite[j] = true;
                }
            }
        }
        int count = 0;
        for(int i=2; i<n; i++){
            if(!composite[i]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 5));
        int res = Collections.binarySearch(list, 3);
        System.out.println(res);
    }
}
