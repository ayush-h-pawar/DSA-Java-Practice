public class VowelPermutationCounter {

    private static final int MOD = 1_000_000_007;

    // Counts valid strings of length n, where n is positive.
    public int countVowelPermutation(int n) {
        long a = 1;
        long e = 1;
        long i = 1;
        long o = 1;
        long u = 1;

        for (int length = 2; length <= n; length++) {
            // Sum the counts for vowels that can precede each new ending.
            long nextA = (e + i + u) % MOD;
            long nextE = (a + i) % MOD;
            long nextI = (e + o) % MOD;
            long nextO = i;
            long nextU = (i + o) % MOD;

            a = nextA;
            e = nextE;
            i = nextI;
            o = nextO;
            u = nextU;
        }
        return (int) ((a + e + i + o + u) % MOD);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
