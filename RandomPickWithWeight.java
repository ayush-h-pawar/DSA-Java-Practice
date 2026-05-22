import java.util.*;

public class RandomPickWithWeight {

    int[] prefixSum;

    Random random;

    public RandomPickWithWeight(int[] w) {

        prefixSum = new int[w.length];

        prefixSum[0] = w[0];

        for (int i = 1; i < w.length; i++) {

            prefixSum[i] =
                    prefixSum[i - 1] + w[i];
        }

        random = new Random();
    }

    public int pickIndex() {

        int target =
                random.nextInt(
                        prefixSum[prefixSum.length - 1]
                ) + 1;

        int left = 0;
        int right = prefixSum.length - 1;

        while (left < right) {

            int mid =
                    left + (right - left) / 2;

            if (prefixSum[mid] < target) {

                left = mid + 1;

            } else {

                right = mid;
            }
        }

        return left;
    }
          }
