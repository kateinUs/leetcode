package oa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author huimin
 * @create 2022-09-19 15:15
 */
public class RedBook_OA {
    //  ABCD 四个组件拼装，判断合格的同时修改数量，最后取四者中最小值即可。
    void test1(){
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt(), a2 = sc.nextInt(), a3 = sc.nextInt(), a4 = sc.nextInt(), x = sc.nextInt();
        int[] a = {a1, a2, a3, a4};
        sc.nextLine();
        for (int i = 0; i < 4; i++) {
            String str = sc.nextLine();
            String[] nums = str.split(" ");
            for (String num : nums) {
                if (Integer.parseInt(num) < x) {
                    a[i] = a[i] - 1;
                }
            }
        }
        // 减掉不合格的零件，返回合格数量最小的零件个数
        int min = Arrays.stream(a).min().getAsInt();
        System.out.println(min);
    }
    // 典型的动态规划：当前位置 dp[i] 的最小值，由之前 k 个元素决定。
    void test2(){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 100);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i - j < 0) break;
                dp[i] = Math.min(dp[i], dp[i - j] + Math.max(0, arr[i] - arr[i - j]));
            }
        }
        System.out.println(dp[n - 1]);
    }

    //滑动窗口：当窗口内任一元素达到 k 个时，窗口收缩。窗口收缩时，当前 子数组右边的 n - right
    // 个元素逐一加入该子数组，都满足题目条件，所以统计时是加 n - right 而非加 1
    void test3(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int left = 0, right = 0;
        int cnt = 0;
        Map<Integer, Integer> window = new HashMap<>();
        while (right < n) {
            int num1 = arr[right];
            window.put(num1, window.getOrDefault(num1, 0) + 1);
            while (window.get(num1) == k) {
                int num2 = arr[left];
                left++;
                window.put(num2, window.get(num2) - 1);
                cnt = cnt + (n - right);
            }
            right++;
        }
        System.out.println(cnt);
    }
    public static void main(String[] args) {

    }
}

