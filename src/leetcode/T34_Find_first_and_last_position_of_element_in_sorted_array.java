package leetcode;

/**
 * @author huimin
 * @create 2022-02-21 15:21
 */
public class T34_Find_first_and_last_position_of_element_in_sorted_array {
    public int[] searchRange(int[] nums, int target) {

        int leftBound = searchBound(nums, target, true);
        if(leftBound == -1)
            return new int[]{-1, -1};
        int rightBound = searchBound(nums, target, false);
        return new int[]{leftBound,rightBound};
    }
    // return left bound is isFirst=true; else return right bound
    public int searchBound(int[] nums, int target, boolean isFrist){

        int l = 0;
        int r = nums.length-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                if(isFrist){
                    if(mid == l || nums[mid-1] != target){
                        return mid;
                    }
                    r = mid -1;
                }else{
                    if(mid == r || nums[mid+1] != target){
                        return mid;
                    }
                    l = mid+1;
                }
            }
            else if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        // cannot find target return -1
        return -1;
    }
}
