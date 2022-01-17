package meta;

import java.util.*;

/**
 * @author huimin
 * @create 2021-11-29 22:21
 */
public class Minimum_Length_Substrings {
    // mehtod 1:
    int minLengthSubstring(String s, String t) {
        // Write your code here
        HashMap<Character, Integer> occurance = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            occurance.put(ch, occurance.getOrDefault(ch, 0)+1);
        }
        HashMap<Character, ArrayList<Integer>> positions = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(occurance.containsKey(ch)){
                ArrayList<Integer> list = positions.getOrDefault(ch, new ArrayList<Integer>());
                list.add(i);
                positions.put(ch, list);
            }
        }
        if(positions.size()<t.length()) return -1;
        int minLen = Integer.MAX_VALUE;
        for(Map.Entry<Character, Integer> entry: occurance.entrySet()){
            Character key = entry.getKey();
            Integer value = entry.getValue();
            ArrayList<Integer> positionList = positions.get(key);
            if(positionList.size()<value) return -1;

        }

        return 0;
    }

    // sliding window
    int method2(String s, String t){


        if (t.length() == 0) {
            return -1;
        }
        List<Character> charsT = new ArrayList<Character>();
        for (int x=0;x<t.length();x++) {
            charsT.add(t.charAt(x));
        }
        int lastIndex = 0;
        for (int x=0;x<s.length() && charsT.size() > 0;x++) {
            charsT.remove((Character) s.charAt(x));
            lastIndex++;
        }
        if (charsT.size() > 0) {
            return -1;
        }

        return lastIndex;

    }

    static int magical_candy_bags(int[] arr, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->(b-a));
        for(int i=0; i< arr.length; i++){
            heap.add(arr[i]);
        }
        int eaten =0 ;
        for(int i=0; i<k; i++){
            Integer max = heap.poll();
            eaten += max;
            heap.add(max/2);
        }
        return eaten;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 7, 4, 2};
        int res = magical_candy_bags(arr, 3);
        System.out.println(res);
    }
}
