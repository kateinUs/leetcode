package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author huimin
 * @create 2021-09-03 2:25
 */
public class T937_reorder_data_in_log_file {
    public static void main(String[] args) {

    }

    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String log1, String log2) {
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                // both log are letter log
                if(!isDigit1 && !isDigit2){
                    int cmp = split1[1].compareTo(split2[1]);
                    if(cmp != 0){
                        return cmp;
                    }
                    return split1[0].compareTo(split2[0]);
                }

                // log1 is letter, log2 is digit, digit comes later, so letter is less than digit, here return -1
                if(!isDigit1 && isDigit2)
                    return -1;
                // log1 is digit, log2 is letter, digit larger than letter, so return 1
                else if(isDigit1 && !isDigit2)
                    return 1;
                // both are digit
                else
                    return 0;
            }
        };
        Arrays.sort(logs, comparator);
        return logs;
    }
}
