package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author huimin
 * @create 2022-09-06 15:38
 */
public class T2272_Substring_with_largest_variance {
    public int largestVariance(String s) {

        int res = 0;
        // high表示的字母充当最高频次的字母，low充当最低频次的字母
        // 比如 aaabb, 当high='a', low='b'时， maxVariance=2 -> "aaab"
        // 相反地，当high='b', low='a'时，maxVarance=1 -> "abb"
        for(int high=0; high<26; high++){
            for(int low=0; low<26; low++){
                if(high == low) continue;

                int currHigh=0, currLow=0; // store the count of high/low letter
                // 我们期望的是high的count比low高，当low
                boolean shrinked = false;
                for(int i=0; i<s.length(); i++){
                    int ch = s.charAt(i) - 'a';
                    if(ch == high) currHigh ++;
                    else if(ch == low) currLow++;

                    if(currHigh>0 && currLow>0){
                        res = Math.max(res, currHigh-currLow);
                    }
                    else if(currHigh>0 && shrinked){
                        res = Math.max(res, currHigh-1);
                    }
                    // the shrink condition meet: the freq of low letter is larger than high
                    // we ignore the letters before i
                    // e.g. abb aaaaaa; high=a, low=b
                    // In the above case, when i=2, freq of b is larger than freq of a, so we don't need
                    // to consider the digits before i anymore since they will make the variance lower.
                    if(currLow > currHigh){
                        shrinked = true;
                        currHigh=0;
                        currLow = 0;
                    }
                }
            }
        }
        return res;
    }
}
