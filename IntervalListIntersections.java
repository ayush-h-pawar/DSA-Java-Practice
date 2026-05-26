import java.util.*;

public class IntervalListIntersections {

    static int[][] intervalIntersection(
            int[][] firstList,
            int[][] secondList) {

        List<int[]> result =
                new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < firstList.length &&
               j < secondList.length) {

            int start =
                    Math.max(
                            firstList[i][0],
                            secondList[j][0]
                    );

            int end =
                    Math.min(
                            firstList[i][1],
                            secondList[j][1]
                    );

            if (start <= end) {

                result.add(
                        new int[]{start, end}
                );
            }

            if (firstList[i][1] <
                secondList[j][1]) {

                i++;

            } else {

                j++;
            }
        }

        return result.toArray(
                new int[result.size()][2]
        );
    }

    public static void main(String[] args) {

        int[][] first = {
                {0,2},
                {5,10},
                {13,23},
                {24,25}
        };

        int[][] second = {
                {1,5},
                {8,12},
                {15,24},
                {25,26}
        };

        int[][] ans =
                intervalIntersection(
                        first,
                        second
                );

        for (int[] a : ans) {

            System.out.println(
                    a[0] + " " + a[1]
            );
        }
    }
}
