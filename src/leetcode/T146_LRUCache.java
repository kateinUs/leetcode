package leetcode;

import java.security.Key;
import java.util.*;

/**
 * @author huimin
 * @create 2022-03-08 1:54
 */
public class T146_LRUCache {

    DNode head, tail;

    class DNode{
        int key, value;
        DNode prev, next;

        DNode(){}
        DNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    // add node2 to head
    // head <-> node2 <-> node1 <-> tail
    private void addNode(DNode node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    // remvoe node2
    // head <-> node3 <-> node2 <-> node1 <-> tail
    private void removeNode(DNode node){
        DNode prevNode = node.prev;
        DNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private DNode popTail(){
        DNode res = tail.prev; // the least recently used one
        removeNode(res);
        return res;
    }

    private void moveToHead(DNode node){
        removeNode(node);
        addNode(node);
    }

    HashMap<Integer, DNode> cache = new HashMap<>();
    int capacity;
    int size;

    public T146_LRUCache(int capacity){
        this.capacity = capacity;
        this.size = 0;
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key){
        DNode node = cache.get(key);
        if(node == null) return -1;

        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value){
        DNode node = cache.get(key);
        if(node == null){
            DNode newNode = new DNode(key, value);

            cache.put(key, newNode);
            addNode(newNode);
            ++size;
            if(size > capacity){
                // pop the least recent used
                DNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }

}

/*
    Method 2: Extend LinkedHashMap
 */
class LRUCache extends LinkedHashMap<Integer, Integer>{
    int capacity;

    LRUCache(int capacity){
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key){
        return super.getOrDefault(key, -1);
    }

    public void set(int key, int value){
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
        return size() > capacity;
    }
}