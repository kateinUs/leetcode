package leetcode;

import javax.swing.text.StyledEditorKit;
import java.util.*;

/**
 * @author huimin
 * @create 2021-05-18 0:32
 */
public class T15_3sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length && nums[i]<=0; i++){
            //这里if判断的作用是确保这次循环数i的值和上一次循环数的值是不同的，避免重复计算
            if(i == 0 || nums[i-1] != nums[i]){
                int low = i+1, high = nums.length-1;
                while(low < high){
                    int sum = nums[i] + nums[low] + nums[high];
                    if(sum == 0){

                        //将结果添加入list中，并将low减一，high加一，检查下一组数
                        res.add(Arrays.asList(nums[i], nums[low++], nums[high--]));
                        //这个while是确保不重复count一样的triple（三元组）
                        while(low<high && nums[low] == nums[low-1])
                            low++;
                    }
                    else if(sum < 0)
                        low++;
                    else
                        high--;
                }
            }
        }
        return res;
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
