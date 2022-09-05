package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huimin
 * @create 2022-07-06 11:01
 */
public class T365_Water_and_Jus {
    /*
    Method1:Using BFS
     */
    public boolean canMeasureWater(int jug1, int jug2, int target) {
        if(target > jug1+jug2)
            return false;

        int[] dirs = {jug1, -jug1, jug2, -jug2};
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();

            for(int dir: dirs){
                int dist = curr +dir;
                if(dist == target)
                    return true;
                if(dist < 0 || dist > jug1+jug2){
                    continue;
                }
                if(!visited.contains(dist)){
                    visited.add(dist);
                    q.add(dist);
                }
            }
        }

        return false;
    }
}
