package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huimin
 * @create 2022-01-29 0:37
 */
public class T1941_check_if_all_characters_have_equal_number_occurences {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        Integer count = -1;
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(count == -1)
                count = entry.getValue();
            else{
                // 这里之所以要用equals，因为比较的对象是Integer 引用数据类型的
                // 在 == 比较时，比较的是地址，而非内容
                if(!count.equals(entry.getValue())){
                    return false;
                }
            }
        }
        return true;
    }
}
