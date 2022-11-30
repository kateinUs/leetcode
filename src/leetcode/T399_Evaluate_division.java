package leetcode;

import java.util.*;

/**
 * @author huimin
 * @create 2022-09-23 17:03
 */
public class T399_Evaluate_division {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 1. build graph
        // then the question is equivalent with finding path. and find the weigh product along the path

        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for(int i=0; i<equations.size(); i++){
            double val = values[i];
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            // from -> to, w= val
            graph.putIfAbsent(from, new HashMap<>());
            graph.get(from).put(to, val);
            // to -> from, w=1/val
            graph.putIfAbsent(to, new HashMap<>());
            graph.get(to).put(from, 1/val);
        }

        double[] res = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);
            if(!graph.containsKey(from) || !graph.containsKey(to)){
                res[i] = -1.0;
                continue;
            }
            res[i] =  findPath(graph, from, to, new HashSet<>(), 1);
        }

        return res;
    }

//    Set<String> seen = new HashSet<>();
    private double findPath(HashMap<String, HashMap<String, Double>> graph, String from, String to,Set<String> seen, double prod) {

        if(from.equals(to)) return prod;
        Map<String, Double> map = graph.get(from);
        seen.add(from);
        double res = -1.0;
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            String neigh = entry.getKey();
            double w = entry.getValue();
            if(!seen.contains(neigh)){
                res = findPath(graph, neigh, to, seen, prod*w);
                if(res != -1.0) return res;
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        [["a","b"],["b","c"]]
//        [2.0,3.0]
//        [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        T399_Evaluate_division test = new T399_Evaluate_division();
        double[] res = test.calcEquation(equations, values, queries);
        Arrays.stream(res).forEach(System.out::println);
        System.out.println();
    }
}
