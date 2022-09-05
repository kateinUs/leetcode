package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huimin
 * @create 2022-04-20 17:10
 */
public class T13_roman_to_integer {
    static Map<Character, Integer> values = new HashMap<>();

    static {
        values.put('M', 1000);
        values.put('D', 500);
        values.put('C', 100);
        values.put('L', 50);
        values.put('X', 10);
        values.put('V', 5);
        values.put('I', 1);
    }
//    HashMap<Character, Integer> value = (HashMap<Character, Integer>) Map.of('M', 1000);
    public int romanToInt(String s) {
        int sum = 0;
        int i=0;
        while(i < s.length()){
            // get i-th and i+1-th value if exists
            int currValue = values.get(s.charAt(i));
            int nextValue =0;
            if(i+1 < s.length())
                nextValue = values.get(s.charAt(i+1));
            if(nextValue > currValue){
                sum += nextValue - currValue;
                i+=2;
            }
            else{
                sum += currValue;
                i++;
            }
        }
        return sum;
    }
}
