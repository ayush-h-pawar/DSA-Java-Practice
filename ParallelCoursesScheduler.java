import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ParallelCoursesScheduler {

    public int minimumSemesters(
            int n,
            int[][] relations) {

        List<List<Integer>> graph =
                new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree =
                new int[n + 1];

        for (int[] relation : relations) {

            int prerequisite = relation[0];
            int course = relation[1];

            graph.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue =
                new ArrayDeque<>();

        for (int course = 1;
             course <= n;
             course++) {

            if (indegree[course] == 0) {
                queue.offer(course);
            }
        }

        int semesters = 0;
        int completedCourses = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            semesters++;

            while (size-- > 0) {

                int currentCourse =
                        queue.poll();

                completedCourses++;

                for (int nextCourse :
                        graph.get(currentCourse)) {

                    indegree[nextCourse]--;

                    if (indegree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }
        }

        return completedCourses == n
                ? semesters
                : -1;
    }

    public static void main(String[] args) {

        ParallelCoursesScheduler solver =
                new ParallelCoursesScheduler();

        int[][] relations = {
                {1, 3},
                {2, 3}
        };

        System.out.println(
                solver.minimumSemesters(
                        3,
                        relations
                )
        );

        int[][] relations2 = {
                {1, 2},
                {2, 3},
                {3, 1}
        };

        System.out.println(
                solver.minimumSemesters(
                        3,
                        relations2
                )
        );
    }
}
