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

    public int largestVariance2(String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()){
            freq[c-'a'] ++;
        }
        // 找出两个不同字母a 和b, 两两进行检查
        // 想象成字母a 是 -1，b是 1，，其他字母为0
        // 那么 aaabbcacb，就变成[-1, -1, -1, 1, 1, 0, -1, 0, 1]
        // 只要用kadane算法求max subarray即可
        int maxVariance=0;
        for(int a=0; a<26; a++){
            for(int b=0; b<26; b++){
                int remainingA = freq[a];
                int remainingB = freq[b];
                if(a == b || remainingA == 0 || remainingB == 0){
                    continue;
                }
                int currBFreq = 0, currAFreq = 0;
                for(int i=0; i<s.length(); i++){
                    int cur = (int)(s.charAt(i)-'a');
                    if(cur == a){
                        currAFreq++;
                        remainingA--;
                    }else if(cur == b){
                        currBFreq++;
                    }

                    if(currAFreq > 0)
                        maxVariance = Math.max(maxVariance, currBFreq - currAFreq);
                    // 当前累积和已经变成负数，所以重新计算以获得最大值
                    if(currBFreq < currAFreq &&  remainingA >= 1){
                        currBFreq = 0;
                        currAFreq = 0;
                    }
                }
            }
        }

        return maxVariance;
    }
}
