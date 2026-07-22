import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {

    public List<String> topKFrequent(
            String[] words,
            int k) {

        Map<String, Integer> frequency =
                new HashMap<>();

        for (String word : words) {

            frequency.put(
                    word,
                    frequency.getOrDefault(word, 0) + 1
            );
        }

        PriorityQueue<String> minHeap =
                new PriorityQueue<>(
                        (first, second) -> {

                            int compare =
                                    frequency.get(first)
                                            - frequency.get(second);

                            if (compare == 0) {
                                return second.compareTo(first);
                            }

                            return compare;
                        }
                );

        for (String word : frequency.keySet()) {

            minHeap.offer(word);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<String> answer =
                new ArrayList<>();

        while (!minHeap.isEmpty()) {
            answer.add(0, minHeap.poll());
        }

        return answer;
    }

    public static void main(String[] args) {

        TopKFrequentWords solver =
                new TopKFrequentWords();

        String[] words = {
                "i",
                "love",
                "leetcode",
                "i",
                "love",
                "coding"
        };

        System.out.println(
                solver.topKFrequent(
                        words,
                        2
                )
        );
    }
}
