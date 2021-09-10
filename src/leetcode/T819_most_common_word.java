package leetcode;

import javafx.concurrent.WorkerStateEvent;

import java.util.*;

/**
 * @author huimin
 * @create 2021-09-09 23:10
 */
public class T819_most_common_word {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 1. replace the puctuation with spaces and put all letters in lowercase
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        // 2. split the string into words
        String[] words = normalizedStr.split("\\s+"); // TODO: 研究一下正则
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> bannedWords = new HashSet();
        for (String word : banned)
            bannedWords.add(word);

        // 3. count the appearance of each words and excluding the banned words
        for(int i=0; i< words.length; ++i){
            if(!bannedWords.contains(words[i]))
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        // 4. return the word with the highest frequency
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        // int largest = 0;
        // String ret = null;
        // for (Map.Entry<String, Integer> entry: map.entrySet()) {
        //     if(entry.getValue() > largest){
        //         largest = entry.getValue();
        //         ret = entry.getKey();
        //     }
        // }
        // return ret;
    }

}
