package leetcode;

/**
 * @author huimin
 * @create 2021-09-09 5:22
 */
public class T238_product_expect_itself {
    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int[] L = new int[len];
        int[] R = new int[len];
        int[] res = new int[len];

        // calculate the product of element to the left
        L[0] = 1;
        for(int i=1; i<len; i++){
            L[i] = L[i-1] * nums[i-1];
        }

        // calculate the product of element to the right
        R[len-1] =1;
        for(int i=len-2; i>=0; i--){
            R[i] = R[i+1] * nums[i+1];
        }
        // calculate product expect itself by time L[i] and R[i]
        for(int i=0; i<len; i++){
            res[i] = L[i] * R[i];
        }

        return res;
    }

    // which only need 2 traversal, and 1 array space store the answer
    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];

        // calculate the product of element to the left
        ans[0] = 1;
        for(int i=1; i<len; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        // calculate the product of element to the right
        int R = 1;
        for(int i=len-1; i>=0; i--){
            ans[i] = ans[i] * R;
            R *= nums[i];
        }

        return ans;
    }
}
