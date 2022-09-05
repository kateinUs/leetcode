package leetcode;

/**
 * @author huimin
 * @create 2022-07-28 16:13
 */
public class T153_Find_min_in_rotated_sorted_Arr {
    public static int findMin(int[] nums) {
        int l=0, r=nums.length-1;
        if(nums[0] < nums[r])
            return nums[0];
        while(l <= r){
            int m = l +(r-l)/2;
//            System.out.println(l+ " " + m +" "+ r);
            if(nums[l] <nums[r])
                return nums[l];
            if(m > 0 && nums[m]<nums[m-1])
                return nums[m];
            if(nums[m] > nums[l]){
                l = m+1;
            } else{
                r = m-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,0,1,2};
        findMin(arr);
    }
}
