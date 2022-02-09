package leetcode;

import basic.IntegerRelated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author huimin
 * @create 2022-02-06 23:36
 */
public class T735_Asteroid_collision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<asteroids.length; i++) {
            Integer curr = asteroids[i];
            if (stack.isEmpty()) {
                stack.push(curr);
                continue;
            } else {
                if (stack.peek() > 0 && curr < 0) {
                    if (stack.peek() + curr > 0) {

                    } else if (stack.peek() + curr < 0) {
                        while (!stack.isEmpty() && stack.peek()>0 && stack.peek()+curr < 0) {
                            stack.pop();
                        }
                        if(!stack.isEmpty() && stack.peek()+curr == 0){
                            stack.pop();
                        }
                        else if(stack.isEmpty() || stack.peek()<0) {
                            stack.push(curr);
                        }
                    } else {
                        stack.pop();
                    }
                } else {
                    stack.push(curr);
                }
            }
        }
//            boolean flag = false;
//            while(!stack.isEmpty()){
//                flag = false;
//                if(stack.peek()>0 && curr <0){
//                    if(stack.peek() + curr > 0){
//                        break;
//                    }else if(stack.peek() + curr < 0){
//                        flag = true;
//                        stack.pop();
//                    }else{
//                        stack.pop();
//                        break;
//                    }
//                }else{
//                    stack.push(curr);
//                    break;
//                }
//            }
//            if(flag)
//                stack.push(curr);

        int[] res = new int[stack.size()];
        for(int i=stack.size()-1; i>=0; i--){
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,1,-2,-2};
        int[] res = asteroidCollision(test);
        for(int i: res){
            System.out.println(i);
        }
    }

    public int[] asteroidCollision2(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int val:asteroids){
            if(val>0){
                st.push(val);
                continue;
            }
            while(st.size()>0 && st.peek()<-val && st.peek()>0){
                st.pop();
            }

            if(st.size()>0 && st.peek()==-val){
                st.pop();
            }else if(st.size()==0 || st.peek()<0){
                st.push(val);
            }
        }
        int[] res=new int[st.size()];
        for(int i=res.length-1;i>=0;i--){
            res[i]=st.pop();
        }
        return res;
    }
}
