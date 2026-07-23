import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeStringBuilder {

    static class CharacterFrequency {

        char character;
        int frequency;

        CharacterFrequency(
                char character,
                int frequency) {

            this.character = character;
            this.frequency = frequency;
        }
    }

    public String reorganizeString(
            String text) {

        Map<Character, Integer> frequencyMap =
                new HashMap<>();

        for (char character : text.toCharArray()) {

            frequencyMap.put(
                    character,
                    frequencyMap.getOrDefault(
                            character,
                            0
                    ) + 1
            );
        }

        PriorityQueue<CharacterFrequency> maxHeap =
                new PriorityQueue<>(
                        (first, second) ->
                                second.frequency
                                        - first.frequency
                );

        for (Map.Entry<Character, Integer> entry
                : frequencyMap.entrySet()) {

            maxHeap.offer(
                    new CharacterFrequency(
                            entry.getKey(),
                            entry.getValue()
                    )
            );
        }

        StringBuilder result =
                new StringBuilder();

        CharacterFrequency previous = null;

        while (!maxHeap.isEmpty()) {

            CharacterFrequency current =
                    maxHeap.poll();

            result.append(current.character);
            current.frequency--;

            if (previous != null
                    && previous.frequency > 0) {

                maxHeap.offer(previous);
            }

            previous = current;
        }

        if (result.length() != text.length()) {
            return "";
        }

        return result.toString();
    }

    public static void main(String[] args) {

        ReorganizeStringBuilder solver =
                new ReorganizeStringBuilder();

        String text = "aab";

        System.out.println(
                solver.reorganizeString(text)
        );
    }
}
