package leetcode;

/**
 * @author huimin
 * @create 2022-01-19 19:45
 */
public class T696_count_binary_substrings {
    public int countBinarySubstrings(String s) {
        int[] groups = new int[s.length()];
        int j=0;
        groups[0] = 1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) != s.charAt(i-1)){
                groups[++j] = 1;
            }else{
                groups[j]++;
            }
        }
        int res = 0;
        for(int n=1; n<groups.length; n++){
            res += Math.min(groups[n], groups[n-1]);
        }
        return res;
    }
}
