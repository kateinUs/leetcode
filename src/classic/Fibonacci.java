package classic;

/**
 * 暴力递归的时间复杂度 O(N^2)
 * 升级版：去重递归 时间复杂度O(N) 空间复杂度O(N)
 * @author huimin
 * @create 2021-07-27 15:54
 */
public class Fibonacci {
    public static void main(String[] args) {
        int res = calculate(10);
        int res2 = iterate(10);
        System.out.println(res);
        System.out.println(res2);
    }

    // 升级版：去重递归 时间复杂度O(N) 空间复杂度O(N)
    public static int calculate(int num) {
        int[] arr = new int[num+1];

        return recurse(arr, num);
    }

    private static int recurse(int[] arr, int num){
        if(num <= 0)
            return 0;
        if(num == 1)
            return 1;
        if(arr[num] != 0){
            return arr[num];
        }
        arr[num] = recurse(arr, num-1) +recurse(arr, num-2);
        return arr[num];
    }

    // 升级版：双指针迭代 时间复杂度O(N) 空间复杂度O(1)
    public static int calculate2(int num) {
        int[] arr = new int[num+1];

        return recurse(arr, num);
    }
    private static int iterate(int num){
        if(num == 0)
            return 0;
        if(num == 1)
            return 1;
        int low = 0, high =1;
        for(int i=2; i<=num; i++){
            int sum = low +high;
            low = high;
            high = sum;
        }

        return high;
    }
}
