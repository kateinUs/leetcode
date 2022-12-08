package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author huimin
 * @create 2022-09-14 16:27
 */
public class T1696_Jump_game_6 {
    public static int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] score = new int[n];
        score[0] = nums[0];
        Deque<Integer> dq = new LinkedList<>();// 是一个递减队列，从头到尾递减

        dq.offerLast(0);
        for (int i = 1; i < n; i++) {
            // pop the old index
            while (dq.peekFirst() != null && dq.peekFirst() < i - k) {
                dq.pollFirst();
            }
            score[i] = score[dq.peek()] + nums[i];
            // pop the smaller value
            while (dq.peekLast() != null && score[i] >= score[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return score[n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {10,-5,-2,4,0,3};
        int k= 3;
        System.out.println(maxResult(arr, k));

    }
}
