import java.util.ArrayList;
import java.util.List;

public class PartitionLabelsGreedy {

    public List<Integer> partitionLabels(
            String text) {

        int[] lastPosition =
                new int[26];

        for (int index = 0;
             index < text.length();
             index++) {

            lastPosition[
                    text.charAt(index) - 'a'
            ] = index;
        }

        List<Integer> result =
                new ArrayList<>();

        int start = 0;
        int end = 0;

        for (int index = 0;
             index < text.length();
             index++) {

            end = Math.max(
                    end,
                    lastPosition[
                            text.charAt(index) - 'a'
                    ]
            );

            if (index == end) {

                result.add(
                        end - start + 1
                );

                start = index + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        PartitionLabelsGreedy solver =
                new PartitionLabelsGreedy();

        String text =
                "ababcbacadefegdehijhklij";

        System.out.println(
                solver.partitionLabels(text)
        );
    }
}
