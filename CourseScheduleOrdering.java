import java.util.*;

public class CourseScheduleOrdering {

    public int[] findOrder(
            int courses,
            int[][] prerequisites) {

        List<List<Integer>> graph =
                new ArrayList<>();

        for (int i = 0; i < courses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree =
                new int[courses];

        for (int[] pair : prerequisites) {

            graph.get(pair[1])
                    .add(pair[0]);

            indegree[pair[0]]++;
        }

        Queue<Integer> queue =
                new ArrayDeque<>();

        for (int i = 0; i < courses; i++) {

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order =
                new int[courses];

        int position = 0;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            order[position++] =
                    current;

            for (int next :
                    graph.get(current)) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        if (position != courses) {
            return new int[0];
        }

        return order;
    }

    public static void main(String[] args) {

        CourseScheduleOrdering solver =
                new CourseScheduleOrdering();

        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        int[] result =
                solver.findOrder(
                        4,
                        prerequisites
                );

        System.out.println(
                Arrays.toString(result)
        );
    }
}
