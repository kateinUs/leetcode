package leetcode;

import java.util.*;

/**
 * @author huimin
 * @create 2022-03-08 22:43
 */
public class T380_Insert_delete_getrandom {
    Set<Integer> set;
    public T380_Insert_delete_getrandom() {
        set = new HashSet<>();
    }

    public boolean insert(int val) {
        if(set.contains(val))
            return false;
        else{
            set.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if(set.contains(val)){
            set.remove(val);
            return true;
        }else{
            return false;
        }
    }

    public int getRandom() {
        Random rand = new Random();
        int randPos = rand.nextInt(set.size());
        return new ArrayList<>(set).get(randPos);
    }
}

// Method2: use ArrayList and HashMap
/**
 * class RandomizedSet {
 *     Map<Integer, Integer> dict;
 *     List<Integer> list;
 *     Random rand = new Random();
 *     public RandomizedSet() {
 *         dict = new HashMap();
 *         list = new ArrayList<>();
 *     }
 *
 *     public boolean insert(int val) {
 *         if(dict.containsKey(val)) return false;
 *         // key of dict is the value
 *         // value is its index
 *         dict.put(val, list.size()); // index starts from 0
 *         list.add(val);
 *         return true;
 *     }
 *
 *     public boolean remove(int val) {
 *         if(!dict.containsKey(val)) return false;
 *         // swap the random picked one with the last one, and always remove the last
 *         Integer last = list.get(list.size()-1);
 *         int idx = dict.get(val);
 *         list.set(idx, last);
 *         dict.put(last, idx);
 *         // remove the element form both list and map
 *         list.remove(list.size() - 1);
 *         dict.remove(val);
 *         return true;
 *     }
 *
 *     public int getRandom() {
 *         return list.get(rand.nextInt(list.size()));
 *     }
 * }
 */
