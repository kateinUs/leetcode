package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author huimin
 * @create 2022-11-14 14:52
 */
public class T_2290_Min_Obstacle_removal_to_reach_corner {
    public int minimumObstacles(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[row][col];
        // # of edges: row * col
        // 先加入第一个节点，需要保存从原点到改点所需的cost
        dq.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;

        // while循环不断poll出队首元素
        // 对该元素的邻居进行遍历，如果邻居是障碍物，那么当前点到邻居的距离是1
        // 如果邻居是空地，那么到邻居的距离是0
        // 0 加到队首，1加到队尾，这样就不需要用优先级对列来实现每次拿出最近的邻居
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            if(cur[0] == row-1 && cur[1] == col-1)
                return cur[2];
            for(int[] dir: dirs){
                int ni = cur[0] + dir[0];
                int nj = cur[1] + dir[1];
                if(ni<0 || ni>= row || nj<0 || nj>=col || visited[ni][nj]) continue;

                if(grid[ni][nj] == 1)
                    dq.offerLast(new int[]{ni, nj, cur[2] + grid[ni][nj]});
                else
                    dq.offerFirst(new int[]{ni, nj, cur[2] + grid[ni][nj]});
                visited[ni][nj] = true;
            }
        }

        return -1;
    }
}
