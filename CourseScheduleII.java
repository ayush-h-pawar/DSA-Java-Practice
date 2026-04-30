import java.util.*;

public class CourseScheduleII {

    static int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        int[] indegree = new int[numCourses];

        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        int[] result = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {

            int curr = queue.poll();
            result[index++] = curr;

            for (int nei : graph.get(curr)) {

                indegree[nei]--;

                if (indegree[nei] == 0)
                    queue.offer(nei);
            }
        }

        return index == numCourses ? result : new int[0];
    }
}
