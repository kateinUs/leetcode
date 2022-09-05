package leetcode;

import java.util.Arrays;

/**
 * @author huimin
 * @create 2022-03-09 16:19
 */
public class T134_Gas_station {
    // Method 1: brute force
    // two nested loop: i for the start position
    //                  j for verifying
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum())
            return -1;

        for(int i=0; i<len; i++){
            int total = 0; // total gas volumn
            for(int j=i; j<i+len; j++){
                int pos = j % 5;
                total += gas[pos];
                total -= cost[pos+1];
                if(total < 0)
                    break;
                if(j == i+len-1)
                    return i;
            }
        }
        return -1;
    }
}
