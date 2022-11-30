package oa;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author huimin
 * @create 2022-10-03 0:41
 */
public class CodeSignal {
    public static void test1(){
        int i = 32;
        String.valueOf(i);
        Integer res1 = Integer.valueOf("12");
        int res2 = Integer.parseInt("12");
        System.out.println(res1);
        System.out.println(res2);
    }

    String customMergeString(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for(char c: c1){
            map1.put(c, map1.getOrDefault(c, 0)+1);
        }
        for(char c: c2){
            map2.put(c, map2.getOrDefault(c, 0)+1);
        }
        int m=c1.length, n = c2.length, i=0, j=0;
        StringBuilder sb = new StringBuilder();
        while(i<m && j<n){
            if(map1.get(c1[i]) < map2.get(c2[j])){
                sb.append(c1[i++]);
            }else if(map1.get(c1[i]) > map2.get(c2[j])){
                sb.append(c2[j++]);
            }else{
                if(c1[i] <= c2[j])  sb.append(c1[i++]);
                else sb.append(c2[j++]);
            }
        }
        while(i<m || j<n){
            if(i == m){
                sb.append(c2[j++]);
            }else{
                sb.append(c1[i++]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        test1();
    }
    public void tes2(){
        System.out.println("");
        int[] a = new int[10];
        for(int i=0; i<a.length; i++){
            
        }
        LinkedList<Integer> lst = new LinkedList<>();
        lst.addFirst(1);
        String s = "1we";
        s.toLowerCase();
    }


}
