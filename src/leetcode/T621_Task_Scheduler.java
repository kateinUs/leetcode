package leetcode;

/**
 * @author huimin
 * @create 2022-02-18 16:28
 */
public class T621_Task_Scheduler {
    public int leastInterval(char[] tasks, int n) {
        if(n ==0)
            return tasks.length;
        // count the frequency for each letter
        int[] freq = new int[26];
        for(int t: tasks){
            freq[t - 'A'] ++;
        }
        // max frequency
        int max_freq = 0;
        for(int f: freq){
            max_freq = Math.max(max_freq, f);
        }
        // count the most frequent tasks
        int max_count = 0;
        for(int f: freq){
            if(f == max_freq)
                max_count++;
        }
        // or merge 2 loops into 1
        /*for(int i=0;i<26;i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                maxFreqCount = 1;
            } else if (freq[i] == maxFreq) {
                maxFreqCount++;
            }
        }*/

        return Math.max(tasks.length, (max_freq-1) * (n+1) + max_count);
    }
}
