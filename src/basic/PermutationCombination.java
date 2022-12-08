package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huimin
 * @create 2022-11-26 21:11
 */
public class PermutationCombination {
    // 组合：combination
    // Subset 1： 数字不重复
    public List<List<Integer>> subsets(int[] arr) {
        // 不重复不需要sort arr
        List<List<Integer>> res = new ArrayList<>();
        subsetsHelper(arr, 0, new ArrayList<>(), res);
        return res;
    }
    public void subsetsHelper(int[] arr, int index, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for(int i=index; i<arr.length; i++){
            path.add(arr[i]);
            subsetsHelper(arr, i+1, path, res);
            path.remove(path.size()-1);
        }
    }

    // Subset 2： 数字会重复
    public List<List<Integer>> subsets2(int[] arr){
        List<List<Integer>> res = new ArrayList<>();
        //sort作用：方便去重
        Arrays.sort(arr);
        subsetsHelper2(arr, 0, new ArrayList<>(), res);
        return res;
    }

    public void subsetsHelper2(int[] arr, int index, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for(int i=index; i<arr.length; i++){
            // 比如 [1, 2', 2'']
            // 还没用2' 不能用2''
            // 比如index=1, path=[1] 进来
            // i=1 -> path=[1. 2'] 可以
            // i=2 -> path=[1, 2''] 不可以
            if(i>0 && arr[i] == arr[i-1] && i>index){
                continue;
            }
            path.add(arr[i]);
            subsetsHelper2(arr, i+1, path, res);
            path.remove(path.size()-1);
        }
    }

    // ------------------------------------------------------------------
    // 求全排列：permutation
    // Permutation 1: 数字不重复
    public List<List<Integer>> permutation(int[] arr){
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];
        permHelper(arr, visited, new ArrayList<>(), res);
        return res;
    }

    //找到以当前path开头的所有排列
    public void permHelper(int[] arr, boolean[] visited, List<Integer> path, List<List<Integer>> res){
        if(path.size() == arr.length){
            res.add(new ArrayList<>(path));
        }
        for(int i=0; i<arr.length; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            path.add(arr[i]);
            permHelper(arr, visited, path, res);
            path.remove(path.size()-1);
            visited[i] = false;
        }
    }

    // Permutation 2: 数字可能重复
    // 求全排列：permutation with repetition
    public List<List<Integer>> permutation2(int[] arr){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        boolean[] visited = new boolean[arr.length];
        permHelper2(arr, visited, new ArrayList<>(), res);
        return res;
    }

    //找到以当前path开头的所有排列
    public void permHelper2(int[] arr, boolean[] visited, List<Integer> path, List<List<Integer>> res){
        if(path.size() == arr.length){
            res.add(new ArrayList<>(path));
        }
        for(int i=0; i<arr.length; i++){
            if(i>0 && arr[i-1] == arr[i] && !visited[i-1]){
                continue;
            }
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            path.add(arr[i]);
            permHelper2(arr, visited, path, res);
            path.remove(path.size()-1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        PermutationCombination test = new PermutationCombination();
        // Test combination with repetition
//        int[] arr = {1, 2, 2};
//        List<List<Integer>> res = test.subsets2(arr);
//        for(List<Integer> list: res){
//            System.out.println(list.toString());
//        }

        // Test permutation with repetition
        int[] arr = {1, 2, 2};
        List<List<Integer>> permutation = test.permutation2(arr);
        System.out.println("Total # of permutations is " + permutation.size());
        for(List<Integer> list: permutation){
            System.out.println(list);
        }


    }

}
