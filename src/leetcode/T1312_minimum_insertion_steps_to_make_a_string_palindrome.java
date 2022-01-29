package leetcode;

/**
 * Method:
 *  Use longest common substring
 * @author huimin
 * @create 2022-01-26 18:00
 */
public class T1312_minimum_insertion_steps_to_make_a_string_palindrome {
    public static int minInsertions(String s) {
        StringBuilder reverse = new StringBuilder();
        reverse.append(s);
        reverse.reverse();
        int len = s.length();
        int[][] lcs = new int[len+1][len+1];
        for(int i=1; i<lcs.length; i++){
            for(int j=1; j<lcs[0].length; j++){
                if(s.charAt(i-1) == reverse.charAt(j-1))
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                else
                    lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
            }
        }
        return len-lcs[len][len];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int res = minInsertions(s);
        System.out.println(res);
    }
}
