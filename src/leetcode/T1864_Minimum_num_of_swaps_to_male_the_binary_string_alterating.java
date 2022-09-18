package leetcode;

/**
 * @author huimin
 * @create 2022-09-06 14:57
 */
public class T1864_Minimum_num_of_swaps_to_male_the_binary_string_alterating {
    // method 1: waste memory
    public int minSwaps(String s) {
        // count the number of 0's and 1's, if their difference > 1, return false
        char[] arr = s.toCharArray();
        int cnt0 = 0, cnt1 = 0;
        for (char c : arr) {
            if (c == '0') cnt0++;
            else if (c == '1') cnt1++;
        }
        if (Math.abs(cnt0 - cnt1) > 1) return -1;
        // 若果两个count数量相等，那么一定是1010..10 or 0101...01
        // 只需要计算那种alternating和当前s距离最近
        // 如果其中一个大一，那么大的那个打头并结尾
        if (cnt0 == cnt1) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < cnt0; i++) {
                sb.append("01");
                sb2.append("10");
            }
            int diff1 = 0, diff2 = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != sb.charAt(i)) diff1++;
                if (arr[i] != sb2.charAt(i)) diff2++;
            }
            return Math.min(diff1, diff2) / 2;
        } else {
            StringBuilder sb = new StringBuilder();
            if ((cnt0 > cnt1)) sb.append("0");
            else sb.append("1");
            for (int i = 0; i < Math.min(cnt0, cnt1); i++) {
                if (cnt0 > cnt1) sb.append("10");
                else sb.append("01");
            }
            int diff = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != sb.charAt(i)) diff++;
            }
            return diff / 2;
        }
    }

    // Method2:
    public int minSwaps2(String s) {
        int one=0,zero=0;
        for(char ch : s.toCharArray()){
            if(ch == '1')   one++;
            else zero++;
        }
        if(Math.abs(one-zero) > 1)
            return -1;
        //if no of 1 is more then, all ones should be placed at even positions,
        //if it's not present at even position then we need a swap. vice-versa for 0
        if(one > zero)
            return checkSwaps(s.toCharArray(),'1');
        else if(zero > one)
            return checkSwaps(s.toCharArray(),'0');
            //if both are having same count then either can be placed at even/odd position
            //so take minimum of both possibilities
        else
            return Math.min(checkSwaps(s.toCharArray(),'1'),checkSwaps(s.toCharArray(),'0'));
    }

    //checks wrong position when symbol is not present at even positon
    //(this symbol is present more)
    public int checkSwaps(char[] s, char symbol){
        int swaps=0;
        for(int i=0;i<s.length;i++){
            // even position不应该等于传入的symbol，所以swap数量加一
            if(s[i] == symbol && i%2 != 0)
                swaps++;
        }
        return swaps;
    }

    public static void main(String[] args) {
        String s11 = "111000";
        String s2 = "010";
        String s3 = "1110";
    }
}
