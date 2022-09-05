package leetcode;

import java.util.Stack;

/**
 * @author huimin
 * @create 2022-03-09 20:07
 */
public class T227_Basic_calculator_2 {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        int currNum = 0;
        char preOperation = '+';
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currNum = currNum *10+ ch-'0';
            }
            if(!Character.isDigit(ch) && !Character.isWhitespace(ch) || i ==s.length()-1){
                if (preOperation == '/') {
                    stack.push(stack.pop() / currNum);
                } else if (preOperation == '*') {
                    stack.push(stack.pop() * currNum);
                } else if (preOperation == '+') {
                    stack.push(currNum);
                } else if (preOperation == '-') {
                    stack.push(-currNum);
                }

                preOperation = ch;
                currNum = 0;
            }
        }
        int ans = 0;
        while(!stack.isEmpty()){
            ans += stack.pop();
        }

        return ans;
    }
}
