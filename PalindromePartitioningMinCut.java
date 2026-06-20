public class PalindromePartitioningMinCut {

    public int minCut(String s) {

        int n = s.length();

        boolean[][] palindrome =
                new boolean[n][n];

        for (int end = 0; end < n; end++) {

            for (int start = 0;
                 start <= end;
                 start++) {

                if (s.charAt(start)
                        == s.charAt(end)
                        &&
                        (end - start <= 2
                                || palindrome[start + 1][end - 1])) {

                    palindrome[start][end] = true;
                }
            }
        }

        int[] cuts = new int[n];

        for (int i = 0; i < n; i++) {

            if (palindrome[0][i]) {

                cuts[i] = 0;

            } else {

                cuts[i] = i;

                for (int j = 1; j <= i; j++) {

                    if (palindrome[j][i]) {

                        cuts[i] =
                                Math.min(
                                        cuts[i],
                                        cuts[j - 1] + 1
                                );
                    }
                }
            }
        }

        return cuts[n - 1];
    }

    public static void main(String[] args) {

        PalindromePartitioningMinCut solver =
                new PalindromePartitioningMinCut();

        System.out.println(
                solver.minCut("aab")
        );
    }
}
