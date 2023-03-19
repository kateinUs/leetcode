package leetcode;

/**
 * @author huimin
 * @create 2023-02-14 22:52
 */
public class T494_Target_Sum {
    public int findTargetSumWays(int[] nums, int target) {
        int[] res = new int[1];
        dfs(nums, target, 0, res);
        return res[0];
    }

    void dfs(int[] nums, int target, int step,int[] res){
        if(step == nums.length){
            if(target ==0) res[0]++;
            return;
        }
        // -
        dfs(nums, target + nums[step], step+1, res);
        // +
        dfs(nums, target - nums[step], step+1, res);
    }
}
