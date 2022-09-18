package leetcode;

/**
 * https://leetcode.com/problems/sum-of-prefix-scores-of-strings/discuss/2590081/C%2B%2B-Java-Python3-Easy-Trie-Explained-with-diagram
 * @author huimin
 * @create 2022-09-18 0:16
 */
public class t2416_Sum_of_Prefix_Scores_of_Strings {
    class Trie {
        Trie[] ch = new Trie[26];
        int visited = 0;
    }
    class Solution {
        public int[] sumPrefixScores(String[] words) {
            Trie trie = new Trie();
            int[] ans = new int[words.length];
            int k = 0;
            for (String x: words) {
                Trie t = trie;
                for (int i = 0; i < x.length(); i++) {
                    int c = x.charAt(i) - 'a';
                    if (t.ch[c] == null) t.ch[c] = new Trie();
                    t.ch[c].visited++;
                    t = t.ch[c];
                }
            }
            for (String x: words) {
                Trie t = trie; int curr = 0;
                for (int i = 0; i < x.length(); i++) {
                    int c = x.charAt(i) - 'a';
                    curr += t.ch[c].visited;
                    t = t.ch[c];
                }
                ans[k++] = curr;
            }
            return ans;
        }
    }
}
