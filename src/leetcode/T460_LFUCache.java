package leetcode;


import java.util.*;

/**
 * @author huimin
 * @create 2022-02-16 15:12
 */


public class T460_LFUCache {
    class Node {
        int key;
        int value;
        int freq;

        // 封装一个包含key、value和初始化访问频次为 1 的节点。
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            freq = 1;
        }
    }
    // 存储缓存的内容。
    Map<Integer, Node> cache;
    // 存储每个访问频次对应的内容链表。
    Map<Integer, LinkedHashSet<Node>> freqMap;
    // 缓存内容长度。
    int capacity;
    // 记录最小访问频次。
    int minFreq;
    public T460_LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
        minFreq = 1;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node == null){
            return -1;
        }
        updateFreq(node);
        return node.value;
    }
    public void updateFreq(Node node) {
        int freq = node.freq;
        LinkedHashSet<Node> oldSet = freqMap.get(freq);
        oldSet.remove(node);

        // 当前节点的访问频次最小，并且没有相同访问频次的节点了，则最小访问频次 +1 。
        if (freq == minFreq && oldSet.size() == 0) {
            minFreq = freq + 1;
        }

        node.freq++;
        LinkedHashSet<Node> newSet = freqMap.getOrDefault(node.freq, new LinkedHashSet<Node>());
        newSet.add(node);
        freqMap.put(freq+1, newSet);

    }

    public void put(int key, int value) {
        if(capacity ==0)
            return;
        Node node = cache.get(key);
        if(node == null){
            if (cache.size() == capacity) {
                removeNode();
            }
            Node newNode = new Node(key, value);
            addNode(newNode);
        }else{
            node.value = value;
            updateFreq(node);
        }
    }

    private void addNode(Node node) {
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.getOrDefault(freq, new LinkedHashSet<>());
        set.add(node);
        // update min frequency, since freq = 1, so directly update it to 1
        minFreq = freq;
        freqMap.put(freq, set);
        cache.put(node.key, node);

    }

    private void removeNode() {
        // find the linkedset of minfreq
        LinkedHashSet<Node> minFreqSet = freqMap.get(minFreq);

        // get the first added value, which is the least recent used one
        Node nodeToRemove = minFreqSet.iterator().next();
        // remove the node from set and cache
        minFreqSet.remove(nodeToRemove);
        cache.remove(nodeToRemove.key);
    }

    public static void main(String[] args) {
        T460_LFUCache lfu = new T460_LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.get(1);      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        lfu.get(2);      // return -1 (not found)
        lfu.get(3);      // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        lfu.get(1);      // return -1 (not found)
        lfu.get(3);      // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        lfu.get(4);      // return 4
        // cache=[4,3], cnt(4)=2, cnt(3)=3
    }
}
