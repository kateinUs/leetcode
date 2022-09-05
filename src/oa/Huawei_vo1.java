package oa;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

import static java.util.Comparator.naturalOrder;

/**
 * 丑数：
 * 请你帮忙设计一个程序，用来找出第 n 个丑数。
 *
 * 丑数是可以被 a 或 b 或 c 整除的 正整数。
 *
 * 示例 1：
 * 输入：n = 3, a = 2, b = 3, c = 5
 * 输出：4
 * 解释：丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。
 *
 * 示例 2：
 * 输入：n = 4, a = 2, b = 3, c = 4
 * 输出：6
 * 解释：丑数序列为 2, 3, 4, 6, 8, 9, 10, 12... 其中第 4 个是 6。
 *
 * 示例 3：
 * 输入：n = 5, a = 2, b = 11, c = 13
 * 输出：10
 * 解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
 *
 * 示例 4：
 * 输入：n = 1000000000, a = 2, b = 217983653, c = 336916467
 * 输出：1999999984
 * @author huimin
 * @create 2022-01-06 21:01
 */
public class Huawei_vo1 {

    public static int findChouShu(int n, int a, int b, int c){
        int i=1;
        int count =0;
        while(count < n){
            if(i % a == 0 || i % b == 0 || i % c == 0){
                count++;
            }
            i++;
        }
        return i -1;
    }

    public static int findChouShu2(int n, int a, int b, int c){
        HashSet<Integer> set = new HashSet<>();
        for(int i=1; i<=n; i++){
            set.add(i * a);
             set.add(i * b);
            set.add(i * c);
        }
        Integer[] arr = set.toArray(new Integer[0]);
        Arrays.sort(arr);
        return arr[n-1];
    }

    public static void main(String[] args) {
        int res = findChouShu(5, 2, 11,13);
        int res2 = findChouShu2(5, 2, 11,13);
        int res3 = findChouShu2(4, 2, 3,4);
        System.out.println(res2);
        System.out.println(res3);
        String s = "qe";
        s.startsWith("1");
    }

}
