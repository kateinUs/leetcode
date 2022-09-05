package leetcode;

import java.util.*;

/**
 * @author huimin
 * @create 2022-03-08 16:12
 */
public class T1249_Minimim_remove_to_make_valid_parentheses {
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        Set<Integer> indexesToRemove = new HashSet<>();

        for(int i=0, j=0; i<s.length(); i++, j++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }else if(c == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    //delete the ')'
                    indexesToRemove.add(i);
                }

            }
        }
        while(!stack.isEmpty())
            indexesToRemove.add(stack.pop());
        for(int i=0; i<s.length(); i++){
            if(!indexesToRemove.contains(i)){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input ="())()(((";
        String out = minRemoveToMakeValid(input);
        System.out.println(out);
    }
}
