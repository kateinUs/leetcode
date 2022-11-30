package oa;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huimin
 * @create 2022-09-29 14:34
 */
public class shein_oa {
    public static void main(String[] args) {
        String target = "abc";
        char[] arr = "cacbcc".toCharArray();
        // return [1, 4]
//        Map<Character, Integer> freq = new HashMap<>();
//        for(char c: charArr){
//            freq.put(c, freq.getOrDefault(c,0)+1);
//        }
//        int l = 0, r;
//        for(r=0; r< charArr.length; r++){
//            char c = charArr[r];
//            if(freq.containsKey(c)){
//                if(freq.get(c) <= 1) freq.remove(c);
//                else freq.put(c, freq.get(c)-1);
//            }else l++;
//        }
        int l=-1, r;
        int t =0;
        for(r=0; r<arr.length; r++){
            if(target.charAt(t) == arr[r]){
                if(l == -1) l =r;
                t++;
                if(t >= target.length()) break;
            }

        }
        System.out.println("("+l+","+r+")");

    }
}
