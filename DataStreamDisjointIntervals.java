import java.util.*;

public class DataStreamDisjointIntervals {

    private TreeMap<Integer, int[]> intervals;

    public DataStreamDisjointIntervals() {

        intervals = new TreeMap<>();
    }

    public void addNum(int value) {

        Integer lower =
                intervals.floorKey(value);

        Integer higher =
                intervals.ceilingKey(value);

        if (lower != null &&
            intervals.get(lower)[1] >= value) {

            return;
        }

        boolean mergeLeft =
                lower != null &&
                intervals.get(lower)[1] + 1
                == value;

        boolean mergeRight =
                higher != null &&
                higher - 1 == value;

        if (mergeLeft && mergeRight) {

            intervals.get(lower)[1] =
                    intervals.get(higher)[1];

            intervals.remove(higher);

        } else if (mergeLeft) {

            intervals.get(lower)[1]++;

        } else if (mergeRight) {

            int end =
                    intervals.get(higher)[1];

            intervals.remove(higher);

            intervals.put(
                    value,
                    new int[]{value, end}
            );

        } else {

            intervals.put(
                    value,
                    new int[]{value, value}
            );
        }
    }

    public int[][] getIntervals() {

        return intervals.values()
                        .toArray(
                                new int[intervals.size()][2]
                        );
    }

    public static void main(String[] args) {

        DataStreamDisjointIntervals ds =
                new DataStreamDisjointIntervals();

        ds.addNum(1);
        ds.addNum(3);
        ds.addNum(7);
        ds.addNum(2);
        ds.addNum(6);

        int[][] result =
                ds.getIntervals();

        for (int[] interval : result) {

            System.out.println(
                    "[" +
                    interval[0] +
                    "," +
                    interval[1] +
                    "]"
            );
        }
    }
    }
