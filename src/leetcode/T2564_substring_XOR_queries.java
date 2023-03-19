package leetcode;

import javafx.util.Pair;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huimin
 * @create 2023-02-11 23:17
 */
public class T2564_substring_XOR_queries {
    public int[][] substringXorQueries(String s, int[][] queries) {
        int[][] res = new int[queries.length][2];
        for(int i=0; i<queries.length; i++){
            res[i][0] = -1;
            res[i][1] = -1;
        }
        int n = s.length();
        Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();
        String sub;
        int num;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                sub = s.substring(i, j+1);
                num = binStr2Num(sub);
                if(!map.containsKey(num)){
                    map.put(num, new Pair<Integer, Integer>(i, j));
                }else{
                    Pair<Integer, Integer> old = map.get(num);
                    if(j-i < old.getValue()-old.getKey()){
                        map.put(num, new Pair<Integer, Integer>(i, j));
                    }
                }
            }
        }
        for(int i=0; i<queries.length; i++){
            int first = queries[i][0];
            int second = queries[i][1];
            for(Integer key: map.keySet()){
                int tmp = key ^ first;
                System.out.println(tmp);
                if(tmp == second){
                    res[i][0] = map.get(key).getKey();
                    res[i][1] = map.get(key).getValue();
                }
            }
        }
        return res;
    }


    int binStr2Num(String s){
        int num=0;
        char ch;
        for(int i=s.length()-1; i>=0; i--){
            ch = s.charAt(i);
            num = num * 2 + ch-'0';
        }
        return num;
    }

    public static void main(String[] args) {
        //s = "101101", queries = [[0,5],[1,2]]
        String s = "101101";
        int[][] queries = {{0, 5}, {1, 2}};
        T2564_substring_XOR_queries test =new T2564_substring_XOR_queries();
        int[][] res = test.substringXorQueries(s, queries);
        System.out.println(res);
    }
}
