package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author huimin
 * @create 2023-02-14 23:15
 */
public class T2035_Partition_Array_Into_Two_Arrays_to_Minimize_Sum_Difference {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("12", "123", "1234");
        String[] strs = {"1", "2", "3"};
        String concatStr = String.join("-", list);
        System.out.println(concatStr);
        Collections.reverse(list);
    }
}
