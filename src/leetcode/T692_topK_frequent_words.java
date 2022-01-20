package leetcode;

import jdk.jfr.Frequency;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author huimin
 * @create 2022-01-18 1:20
 */
public class T692_topK_frequent_words {

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freq = new HashMap<>();
        for(int i=0; i<words.length; i++){
            freq.put(words[i], freq.getOrDefault(words[i], 0)+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() != o2.getValue())
                    return o2.getValue() - o1.getValue();
                else
                    return o1.getKey().compareTo(o2.getKey());
            }
        });
        for(Map.Entry<String, Integer> entry: freq.entrySet()){
            queue.add(entry);
        }
        List<String> res = new ArrayList<>();
        for(int i=0; i<k; i++){
            res.add(queue.remove().getKey());
        }
        return res;
    }

    public List<String> topKFrequent2(String[] words, int k) {

        //step1: Use the hashMap to store the count
        Map<String, Integer> counter = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            counter.put(word, counter.getOrDefault(word, 0) + 1);
        }

        //step2: Use the priority queue to build a min-heap. Lambda first order is the count, second order is the lexicographical order
        Queue<String> heap = new PriorityQueue<String>(
                (n1, n2) -> counter.get(n1) == counter.get(n2) ? n2.compareTo(n1) : counter.get(n1) - counter.get(n2) );

        //step3: Push counter KeySet into the min-heap
        for (String word : counter.keySet()) {
            heap.add(word);
            if (heap.size() > k) heap.poll();
        }

        //step 4 output the string array
        String[] top = new String[k];
        for (int i = k-1; i >= 0; i--) {
            top[i] = heap.poll();
        }

        return Arrays.asList(top);
    }

    public List<String> topKFrequent3(String[] words, int k){
        // Creating a map with each word and its frequency
        // then sorting it based on frequency and lexicographical order of same frequency
        // taking first k words fromm the sorted list
        return Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted((o1, o2) -> o2.getValue() == o1.getValue() ? o1.getKey().compareTo(
                o2.getKey()) : Long.compare(o2.getValue(), o1.getValue())).map(o -> o.getKey())
                .limit(k).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String[] words = new String[]{"i","love","leetcode","i","love","coding"};
        int k = 2;
        T692_topK_frequent_words cls = new T692_topK_frequent_words();
        List<String> strings = cls.topKFrequent(words, k);
        System.out.println(strings.toString());
    }
}
