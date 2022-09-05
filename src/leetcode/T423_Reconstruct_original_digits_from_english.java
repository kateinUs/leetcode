package leetcode;

/**
 * @author huimin
 * @create 2022-03-08 15:57
 */
public class T423_Reconstruct_original_digits_from_english {
    public String originalDigits(String s) {
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            count[ch-'a'] += 1;
        }
        // record the number of each letter form 0-9
        int[] out = new int[10];
        // first count even number: (because they have unique characher)
        // 0(z), 2(w), 4(u), 6(x), 8(g)
        out[0] = count['z'-'a'];
        out[2] = count['w'-'a'];
        out[4] = count['u'-'a'];
        out[6] = count['x'-'a'];
        out[8] = count['g'-'a'];

        // Letter "h" is present only in "three" and "eight".
        // Letter "f" is present only in "five" and "four".
        // Letter "s" is present only in "seven" and "six".
        //then count 3, 5, 7
        out[3] = count['h'-'a'] - out[8];
        out[5] = count['f'-'a'] - out[4];
        out[7] = count['s'-'a'] - out[6];
        // letter "i" is present in "nine", "five", "six", and "eight"
        out[9] = count['i'-'a'] - out[5] - out[6] - out[8];
        // letter "n" is present in "one", "nine", and "seven"
        out[1] = count['n'-'a'] - out[7] - 2 * out[9];

        StringBuilder res = new StringBuilder();
        for(int i=0; i<10; i++){
            for(int j=0; j<out[i]; j++){
                res.append(i);
            }
        }
        return res.toString();

    }
}
