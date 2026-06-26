import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJumpRiverCrossing1 {

    public boolean canCross(int[] stones) {

        Map<Integer, Set<Integer>> jumps =
                new HashMap<>();

        for (int stone : stones) {
            jumps.put(stone, new HashSet<>());
        }

        jumps.get(0).add(0);

        for (int stone : stones) {

            for (int jump : jumps.get(stone)) {

                for (int step = jump - 1;
                     step <= jump + 1;
                     step++) {

                    if (step <= 0) {
                        continue;
                    }

                    int nextStone = stone + step;

                    if (jumps.containsKey(nextStone)) {
                        jumps.get(nextStone).add(step);
                    }
                }
            }
        }

        return !jumps
                .get(stones[stones.length - 1])
                .isEmpty();
    }

    public static void main(String[] args) {

        FrogJumpRiverCrossing solver =
                new FrogJumpRiverCrossing();

        int[] stones = {
                0, 1, 3, 5, 6, 8, 12, 17
        };

        System.out.println(
                solver.canCross(stones)
        );
    }
}
