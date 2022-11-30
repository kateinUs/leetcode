package jiuzhang;

import java.util.*;

/**
 * @author huimin
 * @create 2022-11-29 16:44
 */
public class T90_KSum_2 {
    // 纯DFS的解法
    public List<List<Integer>> kSumII(int[] a, int k, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        dfs(a, 0, k, target, new ArrayList<>(), res);
        return res;
    }
    void dfs(int[] a, int start, int k, int target, List<Integer> path, List<List<Integer>> res){
        if(k == 0 && target == 0){
            res.add(new ArrayList<>(path));
            return ;
        }
        if(start >= a.length) return;
        if(k==0 || target== 0) return ;
        if(target < 0) return;
        // 不拿当前数
        dfs(a, start+1, k, target, path, res);
        // 拿
        path.add(a[start]);
        dfs(a, start+1, k-1, target-a[start], path, res);
        path.remove(path.size()-1);
    }

    // 我们也可以进行一个DFS with memo的操作
    // 递归方法就需要返回 List<List<Integer>> res
    // 参数需要传一个Map类型的memo

}
// FreeMsg: Txt: CALL to No: 86888 & claim your reward of 3 hours talk time to use from your phone now! ubscribe6GBP/ mnth inc 3hrs 16 stop?txtStop