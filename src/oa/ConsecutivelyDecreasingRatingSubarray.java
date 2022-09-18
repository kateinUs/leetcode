package oa;

import java.util.Stack;

/**
 * Amazon oa
 * There is a new product launched and its customer ratings are being recorded in an array. The ratings are being monitored and analyzed if there is any decrease in the ratings.
 * Find the number of periods in which the rating is consecutively decreasing.
 * Example - Ratings = [4,3,5,4,3]
 * Periods (in other words sub arrays in which ratings are decreasing):
 * One day periods = [4],[3],[5],[4],[3] (count of subarrays is 5)
 * Two day periods = [4,3],[5,4],[4,3] (count of subarrays is 3)
 * 3 day periods = [5,4,3] (count of subarrays is 1)
 * So, the output for this example will be 9 (5 + 3 + 1)
 *
 * 用递减栈
 * 当一个大于当前栈顶的元素出现，一直pop掉栈顶，知道符合要求
 * 计算pop出的数量，然后计算 n*(n+1)/2
 *
 * @author huimin
 * @create 2022-09-12 16:45
 */
public class ConsecutivelyDecreasingRatingSubarray {

    static int findNumDecreasing(int[] arr){

        Stack<Integer> st = new Stack<>();
        int ans = 0;
        int numPop;
        for(int i=0; i<arr.length; i++){
            numPop = 0;
            while(!st.isEmpty() && st.peek() <= arr[i]){
                numPop++;
                st.pop();
            }
            ans += numPop*(numPop+1)/2;
            st.push(arr[i]);
        }
        numPop = st.size();
        ans += numPop*(numPop+1)/2;
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3};
        System.out.println(findNumDecreasing(arr));
    }
}
