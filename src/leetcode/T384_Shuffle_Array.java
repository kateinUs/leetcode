package leetcode;

import java.util.Random;

/**
 * @author huimin
 * @create 2022-02-09 1:01
 */
public class T384_Shuffle_Array {
    int[] array;
    public T384_Shuffle_Array(int[] nums) {
        this.array = new int[nums.length];
        System.arraycopy(nums, 0, this.array, 0, nums.length);
    }

    public int[] reset() {
        return this.array;
    }

    public int[] shuffle() {
        int[] shufArr = new int[array.length];
        System.arraycopy(array, 0, shufArr, 0, array.length);
        Random rn = new Random();
        for(int i=0; i<shufArr.length; i++){
            int pos = rn.nextInt(shufArr.length);
            swap(shufArr, i, pos);
        }
        return shufArr;
    }
    private void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
