package meta;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author huimin
 * @create 2021-11-30 0:33
 */
public class Find_Median {
    PriorityQueue<Integer> large;
    PriorityQueue<Integer> small;
    /** initialize your data structure here. */
    public Find_Median() {
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

    int findMedian_meta(int[] arr) {
        int[] res = new int[arr.length];
        // Write your code here
        for(int i=0; i<arr.length; i++){
            addNum(arr[i]);
            res[i] = (int) findMedian();
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr= new int[]{1,2,3,4};
        String s1 = arr.toString();
        String s2 = Arrays.toString(arr);
        System.out.println(s1);
        System.out.println(s2);

    }
}
