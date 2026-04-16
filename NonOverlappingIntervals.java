import java.util.*;

public class NonOverlappingIntervals {

    static int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < end) {
                count++; // remove this interval
            } else {
                end = intervals[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};

        System.out.println(eraseOverlapIntervals(intervals)); // 1
    }
}
