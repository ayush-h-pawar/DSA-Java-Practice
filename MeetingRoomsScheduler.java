import java.util.Arrays;

public class MeetingRoomsScheduler {

    public boolean canAttendMeetings(
            int[][] intervals) {

        if (intervals == null
                || intervals.length <= 1) {
            return true;
        }

        Arrays.sort(
                intervals,
                (first, second) ->
                        Integer.compare(
                                first[0],
                                second[0]
                        )
        );

        for (int i = 1;
             i < intervals.length;
             i++) {

            if (intervals[i][0]
                    < intervals[i - 1][1]) {

                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        MeetingRoomsScheduler solver =
                new MeetingRoomsScheduler();

        int[][] meetings1 = {
                {0, 30},
                {35, 40},
                {45, 50}
        };

        int[][] meetings2 = {
                {0, 30},
                {5, 10},
                {15, 20}
        };

        System.out.println(
                solver.canAttendMeetings(
                        meetings1
                )
        );

        System.out.println(
                solver.canAttendMeetings(
                        meetings2
                )
        );
    }
}
