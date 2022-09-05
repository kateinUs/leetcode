package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author huimin
 * @create 2022-07-28 15:22
 */
public class T207_Course_schedule {
    // use DFS to chekc ifCyclic
    int[] color; // 1 for visiting; -1 for visited; 0 not visit
    HashMap<Integer, List<Integer>> courseDict = new HashMap<>();
    boolean hasCycle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        color = new int[numCourses];
        for(int[] pair: prerequisites){
            int a = pair[0];
            int b = pair[1];
            List<Integer> neighbors = courseDict.getOrDefault(b, new ArrayList<>());
            neighbors.add(a);
            courseDict.put(b, neighbors);
        }
        for(int i=0; i<numCourses; i++){
            if(color[i] != -1){
                DFS(i);
                if(hasCycle)
                    return false;
            }
        }
        return !hasCycle;

    }
    void DFS(int courseId){
        color[courseId] = 1;
        List<Integer> neighbors = courseDict.get(courseId);
        if(!neighbors.isEmpty()){
            for(int i: neighbors){
                if(color[i] == 1){
                    hasCycle = true;
                    return;
                }else if(color[i] == -1){
                    continue;
                }else
                    DFS(i);
            }
        }

        // marked as finished visit
        color[courseId] = -1;
    }

    public static void main(String[] args) {
        int num = 3;
        int[][] pres = new int[][]{{1,0},{2,0},{0,2}};
        T207_Course_schedule test = new T207_Course_schedule();
        boolean res = test.canFinish(num, pres);
        System.out.println(res);
    }
}
