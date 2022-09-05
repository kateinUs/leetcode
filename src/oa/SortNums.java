package oa;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * @author huimin
 * @create 2022-03-10 16:06
 */
public class SortNums {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\90494\\IdeaProjects\\mystudy\\src\\oa\\sort.txt");
        Scanner scanner = new Scanner(file);
        List<BigInteger> list = new ArrayList<>();
        while(scanner.hasNextBigInteger()){
            BigInteger bigInteger = scanner.nextBigInteger();
            list.add(bigInteger);
        }
        long start = System.currentTimeMillis();
        Collections.sort(list);
        long end = System.currentTimeMillis();
        for(BigInteger i: list){
            System.out.println(i);
        }
        System.out.println((end - start) + "milliseconds");
    }
}
