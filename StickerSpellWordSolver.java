import java.util.HashMap;
import java.util.Map;

public class StickerSpellWordSolver {

    public int minStickers(String[] stickers, String target) {

        int[][] frequency = new int[stickers.length][26];

        for (int i = 0; i < stickers.length; i++) {

            for (char ch : stickers[i].toCharArray()) {
                frequency[i][ch - 'a']++;
            }
        }

        Map<String, Integer> memo = new HashMap<>();
        memo.put("", 0);

        return dfs(memo, frequency, target);
    }

    private int dfs(
            Map<String, Integer> memo,
            int[][] frequency,
            String target) {

        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        int[] targetCount = new int[26];

        for (char ch : target.toCharArray()) {
            targetCount[ch - 'a']++;
        }

        int answer = Integer.MAX_VALUE;

        for (int[] sticker : frequency) {

            if (sticker[target.charAt(0) - 'a'] == 0) {
                continue;
            }

            StringBuilder remaining = new StringBuilder();

            for (int i = 0; i < 26; i++) {

                if (targetCount[i] > 0) {

                    int left =
                            targetCount[i]
                                    - Math.min(
                                            targetCount[i],
                                            sticker[i]);

                    while (left-- > 0) {
                        remaining.append((char) ('a' + i));
                    }
                }
            }

            String next = remaining.toString();

            int result = dfs(memo, frequency, next);

            if (result != -1) {
                answer = Math.min(answer, result + 1);
            }
        }

        memo.put(
                target,
                answer == Integer.MAX_VALUE ? -1 : answer
        );

        return memo.get(target);
    }

    public static void main(String[] args) {

        StickerSpellWordSolver solver =
                new StickerSpellWordSolver();

        String[] stickers = {
                "with",
                "example",
                "science"
        };

        System.out.println(
                solver.minStickers(
                        stickers,
                        "thehat"
                )
        );
    }
}
