package leetcode;

import java.awt.print.Printable;
import java.security.Permission;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author huimin
 * @create 2022-01-19 20:57
 */
public class T46_permutations {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        permute( nums, 0);
        return list;
    }

    public void permute(int[] nums, int k){
        if(k == nums.length){
            List<Integer> cur = new ArrayList<Integer>();
            for(int i: nums)
                cur.add(i);
            list.add(cur);
        }
        for(int i=k; i<nums.length; i++){
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
            permute(nums, k+1);
            temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3};
        T46_permutations perm = new T46_permutations();

        List<List<Integer>> res = perm.permute(arr);
        for(int i=0; i<res.size(); i++){
            for(int j=0; j<res.get(i).size(); j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println();
        }

    }
}
