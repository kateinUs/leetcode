package oa;

/**
 * @author huimin
 * @create 2021-09-30 13:52
 */
public class BinaryPalindrome {
    public static void main(String[] args) {
        boolean res = isBinaryPalindrome(0B1001);
        System.out.println(res);
    }

    public static boolean isBinaryPalindrome(int num) {
        int reverse = 0;
        int temp = num;
        while (temp != 0) {
            reverse = (reverse << 1) | (temp % 2);
            temp = temp >> 1;
        }
        if (reverse == num) {
            return true;
        } else {
            return false;
        }
    }
}
