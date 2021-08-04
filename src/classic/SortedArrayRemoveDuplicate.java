package classic;

/**
 * 要求：一个有序数组nums，原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度
 * 注意：不能使用额外的数组空间，必须在原地修改输入数组并在使用O(1)额外空间的条件下完成
 * 重点： 双指针算法:
 *      数组完成排序后，我们可以放置两个指针i和j，其实i是满指针，j是快指针。只要nums[i]=nums[j],
 *      我们就增加j以跳过重复项。
 *
 *      当遇到nums[i]！=nums[j]时,跳过重复项的运行已经结束，必须把num[j]的值赋到nums[i+1]，然后
 *      递增，接着再次重复相同的过程，直到到达数组的末尾
 * @author huimin
 * @create 2021-07-24 16:47
 */
public class SortedArrayRemoveDuplicate {
    public static int removeDuplicate(int[] nums){
        if(nums.length == 0)
            return 0;

        int i=0;
        for(int j=1; j<nums.length; j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }

        return i+1;
    }

    public static void main(String[] args) {
        int res = removeDuplicate(new int[]{0,1,2,2,3,3,4});
        System.out.println(res);
    }
}
