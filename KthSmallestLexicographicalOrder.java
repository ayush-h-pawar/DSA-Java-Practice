public class KthSmallestLexicographicalOrder {

    public int findKthNumber(int n, int k) {

        long current = 1;
        k--;

        while (k > 0) {

            long steps =
                    countSteps(n, current, current + 1);

            if (steps <= k) {

                current++;
                k -= steps;

            } else {

                current *= 10;
                k--;
            }
        }

        return (int) current;
    }

    private long countSteps(
            long n,
            long first,
            long last) {

        long steps = 0;

        while (first <= n) {

            steps +=
                    Math.min(n + 1, last) - first;

            first *= 10;
            last *= 10;
        }

        return steps;
    }

    public static void main(String[] args) {

        KthSmallestLexicographicalOrder solver =
                new KthSmallestLexicographicalOrder();

        System.out.println(
                solver.findKthNumber(13, 2)
        );
    }
}
