package basic;

import java.util.*;

/**
 * @author huimin
 * @create 2022-09-19 14:16
 */

public class ArraysTools {
    public static void main(String[] args) {
        int[] arr = {1, 3,523, 532, 22,1,5};
//        Arrays.sort(arr);
//        Arrays.sort(arr, (a, b)->(b-a));
//        Arrays.sort(arr, Collections.reverseOrder());
        Arrays.stream(arr).forEach(System.out::println);
        Comparator.reverseOrder();
        // 这俩是相同的
        Collections.reverseOrder();

        int[][] intervals = {{1, 0}, {1, 3}, {3, 0}, {2,2}, {8, 9}, {3,6}};
        Arrays.sort(intervals, (a, b)->(a[0] == b[0])?a[1]-b[1]:a[0]-b[0]);
        Arrays.stream(intervals).forEach(a -> System.out.println(a[0] +", " + a[1]));
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 14, 5, 5,2 ));
        Collections.sort(list);

//        String s1 = "werw";
//        int i = s1.compareTo(s1);
        StringBuilder sb = new StringBuilder();
        sb.append("ad");
        sb.deleteCharAt(1);

    }

}
