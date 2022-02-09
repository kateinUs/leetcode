package leetcode;

import java.util.HashMap;

/**
 * @author huimin
 * @create 2022-01-31 16:52
 */
public class T791_custom_sort_string {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<order.length(); i++){
            map.put(order.charAt(i), 0);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else{
                sb.append(s.charAt(i));
            }
        }

        for(int i=0; i<order.length(); i++){
            int time = map.get(order.charAt(i));
            for(int j=0; j<time; j++){
                sb.append(order.charAt(i));
            }
        }

        return sb.toString();
    }
}
