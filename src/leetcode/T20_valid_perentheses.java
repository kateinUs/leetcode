package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author huimin
 * @create 2021-09-09 22:29
 */
public class T20_valid_perentheses {
    // Method 1: use stack and HashMap
    static Map<Character, Character> mappings = new HashMap<>();
    static {
        mappings.put('(', ')');
        mappings.put('[', ']');
        mappings.put('{', '}');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mappings.containsKey(c)) {
                stack.push(mappings.get(c));
            } else if (mappings.containsValue(c)) {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    // Method 2: use stack without HashMap
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); ++i){
            char ch = s.charAt(i);
            if (!stack.isEmpty() &&((ch == ')' && stack.peek() == '(') ||
                    (ch == '}' && stack.peek() == '{') ||
                    (ch == ']' && stack.peek() == '[')))
                stack.pop();
            else
                stack.add(ch);
        }
        return stack.isEmpty();
    }
}
