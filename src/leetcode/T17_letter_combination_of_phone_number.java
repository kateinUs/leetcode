package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author huimin
 * @create 2021-09-15 11:11
 */
public class T17_letter_combination_of_phone_number {
    private List<String> conbinations = new ArrayList<>();
    private Map<Character, String> letters = Map.of('2',"abc",'3', "def",
            '4', "ghi", '5', "jkl", '6',"mno", '7',"pqrs",
            '8', "tuv", '9', "wxyz");
    private String phoneDigits;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return conbinations;
        phoneDigits = digits;
        backtrack(0, new StringBuilder());

        return conbinations;
    }
    private void backtrack(int index, StringBuilder path){
        if(path.length() == phoneDigits.length()){
            conbinations.add(path.toString());
            return ;// backtrack
        }
        // e.g. phoneDigits.charAt(index) = 2 ->
        //      possibleLetters = abc
        String possibleLetters = letters.get(phoneDigits.charAt(index));
        char[] letters = possibleLetters.toCharArray();
        for (char letter : letters) {
            path.append(letter); // path: "a" ; "b" ; "c"
            backtrack(index+1, path);
            path.deleteCharAt(path.length() - 1); // 删去遍历过的字符
        }
    }
}
