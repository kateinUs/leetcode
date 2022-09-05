package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huimin
 * @create 2022-06-17 16:00
 */
public class T923_3Sum_with_multiplicity {
    public int threeSumMulti(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int count = 0;
        int countNum1 = 1;
        int countNum2 = 1;
        int countNum3 = 1;
        int flag = 0;
        for(int i=0; i<arr.length; i++){
            //这里if判断的作用是确保这次循环数i的值和上一次循环数的值是不同的，避免重复计算

            if(i > 0 && arr[i] == arr[i-1]){
                countNum1++;
                continue;
            }
            count += flag * countNum1*countNum2*countNum3;
            countNum1 = 1; countNum2 = 1; countNum3 = 1; flag = 0;
            int low = i+1, high = arr.length-1;
            while(low < high){
                int sum = arr[i] + arr[low] + arr[high];
                if(sum == target){
                    flag = 1;
                    //将结果添加入list中，并将low减一，high加一，检查下一组数
                    res.add(Arrays.asList(arr[i], arr[low++], arr[high--]));
                    //这个while是确保不重复count一样的triple（三元组）
                    while(low<high && arr[low] == arr[low-1]){
                        low++;
                        countNum2++;
                    }
                    while(low<high && arr[high] == arr[high-1]){
                        high--;
                        countNum3++;
                    }
//                    count += countNum1*countNum2*countNum3;
//                    countNum2 = 1; countNum3 = 1;
                }
                else if(sum < target)
                    low++;
                else
                    high--;
            }
        }
        return count;
    }   
}
