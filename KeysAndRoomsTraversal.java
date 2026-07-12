import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class KeysAndRoomsTraversal {

    public boolean canVisitAllRooms(
            List<List<Integer>> rooms) {

        int totalRooms = rooms.size();

        boolean[] visited =
                new boolean[totalRooms];

        Queue<Integer> queue =
                new ArrayDeque<>();

        queue.offer(0);
        visited[0] = true;

        int visitedCount = 1;

        while (!queue.isEmpty()) {

            int currentRoom =
                    queue.poll();

            for (int key :
                    rooms.get(currentRoom)) {

                if (!visited[key]) {

                    visited[key] = true;
                    visitedCount++;

                    queue.offer(key);
                }
            }
        }

        return visitedCount == totalRooms;
    }

    public static void main(String[] args) {

        KeysAndRoomsTraversal solver =
                new KeysAndRoomsTraversal();

        List<List<Integer>> rooms =
                List.of(
                        List.of(1),
                        List.of(2),
                        List.of(3),
                        List.of()
                );

        System.out.println(
                solver.canVisitAllRooms(rooms)
        );
    }
}
