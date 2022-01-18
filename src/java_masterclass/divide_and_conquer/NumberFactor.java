package java_masterclass.divide_and_conquer;

import java.util.HashMap;

/**
 * @author huimin
 * @create 2022-01-17 23:54
 */
public class NumberFactor {

    public int waysToGetNTopDown(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return recursion(map, n);

    }

    /**
     * Number foctor top down approach
     * @param map
     * @param n
     * @return
     */
    private int recursion(HashMap<Integer, Integer> map, int n){
        if(n == 0 || n == 1 || n == 2)
            return 1;
        if(n == 3)
            return 2;

        if(!map.containsKey(n)){
            map.put(n, recursion(map, n-1)+recursion(map,n-3)+recursion(map,n-4));
        }
        return map.get(n);
    }

    public static void main(String[] args) {
        NumberFactor nf = new NumberFactor();
        int res = nf.waysToGetNTopDown(4);
        System.out.println(res);
    }
}