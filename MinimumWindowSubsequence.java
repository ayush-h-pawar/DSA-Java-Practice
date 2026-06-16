public class MinimumWindowSubsequence {

    public String minWindow(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        int i = 0;

        while (i < n) {

            int j = 0;
            int k = i;

            while (k < n && j < m) {
                if (s1.charAt(k) == s2.charAt(j)) {
                    j++;
                }
                k++;
            }

            if (j == m) {

                int end = k - 1;
                j = m - 1;
                k = end;

                while (j >= 0) {
                    if (s1.charAt(k) == s2.charAt(j)) {
                        j--;
                    }
                    k--;
                }

                int start = k + 1;

                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    startIndex = start;
                }

                i = start + 1;
            } else {
                break;
            }
        }

        return startIndex == -1
                ? ""
                : s1.substring(startIndex, startIndex + minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubsequence solver = new MinimumWindowSubsequence();

        String s1 = "abcdebdde";
        String s2 = "bde";

        System.out.println(solver.minWindow(s1, s2));
    }
}
