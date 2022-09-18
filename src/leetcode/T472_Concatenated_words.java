package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author huimin
 * @create 2022-09-07 23:48
 */
public class T472_Concatenated_words {
    Set<String> set = new HashSet<>();
    // backtracking
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        for(String word: words) set.add(word);
        ArrayList<String> res = new ArrayList<>();
        for(String word: words){
            if(canConcat(word, 0, 0))
                res.add(word);
        }
        return res;
    }

    boolean canConcat(String word, int index, int num){
        if(index == word.length() && num > 1) return true;
        else if(index == word.length()) return false;
        for(int i=index+1; i<=word.length(); i++){
            if(set.contains(word.substring(index, i))){
                if(canConcat(word, i, num+1)) return true;
            }
        }
        return false;
    }
}
