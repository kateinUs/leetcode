package leetcode;

/**
 * @author huimin
 * @create 2022-03-08 20:30
 */
public class T680_Valid_palindrome_2 {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)){
                return helper(s,l+1, r) || helper(s, l, r-1);
            }
            l++; r--;
        }
        return true;
    }

    private boolean helper(String s, int l, int r) {
        while(l <= r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++; r--;
        }
        return true;
    }
}
