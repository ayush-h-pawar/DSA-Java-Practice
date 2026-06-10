import java.util.*;

public class RearrangeStringKDistanceApart {

    static String rearrangeString(
            String s,
            int k) {

        if (k <= 1)
            return s;

        Map<Character, Integer> freq =
                new HashMap<>();

        for (char c :
                s.toCharArray()) {

            freq.put(
                    c,
                    freq.getOrDefault(
                            c,
                            0
                    ) + 1
            );
        }

        PriorityQueue<Character> maxHeap =
                new PriorityQueue<>(
                        (a, b) ->
                                freq.get(b)
                                - freq.get(a)
                );

        maxHeap.addAll(
                freq.keySet()
        );

        Queue<Character> waitQueue =
                new LinkedList<>();

        StringBuilder result =
                new StringBuilder();

        while (!maxHeap.isEmpty()) {

            char current =
                    maxHeap.poll();

            result.append(current);

            freq.put(
                    current,
                    freq.get(current) - 1
            );

            waitQueue.offer(current);

            if (waitQueue.size() >= k) {

                char ready =
                        waitQueue.poll();

                if (freq.get(ready) > 0) {

                    maxHeap.offer(ready);
                }
            }
        }

        return result.length()
                == s.length()
                ? result.toString()
                : "";
    }

    public static void main(String[] args) {

        System.out.println(
                rearrangeString(
                        "aabbcc",
                        3
                )
        );
    }
}
