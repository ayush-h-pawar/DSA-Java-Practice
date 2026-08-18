import java.util.Arrays;

public class NonOverlappingIntervalsCounter {

    public int eraseOverlapIntervals(
            int[][] intervals) {

        if (intervals.length <= 1) {
            return 0;
        }

        Arrays.sort(
                intervals,
                (first, second) ->
                        Integer.compare(
                                first[1],
                                second[1]
                        )
        );

        int removals = 0;
        int previousEnd =
                intervals[0][1];

        for (int index = 1;
             index < intervals.length;
             index++) {

            if (intervals[index][0]
                    < previousEnd) {

                removals++;

            } else {

                previousEnd =
                        intervals[index][1];
            }
        }

        return removals;
    }

    public static void main(String[] args) {

        NonOverlappingIntervalsCounter solver =
                new NonOverlappingIntervalsCounter();

        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };

        System.out.println(
                solver.eraseOverlapIntervals(
                        intervals
                )
        );
    }
}
