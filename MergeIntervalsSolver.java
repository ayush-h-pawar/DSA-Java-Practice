import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervalsSolver {

    public int[][] merge(
            int[][] intervals) {

        if (intervals == null
                || intervals.length == 0) {

            return new int[0][];
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

        int[] current =
                intervals[0];

        merged.add(current);

        for (int i = 1;
             i < intervals.length;
             i++) {

            if (intervals[i][0]
                    <= current[1]) {

                current[1] =
                        Math.max(
                                current[1],
                                intervals[i][1]
                        );

            } else {

                current =
                        intervals[i];

                merged.add(current);
            }
        }

        return merged.toArray(
                new int[merged.size()][2]
        );
    }

    public static void main(String[] args) {

        MergeIntervalsSolver solver =
                new MergeIntervalsSolver();

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
                    "[" + interval[0]
                            + ", "
                            + interval[1]
                            + "]"
            );
        }
    }
}
