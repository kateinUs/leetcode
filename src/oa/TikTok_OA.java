package oa;

/**
 * @author huimin
 * @create 2021-10-02 19:20
 */
public class TikTok_OA {
    /** Q1. Find Before Matrix
     *      The algorithm below is used to convert the "below matrix" to "after matrix".
     *      Find the "before matrix" given the "after matrix".
     *  Example:
     *      before = [[2, 3], [5, 7]]
     *      after =  [[2, 5], [7, 17]]
     *  Explanation:
     *      after[0][0] = before[0][0] = 2
     *      after[0][1] = before[0][0] + before[0][1] = 2 + 3 = 5
     *      after[1][0] = before[0][0] + before[1][0] = 2 + 5 = 7
     *      after[1][1] = before[0][0] + before[0][1] + before[1][0] + before[1][1] = 2 + 3 + 5 + 7 =  17
     *
     *  Link: https://stackoverflow.com/questions/65510354/matrix-summation-challenge
     * @param after
     * @return
     */
    public static int[][] getBeforeMatrix(int [][] after){

        int[][] before = new int[after.length][after[0].length];
        for(int i=0; i<after.length; i++){
            for(int j=0; j<after[0].length; j++){
                int up = i <=0 ? 0: after[i-1][j];
                int left = j <=0 ? 0: after[i][j-1];
                int up_left = j <=0 || i<= 0? 0: after[i-1][j-1];
                before[i][j] = after[i][j] - up - left + up_left;

            }
        }
        return before;
    }

    public static void main(String[] args) {
        // test Q1
        int[][] test = new int[][]{{2, 5},{7, 17}};
        int[][] res = getBeforeMatrix(test);
        for(int i=0; i<res.length; i++){
            for(int j=0; j<res[0].length; j++){
                System.out.print(res[i][j] + " ");
            }
        }
    }

    /** Q2: Count Binary Substrings
     *      Give a string s, count the number of non-empty (contiguous) substrings that have the same number of
     *      0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively. Substrings
     *      that occur multiple times are counted the number of times they occur.
     *
     * Example:
     *      Input: "00110011"
     *      Output: 6
     * Explanation:
     *      There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100",
     *      "10", "0011", and "01".
     * Notice:
     *      Some of these substrings repeat and are counted the number of times they occur. Also, "00110011" is not
     *      a valid substring because all the 0's (and 1's) are not grouped together.
     *
     * Link: https://chih-hsien.gitbooks.io/mysolution/content/count-binary-substrings.html
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s){
        int len = s.length();
        int count = 0;
        int zero = 0;
        int one = 0;
        int zeroCnt = 0;
        int oneCnt = 0;
        while (true) {
            while (zero < len && s.charAt(zero) == '0') {
                zero++;
            }
            zeroCnt = zero - one;
            count += Math.min(zeroCnt, oneCnt);
            if (zero == len) {
                break;
            }
            oneCnt = 0;
            one = zero;
            while (one < len && s.charAt(one) == '1') {
                one++;
            }
            oneCnt = one - zero;
            count += Math.min(zeroCnt, oneCnt);
            if (one == len) {
                break;
            }
            zero = one;
            zeroCnt = 0;
        }
        return count;
    }
}
