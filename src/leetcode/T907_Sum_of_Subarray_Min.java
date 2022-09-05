package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author huimin
 * @create 2022-08-13 22:27
 */
public class T907_Sum_of_Subarray_Min {
    // Method 1: monotonic stack, using 2 array to store next smaller element
    // and previous small or equal element
    // BUT EASY TO UNDERSTAND
    public int sumSubarrayMins(int[] arr) {
        int[] smallerIdx = new int[arr.length];
        int[] largerIdx = new int[arr.length];
        Arrays.fill(smallerIdx, -1);
        Arrays.fill(largerIdx, arr.length);
        Stack<Integer> stack = new Stack<>();
        for(int i=0 ;i<arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()]> arr[i]){
                int j = stack.pop();
                largerIdx[j] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for(int i=arr.length -1;i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                int j = stack.pop();
                smallerIdx[j] = i;
            }
            stack.push(i);
        }
        long res = 0l;
        long mod = 1000000007;
        for(int i=0 ;i<arr.length; i++){
            res  = (res + (long)arr[i] * (i-largerIdx[i])*(smallerIdx[i]-i))%mod;
        }
        return (int)res;
    }

    // Improvement on Method 1
    // Only only 1 array and one loop
    public int sumSubarrayMins2(int[] arr) {
        long res = 0l;
        Stack<Integer> stack = new Stack<>();
        int k  = 0;
        int j = 0;
        for(int i = 0; i <= arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > (i == arr.length ? Integer.MIN_VALUE : arr[i])){
                j = stack.pop();
                k = stack.isEmpty() ? -1: stack.peek();

                res = (res +(i-j)*(j-k) * (long)arr[j])%1000000007;
            }
            stack.push(i);
        }

        return (int)res;
    }
}
