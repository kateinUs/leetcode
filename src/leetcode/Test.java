package leetcode;

import java.util.PriorityQueue;

/**
 * @author huimin
 * @create 2021-05-21 19:09
 */
public class Test {
    public static void main(String[] args) {
        test3();


    }
    public void test1(){
        //        Scanner sc = new Scanner(System.in);
//        String input = sc.next();
        String str = "acbacdefc";
//        int len = str.length();
//        System.out.println(str.indexOf("a"));
        int count = 0;
        for(int i=str.indexOf("a"); i>=0; i=str.indexOf("a", i+1)){
            for(int j=str.indexOf("b", i); j>=0; j=str.indexOf("b", j+1)){
                for(int k=str.indexOf("c", j); k>=0; k=str.indexOf("c",k+1)){
                    count++;
                }
            }
        }
        System.out.println(count);
        Math.min(1,2);
    }

    public static void test2(){
        String s = "-91283472332";
        int a = Integer.parseInt(s);
        System.out.println(a);
    }
    public static void test3(){
        int[][] arr = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(arr[0][2]);

        String s = "asbc]]";
        PriorityQueue<Integer> que1 = new PriorityQueue<>(); // natural order
        PriorityQueue<Integer> que2 = new PriorityQueue<>((a,b) -> (b-a)); // dscending order

    }

}
