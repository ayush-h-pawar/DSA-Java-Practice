import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsIICalculator {

    public int minMeetingRooms(
            int[][] intervals) {

        if (intervals == null
                || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(
                intervals,
                (first, second) ->
                        Integer.compare(
                                first[0],
                                second[0]
                        )
        );

        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>();

        minHeap.offer(intervals[0][1]);

        for (int i = 1;
             i < intervals.length;
             i++) {

            if (intervals[i][0]
                    >= minHeap.peek()) {

                minHeap.poll();
            }

            minHeap.offer(intervals[i][1]);
        }

        return minHeap.size();
    }

    public static void main(String[] args) {

        MeetingRoomsIICalculator solver =
                new MeetingRoomsIICalculator();

        int[][] meetings = {
                {0, 30},
                {5, 10},
                {15, 20}
        };

        System.out.println(
                solver.minMeetingRooms(
                        meetings
                )
        );
    }
}
