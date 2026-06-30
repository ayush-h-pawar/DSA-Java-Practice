import java.util.*;

public class CourseSchedulePlanner {

    public int[] findOrder(
            int numCourses,
            int[][] prerequisites) {

        List<List<Integer>> graph =
                new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {

            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];

            graph.get(prerequisiteCourse).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            order[index++] = current;

            for (int neighbor : graph.get(current)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }

        return order;
    }

    public static void main(String[] args) {

        CourseSchedulePlanner solver =
                new CourseSchedulePlanner();

        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        int[] order =
                solver.findOrder(
                        4,
                        prerequisites
                );

        System.out.println(
                Arrays.toString(order)
        );
    }
}
