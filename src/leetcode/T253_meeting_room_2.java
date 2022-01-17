package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author huimin
 * @create 2021-09-15 12:24
 */
public class T253_meeting_room_2 {
    public static void main(String[] args) {
        int[][] testcase = new int[][]{{9,10}, {4,9},{4,17}};
        System.out.println(minMeetingRooms(testcase));
    }
    // Method 1: use simulation
    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int len = intervals.length;
        int i=0, time=0;
        ArrayList<int[]> rooms = new ArrayList<>();
        int max_room=0;
        while(i< len){
            while(intervals[i][0] == time){
                rooms.add(new int[]{intervals[i][0], intervals[i][1]});
                i++;
            }
            for (int j = 0; j < rooms.size(); j++) {
                if(time == rooms.get(j)[1])
                    rooms.remove(j);
            }
            time++;
            max_room = Math.max(max_room, rooms.size());
        }
        return max_room;
    }

    public static int minMeetingRooms2(int[][] intervals) {

        return 0;
    }
}
