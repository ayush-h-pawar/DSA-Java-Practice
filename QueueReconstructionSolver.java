import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionSolver {

    public int[][] reconstructQueue(
            int[][] people) {

        Arrays.sort(
                people,
                (first, second) -> {

                    if (first[0] == second[0]) {
                        return first[1] - second[1];
                    }

                    return second[0] - first[0];
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

        int[][] answer =
                new int[people.length][2];

        for (int i = 0; i < queue.size(); i++) {

            answer[i] = queue.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        QueueReconstructionSolver solver =
                new QueueReconstructionSolver();

        int[][] people = {
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };

        int[][] result =
                solver.reconstructQueue(people);

        for (int[] person : result) {

            System.out.println(
                    "[" + person[0]
                            + ", "
                            + person[1]
                            + "]"
            );
        }
    }
}
