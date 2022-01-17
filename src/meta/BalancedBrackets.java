package meta;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author huimin
 * @create 2021-11-30 11:53
 */
public class BalancedBrackets {
    static HashMap<Character, Character> matching = new HashMap<>();;
    static{
        matching.put(')', '(');
        matching.put(']', '[');
        matching.put('}', '{');
    }

     boolean isBalanced(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!matching.containsKey(ch))
                stack.push(ch);
            else if(!stack.empty())
                if(stack.peek() == matching.get(ch)){
                    stack.pop();
                }

                else
                    return false;

        }
        return stack.empty();
    }
}
