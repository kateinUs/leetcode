package classic;

/**
 * @author huimin
 * @create 2021-07-27 17:22
 */
public class ArrangeCoin {
    public static void main(String[] args) {
        System.out.println(arrangeCoin3(20));
    }

    //迭代
    public static int arrangeCoin(int n) {
        for(int i=1; i<n; i++){
            n = n - i;
            if(n <= i)
                return i;
        }
        return 0;
    }

    //二分查找
    public static int arrangeCoin2(int n) {
        int low = 0, high = n;
        while(low <= high){
            int mid = low + (high - low)/2;
            int cost = (mid+1) * mid / 2;
            if (cost == n){
                return mid;
            } else if(cost > n){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return high; // ??为啥这边返回high不是low
    }

    //牛顿迭代 bug：当n=20时
    public static int arrangeCoin3(int n) {
        if(n == 0){
            return 0;
        }
        return (int)sqrt(n, n);

    }

    private static double sqrt(double x, int n) {
        double res = (x + (2*n - x)/x)/2;
        if(res == x)
            return x;
        else
            return sqrt(res, n);
    }
}
