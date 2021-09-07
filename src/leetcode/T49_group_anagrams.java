package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author huimin
 * @create 2021-09-08 1:54
 */
public class T49_group_anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0)
            return new ArrayList();
        HashMap<String, List> map = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sorted = String.valueOf(ch);
            if(!map.containsKey(sorted))
                map.put(sorted, new ArrayList<String>());
            map.get(sorted).add(str);
        }
        return new ArrayList(map.values());
    }
}
