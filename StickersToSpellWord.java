import java.util.*;

public class StickersToSpellWord {

    static Map<String, Integer> memo =
            new HashMap<>();

    static int minStickers(
            String[] stickers,
            String target) {

        int n = stickers.length;

        int[][] counts =
                new int[n][26];

        for (int i = 0; i < n; i++) {

            for (char c :
                    stickers[i]
                    .toCharArray()) {

                counts[i][c - 'a']++;
            }
        }

        memo.put("", 0);

        return dfs(
                counts,
                target
        );
    }

    static int dfs(
            int[][] stickers,
            String target) {

        if (memo.containsKey(target))
            return memo.get(target);

        int[] targetCount =
                new int[26];

        for (char c :
                target.toCharArray()) {

            targetCount[c - 'a']++;
        }

        int answer =
                Integer.MAX_VALUE;

        for (int[] sticker :
                stickers) {

            if (sticker[
                    target.charAt(0)
                    - 'a'
            ] == 0) {

                continue;
            }

            StringBuilder remain =
                    new StringBuilder();

            for (int i = 0;
                 i < 26;
                 i++) {

                int needed =
                        targetCount[i]
                        - sticker[i];

                for (int j = 0;
                     j < Math.max(
                             0,
                             needed
                     );
                     j++) {

                    remain.append(
                            (char)
                            ('a' + i)
                    );
                }
            }

            String next =
                    remain.toString();

            int temp =
                    dfs(
                            stickers,
                            next
                    );

            if (temp != -1) {

                answer =
                        Math.min(
                                answer,
                                temp + 1
                        );
            }
        }

        memo.put(
                target,
                answer ==
                Integer.MAX_VALUE
                ? -1
                : answer
        );

        return memo.get(target);
    }

    public static void main(String[] args) {

        String[] stickers = {
                "with",
                "example",
                "science"
        };

        System.out.println(
                minStickers(
                        stickers,
                        "thehat"
                )
        );
    }
          }
