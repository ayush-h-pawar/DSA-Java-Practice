import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenLockSolver {

    public int openLock(
            String[] deadends,
            String target) {

        Set<String> dead =
                new HashSet<>();

        for (String state : deadends) {
            dead.add(state);
        }

        if (dead.contains("0000")) {
            return -1;
        }

        Queue<String> queue =
                new LinkedList<>();

        Set<String> visited =
                new HashSet<>();

        queue.offer("0000");
        visited.add("0000");

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                String current =
                        queue.poll();

                if (current.equals(target)) {
                    return moves;
                }

                if (dead.contains(current)) {
                    continue;
                }

                for (String next :
                        generateNextStates(current)) {

                    if (!visited.contains(next)
                            && !dead.contains(next)) {

                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private Set<String> generateNextStates(
            String state) {

        Set<String> neighbors =
                new HashSet<>();

        char[] digits =
                state.toCharArray();

        for (int i = 0; i < 4; i++) {

            char original = digits[i];

            digits[i] =
                    original == '9'
                            ? '0'
                            : (char) (original + 1);

            neighbors.add(new String(digits));

            digits[i] =
                    original == '0'
                            ? '9'
                            : (char) (original - 1);

            neighbors.add(new String(digits));

            digits[i] = original;
        }

        return neighbors;
    }

    public static void main(String[] args) {

        OpenLockSolver solver =
                new OpenLockSolver();

        String[] deadends = {
                "0201",
                "0101",
                "0102",
                "1212",
                "2002"
        };

        System.out.println(
                solver.openLock(
                        deadends,
                        "0202"
                )
        );
    }
}
