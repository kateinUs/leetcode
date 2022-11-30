package basic;

import java.util.*;

/**
 * @author huimin
 * @create 2022-09-25 4:37
 */
class NodeJ{
    int id;
    int dist;
}

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a1 = new int[n-1];
        int[] a2 = new int[n-1];
        for(int i=0; i<n-1; i++){
            a1[i] = sc.nextInt();
        }
        for(int i=0; i<n-1; i++){
            a2[i] = sc.nextInt();
        }
        int am=sc.nextInt(), bm=sc.nextInt(), cm = sc.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<int[], Integer> weighs = new HashMap<>();
        Map<Integer, Integer> dists = new HashMap<>();
        for(int i=0; i<a1.length; i++){
            int from = i+2;
            int to = a1[i];
            map.putIfAbsent(from, new ArrayList<>());
            map.putIfAbsent(to, new ArrayList<>());
            map.get(from).add(to);
            map.get(to).add(from);
            weighs.put(new int[]{from, to}, a2[i]);
            weighs.put(new int[]{to, from}, a2[i]);
        }
        int m = 0;
        int min = Integer.MAX_VALUE;
        while(m<n){
            int da=-1, db=-1, dc=-1;
            Queue<Integer> q = new LinkedList<>();
            int dis = 0;
            dists.put(m, dis);
            boolean[] visited = new boolean[n];
            while(!q.isEmpty()){
                int cur = q.poll();
                visited[cur] = true;
                if(cur+1 == am) da = dists.get(cur);
                else if (cur+1 == bm) db = dists.get(cur);
                else if(cur+1 == cm) dc = dists.get(cur);
                if(da >0 && db >0 && dc>0) break;
                // iterate all the neighbors
                for(int i: map.get(cur)){
                    if(!visited[i]){
                        q.add(i);
                        dists.put(i, dists.get(cur)+weighs.get(new int[]{cur, i}));
                    }
                }
            }
            int sum = da+db+dc;
            min = Math.min(min, sum);
            m++;
        }
        System.out.println(min);

    }

    void method2(){
//        for(int i=0; i<n; i++){
//            String s1 = sc.nextLine();
//            String s2 = sc.nextLine();
//
//            String res = (function(s1, s2))? "yes": "no";
//            System.out.println(res);
//        }
//        boolean res = function("yesyes", "yes");
//        System.out.println(res);
    }


    static boolean function(String s1, String s2) {
        int i =0, j=0; // i for s1, j for s2
        int m=s1.length(), n=s2.length();
        while(j<n && i<m){
            if(s1.charAt(i) == s2.charAt(j)){
                j++;
            }
            i++;
        }

        return j==n;
    }
}
