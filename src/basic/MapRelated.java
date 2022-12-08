package basic;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Map 按值排序 按键排序的方法 以及时间复杂度 空间复杂度 比较
 * @author huimin
 * @create 2022-09-19 14:04
 */
public class MapRelated {

    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 1020);
        map.put(3, 300);
        map.put(1, 100);
        map.put(5, 500);
        map.forEach((k,v)->System.out.println(k+"="+v));

        // Method 1: 转化成list后用Entry.comparingByValue() 排序
        List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue(Collections.reverseOrder()));
//        list.sort(Entry.comparingByValue(Comparator.reverseOrder()));
        System.out.println("After Sorting by value");
        list.forEach(System.out::println);

        Integer keyWithMaxValue = Collections.max(map.entrySet(), Entry.comparingByValue()).getKey();
        Integer maxKey = Collections.max(map.entrySet(), Map.Entry.comparingByKey()).getKey();
        System.out.println("Key with max value: " + keyWithMaxValue);
        System.out.println("Max key: " + maxKey);

        // Method 2: 用java8新特性stream 排序 stream().sorted(Map.Entry.comparingByValue())
        System.out.println("After Sorting by value");
        Stream<Entry<Integer, Integer>> sorted =
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue());
        sorted.forEach(System.out::println);

        // Method 3: 转换成list 用comparator排序
        List<Entry<Integer, Integer>> list2 = new LinkedList<>(map.entrySet());
        Collections.sort(list2, new Comparator<Object>() {
            @SuppressWarnings("unchecked")
            public int compare(Object o1, Object o2) {
                return ((Comparable<Integer>) ((Map.Entry<Integer, Integer>) (o1)).getValue()).compareTo(((Map.Entry<Integer, Integer>) (o2)).getValue());
            }
        });
        Map<Integer, Integer> result = new LinkedHashMap<>();
        for (Iterator<Entry<Integer, Integer>> it = list2.iterator(); it.hasNext();) {
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) it.next();
            result.put(entry.getKey(), entry.getValue());
        }
        result.forEach((k,v)->System.out.println(k+"="+v));

        //Method 4: 用stream sorted方法，最后输出成一个新的linkedhashmap
        System.out.println("After Sorting by value");
        Map<Integer, Integer> result2 = map.entrySet().stream()
                .sorted(Entry.comparingByValue())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        result2.forEach((k,v)->System.out.println(k+"="+v));

        // Method 5: TreeMap 对键进行排序
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>(Comparator.naturalOrder());
        treeMap.putAll(map);
        treeMap.forEach((k,v)->System.out.println(k+"="+v));
        // TreeMap 其他操作
        Integer first = treeMap.firstKey();
        treeMap.firstEntry();
        Integer last = treeMap.lastKey();
        treeMap.lastEntry();
        System.out.println("First key " + first);
        System.out.println("Last key " + last);

        Integer keyHigherThan1 = treeMap.higherKey(1);

        Integer keyLowerThan5 = treeMap.lowerKey(5);
        System.out.println("The key higher then 1 is "+ keyHigherThan1);
        System.out.println("The key lower than 5 is "+ keyLowerThan5);

    }


}


