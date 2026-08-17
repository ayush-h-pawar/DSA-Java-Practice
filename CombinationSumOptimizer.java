import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumOptimizer {

    public List<List<Integer>> combinationSum(
            int[] candidates,
            int target) {

        Arrays.sort(candidates);

        List<List<Integer>> result =
                new ArrayList<>();

        findCombinations(
                candidates,
                target,
                0,
                new ArrayList<>(),
                result
        );

        return result;
    }

    private void findCombinations(
            int[] candidates,
            int remaining,
            int start,
            List<Integer> current,
            List<List<Integer>> result) {

        if (remaining == 0) {

            result.add(
                    new ArrayList<>(current)
            );

            return;
        }

        for (int index = start;
             index < candidates.length;
             index++) {

            if (candidates[index] > remaining) {
                break;
            }

            current.add(
                    candidates[index]
            );

            findCombinations(
                    candidates,
                    remaining - candidates[index],
                    index,
                    current,
                    result
            );

            current.remove(
                    current.size() - 1
            );
        }
    }

    public static void main(String[] args) {

        CombinationSumOptimizer solver =
                new CombinationSumOptimizer();

        int[] candidates = {
                2, 3, 6, 7
        };

        System.out.println(
                solver.combinationSum(
                        candidates,
                        7
                )
        );
    }
}
