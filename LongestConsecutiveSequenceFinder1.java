import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceFinder1 {

    public int longestConsecutive(
            int[] numbers) {

        Set<Integer> values =
                new HashSet<>();

        for (int number : numbers) {
            values.add(number);
        }

        int longestSequence = 0;

        for (int number : values) {

            if (!values.contains(number - 1)) {

                int currentNumber = number;
                int currentLength = 1;

                while (values.contains(currentNumber + 1)) {

                    currentNumber++;
                    currentLength++;
                }

                longestSequence =
                        Math.max(
                                longestSequence,
                                currentLength
                        );
            }
        }

        return longestSequence;
    }

    public static void main(String[] args) {

        LongestConsecutiveSequenceFinder solver =
                new LongestConsecutiveSequenceFinder();

        int[] numbers = {
                100,
                4,
                200,
                1,
                3,
                2
        };

        System.out.println(
                solver.longestConsecutive(
                        numbers
                )
        );
    }
}
