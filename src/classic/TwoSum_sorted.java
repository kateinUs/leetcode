package classic;

/**
 *
 * @author huimin
 * @create 2021-07-27 14:36
 */
public class TwoSum_sorted {
    public static void main(String[] args) {
        int[] res = twoPoint(new int[]{1,2,3,4,5,6}, 10);
        for (int re : res) {
            System.out.print(re +" ");
        }
    }

    // 二分法 时间复杂度O(NlogN)
    public static int[] twoSearch(int[] nums, int target){

        return null;
    }

    // 双指针 时间复杂度O(N)
    public static int[] twoPoint(int[] nums, int target){
        int low =0,high= nums.length-1;
        while(low < high){
            int sum = nums[low] + nums[high];
            if(sum == target){
                return new int[]{low, high};
            } else if(sum > target){
                high--;
            } else{
                low++;
            }
        }
        return new int[0];
    }
}
