package leetcode;

import java.util.*;

/**
 * @author huimin
 * @create 2022-08-28 15:21
 */
public class T2392_Build_matrix_With_conditions {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    Stack<Integer> st = new Stack<>();
    int[] color ; // 0 for unvisited, 1 for visting, -1 for visited
    int k;

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        this.k = k;
        int[][] res = new int[k][k];
        Map<Integer, Integer> rowOrder = new HashMap<>();
        Map<Integer, Integer> colOrder = new HashMap<>();

        if(!topoSort(rowConditions, rowOrder) || !topoSort(colConditions, colOrder))
            return new int[0][];

        for(int i=1; i<=k; i++){
            res[rowOrder.get(i)][colOrder.get(i)] = i;
        }
        return res;
    }

    boolean topoSort(int[][] conditions, Map<Integer, Integer> resOrder){
        adjList.clear();
        st.clear();
        color = new int[k+1];

        // build graph using conditions
        for(int[] pair: conditions){
            int from = pair[0];
            int to = pair[1];
            List<Integer> oldList = adjList.getOrDefault(from, new ArrayList<>());
            oldList.add(to);
            adjList.put(from, oldList);
        }

        for(int i=1; i<=k; i++){
            if(color[i] == 0){
                if(!dfs(i)) return false;
            }
        }
        int i=0;
        while(!st.isEmpty()){
            resOrder.put(st.pop(), i++);
        }
        return true;
    }
    // dfs with cycle dection
    boolean dfs(int node){
        color[node] =1;
//        if(adjList.get(node) == null) return true;
        for(int neib: adjList.getOrDefault(node, new ArrayList<>())){
            if(color[neib] == 0){
                if(!dfs(neib)){
                    return false;
                }
            }else if(color[neib] == 1){
                // hasCycle = true;
                return false;
            }
        }
        st.push(node);
        color[node] = -1;
        return true;
    }

    public static void main(String[] args) {
        //[[1,2],[3,2]], colConditions = [[2,1],[3,2]]
        int k =3;
        int[][] rowCond = {{1,2}, {3,2}};
        int[][] colCond = {{2,1}, {3,2}};
        T2392_Build_matrix_With_conditions test = new T2392_Build_matrix_With_conditions();
        int[][] res = test.buildMatrix(k, rowCond, colCond);
        System.out.println(res);
        for(int i=0; i<res.length; i++){
            for(int j=0; j<res[0].length; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
