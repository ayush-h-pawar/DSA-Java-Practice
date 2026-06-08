import java.util.*;

public class FreedomTrailOptimizer {

    static Map<String, Integer> memo =
            new HashMap<>();

    static int findRotateSteps(
            String ring,
            String key) {

        return dfs(
                ring,
                key,
                0,
                0
        );
    }

    static int dfs(
            String ring,
            String key,
            int ringPos,
            int keyPos) {

        if (keyPos == key.length())
            return 0;

        String state =
                ringPos + "," + keyPos;

        if (memo.containsKey(state))
            return memo.get(state);

        int n = ring.length();

        int result =
                Integer.MAX_VALUE;

        char target =
                key.charAt(keyPos);

        for (int i = 0;
             i < n;
             i++) {

            if (ring.charAt(i)
                == target) {

                int diff =
                        Math.abs(
                                i - ringPos
                        );

                int steps =
                        Math.min(
                                diff,
                                n - diff
                        );

                result =
                        Math.min(
                                result,
                                steps + 1 +
                                dfs(
                                        ring,
                                        key,
                                        i,
                                        keyPos + 1
                                )
                        );
            }
        }

        memo.put(state, result);

        return result;
    }

    public static void main(String[] args) {

        System.out.println(
                findRotateSteps(
                        "godding",
                        "gd"
                )
        );
    }
}
