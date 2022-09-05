package leetcode;

import java.util.HashSet;

/**
 * Given a string s and an integer k, return the length of the longest substring
 * of s that contains at most k distinct characters.
 *
 * Example:
 * Input: s = "eceba" k=2
 * Output: 3
 * Explanation: The substring is "ece" with length 3.
 *
 * @author huimin
 * @create 2022-07-16 17:18
 */
public class T340_Longest_substring_with_at_most_k_distinct_character {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int max = 0;
        int l = 0;
        int[] occurTime = new int[256];
        HashSet<Character> distSet = new HashSet<>();
        for(int r=0; r<s.length(); r++){
            char curr = s.charAt(r);
            distSet.add(curr);
            occurTime[curr] ++;
            while (distSet.size()>k && l<=r){
                // move the left pointer to right by 1 step
                char lc = s.charAt(l);
                occurTime[lc] --;
                if(occurTime[lc] <= 0)
                    distSet.remove(s.charAt(l));
                l++;

            }
            max = Math.max(max, r-l+1);
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        int res = lengthOfLongestSubstringKDistinct(s, k);
        System.out.println(res);
    }
}
