package leetcode;

/**
 * @author huimin
 * @create 2022-03-09 21:01
 */
class SparseVector {

    int[] vector;
    SparseVector(int[] nums) {
        vector = new int[nums.length];
        System.arraycopy(nums, 0, vector, 0, nums.length);
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int[] vec2 = vec.vector;
        int dotProd = 0;
        for(int i=0; i<vector.length; i++){
            dotProd += vector[i] * vec2[i];
        }
        return dotProd;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 0, 0, 2, 3};
        int[] nums2 = {0, 3, 0, 4,0 };
        SparseVector sv1 = new SparseVector(nums1);
        SparseVector sv2 = new SparseVector(nums2);

        int res = sv1.dotProduct(sv2);
        System.out.println(res);
    }
}
