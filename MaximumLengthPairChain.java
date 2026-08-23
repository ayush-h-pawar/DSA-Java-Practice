import java.util.Arrays;

public class MaximumLengthPairChain {

    public int findLongestChain(
            int[][] pairs) {

        Arrays.sort(
                pairs,
                (first, second) ->
                        Integer.compare(
                                first[1],
                                second[1]
                        )
        );

        int count = 0;
        int previousEnd =
                Integer.MIN_VALUE;

        for (int[] pair : pairs) {

            if (pair[0] > previousEnd) {

                count++;
                previousEnd = pair[1];
            }
        }

        return count;
    }

    public static void main(String[] args) {

        MaximumLengthPairChain solver =
                new MaximumLengthPairChain();

        int[][] pairs = {
                {1, 2},
                {2, 3},
                {3, 4}
        };

        System.out.println(
                solver.findLongestChain(pairs)
        );
    }
}
