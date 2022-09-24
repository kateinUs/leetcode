package oa;

import java.util.*;

/**
 * @author huimin
 * @create 2022-09-21 15:41
 */
public class Eulerity_OA {
    /**
     * cardinal dividents:
     * e.g 8 is cardinal divident
     * the set of divisors of 8 = [1, 2, 4, 8]
     * the number of divisors is 4, and also 4 is one of the divisor, so it's a cardinal divident
     */
    public static boolean isCardinalDivident(int num){
        if(num == 1) return true;
        int count=2;
        for (int i=2; i*i<=num; i++){
            if(num % i == 0){
                if(i*i == num) count--;
                count+=2;
            }
        }
        if(num % count == 0) return true;

        return false;
    }

    /**
     * Merging palindromes
     */
    public static String mergePalindrome(String s1, String s2){
        TreeMap<Character, Integer> map1 = new TreeMap<>();
        TreeMap<Character, Integer> map2 = new TreeMap<>();
        for(char c:s1.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0)+1);
        }
        for(char c:s2.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0)+1);
        }
        Map<Character, Integer> even = new TreeMap<>();
        Set<Character> odd = new HashSet<>();

        Character minOdd = null;
        for(Character c: map1.keySet()){
            if(map1.get(c) % 2 == 0)
                even.put(c, map1.get(c));
            else{
                if(minOdd == null || c<minOdd) minOdd = c;
                odd.add(c);
            }
        }
        Character sameOdd = null;
        StringBuilder sb = new StringBuilder();
        for(Character c: map2.keySet()){
            if(map2.get(c) % 2 == 0) {
                even.put(c, even.getOrDefault(c, 0)+ map2.get(c));
            }
            else{
                if(minOdd == null || c<minOdd) minOdd = c;
                if(odd.contains(c)){
                    sameOdd = c;
                }
            }
        }
        for(Character c: even.keySet()) {
            for (int i = 0; i < even.get(c) / 2; i++) {
                sb.append(c);
            }
        }
        StringBuilder increasingOrder = new StringBuilder(sb);

        if(sameOdd == null){
            if(minOdd != null)
                increasingOrder.append(minOdd);
        }else{
            int cnt = map1.get(sameOdd) + map2.get(sameOdd);
            for(int i=0; i<cnt; i++){
                increasingOrder.append(sameOdd);
            }
        }
        increasingOrder.append(sb.reverse());
        return increasingOrder.toString();
    }
    public static void main(String[] args) {
//        System.out.println(isCardinalDivident(8));
//        System.out.println(isCardinalDivident(6));
        String s1 = "aabbc", s2 = "ddefefq";
        System.out.println(mergePalindrome(s1, s2));
    }
}
