package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2022/07/30 Weekly Contest Question 4
 * https://leetcode.com/contest/weekly-contest-304
 * @author huimin
 * @create 2022-08-01 11:05
 */
public class T2360_Longest_cycle_in_A_group {
    int[] color;
    int[] edges;
    int max=-1;

    public int longestCycle(int[] edges) {
        this.color = new int[edges.length];
        this.edges = edges;
        for(int i=0; i<edges.length; i++){
            if(color[i] == 0){
                // use map to store depth
                HashMap<Integer, Integer> map = new HashMap<>(); // node -> depth
                DFS(i, 1, map);
            }
        }
        return max;
    }
    public void DFS(int node, int depth, Map<Integer, Integer> map){
        color[node] = 1;
        map.put(node, depth);

        int neighbor = edges[node];
        if(neighbor != -1) {
            if (color[neighbor] == 1) { // detect cycle
                int cycle = depth - map.get(neighbor) + 1;
                max = Math.max(max, cycle);
            } else if (color[neighbor] == 0) {
                DFS(neighbor, depth + 1, map);
            }
        }
        color[node] = 2;
    }

    public static void main(String[] args) {
        int[] test = new int[]{2, -1, 3, 1};
        T2360_Longest_cycle_in_A_group cls = new T2360_Longest_cycle_in_A_group();
        System.out.println(cls.longestCycle(test));
    }
}
