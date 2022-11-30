package leetcode;

/**
 * 思路：
 * 1. find each number could contribute to how many subarrays as MIN, how many subarray as MAX.
 * 2. the result will be sum of all number * (count of subarray that has it as MAX) - sum of all number * (count of subarray that has it as MIN).
 * 3. Use two monotonic stacks for those two sub problem.
 * @author huimin
 * @create 2022-09-21 17:15
 */
public class T2104_Sum_of_subarray_ranges {
}
