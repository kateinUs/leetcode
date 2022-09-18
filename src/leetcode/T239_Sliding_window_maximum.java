package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 方法与1696类似 都用递减栈
 * @author huimin
 * @create 2022-09-15 0:13
 */
public class T239_Sliding_window_maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> dq = new LinkedList<>(); // 递减栈
        int[] res = new int[n-k+1];
        for(int i=0; i<n; i++){

            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()] ){
                dq.pollLast();
            }
            dq.offerLast(i);
            while(dq.peekFirst()< i-k+1){
                dq.pollFirst();
            }
            if(i >= k-1){
                res[i-k+1] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}
