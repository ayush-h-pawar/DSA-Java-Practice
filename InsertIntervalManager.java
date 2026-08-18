import java.util.ArrayList;
import java.util.List;

public class InsertIntervalManager {

    public int[][] insert(
            int[][] intervals,
            int[] newInterval) {

        List<int[]> result =
                new ArrayList<>();

        int index = 0;

        while (index < intervals.length
                && intervals[index][1]
                < newInterval[0]) {

            result.add(intervals[index]);
            index++;
        }

        while (index < intervals.length
                && intervals[index][0]
                <= newInterval[1]) {

            newInterval[0] =
                    Math.min(
                            newInterval[0],
                            intervals[index][0]
                    );

            newInterval[1] =
                    Math.max(
                            newInterval[1],
                            intervals[index][1]
                    );

            index++;
        }

        result.add(newInterval);

        while (index < intervals.length) {

            result.add(intervals[index]);
            index++;
        }

        return result.toArray(
                new int[result.size()][2]
        );
    }

    public static void main(String[] args) {

        InsertIntervalManager solver =
                new InsertIntervalManager();

        int[][] intervals = {
                {1, 3},
                {6, 9}
        };

        int[] newInterval = {
                2, 5
        };

        int[][] result =
                solver.insert(
                        intervals,
                        newInterval
                );

        for (int[] interval : result) {
            System.out.println(
                    interval[0] + " "
                    + interval[1]
            );
        }
    }
}
