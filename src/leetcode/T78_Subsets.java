package leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * By Backtracking
 * @author huimin
 * @create 2022-07-18 10:28
 */
public class T78_Subsets {

    /**
     * My method backtracking
     */
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        func(0, new ArrayList<Integer>(), nums);
        return res;
    }
    public void func(int p, List<Integer> curLst, int[] nums){
        if(p == nums.length){
            res.add(new ArrayList<>(curLst));
            return;
        }
        // not include curr num
        func(p+1, curLst, nums);
        // include curr num
        curLst.add(nums[p]);
        func(p+1, curLst, nums);
        curLst.remove(curLst.size()-1);
    }

    /**
     * Leetcode答案 Backtracking
     */
    List<List<Integer>> output = new ArrayList();
    int n, k;

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // if the combination is done
        if (curr.size() == k) {
            output.add(new ArrayList(curr));
            return;
        }
        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, curr, nums);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }
}
