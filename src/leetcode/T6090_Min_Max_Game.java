package leetcode;

import java.util.*;

/**
 * @author huimin
 * @create 2022-06-04 22:32
 */
public class T6090_Min_Max_Game {
    public int minMaxGame(int[] nums) {
        Queue<Integer> list = new LinkedList<>();

        for(int i: nums){
            list.add(i);
        }
        while(list.size()>1){
            int len = list.size();
            for(int i=0; i<len/2; i++){
                if(i % 2 == 0){ // even
                    list.add(Math.min(list.remove(), list.remove()));
                }else{ // odd
                    list.add(Math.max(list.remove(), list.remove()));
                }
            }
        }
        return list.remove();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,2,4,8,2,2};
        T6090_Min_Max_Game test = new T6090_Min_Max_Game();
        int ans = test.minMaxGame(arr);
        System.out.println(ans);
    }
}
