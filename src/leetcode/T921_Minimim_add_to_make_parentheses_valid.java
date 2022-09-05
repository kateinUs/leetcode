package leetcode;

/**
 * @author huimin
 * @create 2022-03-09 22:05
 */
public class T921_Minimim_add_to_make_parentheses_valid {
    public int minAddToMakeValid(String s) {
        if(s.length() == 0)
            return 0;
        int left = 0;
        int right = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                left++;
            }else if(ch == ')'){
                if(left >0)
                    left--;
                else
                    right++;
            }
        }
        return left +right;
    }
}
