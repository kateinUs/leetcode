package leetcode;

/**
 * @author huimin
 * @create 2022-08-28 22:50
 */
public class T69_Sqrt {
    public int mySqrt(int x) {
        // binary search 刚好找到i² >= x 且 (i+1)²< x
        if(x < 2) return x;
        long num;
        int mid, l = 2, r = x/2;
        while(l<=r){
            mid = l + (r-l)/2;
            num = (long) mid *mid;
            if(num > x){
                r = mid -1;
            }else if(num < x){
                l = mid +1;
            }else
                return mid;
        }
        return r;
    }

    public int mySqrt2(int x) {
        if (x < 2) return x;

        int left = mySqrt2(x >> 2) << 1;
        int right = left + 1;
        return (long)right * right > x ? left : right;
    }
}
