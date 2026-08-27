import java.util.*;

public class CourseSchedulePlanner1 {

    public boolean canFinish(
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

            int course = pair[0];
            int prerequisite = pair[1];

            graph.get(prerequisite)
                    .add(course);

            indegree[course]++;
        }

        Queue<Integer> queue =
                new ArrayDeque<>();

        for (int i = 0; i < courses; i++) {

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completed = 0;

        while (!queue.isEmpty()) {

            int current = queue.poll();
            completed++;

            for (int next :
                    graph.get(current)) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return completed == courses;
    }

    public static void main(String[] args) {

        CourseSchedulePlanner solver =
                new CourseSchedulePlanner();

        int[][] prerequisites = {
                {1, 0}
        };

        System.out.println(
                solver.canFinish(
                        2,
                        prerequisites
                )
        );
    }
}
