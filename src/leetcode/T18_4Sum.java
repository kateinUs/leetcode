package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huimin
 * @create 2022-02-21 16:09
 */
public class T18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // 锚定两个点 两个for循环做2sum
        for(int i=0; i<=nums.length-4; i++){
            // 如果和前面循环过的值一样 就不需要再循环了，因为题目要求输出unique的答案
            if(i>0 && nums[i] == nums[i-1])
                continue;
            for(int j=i+1; j<= nums.length-3; j++){
                if(j>i+1 && nums[j] == nums[j-1])
                    continue;
                int l = j+1;
                int r = nums.length -1;
                while(l < r){
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target){
                        List<Integer> curAns = Arrays.asList(nums[i], nums[j], nums[l++], nums[r--]);
                        res.add(curAns);
                        while(nums[l] == nums[l-1] && l < r)
                            l++;
                        while(nums[r] == nums[r+1] && l < r)
                            r--;
                    }
                    else if(sum < target){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
