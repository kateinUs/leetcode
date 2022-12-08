package jiuzhang;

import java.util.Arrays;

/**
 * --- 同向双指针的题 ---
 * ---- 1 ---------------
 * Leetcode 209. Minimum Size Subarray Sum
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *
 * ---- 2 ------------------
 * 两数之差题 2sum变种 (数组已排序)
 * Input: [2, 7, 15, 24], target=5
 * Output: [2, 7]
 * Explanation: 7-2 =5
 *
 * ---- 3 ------------------
 * 全零子串问题
 * 求出字符串中全零子串的个数
 * Input: 001000
 * Output: 9
 * Explanation: 5个0,3个00，1个000
 *
 * ---- 4 ------------------
 *  移除重复数据 in-place，返回unique number个数，数组unsorted
 *  Input: [1, 0, 0, 1, 2, 4]
 *  Output: 4, 原数组变成[0, 1, 2, 4,| 2, 4] 最后两位不重要
 *
 * @author huimin
 * @create 2022-12-06 0:32
 */
public class Same_Direction_2_Pointer {
    int[] twoDifference(int[] nums, int target){
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        int n = nums.length;
        target = Math.abs(target);
        int j=1;
        for(int i=0; i<n; i++){
            j = Math.max(j, i+1);
            while(j<n &&  nums[j] <nums[i]+target){
                j++;
            }
            if(j>=n) break;
            if(nums[j] == nums[i]+target) {
                System.out.println("[" +i + ", "+j+"]: " + nums[i]+" "+nums[j]);
//                return new int[]{i, j};
            }
        }

        return new int[]{-1, -1};
    }

    int numOfSubstringWithAllZeros(String s){
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        int j=0;
        int res =0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '1') continue;
            j = Math.max(j, i);
            while(j<n && s.charAt(j) == '0'){
                j++;
            }
            res+=(j-i);
        }

        return res;
    }

    int removeDuplicate(int[] arr){
        Arrays.sort(arr);
        // [0, 1, 1, 2, 2, 2, 4]
        int j=0; // j代表unique number的最后一位的位置
        for(int i=1; i<arr.length; i++){
            if(arr[i] != arr[j]) {
                arr[++j] = arr[i];
            }
        }
        return j+1;
    }

    public static void main(String[] args) {
        Same_Direction_2_Pointer test = new Same_Direction_2_Pointer();
        int[] nums = {2, 7, 9, 15, 22, 24};
        // ------------ TEST twoDifference ---------------
//        int[] res = test.twoDifference(nums, 5);
//        int[] res2 = test.twoDifference(nums, 7);
//        System.out.println("[" +res[0] + ", "+res[1]+"]");
//        System.out.println("[" +res2[0] + ", "+res2[1]+"]");

        // ----- TEST numOfSubstringWithAllZeros ---------
//        System.out.println(test.numOfSubstringWithAllZeros("001000"));
//        System.out.println(test.numOfSubstringWithAllZeros("11000100111000"));
//        System.out.println(test.numOfSubstringWithAllZeros(""));

        // ------------ TEST removeDuplicate -------------
//        int[] arr = {1, 2, 2, 0, 1, 2, 4};
//        int num = test.removeDuplicate(arr);
//        System.out.println("Num of unique: "+num);
//        for(int i=0; i<num; i++){
//            System.out.print(arr[i]+ " ");
//        }
//        System.out.println();

    }
}
