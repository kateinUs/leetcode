package basic_transfomation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author huimin
 * @create 2022-01-19 21:53
 */
public class IntegerRelated {
    public static void test1(){
        // 1. transform int[] to List<Integer>
        int[] arr= new int[]{1,2,3,4};
        List<Integer> list1 = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println("--- Print list 1:");
        System.out.println(list1);

        // 2. transform int[] to Integer[]
        Integer[] arr2 = Arrays.stream( arr ).boxed().toArray( Integer[]::new );

        Integer[] arr3 = IntStream.of( arr ).boxed().toArray( Integer[]::new );
        // 3. transform Integer[] to List<Integer>
        // 3.1 Use Collections.addAll
        List<Integer> list2 = new ArrayList<>(arr.length);
        List<Integer> list3 = new ArrayList<>(arr.length);

        Collections.addAll(list2,arr2);
        Collections.addAll(list3,arr3);
        System.out.println("--- Print list 2:");
        System.out.println(list2);
        System.out.println("--- Print list 3:");
        System.out.println(list3);
        
        // 3.2 Use Arrays.asList(array)
        List<Integer> list4 = Arrays.asList(arr2);
    }

    public void test2() {
        int[] array = {1, 2, 5, 5, 5, 5, 6, 6, 7, 2, 9, 2};

        /*int[]转list*/
        //方法一：需要导入apache commons-lang3  jar
        // https://mvnrepository.com/artifact/org.apache.commons/commons-lang3/3.7
//        List<Integer> list = Arrays.asList(ArrayUtils.toObject(array));
        //方法二：java8及以上版本
        List<Integer> list1 = Arrays.stream(array).boxed().collect(Collectors.toList());

        /*list转int[]*/
        //方法一：
        Integer[] intArr = list1.toArray(new Integer[list1.size()]);
        //方法二：java8及以上版本
        int[] intArr1 = list1.stream().mapToInt(Integer::valueOf).toArray();

    }

    public static void main(String[] args) {
        test1();
    }
}
