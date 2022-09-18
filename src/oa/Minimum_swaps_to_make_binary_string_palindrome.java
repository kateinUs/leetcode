package oa;

/**
 * 第一题 给一个binary string 问最少swap char 几次可以形成回文。
 * 这里要注意test cases里有不能形成回文的binary string 需要return -1 这个可以通过数1和0的个数来判断 如果1和0的个数都是奇数的话 就不行
 * 对比两边的digit,不同的话count加一，如果有偶数个count， 那只需要swap count/2次， 奇数 (count+1)/2
 *  因为： 10...10 （这个case有两个diff,但是只需要swap1次)
 *        101 1 010 如果有奇数个diff，且string长度是奇数，那么最后一对可以和中间的digit交换
 *
 * https://devsolus.com/2022/04/26/minimum-number-of-swaps-required-to-make-a-binary-string-palindrome/#:~:text=Minimum%20number%20of%20swaps%20required%20to%20make%20a%20binary%20string%20palindrome,-Advertisements&text=correct%20answer%20is%202.
 * @author huimin
 * @create 2022-09-06 13:37
 */
public class Minimum_swaps_to_make_binary_string_palindrome {

    public static int getNumOfSwaps(String s){
        // count num of 1's and 0's
        int count0 = 0;
        int count1 = 0;
        char[] arr = s.toCharArray();
        for(char c: arr){
            if (c == '0')  count0++;
            else if(c == '1')  count1++;
        }
        //两个都是奇数 gg
        if(count0%2 != 0 && count1%2 != 0) return -1;
        int countOfDiff = 0;
        int len = arr.length;
        for(int i=0; i<len/2; i++){
            if(arr[i] != arr[len-1-i]){
                countOfDiff++;
            }
        }
        if(countOfDiff%2 == 1){
            if(len%2 == 0) return -1;
            else return countOfDiff/2+1;
        }else
            return countOfDiff/2;
//        return -1;
    }

    public static void main(String[] args) {
        String test1 = "101010";
        String test2 = "1110001";
        //   1 swap to  1100011
        String test3 = "1110010101001";
        // 2 swaps      1100011100011
        System.out.println(getNumOfSwaps(test1));
        System.out.println(getNumOfSwaps(test2));
        System.out.println(getNumOfSwaps(test3));
    }
}
