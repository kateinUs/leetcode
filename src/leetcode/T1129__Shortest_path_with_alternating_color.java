package leetcode;

import java.util.*;

import javafx.util.Pair;
/**
 * @author huimin
 * @create 2022-09-28 15:00
 */
public class T1129__Shortest_path_with_alternating_color {
    enum Color{
        RED,BLUE,DEFAULT
    }
    Map<Integer, List<Pair<Integer, Color>>> graph = new HashMap<>();
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] res = new int[n]; // store the shortest path length, -1 for unreachable
        Arrays.fill(res, -1);
        for(int[] re: redEdges){
            graph.putIfAbsent(re[0], new ArrayList<Pair<Integer, Color>>());
            graph.get(re[0]).add(new Pair<>(re[1], Color.RED));
        }
        for(int[] re: blueEdges){
            graph.putIfAbsent(re[0], new ArrayList<Pair<Integer, Color>>());
            graph.get(re[0]).add(new Pair<>(re[1], Color.BLUE));
        }
        // use BFS
        Queue<Pair<Integer, Color>> q = new LinkedList<>(); // a queue contains of the nodes to be visit
        Set<Pair<Integer, Color>> seen  = new HashSet<>();
        q.add(new Pair<>(0, Color.DEFAULT));
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Pair<Integer, Color> cur = q.poll();
                seen.add(cur);
                res[cur.getKey()] = (res[cur.getKey()]== -1)? step: res[cur.getKey()];
                Color curColor = cur.getValue();
                for(Pair<Integer, Color> p: graph.getOrDefault(cur.getKey(), new ArrayList<>())){
                    if(!seen.contains(p) && (curColor == Color.DEFAULT || p.getValue() != curColor)){
                        q.add(p);
                    }
                }
            }
            step++;
        }

        return res;
    }
}
