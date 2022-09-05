package leetcode;

/**
 * @author huimin
 * @create 2022-08-02 23:03
 */
public class T191_Number_of_1_bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        // because int have 32 bits, so loop 32 times
        for(int i=0; i<32; i++){
            if((mask & n) != 0) count ++;
            mask <<= 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1); // flips the least-significant 1-bit in n to 0.
        }
        return sum;
    }
    public int hammingWeight3(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>>= 1;
        }
        return count;
    }
}
