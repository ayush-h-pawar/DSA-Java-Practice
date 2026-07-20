import java.util.Arrays;

public class NonOverlappingIntervals1 {

    public int eraseOverlapIntervals(
            int[][] intervals) {

        if (intervals == null
                || intervals.length == 0) {
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

        int removed = 0;

        int previousEnd =
                intervals[0][1];

        for (int i = 1;
             i < intervals.length;
             i++) {

            if (intervals[i][0] < previousEnd) {

                removed++;

            } else {

                previousEnd =
                        intervals[i][1];
            }
        }

        return removed;
    }

    public static void main(String[] args) {

        NonOverlappingIntervals solver =
                new NonOverlappingIntervals();

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
