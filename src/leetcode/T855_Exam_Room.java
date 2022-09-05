package leetcode;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author huimin
 * @create 2022-02-10 0:23
 */
public class T855_Exam_Room {
    int[] seats;
    int size = 0; // The number of students in the room
    public T855_Exam_Room(int n) {
        this.seats = new int[n];
    }

    public int seat() {
        if(size == 0) {
            seats[0] = ++size;
            return 0;
        }
        int pos = findMaxDistSeat();
        seats[pos] = ++size;
        return pos;

    }

    private int findMaxDistSeat() {
        PriorityQueue<Integer> takenSeats = new PriorityQueue<>();
        for(int i=0; i<seats.length; i++){
            if(seats[i] != 0)
                takenSeats.add(i);
        }
        if(takenSeats.size() == 1){
            int pos = takenSeats.remove();
            int p = (seats.length-1-pos <= pos)? 0: seats.length-1;
            return p;
        }
        int globMaxDist=takenSeats.remove();
        int globMaxDistIdx=0;
        int pre = globMaxDist;
        int curr = globMaxDist;
        while(!takenSeats.isEmpty()){
            curr = takenSeats.remove();
            int mid = pre + (curr -pre)/2;
            int min_dist = Math.min(Math.abs(curr-mid), Math.abs(pre-mid));
            if(min_dist > globMaxDist){
                globMaxDist = min_dist;
                globMaxDistIdx = mid;
            }
            pre = curr;
        }
        if(seats.length-1-curr > globMaxDist){
            globMaxDistIdx = seats.length-1;
        }
        return globMaxDistIdx;
    }

    public void leave(int p) {
        seats[p] = 0;
        size--;
    }

    public static void main(String[] args) {
        T855_Exam_Room er = new T855_Exam_Room(10);
        System.out.println(er.seat());
        System.out.println(er.seat());
        System.out.println(er.seat());
        System.out.println(er.seat());
        er.leave(4);
        System.out.println(er.seat());


    }
}
