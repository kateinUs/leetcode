package leetcode;

/**
 * @author huimin
 * @create 2022-02-07 15:53
 */
public class T408_valid_word_abbr {
    public boolean validWordAbbreviation(String word, String abbr) {
        // k: loop index for word
        // i: loop index for abbr
        int index=0;
        int k =0, i=0;
        while(i<abbr.length()){
            char ch = abbr.charAt(i);
            if(Character.isDigit(ch)){
                if(index == 0 && ch == '0'){
                    return false;
                }
                index = index*10 + (ch-'0');
            } else{
                if(index !=0){
                    k+= index; // skip the index number of chars
                    index = 0;

                }
                // check individual char
                if(k >= word.length() || word.charAt(k) != abbr.charAt(i))
                    return false;
                k++;
            }
            i++;
        }

        return index == word.length() - k;
    }
}
