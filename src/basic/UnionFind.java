package basic;

import java.util.HashMap;

/**
 * @author huimin
 * @create 2022-10-18 11:58
 */
public class UnionFind{
    HashMap<Integer, Integer> fatherMap;
    HashMap<Integer, Integer> sizeMap;
    int numOfSet = 0;

    public UnionFind(){
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        numOfSet = 0;
    }
    public void add(int x){
        if(fatherMap.containsKey(x)){
            return;
        }
        fatherMap.put(x, null);
        sizeMap.put(x, 1);
        numOfSet++;
    }
    public int find(int x){
        int root = x;
        // 指针root指向被查找的点x
        // 不断找到root的父亲，直到root指向x的根节点
        while(fatherMap.get(root) != null){
            root = fatherMap.get(root);
        }
        // 将路径上所有的点指向根节点
        while(x != root){
            int origFather = fatherMap.get(x);
            fatherMap.put(x, root);
            x = origFather;
        }
        return root;
    }
    public void merge(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            fatherMap.put(rootX, rootY);
            numOfSet--;
            sizeMap.put(rootY, sizeMap.get(rootX)+sizeMap.get(rootY));
        }
    }
    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }

}
