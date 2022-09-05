package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author huimin
 * @create 2022-08-31 0:20
 */
class RLEIterator {
    LinkedList<int[]> pairs;
    public RLEIterator(int[] encoding) {
        pairs = new LinkedList<>();
        for(int i=0; i<encoding.length/2; i++){
            int cnt = encoding[i];
            int num = encoding[i*2+1];
            if(cnt > 0)
                pairs.add(new int[]{cnt, num});
        }
    }

    public int next(int n) {
        while(n>=0){
            int[] cur = pairs.getFirst();
            if(n > cur[0]){
                n -= cur[0];
                pairs.removeFirst();
            }
            else if(n < cur[0]){
                pairs.getFirst()[0] -= n;
                return cur[1];
            }else{
                pairs.removeFirst();
                return cur[1];
            }
        }
        Character.isDigit('0');
        Character.isLetter('o');

        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */
