import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervalsOptimizer {

    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(
                intervals,
                (first, second) ->
                        Integer.compare(
                                first[0],
                                second[0]
                        )
        );

        List<int[]> merged =
                new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int index = 1;
             index < intervals.length;
             index++) {

            if (intervals[index][0] <= end) {

                end = Math.max(
                        end,
                        intervals[index][1]
                );

            } else {

                merged.add(
                        new int[]{start, end}
                );

                start = intervals[index][0];
                end = intervals[index][1];
            }
        }

        merged.add(
                new int[]{start, end}
        );

        return merged.toArray(
                new int[merged.size()][2]
        );
    }

    public static void main(String[] args) {

        MergeIntervalsOptimizer solver =
                new MergeIntervalsOptimizer();

        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] result =
                solver.merge(intervals);

        for (int[] interval : result) {
            System.out.println(
                    interval[0] + " " + interval[1]
            );
        }
    }
}
