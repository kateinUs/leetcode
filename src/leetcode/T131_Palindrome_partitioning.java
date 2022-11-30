package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huimin
 * @create 2022-11-14 15:10
 */
public class T131_Palindrome_partitioning {
    // Method 1: pure DFS
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> res = new ArrayList<>();
        dfs(0, s, new ArrayList<String>(), res);

        return res;
    }
    void dfs(int start, String s, List<String> path, List<List<String>> res){
        if(start == s.length()) res.add(new ArrayList<>(path));
        for(int i=start+1; i<=s.length(); i++){
            String cur = s.substring(start, i);
            if(isPalindrome(cur)){
                path.add(cur);
                dfs(i, s, path, res);
                path.remove(path.size()-1);
            }
        }
    }
    boolean isPalindrome(String s){
        if(s.length() == 1) return true;
        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }

    // Method 2: DFS with memo

    public static void main(String[] args) {
        String s ="aab";
        T131_Palindrome_partitioning test= new T131_Palindrome_partitioning();
        List<List<String>> partition = test.partition(s);
        for(List<String> list: partition){
            for(String li: list){
                System.out.print(li+ " ");
            }
            System.out.println();
        }
    }
}
