package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author huimin
 * @create 2022-01-26 18:26
 */
public class T394_decode_string {
    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != ']'){
                stack.add(s.charAt(i));
            } else{
                StringBuilder sb = new StringBuilder();
                while(stack.peek() != '['){
                    sb.append(stack.pop());
                }
                stack.pop();
                StringBuilder numStr = new StringBuilder();
                while(!stack.isEmpty() && stack.peek()>='0' && stack.peek()<='9'){
                    numStr.append(stack.pop());
                }
                int num = Integer.parseInt(numStr.reverse().toString());

                for(int j=0; j<num; j++){
                    for(int k=sb.length()-1; k>=0; k--){
                        stack.add(sb.charAt(k));
                    }
                }

            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "13[a]2[bc]";
        System.out.println(decodeString(s1));
        String s2 = "2[abc]3[cd]ef";
        System.out.println(decodeString(s2));
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        map.size();

    }
}
