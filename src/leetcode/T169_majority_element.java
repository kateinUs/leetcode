package leetcode;

/**
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 * Method: Boyer-Moore Voting Algorithm
 * Time complexity: O(N)
 * Space O(1)
 * @author huimin
 * @create 2022-01-28 23:38
 */
public class T169_majority_element {
    // Boyer-Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for(int i: nums){
            if(count <= 0)
                candidate = i;

            count += (candidate == i)? 1: -1;
        }
        return candidate;
    }
}
