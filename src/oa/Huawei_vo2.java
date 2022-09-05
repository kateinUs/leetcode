package oa;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 题目：有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），
 * 凡报到3的人退出圈子，问最后留下的是原来第几号的那位。起始索引位为1开始
 * @author huimin
 * @create 2022-01-20 20:39
 */
public class Huawei_vo2 {
    public int solution(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++)
            list.add(i);

        return recursion(list, 1);
    }
    public int recursion(ArrayList<Integer> list, int num){
        ArrayList<Integer> newList = new ArrayList<>();
        if(list.size() == 1)
            return list.get(0);
        int i;
        for(i=0; i<list.size(); i++){
            if((i+num) % 3 != 0)
                newList.add(list.get(i));
        }
//        System.out.println(newList);
        return recursion(newList, i+1);
    }

    public static void main(String[] args) {
        Huawei_vo2 solution = new Huawei_vo2();
        int res = solution.solution(100000);
        System.out.println(res);
    }


}
