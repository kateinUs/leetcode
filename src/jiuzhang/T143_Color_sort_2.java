package jiuzhang;

/**
 * 同时运用 quicksort和mergesort的思想
 * @author huimin
 * @create 2022-11-22 16:58
 */
public class T143_Color_sort_2 {

    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        sort(colors, 0, colors.length-1, 0, k);
        //           [3, 2, 2,   1, 4]
        // partition [1, 2, 2, | 3 ,4]
        //   sort(0,2, 1, 2) <-|-> sort(3, 4, 3, 4)
    }

    void sort(int[] nums, int start, int end, int colorFrom, int colorTo){
        // 退出条件：当前sort的数组里只有一个数，或者只有一个颜色，不需要再sort了
        if(start >= end || colorFrom >= colorTo) return;
        // partition
        // color <= mid 在左边 > mid 在右边
        int mid = (colorFrom+colorTo)/2;
        int left = start, right = end;
        while(left <= right){
            while(left <= right && nums[left] <= mid){
                left++;
            }
            while(left <= right && nums[right] > mid){
                right--;
            }
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++; right--;
            }
        }
        // start ... right | left ... end
        // left part colorFrom->mid
        sort(nums, start, right, colorFrom, mid);
        // right part mid+1->colorTo
        sort(nums, left, end, mid+1, colorTo);
    }
}
