import java.util.Arrays;

public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {

        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int[] lis = new int[envelopes.length];
        int size = 0;

        for (int[] envelope : envelopes) {

            int height = envelope[1];

            int left = 0;
            int right = size;

            while (left < right) {

                int mid = left + (right - left) / 2;

                if (lis[mid] < height) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            lis[left] = height;

            if (left == size) {
                size++;
            }
        }

        return size;
    }

    public static void main(String[] args) {

        RussianDollEnvelopes solver =
                new RussianDollEnvelopes();

        int[][] envelopes = {
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        };

        System.out.println(
                solver.maxEnvelopes(envelopes)
        );
    }
}
