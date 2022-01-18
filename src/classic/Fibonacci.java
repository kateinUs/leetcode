package classic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 方法一：暴力递归
 *  时间复杂度 O(N^2)
 *
 * @author huimin
 * @create 2021-07-27 15:54
 */
public class Fibonacci {
    public static void main(String[] args) {
        int res2 = calculate(10);
        int res3 = fibTab(10);
        int res4 = fibTwoPointer(10);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
    }

    // 方法二：逆向去重递归
    //   时间复杂度O(N) 空间复杂度O(N)
    // dynamic programming: memorization
    public static int calculate(int num) {
        int[] arr = new int[num+1];

        return fibMemo(arr, num);
    }

    private static int fibMemo(int[] arr, int num){
        if(num <= 0)
            return 0;
        if(num == 1)
            return 1;
        if(arr[num] != 0){
            return arr[num];
        }
        arr[num] = fibMemo(arr, num-1) +fibMemo(arr, num-2);
        return arr[num];
    }

    // 方法三：正向计算
    //   时间复杂度O(N) 空间复杂度O(N)
    private static int fibTab(int num){
        ArrayList<Integer> tb = new ArrayList<>();
        tb.add(0);
        tb.add(1);
        for(int i=2; i<=num; i++){
            tb.add(tb.get(i-1) + tb.get(i-2));
        }

//        for(Integer i: tb){
//            System.out.print(i + " ");
//        }
        HashMap<Integer, Integer> map = new HashMap<>();
        return tb.get(num);
    }
    // 方法四：：双指针迭代 时间复杂度O(N) 空间复杂度O(1)
    private static int fibTwoPointer(int num){

        int low = 0, high =1;
        for(int i=2; i<=num; i++){
            int sum = low +high;
            low = high;
            high = sum;
        }

        return high;
    }
}
