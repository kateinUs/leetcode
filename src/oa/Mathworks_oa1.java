package oa;

import java.util.*;

/**
 * collecting pebbles
 *
 * Case1:
 * Input:
 * numOfPubbles = 5
 * bucketSize = [3, 5]
 *  Return: 1
 * 桶的数量无限，但是必须装满，这个例子用1个5的桶
 *
 * numOfPubbles = 6
 *  bucketSize = [3, 5]
 *   Return: 2
 * 用两个3的桶
 *
 * numOfPubbles = 7
 *  * bucketSize = [3, 5]
 *  *  Return: -1
 *  无法在两个桶都装满的情况下 装满所有石头
 * @author huimin
 * @create 2022-09-13 16:33
 */
public class Mathworks_oa1 {
    public static int numOfBuckets(int N, int[] size){
        // n=5
        // size = [3, 5]
        int len = size.length;
        int[][] dp = new int[len+1][N+1];
//        for(int i=0; i< dp.length; i++)
//            dp[i][0] = Integer.MAX_VALUE;
        for(int j=0; j<dp[0].length; j++)
            dp[0][j] = Integer.MAX_VALUE;
        for(int i=1; i< dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(j >= size[i-1] && dp[i][j-size[i-1]] != Integer.MAX_VALUE)
                    dp[i][j] = Math.min(dp[i][j-size[i-1]]+1, dp[i-1][j]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        for(int i=0; i< dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return (dp[len][N] != Integer.MAX_VALUE)? dp[len][N]: -1;
    }

    /**
     * problem 2:
     * e.g.
     * words = ["west", "has", "stew", "good", "it"]
     * phrases = ["west has good stew", "good stew"]
     * @param
     */

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static int getPhrases(String[] words, String[] phrases){
        Set<String> set = new HashSet<>();
        for(String word: words){
            set.add(word);
        }
        Map<String, List<String>> map = new HashMap<>();
        int totalCount = 0;
        for(String phrase: phrases){
            String[] splits = phrase.split(" ");
            int count = 1;
            for(String split: splits){
                if(set.contains(split)){
                    int num;
                    if(!map.containsKey(split)){
                        for (String s : words) {
                            if (isAnagram(s, split)) {
                                List<String> list = map.getOrDefault(split, new ArrayList<>());
                                list.add(s);
                                map.put(split, list);
                            }
                        }

                    }
                    count *=  map.get(split).size();
                }
//                System.out.println(split +" "+count);
            }
            totalCount+= count;
        }
        return totalCount;
    }
    public static void main(String[] args) {
        int[] size = {3, 5};
        int n1 = 5;
        int n2 = 6;
        int n3 = 7;

//        System.out.println(numOfBuckets(n1, size));
//        System.out.println(numOfBuckets(n2, size));
//        System.out.println(numOfBuckets(n3, size));
        String[] words = {"west", "has", "stew", "good", "it"};
        String[] phrases = {"west has good stew", "good stew"};

        System.out.println(getPhrases(words, phrases));
    }

}
