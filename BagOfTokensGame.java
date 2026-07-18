import java.util.Arrays;

public class BagOfTokensGame {

    public int bagOfTokensScore(
            int[] tokens,
            int power) {

        Arrays.sort(tokens);

        int left = 0;
        int right = tokens.length - 1;

        int score = 0;
        int maximumScore = 0;

        while (left <= right) {

            if (power >= tokens[left]) {

                power -= tokens[left];
                score++;
                left++;

                maximumScore =
                        Math.max(
                                maximumScore,
                                score
                        );

            } else if (score > 0) {

                power += tokens[right];
                score--;
                right--;

            } else {

                break;
            }
        }

        return maximumScore;
    }

    public static void main(String[] args) {

        BagOfTokensGame solver =
                new BagOfTokensGame();

        int[] tokens = {
                100,
                200,
                300,
                400
        };

        System.out.println(
                solver.bagOfTokensScore(
                        tokens,
                        200
                )
        );
    }
}
