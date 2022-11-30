package leetcode;

import java.util.PriorityQueue;

/**
 *  维护一个最大堆一个最小堆
 * 控制两个堆的数量相等 或差1
 *  minHeap = [5， 6， 7]
 *  maxHeap = [3， 2， 1]
 *  最小堆维护大的一半数，最大堆维护小的一半
 *  maxHeap poll出来的就是小的一半数中的最大值，
 *  有新的数字进来后，如果最小堆数字少，需要把最大堆中的最大数匀一个过去
 * @author huimin
 * @create 2022-01-30 21:08
 */
public class T295_Find_median_from_data_stream {
    PriorityQueue<Integer> large;
    PriorityQueue<Integer> small;
    /** initialize your data structure here. */
    public T295_Find_median_from_data_stream() {
        large = new PriorityQueue<>((a, b)->(b-a));
        small = new PriorityQueue<>((a,b)->(a-b));
    }
    // 添加数据
    // 如果两个heap数量相等，加到小堆里
    // 除此之外哪个堆数量少进哪个
    public void addNum(int num) {
        if(large.size()>=small.size()){
            large.offer(num);
            small.offer(large.poll());
        }else{
            small.offer(num);
            large.offer(small.poll());
        }
    }
    // 找中位数
    // 如果两个heap数量相等
    public double findMedian() {
        if(small.size()>large.size()){
            return small.peek();
        }
        if(small.size()<large.size()){
            return large.peek();
        }
        return (small.peek()+large.peek())/2.0;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> min = new PriorityQueue<>((a, b) -> (a - b)); // 最小堆
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> (b- a)); // 最大堆
        min.add(10);
        min.add(3);
        System.out.println(min.poll()); // 3
        System.out.println(min.poll()); // 10
        max.add(10);
        max.add(3);
        System.out.println(max.poll()); // 10
        System.out.println(max.poll()); // 3


    }
}
