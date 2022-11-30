package jiuzhang;

/**
 * @author huimin
 * @create 2022-11-22 0:42
 */
public class T5_Quick_Select {
    public int kthLargestElement(int k, int[] nums) {
        if(nums == null)
            return -1;
        return quickSelect(nums, 0, nums.length-1, k);
    }
    public int quickSelect(int[] nums, int start, int end, int k){
        if(start == end) return nums[start];

        int pivot = nums[(start+end)/2];
        int left = start, right = end;
        while(left <= right){
            // 因为找第k大，从大到小排, 这里达大小于号和quicksort相反
            while(left <= right && nums[left] > pivot){
                left ++;
            }
            while(left <= right && nums[right] < pivot){
                right--;
            }
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left ++;
                right --;
            }
        }
        // start ... right | x | left .. end
        // 第k个数在左边
        if(start + k -1 <= right){
            return quickSelect(nums, start, right, k);
        }
        // 第k个数在右边
        if(start + k -1 >= left){
            return quickSelect(nums, left, end, k-(left-start));
        }
        return nums[right+1];
    }
}
