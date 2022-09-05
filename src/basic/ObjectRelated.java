package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huimin
 * @create 2022-02-04 20:33
 */
public class ObjectRelated {
    public void test1(){
        String[] arr = {"a", "b", "c"};
        List<String> l1 = Arrays.asList(arr);
        List<String> l2 = new ArrayList<>(Arrays.asList(arr));
        List<String> l3 = new ArrayList<>(Arrays.asList("a", new String("b"), "c"));
        System.out.println(l1 == l2);
        System.out.println(l1 == l3);
        System.out.println(l2 == l3);
        System.out.println(l1.equals(l2));
        System.out.println(l2.equals(l3));
    }

    public void test2(){
        try{
            System.out.println("try statement");
        } catch (ArithmeticException ex){
            System.out.println("catch Exception");
        } catch(Exception ex){
            System.out.println(ex);
        } // 如果上面两种exception交换位置 会出错
    }

    // Exception 不能catch住error
    public void test3(){
        try {
            System.out.println("Hello world!");
            throw new Error();
        } catch (Exception e){
            System.out.println("catch it");
        } finally{
            System.out.println("finally");
        }
    }

    public static void main(String[] args) {
        ObjectRelated cls = new ObjectRelated();
        cls.test1();
    }
}
