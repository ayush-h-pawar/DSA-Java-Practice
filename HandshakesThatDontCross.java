public class HandshakesThatDontCross {

    static int numberOfWays(int numPeople) {

        int pairs = numPeople / 2;

        long[] dp = new long[pairs + 1];

        dp[0] = 1;

        int MOD = 1_000_000_007;

        for (int i = 1; i <= pairs; i++) {

            for (int j = 0; j < i; j++) {

                dp[i] = (dp[i] +
                        dp[j] * dp[i - 1 - j])
                        % MOD;
            }
        }

        return (int) dp[pairs];
    }

    public static void main(String[] args) {

        System.out.println(
                numberOfWays(6)
        );
    }
}
