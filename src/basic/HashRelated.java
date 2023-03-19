package basic;

import java.util.*;

/**
 * @author huimin
 * @create 2022-02-16 20:26
 */

public class HashRelated {
    static void test1(){
        LinkedHashSet<Integer> hm = new LinkedHashSet<>();
        hm.add(1);
        hm.add(2);
        hm.add(3);
        hm.add(8);
        hm.add(2);

        for (Integer integer : hm) {
            System.out.println(integer);
        }
    }

    static void test2(){
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        //用于存放结果
        setA.addAll(Arrays.asList(new Integer[]{1, 2, 3, 5}));
        setB.addAll(Arrays.asList(new Integer[]{3, 5, 7}));
        HashSet<Integer> resSet1 = new HashSet<>();
        resSet1.addAll(setA);
        resSet1.retainAll(setB);
        System.out.println("The intersection of set A and set B:");
        for(Integer i: resSet1){
            System.out.print(i+ " ");
        }
        System.out.println();

        HashSet<Integer> resSet2 = new HashSet<>();
        resSet2.addAll(setA);
        resSet2.removeAll(setB);
        System.out.println("The difference (A - B):");
        for(Integer i: resSet2){
            System.out.print(i+ " ");
        }
        System.out.println();

        HashSet<Integer> resSet3 = new HashSet<>();
        resSet3.addAll(setA);
        resSet3.addAll(setB);
        System.out.println("The uinon of A and B:");
        for(Integer i: resSet3){
            System.out.print(i+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        test1();
        test2();
    }
}
