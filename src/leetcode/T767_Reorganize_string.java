package leetcode;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * HashMap and PriorityQueue(Max Heap)
 * @author huimin
 * @create 2022-07-20 11:26
 */
class Pair {
    int count ;
    char val ;

    public Pair(char val , int count){
        this.count = count ;
        this.val = val ;
    }
}
public class T767_Reorganize_string {
    public String reorganizeString(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> (p2.count - p1.count));
        for(int i=0; i<len; i++){
            Character ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) +1);
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        Pair hided = null;
        Pair polled = null;
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            sb.append(top.val);

            hided = polled;
            if(top.count -1 >  0){
                polled = new Pair(top.val, top.count-1);
            }else
                polled = null;
            if(hided != null){
                pq.add(hided);
            }
        }
        return (sb.length() == len)? sb.toString(): "";
    }

}

