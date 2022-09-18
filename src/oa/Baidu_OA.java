package oa;

/**
 * 游戏通关 计算在总时间t内可以通过多少关卡
 * 两个游戏A, B, 分别有n, m个关卡，a1, a2, ..., an; b1, b2, bm
 * @author huimin
 * @create 2022-09-13 11:27
 */
public class Baidu_OA {
    public static void main(String[] args) {
        int[] A = {2, 3, 4, 5, 2};
        int[] B = {1, 3, 2, 1, 1};
        int t = 10;
        int res = method1(A,B, t);
        System.out.println(res);
    }
    static int method1(int[] A, int[] B, int limit){
        int i=0, j=0;
        int t=0, ans=0;
        while(t<= limit && i<A.length && j<B.length){
            if(A[i] < B[j]) t += A[i++];
            else            t += B[j++];
            ans ++;
        }
        while(t <= limit && (i<A.length || j<B.length)){
            if(i < A.length)    t += A[i++];
            else if(j <B.length)  t +=B[j++];
            ans++;
        }

        return ans;
    }

    /*
    n个士兵
    战斗力为h1, h2, ..., hn
    小明 t=1：从小到大排；小红 t=2：大到小
    输入：
    n m
    t1 k1 (t ==1 小明操作， else小红)
    t2 k2
    ...
    tm km
     */
    int[] method2(int n, int[][] operations){

        return null;
    }
}
