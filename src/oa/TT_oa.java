package oa;

import java.util.*;

/**
 * @author huimin
 * @create 2022-10-18 11:26
 */
//https://blog.csdn.net/Jocker_coding/article/details/85985474
class UnionFind {
    HashMap<Integer, Integer> fatherMap;
    HashMap<Integer, Integer> sizeMap;
    public UnionFind() {
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
    }

    public void add(int x) {
        if (fatherMap.containsKey(x))  return;
        fatherMap.put(x, x); // make x point to itself
        sizeMap.put(x, 1);
    }

    private Integer find(Integer node) {
        Integer captain = fatherMap.get(node);
        // 如果自己的船长不是自己 bubble up
        // 路劲压缩
        if (captain != node) {
            fatherMap.put(node, find(captain));
        }
        return fatherMap.get(node);
    }

    public boolean isConnected(Integer aNode, Integer bNode) {
        return find(aNode) == find(bNode);
    }

    public void union(Integer aNode, Integer bNode) {
        if (aNode == null || bNode == null) return;
        Integer aHead = find(aNode);
        Integer bHead = find(bNode);
        if (aHead != bHead) {
            int aSize = sizeMap.get(aHead);
            int bSize = sizeMap.get(bHead);
            if (aSize < bSize) {
                fatherMap.put(aHead, bHead);
                sizeMap.put(bHead, aSize + bSize);
            } else {
                fatherMap.put(bHead, aHead);
                sizeMap.put(aHead, aSize + bSize);
            }
        }
    }
}

public class TT_oa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int T = scanner.nextInt();
//        for(int i=0; i<T; i++){
        int m = scanner.nextInt();
        List<int[]> pairs = new ArrayList<>();
        UnionFind uf = new UnionFind();
        System.out.println(m);
        int[] temp;
        for (int j = 0; j < m; j++) {
            temp = new int[2];
            System.out.println("Input " + (j + 1) + " pair");
            temp[0] = scanner.nextInt();
            temp[1] = scanner.nextInt();
//                pairs.add(temp);
            uf.add(temp[0]);
            uf.add(temp[1]);
            uf.union(temp[0], temp[1]);
            System.out.println(temp[0] + "  " +temp[1]);
        }
        uf.fatherMap.forEach((k, v) -> System.out.println(k + "->" + v));
        uf.sizeMap.forEach((k, v) -> System.out.println(k + "->" + v));

        int maxCircle = Collections.max(uf.sizeMap.values());
        System.out.println(maxCircle);
    }
//    }
}
