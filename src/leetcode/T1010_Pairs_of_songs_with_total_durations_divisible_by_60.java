package leetcode;

import java.util.HashMap;

/**
 * @author huimin
 * @create 2022-06-24 16:17
 */
public class T1010_Pairs_of_songs_with_total_durations_divisible_by_60 {
    public static int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0; i<time.length; i++){
            int curr = time[i]%60;
            if(curr != 0 && map.containsKey(60-curr)){
                count += map.get(60-curr);
            } else if(curr == 0)
                count += map.getOrDefault(curr, 0);
            map.put(curr, map.getOrDefault(curr, 0)+1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] times= {60, 60, 60};
        int res = numPairsDivisibleBy60(times);
        System.out.println(res);
    }

}
