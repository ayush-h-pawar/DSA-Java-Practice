import java.util.*;

public class RussianDollEnvelopesSolver {

    static int maxEnvelopes(
            int[][] envelopes) {

        Arrays.sort(envelopes,
                (a, b) -> {

            if (a[0] == b[0]) {

                return b[1] - a[1];
            }

            return a[0] - b[0];
        });

        int[] lis =
                new int[envelopes.length];

        int size = 0;

        for (int[] env : envelopes) {

            int height = env[1];

            int pos =
                    Arrays.binarySearch(
                            lis,
                            0,
                            size,
                            height
                    );

            if (pos < 0)
                pos = -(pos + 1);

            lis[pos] = height;

            if (pos == size)
                size++;
        }

        return size;
    }

    public static void main(String[] args) {

        int[][] envelopes = {
                {5,4},
                {6,4},
                {6,7},
                {2,3}
        };

        System.out.println(
                maxEnvelopes(
                        envelopes
                )
        );
    }
}
