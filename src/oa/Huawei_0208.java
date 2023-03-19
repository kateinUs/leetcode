package oa;

import basic.test;

import java.util.*;

/**
 * @author huimin
 * @create 2023-02-08 13:33
 */
public class Huawei_0208 {

    public int test1(int n, int[] arr){
        int peopleOnCar = 0;
        int res = 0;
        int[] wait = new int[n];
        for(int i=0; i<arr.length; i++){
            peopleOnCar += wait[i%n] + arr[i];
            if(peopleOnCar > 9){
                wait[i%n] = peopleOnCar - 9;
                peopleOnCar = 9;
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] a1 = {0, 2, 7, 1};
        int[] a2 = {0, 2, -1, 8, 1, 0, 0, 2};
//        Scanner sc= new Scanner(System.in);
//        int n = Integer.parseInt(sc.nextLine());
//
//        String line = sc.nextLine();
//        String[] splits = line.split(" ");
//
//        int[] nums = new int[splits.length];
//        for(int i=0; i<splits.length; i++){
//            nums[i] = Integer.parseInt(splits[i]);
//            System.out.println(nums[i]);
//        }


        Huawei_0208 test = new Huawei_0208();
//        int res  = test.test1(n, nums);
//        System.out.println(res);

//        int res1= test.test1(2, a1);
//        System.out.println(res1);
//        int res2= test.test1(6, a2);
//        System.out.println(res2);
        int[][] matrix = {{1, 2}, {2, 3}, {1, 4}};
        Set<Integer> set= new HashSet<>();
        for(int[] pair: matrix){
            for(int i: pair){
                if(!set.contains(i)){
                    set.add(i);
                }
            }
        }
        int numOfFunc = set.size();
        System.out.println(numOfFunc);
        System.out.println(test.recursionDepth(numOfFunc, matrix));


    }

    // n代表方法数量
    // arr[0] 调用arr[1]
    public int recursionDepth(int n, int[][] arr){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=1; i<=n; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] pair: arr){
            int from =pair[0];
            int to= pair[1];
            graph.get(from).add(to);
        }

        // 1 for visiting; -1 for visited; 0 not visit
        int[] color = new int[n+1];
        int[] depth = new int[n+1];

        for(int i=1; i<=n; i++){
            if(color[i] != -1){
                if(dfs(graph, color, depth, i)){
                    return -1;
                }
            }
        }

        return Arrays.stream(depth).max().getAsInt();
    }

    // return true -> find cycle
    boolean dfs(Map<Integer, List<Integer>> graph, int[] color, int[] depth, int i){
        color[i] = 1;
        List<Integer> neighbors = graph.get(i);
        int maxDepth = Integer.MIN_VALUE;
        if(!neighbors.isEmpty()){
            for(int next: neighbors){
                if(color[next] == 1){
                    return true;
                }else if(color[next] == -1){
                    continue;
                }else{
                    dfs(graph, color, depth, next);
                    maxDepth = Math.max(maxDepth, depth[next]);
                }
            }
        }
        depth[i] = (maxDepth == Integer.MIN_VALUE)? 0: maxDepth+1;
        // marked as finished visit
        color[i] = -1;
        return false;
    }
}
