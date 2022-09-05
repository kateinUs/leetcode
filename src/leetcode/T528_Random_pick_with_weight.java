package leetcode;

import java.util.Random;

/**
 * @author huimin
 * @create 2022-03-09 1:20
 */
public class T528_Random_pick_with_weight {
    int[] weights;
    int sum = 0;
    Random rand = new Random();
    public T528_Random_pick_with_weight(int[] w) {
        weights = new int[w.length];
        System.arraycopy(w, 0, weights, 0, w.length);
        for(int i: w){
            sum += i;
        }
    }

    public int pickIndex() {
        int randInx = rand.nextInt(sum);

        int i=0;
        while(randInx+1>0){
            randInx -= weights[i];
            i++;
        }
        return i-1;
    }
}
