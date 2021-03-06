package leetcode;

/**
 * @author huimin
 * @create 2022-01-19 18:05
 */
public class T14_longest_common_prefix {
    // Method 1: Horizental Scanning
    public String longestCommonPrefix1(String[] strs) {

        String prefix = strs[0];
        for(int i=1; i<strs.length; i++){
            for(int j=prefix.length(); j>=0; j--){
                prefix = prefix.substring(0, j);
                if(strs[i].startsWith(prefix)){
                   break;
                }
            }
        }
        return prefix;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }


    // Method 2: Divide and Conquer
    // like merge sort
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }
}
