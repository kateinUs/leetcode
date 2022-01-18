package leetcode;

import java.util.*;

/**
 * @author huimin
 * @create 2022-01-18 1:20
 */
public class T692_topK_frequent_words {
    class Frequency{
        String word;
        int count;
        Frequency(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freq = new HashMap<>();
        for(int i=0; i<words.length; i++){
            freq.put(words[i], freq.getOrDefault(words[i], 0)+1);
        }
        PriorityQueue<Frequency> queue = new PriorityQueue<>(new Comparator<Frequency>(){
            public int compare(Frequency o1, Frequency o2){
                if(o1.count != o2.count)
                    return o2.count - o1.count;
                else
                    return o1.word.compareTo(o2.word);
            }
        });
        for(Map.Entry<String, Integer> entry: freq.entrySet()){
            String key = entry.getKey();
            int value = entry.getValue();
            queue.add(new Frequency(key, value));

        }
        List<String> res = new ArrayList<>();
        for(int i=0; i<k; i++){
            res.add(queue.remove().word);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"i","love","leetcode","i","love","coding"};
        int k = 2;
        T692_topK_frequent_words cls = new T692_topK_frequent_words();
        List<String> strings = cls.topKFrequent(words, k);
        System.out.println(strings.toString());
    }
}
