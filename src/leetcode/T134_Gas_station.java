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

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        // Iterate through all the gas stations
        for(int i = 0 ; i<gas.length; i++){
            // Add the gas and cost at each station to the total
            totalGas += gas[i];
            totalCost += cost[i];
        }
        // If totalCost is greater than totalGas, it is not possible to complete the circuit
        if(totalGas < totalCost) return -1;

        // Initialize remainsGas and start to 0
        int remainsGas = 0, start = 0;
        // Iterate through all the gas stations
        for(int i = 0 ; i < gas.length; i++){
            // Add the difference between gas and cost at each station to remainsGas
            remainsGas = remainsGas +(gas[i] - cost[i]);
            // If remainsGas becomes negative, set start to the next station and reset remainsGas to 0
            if(remainsGas < 0 ){
                start = i+1;
                remainsGas = 0;
            }
        }
        // Return the starting station
        return start;
    }
}
