package leetcode;

import javax.swing.text.StyledEditorKit;
import java.util.*;

/**
 * @author huimin
 * @create 2021-05-18 0:32
 */
public class T15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        // method 1: 5 choose 3
        // loop n(n-1)(n-2)
        ArrayList<List<Integer>> conb = new ArrayList<>();
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                for(int k=j+1; k<len; k++){
                    if((nums[i] + nums[j] + nums[k]) == 0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        conb.add(temp);
                    }
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String str = "abcaabbcc";
//        int len = str.length();
        int firstApprOfa = str.indexOf("a");
        System.out.println(firstApprOfa);
        int[] nums = {1, -1, 2, -2, 0, 0};
        int len = nums.length;
        int target = 0;
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if(nums[0] + nums[1] + nums[2] + nums[3] > target)
            return ;
        if(nums[len-1] + nums[len-2] + nums[len-3] + nums[len-4] < target)
            return ;
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                for(int k=j+1; k<len; k++){
                    for(int p=k+1; p<len; p++){
                        if(nums[i] + nums[j] + nums[k] + nums[p] == target){
                            List<Integer> quadruplet = new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k],
                                    nums[p]));
                            result.add(quadruplet);
                        }
                    }
                }
            }
        }
    }

}
