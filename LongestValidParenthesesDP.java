public class LongestValidParenthesesDP {

    public int longestValidParentheses(String s) {

        int n = s.length();

        int[] dp = new int[n];

        int maxLength = 0;

        for (int i = 1; i < n; i++) {

            if (s.charAt(i) == ')') {

                if (s.charAt(i - 1) == '(') {

                    dp[i] =
                            (i >= 2 ? dp[i - 2] : 0)
                                    + 2;

                } else {

                    int previousIndex =
                            i - dp[i - 1] - 1;

                    if (previousIndex >= 0
                            && s.charAt(previousIndex) == '(') {

                        dp[i] =
                                dp[i - 1] + 2;

                        if (previousIndex > 0) {
                            dp[i] +=
                                    dp[previousIndex - 1];
                        }
                    }
                }

                maxLength =
                        Math.max(maxLength, dp[i]);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        LongestValidParenthesesDP solver =
                new LongestValidParenthesesDP();

        System.out.println(
                solver.longestValidParentheses(")()())")
        );
    }
}
