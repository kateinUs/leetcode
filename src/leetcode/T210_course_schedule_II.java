package leetcode;

import java.util.*;

/**
 * Method: employ DFS by adjacency list
 * @author huimin
 * @create 2022-01-19 16:26
 */
public class T210_course_schedule_II {
    enum Color{
        WHITE, GRAY, BLACK
    }
    boolean isPossible;
    // this map's key stores the number of node in the graph
    //            value stores the color of that node, which stands for search status
    Map<Integer, Color> color;
    Map<Integer, List<Integer>> adjList;
    Stack<Integer> topologicalOrder;

    private void init(int numCourses){
        this.isPossible = true;
        this.color = new HashMap<>();
        this.adjList = new HashMap<>();
        this.topologicalOrder = new Stack<>();

        // At first, all the vertces are WHITE
        for(int i=0; i<numCourses; i++){
            this.color.put(i, Color.WHITE);
        }
    }

    private void dfs(int node){
        // steps 1: is the graph has cycle, don't recurse further
        if(!this.isPossible)
            return ;

        // step 2: set color if the node to GRAY, means start search this node
        this.color.put(node, Color.GRAY);

        // step 3: traverse all the neighbors of this node
        List<Integer> neighbors = this.adjList.getOrDefault(node, new ArrayList<Integer>());
        for(Integer neighbor: neighbors){
            // if the neighbor's color is white, set to gray
            if(this.color.get(neighbor) == Color.WHITE){
                this.dfs(neighbor);
            }
            // if the neighbor's color is gray, means it has a cycle
            else if (this.color.get(neighbor) == Color.GRAY){
                this.isPossible = false;
            }
        }
        // step 4: after traversal of all its neighbors, means this search ends, so set its color to black
        this.color.put(node, Color.BLACK);
        // step 5: add it to stack
        this.topologicalOrder.push(node);

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.init(numCourses);

        // put all the edges to the adjacency list
        for(int i=0; i<prerequisites.length; i++){
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> list = this.adjList.getOrDefault(src, new ArrayList<Integer>());
            list.add(dest);
            adjList.put(src, list);
        }

        // If the node is unprocessed, then call dfs on it
        for(int i=0; i<numCourses; i++){
            if(this.color.get(i) == Color.WHITE)
                this.dfs(i);
        }

        int[] order;
        if(this.isPossible){
            order = new int[numCourses];
            int i=0;
            while (!this.topologicalOrder.isEmpty()){
                order[i++] = this.topologicalOrder.pop();
            }
        } else{
            order = new int[0];
        }
        return order;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] prerequisites= new int[][]{{1,0}, {2,1}, {3,1}, {3, 4}};
        T210_course_schedule_II solu = new T210_course_schedule_II();
        int[] res = solu.findOrder(n, prerequisites);
        for(int i: res){
            System.out.print(i + " ");
        }
    }
}
