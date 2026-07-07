import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PossibleBipartitionChecker {

    public boolean possibleBipartition(
            int n,
            int[][] dislikes) {

        List<List<Integer>> graph =
                new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] dislike : dislikes) {

            int first = dislike[0];
            int second = dislike[1];

            graph.get(first).add(second);
            graph.get(second).add(first);
        }

        int[] color = new int[n + 1];

        for (int person = 1;
             person <= n;
             person++) {

            if (color[person] != 0) {
                continue;
            }

            Queue<Integer> queue =
                    new LinkedList<>();

            queue.offer(person);
            color[person] = 1;

            while (!queue.isEmpty()) {

                int current = queue.poll();

                for (int neighbor :
                        graph.get(current)) {

                    if (color[neighbor] == 0) {

                        color[neighbor] =
                                -color[current];

                        queue.offer(neighbor);

                    } else if (color[neighbor]
                            == color[current]) {

                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        PossibleBipartitionChecker solver =
                new PossibleBipartitionChecker();

        int[][] dislikes1 = {
                {1, 2},
                {1, 3},
                {2, 4}
        };

        System.out.println(
                solver.possibleBipartition(
                        4,
                        dislikes1
                )
        );

        int[][] dislikes2 = {
                {1, 2},
                {1, 3},
                {2, 3}
        };

        System.out.println(
                solver.possibleBipartition(
                        3,
                        dislikes2
                )
        );
    }
}
