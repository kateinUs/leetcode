package leetcode;

import java.math.BigInteger;
import java.util.*;

/**
 * @author huimin
 * @create 2022-07-16 15:40
 */
public class T55_Jump_Game {
    // Method 1: Greedy
    public boolean canJump(int[] nums) {
        int farReach = 0;
        for(int i=0; i<nums.length; i++){
            if(i<=farReach){
                farReach = Math.max(farReach, nums[i]+i);
            }else{
                return false;
            }
        }
        return true;
    }

    // Method 2: Backtracking


    // Method 3: Dynamic programming

    public int maximumSum(int[] nums) {
        // key is sum, value is the position
        int max = -1;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int iSum = findDigitSum(nums[i]);
            if(map.containsKey(iSum)){
                List<Integer> oldLst = map.get(iSum);
                for(int pos: oldLst){
                    int nSum =  nums[pos] + nums[i];
                    max = Math.max(max, nSum);
                }
                oldLst.add(i);
            }else{
                List<Integer> lst = new ArrayList<>();
                lst.add(i);
                map.put(iSum, lst);
            }

        }
        return max;
    }
    private static int findDigitSum(int num){
        int sum = 0;
        while(num >=10){
            sum += num % 10;
            num /= 10;
        }
        sum += num;
        return sum;
    }

    public static void main(String[] args) {
        int t1 = findDigitSum(10);
        int t2 = findDigitSum(12);
        int t3 = findDigitSum(19);
        int t4 = findDigitSum(14);
        System.out.println(t1+ " " + t2 + " "+ t3+ " " + t4);
        BigInteger i = new BigInteger("12131");
    }

}
