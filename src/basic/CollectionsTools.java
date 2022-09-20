package basic;

import java.util.*;

/**
 * @author huimin
 * @create 2022-09-19 14:16
 */
public class CollectionsTools {
    public static void main(String[] args) {
        String[] words = {"I", "am", "happy", "today", "how", "about", "you"};

        List<String> list = Arrays.asList(words);
        list.forEach(a -> System.out.print(a +" "));
        System.out.println();
        // Collections.binarySearch
        int pos = Collections.binarySearch(list, "happy");
        System.out.println("The position of happy is: "+pos);

        // Collections.sort
        Collections.sort(list);
        System.out.println("Sort in natural order: ");
        list.forEach(a -> System.out.print(a +" "));
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println();
        System.out.println("Sort in reverse order: ");
        list.forEach(a -> System.out.print(a +" "));
        System.out.println();

        // Collections.reverse
        Collections.reverse(list);
        System.out.println("Reverse the list again:");
        list.forEach(a -> System.out.print(a +" "));
        System.out.println();

        // Collections.swap
        Collections.swap(list, 1, 3);
        System.out.println("After swap the 1st and 3rd string:");
        list.forEach(a -> System.out.print(a +" "));
        System.out.println();

    }
}
