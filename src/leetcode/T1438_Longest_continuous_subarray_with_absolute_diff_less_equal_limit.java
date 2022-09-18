package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author huimin
 * @create 2022-09-07 21:58
 */
public class T1438_Longest_continuous_subarray_with_absolute_diff_less_equal_limit {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minQ = new LinkedList<>(), maxQ = new LinkedList<>();
        // first, last
        int f = 0, l = 0, ans = 0;

        while (f < nums.length) {
            // maintaining the monotonic property
            while (minQ.size() > 0 && nums[minQ.peekLast()] > nums[f]) minQ.pollLast();
            while (maxQ.size() > 0 && nums[maxQ.peekLast()] < nums[f]) maxQ.pollLast();
            minQ.add(f);
            maxQ.add(f);
            f++;
            // correcting the l pointer for the current f pointer
            while (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > limit) {
                if (maxQ.peekFirst() == l) {
                    maxQ.pollFirst();
                }
                if (minQ.peekFirst() == l) {
                    minQ.pollFirst();
                }
                l++;
            }
            ans = Math.max(ans, f-l);
        }
        return ans;
    }


    public int longestSubarray2(int[] nums, int limit) {
        PriorityQueue<Integer> pq1=new PriorityQueue<>((a, b)->a-b);
        PriorityQueue<Integer> pq2=new PriorityQueue<>((a,b)->b-a);
        int ans=0,len=1;
        pq1.add(nums[0]);
        pq2.add(nums[0]);
        int j=0;
        for(int i=1;i<nums.length;i++)
        {
            pq1.add(nums[i]);
            pq2.add(nums[i]);
            int x=pq1.peek(),y=pq2.peek();
            while(y-x>limit && j<i)
            {
                pq1.remove(nums[j]);
                pq2.remove(nums[j]);
                x=pq1.peek();
                y=pq2.peek();
                j++;
            }
            len=Math.max(len,i-j+1);
        }
        return len;
    }
}
