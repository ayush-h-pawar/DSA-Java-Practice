public class ShortestWordDistanceCalculator {

    static int shortestDistance(
            String[] words,
            String word1,
            String word2) {

        int pos1 = -1;
        int pos2 = -1;

        int minDistance =
                Integer.MAX_VALUE;

        for (int i = 0;
             i < words.length;
             i++) {

            if (words[i]
                .equals(word1)) {

                pos1 = i;
            }

            if (words[i]
                .equals(word2)) {

                pos2 = i;
            }

            if (pos1 != -1 &&
                pos2 != -1) {

                minDistance =
                        Math.min(
                                minDistance,
                                Math.abs(
                                        pos1 -
                                        pos2
                                )
                        );
            }
        }

        return minDistance;
    }

    public static void main(String[] args) {

        String[] words = {
                "practice",
                "makes",
                "perfect",
                "coding",
                "makes"
        };

        System.out.println(
                shortestDistance(
                        words,
                        "coding",
                        "practice"
                )
        );
    }
}
