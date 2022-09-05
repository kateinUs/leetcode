package leetcode;

import java.util.*;

/**
 *
 *
 * @author huimin
 * @create 2022-04-09 22:33
 */
public class T6037 {

    //Input: num = 65875
    //Output: 87655
    public static int largestInteger(int num) {

        int[] arr = new int[String.valueOf(num).length()];
        for(int i=arr.length-1; i>=0; i--){
            arr[i] = num % 10;
            num/=10;
        }
        ArrayList<Integer> evens = new ArrayList<>();
        ArrayList<Integer> odds = new ArrayList<>();
        boolean[] ifEven = new boolean[arr.length];
        for(int i=0; i<arr.length; i++){
            if(arr[i] %2 == 0){
                ifEven[i] =true;
                evens.add(arr[i]);
            }else{
                ifEven[i] = false;
                odds.add(arr[i]);
            }
        }
        Collections.sort(evens, Collections.reverseOrder());
        Collections.sort(odds, Collections.reverseOrder());

        String ans = "";
        for(int i=0; i<arr.length; i++){
            if(ifEven[i]){
                ans+=evens.remove(0);
            }else
                ans+=odds.remove(0);
        }

        return Integer.parseInt(ans);
    }

    public static void main(String[] args) {
//        String res =minimizeResult("247+38");
//        System.out.println(res);
        int[] nums = {92,36,15,84,57,60,72,86,70,43,16};
        int res = maximumProduct(nums, 62);
//        System.out.println(res);


        int[] test= {101, 99, 86, 17};
        int mod= 68;
        // 1. mod every time
        int res1 = 1;
        for(int i:test){
            res1 *= (i % mod);
        }
        System.out.println(res1 % mod);
        // 2. mod at last
        int res2 = 1;
        for(int i:test){
            res2 *= i;
        }
        System.out.println(res2 % mod);

    }

    // Input:"247+38"
    public static String minimizeResult(String expression) {
        String[] splits = expression.split("\\+");
        int l = splits[0].length();
        int r = splits[1].length();

        int min = Integer.MAX_VALUE;
        int minCutL = 0;
        int minCutR = r;
        for(int i=0; i<l; i++){
            for(int j=0; j<r; j++){
                int lcut1;
                if(i == 0)
                    lcut1 = 1;
                else
                    lcut1 = Integer.parseInt(splits[0].substring(0,i));

                int lcut2 = Integer.parseInt(splits[0].substring(i,l));
                int rcut1 = Integer.parseInt(splits[1].substring(0,j+1));
                int rcut2;
                if(j == r-1)
                    rcut2 = 1;
                else rcut2 = Integer.parseInt(splits[1].substring(j+1,r));

                int ans = lcut1 *(lcut2+rcut1)*rcut2;
                if(ans <min){
                    min = ans;
                    minCutL = i;
                    minCutR = j;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<l; i++){
            if(i == minCutL)
                ans.append('(');
            ans.append(splits[0].charAt(i));
        }
        ans.append("+");
        for(int j=0; j<r; j++){

            ans.append(splits[1].charAt(j));
            if(j == minCutR)
                ans.append(')');
        }

        return ans.toString();
    }


    public static int maximumProduct(int[] nums, int k) {

        int mod = 1000000007;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer(num);
        }
        while (k > 0) {
            k--;
            pq.offer(pq.poll() + 1);
        }
        long ans = 1;
        while (!pq.isEmpty()) {
            ans = (ans * pq.poll()) % mod;
        }

        return (int) ans;
//        for(int i=0; i<k; i++){
//            int min =nums[0];
//            int minIdx = 0;
//            for(int j=1; j<nums.length; j++){
//                if(nums[j] < min){
//                    min = nums[j];
//                    minIdx = j;
//                }
//            }
//            nums[minIdx] +=1;
//        }
//        long prod = 1;
//        for(int i:nums){
//            prod *= i;
//        }
//        long ans = prod % (long) (Math.pow(10, 9)+7);
//        return (int)ans;
    }

    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {


        
        return 0;
    }
}
