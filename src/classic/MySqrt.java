package classic;

/**
 * 要求：计算x的平方根的整数部分
 * 方式：二分法，牛顿迭代
 * @author huimin
 * @create 2021-07-25 16:22
 */
public class MySqrt {
    public static int binarySearch(int x){
        int index=-1, l=0, r=x;

        while(l <= r){
            int mid = l + (r - l)/2;
            if(mid * mid <= x){ // 因为平方根整数都是往下取整的
                index = mid;
                l = mid + 1;
            } else{
                r = mid - 1;
            }
        }

        return index;
    }

    /**
     * 牛顿迭代
     *       X^2 = N
     *             |
     * 公式： (X + N/X)/2
     *      这边N可以替换成任意表达式 比如2n-x
     * @param x
     * @return
     */
    public static int newton(int x){
        if(x == 0)
            return 0;
        return (int)sqrt(x, x);
    }

    public static double sqrt(double i, int x){
        double res = (i + x/i)/2;
        if(res == i){
            return i;
        } else{
            return sqrt(res, x);
        }
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(24));
        System.out.println(newton(24));
    }
}
