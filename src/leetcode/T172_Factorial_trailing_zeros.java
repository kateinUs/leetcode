package leetcode;

/**
 * @author huimin
 * @create 2022-09-19 21:10
 */
public class T172_Factorial_trailing_zeros {

    public int trailingZeroes(int n) {
        int zeroCount = 0;
        // We need to use long because currentMultiple can potentially become
        // larger than an int.
        long currentMultiple = 5;
        while (n >= currentMultiple) {
            zeroCount += (n / currentMultiple);
            currentMultiple *= 5;
        }
        return zeroCount;
    }
}
