import java.util.*;

public class RaceCarInstructionOptimizer {

    public int racecar(int target) {

        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new State(0, 1));
        visited.add(getKey(0, 1));

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                State current = queue.poll();

                if (current.position == target) {
                    return moves;
                }

                int nextPosition =
                        current.position + current.speed;

                int nextSpeed =
                        current.speed * 2;

                if (Math.abs(nextPosition) <= target * 2) {

                    String accelerateKey =
                            getKey(nextPosition, nextSpeed);

                    if (!visited.contains(accelerateKey)) {

                        visited.add(accelerateKey);

                        queue.offer(
                                new State(
                                        nextPosition,
                                        nextSpeed
                                )
                        );
                    }
                }

                int reverseSpeed =
                        current.speed > 0 ? -1 : 1;

                String reverseKey =
                        getKey(
                                current.position,
                                reverseSpeed
                        );

                if (!visited.contains(reverseKey)) {

                    visited.add(reverseKey);

                    queue.offer(
                            new State(
                                    current.position,
                                    reverseSpeed
                            )
                    );
                }
            }

            moves++;
        }

        return -1;
    }

    private String getKey(int position, int speed) {
        return position + "#" + speed;
    }

    static class State {

        int position;
        int speed;

        State(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }

    public static void main(String[] args) {

        RaceCarInstructionOptimizer solver =
                new RaceCarInstructionOptimizer();

        System.out.println(
                solver.racecar(3)
        );

        System.out.println(
                solver.racecar(6)
        );
    }
}
