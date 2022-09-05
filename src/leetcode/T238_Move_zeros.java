package leetcode;

/**
 * @author huimin
 * @create 2022-07-26 16:40
 */
public class T238_Move_zeros {
    public void moveZeroes(int[] nums) {
        // int pi=0, p0=0;
        int p = nums.length;
        int i=0;
        while(i<p){
            if(nums[i] == 0){
                for(int j=i+1; j<p; j++){
                    swap(nums, j-1, j);
                }
                p--;
            }else{
                i++;
            }
            for(int num: nums){
                System.out.print(num);
            }
            System.out.println();
        }
    }
    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void moveZero2(int[] nums){
        int cnt_nz=0, p=0;
        while(p < nums.length){
            if(nums[p] != 0){
                nums[cnt_nz] = nums[p];
                cnt_nz ++;
            }
            p++;
        }
        for(int i=cnt_nz; i<nums.length; i++){
            nums[i] = 0;
        }
    }
}
