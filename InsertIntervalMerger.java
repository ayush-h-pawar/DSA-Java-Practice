import java.util.ArrayList;
import java.util.List;

public class InsertIntervalMerger {

    public int[][] insert(
            int[][] intervals,
            int[] newInterval) {

        List<int[]> merged =
                new ArrayList<>();

        int index = 0;

        while (index < intervals.length
                && intervals[index][1] < newInterval[0]) {

            merged.add(intervals[index]);
            index++;
        }

        while (index < intervals.length
                && intervals[index][0] <= newInterval[1]) {

            newInterval[0] = Math.min(
                    newInterval[0],
                    intervals[index][0]
            );

            newInterval[1] = Math.max(
                    newInterval[1],
                    intervals[index][1]
            );

            index++;
        }

        merged.add(newInterval);

        while (index < intervals.length) {

            merged.add(intervals[index]);
            index++;
        }

        return merged.toArray(
                new int[merged.size()][2]
        );
    }

    public static void main(String[] args) {

        InsertIntervalMerger solver =
                new InsertIntervalMerger();

        int[][] intervals = {
                {1, 3},
                {6, 9}
        };

        int[] newInterval = {
                2,
                5
        };

        int[][] result =
                solver.insert(
                        intervals,
                        newInterval
                );

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
