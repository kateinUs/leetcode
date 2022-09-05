package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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
        if (intervals.length == 0)
            return 0;

        // Min heap
        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>(intervals.length);
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);

        // Add the first meeting's end time
        allocator.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i][0] >= allocator.peek())
                allocator.poll();

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i][1]);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }
}
