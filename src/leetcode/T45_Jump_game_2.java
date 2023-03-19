package leetcode;

import java.util.*;

/**
 * @author huimin
 * @create 2023-03-02 2:01
 */
public class T45_Jump_game_2 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(i -j <= nums[j]){
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }

        }
        return dp[n-1];
    }

    /**
     * Input: nums = [2,3,1,1,4]
     * Output: 2
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int end = 0;
        int max = 0;
        // 这个max记录的是 当前step数量下可以走到的最远距离
        int step = 0;
        for(int i=0;i<nums.length-1; i++){
            max = Math.max(max, nums[i]+i);
            if(i==end){
                step++;
                end = max;
            }
        }


        return step;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("test");
        list.add("test1");
        list.add("test2");
        list.add("abc");
        list.forEach(System.out::println);
        list.removeIf(s -> s=="abc");
        list.forEach(System.out::println);
        list.forEach((s) -> System.out.println("item: "+ s));
    }

}
