import java.util.*;

public class SentenceSimilarityChecker {

    static boolean areSentencesSimilar(
            String[] sentence1,
            String[] sentence2,
            List<List<String>> pairs) {

        if (sentence1.length !=
            sentence2.length) {

            return false;
        }

        Map<String, Set<String>> map =
                new HashMap<>();

        for (List<String> pair : pairs) {

            String a = pair.get(0);
            String b = pair.get(1);

            map.computeIfAbsent(
                    a,
                    k -> new HashSet<>()
            ).add(b);

            map.computeIfAbsent(
                    b,
                    k -> new HashSet<>()
            ).add(a);
        }

        for (int i = 0;
             i < sentence1.length;
             i++) {

            String w1 = sentence1[i];
            String w2 = sentence2[i];

            if (w1.equals(w2))
                continue;

            if (!map.containsKey(w1) ||
                !map.get(w1).contains(w2)) {

                return false;
            }
        }

        return true;
    }
}
