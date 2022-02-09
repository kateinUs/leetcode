package leetcode;

import java.util.PriorityQueue;

/**
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
    //添加数据
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
    public double findMedian() {
        if(small.size()>large.size()){
            return small.peek();
        }
        if(small.size()<large.size()){
            return large.peek();
        }
        return (small.peek()+large.peek())/2.0;
    }
}
