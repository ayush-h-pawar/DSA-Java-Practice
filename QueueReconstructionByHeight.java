import java.util.*;

public class QueueReconstructionByHeight {

    static int[][] reconstructQueue(
            int[][] people) {

        Arrays.sort(
                people,
                (a, b) -> {

                    if (a[0] == b[0]) {

                        return a[1] - b[1];
                    }

                    return b[0] - a[0];
                }
        );

        List<int[]> queue =
                new ArrayList<>();

        for (int[] person : people) {

            queue.add(
                    person[1],
                    person
            );
        }

        return queue.toArray(
                new int[people.length][2]
        );
    }

    public static void main(String[] args) {

        int[][] people = {
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2}
        };

        int[][] result =
                reconstructQueue(
                        people
                );

        for (int[] p : result) {

            System.out.println(
                    "[" +
                    p[0] +
                    "," +
                    p[1] +
                    "]"
            );
        }
    }
}
