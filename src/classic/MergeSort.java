package classic;

/**
 * @author huimin
 * @create 2021-07-30 17:04
 */
public class MergeSort {

    public static int[] merge(int[] nums1, int m, int[] nums2, int n){
        int[] res = new int[m+n];
        int p1 = 0;
        int p2 = 0;
        int p=0;
        while(p1<m && p2<n){
            res[p++] = nums1[p1] < nums2[p2] ? nums1[p1++]: nums2[p2++];
        }
        if(p1<m){
            System.arraycopy(nums1, p1, res, p1+p2, m+n-p1-p2);
        }
        if(p2<n){
            System.arraycopy(nums2, p2, res, p1+p2, m+n-p1-p2);
        }
        return res;
    }
}
